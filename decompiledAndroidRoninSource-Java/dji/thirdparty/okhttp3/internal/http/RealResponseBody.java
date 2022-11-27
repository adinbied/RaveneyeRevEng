package dji.thirdparty.okhttp3.internal.http;

import dji.thirdparty.okhttp3.Headers;
import dji.thirdparty.okhttp3.MediaType;
import dji.thirdparty.okhttp3.ResponseBody;
import dji.thirdparty.okio.BufferedSource;

public final class RealResponseBody
  extends ResponseBody
{
  private final Headers headers;
  private final BufferedSource source;
  
  public RealResponseBody(Headers paramHeaders, BufferedSource paramBufferedSource)
  {
    this.headers = paramHeaders;
    this.source = paramBufferedSource;
  }
  
  public long contentLength()
  {
    return OkHeaders.contentLength(this.headers);
  }
  
  public MediaType contentType()
  {
    return null;
  }
  
  public BufferedSource source()
  {
    return this.source;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\http\RealResponseBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */