package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Func1;
import dji.thirdparty.rx.functions.Func2;

public final class OperatorTakeWhile<T>
  implements Observable.Operator<T, T>
{
  final Func2<? super T, ? super Integer, Boolean> predicate;
  
  public OperatorTakeWhile(Func1<? super T, Boolean> paramFunc1)
  {
    this(new Func2()
    {
      public Boolean call(T paramAnonymousT, Integer paramAnonymousInteger)
      {
        return (Boolean)OperatorTakeWhile.this.call(paramAnonymousT);
      }
    });
  }
  
  public OperatorTakeWhile(Func2<? super T, ? super Integer, Boolean> paramFunc2)
  {
    this.predicate = paramFunc2;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorTakeWhile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */