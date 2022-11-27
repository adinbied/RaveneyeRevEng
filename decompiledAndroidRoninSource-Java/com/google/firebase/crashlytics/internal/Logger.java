package com.google.firebase.crashlytics.internal;

import android.util.Log;

public class Logger
{
  static final Logger DEFAULT_LOGGER = new Logger("FirebaseCrashlytics");
  public static final String TAG = "FirebaseCrashlytics";
  private int logLevel;
  private final String tag;
  
  public Logger(String paramString)
  {
    this.tag = paramString;
    this.logLevel = 4;
  }
  
  private boolean canLog(int paramInt)
  {
    return (this.logLevel <= paramInt) || (Log.isLoggable(this.tag, paramInt));
  }
  
  public static Logger getLogger()
  {
    return DEFAULT_LOGGER;
  }
  
  public void d(String paramString)
  {
    d(paramString, null);
  }
  
  public void d(String paramString, Throwable paramThrowable)
  {
    if (canLog(3)) {
      Log.d(this.tag, paramString, paramThrowable);
    }
  }
  
  public void e(String paramString)
  {
    e(paramString, null);
  }
  
  public void e(String paramString, Throwable paramThrowable)
  {
    if (canLog(6)) {
      Log.e(this.tag, paramString, paramThrowable);
    }
  }
  
  public void i(String paramString)
  {
    i(paramString, null);
  }
  
  public void i(String paramString, Throwable paramThrowable)
  {
    if (canLog(4)) {
      Log.i(this.tag, paramString, paramThrowable);
    }
  }
  
  public void log(int paramInt, String paramString)
  {
    log(paramInt, paramString, false);
  }
  
  public void log(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) || (canLog(paramInt))) {
      Log.println(paramInt, this.tag, paramString);
    }
  }
  
  public void v(String paramString)
  {
    v(paramString, null);
  }
  
  public void v(String paramString, Throwable paramThrowable)
  {
    if (canLog(2)) {
      Log.v(this.tag, paramString, paramThrowable);
    }
  }
  
  public void w(String paramString)
  {
    w(paramString, null);
  }
  
  public void w(String paramString, Throwable paramThrowable)
  {
    if (canLog(5)) {
      Log.w(this.tag, paramString, paramThrowable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */