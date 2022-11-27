package com.idlefish.flutterboost.log;

public abstract interface ILog
{
  public abstract void d(String paramString1, String paramString2);
  
  public abstract void d(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void e(String paramString1, String paramString2);
  
  public abstract void e(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void i(String paramString1, String paramString2);
  
  public abstract void i(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract boolean isLogLevelEnabled(int paramInt);
  
  public abstract void v(String paramString1, String paramString2);
  
  public abstract void v(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void w(String paramString1, String paramString2);
  
  public abstract void w(String paramString1, String paramString2, Throwable paramThrowable);
  
  public static enum LogLevelEnum
  {
    private String logLevelName;
    private int loglevel;
    
    static
    {
      DEBUG = new LogLevelEnum("DEBUG", 1, 1, "D");
      INFO = new LogLevelEnum("INFO", 2, 2, "I");
      WARNING = new LogLevelEnum("WARNING", 3, 3, "W");
      LogLevelEnum localLogLevelEnum = new LogLevelEnum("ERROR", 4, 4, "E");
      ERROR = localLogLevelEnum;
      $VALUES = new LogLevelEnum[] { VERBOSE, DEBUG, INFO, WARNING, localLogLevelEnum };
    }
    
    private LogLevelEnum(int paramInt, String paramString)
    {
      this.loglevel = paramInt;
      this.logLevelName = paramString;
    }
    
    public String getLogLevelName()
    {
      return this.logLevelName;
    }
    
    public int getLoglevel()
    {
      return this.loglevel;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\idlefish\flutterboost\log\ILog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */