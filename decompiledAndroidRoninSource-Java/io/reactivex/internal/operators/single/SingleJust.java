package io.reactivex.internal.operators.single;

import io.reactivex.Single;

public final class SingleJust<T>
  extends Single<T>
{
  final T value;
  
  public SingleJust(T paramT)
  {
    this.value = paramT;
  }
  
  /* Error */
  protected void subscribeActual(io.reactivex.SingleObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleJust.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */