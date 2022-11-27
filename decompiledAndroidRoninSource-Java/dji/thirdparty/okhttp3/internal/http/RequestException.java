package dji.thirdparty.okhttp3.internal.http;

import java.io.IOException;

public final class RequestException
  extends Exception
{
  public RequestException(IOException paramIOException)
  {
    super(paramIOException);
  }
  
  public IOException getCause()
  {
    return (IOException)super.getCause();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\http\RequestException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */