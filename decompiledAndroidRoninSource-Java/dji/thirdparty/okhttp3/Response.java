package dji.thirdparty.okhttp3;

import java.io.IOException;
import java.util.List;

public final class Response
{
  private final ResponseBody body;
  private volatile CacheControl cacheControl;
  private Response cacheResponse;
  private final int code;
  private final Handshake handshake;
  private final Headers headers;
  private final String message;
  private Response networkResponse;
  private final Response priorResponse;
  private final Protocol protocol;
  private final Request request;
  
  private Response(Builder paramBuilder)
  {
    this.request = paramBuilder.request;
    this.protocol = paramBuilder.protocol;
    this.code = paramBuilder.code;
    this.message = paramBuilder.message;
    this.handshake = paramBuilder.handshake;
    this.headers = paramBuilder.headers.build();
    this.body = paramBuilder.body;
    this.networkResponse = paramBuilder.networkResponse;
    this.cacheResponse = paramBuilder.cacheResponse;
    this.priorResponse = paramBuilder.priorResponse;
  }
  
  public ResponseBody body()
  {
    return this.body;
  }
  
  public CacheControl cacheControl()
  {
    return null;
  }
  
  public Response cacheResponse()
  {
    return this.cacheResponse;
  }
  
  public List<Challenge> challenges()
  {
    return null;
  }
  
  public int code()
  {
    return this.code;
  }
  
  public Handshake handshake()
  {
    return this.handshake;
  }
  
  public String header(String paramString)
  {
    return header(paramString, null);
  }
  
  public String header(String paramString1, String paramString2)
  {
    return null;
  }
  
  public Headers headers()
  {
    return this.headers;
  }
  
  public List<String> headers(String paramString)
  {
    return this.headers.values(paramString);
  }
  
  public boolean isRedirect()
  {
    return false;
  }
  
  public boolean isSuccessful()
  {
    return false;
  }
  
  public String message()
  {
    return this.message;
  }
  
  public Response networkResponse()
  {
    return this.networkResponse;
  }
  
  public Builder newBuilder()
  {
    return new Builder(this, null);
  }
  
  public ResponseBody peekBody(long paramLong)
    throws IOException
  {
    return null;
  }
  
  public Response priorResponse()
  {
    return this.priorResponse;
  }
  
  public Protocol protocol()
  {
    return this.protocol;
  }
  
  public Request request()
  {
    return this.request;
  }
  
  public String toString()
  {
    return null;
  }
  
  public static class Builder
  {
    private ResponseBody body;
    private Response cacheResponse;
    private int code = -1;
    private Handshake handshake;
    private Headers.Builder headers;
    private String message;
    private Response networkResponse;
    private Response priorResponse;
    private Protocol protocol;
    private Request request;
    
    public Builder()
    {
      this.headers = new Headers.Builder();
    }
    
    private Builder(Response paramResponse)
    {
      this.request = paramResponse.request;
      this.protocol = paramResponse.protocol;
      this.code = paramResponse.code;
      this.message = paramResponse.message;
      this.handshake = paramResponse.handshake;
      this.headers = paramResponse.headers.newBuilder();
      this.body = paramResponse.body;
      this.networkResponse = paramResponse.networkResponse;
      this.cacheResponse = paramResponse.cacheResponse;
      this.priorResponse = paramResponse.priorResponse;
    }
    
    /* Error */
    private void checkPriorResponse(Response arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void checkSupportResponse(String arg1, Response arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public Builder addHeader(String paramString1, String paramString2)
    {
      this.headers.add(paramString1, paramString2);
      return this;
    }
    
    public Builder body(ResponseBody paramResponseBody)
    {
      this.body = paramResponseBody;
      return this;
    }
    
    public Response build()
    {
      return null;
    }
    
    public Builder cacheResponse(Response paramResponse)
    {
      return null;
    }
    
    public Builder code(int paramInt)
    {
      this.code = paramInt;
      return this;
    }
    
    public Builder handshake(Handshake paramHandshake)
    {
      this.handshake = paramHandshake;
      return this;
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
    
    public Builder message(String paramString)
    {
      this.message = paramString;
      return this;
    }
    
    public Builder networkResponse(Response paramResponse)
    {
      return null;
    }
    
    public Builder priorResponse(Response paramResponse)
    {
      if (paramResponse != null) {
        checkPriorResponse(paramResponse);
      }
      this.priorResponse = paramResponse;
      return this;
    }
    
    public Builder protocol(Protocol paramProtocol)
    {
      this.protocol = paramProtocol;
      return this;
    }
    
    public Builder removeHeader(String paramString)
    {
      this.headers.removeAll(paramString);
      return this;
    }
    
    public Builder request(Request paramRequest)
    {
      this.request = paramRequest;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\Response.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */