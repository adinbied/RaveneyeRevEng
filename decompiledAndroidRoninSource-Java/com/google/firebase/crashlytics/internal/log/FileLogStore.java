package com.google.firebase.crashlytics.internal.log;

abstract interface FileLogStore
{
  public abstract void closeLogFile();
  
  public abstract void deleteLogFile();
  
  public abstract byte[] getLogAsBytes();
  
  public abstract String getLogAsString();
  
  public abstract void writeToLog(long paramLong, String paramString);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\log\FileLogStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */