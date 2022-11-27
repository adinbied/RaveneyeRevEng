package com.google.firebase.crashlytics.internal.network;

public enum HttpMethod
{
  static
  {
    HttpMethod localHttpMethod = new HttpMethod("DELETE", 3);
    DELETE = localHttpMethod;
    $VALUES = new HttpMethod[] { GET, POST, PUT, localHttpMethod };
  }
  
  private HttpMethod() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\network\HttpMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */