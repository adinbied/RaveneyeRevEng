package com.xiaomi.channel.commonutils.logger;

public abstract interface LoggerInterface
{
  public abstract void log(String paramString);
  
  public abstract void log(String paramString, Throwable paramThrowable);
  
  public abstract void setTag(String paramString);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\channel\commonutils\logger\LoggerInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */