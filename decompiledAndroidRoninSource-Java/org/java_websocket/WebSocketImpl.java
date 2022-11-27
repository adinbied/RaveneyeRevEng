package org.java_websocket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft.CloseHandshakeType;
import org.java_websocket.drafts.Draft.HandshakeState;
import org.java_websocket.drafts.Draft_10;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.drafts.Draft_75;
import org.java_websocket.drafts.Draft_76;
import org.java_websocket.exceptions.IncompleteHandshakeException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.WebsocketNotConnectedException;
import org.java_websocket.framing.CloseFrame;
import org.java_websocket.framing.CloseFrameBuilder;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.Framedata.Opcode;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;
import org.java_websocket.server.WebSocketServer.WebSocketWorker;
import org.java_websocket.util.Charsetfunctions;

public class WebSocketImpl
  implements WebSocket
{
  public static boolean DEBUG = false;
  public static int RCVBUF = 16384;
  public static final List<Draft> defaultdraftlist;
  public ByteChannel channel;
  private Integer closecode = null;
  private Boolean closedremotely = null;
  private String closemessage = null;
  private Framedata.Opcode current_continuous_frame_opcode = null;
  private Draft draft = null;
  private volatile boolean flushandclosestate = false;
  private ClientHandshake handshakerequest = null;
  public final BlockingQueue<ByteBuffer> inQueue;
  public SelectionKey key;
  private List<Draft> knownDrafts;
  public final BlockingQueue<ByteBuffer> outQueue;
  private WebSocket.READYSTATE readystate = WebSocket.READYSTATE.NOT_YET_CONNECTED;
  private WebSocket.Role role;
  private ByteBuffer tmpHandshakeBytes;
  public volatile WebSocketServer.WebSocketWorker workerThread;
  private final WebSocketListener wsl;
  
  static
  {
    ArrayList localArrayList = new ArrayList(4);
    defaultdraftlist = localArrayList;
    localArrayList.add(new Draft_17());
    defaultdraftlist.add(new Draft_10());
    defaultdraftlist.add(new Draft_76());
    defaultdraftlist.add(new Draft_75());
  }
  
  public WebSocketImpl(WebSocketListener paramWebSocketListener, List<Draft> paramList)
  {
    this(paramWebSocketListener, (Draft)null);
    this.role = WebSocket.Role.SERVER;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.knownDrafts = paramList;
      return;
    }
    this.knownDrafts = defaultdraftlist;
  }
  
  @Deprecated
  public WebSocketImpl(WebSocketListener paramWebSocketListener, List<Draft> paramList, Socket paramSocket)
  {
    this(paramWebSocketListener, paramList);
  }
  
  public WebSocketImpl(WebSocketListener paramWebSocketListener, Draft paramDraft)
  {
    if ((paramWebSocketListener != null) && ((paramDraft != null) || (this.role != WebSocket.Role.SERVER)))
    {
      this.outQueue = new LinkedBlockingQueue();
      this.inQueue = new LinkedBlockingQueue();
      this.wsl = paramWebSocketListener;
      this.role = WebSocket.Role.CLIENT;
      if (paramDraft != null) {
        this.draft = paramDraft.copyInstance();
      }
      return;
    }
    throw new IllegalArgumentException("parameters must not be null");
  }
  
  @Deprecated
  public WebSocketImpl(WebSocketListener paramWebSocketListener, Draft paramDraft, Socket paramSocket)
  {
    this(paramWebSocketListener, paramDraft);
  }
  
  private void close(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((this.readystate != WebSocket.READYSTATE.CLOSING) && (this.readystate != WebSocket.READYSTATE.CLOSED))
    {
      if (this.readystate == WebSocket.READYSTATE.OPEN)
      {
        if (paramInt == 1006)
        {
          this.readystate = WebSocket.READYSTATE.CLOSING;
          flushAndClose(paramInt, paramString, false);
          return;
        }
        if (this.draft.getCloseHandshakeType() != Draft.CloseHandshakeType.NONE)
        {
          if (!paramBoolean) {}
          try
          {
            try
            {
              this.wsl.onWebsocketCloseInitiated(this, paramInt, paramString);
            }
            catch (RuntimeException localRuntimeException)
            {
              this.wsl.onWebsocketError(this, localRuntimeException);
            }
            sendFrame(new CloseFrameBuilder(paramInt, paramString));
          }
          catch (InvalidDataException localInvalidDataException)
          {
            this.wsl.onWebsocketError(this, localInvalidDataException);
            flushAndClose(1006, "generated frame is invalid", false);
          }
        }
        flushAndClose(paramInt, paramString, paramBoolean);
      }
      else if (paramInt == -3)
      {
        flushAndClose(-3, paramString, true);
      }
      else
      {
        flushAndClose(-1, paramString, false);
      }
      if (paramInt == 1002) {
        flushAndClose(paramInt, paramString, paramBoolean);
      }
      this.readystate = WebSocket.READYSTATE.CLOSING;
      this.tmpHandshakeBytes = null;
    }
  }
  
  private void decodeFrames(ByteBuffer paramByteBuffer)
  {
    if (this.flushandclosestate) {
      return;
    }
    try
    {
      Iterator localIterator = this.draft.translateFrame(paramByteBuffer).iterator();
      while (localIterator.hasNext())
      {
        Framedata localFramedata = (Framedata)localIterator.next();
        Object localObject;
        if (DEBUG)
        {
          paramByteBuffer = System.out;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("matched frame: ");
          ((StringBuilder)localObject).append(localFramedata);
          paramByteBuffer.println(((StringBuilder)localObject).toString());
        }
        if (this.flushandclosestate) {
          return;
        }
        paramByteBuffer = localFramedata.getOpcode();
        boolean bool = localFramedata.isFin();
        if (paramByteBuffer == Framedata.Opcode.CLOSING)
        {
          int i = 1005;
          paramByteBuffer = "";
          if ((localFramedata instanceof CloseFrame))
          {
            paramByteBuffer = (CloseFrame)localFramedata;
            i = paramByteBuffer.getCloseCode();
            paramByteBuffer = paramByteBuffer.getMessage();
          }
          if (this.readystate == WebSocket.READYSTATE.CLOSING) {
            closeConnection(i, paramByteBuffer, true);
          } else if (this.draft.getCloseHandshakeType() == Draft.CloseHandshakeType.TWOWAY) {
            close(i, paramByteBuffer, true);
          } else {
            flushAndClose(i, paramByteBuffer, false);
          }
        }
        else if (paramByteBuffer == Framedata.Opcode.PING)
        {
          this.wsl.onWebsocketPing(this, localFramedata);
        }
        else if (paramByteBuffer == Framedata.Opcode.PONG)
        {
          this.wsl.onWebsocketPong(this, localFramedata);
        }
        else if ((bool) && (paramByteBuffer != Framedata.Opcode.CONTINUOUS))
        {
          if (this.current_continuous_frame_opcode == null)
          {
            localObject = Framedata.Opcode.TEXT;
            if (paramByteBuffer == localObject)
            {
              try
              {
                this.wsl.onWebsocketMessage(this, Charsetfunctions.stringUtf8(localFramedata.getPayloadData()));
              }
              catch (RuntimeException paramByteBuffer)
              {
                this.wsl.onWebsocketError(this, paramByteBuffer);
              }
            }
            else
            {
              localObject = Framedata.Opcode.BINARY;
              if (paramByteBuffer == localObject) {
                try
                {
                  this.wsl.onWebsocketMessage(this, localFramedata.getPayloadData());
                }
                catch (RuntimeException paramByteBuffer)
                {
                  this.wsl.onWebsocketError(this, paramByteBuffer);
                }
              } else {
                throw new InvalidDataException(1002, "non control or continious frame expected");
              }
            }
          }
          else
          {
            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
          }
        }
        else
        {
          if (paramByteBuffer != Framedata.Opcode.CONTINUOUS)
          {
            if (this.current_continuous_frame_opcode == null) {
              this.current_continuous_frame_opcode = paramByteBuffer;
            } else {
              throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
            }
          }
          else if (bool)
          {
            if (this.current_continuous_frame_opcode != null) {
              this.current_continuous_frame_opcode = null;
            } else {
              throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
            }
          }
          else
          {
            paramByteBuffer = this.current_continuous_frame_opcode;
            if (paramByteBuffer == null) {
              break label505;
            }
          }
          try
          {
            this.wsl.onWebsocketMessageFragment(this, localFramedata);
          }
          catch (RuntimeException paramByteBuffer)
          {
            this.wsl.onWebsocketError(this, paramByteBuffer);
          }
          continue;
          label505:
          throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
        }
      }
      return;
    }
    catch (InvalidDataException paramByteBuffer)
    {
      this.wsl.onWebsocketError(this, paramByteBuffer);
      close(paramByteBuffer);
    }
  }
  
  private boolean decodeHandshake(ByteBuffer paramByteBuffer)
  {
    ByteBuffer localByteBuffer = this.tmpHandshakeBytes;
    if (localByteBuffer == null)
    {
      localByteBuffer = paramByteBuffer;
    }
    else
    {
      if (localByteBuffer.remaining() < paramByteBuffer.remaining())
      {
        localByteBuffer = ByteBuffer.allocate(this.tmpHandshakeBytes.capacity() + paramByteBuffer.remaining());
        this.tmpHandshakeBytes.flip();
        localByteBuffer.put(this.tmpHandshakeBytes);
        this.tmpHandshakeBytes = localByteBuffer;
      }
      this.tmpHandshakeBytes.put(paramByteBuffer);
      this.tmpHandshakeBytes.flip();
      localByteBuffer = this.tmpHandshakeBytes;
    }
    localByteBuffer.mark();
    for (;;)
    {
      try
      {
        if ((this.draft == null) && (isFlashEdgeCase(localByteBuffer) == Draft.HandshakeState.MATCHED))
        {
          write(ByteBuffer.wrap(Charsetfunctions.utf8Bytes(this.wsl.getFlashPolicy(this))));
          close(-3, "");
          return false;
        }
        try
        {
          if (this.role == WebSocket.Role.SERVER)
          {
            localObject1 = this.draft;
            if (localObject1 == null)
            {
              localObject1 = this.knownDrafts.iterator();
              if (((Iterator)localObject1).hasNext()) {
                localDraft = ((Draft)((Iterator)localObject1).next()).copyInstance();
              }
            }
          }
        }
        catch (InvalidHandshakeException localInvalidHandshakeException1)
        {
          Object localObject1;
          Draft localDraft;
          Object localObject3;
          Object localObject4;
          Draft.HandshakeState localHandshakeState;
          StringBuilder localStringBuilder;
          close(localInvalidHandshakeException1);
          return false;
        }
      }
      catch (IncompleteHandshakeException localIncompleteHandshakeException)
      {
        Object localObject2 = this.tmpHandshakeBytes;
        if (localObject2 == null)
        {
          localByteBuffer.reset();
          int j = localIncompleteHandshakeException.getPreferedSize();
          int i = j;
          if (j == 0) {
            i = localByteBuffer.capacity() + 16;
          }
          localByteBuffer = ByteBuffer.allocate(i);
          this.tmpHandshakeBytes = localByteBuffer;
          localByteBuffer.put(paramByteBuffer);
          return false;
        }
        ((ByteBuffer)localObject2).position(((ByteBuffer)localObject2).limit());
        paramByteBuffer = this.tmpHandshakeBytes;
        paramByteBuffer.limit(paramByteBuffer.capacity());
      }
      try
      {
        localDraft.setParseMode(this.role);
        localByteBuffer.reset();
        localObject3 = localDraft.translateHandshake(localByteBuffer);
        if (!(localObject3 instanceof ClientHandshake))
        {
          flushAndClose(1002, "wrong http function", false);
          return false;
        }
        localObject3 = (ClientHandshake)localObject3;
        localObject4 = localDraft.acceptHandshakeAsServer((ClientHandshake)localObject3);
        localHandshakeState = Draft.HandshakeState.MATCHED;
        if (localObject4 != localHandshakeState) {
          continue;
        }
        try
        {
          localObject4 = this.wsl.onWebsocketHandshakeReceivedAsServer(this, localDraft, (ClientHandshake)localObject3);
          write(localDraft.createHandshake(localDraft.postProcessHandshakeResponseAsServer((ClientHandshake)localObject3, (ServerHandshakeBuilder)localObject4), this.role));
          this.draft = localDraft;
          open((Handshakedata)localObject3);
          return true;
        }
        catch (RuntimeException localRuntimeException2)
        {
          this.wsl.onWebsocketError(this, localRuntimeException2);
          flushAndClose(-1, localRuntimeException2.getMessage(), false);
          return false;
        }
        catch (InvalidDataException localInvalidDataException2)
        {
          flushAndClose(localInvalidDataException2.getCloseCode(), localInvalidDataException2.getMessage(), false);
          return false;
        }
        if (this.draft != null) {
          break;
        }
        close(1002, "no draft matches");
        return false;
      }
      catch (InvalidHandshakeException localInvalidHandshakeException2) {}
      localObject1 = this.draft.translateHandshake(localByteBuffer);
      if (!(localObject1 instanceof ClientHandshake))
      {
        flushAndClose(1002, "wrong http function", false);
        return false;
      }
      localObject1 = (ClientHandshake)localObject1;
      if (this.draft.acceptHandshakeAsServer((ClientHandshake)localObject1) == Draft.HandshakeState.MATCHED)
      {
        open((Handshakedata)localObject1);
        return true;
      }
      close(1002, "the handshake did finaly not match");
      return false;
      if (this.role == WebSocket.Role.CLIENT)
      {
        this.draft.setParseMode(this.role);
        localObject1 = this.draft.translateHandshake(localByteBuffer);
        if (!(localObject1 instanceof ServerHandshake))
        {
          flushAndClose(1002, "Wwrong http function", false);
          return false;
        }
        localObject1 = (ServerHandshake)localObject1;
        localObject2 = this.draft.acceptHandshakeAsClient(this.handshakerequest, (ServerHandshake)localObject1);
        localObject3 = Draft.HandshakeState.MATCHED;
        if (localObject2 == localObject3) {
          try
          {
            this.wsl.onWebsocketHandshakeReceivedAsClient(this, this.handshakerequest, (ServerHandshake)localObject1);
            open((Handshakedata)localObject1);
            return true;
          }
          catch (RuntimeException localRuntimeException1)
          {
            this.wsl.onWebsocketError(this, localRuntimeException1);
            flushAndClose(-1, localRuntimeException1.getMessage(), false);
            return false;
          }
          catch (InvalidDataException localInvalidDataException1)
          {
            flushAndClose(localInvalidDataException1.getCloseCode(), localInvalidDataException1.getMessage(), false);
            return false;
          }
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("draft ");
        localStringBuilder.append(this.draft);
        localStringBuilder.append(" refuses handshake");
        close(1002, localStringBuilder.toString());
        return false;
      }
      return false;
    }
    return false;
  }
  
  private Draft.HandshakeState isFlashEdgeCase(ByteBuffer paramByteBuffer)
    throws IncompleteHandshakeException
  {
    paramByteBuffer.mark();
    if (paramByteBuffer.limit() > Draft.FLASH_POLICY_REQUEST.length) {
      return Draft.HandshakeState.NOT_MATCHED;
    }
    if (paramByteBuffer.limit() >= Draft.FLASH_POLICY_REQUEST.length)
    {
      int i = 0;
      while (paramByteBuffer.hasRemaining())
      {
        if (Draft.FLASH_POLICY_REQUEST[i] != paramByteBuffer.get())
        {
          paramByteBuffer.reset();
          return Draft.HandshakeState.NOT_MATCHED;
        }
        i += 1;
      }
      return Draft.HandshakeState.MATCHED;
    }
    throw new IncompleteHandshakeException(Draft.FLASH_POLICY_REQUEST.length);
  }
  
  private void open(Handshakedata paramHandshakedata)
  {
    if (DEBUG)
    {
      PrintStream localPrintStream = System.out;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("open using draft: ");
      localStringBuilder.append(this.draft.getClass().getSimpleName());
      localPrintStream.println(localStringBuilder.toString());
    }
    this.readystate = WebSocket.READYSTATE.OPEN;
    try
    {
      this.wsl.onWebsocketOpen(this, paramHandshakedata);
      return;
    }
    catch (RuntimeException paramHandshakedata)
    {
      this.wsl.onWebsocketError(this, paramHandshakedata);
    }
  }
  
  private void send(Collection<Framedata> paramCollection)
  {
    if (isOpen())
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        sendFrame((Framedata)paramCollection.next());
      }
      return;
    }
    throw new WebsocketNotConnectedException();
  }
  
  private void write(ByteBuffer paramByteBuffer)
  {
    if (DEBUG)
    {
      PrintStream localPrintStream = System.out;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("write(");
      localStringBuilder.append(paramByteBuffer.remaining());
      localStringBuilder.append("): {");
      String str;
      if (paramByteBuffer.remaining() > 1000) {
        str = "too big to display";
      } else {
        str = new String(paramByteBuffer.array());
      }
      localStringBuilder.append(str);
      localStringBuilder.append("}");
      localPrintStream.println(localStringBuilder.toString());
    }
    this.outQueue.add(paramByteBuffer);
    this.wsl.onWriteDemand(this);
  }
  
  private void write(List<ByteBuffer> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      write((ByteBuffer)paramList.next());
    }
  }
  
  public void close()
  {
    close(1000);
  }
  
  public void close(int paramInt)
  {
    close(paramInt, "", false);
  }
  
  public void close(int paramInt, String paramString)
  {
    close(paramInt, paramString, false);
  }
  
  public void close(InvalidDataException paramInvalidDataException)
  {
    close(paramInvalidDataException.getCloseCode(), paramInvalidDataException.getMessage(), false);
  }
  
  public void closeConnection()
  {
    if (this.closedremotely != null)
    {
      closeConnection(this.closecode.intValue(), this.closemessage, this.closedremotely.booleanValue());
      return;
    }
    throw new IllegalStateException("this method must be used in conjuction with flushAndClose");
  }
  
  public void closeConnection(int paramInt, String paramString)
  {
    closeConnection(paramInt, paramString, false);
  }
  
  protected void closeConnection(int paramInt, String paramString, boolean paramBoolean)
  {
    try
    {
      Object localObject = this.readystate;
      WebSocket.READYSTATE localREADYSTATE = WebSocket.READYSTATE.CLOSED;
      if (localObject == localREADYSTATE) {
        return;
      }
      if (this.key != null) {
        this.key.cancel();
      }
      localObject = this.channel;
      if (localObject != null) {
        try
        {
          this.channel.close();
        }
        catch (IOException localIOException)
        {
          this.wsl.onWebsocketError(this, localIOException);
        }
      }
      try
      {
        this.wsl.onWebsocketClose(this, paramInt, paramString, paramBoolean);
      }
      catch (RuntimeException paramString)
      {
        this.wsl.onWebsocketError(this, paramString);
      }
      if (this.draft != null) {
        this.draft.reset();
      }
      this.handshakerequest = null;
      this.readystate = WebSocket.READYSTATE.CLOSED;
      this.outQueue.clear();
      return;
    }
    finally {}
  }
  
  protected void closeConnection(int paramInt, boolean paramBoolean)
  {
    closeConnection(paramInt, "", paramBoolean);
  }
  
  public void decode(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.hasRemaining())
    {
      if (this.flushandclosestate) {
        return;
      }
      if (DEBUG)
      {
        PrintStream localPrintStream = System.out;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("process(");
        localStringBuilder.append(paramByteBuffer.remaining());
        localStringBuilder.append("): {");
        String str;
        if (paramByteBuffer.remaining() > 1000) {
          str = "too big to display";
        } else {
          str = new String(paramByteBuffer.array(), paramByteBuffer.position(), paramByteBuffer.remaining());
        }
        localStringBuilder.append(str);
        localStringBuilder.append("}");
        localPrintStream.println(localStringBuilder.toString());
      }
      if (this.readystate == WebSocket.READYSTATE.OPEN)
      {
        decodeFrames(paramByteBuffer);
        return;
      }
      if (decodeHandshake(paramByteBuffer)) {
        decodeFrames(paramByteBuffer);
      }
    }
  }
  
  public void eot()
  {
    if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED)
    {
      closeConnection(-1, true);
      return;
    }
    if (this.flushandclosestate)
    {
      closeConnection(this.closecode.intValue(), this.closemessage, this.closedremotely.booleanValue());
      return;
    }
    if (this.draft.getCloseHandshakeType() == Draft.CloseHandshakeType.NONE)
    {
      closeConnection(1000, true);
      return;
    }
    if (this.draft.getCloseHandshakeType() == Draft.CloseHandshakeType.ONEWAY)
    {
      if (this.role == WebSocket.Role.SERVER)
      {
        closeConnection(1006, true);
        return;
      }
      closeConnection(1000, true);
      return;
    }
    closeConnection(1006, true);
  }
  
  protected void flushAndClose(int paramInt, String paramString, boolean paramBoolean)
  {
    try
    {
      boolean bool = this.flushandclosestate;
      if (bool) {
        return;
      }
      this.closecode = Integer.valueOf(paramInt);
      this.closemessage = paramString;
      this.closedremotely = Boolean.valueOf(paramBoolean);
      this.flushandclosestate = true;
      this.wsl.onWriteDemand(this);
      try
      {
        this.wsl.onWebsocketClosing(this, paramInt, paramString, paramBoolean);
      }
      catch (RuntimeException paramString)
      {
        this.wsl.onWebsocketError(this, paramString);
      }
      if (this.draft != null) {
        this.draft.reset();
      }
      this.handshakerequest = null;
      return;
    }
    finally {}
  }
  
  public Draft getDraft()
  {
    return this.draft;
  }
  
  public InetSocketAddress getLocalSocketAddress()
  {
    return this.wsl.getLocalSocketAddress(this);
  }
  
  public WebSocket.READYSTATE getReadyState()
  {
    return this.readystate;
  }
  
  public InetSocketAddress getRemoteSocketAddress()
  {
    return this.wsl.getRemoteSocketAddress(this);
  }
  
  public boolean hasBufferedData()
  {
    return this.outQueue.isEmpty() ^ true;
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public boolean isClosed()
  {
    return this.readystate == WebSocket.READYSTATE.CLOSED;
  }
  
  public boolean isClosing()
  {
    return this.readystate == WebSocket.READYSTATE.CLOSING;
  }
  
  public boolean isConnecting()
  {
    return this.readystate == WebSocket.READYSTATE.CONNECTING;
  }
  
  public boolean isFlushAndClose()
  {
    return this.flushandclosestate;
  }
  
  public boolean isOpen()
  {
    return this.readystate == WebSocket.READYSTATE.OPEN;
  }
  
  public void send(String paramString)
    throws WebsocketNotConnectedException
  {
    if (paramString != null)
    {
      Draft localDraft = this.draft;
      boolean bool;
      if (this.role == WebSocket.Role.CLIENT) {
        bool = true;
      } else {
        bool = false;
      }
      send(localDraft.createFrames(paramString, bool));
      return;
    }
    throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
  }
  
  public void send(ByteBuffer paramByteBuffer)
    throws IllegalArgumentException, WebsocketNotConnectedException
  {
    if (paramByteBuffer != null)
    {
      Draft localDraft = this.draft;
      boolean bool;
      if (this.role == WebSocket.Role.CLIENT) {
        bool = true;
      } else {
        bool = false;
      }
      send(localDraft.createFrames(paramByteBuffer, bool));
      return;
    }
    throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
  }
  
  public void send(byte[] paramArrayOfByte)
    throws IllegalArgumentException, WebsocketNotConnectedException
  {
    send(ByteBuffer.wrap(paramArrayOfByte));
  }
  
  public void sendFrame(Framedata paramFramedata)
  {
    if (DEBUG)
    {
      PrintStream localPrintStream = System.out;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("send frame: ");
      localStringBuilder.append(paramFramedata);
      localPrintStream.println(localStringBuilder.toString());
    }
    write(this.draft.createBinaryFrame(paramFramedata));
  }
  
  public void startHandshake(ClientHandshakeBuilder paramClientHandshakeBuilder)
    throws InvalidHandshakeException
  {
    paramClientHandshakeBuilder = this.draft.postProcessHandshakeRequestAsClient(paramClientHandshakeBuilder);
    this.handshakerequest = paramClientHandshakeBuilder;
    try
    {
      this.wsl.onWebsocketHandshakeSentAsClient(this, paramClientHandshakeBuilder);
      write(this.draft.createHandshake(this.handshakerequest, this.role));
      return;
    }
    catch (RuntimeException paramClientHandshakeBuilder)
    {
      this.wsl.onWebsocketError(this, paramClientHandshakeBuilder);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("rejected because of");
      localStringBuilder.append(paramClientHandshakeBuilder);
      throw new InvalidHandshakeException(localStringBuilder.toString());
      throw new InvalidHandshakeException("Handshake data rejected by client.");
    }
    catch (InvalidDataException paramClientHandshakeBuilder)
    {
      for (;;) {}
    }
  }
  
  public String toString()
  {
    return super.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\java_websocket\WebSocketImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */