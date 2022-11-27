package io.reactivex.android.schedulers;

import android.os.Handler;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;

final class HandlerScheduler
  extends Scheduler
{
  private final boolean async;
  private final Handler handler;
  
  HandlerScheduler(Handler paramHandler, boolean paramBoolean)
  {
    this.handler = paramHandler;
    this.async = paramBoolean;
  }
  
  public Scheduler.Worker createWorker()
  {
    return null;
  }
  
  public Disposable scheduleDirect(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  private static final class HandlerWorker
    extends Scheduler.Worker
  {
    private final boolean async;
    private volatile boolean disposed;
    private final Handler handler;
    
    HandlerWorker(Handler paramHandler, boolean paramBoolean)
    {
      this.handler = paramHandler;
      this.async = paramBoolean;
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
  
  private static final class ScheduledRunnable
    implements Runnable, Disposable
  {
    private final Runnable delegate;
    private volatile boolean disposed;
    private final Handler handler;
    
    ScheduledRunnable(Handler paramHandler, Runnable paramRunnable)
    {
      this.handler = paramHandler;
      this.delegate = paramRunnable;
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
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\android\schedulers\HandlerScheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */