package io.flutter;

public class Log
{
  private static int logLevel = 3;
  
  public static void d(String paramString1, String paramString2) {}
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable) {}
  
  public static void e(String paramString1, String paramString2)
  {
    android.util.Log.e(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    android.util.Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2) {}
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable) {}
  
  public static void setLogLevel(int paramInt)
  {
    logLevel = paramInt;
  }
  
  public static void v(String paramString1, String paramString2) {}
  
  public static void v(String paramString1, String paramString2, Throwable paramThrowable) {}
  
  public static void w(String paramString1, String paramString2)
  {
    android.util.Log.w(paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    android.util.Log.w(paramString1, paramString2, paramThrowable);
  }
  
  public static void wtf(String paramString1, String paramString2)
  {
    android.util.Log.wtf(paramString1, paramString2);
  }
  
  public static void wtf(String paramString1, String paramString2, Throwable paramThrowable)
  {
    android.util.Log.wtf(paramString1, paramString2, paramThrowable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\Log.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */