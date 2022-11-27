package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBufferTimed<T, U extends Collection<? super T>>
  extends AbstractFlowableWithUpstream<T, U>
{
  final Callable<U> bufferSupplier;
  final int maxSize;
  final boolean restartTimerOnMaxSize;
  final Scheduler scheduler;
  final long timeskip;
  final long timespan;
  final TimeUnit unit;
  
  public FlowableBufferTimed(Flowable<T> paramFlowable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit, Scheduler paramScheduler, Callable<U> paramCallable, int paramInt, boolean paramBoolean)
  {
    super(paramFlowable);
    this.timespan = paramLong1;
    this.timeskip = paramLong2;
    this.unit = paramTimeUnit;
    this.scheduler = paramScheduler;
    this.bufferSupplier = paramCallable;
    this.maxSize = paramInt;
    this.restartTimerOnMaxSize = paramBoolean;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super U> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class BufferExactBoundedSubscriber<T, U extends Collection<? super T>>
    extends QueueDrainSubscriber<T, U, U>
    implements Subscription, Runnable, Disposable
  {
    U buffer;
    final Callable<U> bufferSupplier;
    long consumerIndex;
    final int maxSize;
    long producerIndex;
    final boolean restartTimerOnMaxSize;
    Disposable timer;
    final long timespan;
    final TimeUnit unit;
    Subscription upstream;
    final Scheduler.Worker w;
    
    BufferExactBoundedSubscriber(Subscriber<? super U> paramSubscriber, Callable<U> paramCallable, long paramLong, TimeUnit paramTimeUnit, int paramInt, boolean paramBoolean, Scheduler.Worker paramWorker)
    {
      super(new MpscLinkedQueue());
      this.bufferSupplier = paramCallable;
      this.timespan = paramLong;
      this.unit = paramTimeUnit;
      this.maxSize = paramInt;
      this.restartTimerOnMaxSize = paramBoolean;
      this.w = paramWorker;
    }
    
    public boolean accept(Subscriber<? super U> paramSubscriber, U paramU)
    {
      paramSubscriber.onNext(paramU);
      return true;
    }
    
    /* Error */
    public void cancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public boolean isDisposed()
    {
      return this.w.isDisposed();
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onSubscribe(Subscription arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
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
      //   2: return
    }
  }
  
  static final class BufferExactUnboundedSubscriber<T, U extends Collection<? super T>>
    extends QueueDrainSubscriber<T, U, U>
    implements Subscription, Runnable, Disposable
  {
    U buffer;
    final Callable<U> bufferSupplier;
    final Scheduler scheduler;
    final AtomicReference<Disposable> timer = new AtomicReference();
    final long timespan;
    final TimeUnit unit;
    Subscription upstream;
    
    BufferExactUnboundedSubscriber(Subscriber<? super U> paramSubscriber, Callable<U> paramCallable, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
    {
      super(new MpscLinkedQueue());
      this.bufferSupplier = paramCallable;
      this.timespan = paramLong;
      this.unit = paramTimeUnit;
      this.scheduler = paramScheduler;
    }
    
    public boolean accept(Subscriber<? super U> paramSubscriber, U paramU)
    {
      this.downstream.onNext(paramU);
      return true;
    }
    
    /* Error */
    public void cancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void dispose()
    {
      cancel();
    }
    
    public boolean isDisposed()
    {
      return false;
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onSubscribe(Subscription arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
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
      //   2: return
    }
  }
  
  static final class BufferSkipBoundedSubscriber<T, U extends Collection<? super T>>
    extends QueueDrainSubscriber<T, U, U>
    implements Subscription, Runnable
  {
    final Callable<U> bufferSupplier;
    final List<U> buffers;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;
    Subscription upstream;
    final Scheduler.Worker w;
    
    BufferSkipBoundedSubscriber(Subscriber<? super U> paramSubscriber, Callable<U> paramCallable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit, Scheduler.Worker paramWorker)
    {
      super(new MpscLinkedQueue());
      this.bufferSupplier = paramCallable;
      this.timespan = paramLong1;
      this.timeskip = paramLong2;
      this.unit = paramTimeUnit;
      this.w = paramWorker;
      this.buffers = new LinkedList();
    }
    
    public boolean accept(Subscriber<? super U> paramSubscriber, U paramU)
    {
      paramSubscriber.onNext(paramU);
      return true;
    }
    
    /* Error */
    public void cancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void clear()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
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
      //   2: return
    }
    
    /* Error */
    public void onSubscribe(Subscription arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
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
      //   2: return
    }
    
    final class RemoveFromBuffer
      implements Runnable
    {
      private final U buffer;
      
      RemoveFromBuffer()
      {
        Collection localCollection;
        this.buffer = localCollection;
      }
      
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableBufferTimed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */