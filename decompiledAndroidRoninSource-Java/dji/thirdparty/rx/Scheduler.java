package dji.thirdparty.rx;

import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.subscriptions.MultipleAssignmentSubscription;
import java.util.concurrent.TimeUnit;

public abstract class Scheduler
{
  static final long CLOCK_DRIFT_TOLERANCE_NANOS = TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15L).longValue());
  
  public abstract Worker createWorker();
  
  public long now()
  {
    return System.currentTimeMillis();
  }
  
  public static abstract class Worker
    implements Subscription
  {
    public long now()
    {
      return System.currentTimeMillis();
    }
    
    public abstract Subscription schedule(Action0 paramAction0);
    
    public abstract Subscription schedule(Action0 paramAction0, long paramLong, TimeUnit paramTimeUnit);
    
    public Subscription schedulePeriodically(Action0 paramAction0, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\Scheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */