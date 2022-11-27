package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Scheduler;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Action0;
import java.util.concurrent.TimeUnit;

public final class OperatorTakeTimed<T>
  implements Observable.Operator<T, T>
{
  final Scheduler scheduler;
  final long time;
  final TimeUnit unit;
  
  public OperatorTakeTimed(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    this.time = paramLong;
    this.unit = paramTimeUnit;
    this.scheduler = paramScheduler;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
  
  static final class TakeSubscriber<T>
    extends Subscriber<T>
    implements Action0
  {
    final Subscriber<? super T> child;
    
    public TakeSubscriber(Subscriber<? super T> paramSubscriber)
    {
      super();
      this.child = paramSubscriber;
    }
    
    public void call()
    {
      onCompleted();
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
    
    public void onNext(T paramT)
    {
      this.child.onNext(paramT);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorTakeTimed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */