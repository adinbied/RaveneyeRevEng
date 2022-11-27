package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;

public final class ObservableSerialized<T>
  extends AbstractObservableWithUpstream<T, T>
{
  public ObservableSerialized(Observable<T> paramObservable)
  {
    super(paramObservable);
  }
  
  /* Error */
  protected void subscribeActual(io.reactivex.Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableSerialized.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */