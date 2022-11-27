package org.java_websocket.server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketAdapter;
import org.java_websocket.WebSocketFactory;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.Handshakedata;

public abstract class WebSocketServer
  extends WebSocketAdapter
  implements Runnable
{
  public static int DECODERS = Runtime.getRuntime().availableProcessors();
  private final InetSocketAddress address;
  private BlockingQueue<ByteBuffer> buffers;
  private final Collection<WebSocket> connections;
  private List<WebSocketWorker> decoders;
  private List<Draft> drafts;
  private List<WebSocketImpl> iqueue;
  private volatile AtomicBoolean isclosed;
  private int queueinvokes;
  private AtomicInteger queuesize;
  private Selector selector;
  private Thread selectorthread;
  private ServerSocketChannel server;
  private WebSocketServerFactory wsf;
  
  public WebSocketServer()
    throws UnknownHostException
  {
    this(new InetSocketAddress(80), DECODERS, null);
  }
  
  public WebSocketServer(InetSocketAddress paramInetSocketAddress)
  {
    this(paramInetSocketAddress, DECODERS, null);
  }
  
  public WebSocketServer(InetSocketAddress paramInetSocketAddress, int paramInt)
  {
    this(paramInetSocketAddress, paramInt, null);
  }
  
  public WebSocketServer(InetSocketAddress paramInetSocketAddress, int paramInt, List<Draft> paramList)
  {
    this(paramInetSocketAddress, paramInt, paramList, new HashSet());
  }
  
  public WebSocketServer(InetSocketAddress paramInetSocketAddress, int paramInt, List<Draft> paramList, Collection<WebSocket> paramCollection)
  {
    int i = 0;
    this.isclosed = new AtomicBoolean(false);
    this.queueinvokes = 0;
    this.queuesize = new AtomicInteger(0);
    this.wsf = new DefaultWebSocketServerFactory();
    if ((paramInetSocketAddress != null) && (paramInt >= 1) && (paramCollection != null))
    {
      if (paramList == null) {
        this.drafts = Collections.emptyList();
      } else {
        this.drafts = paramList;
      }
      this.address = paramInetSocketAddress;
      this.connections = paramCollection;
      this.iqueue = new LinkedList();
      this.decoders = new ArrayList(paramInt);
      this.buffers = new LinkedBlockingQueue();
      while (i < paramInt)
      {
        paramInetSocketAddress = new WebSocketWorker();
        this.decoders.add(paramInetSocketAddress);
        paramInetSocketAddress.start();
        i += 1;
      }
      return;
    }
    throw new IllegalArgumentException("address and connectionscontainer must not be null and you need at least 1 decoder");
  }
  
  public WebSocketServer(InetSocketAddress paramInetSocketAddress, List<Draft> paramList)
  {
    this(paramInetSocketAddress, DECODERS, paramList);
  }
  
  private Socket getSocket(WebSocket paramWebSocket)
  {
    return ((SocketChannel)((WebSocketImpl)paramWebSocket).key.channel()).socket();
  }
  
  private void handleFatal(WebSocket paramWebSocket, Exception paramException)
  {
    onError(paramWebSocket, paramException);
    try
    {
      stop();
      return;
    }
    catch (InterruptedException paramWebSocket)
    {
      Thread.currentThread().interrupt();
      onError(null, paramWebSocket);
      return;
    }
    catch (IOException paramWebSocket)
    {
      onError(null, paramWebSocket);
    }
  }
  
  private void handleIOException(SelectionKey paramSelectionKey, WebSocket paramWebSocket, IOException paramIOException)
  {
    onWebsocketError(paramWebSocket, paramIOException);
    if (paramWebSocket != null)
    {
      paramWebSocket.closeConnection(1006, paramIOException.getMessage());
      return;
    }
    if (paramSelectionKey != null)
    {
      paramSelectionKey = paramSelectionKey.channel();
      if ((paramSelectionKey == null) || (!paramSelectionKey.isOpen())) {}
    }
    try
    {
      paramSelectionKey.close();
    }
    catch (IOException paramSelectionKey)
    {
      for (;;) {}
    }
    if (WebSocketImpl.DEBUG)
    {
      paramSelectionKey = System.out;
      paramWebSocket = new StringBuilder();
      paramWebSocket.append("Connection closed because of");
      paramWebSocket.append(paramIOException);
      paramSelectionKey.println(paramWebSocket.toString());
    }
  }
  
  private void pushBuffer(ByteBuffer paramByteBuffer)
    throws InterruptedException
  {
    if (this.buffers.size() > this.queuesize.intValue()) {
      return;
    }
    this.buffers.put(paramByteBuffer);
  }
  
  private void queue(WebSocketImpl paramWebSocketImpl)
    throws InterruptedException
  {
    if (paramWebSocketImpl.workerThread == null)
    {
      List localList = this.decoders;
      paramWebSocketImpl.workerThread = ((WebSocketWorker)localList.get(this.queueinvokes % localList.size()));
      this.queueinvokes += 1;
    }
    paramWebSocketImpl.workerThread.put(paramWebSocketImpl);
  }
  
  private ByteBuffer takeBuffer()
    throws InterruptedException
  {
    return (ByteBuffer)this.buffers.take();
  }
  
  protected boolean addConnection(WebSocket paramWebSocket)
  {
    synchronized (this.connections)
    {
      boolean bool = this.connections.add(paramWebSocket);
      return bool;
    }
  }
  
  protected void allocateBuffers(WebSocket paramWebSocket)
    throws InterruptedException
  {
    if (this.queuesize.get() >= this.decoders.size() * 2 + 1) {
      return;
    }
    this.queuesize.incrementAndGet();
    this.buffers.put(createBuffer());
  }
  
  public Collection<WebSocket> connections()
  {
    return this.connections;
  }
  
  public ByteBuffer createBuffer()
  {
    return ByteBuffer.allocate(WebSocketImpl.RCVBUF);
  }
  
  public InetSocketAddress getAddress()
  {
    return this.address;
  }
  
  public List<Draft> getDraft()
  {
    return Collections.unmodifiableList(this.drafts);
  }
  
  protected String getFlashSecurityPolicy()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"");
    localStringBuilder.append(getPort());
    localStringBuilder.append("\" /></cross-domain-policy>");
    return localStringBuilder.toString();
  }
  
  public InetSocketAddress getLocalSocketAddress(WebSocket paramWebSocket)
  {
    return (InetSocketAddress)getSocket(paramWebSocket).getLocalSocketAddress();
  }
  
  public int getPort()
  {
    int j = getAddress().getPort();
    int i = j;
    if (j == 0)
    {
      ServerSocketChannel localServerSocketChannel = this.server;
      i = j;
      if (localServerSocketChannel != null) {
        i = localServerSocketChannel.socket().getLocalPort();
      }
    }
    return i;
  }
  
  public InetSocketAddress getRemoteSocketAddress(WebSocket paramWebSocket)
  {
    return (InetSocketAddress)getSocket(paramWebSocket).getRemoteSocketAddress();
  }
  
  public final WebSocketFactory getWebSocketFactory()
  {
    return this.wsf;
  }
  
  public abstract void onClose(WebSocket paramWebSocket, int paramInt, String paramString, boolean paramBoolean);
  
  public void onCloseInitiated(WebSocket paramWebSocket, int paramInt, String paramString) {}
  
  public void onClosing(WebSocket paramWebSocket, int paramInt, String paramString, boolean paramBoolean) {}
  
  protected boolean onConnect(SelectionKey paramSelectionKey)
  {
    return true;
  }
  
  public abstract void onError(WebSocket paramWebSocket, Exception paramException);
  
  public abstract void onMessage(WebSocket paramWebSocket, String paramString);
  
  public void onMessage(WebSocket paramWebSocket, ByteBuffer paramByteBuffer) {}
  
  public abstract void onOpen(WebSocket paramWebSocket, ClientHandshake paramClientHandshake);
  
  public final void onWebsocketClose(WebSocket paramWebSocket, int paramInt, String paramString, boolean paramBoolean)
  {
    this.selector.wakeup();
    label31:
    try
    {
      if (removeConnection(paramWebSocket)) {
        onClose(paramWebSocket, paramInt, paramString, paramBoolean);
      }
    }
    finally {}
    try
    {
      releaseBuffers(paramWebSocket);
      return;
    }
    catch (InterruptedException paramWebSocket)
    {
      break label31;
    }
    Thread.currentThread().interrupt();
    return;
    try
    {
      releaseBuffers(paramWebSocket);
    }
    catch (InterruptedException paramWebSocket)
    {
      for (;;) {}
    }
    Thread.currentThread().interrupt();
    throw paramString;
  }
  
  public void onWebsocketCloseInitiated(WebSocket paramWebSocket, int paramInt, String paramString)
  {
    onCloseInitiated(paramWebSocket, paramInt, paramString);
  }
  
  public void onWebsocketClosing(WebSocket paramWebSocket, int paramInt, String paramString, boolean paramBoolean)
  {
    onClosing(paramWebSocket, paramInt, paramString, paramBoolean);
  }
  
  public final void onWebsocketError(WebSocket paramWebSocket, Exception paramException)
  {
    onError(paramWebSocket, paramException);
  }
  
  public final void onWebsocketMessage(WebSocket paramWebSocket, String paramString)
  {
    onMessage(paramWebSocket, paramString);
  }
  
  public final void onWebsocketMessage(WebSocket paramWebSocket, ByteBuffer paramByteBuffer)
  {
    onMessage(paramWebSocket, paramByteBuffer);
  }
  
  public final void onWebsocketOpen(WebSocket paramWebSocket, Handshakedata paramHandshakedata)
  {
    if (addConnection(paramWebSocket)) {
      onOpen(paramWebSocket, (ClientHandshake)paramHandshakedata);
    }
  }
  
  public final void onWriteDemand(WebSocket paramWebSocket)
  {
    paramWebSocket = (WebSocketImpl)paramWebSocket;
    try
    {
      paramWebSocket.key.interestOps(5);
    }
    catch (CancelledKeyException localCancelledKeyException)
    {
      for (;;) {}
    }
    paramWebSocket.outQueue.clear();
    this.selector.wakeup();
  }
  
  protected void releaseBuffers(WebSocket paramWebSocket)
    throws InterruptedException
  {}
  
  protected boolean removeConnection(WebSocket paramWebSocket)
  {
    synchronized (this.connections)
    {
      boolean bool = this.connections.remove(paramWebSocket);
      return bool;
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 430	org/java_websocket/server/WebSocketServer:selectorthread	Ljava/lang/Thread;
    //   6: ifnonnull +760 -> 766
    //   9: aload_0
    //   10: invokestatic 199	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   13: putfield 430	org/java_websocket/server/WebSocketServer:selectorthread	Ljava/lang/Thread;
    //   16: aload_0
    //   17: getfield 90	org/java_websocket/server/WebSocketServer:isclosed	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   20: invokevirtual 432	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   23: ifeq +6 -> 29
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_0
    //   32: getfield 430	org/java_websocket/server/WebSocketServer:selectorthread	Ljava/lang/Thread;
    //   35: astore_2
    //   36: new 238	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   43: astore_3
    //   44: aload_3
    //   45: ldc_w 434
    //   48: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload_3
    //   53: aload_0
    //   54: getfield 430	org/java_websocket/server/WebSocketServer:selectorthread	Ljava/lang/Thread;
    //   57: invokevirtual 438	java/lang/Thread:getId	()J
    //   60: invokevirtual 441	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_2
    //   65: aload_3
    //   66: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokevirtual 444	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   72: invokestatic 448	java/nio/channels/ServerSocketChannel:open	()Ljava/nio/channels/ServerSocketChannel;
    //   75: astore_2
    //   76: aload_0
    //   77: aload_2
    //   78: putfield 346	org/java_websocket/server/WebSocketServer:server	Ljava/nio/channels/ServerSocketChannel;
    //   81: aload_2
    //   82: iconst_0
    //   83: invokevirtual 452	java/nio/channels/ServerSocketChannel:configureBlocking	(Z)Ljava/nio/channels/SelectableChannel;
    //   86: pop
    //   87: aload_0
    //   88: getfield 346	org/java_websocket/server/WebSocketServer:server	Ljava/nio/channels/ServerSocketChannel;
    //   91: invokevirtual 351	java/nio/channels/ServerSocketChannel:socket	()Ljava/net/ServerSocket;
    //   94: astore_2
    //   95: aload_2
    //   96: getstatic 309	org/java_websocket/WebSocketImpl:RCVBUF	I
    //   99: invokevirtual 455	java/net/ServerSocket:setReceiveBufferSize	(I)V
    //   102: aload_2
    //   103: aload_0
    //   104: getfield 112	org/java_websocket/server/WebSocketServer:address	Ljava/net/InetSocketAddress;
    //   107: invokevirtual 459	java/net/ServerSocket:bind	(Ljava/net/SocketAddress;)V
    //   110: invokestatic 461	java/nio/channels/Selector:open	()Ljava/nio/channels/Selector;
    //   113: astore_2
    //   114: aload_0
    //   115: aload_2
    //   116: putfield 376	org/java_websocket/server/WebSocketServer:selector	Ljava/nio/channels/Selector;
    //   119: aload_0
    //   120: getfield 346	org/java_websocket/server/WebSocketServer:server	Ljava/nio/channels/ServerSocketChannel;
    //   123: aload_2
    //   124: aload_0
    //   125: getfield 346	org/java_websocket/server/WebSocketServer:server	Ljava/nio/channels/ServerSocketChannel;
    //   128: invokevirtual 464	java/nio/channels/ServerSocketChannel:validOps	()I
    //   131: invokevirtual 468	java/nio/channels/ServerSocketChannel:register	(Ljava/nio/channels/Selector;I)Ljava/nio/channels/SelectionKey;
    //   134: pop
    //   135: aload_0
    //   136: getfield 430	org/java_websocket/server/WebSocketServer:selectorthread	Ljava/lang/Thread;
    //   139: invokevirtual 471	java/lang/Thread:isInterrupted	()Z
    //   142: istore_1
    //   143: iload_1
    //   144: ifne +613 -> 757
    //   147: aload_0
    //   148: getfield 376	org/java_websocket/server/WebSocketServer:selector	Ljava/nio/channels/Selector;
    //   151: invokevirtual 474	java/nio/channels/Selector:select	()I
    //   154: pop
    //   155: aload_0
    //   156: getfield 376	org/java_websocket/server/WebSocketServer:selector	Ljava/nio/channels/Selector;
    //   159: invokevirtual 478	java/nio/channels/Selector:selectedKeys	()Ljava/util/Set;
    //   162: invokeinterface 484 1 0
    //   167: astore 6
    //   169: aconst_null
    //   170: astore_3
    //   171: aload_3
    //   172: astore_2
    //   173: aload_2
    //   174: astore 5
    //   176: aload_2
    //   177: astore 4
    //   179: aload 6
    //   181: invokeinterface 489 1 0
    //   186: ifeq +399 -> 585
    //   189: aload_2
    //   190: astore 4
    //   192: aload 6
    //   194: invokeinterface 492 1 0
    //   199: checkcast 175	java/nio/channels/SelectionKey
    //   202: astore 5
    //   204: aload_2
    //   205: astore 4
    //   207: aload 5
    //   209: invokevirtual 495	java/nio/channels/SelectionKey:isValid	()Z
    //   212: ifne +6 -> 218
    //   215: goto +602 -> 817
    //   218: aload_2
    //   219: astore 4
    //   221: aload 5
    //   223: invokevirtual 498	java/nio/channels/SelectionKey:isAcceptable	()Z
    //   226: ifeq +133 -> 359
    //   229: aload_2
    //   230: astore 4
    //   232: aload_0
    //   233: aload 5
    //   235: invokevirtual 500	org/java_websocket/server/WebSocketServer:onConnect	(Ljava/nio/channels/SelectionKey;)Z
    //   238: ifne +14 -> 252
    //   241: aload_2
    //   242: astore 4
    //   244: aload 5
    //   246: invokevirtual 503	java/nio/channels/SelectionKey:cancel	()V
    //   249: goto +568 -> 817
    //   252: aload_2
    //   253: astore 4
    //   255: aload_0
    //   256: getfield 346	org/java_websocket/server/WebSocketServer:server	Ljava/nio/channels/ServerSocketChannel;
    //   259: invokevirtual 507	java/nio/channels/ServerSocketChannel:accept	()Ljava/nio/channels/SocketChannel;
    //   262: astore_3
    //   263: aload_2
    //   264: astore 4
    //   266: aload_3
    //   267: iconst_0
    //   268: invokevirtual 508	java/nio/channels/SocketChannel:configureBlocking	(Z)Ljava/nio/channels/SelectableChannel;
    //   271: pop
    //   272: aload_2
    //   273: astore 4
    //   275: aload_0
    //   276: getfield 102	org/java_websocket/server/WebSocketServer:wsf	Lorg/java_websocket/server/WebSocketServer$WebSocketServerFactory;
    //   279: aload_0
    //   280: aload_0
    //   281: getfield 110	org/java_websocket/server/WebSocketServer:drafts	Ljava/util/List;
    //   284: aload_3
    //   285: invokevirtual 185	java/nio/channels/SocketChannel:socket	()Ljava/net/Socket;
    //   288: invokeinterface 512 4 0
    //   293: astore 7
    //   295: aload_2
    //   296: astore 4
    //   298: aload 7
    //   300: aload_3
    //   301: aload_0
    //   302: getfield 376	org/java_websocket/server/WebSocketServer:selector	Ljava/nio/channels/Selector;
    //   305: iconst_1
    //   306: aload 7
    //   308: invokevirtual 515	java/nio/channels/SocketChannel:register	(Ljava/nio/channels/Selector;ILjava/lang/Object;)Ljava/nio/channels/SelectionKey;
    //   311: putfield 173	org/java_websocket/WebSocketImpl:key	Ljava/nio/channels/SelectionKey;
    //   314: aload_2
    //   315: astore 4
    //   317: aload 7
    //   319: aload_0
    //   320: getfield 102	org/java_websocket/server/WebSocketServer:wsf	Lorg/java_websocket/server/WebSocketServer$WebSocketServerFactory;
    //   323: aload_3
    //   324: aload 7
    //   326: getfield 173	org/java_websocket/WebSocketImpl:key	Ljava/nio/channels/SelectionKey;
    //   329: invokeinterface 519 3 0
    //   334: putfield 522	org/java_websocket/WebSocketImpl:channel	Ljava/nio/channels/ByteChannel;
    //   337: aload_2
    //   338: astore 4
    //   340: aload 6
    //   342: invokeinterface 524 1 0
    //   347: aload_2
    //   348: astore 4
    //   350: aload_0
    //   351: aload 7
    //   353: invokevirtual 526	org/java_websocket/server/WebSocketServer:allocateBuffers	(Lorg/java_websocket/WebSocket;)V
    //   356: goto +461 -> 817
    //   359: aload_2
    //   360: astore_3
    //   361: aload_2
    //   362: astore 4
    //   364: aload 5
    //   366: invokevirtual 529	java/nio/channels/SelectionKey:isReadable	()Z
    //   369: ifeq +147 -> 516
    //   372: aload_2
    //   373: astore 4
    //   375: aload 5
    //   377: invokevirtual 532	java/nio/channels/SelectionKey:attachment	()Ljava/lang/Object;
    //   380: checkcast 169	org/java_websocket/WebSocketImpl
    //   383: astore_3
    //   384: aload_3
    //   385: astore_2
    //   386: aload_0
    //   387: invokespecial 534	org/java_websocket/server/WebSocketServer:takeBuffer	()Ljava/nio/ByteBuffer;
    //   390: astore 4
    //   392: aload 4
    //   394: aload_3
    //   395: aload_3
    //   396: getfield 522	org/java_websocket/WebSocketImpl:channel	Ljava/nio/channels/ByteChannel;
    //   399: invokestatic 540	org/java_websocket/SocketChannelIOHelper:read	(Ljava/nio/ByteBuffer;Lorg/java_websocket/WebSocketImpl;Ljava/nio/channels/ByteChannel;)Z
    //   402: ifeq +65 -> 467
    //   405: aload_3
    //   406: getfield 543	org/java_websocket/WebSocketImpl:inQueue	Ljava/util/concurrent/BlockingQueue;
    //   409: aload 4
    //   411: invokeinterface 268 2 0
    //   416: aload_0
    //   417: aload_3
    //   418: invokespecial 545	org/java_websocket/server/WebSocketServer:queue	(Lorg/java_websocket/WebSocketImpl;)V
    //   421: aload 6
    //   423: invokeinterface 524 1 0
    //   428: aload_3
    //   429: getfield 522	org/java_websocket/WebSocketImpl:channel	Ljava/nio/channels/ByteChannel;
    //   432: instanceof 547
    //   435: ifeq +38 -> 473
    //   438: aload_3
    //   439: getfield 522	org/java_websocket/WebSocketImpl:channel	Ljava/nio/channels/ByteChannel;
    //   442: checkcast 547	org/java_websocket/WrappedByteChannel
    //   445: invokeinterface 550 1 0
    //   450: ifeq +23 -> 473
    //   453: aload_0
    //   454: getfield 119	org/java_websocket/server/WebSocketServer:iqueue	Ljava/util/List;
    //   457: aload_3
    //   458: invokeinterface 138 2 0
    //   463: pop
    //   464: goto +9 -> 473
    //   467: aload_0
    //   468: aload 4
    //   470: invokespecial 159	org/java_websocket/server/WebSocketServer:pushBuffer	(Ljava/nio/ByteBuffer;)V
    //   473: goto +43 -> 516
    //   476: astore 6
    //   478: aload_3
    //   479: astore_2
    //   480: aload_0
    //   481: aload 4
    //   483: invokespecial 159	org/java_websocket/server/WebSocketServer:pushBuffer	(Ljava/nio/ByteBuffer;)V
    //   486: aload_3
    //   487: astore_2
    //   488: aload 6
    //   490: athrow
    //   491: astore 6
    //   493: aload_3
    //   494: astore_2
    //   495: aload_0
    //   496: aload 4
    //   498: invokespecial 159	org/java_websocket/server/WebSocketServer:pushBuffer	(Ljava/nio/ByteBuffer;)V
    //   501: aload_3
    //   502: astore_2
    //   503: aload 6
    //   505: athrow
    //   506: astore 4
    //   508: aload_2
    //   509: astore_3
    //   510: aload 4
    //   512: astore_2
    //   513: goto +69 -> 582
    //   516: aload_3
    //   517: astore 4
    //   519: aload_3
    //   520: astore_2
    //   521: aload 5
    //   523: invokevirtual 553	java/nio/channels/SelectionKey:isWritable	()Z
    //   526: ifeq +291 -> 817
    //   529: aload_3
    //   530: astore 4
    //   532: aload 5
    //   534: invokevirtual 532	java/nio/channels/SelectionKey:attachment	()Ljava/lang/Object;
    //   537: checkcast 169	org/java_websocket/WebSocketImpl
    //   540: astore_3
    //   541: aload_3
    //   542: astore_2
    //   543: aload_3
    //   544: aload_3
    //   545: getfield 522	org/java_websocket/WebSocketImpl:channel	Ljava/nio/channels/ByteChannel;
    //   548: invokestatic 557	org/java_websocket/SocketChannelIOHelper:batch	(Lorg/java_websocket/WebSocketImpl;Ljava/nio/channels/ByteChannel;)Z
    //   551: ifeq +22 -> 573
    //   554: aload_3
    //   555: astore_2
    //   556: aload 5
    //   558: invokevirtual 495	java/nio/channels/SelectionKey:isValid	()Z
    //   561: ifeq +12 -> 573
    //   564: aload_3
    //   565: astore_2
    //   566: aload 5
    //   568: iconst_1
    //   569: invokevirtual 416	java/nio/channels/SelectionKey:interestOps	(I)Ljava/nio/channels/SelectionKey;
    //   572: pop
    //   573: aload_3
    //   574: astore_2
    //   575: goto +242 -> 817
    //   578: astore_2
    //   579: aload 4
    //   581: astore_3
    //   582: goto +147 -> 729
    //   585: aload 5
    //   587: astore 4
    //   589: aload_0
    //   590: getfield 119	org/java_websocket/server/WebSocketServer:iqueue	Ljava/util/List;
    //   593: invokeinterface 560 1 0
    //   598: ifne -463 -> 135
    //   601: aload 5
    //   603: astore 4
    //   605: aload_0
    //   606: getfield 119	org/java_websocket/server/WebSocketServer:iqueue	Ljava/util/List;
    //   609: iconst_0
    //   610: invokeinterface 562 2 0
    //   615: checkcast 169	org/java_websocket/WebSocketImpl
    //   618: astore_2
    //   619: aload_2
    //   620: getfield 522	org/java_websocket/WebSocketImpl:channel	Ljava/nio/channels/ByteChannel;
    //   623: checkcast 547	org/java_websocket/WrappedByteChannel
    //   626: astore 5
    //   628: aload_0
    //   629: invokespecial 534	org/java_websocket/server/WebSocketServer:takeBuffer	()Ljava/nio/ByteBuffer;
    //   632: astore 4
    //   634: aload 4
    //   636: aload_2
    //   637: aload 5
    //   639: invokestatic 566	org/java_websocket/SocketChannelIOHelper:readMore	(Ljava/nio/ByteBuffer;Lorg/java_websocket/WebSocketImpl;Lorg/java_websocket/WrappedByteChannel;)Z
    //   642: ifeq +14 -> 656
    //   645: aload_0
    //   646: getfield 119	org/java_websocket/server/WebSocketServer:iqueue	Ljava/util/List;
    //   649: aload_2
    //   650: invokeinterface 138 2 0
    //   655: pop
    //   656: aload_2
    //   657: getfield 543	org/java_websocket/WebSocketImpl:inQueue	Ljava/util/concurrent/BlockingQueue;
    //   660: aload 4
    //   662: invokeinterface 268 2 0
    //   667: aload_0
    //   668: aload_2
    //   669: invokespecial 545	org/java_websocket/server/WebSocketServer:queue	(Lorg/java_websocket/WebSocketImpl;)V
    //   672: aload_0
    //   673: aload 4
    //   675: invokespecial 159	org/java_websocket/server/WebSocketServer:pushBuffer	(Ljava/nio/ByteBuffer;)V
    //   678: aload_2
    //   679: astore 5
    //   681: goto -96 -> 585
    //   684: astore 5
    //   686: aload_0
    //   687: aload 4
    //   689: invokespecial 159	org/java_websocket/server/WebSocketServer:pushBuffer	(Ljava/nio/ByteBuffer;)V
    //   692: aload 5
    //   694: athrow
    //   695: astore 5
    //   697: aload_2
    //   698: astore 4
    //   700: aload 5
    //   702: astore_2
    //   703: aload_3
    //   704: astore 5
    //   706: aload 4
    //   708: astore_3
    //   709: goto +20 -> 729
    //   712: astore_2
    //   713: aload_3
    //   714: astore 5
    //   716: aload 4
    //   718: astore_3
    //   719: goto +10 -> 729
    //   722: astore_2
    //   723: aconst_null
    //   724: astore 5
    //   726: aload 5
    //   728: astore_3
    //   729: aload 5
    //   731: ifnull +8 -> 739
    //   734: aload 5
    //   736: invokevirtual 503	java/nio/channels/SelectionKey:cancel	()V
    //   739: aload_0
    //   740: aload 5
    //   742: aload_3
    //   743: aload_2
    //   744: invokespecial 568	org/java_websocket/server/WebSocketServer:handleIOException	(Ljava/nio/channels/SelectionKey;Lorg/java_websocket/WebSocket;Ljava/io/IOException;)V
    //   747: goto -612 -> 135
    //   750: astore_2
    //   751: aload_0
    //   752: aconst_null
    //   753: aload_2
    //   754: invokespecial 165	org/java_websocket/server/WebSocketServer:handleFatal	(Lorg/java_websocket/WebSocket;Ljava/lang/Exception;)V
    //   757: return
    //   758: astore_2
    //   759: aload_0
    //   760: aconst_null
    //   761: aload_2
    //   762: invokespecial 165	org/java_websocket/server/WebSocketServer:handleFatal	(Lorg/java_websocket/WebSocket;Ljava/lang/Exception;)V
    //   765: return
    //   766: new 238	java/lang/StringBuilder
    //   769: dup
    //   770: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   773: astore_2
    //   774: aload_2
    //   775: aload_0
    //   776: invokevirtual 574	java/lang/Object:getClass	()Ljava/lang/Class;
    //   779: invokevirtual 579	java/lang/Class:getName	()Ljava/lang/String;
    //   782: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: pop
    //   786: aload_2
    //   787: ldc_w 581
    //   790: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: pop
    //   794: new 583	java/lang/IllegalStateException
    //   797: dup
    //   798: aload_2
    //   799: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   802: invokespecial 584	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   805: athrow
    //   806: astore_2
    //   807: aload_0
    //   808: monitorexit
    //   809: aload_2
    //   810: athrow
    //   811: astore_2
    //   812: goto -677 -> 135
    //   815: astore_2
    //   816: return
    //   817: aload 5
    //   819: astore_3
    //   820: goto -647 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	823	0	this	WebSocketServer
    //   142	2	1	bool	boolean
    //   35	540	2	localObject1	Object
    //   578	1	2	localIOException1	IOException
    //   618	85	2	localObject2	Object
    //   712	1	2	localIOException2	IOException
    //   722	22	2	localIOException3	IOException
    //   750	4	2	localRuntimeException1	RuntimeException
    //   758	4	2	localIOException4	IOException
    //   773	26	2	localStringBuilder	StringBuilder
    //   806	4	2	localObject3	Object
    //   811	1	2	localCancelledKeyException	CancelledKeyException
    //   815	1	2	localInterruptedException	InterruptedException
    //   43	777	3	localObject4	Object
    //   177	320	4	localObject5	Object
    //   506	5	4	localIOException5	IOException
    //   517	200	4	localObject6	Object
    //   174	506	5	localObject7	Object
    //   684	9	5	localObject8	Object
    //   695	6	5	localIOException6	IOException
    //   704	114	5	localObject9	Object
    //   167	255	6	localIterator	Iterator
    //   476	13	6	localRuntimeException2	RuntimeException
    //   491	13	6	localIOException7	IOException
    //   293	59	7	localWebSocketImpl	WebSocketImpl
    // Exception table:
    //   from	to	target	type
    //   392	464	476	java/lang/RuntimeException
    //   467	473	476	java/lang/RuntimeException
    //   392	464	491	java/io/IOException
    //   467	473	491	java/io/IOException
    //   386	392	506	java/io/IOException
    //   480	486	506	java/io/IOException
    //   488	491	506	java/io/IOException
    //   495	501	506	java/io/IOException
    //   503	506	506	java/io/IOException
    //   543	554	506	java/io/IOException
    //   556	564	506	java/io/IOException
    //   566	573	506	java/io/IOException
    //   207	215	578	java/io/IOException
    //   221	229	578	java/io/IOException
    //   232	241	578	java/io/IOException
    //   244	249	578	java/io/IOException
    //   255	263	578	java/io/IOException
    //   266	272	578	java/io/IOException
    //   275	295	578	java/io/IOException
    //   298	314	578	java/io/IOException
    //   317	337	578	java/io/IOException
    //   340	347	578	java/io/IOException
    //   350	356	578	java/io/IOException
    //   364	372	578	java/io/IOException
    //   375	384	578	java/io/IOException
    //   521	529	578	java/io/IOException
    //   532	541	578	java/io/IOException
    //   634	656	684	finally
    //   656	672	684	finally
    //   619	634	695	java/io/IOException
    //   672	678	695	java/io/IOException
    //   686	695	695	java/io/IOException
    //   179	189	712	java/io/IOException
    //   192	204	712	java/io/IOException
    //   589	601	712	java/io/IOException
    //   605	619	712	java/io/IOException
    //   147	169	722	java/io/IOException
    //   135	143	750	java/lang/RuntimeException
    //   147	169	750	java/lang/RuntimeException
    //   179	189	750	java/lang/RuntimeException
    //   192	204	750	java/lang/RuntimeException
    //   207	215	750	java/lang/RuntimeException
    //   221	229	750	java/lang/RuntimeException
    //   232	241	750	java/lang/RuntimeException
    //   244	249	750	java/lang/RuntimeException
    //   255	263	750	java/lang/RuntimeException
    //   266	272	750	java/lang/RuntimeException
    //   275	295	750	java/lang/RuntimeException
    //   298	314	750	java/lang/RuntimeException
    //   317	337	750	java/lang/RuntimeException
    //   340	347	750	java/lang/RuntimeException
    //   350	356	750	java/lang/RuntimeException
    //   364	372	750	java/lang/RuntimeException
    //   375	384	750	java/lang/RuntimeException
    //   386	392	750	java/lang/RuntimeException
    //   480	486	750	java/lang/RuntimeException
    //   488	491	750	java/lang/RuntimeException
    //   495	501	750	java/lang/RuntimeException
    //   503	506	750	java/lang/RuntimeException
    //   521	529	750	java/lang/RuntimeException
    //   532	541	750	java/lang/RuntimeException
    //   543	554	750	java/lang/RuntimeException
    //   556	564	750	java/lang/RuntimeException
    //   566	573	750	java/lang/RuntimeException
    //   589	601	750	java/lang/RuntimeException
    //   605	619	750	java/lang/RuntimeException
    //   619	634	750	java/lang/RuntimeException
    //   672	678	750	java/lang/RuntimeException
    //   686	695	750	java/lang/RuntimeException
    //   734	739	750	java/lang/RuntimeException
    //   739	747	750	java/lang/RuntimeException
    //   72	135	758	java/io/IOException
    //   2	28	806	finally
    //   29	31	806	finally
    //   766	806	806	finally
    //   807	809	806	finally
    //   147	169	811	java/nio/channels/CancelledKeyException
    //   179	189	811	java/nio/channels/CancelledKeyException
    //   192	204	811	java/nio/channels/CancelledKeyException
    //   207	215	811	java/nio/channels/CancelledKeyException
    //   221	229	811	java/nio/channels/CancelledKeyException
    //   232	241	811	java/nio/channels/CancelledKeyException
    //   244	249	811	java/nio/channels/CancelledKeyException
    //   255	263	811	java/nio/channels/CancelledKeyException
    //   266	272	811	java/nio/channels/CancelledKeyException
    //   275	295	811	java/nio/channels/CancelledKeyException
    //   298	314	811	java/nio/channels/CancelledKeyException
    //   317	337	811	java/nio/channels/CancelledKeyException
    //   340	347	811	java/nio/channels/CancelledKeyException
    //   350	356	811	java/nio/channels/CancelledKeyException
    //   364	372	811	java/nio/channels/CancelledKeyException
    //   375	384	811	java/nio/channels/CancelledKeyException
    //   386	392	811	java/nio/channels/CancelledKeyException
    //   392	464	811	java/nio/channels/CancelledKeyException
    //   467	473	811	java/nio/channels/CancelledKeyException
    //   480	486	811	java/nio/channels/CancelledKeyException
    //   488	491	811	java/nio/channels/CancelledKeyException
    //   495	501	811	java/nio/channels/CancelledKeyException
    //   503	506	811	java/nio/channels/CancelledKeyException
    //   521	529	811	java/nio/channels/CancelledKeyException
    //   532	541	811	java/nio/channels/CancelledKeyException
    //   543	554	811	java/nio/channels/CancelledKeyException
    //   556	564	811	java/nio/channels/CancelledKeyException
    //   566	573	811	java/nio/channels/CancelledKeyException
    //   589	601	811	java/nio/channels/CancelledKeyException
    //   605	619	811	java/nio/channels/CancelledKeyException
    //   619	634	811	java/nio/channels/CancelledKeyException
    //   672	678	811	java/nio/channels/CancelledKeyException
    //   686	695	811	java/nio/channels/CancelledKeyException
    //   147	169	815	java/lang/InterruptedException
    //   179	189	815	java/lang/InterruptedException
    //   192	204	815	java/lang/InterruptedException
    //   207	215	815	java/lang/InterruptedException
    //   221	229	815	java/lang/InterruptedException
    //   232	241	815	java/lang/InterruptedException
    //   244	249	815	java/lang/InterruptedException
    //   255	263	815	java/lang/InterruptedException
    //   266	272	815	java/lang/InterruptedException
    //   275	295	815	java/lang/InterruptedException
    //   298	314	815	java/lang/InterruptedException
    //   317	337	815	java/lang/InterruptedException
    //   340	347	815	java/lang/InterruptedException
    //   350	356	815	java/lang/InterruptedException
    //   364	372	815	java/lang/InterruptedException
    //   375	384	815	java/lang/InterruptedException
    //   386	392	815	java/lang/InterruptedException
    //   392	464	815	java/lang/InterruptedException
    //   467	473	815	java/lang/InterruptedException
    //   480	486	815	java/lang/InterruptedException
    //   488	491	815	java/lang/InterruptedException
    //   495	501	815	java/lang/InterruptedException
    //   503	506	815	java/lang/InterruptedException
    //   521	529	815	java/lang/InterruptedException
    //   532	541	815	java/lang/InterruptedException
    //   543	554	815	java/lang/InterruptedException
    //   556	564	815	java/lang/InterruptedException
    //   566	573	815	java/lang/InterruptedException
    //   589	601	815	java/lang/InterruptedException
    //   605	619	815	java/lang/InterruptedException
    //   619	634	815	java/lang/InterruptedException
    //   672	678	815	java/lang/InterruptedException
    //   686	695	815	java/lang/InterruptedException
  }
  
  public final void setWebSocketFactory(WebSocketServerFactory paramWebSocketServerFactory)
  {
    this.wsf = paramWebSocketServerFactory;
  }
  
  public void start()
  {
    if (this.selectorthread == null)
    {
      new Thread(this).start();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(" can only be started once.");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public void stop()
    throws IOException, InterruptedException
  {
    stop(0);
  }
  
  public void stop(int paramInt)
    throws IOException, InterruptedException
  {
    if (!this.isclosed.compareAndSet(false, true)) {
      return;
    }
    synchronized (this.connections)
    {
      Iterator localIterator = this.connections.iterator();
      while (localIterator.hasNext()) {
        ((WebSocket)localIterator.next()).close(1001);
      }
      try
      {
        if (this.selectorthread != null)
        {
          Thread.currentThread();
          if (this.selectorthread != Thread.currentThread())
          {
            this.selectorthread.interrupt();
            this.selectorthread.join();
          }
        }
        if (this.decoders != null)
        {
          ??? = this.decoders.iterator();
          while (((Iterator)???).hasNext()) {
            ((WebSocketWorker)((Iterator)???).next()).interrupt();
          }
        }
        if (this.server != null) {
          this.server.close();
        }
        return;
      }
      finally {}
    }
  }
  
  public static abstract interface WebSocketServerFactory
    extends WebSocketFactory
  {
    public abstract WebSocketImpl createWebSocket(WebSocketAdapter paramWebSocketAdapter, List<Draft> paramList, Socket paramSocket);
    
    public abstract WebSocketImpl createWebSocket(WebSocketAdapter paramWebSocketAdapter, Draft paramDraft, Socket paramSocket);
    
    public abstract ByteChannel wrapChannel(SocketChannel paramSocketChannel, SelectionKey paramSelectionKey)
      throws IOException;
  }
  
  public class WebSocketWorker
    extends Thread
  {
    private BlockingQueue<WebSocketImpl> iqueue = new LinkedBlockingQueue();
    
    public WebSocketWorker()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WebSocketWorker-");
      localStringBuilder.append(getId());
      setName(localStringBuilder.toString());
      setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
      {
        public void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
        {
          Thread.getDefaultUncaughtExceptionHandler().uncaughtException(paramAnonymousThread, paramAnonymousThrowable);
        }
      });
    }
    
    public void put(WebSocketImpl paramWebSocketImpl)
      throws InterruptedException
    {
      this.iqueue.put(paramWebSocketImpl);
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_1
      //   2: aload_0
      //   3: getfield 31	org/java_websocket/server/WebSocketServer$WebSocketWorker:iqueue	Ljava/util/concurrent/BlockingQueue;
      //   6: invokeinterface 79 1 0
      //   11: checkcast 81	org/java_websocket/WebSocketImpl
      //   14: astore_2
      //   15: aload_2
      //   16: getfield 84	org/java_websocket/WebSocketImpl:inQueue	Ljava/util/concurrent/BlockingQueue;
      //   19: invokeinterface 87 1 0
      //   24: checkcast 89	java/nio/ByteBuffer
      //   27: astore_1
      //   28: aload_2
      //   29: aload_1
      //   30: invokevirtual 93	org/java_websocket/WebSocketImpl:decode	(Ljava/nio/ByteBuffer;)V
      //   33: aload_0
      //   34: getfield 24	org/java_websocket/server/WebSocketServer$WebSocketWorker:this$0	Lorg/java_websocket/server/WebSocketServer;
      //   37: aload_1
      //   38: invokestatic 97	org/java_websocket/server/WebSocketServer:access$000	(Lorg/java_websocket/server/WebSocketServer;Ljava/nio/ByteBuffer;)V
      //   41: aload_2
      //   42: astore_1
      //   43: goto -41 -> 2
      //   46: astore_3
      //   47: aload_0
      //   48: getfield 24	org/java_websocket/server/WebSocketServer$WebSocketWorker:this$0	Lorg/java_websocket/server/WebSocketServer;
      //   51: aload_1
      //   52: invokestatic 97	org/java_websocket/server/WebSocketServer:access$000	(Lorg/java_websocket/server/WebSocketServer;Ljava/nio/ByteBuffer;)V
      //   55: aload_3
      //   56: athrow
      //   57: astore_1
      //   58: aload_2
      //   59: astore_3
      //   60: goto +8 -> 68
      //   63: astore_2
      //   64: aload_1
      //   65: astore_3
      //   66: aload_2
      //   67: astore_1
      //   68: aload_0
      //   69: getfield 24	org/java_websocket/server/WebSocketServer$WebSocketWorker:this$0	Lorg/java_websocket/server/WebSocketServer;
      //   72: aload_3
      //   73: aload_1
      //   74: invokestatic 101	org/java_websocket/server/WebSocketServer:access$100	(Lorg/java_websocket/server/WebSocketServer;Lorg/java_websocket/WebSocket;Ljava/lang/Exception;)V
      //   77: return
      //   78: astore_1
      //   79: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	80	0	this	WebSocketWorker
      //   1	51	1	localObject1	Object
      //   57	8	1	localRuntimeException1	RuntimeException
      //   67	7	1	localObject2	Object
      //   78	1	1	localInterruptedException	InterruptedException
      //   14	45	2	localWebSocketImpl	WebSocketImpl
      //   63	4	2	localRuntimeException2	RuntimeException
      //   46	10	3	localObject3	Object
      //   59	14	3	localObject4	Object
      // Exception table:
      //   from	to	target	type
      //   28	33	46	finally
      //   15	28	57	java/lang/RuntimeException
      //   33	41	57	java/lang/RuntimeException
      //   47	57	57	java/lang/RuntimeException
      //   2	15	63	java/lang/RuntimeException
      //   2	15	78	java/lang/InterruptedException
      //   15	28	78	java/lang/InterruptedException
      //   33	41	78	java/lang/InterruptedException
      //   47	57	78	java/lang/InterruptedException
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\java_websocket\server\WebSocketServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */