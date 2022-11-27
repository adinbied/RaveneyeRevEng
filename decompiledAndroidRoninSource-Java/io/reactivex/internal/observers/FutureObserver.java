package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class FutureObserver<T>
  extends CountDownLatch
  implements Observer<T>, Future<T>, Disposable
{
  Throwable error;
  final AtomicReference<Disposable> upstream = new AtomicReference();
  T value;
  
  public FutureObserver()
  {
    super(1);
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    return false;
  }
  
  public void dispose() {}
  
  public T get()
    throws InterruptedException, ExecutionException
  {
    return null;
  }
  
  public T get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    return null;
  }
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public boolean isDisposed()
  {
    return isDone();
  }
  
  public boolean isDone()
  {
    return false;
  }
  
  /* Error */
  public void onComplete()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onError(Throwable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onNext(T arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onSubscribe(Disposable paramDisposable)
  {
    DisposableHelper.setOnce(this.upstream, paramDisposable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\observers\FutureObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */