package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Subscriber;

public final class OperatorTakeUntil<T, E>
  implements Observable.Operator<T, T>
{
  private final Observable<? extends E> other;
  
  public OperatorTakeUntil(Observable<? extends E> paramObservable)
  {
    this.other = paramObservable;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorTakeUntil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */