package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSwitchIfEmpty<T>
  extends AbstractFlowableWithUpstream<T, T>
{
  final Publisher<? extends T> other;
  
  public FlowableSwitchIfEmpty(Flowable<T> paramFlowable, Publisher<? extends T> paramPublisher)
  {
    super(paramFlowable);
    this.other = paramPublisher;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class SwitchIfEmptySubscriber<T>
    implements FlowableSubscriber<T>
  {
    final SubscriptionArbiter arbiter;
    final Subscriber<? super T> downstream;
    boolean empty;
    final Publisher<? extends T> other;
    
    SwitchIfEmptySubscriber(Subscriber<? super T> paramSubscriber, Publisher<? extends T> paramPublisher)
    {
      this.downstream = paramSubscriber;
      this.other = paramPublisher;
      this.empty = true;
      this.arbiter = new SubscriptionArbiter(false);
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.downstream.onError(paramThrowable);
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
      this.arbiter.setSubscription(paramSubscription);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableSwitchIfEmpty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */