package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableAutoConnect<T>
  extends Observable<T>
{
  final AtomicInteger clients;
  final Consumer<? super Disposable> connection;
  final int numberOfObservers;
  final ConnectableObservable<? extends T> source;
  
  public ObservableAutoConnect(ConnectableObservable<? extends T> paramConnectableObservable, int paramInt, Consumer<? super Disposable> paramConsumer)
  {
    this.source = paramConnectableObservable;
    this.numberOfObservers = paramInt;
    this.connection = paramConsumer;
    this.clients = new AtomicInteger();
  }
  
  /* Error */
  public void subscribeActual(io.reactivex.Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableAutoConnect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */