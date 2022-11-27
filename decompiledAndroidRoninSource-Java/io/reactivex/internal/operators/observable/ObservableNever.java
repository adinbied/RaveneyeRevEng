package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.disposables.EmptyDisposable;

public final class ObservableNever
  extends Observable<Object>
{
  public static final Observable<Object> INSTANCE = new ObservableNever();
  
  protected void subscribeActual(Observer<? super Object> paramObserver)
  {
    paramObserver.onSubscribe(EmptyDisposable.NEVER);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableNever.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */