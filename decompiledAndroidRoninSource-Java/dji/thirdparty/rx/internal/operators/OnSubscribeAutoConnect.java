package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.functions.Action1;
import dji.thirdparty.rx.observables.ConnectableObservable;
import java.util.concurrent.atomic.AtomicInteger;

public final class OnSubscribeAutoConnect<T>
  implements Observable.OnSubscribe<T>
{
  final AtomicInteger clients;
  final Action1<? super Subscription> connection;
  final int numberOfSubscribers;
  final ConnectableObservable<? extends T> source;
  
  public OnSubscribeAutoConnect(ConnectableObservable<? extends T> paramConnectableObservable, int paramInt, Action1<? super Subscription> paramAction1)
  {
    if (paramInt > 0)
    {
      this.source = paramConnectableObservable;
      this.numberOfSubscribers = paramInt;
      this.connection = paramAction1;
      this.clients = new AtomicInteger();
      return;
    }
    throw new IllegalArgumentException("numberOfSubscribers > 0 required");
  }
  
  /* Error */
  public void call(dji.thirdparty.rx.Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OnSubscribeAutoConnect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */