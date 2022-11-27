package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSampleTimed<T>
  extends AbstractFlowableWithUpstream<T, T>
{
  final boolean emitLast;
  final long period;
  final Scheduler scheduler;
  final TimeUnit unit;
  
  public FlowableSampleTimed(Flowable<T> paramFlowable, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, boolean paramBoolean)
  {
    super(paramFlowable);
    this.period = paramLong;
    this.unit = paramTimeUnit;
    this.scheduler = paramScheduler;
    this.emitLast = paramBoolean;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class SampleTimedEmitLast<T>
    extends FlowableSampleTimed.SampleTimedSubscriber<T>
  {
    private static final long serialVersionUID = -7139995637533111443L;
    final AtomicInteger wip = new AtomicInteger(1);
    
    SampleTimedEmitLast(Subscriber<? super T> paramSubscriber, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
    {
      super(paramLong, paramTimeUnit, paramScheduler);
    }
    
    /* Error */
    void complete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
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
  }
  
  static final class SampleTimedNoLast<T>
    extends FlowableSampleTimed.SampleTimedSubscriber<T>
  {
    private static final long serialVersionUID = -7139995637533111443L;
    
    SampleTimedNoLast(Subscriber<? super T> paramSubscriber, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
    {
      super(paramLong, paramTimeUnit, paramScheduler);
    }
    
    void complete()
    {
      this.downstream.onComplete();
    }
    
    public void run()
    {
      emit();
    }
  }
  
  static abstract class SampleTimedSubscriber<T>
    extends AtomicReference<T>
    implements FlowableSubscriber<T>, Subscription, Runnable
  {
    private static final long serialVersionUID = -3517602651313910099L;
    final Subscriber<? super T> downstream;
    final long period;
    final AtomicLong requested = new AtomicLong();
    final Scheduler scheduler;
    final SequentialDisposable timer = new SequentialDisposable();
    final TimeUnit unit;
    Subscription upstream;
    
    SampleTimedSubscriber(Subscriber<? super T> paramSubscriber, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
    {
      this.downstream = paramSubscriber;
      this.period = paramLong;
      this.unit = paramTimeUnit;
      this.scheduler = paramScheduler;
    }
    
    /* Error */
    public void cancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    void cancelTimer()
    {
      DisposableHelper.dispose(this.timer);
    }
    
    abstract void complete();
    
    /* Error */
    void emit()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onComplete()
    {
      cancelTimer();
      complete();
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
      lazySet(paramT);
    }
    
    /* Error */
    public void onSubscribe(Subscription arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableSampleTimed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */