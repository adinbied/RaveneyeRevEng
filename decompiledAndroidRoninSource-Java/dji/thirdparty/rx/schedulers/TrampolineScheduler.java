package dji.thirdparty.rx.schedulers;

import dji.thirdparty.rx.Scheduler;
import dji.thirdparty.rx.Scheduler.Worker;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.subscriptions.BooleanSubscription;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class TrampolineScheduler
  extends Scheduler
{
  private static final TrampolineScheduler INSTANCE = new TrampolineScheduler();
  
  static int compare(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return -1;
    }
    if (paramInt1 == paramInt2) {
      return 0;
    }
    return 1;
  }
  
  static TrampolineScheduler instance()
  {
    return INSTANCE;
  }
  
  public Scheduler.Worker createWorker()
  {
    return new InnerCurrentThreadScheduler();
  }
  
  private static class InnerCurrentThreadScheduler
    extends Scheduler.Worker
    implements Subscription
  {
    final AtomicInteger counter = new AtomicInteger();
    private final BooleanSubscription innerSubscription = new BooleanSubscription();
    final PriorityBlockingQueue<TrampolineScheduler.TimedAction> queue = new PriorityBlockingQueue();
    private final AtomicInteger wip = new AtomicInteger();
    
    private Subscription enqueue(Action0 paramAction0, long paramLong)
    {
      return null;
    }
    
    public boolean isUnsubscribed()
    {
      return this.innerSubscription.isUnsubscribed();
    }
    
    public Subscription schedule(Action0 paramAction0)
    {
      return null;
    }
    
    public Subscription schedule(Action0 paramAction0, long paramLong, TimeUnit paramTimeUnit)
    {
      return null;
    }
    
    public void unsubscribe()
    {
      this.innerSubscription.unsubscribe();
    }
  }
  
  private static final class TimedAction
    implements Comparable<TimedAction>
  {
    final Action0 action;
    final int count;
    final Long execTime;
    
    TimedAction(Action0 paramAction0, Long paramLong, int paramInt)
    {
      this.action = paramAction0;
      this.execTime = paramLong;
      this.count = paramInt;
    }
    
    public int compareTo(TimedAction paramTimedAction)
    {
      return 0;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\schedulers\TrampolineScheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */