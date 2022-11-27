package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Function;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatMapEager<T, R>
  extends AbstractFlowableWithUpstream<T, R>
{
  final ErrorMode errorMode;
  final Function<? super T, ? extends Publisher<? extends R>> mapper;
  final int maxConcurrency;
  final int prefetch;
  
  public FlowableConcatMapEager(Flowable<T> paramFlowable, Function<? super T, ? extends Publisher<? extends R>> paramFunction, int paramInt1, int paramInt2, ErrorMode paramErrorMode)
  {
    super(paramFlowable);
    this.mapper = paramFunction;
    this.maxConcurrency = paramInt1;
    this.prefetch = paramInt2;
    this.errorMode = paramErrorMode;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ConcatMapEagerDelayErrorSubscriber<T, R>
    extends AtomicInteger
    implements FlowableSubscriber<T>, Subscription, InnerQueuedSubscriberSupport<R>
  {
    private static final long serialVersionUID = -4255299542215038287L;
    volatile boolean cancelled;
    volatile InnerQueuedSubscriber<R> current;
    volatile boolean done;
    final Subscriber<? super R> downstream;
    final ErrorMode errorMode;
    final AtomicThrowable errors;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final int maxConcurrency;
    final int prefetch;
    final AtomicLong requested;
    final SpscLinkedArrayQueue<InnerQueuedSubscriber<R>> subscribers;
    Subscription upstream;
    
    ConcatMapEagerDelayErrorSubscriber(Subscriber<? super R> paramSubscriber, Function<? super T, ? extends Publisher<? extends R>> paramFunction, int paramInt1, int paramInt2, ErrorMode paramErrorMode)
    {
      this.downstream = paramSubscriber;
      this.mapper = paramFunction;
      this.maxConcurrency = paramInt1;
      this.prefetch = paramInt2;
      this.errorMode = paramErrorMode;
      this.subscribers = new SpscLinkedArrayQueue(Math.min(paramInt2, paramInt1));
      this.errors = new AtomicThrowable();
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
    void cancelAll()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void drain()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void drainAndCancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void innerComplete(InnerQueuedSubscriber<R> paramInnerQueuedSubscriber)
    {
      paramInnerQueuedSubscriber.setDone();
      drain();
    }
    
    /* Error */
    public void innerError(InnerQueuedSubscriber<R> arg1, Throwable arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void innerNext(InnerQueuedSubscriber<R> arg1, R arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onComplete()
    {
      this.done = true;
      drain();
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableConcatMapEager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */