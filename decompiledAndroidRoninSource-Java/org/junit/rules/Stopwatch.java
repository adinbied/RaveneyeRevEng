package org.junit.rules;

import java.util.concurrent.TimeUnit;
import org.junit.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public abstract class Stopwatch
  implements TestRule
{
  private final Clock clock;
  private volatile long endNanos;
  private volatile long startNanos;
  
  public Stopwatch()
  {
    this(new Clock());
  }
  
  Stopwatch(Clock paramClock)
  {
    this.clock = paramClock;
  }
  
  private long getNanos()
  {
    if (this.startNanos != 0L)
    {
      long l2 = this.endNanos;
      long l1 = l2;
      if (l2 == 0L) {
        l1 = this.clock.nanoTime();
      }
      return l1 - this.startNanos;
    }
    throw new IllegalStateException("Test has not started");
  }
  
  private void starting()
  {
    this.startNanos = this.clock.nanoTime();
    this.endNanos = 0L;
  }
  
  private void stopping()
  {
    this.endNanos = this.clock.nanoTime();
  }
  
  public final Statement apply(Statement paramStatement, Description paramDescription)
  {
    return new InternalWatcher(null).apply(paramStatement, paramDescription);
  }
  
  protected void failed(long paramLong, Throwable paramThrowable, Description paramDescription) {}
  
  protected void finished(long paramLong, Description paramDescription) {}
  
  public long runtime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(getNanos(), TimeUnit.NANOSECONDS);
  }
  
  protected void skipped(long paramLong, AssumptionViolatedException paramAssumptionViolatedException, Description paramDescription) {}
  
  protected void succeeded(long paramLong, Description paramDescription) {}
  
  static class Clock
  {
    public long nanoTime()
    {
      return System.nanoTime();
    }
  }
  
  private class InternalWatcher
    extends TestWatcher
  {
    private InternalWatcher() {}
    
    protected void failed(Throwable paramThrowable, Description paramDescription)
    {
      Stopwatch.this.stopping();
      Stopwatch localStopwatch = Stopwatch.this;
      localStopwatch.failed(localStopwatch.getNanos(), paramThrowable, paramDescription);
    }
    
    protected void finished(Description paramDescription)
    {
      Stopwatch localStopwatch = Stopwatch.this;
      localStopwatch.finished(localStopwatch.getNanos(), paramDescription);
    }
    
    protected void skipped(AssumptionViolatedException paramAssumptionViolatedException, Description paramDescription)
    {
      Stopwatch.this.stopping();
      Stopwatch localStopwatch = Stopwatch.this;
      localStopwatch.skipped(localStopwatch.getNanos(), paramAssumptionViolatedException, paramDescription);
    }
    
    protected void starting(Description paramDescription)
    {
      Stopwatch.this.starting();
    }
    
    protected void succeeded(Description paramDescription)
    {
      Stopwatch.this.stopping();
      Stopwatch localStopwatch = Stopwatch.this;
      localStopwatch.succeeded(localStopwatch.getNanos(), paramDescription);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\rules\Stopwatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */