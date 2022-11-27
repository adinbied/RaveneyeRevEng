package com.tencent.bugly.crashreport;

import android.util.Log;
import com.tencent.bugly.b;
import com.tencent.bugly.proguard.y;

public class BuglyLog
{
  public static void d(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "null";
    }
    if (b.c) {
      Log.d(str, paramString1);
    }
    y.a("D", str, paramString1);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "null";
    }
    if (b.c) {
      Log.e(str, paramString1);
    }
    y.a("E", str, paramString1);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "null";
    }
    if (b.c) {
      Log.e(str, paramString1, paramThrowable);
    }
    y.a("E", str, paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "null";
    }
    if (b.c) {
      Log.i(str, paramString1);
    }
    y.a("I", str, paramString1);
  }
  
  public static void setCache(int paramInt)
  {
    y.a(paramInt);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "null";
    }
    if (b.c) {
      Log.v(str, paramString1);
    }
    y.a("V", str, paramString1);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "null";
    }
    if (b.c) {
      Log.w(str, paramString1);
    }
    y.a("W", str, paramString1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\crashreport\BuglyLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */