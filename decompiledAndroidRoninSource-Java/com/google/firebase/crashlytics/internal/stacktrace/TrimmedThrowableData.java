package com.google.firebase.crashlytics.internal.stacktrace;

public class TrimmedThrowableData
{
  public final TrimmedThrowableData cause;
  public final String className;
  public final String localizedMessage;
  public final StackTraceElement[] stacktrace;
  
  public TrimmedThrowableData(Throwable paramThrowable, StackTraceTrimmingStrategy paramStackTraceTrimmingStrategy)
  {
    this.localizedMessage = paramThrowable.getLocalizedMessage();
    this.className = paramThrowable.getClass().getName();
    this.stacktrace = paramStackTraceTrimmingStrategy.getTrimmedStackTrace(paramThrowable.getStackTrace());
    paramThrowable = paramThrowable.getCause();
    if (paramThrowable != null) {
      paramThrowable = new TrimmedThrowableData(paramThrowable, paramStackTraceTrimmingStrategy);
    } else {
      paramThrowable = null;
    }
    this.cause = paramThrowable;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\stacktrace\TrimmedThrowableData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */