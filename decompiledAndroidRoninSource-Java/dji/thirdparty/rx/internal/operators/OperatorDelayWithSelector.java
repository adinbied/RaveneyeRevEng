package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Func1;
import dji.thirdparty.rx.observers.SerializedSubscriber;
import dji.thirdparty.rx.subjects.PublishSubject;

public final class OperatorDelayWithSelector<T, V>
  implements Observable.Operator<T, T>
{
  final Func1<? super T, ? extends Observable<V>> itemDelay;
  final Observable<? extends T> source;
  
  public OperatorDelayWithSelector(Observable<? extends T> paramObservable, Func1<? super T, ? extends Observable<V>> paramFunc1)
  {
    this.source = paramObservable;
    this.itemDelay = paramFunc1;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorDelayWithSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */