package dji.thirdparty.okhttp3.internal.http;

import dji.thirdparty.okhttp3.Request;
import dji.thirdparty.okhttp3.Response;
import dji.thirdparty.okhttp3.Response.Builder;
import dji.thirdparty.okhttp3.ResponseBody;
import dji.thirdparty.okio.Sink;
import java.io.IOException;

public abstract interface HttpStream
{
  public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;
  
  public abstract void cancel();
  
  public abstract Sink createRequestBody(Request paramRequest, long paramLong)
    throws IOException;
  
  public abstract void finishRequest()
    throws IOException;
  
  public abstract ResponseBody openResponseBody(Response paramResponse)
    throws IOException;
  
  public abstract Response.Builder readResponseHeaders()
    throws IOException;
  
  public abstract void setHttpEngine(HttpEngine paramHttpEngine);
  
  public abstract void writeRequestBody(RetryableSink paramRetryableSink)
    throws IOException;
  
  public abstract void writeRequestHeaders(Request paramRequest)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\http\HttpStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */