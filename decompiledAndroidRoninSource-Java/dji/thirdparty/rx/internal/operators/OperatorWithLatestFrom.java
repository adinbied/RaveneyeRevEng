package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Func2;
import dji.thirdparty.rx.observers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicReference;

public final class OperatorWithLatestFrom<T, U, R>
  implements Observable.Operator<R, T>
{
  static final Object EMPTY = new Object();
  final Observable<? extends U> other;
  final Func2<? super T, ? super U, ? extends R> resultSelector;
  
  public OperatorWithLatestFrom(Observable<? extends U> paramObservable, Func2<? super T, ? super U, ? extends R> paramFunc2)
  {
    this.other = paramObservable;
    this.resultSelector = paramFunc2;
  }
  
  public Subscriber<? super T> call(Subscriber<? super R> paramSubscriber)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorWithLatestFrom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */