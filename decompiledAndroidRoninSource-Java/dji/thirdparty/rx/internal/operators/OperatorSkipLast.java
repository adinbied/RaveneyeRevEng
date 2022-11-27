package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Subscriber;
import java.util.ArrayDeque;
import java.util.Deque;

public class OperatorSkipLast<T>
  implements Observable.Operator<T, T>
{
  final int count;
  
  public OperatorSkipLast(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.count = paramInt;
      return;
    }
    throw new IndexOutOfBoundsException("count could not be negative");
  }
  
  public Subscriber<? super T> call(final Subscriber<? super T> paramSubscriber)
  {
    new Subscriber(paramSubscriber)
    {
      private final Deque<Object> deque = new ArrayDeque();
      private final NotificationLite<T> on = NotificationLite.instance();
      
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
        //   2: goto -2 -> 0
      }
    };
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorSkipLast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */