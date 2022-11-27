package dji.thirdparty.rx.android.schedulers;

import android.os.Handler;
import dji.thirdparty.rx.Scheduler;
import dji.thirdparty.rx.Scheduler.Worker;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.internal.schedulers.ScheduledAction;
import dji.thirdparty.rx.subscriptions.CompositeSubscription;
import java.util.concurrent.TimeUnit;

public final class HandlerScheduler
  extends Scheduler
{
  private final Handler handler;
  
  HandlerScheduler(Handler paramHandler)
  {
    this.handler = paramHandler;
  }
  
  public static HandlerScheduler from(Handler paramHandler)
  {
    if (paramHandler != null) {
      return new HandlerScheduler(paramHandler);
    }
    throw new NullPointerException("handler == null");
  }
  
  public Scheduler.Worker createWorker()
  {
    return new HandlerWorker(this.handler);
  }
  
  static class HandlerWorker
    extends Scheduler.Worker
  {
    private final CompositeSubscription compositeSubscription = new CompositeSubscription();
    private final Handler handler;
    
    HandlerWorker(Handler paramHandler)
    {
      this.handler = paramHandler;
    }
    
    public boolean isUnsubscribed()
    {
      return this.compositeSubscription.isUnsubscribed();
    }
    
    public Subscription schedule(Action0 paramAction0)
    {
      return null;
    }
    
    public Subscription schedule(Action0 paramAction0, long paramLong, TimeUnit paramTimeUnit)
    {
      return null;
    }
    
    public void unsubscribe()
    {
      this.compositeSubscription.unsubscribe();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\android\schedulers\HandlerScheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */