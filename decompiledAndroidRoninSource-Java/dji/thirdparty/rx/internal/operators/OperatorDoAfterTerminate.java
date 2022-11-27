package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Action0;

public final class OperatorDoAfterTerminate<T>
  implements Observable.Operator<T, T>
{
  final Action0 action;
  
  public OperatorDoAfterTerminate(Action0 paramAction0)
  {
    if (paramAction0 != null)
    {
      this.action = paramAction0;
      return;
    }
    throw new NullPointerException("Action can not be null");
  }
  
  public Subscriber<? super T> call(final Subscriber<? super T> paramSubscriber)
  {
    new Subscriber(paramSubscriber)
    {
      /* Error */
      public void onCompleted()
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
      
      /* Error */
      public void onError(Throwable arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
      
      public void onNext(T paramAnonymousT)
      {
        paramSubscriber.onNext(paramAnonymousT);
      }
    };
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorDoAfterTerminate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */