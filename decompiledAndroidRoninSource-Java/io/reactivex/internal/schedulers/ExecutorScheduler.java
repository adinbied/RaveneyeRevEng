package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ExecutorScheduler
  extends Scheduler
{
  static final Scheduler HELPER = ;
  final Executor executor;
  final boolean interruptibleWorker;
  
  public ExecutorScheduler(Executor paramExecutor, boolean paramBoolean)
  {
    this.executor = paramExecutor;
    this.interruptibleWorker = paramBoolean;
  }
  
  public Scheduler.Worker createWorker()
  {
    return null;
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
  
  final class DelayedDispose
    implements Runnable
  {
    private final ExecutorScheduler.DelayedRunnable dr;
    
    DelayedDispose(ExecutorScheduler.DelayedRunnable paramDelayedRunnable)
    {
      this.dr = paramDelayedRunnable;
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
  
  static final class DelayedRunnable
    extends AtomicReference<Runnable>
    implements Runnable, Disposable, SchedulerRunnableIntrospection
  {
    private static final long serialVersionUID = -4101336210206799084L;
    final SequentialDisposable direct = new SequentialDisposable();
    final SequentialDisposable timed = new SequentialDisposable();
    
    DelayedRunnable(Runnable paramRunnable)
    {
      super();
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
      return null;
    }
    
    public boolean isDisposed()
    {
      return false;
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
  
  public static final class ExecutorWorker
    extends Scheduler.Worker
    implements Runnable
  {
    volatile boolean disposed;
    final Executor executor;
    final boolean interruptibleWorker;
    final MpscLinkedQueue<Runnable> queue;
    final CompositeDisposable tasks = new CompositeDisposable();
    final AtomicInteger wip = new AtomicInteger();
    
    public ExecutorWorker(Executor paramExecutor, boolean paramBoolean)
    {
      this.executor = paramExecutor;
      this.queue = new MpscLinkedQueue();
      this.interruptibleWorker = paramBoolean;
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
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
      //   2: goto -2 -> 0
    }
    
    public Disposable schedule(Runnable paramRunnable)
    {
      return null;
    }
    
    public Disposable schedule(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
    {
      return null;
    }
    
    static final class BooleanRunnable
      extends AtomicBoolean
      implements Runnable, Disposable
    {
      private static final long serialVersionUID = -2421395018820541164L;
      final Runnable actual;
      
      BooleanRunnable(Runnable paramRunnable)
      {
        this.actual = paramRunnable;
      }
      
      public void dispose()
      {
        lazySet(true);
      }
      
      public boolean isDisposed()
      {
        return get();
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
    
    static final class InterruptibleRunnable
      extends AtomicInteger
      implements Runnable, Disposable
    {
      static final int FINISHED = 2;
      static final int INTERRUPTED = 4;
      static final int INTERRUPTING = 3;
      static final int READY = 0;
      static final int RUNNING = 1;
      private static final long serialVersionUID = -3603436687413320876L;
      final Runnable run;
      final DisposableContainer tasks;
      volatile Thread thread;
      
      InterruptibleRunnable(Runnable paramRunnable, DisposableContainer paramDisposableContainer)
      {
        this.run = paramRunnable;
        this.tasks = paramDisposableContainer;
      }
      
      void cleanup()
      {
        DisposableContainer localDisposableContainer = this.tasks;
        if (localDisposableContainer != null) {
          localDisposableContainer.delete(this);
        }
      }
      
      /* Error */
      public void dispose()
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
      
      public boolean isDisposed()
      {
        return false;
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
    
    final class SequentialDispose
      implements Runnable
    {
      private final Runnable decoratedRun;
      private final SequentialDisposable mar;
      
      SequentialDispose(SequentialDisposable paramSequentialDisposable, Runnable paramRunnable)
      {
        this.mar = paramSequentialDisposable;
        this.decoratedRun = paramRunnable;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\schedulers\ExecutorScheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */