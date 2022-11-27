package com.huawei.appmarket.component.buoycircle.impl.utils;

import com.huawei.appmarket.component.buoycircle.impl.log.BuoyLog;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class IOUtil
{
  private static final String TAG = "IOUtil";
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      for (;;) {}
    }
    BuoyLog.e("IOUtil", "An exception occurred while closing the 'Closeable' object.");
  }
  
  public static void closeQuietly(InputStream paramInputStream)
  {
    closeQuietly(paramInputStream);
  }
  
  public static void closeQuietly(OutputStream paramOutputStream)
  {
    closeQuietly(paramOutputStream);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\utils\IOUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */