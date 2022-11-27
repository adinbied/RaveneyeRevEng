package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.CountDownLatch;

public abstract class BlockingBaseObserver<T>
  extends CountDownLatch
  implements Observer<T>, Disposable
{
  volatile boolean cancelled;
  Throwable error;
  Disposable upstream;
  T value;
  
  public BlockingBaseObserver()
  {
    super(1);
  }
  
  public final T blockingGet()
  {
    return null;
  }
  
  /* Error */
  public final void dispose()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public final boolean isDisposed()
  {
    return this.cancelled;
  }
  
  public final void onComplete()
  {
    countDown();
  }
  
  /* Error */
  public final void onSubscribe(Disposable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\observers\BlockingBaseObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */