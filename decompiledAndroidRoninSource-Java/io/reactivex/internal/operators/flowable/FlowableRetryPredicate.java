package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRetryPredicate<T>
  extends AbstractFlowableWithUpstream<T, T>
{
  final long count;
  final Predicate<? super Throwable> predicate;
  
  public FlowableRetryPredicate(Flowable<T> paramFlowable, long paramLong, Predicate<? super Throwable> paramPredicate)
  {
    super(paramFlowable);
    this.predicate = paramPredicate;
    this.count = paramLong;
  }
  
  /* Error */
  public void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class RetrySubscriber<T>
    extends AtomicInteger
    implements FlowableSubscriber<T>
  {
    private static final long serialVersionUID = -7098360935104053232L;
    final Subscriber<? super T> downstream;
    final Predicate<? super Throwable> predicate;
    long produced;
    long remaining;
    final SubscriptionArbiter sa;
    final Publisher<? extends T> source;
    
    RetrySubscriber(Subscriber<? super T> paramSubscriber, long paramLong, Predicate<? super Throwable> paramPredicate, SubscriptionArbiter paramSubscriptionArbiter, Publisher<? extends T> paramPublisher)
    {
      this.downstream = paramSubscriber;
      this.sa = paramSubscriptionArbiter;
      this.source = paramPublisher;
      this.predicate = paramPredicate;
      this.remaining = paramLong;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableRetryPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */