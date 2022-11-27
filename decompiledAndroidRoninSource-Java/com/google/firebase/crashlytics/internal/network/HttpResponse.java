package com.google.firebase.crashlytics.internal.network;

import java.io.IOException;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class HttpResponse
{
  private String body;
  private int code;
  private Headers headers;
  
  HttpResponse(int paramInt, String paramString, Headers paramHeaders)
  {
    this.code = paramInt;
    this.body = paramString;
    this.headers = paramHeaders;
  }
  
  static HttpResponse create(Response paramResponse)
    throws IOException
  {
    String str;
    if (paramResponse.body() == null) {
      str = null;
    } else {
      str = paramResponse.body().string();
    }
    return new HttpResponse(paramResponse.code(), str, paramResponse.headers());
  }
  
  public String body()
  {
    return this.body;
  }
  
  public int code()
  {
    return this.code;
  }
  
  public String header(String paramString)
  {
    return this.headers.get(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\network\HttpResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */