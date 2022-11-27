package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Func1;
import dji.thirdparty.rx.observers.SerializedSubscriber;
import dji.thirdparty.rx.subscriptions.SerialSubscription;

public final class OperatorDebounceWithSelector<T, U>
  implements Observable.Operator<T, T>
{
  final Func1<? super T, ? extends Observable<U>> selector;
  
  public OperatorDebounceWithSelector(Func1<? super T, ? extends Observable<U>> paramFunc1)
  {
    this.selector = paramFunc1;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorDebounceWithSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */