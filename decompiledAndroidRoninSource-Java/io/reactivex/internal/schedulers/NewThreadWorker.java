package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class NewThreadWorker
  extends Scheduler.Worker
  implements Disposable
{
  volatile boolean disposed;
  private final ScheduledExecutorService executor;
  
  public NewThreadWorker(ThreadFactory paramThreadFactory)
  {
    this.executor = SchedulerPoolFactory.create(paramThreadFactory);
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
    return schedule(paramRunnable, 0L, null);
  }
  
  public Disposable schedule(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  public ScheduledRunnable scheduleActual(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit, DisposableContainer paramDisposableContainer)
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\schedulers\NewThreadWorker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */