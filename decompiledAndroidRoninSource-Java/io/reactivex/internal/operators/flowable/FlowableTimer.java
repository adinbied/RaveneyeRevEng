package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTimer
  extends Flowable<Long>
{
  final long delay;
  final Scheduler scheduler;
  final TimeUnit unit;
  
  public FlowableTimer(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    this.delay = paramLong;
    this.unit = paramTimeUnit;
    this.scheduler = paramScheduler;
  }
  
  /* Error */
  public void subscribeActual(Subscriber<? super Long> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class TimerSubscriber
    extends AtomicReference<Disposable>
    implements Subscription, Runnable
  {
    private static final long serialVersionUID = -2809475196591179431L;
    final Subscriber<? super Long> downstream;
    volatile boolean requested;
    
    TimerSubscriber(Subscriber<? super Long> paramSubscriber)
    {
      this.downstream = paramSubscriber;
    }
    
    public void cancel()
    {
      DisposableHelper.dispose(this);
    }
    
    public void request(long paramLong)
    {
      if (SubscriptionHelper.validate(paramLong)) {
        this.requested = true;
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void setResource(Disposable paramDisposable)
    {
      DisposableHelper.trySet(this, paramDisposable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */