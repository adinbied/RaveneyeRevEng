package com.facebook.common.logging;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;

public class FLogDefaultLoggingDelegate
  implements LoggingDelegate
{
  public static final FLogDefaultLoggingDelegate sInstance = new FLogDefaultLoggingDelegate();
  private String mApplicationTag = "unknown";
  private int mMinimumLoggingLevel = 5;
  
  public static FLogDefaultLoggingDelegate getInstance()
  {
    return sInstance;
  }
  
  private static String getMsg(String paramString, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append('\n');
    localStringBuilder.append(getStackTraceString(paramThrowable));
    return localStringBuilder.toString();
  }
  
  private static String getStackTraceString(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  private String prefixTag(String paramString)
  {
    Object localObject = paramString;
    if (this.mApplicationTag != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.mApplicationTag);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    return (String)localObject;
  }
  
  private void println(int paramInt, String paramString1, String paramString2)
  {
    Log.println(paramInt, prefixTag(paramString1), paramString2);
  }
  
  private void println(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.println(paramInt, prefixTag(paramString1), getMsg(paramString2, paramThrowable));
  }
  
  public void d(String paramString1, String paramString2)
  {
    println(3, paramString1, paramString2);
  }
  
  public void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    println(3, paramString1, paramString2, paramThrowable);
  }
  
  public void e(String paramString1, String paramString2)
  {
    println(6, paramString1, paramString2);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    println(6, paramString1, paramString2, paramThrowable);
  }
  
  public int getMinimumLoggingLevel()
  {
    return this.mMinimumLoggingLevel;
  }
  
  public void i(String paramString1, String paramString2)
  {
    println(4, paramString1, paramString2);
  }
  
  public void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    println(4, paramString1, paramString2, paramThrowable);
  }
  
  public boolean isLoggable(int paramInt)
  {
    return this.mMinimumLoggingLevel <= paramInt;
  }
  
  public void log(int paramInt, String paramString1, String paramString2)
  {
    println(paramInt, paramString1, paramString2);
  }
  
  public void setApplicationTag(String paramString)
  {
    this.mApplicationTag = paramString;
  }
  
  public void setMinimumLoggingLevel(int paramInt)
  {
    this.mMinimumLoggingLevel = paramInt;
  }
  
  public void v(String paramString1, String paramString2)
  {
    println(2, paramString1, paramString2);
  }
  
  public void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    println(2, paramString1, paramString2, paramThrowable);
  }
  
  public void w(String paramString1, String paramString2)
  {
    println(5, paramString1, paramString2);
  }
  
  public void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    println(5, paramString1, paramString2, paramThrowable);
  }
  
  public void wtf(String paramString1, String paramString2)
  {
    println(6, paramString1, paramString2);
  }
  
  public void wtf(String paramString1, String paramString2, Throwable paramThrowable)
  {
    println(6, paramString1, paramString2, paramThrowable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\logging\FLogDefaultLoggingDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */