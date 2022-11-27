package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Func1;
import dji.thirdparty.rx.internal.util.UtilityFunctions;

public final class OperatorDistinctUntilChanged<T, U>
  implements Observable.Operator<T, T>
{
  final Func1<? super T, ? extends U> keySelector;
  
  public OperatorDistinctUntilChanged(Func1<? super T, ? extends U> paramFunc1)
  {
    this.keySelector = paramFunc1;
  }
  
  public static <T> OperatorDistinctUntilChanged<T, T> instance()
  {
    return Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(final Subscriber<? super T> paramSubscriber)
  {
    new Subscriber(paramSubscriber)
    {
      boolean hasPrevious;
      U previousKey;
      
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
  
  private static class Holder
  {
    static final OperatorDistinctUntilChanged<?, ?> INSTANCE = new OperatorDistinctUntilChanged(UtilityFunctions.identity());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorDistinctUntilChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */