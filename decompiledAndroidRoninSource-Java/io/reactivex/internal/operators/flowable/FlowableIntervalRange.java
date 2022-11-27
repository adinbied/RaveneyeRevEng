package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableIntervalRange
  extends Flowable<Long>
{
  final long end;
  final long initialDelay;
  final long period;
  final Scheduler scheduler;
  final long start;
  final TimeUnit unit;
  
  public FlowableIntervalRange(long paramLong1, long paramLong2, long paramLong3, long paramLong4, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    this.initialDelay = paramLong3;
    this.period = paramLong4;
    this.unit = paramTimeUnit;
    this.scheduler = paramScheduler;
    this.start = paramLong1;
    this.end = paramLong2;
  }
  
  /* Error */
  public void subscribeActual(Subscriber<? super Long> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class IntervalRangeSubscriber
    extends AtomicLong
    implements Subscription, Runnable
  {
    private static final long serialVersionUID = -2809475196591179431L;
    long count;
    final Subscriber<? super Long> downstream;
    final long end;
    final AtomicReference<Disposable> resource = new AtomicReference();
    
    IntervalRangeSubscriber(Subscriber<? super Long> paramSubscriber, long paramLong1, long paramLong2)
    {
      this.downstream = paramSubscriber;
      this.count = paramLong1;
      this.end = paramLong2;
    }
    
    public void cancel()
    {
      DisposableHelper.dispose(this.resource);
    }
    
    /* Error */
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
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
      DisposableHelper.setOnce(this.resource, paramDisposable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableIntervalRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */