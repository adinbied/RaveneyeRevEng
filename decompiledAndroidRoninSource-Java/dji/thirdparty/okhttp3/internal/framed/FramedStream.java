package dji.thirdparty.okhttp3.internal.framed;

import dji.thirdparty.okio.AsyncTimeout;
import dji.thirdparty.okio.Buffer;
import dji.thirdparty.okio.BufferedSource;
import dji.thirdparty.okio.Sink;
import dji.thirdparty.okio.Source;
import dji.thirdparty.okio.Timeout;
import java.io.IOException;
import java.util.List;

public final class FramedStream
{
  long bytesLeftInWriteWindow;
  private final FramedConnection connection;
  private ErrorCode errorCode = null;
  private final int id;
  private final StreamTimeout readTimeout = new StreamTimeout();
  private final List<Header> requestHeaders;
  private List<Header> responseHeaders;
  final FramedDataSink sink;
  private final FramedDataSource source;
  long unacknowledgedBytesRead = 0L;
  private final StreamTimeout writeTimeout = new StreamTimeout();
  
  FramedStream(int paramInt, FramedConnection paramFramedConnection, boolean paramBoolean1, boolean paramBoolean2, List<Header> paramList)
  {
    if (paramFramedConnection != null)
    {
      if (paramList != null)
      {
        this.id = paramInt;
        this.connection = paramFramedConnection;
        this.bytesLeftInWriteWindow = paramFramedConnection.peerSettings.getInitialWindowSize(65536);
        this.source = new FramedDataSource(paramFramedConnection.okHttpSettings.getInitialWindowSize(65536), null);
        this.sink = new FramedDataSink();
        FramedDataSource.access$102(this.source, paramBoolean2);
        FramedDataSink.access$202(this.sink, paramBoolean1);
        this.requestHeaders = paramList;
        return;
      }
      throw new NullPointerException("requestHeaders == null");
    }
    throw new NullPointerException("connection == null");
  }
  
  /* Error */
  private void cancelStreamIfNecessary()
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void checkOutNotClosed()
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean closeInternal(ErrorCode paramErrorCode)
  {
    return false;
  }
  
  /* Error */
  private void waitForIo()
    throws java.io.InterruptedIOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  void addBytesToWriteWindow(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void close(ErrorCode arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void closeLater(ErrorCode arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public FramedConnection getConnection()
  {
    return this.connection;
  }
  
  public ErrorCode getErrorCode()
  {
    try
    {
      ErrorCode localErrorCode = this.errorCode;
      return localErrorCode;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public List<Header> getRequestHeaders()
  {
    return this.requestHeaders;
  }
  
  public List<Header> getResponseHeaders()
    throws IOException
  {
    return null;
  }
  
  public Sink getSink()
  {
    return null;
  }
  
  public Source getSource()
  {
    return this.source;
  }
  
  public boolean isLocallyInitiated()
  {
    return false;
  }
  
  public boolean isOpen()
  {
    return false;
  }
  
  public Timeout readTimeout()
  {
    return this.readTimeout;
  }
  
  void receiveData(BufferedSource paramBufferedSource, int paramInt)
    throws IOException
  {
    this.source.receive(paramBufferedSource, paramInt);
  }
  
  /* Error */
  void receiveFin()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  void receiveHeaders(List<Header> arg1, HeadersMode arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  void receiveRstStream(ErrorCode arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void reply(List<Header> arg1, boolean arg2)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public Timeout writeTimeout()
  {
    return this.writeTimeout;
  }
  
  final class FramedDataSink
    implements Sink
  {
    private static final long EMIT_BUFFER_SIZE = 16384L;
    private boolean closed;
    private boolean finished;
    private final Buffer sendBuffer = new Buffer();
    
    FramedDataSink() {}
    
    /* Error */
    private void emitDataFrame(boolean arg1)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: return
    }
    
    /* Error */
    public void close()
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void flush()
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public Timeout timeout()
    {
      return FramedStream.this.writeTimeout;
    }
    
    /* Error */
    public void write(Buffer arg1, long arg2)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  private final class FramedDataSource
    implements Source
  {
    private boolean closed;
    private boolean finished;
    private final long maxByteCount;
    private final Buffer readBuffer = new Buffer();
    private final Buffer receiveBuffer = new Buffer();
    
    private FramedDataSource(long paramLong)
    {
      this.maxByteCount = paramLong;
    }
    
    /* Error */
    private void checkNotClosed()
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void waitUntilReadable()
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void close()
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      return 277867178L;
    }
    
    /* Error */
    void receive(BufferedSource arg1, long arg2)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public Timeout timeout()
    {
      return FramedStream.this.readTimeout;
    }
  }
  
  class StreamTimeout
    extends AsyncTimeout
  {
    StreamTimeout() {}
    
    /* Error */
    public void exitAndThrowIfTimedOut()
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    protected IOException newTimeoutException(IOException paramIOException)
    {
      return null;
    }
    
    protected void timedOut()
    {
      FramedStream.this.closeLater(ErrorCode.CANCEL);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\framed\FramedStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */