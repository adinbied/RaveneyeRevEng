package io.reactivex.internal.operators.single;

import io.reactivex.Notification;
import io.reactivex.Single;

public final class SingleMaterialize<T>
  extends Single<Notification<T>>
{
  final Single<T> source;
  
  public SingleMaterialize(Single<T> paramSingle)
  {
    this.source = paramSingle;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleMaterialize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */