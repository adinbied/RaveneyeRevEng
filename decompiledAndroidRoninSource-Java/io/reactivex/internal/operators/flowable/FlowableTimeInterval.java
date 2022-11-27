package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Timed;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTimeInterval<T>
  extends AbstractFlowableWithUpstream<T, Timed<T>>
{
  final Scheduler scheduler;
  final TimeUnit unit;
  
  public FlowableTimeInterval(Flowable<T> paramFlowable, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    super(paramFlowable);
    this.scheduler = paramScheduler;
    this.unit = paramTimeUnit;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super Timed<T>> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class TimeIntervalSubscriber<T>
    implements FlowableSubscriber<T>, Subscription
  {
    final Subscriber<? super Timed<T>> downstream;
    long lastTime;
    final Scheduler scheduler;
    final TimeUnit unit;
    Subscription upstream;
    
    TimeIntervalSubscriber(Subscriber<? super Timed<T>> paramSubscriber, TimeUnit paramTimeUnit, Scheduler paramScheduler)
    {
      this.downstream = paramSubscriber;
      this.scheduler = paramScheduler;
      this.unit = paramTimeUnit;
    }
    
    public void cancel()
    {
      this.upstream.cancel();
    }
    
    public void onComplete()
    {
      this.downstream.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.downstream.onError(paramThrowable);
    }
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onSubscribe(Subscription arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void request(long paramLong)
    {
      this.upstream.request(paramLong);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableTimeInterval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */