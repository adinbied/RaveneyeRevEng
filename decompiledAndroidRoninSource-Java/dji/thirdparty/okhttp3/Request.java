package dji.thirdparty.okhttp3;

import java.net.URI;
import java.net.URL;
import java.util.List;

public final class Request
{
  private final RequestBody body;
  private volatile CacheControl cacheControl;
  private final Headers headers;
  private volatile URI javaNetUri;
  private final String method;
  private final Object tag;
  private final HttpUrl url;
  
  private Request(Builder paramBuilder)
  {
    this.url = paramBuilder.url;
    this.method = paramBuilder.method;
    this.headers = paramBuilder.headers.build();
    this.body = paramBuilder.body;
    if (paramBuilder.tag != null) {
      paramBuilder = paramBuilder.tag;
    } else {
      paramBuilder = this;
    }
    this.tag = paramBuilder;
  }
  
  public RequestBody body()
  {
    return this.body;
  }
  
  public CacheControl cacheControl()
  {
    return null;
  }
  
  public String header(String paramString)
  {
    return this.headers.get(paramString);
  }
  
  public Headers headers()
  {
    return this.headers;
  }
  
  public List<String> headers(String paramString)
  {
    return this.headers.values(paramString);
  }
  
  public boolean isHttps()
  {
    return this.url.isHttps();
  }
  
  public String method()
  {
    return this.method;
  }
  
  public Builder newBuilder()
  {
    return new Builder(this, null);
  }
  
  public Object tag()
  {
    return this.tag;
  }
  
  public String toString()
  {
    return null;
  }
  
  public HttpUrl url()
  {
    return this.url;
  }
  
  public static class Builder
  {
    private RequestBody body;
    private Headers.Builder headers;
    private String method;
    private Object tag;
    private HttpUrl url;
    
    public Builder()
    {
      this.method = "GET";
      this.headers = new Headers.Builder();
    }
    
    private Builder(Request paramRequest)
    {
      this.url = paramRequest.url;
      this.method = paramRequest.method;
      this.body = paramRequest.body;
      this.tag = paramRequest.tag;
      this.headers = paramRequest.headers.newBuilder();
    }
    
    public Builder addHeader(String paramString1, String paramString2)
    {
      this.headers.add(paramString1, paramString2);
      return this;
    }
    
    public Request build()
    {
      return null;
    }
    
    public Builder cacheControl(CacheControl paramCacheControl)
    {
      return null;
    }
    
    public Builder delete()
    {
      return null;
    }
    
    public Builder delete(RequestBody paramRequestBody)
    {
      return method("DELETE", paramRequestBody);
    }
    
    public Builder get()
    {
      return method("GET", null);
    }
    
    public Builder head()
    {
      return method("HEAD", null);
    }
    
    public Builder header(String paramString1, String paramString2)
    {
      this.headers.set(paramString1, paramString2);
      return this;
    }
    
    public Builder headers(Headers paramHeaders)
    {
      this.headers = paramHeaders.newBuilder();
      return this;
    }
    
    public Builder method(String paramString, RequestBody paramRequestBody)
    {
      return null;
    }
    
    public Builder patch(RequestBody paramRequestBody)
    {
      return method("PATCH", paramRequestBody);
    }
    
    public Builder post(RequestBody paramRequestBody)
    {
      return method("POST", paramRequestBody);
    }
    
    public Builder put(RequestBody paramRequestBody)
    {
      return method("PUT", paramRequestBody);
    }
    
    public Builder removeHeader(String paramString)
    {
      this.headers.removeAll(paramString);
      return this;
    }
    
    public Builder tag(Object paramObject)
    {
      this.tag = paramObject;
      return this;
    }
    
    public Builder url(HttpUrl paramHttpUrl)
    {
      return null;
    }
    
    public Builder url(String paramString)
    {
      return null;
    }
    
    public Builder url(URL paramURL)
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\Request.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */