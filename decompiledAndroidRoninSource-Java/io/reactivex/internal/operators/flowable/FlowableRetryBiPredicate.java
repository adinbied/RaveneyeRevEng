package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRetryBiPredicate<T>
  extends AbstractFlowableWithUpstream<T, T>
{
  final BiPredicate<? super Integer, ? super Throwable> predicate;
  
  public FlowableRetryBiPredicate(Flowable<T> paramFlowable, BiPredicate<? super Integer, ? super Throwable> paramBiPredicate)
  {
    super(paramFlowable);
    this.predicate = paramBiPredicate;
  }
  
  /* Error */
  public void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class RetryBiSubscriber<T>
    extends AtomicInteger
    implements FlowableSubscriber<T>
  {
    private static final long serialVersionUID = -7098360935104053232L;
    final Subscriber<? super T> downstream;
    final BiPredicate<? super Integer, ? super Throwable> predicate;
    long produced;
    int retries;
    final SubscriptionArbiter sa;
    final Publisher<? extends T> source;
    
    RetryBiSubscriber(Subscriber<? super T> paramSubscriber, BiPredicate<? super Integer, ? super Throwable> paramBiPredicate, SubscriptionArbiter paramSubscriptionArbiter, Publisher<? extends T> paramPublisher)
    {
      this.downstream = paramSubscriber;
      this.sa = paramSubscriptionArbiter;
      this.source = paramPublisher;
      this.predicate = paramBiPredicate;
    }
    
    public void onComplete()
    {
      this.downstream.onComplete();
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
      //   2: goto -2 -> 0
    }
    
    public void onSubscribe(Subscription paramSubscription)
    {
      this.sa.setSubscription(paramSubscription);
    }
    
    /* Error */
    void subscribeNext()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableRetryBiPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */