package com.google.firebase.crashlytics.internal.network;

import java.util.Collections;
import java.util.Map;

public class HttpRequestFactory
{
  public HttpRequest buildHttpRequest(HttpMethod paramHttpMethod, String paramString)
  {
    return buildHttpRequest(paramHttpMethod, paramString, Collections.emptyMap());
  }
  
  public HttpRequest buildHttpRequest(HttpMethod paramHttpMethod, String paramString, Map<String, String> paramMap)
  {
    return new HttpRequest(paramHttpMethod, paramString, paramMap);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\network\HttpRequestFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */