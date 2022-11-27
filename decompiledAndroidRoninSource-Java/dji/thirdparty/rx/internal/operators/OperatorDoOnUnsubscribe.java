package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Action0;

public class OperatorDoOnUnsubscribe<T>
  implements Observable.Operator<T, T>
{
  private final Action0 unsubscribe;
  
  public OperatorDoOnUnsubscribe(Action0 paramAction0)
  {
    this.unsubscribe = paramAction0;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorDoOnUnsubscribe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */