package dji.thirdparty.rx.schedulers;

import dji.thirdparty.rx.Scheduler;
import dji.thirdparty.rx.Scheduler.Worker;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.subscriptions.BooleanSubscription;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class TestScheduler
  extends Scheduler
{
  static long counter;
  final Queue<TimedAction> queue = new PriorityQueue(11, new CompareActionsByTime());
  long time;
  
  /* Error */
  private void triggerActions(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void advanceTimeBy(long arg1, TimeUnit arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public void advanceTimeTo(long paramLong, TimeUnit paramTimeUnit)
  {
    triggerActions(paramTimeUnit.toNanos(paramLong));
  }
  
  public Scheduler.Worker createWorker()
  {
    return new InnerTestScheduler();
  }
  
  public long now()
  {
    return 277876931L;
  }
  
  public void triggerActions()
  {
    triggerActions(this.time);
  }
  
  private static class CompareActionsByTime
    implements Comparator<TestScheduler.TimedAction>
  {
    public int compare(TestScheduler.TimedAction paramTimedAction1, TestScheduler.TimedAction paramTimedAction2)
    {
      return 0;
    }
  }
  
  private final class InnerTestScheduler
    extends Scheduler.Worker
  {
    private final BooleanSubscription s = new BooleanSubscription();
    
    InnerTestScheduler() {}
    
    public boolean isUnsubscribed()
    {
      return this.s.isUnsubscribed();
    }
    
    public long now()
    {
      return TestScheduler.this.now();
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
      this.s.unsubscribe();
    }
  }
  
  private static final class TimedAction
  {
    final Action0 action;
    private final long count;
    final Scheduler.Worker scheduler;
    final long time;
    
    TimedAction(Scheduler.Worker paramWorker, long paramLong, Action0 paramAction0)
    {
      long l = TestScheduler.counter;
      TestScheduler.counter = 1L + l;
      this.count = l;
      this.time = paramLong;
      this.action = paramAction0;
      this.scheduler = paramWorker;
    }
    
    public String toString()
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\schedulers\TestScheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */