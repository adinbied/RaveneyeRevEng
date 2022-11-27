package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Observer;
import dji.thirdparty.rx.Subscriber;

public class OperatorDoOnEach<T>
  implements Observable.Operator<T, T>
{
  final Observer<? super T> doOnEachObserver;
  
  public OperatorDoOnEach(Observer<? super T> paramObserver)
  {
    this.doOnEachObserver = paramObserver;
  }
  
  public Subscriber<? super T> call(final Subscriber<? super T> paramSubscriber)
  {
    new Subscriber(paramSubscriber)
    {
      private boolean done = false;
      
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorDoOnEach.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */