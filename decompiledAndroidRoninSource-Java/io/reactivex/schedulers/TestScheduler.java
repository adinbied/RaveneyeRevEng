package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class TestScheduler
  extends Scheduler
{
  long counter;
  final Queue<TimedRunnable> queue = new PriorityBlockingQueue(11);
  volatile long time;
  
  public TestScheduler() {}
  
  public TestScheduler(long paramLong, TimeUnit paramTimeUnit)
  {
    this.time = paramTimeUnit.toNanos(paramLong);
  }
  
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
    return new TestWorker();
  }
  
  public long now(TimeUnit paramTimeUnit)
  {
    return 277927429L;
  }
  
  public void triggerActions()
  {
    triggerActions(this.time);
  }
  
  final class TestWorker
    extends Scheduler.Worker
  {
    volatile boolean disposed;
    
    TestWorker() {}
    
    public void dispose()
    {
      this.disposed = true;
    }
    
    public boolean isDisposed()
    {
      return this.disposed;
    }
    
    public long now(TimeUnit paramTimeUnit)
    {
      return TestScheduler.this.now(paramTimeUnit);
    }
    
    public Disposable schedule(Runnable paramRunnable)
    {
      return null;
    }
    
    public Disposable schedule(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
    {
      return null;
    }
    
    final class QueueRemove
      implements Runnable
    {
      final TestScheduler.TimedRunnable timedAction;
      
      QueueRemove(TestScheduler.TimedRunnable paramTimedRunnable)
      {
        this.timedAction = paramTimedRunnable;
      }
      
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    }
  }
  
  static final class TimedRunnable
    implements Comparable<TimedRunnable>
  {
    final long count;
    final Runnable run;
    final TestScheduler.TestWorker scheduler;
    final long time;
    
    TimedRunnable(TestScheduler.TestWorker paramTestWorker, long paramLong1, Runnable paramRunnable, long paramLong2)
    {
      this.time = paramLong1;
      this.run = paramRunnable;
      this.scheduler = paramTestWorker;
      this.count = paramLong2;
    }
    
    public int compareTo(TimedRunnable paramTimedRunnable)
    {
      return 0;
    }
    
    public String toString()
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\schedulers\TestScheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */