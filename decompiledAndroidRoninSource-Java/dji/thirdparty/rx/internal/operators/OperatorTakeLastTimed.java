package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Scheduler;
import dji.thirdparty.rx.Subscriber;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

public final class OperatorTakeLastTimed<T>
  implements Observable.Operator<T, T>
{
  final long ageMillis;
  final int count;
  final Scheduler scheduler;
  
  public OperatorTakeLastTimed(int paramInt, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    if (paramInt >= 0)
    {
      this.ageMillis = paramTimeUnit.toMillis(paramLong);
      this.scheduler = paramScheduler;
      this.count = paramInt;
      return;
    }
    throw new IndexOutOfBoundsException("count could not be negative");
  }
  
  public OperatorTakeLastTimed(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    this.ageMillis = paramTimeUnit.toMillis(paramLong);
    this.scheduler = paramScheduler;
    this.count = -1;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorTakeLastTimed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */