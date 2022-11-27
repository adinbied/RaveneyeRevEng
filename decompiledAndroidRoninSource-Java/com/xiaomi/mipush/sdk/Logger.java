package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ai;
import com.xiaomi.push.dn;
import com.xiaomi.push.do;
import java.io.File;

public class Logger
{
  private static boolean sDisablePushLog;
  private static LoggerInterface sUserLogger;
  
  public static void disablePushFileLog(Context paramContext)
  {
    sDisablePushLog = true;
    setPushLog(paramContext);
  }
  
  public static void enablePushFileLog(Context paramContext)
  {
    sDisablePushLog = false;
    setPushLog(paramContext);
  }
  
  public static File getLogFile(String paramString)
  {
    try
    {
      paramString = new File(paramString);
      if (paramString.exists())
      {
        if (!paramString.isDirectory()) {
          return null;
        }
        paramString = paramString.listFiles();
        int i = 0;
        while (i < paramString.length)
        {
          if ((paramString[i].isFile()) && (!paramString[i].getName().contains("lock")) && (paramString[i].getName().contains("log")))
          {
            paramString = paramString[i];
            return paramString;
          }
          i += 1;
        }
      }
      return null;
    }
    catch (NullPointerException paramString)
    {
      for (;;) {}
    }
    b.d("null pointer exception while retrieve file.");
    return null;
  }
  
  protected static LoggerInterface getUserLogger()
  {
    return sUserLogger;
  }
  
  private static boolean hasWritePermission(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 4096).requestedPermissions;
      if (paramContext != null)
      {
        int j = paramContext.length;
        int i = 0;
        while (i < j)
        {
          boolean bool = "android.permission.WRITE_EXTERNAL_STORAGE".equals(paramContext[i]);
          if (bool) {
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static void setLogger(Context paramContext, LoggerInterface paramLoggerInterface)
  {
    sUserLogger = paramLoggerInterface;
    setPushLog(paramContext);
  }
  
  public static void setPushLog(Context paramContext)
  {
    LoggerInterface localLoggerInterface = sUserLogger;
    int j = 0;
    if (localLoggerInterface != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (!sDisablePushLog)
    {
      boolean bool = hasWritePermission(paramContext);
      j = i;
      if (bool)
      {
        j = 1;
        break label52;
      }
    }
    int k = 0;
    int i = j;
    j = k;
    label52:
    do localdo = null;
    if (i == 1) {
      localLoggerInterface = sUserLogger;
    } else {
      localLoggerInterface = null;
    }
    if (j == 1) {
      localdo = new do(paramContext);
    }
    b.a(new dn(localLoggerInterface, localdo));
  }
  
  public static void uploadLogFile(Context paramContext, boolean paramBoolean)
  {
    ai.a(paramContext).a(new u(paramContext, paramBoolean));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */