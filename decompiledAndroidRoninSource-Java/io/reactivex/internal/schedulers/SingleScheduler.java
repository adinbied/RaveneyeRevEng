package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleScheduler
  extends Scheduler
{
  private static final String KEY_SINGLE_PRIORITY = "rx2.single-priority";
  static final ScheduledExecutorService SHUTDOWN;
  static final RxThreadFactory SINGLE_THREAD_FACTORY = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
  private static final String THREAD_NAME_PREFIX = "RxSingleScheduler";
  final AtomicReference<ScheduledExecutorService> executor;
  final ThreadFactory threadFactory;
  
  static
  {
    ScheduledExecutorService localScheduledExecutorService = Executors.newScheduledThreadPool(0);
    SHUTDOWN = localScheduledExecutorService;
    localScheduledExecutorService.shutdown();
  }
  
  public SingleScheduler()
  {
    this(SINGLE_THREAD_FACTORY);
  }
  
  public SingleScheduler(ThreadFactory paramThreadFactory)
  {
    AtomicReference localAtomicReference = new AtomicReference();
    this.executor = localAtomicReference;
    this.threadFactory = paramThreadFactory;
    localAtomicReference.lazySet(createExecutor(paramThreadFactory));
  }
  
  static ScheduledExecutorService createExecutor(ThreadFactory paramThreadFactory)
  {
    return SchedulerPoolFactory.create(paramThreadFactory);
  }
  
  public Scheduler.Worker createWorker()
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
  
  static final class ScheduledWorker
    extends Scheduler.Worker
  {
    volatile boolean disposed;
    final ScheduledExecutorService executor;
    final CompositeDisposable tasks;
    
    ScheduledWorker(ScheduledExecutorService paramScheduledExecutorService)
    {
      this.executor = paramScheduledExecutorService;
      this.tasks = new CompositeDisposable();
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
    
    public Disposable schedule(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\schedulers\SingleScheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */