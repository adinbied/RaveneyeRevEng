package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableOperator;
import io.reactivex.ObservableSource;

public final class ObservableLift<R, T>
  extends AbstractObservableWithUpstream<T, R>
{
  final ObservableOperator<? extends R, ? super T> operator;
  
  public ObservableLift(ObservableSource<T> paramObservableSource, ObservableOperator<? extends R, ? super T> paramObservableOperator)
  {
    super(paramObservableSource);
    this.operator = paramObservableOperator;
  }
  
  /* Error */
  public void subscribeActual(io.reactivex.Observer<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableLift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */