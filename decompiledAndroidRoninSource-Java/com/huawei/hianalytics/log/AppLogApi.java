package com.huawei.hianalytics.log;

import android.os.Bundle;
import com.huawei.hianalytics.g.b;
import com.huawei.hianalytics.log.g.a;

public class AppLogApi
{
  public static void checkUploadLog()
  {
    b.b("HiAnalytics/logServer", "AppLogApi.checkUploadLog() is execute.");
    a.c();
  }
  
  public static void collectErrorLog(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    b.b("HiAnalytics/logServer", "AppLogApi.collectErrorLog() is execute.");
    a.a(paramString1, paramString2, paramString3, paramBundle);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    b.b("HiAnalytics/logServer", "AppLogApi.d(String tag, String msg) is execute.");
    a.a(3, "D", paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    b.b("HiAnalytics/logServer", "AppLogApi.e(String tag, String msg) is execute.");
    a.a(6, "E", paramString1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    b.b("HiAnalytics/logServer", "AppLogApi.i(String tag, String msg) is execute.");
    a.a(4, "I", paramString1, paramString2);
  }
  
  public static void setLogSecret(String paramString1, String paramString2)
  {
    b.b("HiAnalytics/logServer", "AppLogApi.setLogSecret(String logServerID,String logSecret) is execute.");
    a.a(paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    b.b("HiAnalytics/logServer", "AppLogApi.w(String tag, String msg) is execute.");
    a.a(5, "W", paramString1, paramString2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\log\AppLogApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */