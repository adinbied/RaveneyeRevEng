package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWithLatestFrom<T, U, R>
  extends AbstractFlowableWithUpstream<T, R>
{
  final BiFunction<? super T, ? super U, ? extends R> combiner;
  final Publisher<? extends U> other;
  
  public FlowableWithLatestFrom(Flowable<T> paramFlowable, BiFunction<? super T, ? super U, ? extends R> paramBiFunction, Publisher<? extends U> paramPublisher)
  {
    super(paramFlowable);
    this.combiner = paramBiFunction;
    this.other = paramPublisher;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  final class FlowableWithLatestSubscriber
    implements FlowableSubscriber<U>
  {
    private final FlowableWithLatestFrom.WithLatestFromSubscriber<T, U, R> wlf;
    
    FlowableWithLatestSubscriber()
    {
      FlowableWithLatestFrom.WithLatestFromSubscriber localWithLatestFromSubscriber;
      this.wlf = localWithLatestFromSubscriber;
    }
    
    public void onComplete() {}
    
    public void onError(Throwable paramThrowable)
    {
      this.wlf.otherError(paramThrowable);
    }
    
    public void onNext(U paramU)
    {
      this.wlf.lazySet(paramU);
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
  
  static final class WithLatestFromSubscriber<T, U, R>
    extends AtomicReference<U>
    implements ConditionalSubscriber<T>, Subscription
  {
    private static final long serialVersionUID = -312246233408980075L;
    final BiFunction<? super T, ? super U, ? extends R> combiner;
    final Subscriber<? super R> downstream;
    final AtomicReference<Subscription> other = new AtomicReference();
    final AtomicLong requested = new AtomicLong();
    final AtomicReference<Subscription> upstream = new AtomicReference();
    
    WithLatestFromSubscriber(Subscriber<? super R> paramSubscriber, BiFunction<? super T, ? super U, ? extends R> paramBiFunction)
    {
      this.downstream = paramSubscriber;
      this.combiner = paramBiFunction;
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
      //   2: goto -2 -> 0
    }
    
    public void onSubscribe(Subscription paramSubscription)
    {
      SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, paramSubscription);
    }
    
    /* Error */
    public void otherError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void request(long paramLong)
    {
      SubscriptionHelper.deferredRequest(this.upstream, this.requested, paramLong);
    }
    
    public boolean setOther(Subscription paramSubscription)
    {
      return SubscriptionHelper.setOnce(this.other, paramSubscription);
    }
    
    public boolean tryOnNext(T paramT)
    {
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableWithLatestFrom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */