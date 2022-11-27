package dji.thirdparty.rx.schedulers;

import dji.thirdparty.rx.Scheduler;
import dji.thirdparty.rx.Scheduler.Worker;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.internal.schedulers.NewThreadWorker;
import dji.thirdparty.rx.internal.schedulers.SchedulerLifecycle;
import dji.thirdparty.rx.internal.util.RxThreadFactory;
import dji.thirdparty.rx.subscriptions.CompositeSubscription;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

final class CachedThreadScheduler
  extends Scheduler
  implements SchedulerLifecycle
{
  static final RxThreadFactory EVICTOR_THREAD_FACTORY;
  private static final String EVICTOR_THREAD_NAME_PREFIX = "RxCachedWorkerPoolEvictor-";
  private static final long KEEP_ALIVE_TIME = 60L;
  private static final TimeUnit KEEP_ALIVE_UNIT;
  static final CachedWorkerPool NONE;
  static final ThreadWorker SHUTDOWN_THREADWORKER;
  static final RxThreadFactory WORKER_THREAD_FACTORY = new RxThreadFactory("RxCachedThreadScheduler-");
  private static final String WORKER_THREAD_NAME_PREFIX = "RxCachedThreadScheduler-";
  final AtomicReference<CachedWorkerPool> pool = new AtomicReference(NONE);
  
  static
  {
    EVICTOR_THREAD_FACTORY = new RxThreadFactory("RxCachedWorkerPoolEvictor-");
    KEEP_ALIVE_UNIT = TimeUnit.SECONDS;
    Object localObject = new ThreadWorker(new RxThreadFactory("RxCachedThreadSchedulerShutdown-"));
    SHUTDOWN_THREADWORKER = (ThreadWorker)localObject;
    ((ThreadWorker)localObject).unsubscribe();
    localObject = new CachedWorkerPool(0L, null);
    NONE = (CachedWorkerPool)localObject;
    ((CachedWorkerPool)localObject).shutdown();
  }
  
  public CachedThreadScheduler()
  {
    start();
  }
  
  public Scheduler.Worker createWorker()
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
  
  private static final class CachedWorkerPool
  {
    private final CompositeSubscription allWorkers;
    private final ScheduledExecutorService evictorService;
    private final Future<?> evictorTask;
    private final ConcurrentLinkedQueue<CachedThreadScheduler.ThreadWorker> expiringWorkerQueue;
    private final long keepAliveTime;
    
    CachedWorkerPool(long paramLong, TimeUnit paramTimeUnit)
    {
      if (paramTimeUnit != null) {
        paramLong = paramTimeUnit.toNanos(paramLong);
      } else {
        paramLong = 0L;
      }
      this.keepAliveTime = paramLong;
      this.expiringWorkerQueue = new ConcurrentLinkedQueue();
      this.allWorkers = new CompositeSubscription();
      Object localObject2 = null;
      Object localObject1;
      if (paramTimeUnit != null)
      {
        paramTimeUnit = Executors.newScheduledThreadPool(1, CachedThreadScheduler.EVICTOR_THREAD_FACTORY);
        NewThreadWorker.tryEnableCancelPolicy(paramTimeUnit);
        localObject1 = new Runnable()
        {
          public void run()
          {
            CachedThreadScheduler.CachedWorkerPool.this.evictExpiredWorkers();
          }
        };
        paramLong = this.keepAliveTime;
        localObject1 = paramTimeUnit.scheduleWithFixedDelay((Runnable)localObject1, paramLong, paramLong, TimeUnit.NANOSECONDS);
      }
      else
      {
        localObject1 = null;
        paramTimeUnit = (TimeUnit)localObject2;
      }
      this.evictorService = paramTimeUnit;
      this.evictorTask = ((Future)localObject1);
    }
    
    /* Error */
    void evictExpiredWorkers()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    CachedThreadScheduler.ThreadWorker get()
    {
      return null;
    }
    
    long now()
    {
      return System.nanoTime();
    }
    
    /* Error */
    void release(CachedThreadScheduler.ThreadWorker arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void shutdown()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  private static final class EventLoopWorker
    extends Scheduler.Worker
  {
    static final AtomicIntegerFieldUpdater<EventLoopWorker> ONCE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(EventLoopWorker.class, "once");
    private final CompositeSubscription innerSubscription = new CompositeSubscription();
    volatile int once;
    private final CachedThreadScheduler.CachedWorkerPool pool;
    private final CachedThreadScheduler.ThreadWorker threadWorker;
    
    EventLoopWorker(CachedThreadScheduler.CachedWorkerPool paramCachedWorkerPool)
    {
      this.pool = paramCachedWorkerPool;
      this.threadWorker = paramCachedWorkerPool.get();
    }
    
    public boolean isUnsubscribed()
    {
      return this.innerSubscription.isUnsubscribed();
    }
    
    public Subscription schedule(Action0 paramAction0)
    {
      return schedule(paramAction0, 0L, null);
    }
    
    public Subscription schedule(Action0 paramAction0, long paramLong, TimeUnit paramTimeUnit)
    {
      return null;
    }
    
    /* Error */
    public void unsubscribe()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  private static final class ThreadWorker
    extends NewThreadWorker
  {
    private long expirationTime = 0L;
    
    ThreadWorker(ThreadFactory paramThreadFactory)
    {
      super();
    }
    
    public long getExpirationTime()
    {
      return this.expirationTime;
    }
    
    public void setExpirationTime(long paramLong)
    {
      this.expirationTime = paramLong;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\schedulers\CachedThreadScheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */