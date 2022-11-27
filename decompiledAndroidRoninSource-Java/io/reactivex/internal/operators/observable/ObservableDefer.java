package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import java.util.concurrent.Callable;

public final class ObservableDefer<T>
  extends Observable<T>
{
  final Callable<? extends ObservableSource<? extends T>> supplier;
  
  public ObservableDefer(Callable<? extends ObservableSource<? extends T>> paramCallable)
  {
    this.supplier = paramCallable;
  }
  
  /* Error */
  public void subscribeActual(io.reactivex.Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableDefer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */