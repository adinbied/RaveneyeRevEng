package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Action1;

public class OperatorDoOnRequest<T>
  implements Observable.Operator<T, T>
{
  final Action1<Long> request;
  
  public OperatorDoOnRequest(Action1<Long> paramAction1)
  {
    this.request = paramAction1;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
  
  private static final class ParentSubscriber<T>
    extends Subscriber<T>
  {
    private final Subscriber<? super T> child;
    
    ParentSubscriber(Subscriber<? super T> paramSubscriber)
    {
      this.child = paramSubscriber;
      request(0L);
    }
    
    private void requestMore(long paramLong)
    {
      request(paramLong);
    }
    
    public void onCompleted()
    {
      this.child.onCompleted();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.child.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.child.onNext(paramT);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorDoOnRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */