package dji.thirdparty.rx.schedulers;

import dji.thirdparty.rx.Scheduler;
import dji.thirdparty.rx.Scheduler.Worker;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.subscriptions.BooleanSubscription;
import dji.thirdparty.rx.subscriptions.Subscriptions;
import java.util.concurrent.TimeUnit;

public final class ImmediateScheduler
  extends Scheduler
{
  private static final ImmediateScheduler INSTANCE = new ImmediateScheduler();
  
  static ImmediateScheduler instance()
  {
    return INSTANCE;
  }
  
  public Scheduler.Worker createWorker()
  {
    return new InnerImmediateScheduler();
  }
  
  private class InnerImmediateScheduler
    extends Scheduler.Worker
    implements Subscription
  {
    final BooleanSubscription innerSubscription = new BooleanSubscription();
    
    InnerImmediateScheduler() {}
    
    public boolean isUnsubscribed()
    {
      return this.innerSubscription.isUnsubscribed();
    }
    
    public Subscription schedule(Action0 paramAction0)
    {
      paramAction0.call();
      return Subscriptions.unsubscribed();
    }
    
    public Subscription schedule(Action0 paramAction0, long paramLong, TimeUnit paramTimeUnit)
    {
      return null;
    }
    
    public void unsubscribe()
    {
      this.innerSubscription.unsubscribe();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\schedulers\ImmediateScheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */