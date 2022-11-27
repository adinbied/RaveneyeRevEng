package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.DisposableSubscriber;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWindowBoundarySupplier<T, B>
  extends AbstractFlowableWithUpstream<T, Flowable<T>>
{
  final int capacityHint;
  final Callable<? extends Publisher<B>> other;
  
  public FlowableWindowBoundarySupplier(Flowable<T> paramFlowable, Callable<? extends Publisher<B>> paramCallable, int paramInt)
  {
    super(paramFlowable);
    this.other = paramCallable;
    this.capacityHint = paramInt;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super Flowable<T>> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class WindowBoundaryInnerSubscriber<T, B>
    extends DisposableSubscriber<B>
  {
    boolean done;
    final FlowableWindowBoundarySupplier.WindowBoundaryMainSubscriber<T, B> parent;
    
    WindowBoundaryInnerSubscriber(FlowableWindowBoundarySupplier.WindowBoundaryMainSubscriber<T, B> paramWindowBoundaryMainSubscriber)
    {
      this.parent = paramWindowBoundaryMainSubscriber;
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
    
    public void onNext(B paramB)
    {
      if (this.done) {
        return;
      }
      this.done = true;
      dispose();
      this.parent.innerNext(this);
    }
  }
  
  static final class WindowBoundaryMainSubscriber<T, B>
    extends AtomicInteger
    implements FlowableSubscriber<T>, Subscription, Runnable
  {
    static final FlowableWindowBoundarySupplier.WindowBoundaryInnerSubscriber<Object, Object> BOUNDARY_DISPOSED = new FlowableWindowBoundarySupplier.WindowBoundaryInnerSubscriber(null);
    static final Object NEXT_WINDOW = new Object();
    private static final long serialVersionUID = 2233020065421370272L;
    final AtomicReference<FlowableWindowBoundarySupplier.WindowBoundaryInnerSubscriber<T, B>> boundarySubscriber;
    final int capacityHint;
    volatile boolean done;
    final Subscriber<? super Flowable<T>> downstream;
    long emitted;
    final AtomicThrowable errors;
    final Callable<? extends Publisher<B>> other;
    final MpscLinkedQueue<Object> queue;
    final AtomicLong requested;
    final AtomicBoolean stopWindows;
    Subscription upstream;
    UnicastProcessor<T> window;
    final AtomicInteger windows;
    
    WindowBoundaryMainSubscriber(Subscriber<? super Flowable<T>> paramSubscriber, int paramInt, Callable<? extends Publisher<B>> paramCallable)
    {
      this.downstream = paramSubscriber;
      this.capacityHint = paramInt;
      this.boundarySubscriber = new AtomicReference();
      this.windows = new AtomicInteger(1);
      this.queue = new MpscLinkedQueue();
      this.errors = new AtomicThrowable();
      this.stopWindows = new AtomicBoolean();
      this.other = paramCallable;
      this.requested = new AtomicLong();
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
    void disposeBoundary()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void drain()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void innerComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void innerError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void innerNext(FlowableWindowBoundarySupplier.WindowBoundaryInnerSubscriber<T, B> arg1)
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
      BackpressureHelper.add(this.requested, paramLong);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableWindowBoundarySupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */