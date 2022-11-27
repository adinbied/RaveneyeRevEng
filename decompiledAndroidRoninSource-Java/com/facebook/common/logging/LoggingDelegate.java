package com.facebook.common.logging;

public abstract interface LoggingDelegate
{
  public abstract void d(String paramString1, String paramString2);
  
  public abstract void d(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void e(String paramString1, String paramString2);
  
  public abstract void e(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract int getMinimumLoggingLevel();
  
  public abstract void i(String paramString1, String paramString2);
  
  public abstract void i(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract boolean isLoggable(int paramInt);
  
  public abstract void log(int paramInt, String paramString1, String paramString2);
  
  public abstract void setMinimumLoggingLevel(int paramInt);
  
  public abstract void v(String paramString1, String paramString2);
  
  public abstract void v(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void w(String paramString1, String paramString2);
  
  public abstract void w(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void wtf(String paramString1, String paramString2);
  
  public abstract void wtf(String paramString1, String paramString2, Throwable paramThrowable);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\logging\LoggingDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */