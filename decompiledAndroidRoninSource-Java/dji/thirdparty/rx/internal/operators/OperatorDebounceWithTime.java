package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Scheduler;
import dji.thirdparty.rx.Scheduler.Worker;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.observers.SerializedSubscriber;
import dji.thirdparty.rx.subscriptions.SerialSubscription;
import java.util.concurrent.TimeUnit;

public final class OperatorDebounceWithTime<T>
  implements Observable.Operator<T, T>
{
  final Scheduler scheduler;
  final long timeout;
  final TimeUnit unit;
  
  public OperatorDebounceWithTime(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    this.timeout = paramLong;
    this.unit = paramTimeUnit;
    this.scheduler = paramScheduler;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
  
  static final class DebounceState<T>
  {
    boolean emitting;
    boolean hasValue;
    int index;
    boolean terminate;
    T value;
    
    /* Error */
    public void clear()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void emit(int arg1, Subscriber<T> arg2, Subscriber<?> arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: return
    }
    
    /* Error */
    public void emitAndComplete(Subscriber<T> arg1, Subscriber<?> arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public int next(T paramT)
    {
      return 0;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorDebounceWithTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */