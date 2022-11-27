package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

abstract class AbstractDirectTask
  extends AtomicReference<Future<?>>
  implements Disposable, SchedulerRunnableIntrospection
{
  protected static final FutureTask<Void> DISPOSED = new FutureTask(Functions.EMPTY_RUNNABLE, null);
  protected static final FutureTask<Void> FINISHED = new FutureTask(Functions.EMPTY_RUNNABLE, null);
  private static final long serialVersionUID = 1811839108042568751L;
  protected final Runnable runnable;
  protected Thread runner;
  
  AbstractDirectTask(Runnable paramRunnable)
  {
    this.runnable = paramRunnable;
  }
  
  /* Error */
  public final void dispose()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Runnable getWrappedRunnable()
  {
    return this.runnable;
  }
  
  public final boolean isDisposed()
  {
    return false;
  }
  
  /* Error */
  public final void setFuture(Future<?> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\schedulers\AbstractDirectTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */