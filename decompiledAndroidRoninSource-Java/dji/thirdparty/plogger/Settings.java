package dji.thirdparty.plogger;

public final class Settings
{
  private LogAdapter logAdapter;
  private LogLevel logLevel = LogLevel.FULL;
  private int methodCount = 2;
  private int methodOffset = 0;
  private boolean showThreadInfo = true;
  
  public LogAdapter getLogAdapter()
  {
    return null;
  }
  
  public LogLevel getLogLevel()
  {
    return this.logLevel;
  }
  
  public int getMethodCount()
  {
    return this.methodCount;
  }
  
  public int getMethodOffset()
  {
    return this.methodOffset;
  }
  
  public Settings hideThreadInfo()
  {
    this.showThreadInfo = false;
    return this;
  }
  
  public boolean isShowThreadInfo()
  {
    return this.showThreadInfo;
  }
  
  public Settings logAdapter(LogAdapter paramLogAdapter)
  {
    this.logAdapter = paramLogAdapter;
    return this;
  }
  
  public Settings logLevel(LogLevel paramLogLevel)
  {
    this.logLevel = paramLogLevel;
    return this;
  }
  
  public Settings methodCount(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    this.methodCount = i;
    return this;
  }
  
  public Settings methodOffset(int paramInt)
  {
    this.methodOffset = paramInt;
    return this;
  }
  
  /* Error */
  public void reset()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\plogger\Settings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */