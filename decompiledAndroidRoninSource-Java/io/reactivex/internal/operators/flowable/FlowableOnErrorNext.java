package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Function;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnErrorNext<T>
  extends AbstractFlowableWithUpstream<T, T>
{
  final boolean allowFatal;
  final Function<? super Throwable, ? extends Publisher<? extends T>> nextSupplier;
  
  public FlowableOnErrorNext(Flowable<T> paramFlowable, Function<? super Throwable, ? extends Publisher<? extends T>> paramFunction, boolean paramBoolean)
  {
    super(paramFlowable);
    this.nextSupplier = paramFunction;
    this.allowFatal = paramBoolean;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class OnErrorNextSubscriber<T>
    extends SubscriptionArbiter
    implements FlowableSubscriber<T>
  {
    private static final long serialVersionUID = 4063763155303814625L;
    final boolean allowFatal;
    boolean done;
    final Subscriber<? super T> downstream;
    final Function<? super Throwable, ? extends Publisher<? extends T>> nextSupplier;
    boolean once;
    long produced;
    
    OnErrorNextSubscriber(Subscriber<? super T> paramSubscriber, Function<? super Throwable, ? extends Publisher<? extends T>> paramFunction, boolean paramBoolean)
    {
      super();
      this.downstream = paramSubscriber;
      this.nextSupplier = paramFunction;
      this.allowFatal = paramBoolean;
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
      setSubscription(paramSubscription);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableOnErrorNext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */