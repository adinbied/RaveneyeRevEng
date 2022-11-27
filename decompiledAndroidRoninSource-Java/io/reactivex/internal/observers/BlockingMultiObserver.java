package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class BlockingMultiObserver<T>
  extends CountDownLatch
  implements SingleObserver<T>, CompletableObserver, MaybeObserver<T>
{
  volatile boolean cancelled;
  Throwable error;
  Disposable upstream;
  T value;
  
  public BlockingMultiObserver()
  {
    super(1);
  }
  
  public boolean blockingAwait(long paramLong, TimeUnit paramTimeUnit)
  {
    return false;
  }
  
  public T blockingGet()
  {
    return null;
  }
  
  public T blockingGet(T paramT)
  {
    return null;
  }
  
  public Throwable blockingGetError()
  {
    return null;
  }
  
  public Throwable blockingGetError(long paramLong, TimeUnit paramTimeUnit)
  {
    return null;
  }
  
  /* Error */
  void dispose()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onComplete()
  {
    countDown();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.error = paramThrowable;
    countDown();
  }
  
  /* Error */
  public void onSubscribe(Disposable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onSuccess(T paramT)
  {
    this.value = paramT;
    countDown();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\observers\BlockingMultiObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */