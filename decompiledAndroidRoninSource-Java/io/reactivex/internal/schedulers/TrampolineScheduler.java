package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class TrampolineScheduler
  extends Scheduler
{
  private static final TrampolineScheduler INSTANCE = new TrampolineScheduler();
  
  public static TrampolineScheduler instance()
  {
    return INSTANCE;
  }
  
  public Scheduler.Worker createWorker()
  {
    return new TrampolineWorker();
  }
  
  public Disposable scheduleDirect(Runnable paramRunnable)
  {
    RxJavaPlugins.onSchedule(paramRunnable).run();
    return EmptyDisposable.INSTANCE;
  }
  
  public Disposable scheduleDirect(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    try
    {
      paramTimeUnit.sleep(paramLong);
      RxJavaPlugins.onSchedule(paramRunnable).run();
    }
    catch (InterruptedException paramRunnable)
    {
      Thread.currentThread().interrupt();
      RxJavaPlugins.onError(paramRunnable);
    }
    return EmptyDisposable.INSTANCE;
  }
  
  static final class SleepingRunnable
    implements Runnable
  {
    private final long execTime;
    private final Runnable run;
    private final TrampolineScheduler.TrampolineWorker worker;
    
    SleepingRunnable(Runnable paramRunnable, TrampolineScheduler.TrampolineWorker paramTrampolineWorker, long paramLong)
    {
      this.run = paramRunnable;
      this.worker = paramTrampolineWorker;
      this.execTime = paramLong;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  static final class TimedRunnable
    implements Comparable<TimedRunnable>
  {
    final int count;
    volatile boolean disposed;
    final long execTime;
    final Runnable run;
    
    TimedRunnable(Runnable paramRunnable, Long paramLong, int paramInt)
    {
      this.run = paramRunnable;
      this.execTime = paramLong.longValue();
      this.count = paramInt;
    }
    
    public int compareTo(TimedRunnable paramTimedRunnable)
    {
      return 0;
    }
  }
  
  static final class TrampolineWorker
    extends Scheduler.Worker
    implements Disposable
  {
    final AtomicInteger counter = new AtomicInteger();
    volatile boolean disposed;
    final PriorityBlockingQueue<TrampolineScheduler.TimedRunnable> queue = new PriorityBlockingQueue();
    private final AtomicInteger wip = new AtomicInteger();
    
    public void dispose()
    {
      this.disposed = true;
    }
    
    Disposable enqueue(Runnable paramRunnable, long paramLong)
    {
      return null;
    }
    
    public boolean isDisposed()
    {
      return this.disposed;
    }
    
    public Disposable schedule(Runnable paramRunnable)
    {
      return null;
    }
    
    public Disposable schedule(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
    {
      return null;
    }
    
    final class AppendToQueueTask
      implements Runnable
    {
      final TrampolineScheduler.TimedRunnable timedRunnable;
      
      AppendToQueueTask(TrampolineScheduler.TimedRunnable paramTimedRunnable)
      {
        this.timedRunnable = paramTimedRunnable;
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\schedulers\TrampolineScheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */