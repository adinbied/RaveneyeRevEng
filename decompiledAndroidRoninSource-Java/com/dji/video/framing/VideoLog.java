package com.dji.video.framing;

import android.util.Log;
import dji.log.DJILog;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VideoLog
{
  private static boolean DEBUG_ACTIVE = false;
  private static final String TAG = "VideoLog";
  private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    if (DEBUG_ACTIVE)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(df.format(new Date()));
      localStringBuilder.append(":  ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(Log.getStackTraceString(paramThrowable));
      DJILog.logWriteD(paramString1, localStringBuilder.toString(), "DECODER", paramVarArgs);
    }
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (DEBUG_ACTIVE)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(df.format(new Date()));
      localStringBuilder.append(":  ");
      localStringBuilder.append(paramString2);
      DJILog.logWriteD(paramString1, localStringBuilder.toString(), "DECODER", paramVarArgs);
    }
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    if (DEBUG_ACTIVE)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(df.format(new Date()));
      localStringBuilder.append(":  ");
      localStringBuilder.append(paramString);
      DJILog.logWriteD("VideoLog", localStringBuilder.toString(), "DECODER", paramVarArgs);
    }
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(df.format(new Date()));
    localStringBuilder.append(":  ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(Log.getStackTraceString(paramThrowable));
    DJILog.logWriteE(paramString1, localStringBuilder.toString(), "DECODER", paramVarArgs);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(df.format(new Date()));
    localStringBuilder.append(":  ");
    localStringBuilder.append(paramString2);
    DJILog.logWriteE(paramString1, localStringBuilder.toString(), "DECODER", paramVarArgs);
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(df.format(new Date()));
    localStringBuilder.append(":  ");
    localStringBuilder.append(paramString);
    DJILog.logWriteE("VideoLog", localStringBuilder.toString(), "DECODER", paramVarArgs);
  }
  
  public static boolean getVideoDebugSwitch()
  {
    return DEBUG_ACTIVE;
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    if (DEBUG_ACTIVE)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(df.format(new Date()));
      localStringBuilder.append(":  ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(Log.getStackTraceString(paramThrowable));
      DJILog.logWriteI(paramString1, localStringBuilder.toString(), "DECODER", paramVarArgs);
    }
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (DEBUG_ACTIVE)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(df.format(new Date()));
      localStringBuilder.append(":  ");
      localStringBuilder.append(paramString2);
      DJILog.logWriteI(paramString1, localStringBuilder.toString(), "DECODER", paramVarArgs);
    }
  }
  
  public static void i(String paramString, Object... paramVarArgs)
  {
    if (DEBUG_ACTIVE)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(df.format(new Date()));
      localStringBuilder.append(":  ");
      localStringBuilder.append(paramString);
      DJILog.logWriteI("VideoLog", localStringBuilder.toString(), "DECODER", paramVarArgs);
    }
  }
  
  public static void setVideoDebugSwitch(boolean paramBoolean)
  {
    DEBUG_ACTIVE = paramBoolean;
  }
  
  public static void v(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    if (DEBUG_ACTIVE)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(df.format(new Date()));
      localStringBuilder.append(":  ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(Log.getStackTraceString(paramThrowable));
      DJILog.logWriteV(paramString1, localStringBuilder.toString(), "DECODER", paramVarArgs);
    }
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (DEBUG_ACTIVE)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(df.format(new Date()));
      localStringBuilder.append(":  ");
      localStringBuilder.append(paramString2);
      DJILog.logWriteV(paramString1, localStringBuilder.toString(), "DECODER", paramVarArgs);
    }
  }
  
  public static void v(String paramString, Object... paramVarArgs)
  {
    if (DEBUG_ACTIVE)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(df.format(new Date()));
      localStringBuilder.append(":  ");
      localStringBuilder.append(paramString);
      DJILog.logWriteV("VideoLog", localStringBuilder.toString(), "DECODER", paramVarArgs);
    }
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(df.format(new Date()));
    localStringBuilder.append(":  ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(Log.getStackTraceString(paramThrowable));
    DJILog.logWriteW(paramString1, localStringBuilder.toString(), "DECODER", paramVarArgs);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(df.format(new Date()));
    localStringBuilder.append(":  ");
    localStringBuilder.append(paramString2);
    DJILog.logWriteW(paramString1, localStringBuilder.toString(), "DECODER", paramVarArgs);
  }
  
  public static void w(String paramString, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(df.format(new Date()));
    localStringBuilder.append(":  ");
    localStringBuilder.append(paramString);
    DJILog.logWriteW("VideoLog", localStringBuilder.toString(), "DECODER", paramVarArgs);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\VideoLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */