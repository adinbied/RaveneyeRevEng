package dji.thirdparty.okhttp3.internal.http;

import dji.thirdparty.okhttp3.CacheControl;
import dji.thirdparty.okhttp3.Headers;
import dji.thirdparty.okhttp3.Request;
import dji.thirdparty.okhttp3.Response;
import java.util.Date;

public final class CacheStrategy
{
  public final Response cacheResponse;
  public final Request networkRequest;
  
  private CacheStrategy(Request paramRequest, Response paramResponse)
  {
    this.networkRequest = paramRequest;
    this.cacheResponse = paramResponse;
  }
  
  public static boolean isCacheable(Response paramResponse, Request paramRequest)
  {
    int i = paramResponse.code();
    boolean bool2 = false;
    if ((i != 200) && (i != 410) && (i != 414) && (i != 501) && (i != 203) && (i != 204)) {
      if (i != 307)
      {
        if ((i == 308) || (i == 404) || (i == 405)) {}
      }
      else {
        switch (i)
        {
        default: 
          return false;
        case 302: 
          if ((paramResponse.header("Expires") == null) && (paramResponse.cacheControl().maxAgeSeconds() == -1) && (!paramResponse.cacheControl().isPublic()) && (!paramResponse.cacheControl().isPrivate())) {
            return false;
          }
          break;
        }
      }
    }
    boolean bool1 = bool2;
    if (!paramResponse.cacheControl().noStore())
    {
      bool1 = bool2;
      if (!paramRequest.cacheControl().noStore()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static class Factory
  {
    private int ageSeconds = -1;
    final Response cacheResponse;
    private String etag;
    private Date expires;
    private Date lastModified;
    private String lastModifiedString;
    final long nowMillis;
    private long receivedResponseMillis;
    final Request request;
    private long sentRequestMillis;
    private Date servedDate;
    private String servedDateString;
    
    public Factory(long paramLong, Request paramRequest, Response paramResponse)
    {
      this.nowMillis = paramLong;
      this.request = paramRequest;
      this.cacheResponse = paramResponse;
      if (paramResponse != null)
      {
        paramRequest = paramResponse.headers();
        int i = 0;
        int j = paramRequest.size();
        while (i < j)
        {
          paramResponse = paramRequest.name(i);
          String str = paramRequest.value(i);
          if ("Date".equalsIgnoreCase(paramResponse))
          {
            this.servedDate = HttpDate.parse(str);
            this.servedDateString = str;
          }
          else if ("Expires".equalsIgnoreCase(paramResponse))
          {
            this.expires = HttpDate.parse(str);
          }
          else if ("Last-Modified".equalsIgnoreCase(paramResponse))
          {
            this.lastModified = HttpDate.parse(str);
            this.lastModifiedString = str;
          }
          else if ("ETag".equalsIgnoreCase(paramResponse))
          {
            this.etag = str;
          }
          else if ("Age".equalsIgnoreCase(paramResponse))
          {
            this.ageSeconds = HeaderParser.parseSeconds(str, -1);
          }
          else if (OkHeaders.SENT_MILLIS.equalsIgnoreCase(paramResponse))
          {
            this.sentRequestMillis = Long.parseLong(str);
          }
          else if (OkHeaders.RECEIVED_MILLIS.equalsIgnoreCase(paramResponse))
          {
            this.receivedResponseMillis = Long.parseLong(str);
          }
          i += 1;
        }
      }
    }
    
    private long cacheResponseAge()
    {
      return 277750875L;
    }
    
    private long computeFreshnessLifetime()
    {
      return 277750885L;
    }
    
    private CacheStrategy getCandidate()
    {
      return null;
    }
    
    private static boolean hasConditions(Request paramRequest)
    {
      return (paramRequest.header("If-Modified-Since") != null) || (paramRequest.header("If-None-Match") != null);
    }
    
    private boolean isFreshnessLifetimeHeuristic()
    {
      return false;
    }
    
    public CacheStrategy get()
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\http\CacheStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */