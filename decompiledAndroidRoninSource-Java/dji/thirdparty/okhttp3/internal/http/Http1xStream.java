package dji.thirdparty.okhttp3.internal.http;

import dji.thirdparty.okhttp3.Headers;
import dji.thirdparty.okhttp3.Request;
import dji.thirdparty.okhttp3.Response;
import dji.thirdparty.okhttp3.Response.Builder;
import dji.thirdparty.okhttp3.ResponseBody;
import dji.thirdparty.okio.Buffer;
import dji.thirdparty.okio.BufferedSink;
import dji.thirdparty.okio.BufferedSource;
import dji.thirdparty.okio.ForwardingTimeout;
import dji.thirdparty.okio.Sink;
import dji.thirdparty.okio.Source;
import dji.thirdparty.okio.Timeout;
import java.io.IOException;

public final class Http1xStream
  implements HttpStream
{
  private static final int STATE_CLOSED = 6;
  private static final int STATE_IDLE = 0;
  private static final int STATE_OPEN_REQUEST_BODY = 1;
  private static final int STATE_OPEN_RESPONSE_BODY = 4;
  private static final int STATE_READING_RESPONSE_BODY = 5;
  private static final int STATE_READ_RESPONSE_HEADERS = 3;
  private static final int STATE_WRITING_REQUEST_BODY = 2;
  private HttpEngine httpEngine;
  private final BufferedSink sink;
  private final BufferedSource source;
  private int state = 0;
  private final StreamAllocation streamAllocation;
  
  public Http1xStream(StreamAllocation paramStreamAllocation, BufferedSource paramBufferedSource, BufferedSink paramBufferedSink)
  {
    this.streamAllocation = paramStreamAllocation;
    this.source = paramBufferedSource;
    this.sink = paramBufferedSink;
  }
  
  /* Error */
  private void detachTimeout(ForwardingTimeout arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private Source getTransferStream(Response paramResponse)
    throws IOException
  {
    return null;
  }
  
  /* Error */
  public void cancel()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Sink createRequestBody(Request paramRequest, long paramLong)
    throws IOException
  {
    return null;
  }
  
  public void finishRequest()
    throws IOException
  {
    this.sink.flush();
  }
  
  public boolean isClosed()
  {
    return false;
  }
  
  public Sink newChunkedSink()
  {
    return null;
  }
  
  public Source newChunkedSource(HttpEngine paramHttpEngine)
    throws IOException
  {
    return null;
  }
  
  public Sink newFixedLengthSink(long paramLong)
  {
    return null;
  }
  
  public Source newFixedLengthSource(long paramLong)
    throws IOException
  {
    return null;
  }
  
  public Source newUnknownLengthSource()
    throws IOException
  {
    return null;
  }
  
  public ResponseBody openResponseBody(Response paramResponse)
    throws IOException
  {
    return null;
  }
  
  public Headers readHeaders()
    throws IOException
  {
    return null;
  }
  
  public Response.Builder readResponse()
    throws IOException
  {
    return null;
  }
  
  public Response.Builder readResponseHeaders()
    throws IOException
  {
    return readResponse();
  }
  
  public void setHttpEngine(HttpEngine paramHttpEngine)
  {
    this.httpEngine = paramHttpEngine;
  }
  
  /* Error */
  public void writeRequest(Headers arg1, String arg2)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void writeRequestBody(RetryableSink arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void writeRequestHeaders(Request arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private abstract class AbstractSource
    implements Source
  {
    protected boolean closed;
    protected final ForwardingTimeout timeout = new ForwardingTimeout(Http1xStream.this.source.timeout());
    
    private AbstractSource() {}
    
    /* Error */
    protected final void endOfInput(boolean arg1)
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    public Timeout timeout()
    {
      return this.timeout;
    }
  }
  
  private final class ChunkedSink
    implements Sink
  {
    private boolean closed;
    private final ForwardingTimeout timeout = new ForwardingTimeout(Http1xStream.this.sink.timeout());
    
    private ChunkedSink() {}
    
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
      return this.timeout;
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
  
  private class ChunkedSource
    extends Http1xStream.AbstractSource
  {
    private static final long NO_CHUNK_YET = -1L;
    private long bytesRemainingInChunk = -1L;
    private boolean hasMoreChunks = true;
    private final HttpEngine httpEngine;
    
    ChunkedSource(HttpEngine paramHttpEngine)
      throws IOException
    {
      super(null);
      this.httpEngine = paramHttpEngine;
    }
    
    /* Error */
    private void readChunkSize()
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
      //   2: goto -2 -> 0
    }
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      return 277961471L;
    }
  }
  
  private final class FixedLengthSink
    implements Sink
  {
    private long bytesRemaining;
    private boolean closed;
    private final ForwardingTimeout timeout = new ForwardingTimeout(Http1xStream.this.sink.timeout());
    
    private FixedLengthSink(long paramLong)
    {
      this.bytesRemaining = paramLong;
    }
    
    /* Error */
    public void close()
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void flush()
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public Timeout timeout()
    {
      return this.timeout;
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
  
  private class FixedLengthSource
    extends Http1xStream.AbstractSource
  {
    private long bytesRemaining;
    
    public FixedLengthSource(long paramLong)
      throws IOException
    {
      super(null);
      this.bytesRemaining = paramLong;
      if (paramLong == 0L) {
        endOfInput(true);
      }
    }
    
    /* Error */
    public void close()
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      return 277961511L;
    }
  }
  
  private class UnknownLengthSource
    extends Http1xStream.AbstractSource
  {
    private boolean inputExhausted;
    
    private UnknownLengthSource()
    {
      super(null);
    }
    
    /* Error */
    public void close()
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      return 277961553L;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\http\Http1xStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */