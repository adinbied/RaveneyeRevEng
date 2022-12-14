package org.junit.rules;

import java.util.concurrent.TimeUnit;
import org.junit.internal.runners.statements.FailOnTimeout;
import org.junit.internal.runners.statements.FailOnTimeout.Builder;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class Timeout
  implements TestRule
{
  private final boolean lookForStuckThread;
  private final TimeUnit timeUnit;
  private final long timeout;
  
  @Deprecated
  public Timeout(int paramInt)
  {
    this(paramInt, TimeUnit.MILLISECONDS);
  }
  
  public Timeout(long paramLong, TimeUnit paramTimeUnit)
  {
    this.timeout = paramLong;
    this.timeUnit = paramTimeUnit;
    this.lookForStuckThread = false;
  }
  
  protected Timeout(Builder paramBuilder)
  {
    this.timeout = paramBuilder.getTimeout();
    this.timeUnit = paramBuilder.getTimeUnit();
    this.lookForStuckThread = paramBuilder.getLookingForStuckThread();
  }
  
  public static Builder builder()
  {
    return new Builder();
  }
  
  public static Timeout millis(long paramLong)
  {
    return new Timeout(paramLong, TimeUnit.MILLISECONDS);
  }
  
  public static Timeout seconds(long paramLong)
  {
    return new Timeout(paramLong, TimeUnit.SECONDS);
  }
  
  public Statement apply(final Statement paramStatement, Description paramDescription)
  {
    try
    {
      paramStatement = createFailOnTimeoutStatement(paramStatement);
      return paramStatement;
    }
    catch (Exception paramStatement) {}
    new Statement()
    {
      public void evaluate()
        throws Throwable
      {
        throw new RuntimeException("Invalid parameters for Timeout", paramStatement);
      }
    };
  }
  
  protected Statement createFailOnTimeoutStatement(Statement paramStatement)
    throws Exception
  {
    return FailOnTimeout.builder().withTimeout(this.timeout, this.timeUnit).withLookingForStuckThread(this.lookForStuckThread).build(paramStatement);
  }
  
  protected final boolean getLookingForStuckThread()
  {
    return this.lookForStuckThread;
  }
  
  protected final long getTimeout(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.timeout, this.timeUnit);
  }
  
  public static class Builder
  {
    private boolean lookForStuckThread = false;
    private TimeUnit timeUnit = TimeUnit.SECONDS;
    private long timeout = 0L;
    
    public Timeout build()
    {
      return new Timeout(this);
    }
    
    protected boolean getLookingForStuckThread()
    {
      return this.lookForStuckThread;
    }
    
    protected TimeUnit getTimeUnit()
    {
      return this.timeUnit;
    }
    
    protected long getTimeout()
    {
      return this.timeout;
    }
    
    public Builder withLookingForStuckThread(boolean paramBoolean)
    {
      this.lookForStuckThread = paramBoolean;
      return this;
    }
    
    public Builder withTimeout(long paramLong, TimeUnit paramTimeUnit)
    {
      this.timeout = paramLong;
      this.timeUnit = paramTimeUnit;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\rules\Timeout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */