package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Scheduler;
import dji.thirdparty.rx.Scheduler.Worker;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.functions.Action0;
import java.util.concurrent.TimeUnit;

public final class OperatorTimeout<T>
  extends OperatorTimeoutBase<T>
{
  public OperatorTimeout(long paramLong, TimeUnit paramTimeUnit, Observable<? extends T> paramObservable, Scheduler paramScheduler)
  {
    super(new OperatorTimeoutBase.FirstTimeoutStub()new OperatorTimeoutBase.TimeoutStub
    {
      public Subscription call(OperatorTimeoutBase.TimeoutSubscriber<T> paramAnonymousTimeoutSubscriber, Long paramAnonymousLong, Scheduler.Worker paramAnonymousWorker)
      {
        return null;
      }
    }, new OperatorTimeoutBase.TimeoutStub()
    {
      public Subscription call(OperatorTimeoutBase.TimeoutSubscriber<T> paramAnonymousTimeoutSubscriber, Long paramAnonymousLong, T paramAnonymousT, Scheduler.Worker paramAnonymousWorker)
      {
        return null;
      }
    }, paramObservable, paramScheduler);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorTimeout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */