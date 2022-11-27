package dji.thirdparty.okhttp3.internal.framed;

import dji.thirdparty.okhttp3.Protocol;
import dji.thirdparty.okhttp3.internal.NamedRunnable;
import dji.thirdparty.okhttp3.internal.Util;
import dji.thirdparty.okio.Buffer;
import dji.thirdparty.okio.BufferedSink;
import dji.thirdparty.okio.BufferedSource;
import dji.thirdparty.okio.ByteString;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class FramedConnection
  implements Closeable
{
  private static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
  private static final ExecutorService executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp FramedConnection", true));
  long bytesLeftInWriteWindow;
  final boolean client;
  private final Set<Integer> currentPushRequests = new LinkedHashSet();
  final FrameWriter frameWriter;
  private final String hostname;
  private long idleStartTimeNs = System.nanoTime();
  private int lastGoodStreamId;
  private final Listener listener;
  private int nextPingId;
  private int nextStreamId;
  Settings okHttpSettings = new Settings();
  final Settings peerSettings = new Settings();
  private Map<Integer, Ping> pings;
  final Protocol protocol;
  private final ExecutorService pushExecutor;
  private final PushObserver pushObserver;
  final Reader readerRunnable;
  private boolean receivedInitialPeerSettings = false;
  private boolean shutdown;
  final Socket socket;
  private final Map<Integer, FramedStream> streams = new HashMap();
  long unacknowledgedBytesRead = 0L;
  final Variant variant;
  
  private FramedConnection(Builder paramBuilder)
    throws IOException
  {
    this.protocol = paramBuilder.protocol;
    this.pushObserver = paramBuilder.pushObserver;
    this.client = paramBuilder.client;
    this.listener = paramBuilder.listener;
    boolean bool = paramBuilder.client;
    int j = 2;
    if (bool) {
      i = 1;
    } else {
      i = 2;
    }
    this.nextStreamId = i;
    if ((paramBuilder.client) && (this.protocol == Protocol.HTTP_2)) {
      this.nextStreamId += 2;
    }
    int i = j;
    if (paramBuilder.client) {
      i = 1;
    }
    this.nextPingId = i;
    if (paramBuilder.client) {
      this.okHttpSettings.set(7, 0, 16777216);
    }
    this.hostname = paramBuilder.hostname;
    if (this.protocol == Protocol.HTTP_2)
    {
      this.variant = new Http2();
      this.pushExecutor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(String.format("OkHttp %s Push Observer", new Object[] { this.hostname }), true));
      this.peerSettings.set(7, 0, 65535);
      this.peerSettings.set(5, 0, 16384);
    }
    else
    {
      if (this.protocol != Protocol.SPDY_3) {
        break label403;
      }
      this.variant = new Spdy3();
      this.pushExecutor = null;
    }
    this.bytesLeftInWriteWindow = this.peerSettings.getInitialWindowSize(65536);
    this.socket = paramBuilder.socket;
    this.frameWriter = this.variant.newWriter(paramBuilder.sink, this.client);
    this.readerRunnable = new Reader(this.variant.newReader(paramBuilder.source, this.client), null);
    new Thread(this.readerRunnable).start();
    return;
    label403:
    throw new AssertionError(this.protocol);
  }
  
  /* Error */
  private void close(ErrorCode arg1, ErrorCode arg2)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private FramedStream newStream(int paramInt, List<Header> paramList, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    return null;
  }
  
  /* Error */
  private void pushDataLater(int arg1, BufferedSource arg2, int arg3, boolean arg4)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void pushHeadersLater(int arg1, List<Header> arg2, boolean arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void pushRequestLater(int arg1, List<Header> arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  /* Error */
  private void pushResetLater(int arg1, ErrorCode arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  private boolean pushedStream(int paramInt)
  {
    return false;
  }
  
  private Ping removePing(int paramInt)
  {
    return null;
  }
  
  /* Error */
  private void setIdle(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  /* Error */
  private void writePing(boolean arg1, int arg2, int arg3, Ping arg4)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: return
  }
  
  /* Error */
  private void writePingLater(boolean arg1, int arg2, int arg3, Ping arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: goto -3 -> 0
  }
  
  /* Error */
  void addBytesToWriteWindow(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public void close()
    throws IOException
  {
    close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
  }
  
  public void flush()
    throws IOException
  {
    this.frameWriter.flush();
  }
  
  public long getIdleStartTimeNs()
  {
    try
    {
      long l = this.idleStartTimeNs;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Protocol getProtocol()
  {
    return this.protocol;
  }
  
  FramedStream getStream(int paramInt)
  {
    return null;
  }
  
  public boolean isIdle()
  {
    return false;
  }
  
  public int maxConcurrentStreams()
  {
    return 0;
  }
  
  public FramedStream newStream(List<Header> paramList, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    return newStream(0, paramList, paramBoolean1, paramBoolean2);
  }
  
  public int openStreamCount()
  {
    return 0;
  }
  
  public Ping ping()
    throws IOException
  {
    return null;
  }
  
  public FramedStream pushStream(int paramInt, List<Header> paramList, boolean paramBoolean)
    throws IOException
  {
    return null;
  }
  
  FramedStream removeStream(int paramInt)
  {
    return null;
  }
  
  /* Error */
  public void sendConnectionPreface()
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setSettings(Settings arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void shutdown(ErrorCode arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void writeData(int arg1, boolean arg2, Buffer arg3, long arg4)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: return
  }
  
  void writeSynReply(int paramInt, boolean paramBoolean, List<Header> paramList)
    throws IOException
  {
    this.frameWriter.synReply(paramBoolean, paramInt, paramList);
  }
  
  void writeSynReset(int paramInt, ErrorCode paramErrorCode)
    throws IOException
  {
    this.frameWriter.rstStream(paramInt, paramErrorCode);
  }
  
  /* Error */
  void writeSynResetLater(int arg1, ErrorCode arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void writeWindowUpdateLater(int arg1, long arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: goto -3 -> 0
  }
  
  public static class Builder
  {
    private boolean client;
    private String hostname;
    private FramedConnection.Listener listener = FramedConnection.Listener.REFUSE_INCOMING_STREAMS;
    private Protocol protocol = Protocol.SPDY_3;
    private PushObserver pushObserver = PushObserver.CANCEL;
    private BufferedSink sink;
    private Socket socket;
    private BufferedSource source;
    
    public Builder(boolean paramBoolean)
      throws IOException
    {
      this.client = paramBoolean;
    }
    
    public FramedConnection build()
      throws IOException
    {
      return new FramedConnection(this, null);
    }
    
    public Builder listener(FramedConnection.Listener paramListener)
    {
      this.listener = paramListener;
      return this;
    }
    
    public Builder protocol(Protocol paramProtocol)
    {
      this.protocol = paramProtocol;
      return this;
    }
    
    public Builder pushObserver(PushObserver paramPushObserver)
    {
      this.pushObserver = paramPushObserver;
      return this;
    }
    
    public Builder socket(Socket paramSocket)
      throws IOException
    {
      return null;
    }
    
    public Builder socket(Socket paramSocket, String paramString, BufferedSource paramBufferedSource, BufferedSink paramBufferedSink)
    {
      this.socket = paramSocket;
      this.hostname = paramString;
      this.source = paramBufferedSource;
      this.sink = paramBufferedSink;
      return this;
    }
  }
  
  public static abstract class Listener
  {
    public static final Listener REFUSE_INCOMING_STREAMS = new Listener()
    {
      public void onStream(FramedStream paramAnonymousFramedStream)
        throws IOException
      {
        paramAnonymousFramedStream.close(ErrorCode.REFUSED_STREAM);
      }
    };
    
    public void onSettings(FramedConnection paramFramedConnection) {}
    
    public abstract void onStream(FramedStream paramFramedStream)
      throws IOException;
  }
  
  class Reader
    extends NamedRunnable
    implements FrameReader.Handler
  {
    final FrameReader frameReader;
    
    private Reader(FrameReader paramFrameReader)
    {
      super(new Object[] { FramedConnection.this.hostname });
      this.frameReader = paramFrameReader;
    }
    
    /* Error */
    private void ackSettingsLater(Settings arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void ackSettings() {}
    
    public void alternateService(int paramInt1, String paramString1, ByteString paramByteString, String paramString2, int paramInt2, long paramLong) {}
    
    /* Error */
    public void data(boolean arg1, int arg2, BufferedSource arg3, int arg4)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    /* Error */
    protected void execute()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void goAway(int arg1, ErrorCode arg2, ByteString arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: return
    }
    
    /* Error */
    public void headers(boolean arg1, boolean arg2, int arg3, int arg4, List<Header> arg5, HeadersMode arg6)
    {
      // Byte code:
      //   0: return
      //   1: astore 5
      //   3: return
    }
    
    /* Error */
    public void ping(boolean arg1, int arg2, int arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore 4
      //   3: goto -3 -> 0
    }
    
    public void priority(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
    
    public void pushPromise(int paramInt1, int paramInt2, List<Header> paramList)
    {
      FramedConnection.this.pushRequestLater(paramInt2, paramList);
    }
    
    /* Error */
    public void rstStream(int arg1, ErrorCode arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void settings(boolean arg1, Settings arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: return
    }
    
    /* Error */
    public void windowUpdate(int arg1, long arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore 4
      //   3: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\framed\FramedConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */