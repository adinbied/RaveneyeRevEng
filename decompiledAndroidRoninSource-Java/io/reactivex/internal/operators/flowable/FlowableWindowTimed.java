package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.processors.UnicastProcessor;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWindowTimed<T>
  extends AbstractFlowableWithUpstream<T, Flowable<T>>
{
  final int bufferSize;
  final long maxSize;
  final boolean restartTimerOnMaxSize;
  final Scheduler scheduler;
  final long timeskip;
  final long timespan;
  final TimeUnit unit;
  
  public FlowableWindowTimed(Flowable<T> paramFlowable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit, Scheduler paramScheduler, long paramLong3, int paramInt, boolean paramBoolean)
  {
    super(paramFlowable);
    this.timespan = paramLong1;
    this.timeskip = paramLong2;
    this.unit = paramTimeUnit;
    this.scheduler = paramScheduler;
    this.maxSize = paramLong3;
    this.bufferSize = paramInt;
    this.restartTimerOnMaxSize = paramBoolean;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super Flowable<T>> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class WindowExactBoundedSubscriber<T>
    extends QueueDrainSubscriber<T, Object, Flowable<T>>
    implements Subscription
  {
    final int bufferSize;
    long count;
    final long maxSize;
    long producerIndex;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    volatile boolean terminated;
    final SequentialDisposable timer = new SequentialDisposable();
    final long timespan;
    final TimeUnit unit;
    Subscription upstream;
    UnicastProcessor<T> window;
    final Scheduler.Worker worker;
    
    WindowExactBoundedSubscriber(Subscriber<? super Flowable<T>> paramSubscriber, long paramLong1, TimeUnit paramTimeUnit, Scheduler paramScheduler, int paramInt, long paramLong2, boolean paramBoolean)
    {
      super(new MpscLinkedQueue());
      this.timespan = paramLong1;
      this.unit = paramTimeUnit;
      this.scheduler = paramScheduler;
      this.bufferSize = paramInt;
      this.maxSize = paramLong2;
      this.restartTimerOnMaxSize = paramBoolean;
      if (paramBoolean)
      {
        this.worker = paramScheduler.createWorker();
        return;
      }
      this.worker = null;
    }
    
    public void cancel()
    {
      this.cancelled = true;
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void drainLoop()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
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
      requested(paramLong);
    }
    
    static final class ConsumerIndexHolder
      implements Runnable
    {
      final long index;
      final FlowableWindowTimed.WindowExactBoundedSubscriber<?> parent;
      
      ConsumerIndexHolder(long paramLong, FlowableWindowTimed.WindowExactBoundedSubscriber<?> paramWindowExactBoundedSubscriber)
      {
        this.index = paramLong;
        this.parent = paramWindowExactBoundedSubscriber;
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
  }
  
  static final class WindowExactUnboundedSubscriber<T>
    extends QueueDrainSubscriber<T, Object, Flowable<T>>
    implements FlowableSubscriber<T>, Subscription, Runnable
  {
    static final Object NEXT = new Object();
    final int bufferSize;
    final Scheduler scheduler;
    volatile boolean terminated;
    final SequentialDisposable timer = new SequentialDisposable();
    final long timespan;
    final TimeUnit unit;
    Subscription upstream;
    UnicastProcessor<T> window;
    
    WindowExactUnboundedSubscriber(Subscriber<? super Flowable<T>> paramSubscriber, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, int paramInt)
    {
      super(new MpscLinkedQueue());
      this.timespan = paramLong;
      this.unit = paramTimeUnit;
      this.scheduler = paramScheduler;
      this.bufferSize = paramInt;
    }
    
    public void cancel()
    {
      this.cancelled = true;
    }
    
    public void dispose()
    {
      DisposableHelper.dispose(this.timer);
    }
    
    /* Error */
    void drainLoop()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
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
      requested(paramLong);
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
  
  static final class WindowSkipSubscriber<T>
    extends QueueDrainSubscriber<T, Object, Flowable<T>>
    implements Subscription, Runnable
  {
    final int bufferSize;
    volatile boolean terminated;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;
    Subscription upstream;
    final List<UnicastProcessor<T>> windows;
    final Scheduler.Worker worker;
    
    WindowSkipSubscriber(Subscriber<? super Flowable<T>> paramSubscriber, long paramLong1, long paramLong2, TimeUnit paramTimeUnit, Scheduler.Worker paramWorker, int paramInt)
    {
      super(new MpscLinkedQueue());
      this.timespan = paramLong1;
      this.timeskip = paramLong2;
      this.unit = paramTimeUnit;
      this.worker = paramWorker;
      this.bufferSize = paramInt;
      this.windows = new LinkedList();
    }
    
    public void cancel()
    {
      this.cancelled = true;
    }
    
    /* Error */
    void complete(UnicastProcessor<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void dispose()
    {
      this.worker.dispose();
    }
    
    /* Error */
    void drainLoop()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
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
      requested(paramLong);
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    final class Completion
      implements Runnable
    {
      private final UnicastProcessor<T> processor;
      
      Completion()
      {
        UnicastProcessor localUnicastProcessor;
        this.processor = localUnicastProcessor;
      }
      
      public void run()
      {
        FlowableWindowTimed.WindowSkipSubscriber.this.complete(this.processor);
      }
    }
    
    static final class SubjectWork<T>
    {
      final boolean open;
      final UnicastProcessor<T> w;
      
      SubjectWork(UnicastProcessor<T> paramUnicastProcessor, boolean paramBoolean)
      {
        this.w = paramUnicastProcessor;
        this.open = paramBoolean;
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableWindowTimed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */