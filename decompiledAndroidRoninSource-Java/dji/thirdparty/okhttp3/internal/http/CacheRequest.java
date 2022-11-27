package dji.thirdparty.okhttp3.internal.http;

import dji.thirdparty.okio.Sink;
import java.io.IOException;

public abstract interface CacheRequest
{
  public abstract void abort();
  
  public abstract Sink body()
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\http\CacheRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */