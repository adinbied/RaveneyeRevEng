package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ComputationScheduler
  extends Scheduler
  implements SchedulerMultiWorkerSupport
{
  private static final String KEY_COMPUTATION_PRIORITY = "rx2.computation-priority";
  static final String KEY_MAX_THREADS = "rx2.computation-threads";
  static final int MAX_THREADS = cap(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
  static final FixedSchedulerPool NONE;
  static final PoolWorker SHUTDOWN_WORKER;
  static final RxThreadFactory THREAD_FACTORY;
  private static final String THREAD_NAME_PREFIX = "RxComputationThreadPool";
  final AtomicReference<FixedSchedulerPool> pool;
  final ThreadFactory threadFactory;
  
  static
  {
    Object localObject = new PoolWorker(new RxThreadFactory("RxComputationShutdown"));
    SHUTDOWN_WORKER = (PoolWorker)localObject;
    ((PoolWorker)localObject).dispose();
    localObject = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
    THREAD_FACTORY = (RxThreadFactory)localObject;
    localObject = new FixedSchedulerPool(0, (ThreadFactory)localObject);
    NONE = (FixedSchedulerPool)localObject;
    ((FixedSchedulerPool)localObject).shutdown();
  }
  
  public ComputationScheduler()
  {
    this(THREAD_FACTORY);
  }
  
  public ComputationScheduler(ThreadFactory paramThreadFactory)
  {
    this.threadFactory = paramThreadFactory;
    this.pool = new AtomicReference(NONE);
    start();
  }
  
  static int cap(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 > 0)
    {
      if (paramInt2 > paramInt1) {
        return paramInt1;
      }
      i = paramInt2;
    }
    return i;
  }
  
  public Scheduler.Worker createWorker()
  {
    return null;
  }
  
  /* Error */
  public void createWorkers(int arg1, SchedulerMultiWorkerSupport.WorkerCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public Disposable scheduleDirect(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  public Disposable schedulePeriodicallyDirect(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  /* Error */
  public void shutdown()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class EventLoopWorker
    extends Scheduler.Worker
  {
    private final ListCompositeDisposable both;
    volatile boolean disposed;
    private final ComputationScheduler.PoolWorker poolWorker;
    private final ListCompositeDisposable serial;
    private final CompositeDisposable timed;
    
    EventLoopWorker(ComputationScheduler.PoolWorker paramPoolWorker)
    {
      this.poolWorker = paramPoolWorker;
      this.serial = new ListCompositeDisposable();
      this.timed = new CompositeDisposable();
      paramPoolWorker = new ListCompositeDisposable();
      this.both = paramPoolWorker;
      paramPoolWorker.add(this.serial);
      this.both.add(this.timed);
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
    
    public Disposable schedule(Runnable paramRunnable)
    {
      return null;
    }
    
    public Disposable schedule(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
    {
      return null;
    }
  }
  
  static final class FixedSchedulerPool
    implements SchedulerMultiWorkerSupport
  {
    final int cores;
    final ComputationScheduler.PoolWorker[] eventLoops;
    long n;
    
    FixedSchedulerPool(int paramInt, ThreadFactory paramThreadFactory)
    {
      this.cores = paramInt;
      this.eventLoops = new ComputationScheduler.PoolWorker[paramInt];
      int i = 0;
      while (i < paramInt)
      {
        this.eventLoops[i] = new ComputationScheduler.PoolWorker(paramThreadFactory);
        i += 1;
      }
    }
    
    /* Error */
    public void createWorkers(int arg1, SchedulerMultiWorkerSupport.WorkerCallback arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    public ComputationScheduler.PoolWorker getEventLoop()
    {
      return null;
    }
    
    /* Error */
    public void shutdown()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class PoolWorker
    extends NewThreadWorker
  {
    PoolWorker(ThreadFactory paramThreadFactory)
    {
      super();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\schedulers\ComputationScheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */