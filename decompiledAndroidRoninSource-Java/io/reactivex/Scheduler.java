package io.reactivex;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.schedulers.SchedulerWhen;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import java.util.concurrent.TimeUnit;

public abstract class Scheduler
{
  static final long CLOCK_DRIFT_TOLERANCE_NANOSECONDS = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15L).longValue());
  
  public static long clockDriftTolerance()
  {
    return CLOCK_DRIFT_TOLERANCE_NANOSECONDS;
  }
  
  public abstract Worker createWorker();
  
  public long now(TimeUnit paramTimeUnit)
  {
    return 277785576L;
  }
  
  public Disposable scheduleDirect(Runnable paramRunnable)
  {
    return null;
  }
  
  public Disposable scheduleDirect(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  public Disposable schedulePeriodicallyDirect(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  public void shutdown() {}
  
  public void start() {}
  
  public <S extends Scheduler,  extends Disposable> S when(Function<Flowable<Flowable<Completable>>, Completable> paramFunction)
  {
    return new SchedulerWhen(paramFunction, this);
  }
  
  static final class DisposeTask
    implements Disposable, Runnable, SchedulerRunnableIntrospection
  {
    final Runnable decoratedRun;
    Thread runner;
    final Scheduler.Worker w;
    
    DisposeTask(Runnable paramRunnable, Scheduler.Worker paramWorker)
    {
      this.decoratedRun = paramRunnable;
      this.w = paramWorker;
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public Runnable getWrappedRunnable()
    {
      return this.decoratedRun;
    }
    
    public boolean isDisposed()
    {
      return this.w.isDisposed();
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
  
  static final class PeriodicDirectTask
    implements Disposable, Runnable, SchedulerRunnableIntrospection
  {
    volatile boolean disposed;
    final Runnable run;
    final Scheduler.Worker worker;
    
    PeriodicDirectTask(Runnable paramRunnable, Scheduler.Worker paramWorker)
    {
      this.run = paramRunnable;
      this.worker = paramWorker;
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public Runnable getWrappedRunnable()
    {
      return this.run;
    }
    
    public boolean isDisposed()
    {
      return this.disposed;
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
  
  public static abstract class Worker
    implements Disposable
  {
    public long now(TimeUnit paramTimeUnit)
    {
      return 277891744L;
    }
    
    public Disposable schedule(Runnable paramRunnable)
    {
      return null;
    }
    
    public abstract Disposable schedule(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit);
    
    public Disposable schedulePeriodically(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      return null;
    }
    
    final class PeriodicTask
      implements Runnable, SchedulerRunnableIntrospection
    {
      long count;
      final Runnable decoratedRun;
      long lastNowNanoseconds;
      final long periodInNanoseconds;
      final SequentialDisposable sd;
      long startInNanoseconds;
      
      PeriodicTask(long paramLong1, Runnable paramRunnable, long paramLong2, SequentialDisposable paramSequentialDisposable, long paramLong3)
      {
        this.decoratedRun = paramRunnable;
        this.sd = paramSequentialDisposable;
        this.periodInNanoseconds = paramLong3;
        this.lastNowNanoseconds = paramLong2;
        this.startInNanoseconds = paramLong1;
      }
      
      public Runnable getWrappedRunnable()
      {
        return this.decoratedRun;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\Scheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */