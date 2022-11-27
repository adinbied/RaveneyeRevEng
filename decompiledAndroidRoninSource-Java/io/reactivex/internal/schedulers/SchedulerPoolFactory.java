package io.reactivex.internal.schedulers;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class SchedulerPoolFactory
{
  static final Map<ScheduledThreadPoolExecutor, Object> POOLS;
  public static final boolean PURGE_ENABLED;
  static final String PURGE_ENABLED_KEY = "rx2.purge-enabled";
  public static final int PURGE_PERIOD_SECONDS;
  static final String PURGE_PERIOD_SECONDS_KEY = "rx2.purge-period-seconds";
  static final AtomicReference<ScheduledExecutorService> PURGE_THREAD = new AtomicReference();
  
  static
  {
    POOLS = new ConcurrentHashMap();
    Properties localProperties = System.getProperties();
    PurgeProperties localPurgeProperties = new PurgeProperties();
    localPurgeProperties.load(localProperties);
    PURGE_ENABLED = localPurgeProperties.purgeEnable;
    PURGE_PERIOD_SECONDS = localPurgeProperties.purgePeriod;
    start();
  }
  
  private SchedulerPoolFactory()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static ScheduledExecutorService create(ThreadFactory paramThreadFactory)
  {
    paramThreadFactory = Executors.newScheduledThreadPool(1, paramThreadFactory);
    tryPutIntoPool(PURGE_ENABLED, paramThreadFactory);
    return paramThreadFactory;
  }
  
  public static void shutdown()
  {
    ScheduledExecutorService localScheduledExecutorService = (ScheduledExecutorService)PURGE_THREAD.getAndSet(null);
    if (localScheduledExecutorService != null) {
      localScheduledExecutorService.shutdownNow();
    }
    POOLS.clear();
  }
  
  public static void start()
  {
    tryStart(PURGE_ENABLED);
  }
  
  static void tryPutIntoPool(boolean paramBoolean, ScheduledExecutorService paramScheduledExecutorService)
  {
    if ((paramBoolean) && ((paramScheduledExecutorService instanceof ScheduledThreadPoolExecutor)))
    {
      ScheduledThreadPoolExecutor localScheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor)paramScheduledExecutorService;
      POOLS.put(localScheduledThreadPoolExecutor, paramScheduledExecutorService);
    }
  }
  
  static void tryStart(boolean paramBoolean)
  {
    if (paramBoolean) {
      for (;;)
      {
        Object localObject = (ScheduledExecutorService)PURGE_THREAD.get();
        if (localObject != null) {
          return;
        }
        ScheduledExecutorService localScheduledExecutorService = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
        if (PURGE_THREAD.compareAndSet(localObject, localScheduledExecutorService))
        {
          localObject = new ScheduledTask();
          int i = PURGE_PERIOD_SECONDS;
          localScheduledExecutorService.scheduleAtFixedRate((Runnable)localObject, i, i, TimeUnit.SECONDS);
          return;
        }
        localScheduledExecutorService.shutdownNow();
      }
    }
  }
  
  static final class PurgeProperties
  {
    boolean purgeEnable;
    int purgePeriod;
    
    /* Error */
    void load(Properties arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  static final class ScheduledTask
    implements Runnable
  {
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\schedulers\SchedulerPoolFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */