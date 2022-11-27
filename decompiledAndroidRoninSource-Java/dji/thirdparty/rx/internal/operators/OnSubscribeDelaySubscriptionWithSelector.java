package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Func0;

public final class OnSubscribeDelaySubscriptionWithSelector<T, U>
  implements Observable.OnSubscribe<T>
{
  final Observable<? extends T> source;
  final Func0<? extends Observable<U>> subscriptionDelay;
  
  public OnSubscribeDelaySubscriptionWithSelector(Observable<? extends T> paramObservable, Func0<? extends Observable<U>> paramFunc0)
  {
    this.source = paramObservable;
    this.subscriptionDelay = paramFunc0;
  }
  
  /* Error */
  public void call(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OnSubscribeDelaySubscriptionWithSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */