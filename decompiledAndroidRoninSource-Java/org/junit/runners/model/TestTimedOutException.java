package org.junit.runners.model;

import java.util.concurrent.TimeUnit;

public class TestTimedOutException
  extends Exception
{
  private static final long serialVersionUID = 31935685163547539L;
  private final TimeUnit timeUnit;
  private final long timeout;
  
  public TestTimedOutException(long paramLong, TimeUnit paramTimeUnit)
  {
    super(String.format("test timed out after %d %s", new Object[] { Long.valueOf(paramLong), paramTimeUnit.name().toLowerCase() }));
    this.timeUnit = paramTimeUnit;
    this.timeout = paramLong;
  }
  
  public TimeUnit getTimeUnit()
  {
    return this.timeUnit;
  }
  
  public long getTimeout()
  {
    return this.timeout;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\runners\model\TestTimedOutException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */