package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Notification;
import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Subscriber;

public final class OperatorDematerialize<T>
  implements Observable.Operator<T, Notification<T>>
{
  public static OperatorDematerialize instance()
  {
    return Holder.INSTANCE;
  }
  
  public Subscriber<? super Notification<T>> call(final Subscriber<? super T> paramSubscriber)
  {
    new Subscriber(paramSubscriber)
    {
      boolean terminated;
      
      /* Error */
      public void onCompleted()
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
      
      /* Error */
      public void onError(Throwable arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
      
      /* Error */
      public void onNext(Notification<T> arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    };
  }
  
  private static final class Holder
  {
    static final OperatorDematerialize<Object> INSTANCE = new OperatorDematerialize();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorDematerialize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */