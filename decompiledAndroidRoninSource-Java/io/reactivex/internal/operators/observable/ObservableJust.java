package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.internal.fuseable.ScalarCallable;

public final class ObservableJust<T>
  extends Observable<T>
  implements ScalarCallable<T>
{
  private final T value;
  
  public ObservableJust(T paramT)
  {
    this.value = paramT;
  }
  
  public T call()
  {
    return (T)this.value;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableJust.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */