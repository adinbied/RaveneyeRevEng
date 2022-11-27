package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Scheduler;
import dji.thirdparty.rx.Scheduler.Worker;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Action0;

public class OperatorUnsubscribeOn<T>
  implements Observable.Operator<T, T>
{
  final Scheduler scheduler;
  
  public OperatorUnsubscribeOn(Scheduler paramScheduler)
  {
    this.scheduler = paramScheduler;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorUnsubscribeOn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */