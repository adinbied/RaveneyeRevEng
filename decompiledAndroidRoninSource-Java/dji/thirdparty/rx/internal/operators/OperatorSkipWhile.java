package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Func1;
import dji.thirdparty.rx.functions.Func2;

public final class OperatorSkipWhile<T>
  implements Observable.Operator<T, T>
{
  final Func2<? super T, Integer, Boolean> predicate;
  
  public OperatorSkipWhile(Func2<? super T, Integer, Boolean> paramFunc2)
  {
    this.predicate = paramFunc2;
  }
  
  public static <T> Func2<T, Integer, Boolean> toPredicate2(Func1<? super T, Boolean> paramFunc1)
  {
    new Func2()
    {
      public Boolean call(T paramAnonymousT, Integer paramAnonymousInteger)
      {
        return (Boolean)this.val$predicate.call(paramAnonymousT);
      }
    };
  }
  
  public Subscriber<? super T> call(final Subscriber<? super T> paramSubscriber)
  {
    new Subscriber(paramSubscriber)
    {
      int index;
      boolean skipping = true;
      
      public void onCompleted()
      {
        paramSubscriber.onCompleted();
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        paramSubscriber.onError(paramAnonymousThrowable);
      }
      
      /* Error */
      public void onNext(T arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    };
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorSkipWhile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */