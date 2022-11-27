package dji.thirdparty.retrofit2;

import dji.thirdparty.okhttp3.Headers;
import dji.thirdparty.okhttp3.Protocol;
import dji.thirdparty.okhttp3.Request.Builder;
import dji.thirdparty.okhttp3.Response.Builder;
import dji.thirdparty.okhttp3.ResponseBody;

public final class Response<T>
{
  private final T body;
  private final ResponseBody errorBody;
  private final dji.thirdparty.okhttp3.Response rawResponse;
  
  private Response(dji.thirdparty.okhttp3.Response paramResponse, T paramT, ResponseBody paramResponseBody)
  {
    this.rawResponse = paramResponse;
    this.body = paramT;
    this.errorBody = paramResponseBody;
  }
  
  public static <T> Response<T> error(int paramInt, ResponseBody paramResponseBody)
  {
    if (paramInt >= 400) {
      return error(paramResponseBody, new Response.Builder().code(paramInt).protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
    }
    paramResponseBody = new StringBuilder();
    paramResponseBody.append("code < 400: ");
    paramResponseBody.append(paramInt);
    throw new IllegalArgumentException(paramResponseBody.toString());
  }
  
  public static <T> Response<T> error(ResponseBody paramResponseBody, dji.thirdparty.okhttp3.Response paramResponse)
  {
    if (paramResponseBody != null)
    {
      if (paramResponse != null)
      {
        if (!paramResponse.isSuccessful()) {
          return new Response(paramResponse, null, paramResponseBody);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
      }
      throw new NullPointerException("rawResponse == null");
    }
    throw new NullPointerException("body == null");
  }
  
  public static <T> Response<T> success(T paramT)
  {
    return success(paramT, new Response.Builder().code(200).message("OK").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
  }
  
  public static <T> Response<T> success(T paramT, Headers paramHeaders)
  {
    if (paramHeaders != null) {
      return success(paramT, new Response.Builder().code(200).message("OK").protocol(Protocol.HTTP_1_1).headers(paramHeaders).request(new Request.Builder().url("http://localhost/").build()).build());
    }
    throw new NullPointerException("headers == null");
  }
  
  public static <T> Response<T> success(T paramT, dji.thirdparty.okhttp3.Response paramResponse)
  {
    if (paramResponse != null)
    {
      if (paramResponse.isSuccessful()) {
        return new Response(paramResponse, paramT, null);
      }
      throw new IllegalArgumentException("rawResponse must be successful response");
    }
    throw new NullPointerException("rawResponse == null");
  }
  
  public T body()
  {
    return (T)this.body;
  }
  
  public int code()
  {
    return this.rawResponse.code();
  }
  
  public ResponseBody errorBody()
  {
    return this.errorBody;
  }
  
  public Headers headers()
  {
    return this.rawResponse.headers();
  }
  
  public boolean isSuccessful()
  {
    return this.rawResponse.isSuccessful();
  }
  
  public String message()
  {
    return this.rawResponse.message();
  }
  
  public dji.thirdparty.okhttp3.Response raw()
  {
    return this.rawResponse;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\retrofit2\Response.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */