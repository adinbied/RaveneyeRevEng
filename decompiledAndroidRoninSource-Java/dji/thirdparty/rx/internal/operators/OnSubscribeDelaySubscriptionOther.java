package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.subscriptions.SerialSubscription;

public final class OnSubscribeDelaySubscriptionOther<T, U>
  implements Observable.OnSubscribe<T>
{
  final Observable<? extends T> main;
  final Observable<U> other;
  
  public OnSubscribeDelaySubscriptionOther(Observable<? extends T> paramObservable, Observable<U> paramObservable1)
  {
    this.main = paramObservable;
    this.other = paramObservable1;
  }
  
  /* Error */
  public void call(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OnSubscribeDelaySubscriptionOther.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */