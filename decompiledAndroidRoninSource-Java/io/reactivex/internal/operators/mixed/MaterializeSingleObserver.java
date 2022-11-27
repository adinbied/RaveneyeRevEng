package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Notification;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public final class MaterializeSingleObserver<T>
  implements SingleObserver<T>, MaybeObserver<T>, CompletableObserver, Disposable
{
  final SingleObserver<? super Notification<T>> downstream;
  Disposable upstream;
  
  public MaterializeSingleObserver(SingleObserver<? super Notification<T>> paramSingleObserver)
  {
    this.downstream = paramSingleObserver;
  }
  
  public void dispose()
  {
    this.upstream.dispose();
  }
  
  public boolean isDisposed()
  {
    return this.upstream.isDisposed();
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
  public void onSubscribe(Disposable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onSuccess(T arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\mixed\MaterializeSingleObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */