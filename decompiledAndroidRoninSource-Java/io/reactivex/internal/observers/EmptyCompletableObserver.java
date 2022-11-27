package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.LambdaConsumerIntrospection;
import java.util.concurrent.atomic.AtomicReference;

public final class EmptyCompletableObserver
  extends AtomicReference<Disposable>
  implements CompletableObserver, Disposable, LambdaConsumerIntrospection
{
  private static final long serialVersionUID = -7545121636549663526L;
  
  public void dispose()
  {
    DisposableHelper.dispose(this);
  }
  
  public boolean hasCustomOnError()
  {
    return false;
  }
  
  public boolean isDisposed()
  {
    return false;
  }
  
  public void onComplete()
  {
    lazySet(DisposableHelper.DISPOSED);
  }
  
  /* Error */
  public void onError(Throwable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onSubscribe(Disposable paramDisposable)
  {
    DisposableHelper.setOnce(this, paramDisposable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\observers\EmptyCompletableObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */