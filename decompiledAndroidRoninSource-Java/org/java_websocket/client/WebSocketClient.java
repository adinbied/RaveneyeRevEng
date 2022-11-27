package org.java_websocket.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import org.java_websocket.SocketChannelIOHelper;
import org.java_websocket.WebSocket;
import org.java_websocket.WebSocket.READYSTATE;
import org.java_websocket.WebSocketAdapter;
import org.java_websocket.WebSocketFactory;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_10;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.HandshakeImpl1Client;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;

public abstract class WebSocketClient
  extends WebSocketAdapter
  implements Runnable
{
  private SocketChannel channel = null;
  private CountDownLatch closeLatch = new CountDownLatch(1);
  private WebSocketImpl conn = null;
  private CountDownLatch connectLatch = new CountDownLatch(1);
  private Draft draft;
  private Map<String, String> headers;
  private InetSocketAddress proxyAddress = null;
  private Thread readthread;
  private int timeout = 0;
  protected URI uri = null;
  private ByteChannel wrappedchannel = null;
  private Thread writethread;
  private WebSocketClientFactory wsfactory = new DefaultWebSocketClientFactory(this);
  
  public WebSocketClient(URI paramURI)
  {
    this(paramURI, new Draft_10());
  }
  
  public WebSocketClient(URI paramURI, Draft paramDraft)
  {
    this(paramURI, paramDraft, null, 0);
  }
  
  public WebSocketClient(URI paramURI, Draft paramDraft, Map<String, String> paramMap, int paramInt)
  {
    if (paramURI != null)
    {
      if (paramDraft != null)
      {
        this.uri = paramURI;
        this.draft = paramDraft;
        this.headers = paramMap;
        this.timeout = paramInt;
        try
        {
          paramURI = SelectorProvider.provider().openSocketChannel();
          this.channel = paramURI;
          paramURI.configureBlocking(true);
        }
        catch (IOException paramURI)
        {
          this.channel = null;
          onWebsocketError(null, paramURI);
        }
        paramURI = this.channel;
        if (paramURI == null)
        {
          paramURI = (WebSocketImpl)this.wsfactory.createWebSocket(this, paramDraft, null);
          this.conn = paramURI;
          paramURI.close(-1, "Failed to create or configure SocketChannel.");
          return;
        }
        this.conn = ((WebSocketImpl)this.wsfactory.createWebSocket(this, paramDraft, paramURI.socket()));
        return;
      }
      throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
    }
    throw new IllegalArgumentException();
  }
  
  private int getPort()
  {
    int i = this.uri.getPort();
    if (i == -1)
    {
      String str = this.uri.getScheme();
      if (str.equals("wss")) {
        return 443;
      }
      if (str.equals("ws")) {
        return 80;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unkonow scheme");
      localStringBuilder.append(str);
      throw new RuntimeException(localStringBuilder.toString());
    }
    return i;
  }
  
  /* Error */
  private final void interruptableRun()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 69	org/java_websocket/client/WebSocketClient:channel	Ljava/nio/channels/SocketChannel;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 91	org/java_websocket/client/WebSocketClient:proxyAddress	Ljava/net/InetSocketAddress;
    //   12: ifnull +22 -> 34
    //   15: aload_0
    //   16: getfield 91	org/java_websocket/client/WebSocketClient:proxyAddress	Ljava/net/InetSocketAddress;
    //   19: invokevirtual 195	java/net/InetSocketAddress:getHostName	()Ljava/lang/String;
    //   22: astore_2
    //   23: aload_0
    //   24: getfield 91	org/java_websocket/client/WebSocketClient:proxyAddress	Ljava/net/InetSocketAddress;
    //   27: invokevirtual 196	java/net/InetSocketAddress:getPort	()I
    //   30: istore_1
    //   31: goto +16 -> 47
    //   34: aload_0
    //   35: getfield 65	org/java_websocket/client/WebSocketClient:uri	Ljava/net/URI;
    //   38: invokevirtual 199	java/net/URI:getHost	()Ljava/lang/String;
    //   41: astore_2
    //   42: aload_0
    //   43: invokespecial 147	org/java_websocket/client/WebSocketClient:getPort	()I
    //   46: istore_1
    //   47: aload_0
    //   48: getfield 69	org/java_websocket/client/WebSocketClient:channel	Ljava/nio/channels/SocketChannel;
    //   51: new 192	java/net/InetSocketAddress
    //   54: dup
    //   55: aload_2
    //   56: iload_1
    //   57: invokespecial 202	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   60: invokevirtual 206	java/nio/channels/SocketChannel:connect	(Ljava/net/SocketAddress;)Z
    //   63: pop
    //   64: aload_0
    //   65: getfield 67	org/java_websocket/client/WebSocketClient:conn	Lorg/java_websocket/WebSocketImpl;
    //   68: astore_3
    //   69: aload_0
    //   70: aload_0
    //   71: getfield 89	org/java_websocket/client/WebSocketClient:wsfactory	Lorg/java_websocket/client/WebSocketClient$WebSocketClientFactory;
    //   74: aload_0
    //   75: getfield 69	org/java_websocket/client/WebSocketClient:channel	Ljava/nio/channels/SocketChannel;
    //   78: aconst_null
    //   79: aload_2
    //   80: iload_1
    //   81: invokeinterface 210 5 0
    //   86: invokevirtual 214	org/java_websocket/client/WebSocketClient:createProxyChannel	(Ljava/nio/channels/ByteChannel;)Ljava/nio/channels/ByteChannel;
    //   89: astore_2
    //   90: aload_0
    //   91: aload_2
    //   92: putfield 71	org/java_websocket/client/WebSocketClient:wrappedchannel	Ljava/nio/channels/ByteChannel;
    //   95: aload_3
    //   96: aload_2
    //   97: putfield 216	org/java_websocket/WebSocketImpl:channel	Ljava/nio/channels/ByteChannel;
    //   100: aload_0
    //   101: iconst_0
    //   102: putfield 82	org/java_websocket/client/WebSocketClient:timeout	I
    //   105: aload_0
    //   106: invokespecial 219	org/java_websocket/client/WebSocketClient:sendHandshake	()V
    //   109: new 221	java/lang/Thread
    //   112: dup
    //   113: new 16	org/java_websocket/client/WebSocketClient$WebsocketWriteThread
    //   116: dup
    //   117: aload_0
    //   118: aconst_null
    //   119: invokespecial 224	org/java_websocket/client/WebSocketClient$WebsocketWriteThread:<init>	(Lorg/java_websocket/client/WebSocketClient;Lorg/java_websocket/client/WebSocketClient$1;)V
    //   122: invokespecial 227	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   125: astore_2
    //   126: aload_0
    //   127: aload_2
    //   128: putfield 229	org/java_websocket/client/WebSocketClient:readthread	Ljava/lang/Thread;
    //   131: aload_2
    //   132: invokevirtual 232	java/lang/Thread:start	()V
    //   135: getstatic 235	org/java_websocket/WebSocketImpl:RCVBUF	I
    //   138: invokestatic 241	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   141: astore_2
    //   142: aload_0
    //   143: getfield 69	org/java_websocket/client/WebSocketClient:channel	Ljava/nio/channels/SocketChannel;
    //   146: invokevirtual 245	java/nio/channels/SocketChannel:isOpen	()Z
    //   149: ifeq +133 -> 282
    //   152: aload_2
    //   153: aload_0
    //   154: getfield 67	org/java_websocket/client/WebSocketClient:conn	Lorg/java_websocket/WebSocketImpl;
    //   157: aload_0
    //   158: getfield 71	org/java_websocket/client/WebSocketClient:wrappedchannel	Ljava/nio/channels/ByteChannel;
    //   161: invokestatic 251	org/java_websocket/SocketChannelIOHelper:read	(Ljava/nio/ByteBuffer;Lorg/java_websocket/WebSocketImpl;Ljava/nio/channels/ByteChannel;)Z
    //   164: ifeq +14 -> 178
    //   167: aload_0
    //   168: getfield 67	org/java_websocket/client/WebSocketClient:conn	Lorg/java_websocket/WebSocketImpl;
    //   171: aload_2
    //   172: invokevirtual 255	org/java_websocket/WebSocketImpl:decode	(Ljava/nio/ByteBuffer;)V
    //   175: goto +10 -> 185
    //   178: aload_0
    //   179: getfield 67	org/java_websocket/client/WebSocketClient:conn	Lorg/java_websocket/WebSocketImpl;
    //   182: invokevirtual 258	org/java_websocket/WebSocketImpl:eot	()V
    //   185: aload_0
    //   186: getfield 71	org/java_websocket/client/WebSocketClient:wrappedchannel	Ljava/nio/channels/ByteChannel;
    //   189: instanceof 260
    //   192: ifeq -50 -> 142
    //   195: aload_0
    //   196: getfield 71	org/java_websocket/client/WebSocketClient:wrappedchannel	Ljava/nio/channels/ByteChannel;
    //   199: checkcast 260	org/java_websocket/WrappedByteChannel
    //   202: astore_3
    //   203: aload_3
    //   204: invokeinterface 263 1 0
    //   209: ifeq -67 -> 142
    //   212: aload_2
    //   213: aload_0
    //   214: getfield 67	org/java_websocket/client/WebSocketClient:conn	Lorg/java_websocket/WebSocketImpl;
    //   217: aload_3
    //   218: invokestatic 267	org/java_websocket/SocketChannelIOHelper:readMore	(Ljava/nio/ByteBuffer;Lorg/java_websocket/WebSocketImpl;Lorg/java_websocket/WrappedByteChannel;)Z
    //   221: ifeq +14 -> 235
    //   224: aload_0
    //   225: getfield 67	org/java_websocket/client/WebSocketClient:conn	Lorg/java_websocket/WebSocketImpl;
    //   228: aload_2
    //   229: invokevirtual 255	org/java_websocket/WebSocketImpl:decode	(Ljava/nio/ByteBuffer;)V
    //   232: goto -20 -> 212
    //   235: aload_0
    //   236: getfield 67	org/java_websocket/client/WebSocketClient:conn	Lorg/java_websocket/WebSocketImpl;
    //   239: aload_2
    //   240: invokevirtual 255	org/java_websocket/WebSocketImpl:decode	(Ljava/nio/ByteBuffer;)V
    //   243: goto -101 -> 142
    //   246: astore_2
    //   247: aload_0
    //   248: aload_2
    //   249: invokevirtual 271	org/java_websocket/client/WebSocketClient:onError	(Ljava/lang/Exception;)V
    //   252: aload_0
    //   253: getfield 67	org/java_websocket/client/WebSocketClient:conn	Lorg/java_websocket/WebSocketImpl;
    //   256: sipush 1006
    //   259: aload_2
    //   260: invokevirtual 274	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   263: invokevirtual 277	org/java_websocket/WebSocketImpl:closeConnection	(ILjava/lang/String;)V
    //   266: return
    //   267: aload_0
    //   268: getfield 67	org/java_websocket/client/WebSocketClient:conn	Lorg/java_websocket/WebSocketImpl;
    //   271: invokevirtual 258	org/java_websocket/WebSocketImpl:eot	()V
    //   274: return
    //   275: aload_0
    //   276: getfield 67	org/java_websocket/client/WebSocketClient:conn	Lorg/java_websocket/WebSocketImpl;
    //   279: invokevirtual 258	org/java_websocket/WebSocketImpl:eot	()V
    //   282: return
    //   283: astore_2
    //   284: aload_0
    //   285: aload_0
    //   286: getfield 67	org/java_websocket/client/WebSocketClient:conn	Lorg/java_websocket/WebSocketImpl;
    //   289: aload_2
    //   290: invokevirtual 115	org/java_websocket/client/WebSocketClient:onWebsocketError	(Lorg/java_websocket/WebSocket;Ljava/lang/Exception;)V
    //   293: aload_0
    //   294: getfield 67	org/java_websocket/client/WebSocketClient:conn	Lorg/java_websocket/WebSocketImpl;
    //   297: iconst_m1
    //   298: aload_2
    //   299: invokevirtual 278	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   302: invokevirtual 277	org/java_websocket/WebSocketImpl:closeConnection	(ILjava/lang/String;)V
    //   305: return
    //   306: astore_2
    //   307: aload_0
    //   308: aconst_null
    //   309: aload_2
    //   310: invokevirtual 115	org/java_websocket/client/WebSocketClient:onWebsocketError	(Lorg/java_websocket/WebSocket;Ljava/lang/Exception;)V
    //   313: return
    //   314: astore_2
    //   315: goto -40 -> 275
    //   318: astore_2
    //   319: goto -52 -> 267
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	this	WebSocketClient
    //   30	51	1	i	int
    //   22	218	2	localObject1	Object
    //   246	14	2	localRuntimeException	RuntimeException
    //   283	16	2	localException	Exception
    //   306	4	2	localClosedByInterruptException	java.nio.channels.ClosedByInterruptException
    //   314	1	2	localCancelledKeyException	java.nio.channels.CancelledKeyException
    //   318	1	2	localIOException	IOException
    //   68	150	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   142	175	246	java/lang/RuntimeException
    //   178	185	246	java/lang/RuntimeException
    //   185	212	246	java/lang/RuntimeException
    //   212	232	246	java/lang/RuntimeException
    //   235	243	246	java/lang/RuntimeException
    //   8	31	283	java/lang/Exception
    //   34	47	283	java/lang/Exception
    //   47	135	283	java/lang/Exception
    //   8	31	306	java/nio/channels/ClosedByInterruptException
    //   34	47	306	java/nio/channels/ClosedByInterruptException
    //   47	135	306	java/nio/channels/ClosedByInterruptException
    //   142	175	314	java/nio/channels/CancelledKeyException
    //   178	185	314	java/nio/channels/CancelledKeyException
    //   185	212	314	java/nio/channels/CancelledKeyException
    //   212	232	314	java/nio/channels/CancelledKeyException
    //   235	243	314	java/nio/channels/CancelledKeyException
    //   142	175	318	java/io/IOException
    //   178	185	318	java/io/IOException
    //   185	212	318	java/io/IOException
    //   212	232	318	java/io/IOException
    //   235	243	318	java/io/IOException
  }
  
  private void sendHandshake()
    throws InvalidHandshakeException
  {
    Object localObject2 = this.uri.getPath();
    Object localObject3 = this.uri.getQuery();
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      localObject1 = "/";
    }
    localObject2 = localObject1;
    if (localObject3 != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("?");
      ((StringBuilder)localObject2).append((String)localObject3);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    int i = getPort();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(this.uri.getHost());
    if (i != 80)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(":");
      ((StringBuilder)localObject1).append(i);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = "";
    }
    ((StringBuilder)localObject3).append((String)localObject1);
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject1 = new HandshakeImpl1Client();
    ((HandshakeImpl1Client)localObject1).setResourceDescriptor((String)localObject2);
    ((HandshakeImpl1Client)localObject1).put("Host", (String)localObject3);
    localObject2 = this.headers;
    if (localObject2 != null)
    {
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        ((HandshakeImpl1Client)localObject1).put((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
      }
    }
    this.conn.startHandshake((ClientHandshakeBuilder)localObject1);
  }
  
  public void close()
  {
    if (this.writethread != null) {
      this.conn.close(1000);
    }
  }
  
  public void closeBlocking()
    throws InterruptedException
  {
    close();
    this.closeLatch.await();
  }
  
  public void connect()
  {
    if (this.writethread == null)
    {
      Thread localThread = new Thread(this);
      this.writethread = localThread;
      localThread.start();
      return;
    }
    throw new IllegalStateException("WebSocketClient objects are not reuseable");
  }
  
  public boolean connectBlocking()
    throws InterruptedException
  {
    connect();
    this.connectLatch.await();
    return this.conn.isOpen();
  }
  
  public ByteChannel createProxyChannel(ByteChannel paramByteChannel)
  {
    if (this.proxyAddress != null) {
      return new DefaultClientProxyChannel(paramByteChannel);
    }
    return paramByteChannel;
  }
  
  public WebSocket getConnection()
  {
    return this.conn;
  }
  
  public Draft getDraft()
  {
    return this.draft;
  }
  
  public InetSocketAddress getLocalSocketAddress(WebSocket paramWebSocket)
  {
    paramWebSocket = this.channel;
    if (paramWebSocket != null) {
      return (InetSocketAddress)paramWebSocket.socket().getLocalSocketAddress();
    }
    return null;
  }
  
  public WebSocket.READYSTATE getReadyState()
  {
    return this.conn.getReadyState();
  }
  
  public InetSocketAddress getRemoteSocketAddress(WebSocket paramWebSocket)
  {
    paramWebSocket = this.channel;
    if (paramWebSocket != null) {
      return (InetSocketAddress)paramWebSocket.socket().getLocalSocketAddress();
    }
    return null;
  }
  
  public URI getURI()
  {
    return this.uri;
  }
  
  public final WebSocketFactory getWebSocketFactory()
  {
    return this.wsfactory;
  }
  
  public abstract void onClose(int paramInt, String paramString, boolean paramBoolean);
  
  public void onCloseInitiated(int paramInt, String paramString) {}
  
  public void onClosing(int paramInt, String paramString, boolean paramBoolean) {}
  
  public abstract void onError(Exception paramException);
  
  public abstract void onMessage(String paramString);
  
  public void onMessage(ByteBuffer paramByteBuffer) {}
  
  public abstract void onOpen(ServerHandshake paramServerHandshake);
  
  public final void onWebsocketClose(WebSocket paramWebSocket, int paramInt, String paramString, boolean paramBoolean)
  {
    this.connectLatch.countDown();
    this.closeLatch.countDown();
    paramWebSocket = this.readthread;
    if (paramWebSocket != null) {
      paramWebSocket.interrupt();
    }
    onClose(paramInt, paramString, paramBoolean);
  }
  
  public void onWebsocketCloseInitiated(WebSocket paramWebSocket, int paramInt, String paramString)
  {
    onCloseInitiated(paramInt, paramString);
  }
  
  public void onWebsocketClosing(WebSocket paramWebSocket, int paramInt, String paramString, boolean paramBoolean)
  {
    onClosing(paramInt, paramString, paramBoolean);
  }
  
  public final void onWebsocketError(WebSocket paramWebSocket, Exception paramException)
  {
    onError(paramException);
  }
  
  public final void onWebsocketMessage(WebSocket paramWebSocket, String paramString)
  {
    onMessage(paramString);
  }
  
  public final void onWebsocketMessage(WebSocket paramWebSocket, ByteBuffer paramByteBuffer)
  {
    onMessage(paramByteBuffer);
  }
  
  public final void onWebsocketOpen(WebSocket paramWebSocket, Handshakedata paramHandshakedata)
  {
    this.connectLatch.countDown();
    onOpen((ServerHandshake)paramHandshakedata);
  }
  
  public final void onWriteDemand(WebSocket paramWebSocket) {}
  
  public void run()
  {
    if (this.writethread == null) {
      this.writethread = Thread.currentThread();
    }
    interruptableRun();
  }
  
  public void send(String paramString)
    throws NotYetConnectedException
  {
    this.conn.send(paramString);
  }
  
  public void send(byte[] paramArrayOfByte)
    throws NotYetConnectedException
  {
    this.conn.send(paramArrayOfByte);
  }
  
  public void setProxy(InetSocketAddress paramInetSocketAddress)
  {
    this.proxyAddress = paramInetSocketAddress;
  }
  
  public final void setWebSocketFactory(WebSocketClientFactory paramWebSocketClientFactory)
  {
    this.wsfactory = paramWebSocketClientFactory;
  }
  
  public class DefaultClientProxyChannel
    extends AbstractClientProxyChannel
  {
    public DefaultClientProxyChannel(ByteChannel paramByteChannel)
    {
      super();
    }
    
    public String buildHandShake()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String str = WebSocketClient.this.uri.getHost();
      localStringBuilder.append("CONNECT ");
      localStringBuilder.append(str);
      localStringBuilder.append(":");
      localStringBuilder.append(WebSocketClient.this.getPort());
      localStringBuilder.append(" HTTP/1.1\n");
      localStringBuilder.append("Host: ");
      localStringBuilder.append(str);
      localStringBuilder.append("\n");
      return localStringBuilder.toString();
    }
  }
  
  public static abstract interface WebSocketClientFactory
    extends WebSocketFactory
  {
    public abstract ByteChannel wrapChannel(SocketChannel paramSocketChannel, SelectionKey paramSelectionKey, String paramString, int paramInt)
      throws IOException;
  }
  
  private class WebsocketWriteThread
    implements Runnable
  {
    private WebsocketWriteThread() {}
    
    public void run()
    {
      Thread.currentThread().setName("WebsocketWriteThread");
      try
      {
        while (!Thread.interrupted()) {
          SocketChannelIOHelper.writeBlocking(WebSocketClient.this.conn, WebSocketClient.this.wrappedchannel);
        }
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
      catch (InterruptedException localInterruptedException) {}
      WebSocketClient.this.conn.eot();
      return;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\java_websocket\client\WebSocketClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */