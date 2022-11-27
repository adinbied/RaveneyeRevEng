package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTimeout<T, U, V>
  extends AbstractFlowableWithUpstream<T, T>
{
  final Publisher<U> firstTimeoutIndicator;
  final Function<? super T, ? extends Publisher<V>> itemTimeoutIndicator;
  final Publisher<? extends T> other;
  
  public FlowableTimeout(Flowable<T> paramFlowable, Publisher<U> paramPublisher, Function<? super T, ? extends Publisher<V>> paramFunction, Publisher<? extends T> paramPublisher1)
  {
    super(paramFlowable);
    this.firstTimeoutIndicator = paramPublisher;
    this.itemTimeoutIndicator = paramFunction;
    this.other = paramPublisher1;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class TimeoutConsumer
    extends AtomicReference<Subscription>
    implements FlowableSubscriber<Object>, Disposable
  {
    private static final long serialVersionUID = 8708641127342403073L;
    final long idx;
    final FlowableTimeout.TimeoutSelectorSupport parent;
    
    TimeoutConsumer(long paramLong, FlowableTimeout.TimeoutSelectorSupport paramTimeoutSelectorSupport)
    {
      this.idx = paramLong;
      this.parent = paramTimeoutSelectorSupport;
    }
    
    public void dispose()
    {
      SubscriptionHelper.cancel(this);
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
    public void onNext(Object arg1)
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
  }
  
  static final class TimeoutFallbackSubscriber<T>
    extends SubscriptionArbiter
    implements FlowableSubscriber<T>, FlowableTimeout.TimeoutSelectorSupport
  {
    private static final long serialVersionUID = 3764492702657003550L;
    long consumed;
    final Subscriber<? super T> downstream;
    Publisher<? extends T> fallback;
    final AtomicLong index;
    final Function<? super T, ? extends Publisher<?>> itemTimeoutIndicator;
    final SequentialDisposable task;
    final AtomicReference<Subscription> upstream;
    
    TimeoutFallbackSubscriber(Subscriber<? super T> paramSubscriber, Function<? super T, ? extends Publisher<?>> paramFunction, Publisher<? extends T> paramPublisher)
    {
      super();
      this.downstream = paramSubscriber;
      this.itemTimeoutIndicator = paramFunction;
      this.task = new SequentialDisposable();
      this.upstream = new AtomicReference();
      this.fallback = paramPublisher;
      this.index = new AtomicLong();
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
    public void onTimeout(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onTimeoutError(long arg1, Throwable arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void startFirstTimeout(Publisher<?> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static abstract interface TimeoutSelectorSupport
    extends FlowableTimeoutTimed.TimeoutSupport
  {
    public abstract void onTimeoutError(long paramLong, Throwable paramThrowable);
  }
  
  static final class TimeoutSubscriber<T>
    extends AtomicLong
    implements FlowableSubscriber<T>, Subscription, FlowableTimeout.TimeoutSelectorSupport
  {
    private static final long serialVersionUID = 3764492702657003550L;
    final Subscriber<? super T> downstream;
    final Function<? super T, ? extends Publisher<?>> itemTimeoutIndicator;
    final AtomicLong requested;
    final SequentialDisposable task;
    final AtomicReference<Subscription> upstream;
    
    TimeoutSubscriber(Subscriber<? super T> paramSubscriber, Function<? super T, ? extends Publisher<?>> paramFunction)
    {
      this.downstream = paramSubscriber;
      this.itemTimeoutIndicator = paramFunction;
      this.task = new SequentialDisposable();
      this.upstream = new AtomicReference();
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
      //   2: return
    }
    
    public void onSubscribe(Subscription paramSubscription)
    {
      SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, paramSubscription);
    }
    
    /* Error */
    public void onTimeout(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onTimeoutError(long arg1, Throwable arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    public void request(long paramLong)
    {
      SubscriptionHelper.deferredRequest(this.upstream, this.requested, paramLong);
    }
    
    /* Error */
    void startFirstTimeout(Publisher<?> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableTimeout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */