package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.Notification;
import io.reactivex.Single;

public final class CompletableMaterialize<T>
  extends Single<Notification<T>>
{
  final Completable source;
  
  public CompletableMaterialize(Completable paramCompletable)
  {
    this.source = paramCompletable;
  }
  
  /* Error */
  protected void subscribeActual(io.reactivex.SingleObserver<? super Notification<T>> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableMaterialize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */