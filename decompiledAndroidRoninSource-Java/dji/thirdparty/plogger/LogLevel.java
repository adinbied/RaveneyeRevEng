package dji.thirdparty.plogger;

public enum LogLevel
{
  static
  {
    LogLevel localLogLevel = new LogLevel("NONE", 1);
    NONE = localLogLevel;
    $VALUES = new LogLevel[] { FULL, localLogLevel };
  }
  
  private LogLevel() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\plogger\LogLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */