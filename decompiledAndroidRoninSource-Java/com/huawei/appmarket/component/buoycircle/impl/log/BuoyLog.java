package com.huawei.appmarket.component.buoycircle.impl.log;

import android.util.Log;

public class BuoyLog
{
  public static void d(String paramString1, String paramString2) {}
  
  public static void e(String paramString1, long paramLong, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("] ");
    localStringBuilder.append(paramString2);
    Log.e(paramString1, localStringBuilder.toString());
  }
  
  public static void e(String paramString1, long paramLong, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("] ");
    localStringBuilder.append(paramString2);
    Log.e(paramString1, localStringBuilder.toString(), paramThrowable);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    Log.e(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    Log.i(paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    Log.w(paramString1, paramString2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\impl\log\BuoyLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */