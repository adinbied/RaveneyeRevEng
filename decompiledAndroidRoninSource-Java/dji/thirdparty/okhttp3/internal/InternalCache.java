package dji.thirdparty.okhttp3.internal;

import dji.thirdparty.okhttp3.Request;
import dji.thirdparty.okhttp3.Response;
import dji.thirdparty.okhttp3.internal.http.CacheRequest;
import dji.thirdparty.okhttp3.internal.http.CacheStrategy;
import java.io.IOException;

public abstract interface InternalCache
{
  public abstract Response get(Request paramRequest)
    throws IOException;
  
  public abstract CacheRequest put(Response paramResponse)
    throws IOException;
  
  public abstract void remove(Request paramRequest)
    throws IOException;
  
  public abstract void trackConditionalCacheHit();
  
  public abstract void trackResponse(CacheStrategy paramCacheStrategy);
  
  public abstract void update(Response paramResponse1, Response paramResponse2)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\InternalCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */