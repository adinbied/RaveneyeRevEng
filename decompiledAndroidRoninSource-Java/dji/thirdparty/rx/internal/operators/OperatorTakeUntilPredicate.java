package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Func1;

public final class OperatorTakeUntilPredicate<T>
  implements Observable.Operator<T, T>
{
  final Func1<? super T, Boolean> stopPredicate;
  
  public OperatorTakeUntilPredicate(Func1<? super T, Boolean> paramFunc1)
  {
    this.stopPredicate = paramFunc1;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
  
  private final class ParentSubscriber
    extends Subscriber<T>
  {
    private final Subscriber<? super T> child;
    private boolean done = false;
    
    ParentSubscriber()
    {
      Subscriber localSubscriber;
      this.child = localSubscriber;
    }
    
    void downstreamRequest(long paramLong)
    {
      request(paramLong);
    }
    
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
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorTakeUntilPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */