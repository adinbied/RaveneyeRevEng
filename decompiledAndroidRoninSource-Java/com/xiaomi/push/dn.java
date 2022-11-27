package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.LoggerInterface;

public class dn
  implements LoggerInterface
{
  private LoggerInterface a = null;
  private LoggerInterface b = null;
  
  public dn(LoggerInterface paramLoggerInterface1, LoggerInterface paramLoggerInterface2)
  {
    this.a = paramLoggerInterface1;
    this.b = paramLoggerInterface2;
  }
  
  /* Error */
  public void log(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void log(String arg1, Throwable arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setTag(String paramString) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\dn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */