package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ScheduledRunnable
  extends AtomicReferenceArray<Object>
  implements Runnable, Callable<Object>, Disposable
{
  static final Object ASYNC_DISPOSED = new Object();
  static final Object DONE = new Object();
  static final int FUTURE_INDEX = 1;
  static final Object PARENT_DISPOSED = new Object();
  static final int PARENT_INDEX = 0;
  static final Object SYNC_DISPOSED = new Object();
  static final int THREAD_INDEX = 2;
  private static final long serialVersionUID = -6120223772001106981L;
  final Runnable actual;
  
  public ScheduledRunnable(Runnable paramRunnable, DisposableContainer paramDisposableContainer)
  {
    super(3);
    this.actual = paramRunnable;
    lazySet(0, paramDisposableContainer);
  }
  
  public Object call()
  {
    run();
    return null;
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
    return false;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void setFuture(java.util.concurrent.Future<?> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\schedulers\ScheduledRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */