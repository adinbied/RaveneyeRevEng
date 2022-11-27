package com.huawei.appmarket.component.buoycircle.impl.update.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract interface IHttpRequestHelper
{
  public static final int HTTP_OK = 200;
  public static final int HTTP_PARTIAL = 206;
  
  public abstract void cancel();
  
  public abstract void close();
  
  public abstract int get(String paramString, OutputStream paramOutputStream)
    throws IOException, CanceledException;
  
  public abstract int get(String paramString, OutputStream paramOutputStream, int paramInt1, int paramInt2)
    throws IOException, CanceledException;
  
  public abstract int post(String paramString, InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException, CanceledException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\update\http\IHttpRequestHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */