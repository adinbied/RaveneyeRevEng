package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.observers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicBoolean;

public final class OperatorSkipUntil<T, U>
  implements Observable.Operator<T, T>
{
  final Observable<U> other;
  
  public OperatorSkipUntil(Observable<U> paramObservable)
  {
    this.other = paramObservable;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorSkipUntil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */