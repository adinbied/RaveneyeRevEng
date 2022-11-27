package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Function;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.FlowableProcessor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRepeatWhen<T>
  extends AbstractFlowableWithUpstream<T, T>
{
  final Function<? super Flowable<Object>, ? extends Publisher<?>> handler;
  
  public FlowableRepeatWhen(Flowable<T> paramFlowable, Function<? super Flowable<Object>, ? extends Publisher<?>> paramFunction)
  {
    super(paramFlowable);
    this.handler = paramFunction;
  }
  
  /* Error */
  public void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class RepeatWhenSubscriber<T>
    extends FlowableRepeatWhen.WhenSourceSubscriber<T, Object>
  {
    private static final long serialVersionUID = -2680129890138081029L;
    
    RepeatWhenSubscriber(Subscriber<? super T> paramSubscriber, FlowableProcessor<Object> paramFlowableProcessor, Subscription paramSubscription)
    {
      super(paramFlowableProcessor, paramSubscription);
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
  }
  
  static final class WhenReceiver<T, U>
    extends AtomicInteger
    implements FlowableSubscriber<Object>, Subscription
  {
    private static final long serialVersionUID = 2827772011130406689L;
    final AtomicLong requested;
    final Publisher<T> source;
    FlowableRepeatWhen.WhenSourceSubscriber<T, U> subscriber;
    final AtomicReference<Subscription> upstream;
    
    WhenReceiver(Publisher<T> paramPublisher)
    {
      this.source = paramPublisher;
      this.upstream = new AtomicReference();
      this.requested = new AtomicLong();
    }
    
    public void cancel()
    {
      SubscriptionHelper.cancel(this.upstream);
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
    
    public void onSubscribe(Subscription paramSubscription)
    {
      SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, paramSubscription);
    }
    
    public void request(long paramLong)
    {
      SubscriptionHelper.deferredRequest(this.upstream, this.requested, paramLong);
    }
  }
  
  static abstract class WhenSourceSubscriber<T, U>
    extends SubscriptionArbiter
    implements FlowableSubscriber<T>
  {
    private static final long serialVersionUID = -5604623027276966720L;
    protected final Subscriber<? super T> downstream;
    protected final FlowableProcessor<U> processor;
    private long produced;
    protected final Subscription receiver;
    
    WhenSourceSubscriber(Subscriber<? super T> paramSubscriber, FlowableProcessor<U> paramFlowableProcessor, Subscription paramSubscription)
    {
      super();
      this.downstream = paramSubscriber;
      this.processor = paramFlowableProcessor;
      this.receiver = paramSubscription;
    }
    
    /* Error */
    protected final void again(U arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public final void cancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public final void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public final void onSubscribe(Subscription paramSubscription)
    {
      setSubscription(paramSubscription);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableRepeatWhen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */