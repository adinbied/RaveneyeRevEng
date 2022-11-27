package dji.thirdparty.rx.internal.schedulers;

import dji.thirdparty.rx.internal.util.RxThreadFactory;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

public final class GenericScheduledExecutorService
  implements SchedulerLifecycle
{
  public static final GenericScheduledExecutorService INSTANCE = new GenericScheduledExecutorService();
  private static final ScheduledExecutorService[] NONE;
  private static final ScheduledExecutorService SHUTDOWN;
  private static final RxThreadFactory THREAD_FACTORY = new RxThreadFactory("RxScheduledExecutorPool-");
  private static final String THREAD_NAME_PREFIX = "RxScheduledExecutorPool-";
  private static int roundRobin;
  private final AtomicReference<ScheduledExecutorService[]> executor = new AtomicReference(NONE);
  
  static
  {
    NONE = new ScheduledExecutorService[0];
    ScheduledExecutorService localScheduledExecutorService = Executors.newScheduledThreadPool(0);
    SHUTDOWN = localScheduledExecutorService;
    localScheduledExecutorService.shutdown();
  }
  
  private GenericScheduledExecutorService()
  {
    start();
  }
  
  public static ScheduledExecutorService getInstance()
  {
    ScheduledExecutorService[] arrayOfScheduledExecutorService = (ScheduledExecutorService[])INSTANCE.executor.get();
    if (arrayOfScheduledExecutorService == NONE) {
      return SHUTDOWN;
    }
    int j = roundRobin + 1;
    int i = j;
    if (j >= arrayOfScheduledExecutorService.length) {
      i = 0;
    }
    roundRobin = i;
    return arrayOfScheduledExecutorService[i];
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\schedulers\GenericScheduledExecutorService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */