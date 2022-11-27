package com.huawei.android.hms.agent.common;

import android.util.Log;

public final class HMSAgentLog
{
  private static final int PRINT_STACK_COUTN = 2;
  private static final int START_STACK_INDEX = 4;
  private static IHMSAgentLogCallback logCallback;
  
  private static void appendStack(StringBuilder paramStringBuilder)
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    if ((arrayOfStackTraceElement != null) && (arrayOfStackTraceElement.length > 4))
    {
      int i = Math.min(arrayOfStackTraceElement.length - 1, 6);
      while (i >= 4)
      {
        if (arrayOfStackTraceElement[i] != null)
        {
          String str2 = arrayOfStackTraceElement[i].getFileName();
          String str1 = str2;
          if (str2 != null)
          {
            int j = str2.indexOf('.');
            str1 = str2;
            if (j > 0) {
              str1 = str2.substring(0, j);
            }
          }
          paramStringBuilder.append(str1);
          paramStringBuilder.append('(');
          paramStringBuilder.append(arrayOfStackTraceElement[i].getLineNumber());
          paramStringBuilder.append(")");
          paramStringBuilder.append("->");
        }
        i -= 1;
      }
      paramStringBuilder.append(arrayOfStackTraceElement[4].getMethodName());
    }
    paramStringBuilder.append('\n');
  }
  
  public static void d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    appendStack(localStringBuilder);
    localStringBuilder.append(paramString);
    paramString = logCallback;
    if (paramString != null)
    {
      paramString.logD("HMSAgent", localStringBuilder.toString());
      return;
    }
    Log.d("HMSAgent", localStringBuilder.toString());
  }
  
  public static void e(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    appendStack(localStringBuilder);
    localStringBuilder.append(paramString);
    paramString = logCallback;
    if (paramString != null)
    {
      paramString.logE("HMSAgent", localStringBuilder.toString());
      return;
    }
    Log.e("HMSAgent", localStringBuilder.toString());
  }
  
  public static void i(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    appendStack(localStringBuilder);
    localStringBuilder.append(paramString);
    paramString = logCallback;
    if (paramString != null)
    {
      paramString.logI("HMSAgent", localStringBuilder.toString());
      return;
    }
    Log.i("HMSAgent", localStringBuilder.toString());
  }
  
  public static void setHMSAgentLogCallback(IHMSAgentLogCallback paramIHMSAgentLogCallback)
  {
    logCallback = paramIHMSAgentLogCallback;
  }
  
  public static void v(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    appendStack(localStringBuilder);
    localStringBuilder.append(paramString);
    paramString = logCallback;
    if (paramString != null)
    {
      paramString.logV("HMSAgent", localStringBuilder.toString());
      return;
    }
    Log.v("HMSAgent", localStringBuilder.toString());
  }
  
  public static void w(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    appendStack(localStringBuilder);
    localStringBuilder.append(paramString);
    paramString = logCallback;
    if (paramString != null)
    {
      paramString.logW("HMSAgent", localStringBuilder.toString());
      return;
    }
    Log.w("HMSAgent", localStringBuilder.toString());
  }
  
  public static abstract interface IHMSAgentLogCallback
  {
    public abstract void logD(String paramString1, String paramString2);
    
    public abstract void logE(String paramString1, String paramString2);
    
    public abstract void logI(String paramString1, String paramString2);
    
    public abstract void logV(String paramString1, String paramString2);
    
    public abstract void logW(String paramString1, String paramString2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\android\hms\agent\common\HMSAgentLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */