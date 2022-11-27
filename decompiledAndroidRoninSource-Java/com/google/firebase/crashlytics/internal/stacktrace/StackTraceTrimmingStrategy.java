package com.google.firebase.crashlytics.internal.stacktrace;

public abstract interface StackTraceTrimmingStrategy
{
  public abstract StackTraceElement[] getTrimmedStackTrace(StackTraceElement[] paramArrayOfStackTraceElement);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\stacktrace\StackTraceTrimmingStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */