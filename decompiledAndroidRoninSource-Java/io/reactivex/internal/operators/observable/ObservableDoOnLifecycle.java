package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public final class ObservableDoOnLifecycle<T>
  extends AbstractObservableWithUpstream<T, T>
{
  private final Action onDispose;
  private final Consumer<? super Disposable> onSubscribe;
  
  public ObservableDoOnLifecycle(Observable<T> paramObservable, Consumer<? super Disposable> paramConsumer, Action paramAction)
  {
    super(paramObservable);
    this.onSubscribe = paramConsumer;
    this.onDispose = paramAction;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableDoOnLifecycle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */