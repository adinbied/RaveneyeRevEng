package dji.thirdparty.rx.internal.schedulers;

import dji.thirdparty.rx.Scheduler;
import dji.thirdparty.rx.Scheduler.Worker;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.internal.util.RxThreadFactory;
import dji.thirdparty.rx.internal.util.SubscriptionList;
import dji.thirdparty.rx.subscriptions.CompositeSubscription;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class EventLoopsScheduler
  extends Scheduler
  implements SchedulerLifecycle
{
  static final String KEY_MAX_THREADS = "rx.scheduler.max-computation-threads";
  static final int MAX_THREADS;
  static final FixedSchedulerPool NONE = new FixedSchedulerPool(0);
  static final PoolWorker SHUTDOWN_WORKER;
  static final RxThreadFactory THREAD_FACTORY = new RxThreadFactory("RxComputationThreadPool-");
  private static final String THREAD_NAME_PREFIX = "RxComputationThreadPool-";
  final AtomicReference<FixedSchedulerPool> pool = new AtomicReference(NONE);
  
  static
  {
    int j = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
    int k = Runtime.getRuntime().availableProcessors();
    int i;
    if (j > 0)
    {
      i = j;
      if (j <= k) {}
    }
    else
    {
      i = k;
    }
    MAX_THREADS = i;
    PoolWorker localPoolWorker = new PoolWorker(new RxThreadFactory("RxComputationShutdown-"));
    SHUTDOWN_WORKER = localPoolWorker;
    localPoolWorker.unsubscribe();
  }
  
  public EventLoopsScheduler()
  {
    start();
  }
  
  public Scheduler.Worker createWorker()
  {
    return null;
  }
  
  public Subscription scheduleDirect(Action0 paramAction0)
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
  
  private static class EventLoopWorker
    extends Scheduler.Worker
  {
    private final SubscriptionList both;
    private final EventLoopsScheduler.PoolWorker poolWorker;
    private final SubscriptionList serial = new SubscriptionList();
    private final CompositeSubscription timed;
    
    EventLoopWorker(EventLoopsScheduler.PoolWorker paramPoolWorker)
    {
      CompositeSubscription localCompositeSubscription = new CompositeSubscription();
      this.timed = localCompositeSubscription;
      this.both = new SubscriptionList(new Subscription[] { this.serial, localCompositeSubscription });
      this.poolWorker = paramPoolWorker;
    }
    
    public boolean isUnsubscribed()
    {
      return this.both.isUnsubscribed();
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
      this.both.unsubscribe();
    }
  }
  
  static final class FixedSchedulerPool
  {
    final int cores;
    final EventLoopsScheduler.PoolWorker[] eventLoops;
    long n;
    
    FixedSchedulerPool(int paramInt)
    {
      this.cores = paramInt;
      this.eventLoops = new EventLoopsScheduler.PoolWorker[paramInt];
      int i = 0;
      while (i < paramInt)
      {
        this.eventLoops[i] = new EventLoopsScheduler.PoolWorker(EventLoopsScheduler.THREAD_FACTORY);
        i += 1;
      }
    }
    
    public EventLoopsScheduler.PoolWorker getEventLoop()
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\schedulers\EventLoopsScheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */