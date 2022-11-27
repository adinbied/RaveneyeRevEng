package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class IoScheduler
  extends Scheduler
{
  static final RxThreadFactory EVICTOR_THREAD_FACTORY;
  private static final String EVICTOR_THREAD_NAME_PREFIX = "RxCachedWorkerPoolEvictor";
  private static final long KEEP_ALIVE_TIME;
  public static final long KEEP_ALIVE_TIME_DEFAULT = 60L;
  private static final TimeUnit KEEP_ALIVE_UNIT = TimeUnit.SECONDS;
  private static final String KEY_IO_PRIORITY = "rx2.io-priority";
  private static final String KEY_KEEP_ALIVE_TIME = "rx2.io-keep-alive-time";
  static final CachedWorkerPool NONE;
  static final ThreadWorker SHUTDOWN_THREAD_WORKER;
  static final RxThreadFactory WORKER_THREAD_FACTORY;
  private static final String WORKER_THREAD_NAME_PREFIX = "RxCachedThreadScheduler";
  final AtomicReference<CachedWorkerPool> pool;
  final ThreadFactory threadFactory;
  
  static
  {
    KEEP_ALIVE_TIME = Long.getLong("rx2.io-keep-alive-time", 60L).longValue();
    Object localObject = new ThreadWorker(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
    SHUTDOWN_THREAD_WORKER = (ThreadWorker)localObject;
    ((ThreadWorker)localObject).dispose();
    int i = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
    WORKER_THREAD_FACTORY = new RxThreadFactory("RxCachedThreadScheduler", i);
    EVICTOR_THREAD_FACTORY = new RxThreadFactory("RxCachedWorkerPoolEvictor", i);
    localObject = new CachedWorkerPool(0L, null, WORKER_THREAD_FACTORY);
    NONE = (CachedWorkerPool)localObject;
    ((CachedWorkerPool)localObject).shutdown();
  }
  
  public IoScheduler()
  {
    this(WORKER_THREAD_FACTORY);
  }
  
  public IoScheduler(ThreadFactory paramThreadFactory)
  {
    this.threadFactory = paramThreadFactory;
    this.pool = new AtomicReference(NONE);
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
  
  public int size()
  {
    return 0;
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class CachedWorkerPool
    implements Runnable
  {
    final CompositeDisposable allWorkers;
    private final ScheduledExecutorService evictorService;
    private final Future<?> evictorTask;
    private final ConcurrentLinkedQueue<IoScheduler.ThreadWorker> expiringWorkerQueue;
    private final long keepAliveTime;
    private final ThreadFactory threadFactory;
    
    CachedWorkerPool(long paramLong, TimeUnit paramTimeUnit, ThreadFactory paramThreadFactory)
    {
      if (paramTimeUnit != null) {
        paramLong = paramTimeUnit.toNanos(paramLong);
      } else {
        paramLong = 0L;
      }
      this.keepAliveTime = paramLong;
      this.expiringWorkerQueue = new ConcurrentLinkedQueue();
      this.allWorkers = new CompositeDisposable();
      this.threadFactory = paramThreadFactory;
      Object localObject = null;
      if (paramTimeUnit != null)
      {
        paramTimeUnit = Executors.newScheduledThreadPool(1, IoScheduler.EVICTOR_THREAD_FACTORY);
        paramLong = this.keepAliveTime;
        paramThreadFactory = paramTimeUnit.scheduleWithFixedDelay(this, paramLong, paramLong, TimeUnit.NANOSECONDS);
      }
      else
      {
        paramThreadFactory = null;
        paramTimeUnit = (TimeUnit)localObject;
      }
      this.evictorService = paramTimeUnit;
      this.evictorTask = paramThreadFactory;
    }
    
    /* Error */
    void evictExpiredWorkers()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    IoScheduler.ThreadWorker get()
    {
      return null;
    }
    
    long now()
    {
      return System.nanoTime();
    }
    
    /* Error */
    void release(IoScheduler.ThreadWorker arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void run()
    {
      evictExpiredWorkers();
    }
    
    /* Error */
    void shutdown()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class EventLoopWorker
    extends Scheduler.Worker
  {
    final AtomicBoolean once = new AtomicBoolean();
    private final IoScheduler.CachedWorkerPool pool;
    private final CompositeDisposable tasks;
    private final IoScheduler.ThreadWorker threadWorker;
    
    EventLoopWorker(IoScheduler.CachedWorkerPool paramCachedWorkerPool)
    {
      this.pool = paramCachedWorkerPool;
      this.tasks = new CompositeDisposable();
      this.threadWorker = paramCachedWorkerPool.get();
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
      return this.once.get();
    }
    
    public Disposable schedule(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
    {
      return null;
    }
  }
  
  static final class ThreadWorker
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\schedulers\IoScheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */