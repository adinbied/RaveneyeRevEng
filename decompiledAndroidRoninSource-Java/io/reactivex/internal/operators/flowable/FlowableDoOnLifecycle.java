package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.LongConsumer;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDoOnLifecycle<T>
  extends AbstractFlowableWithUpstream<T, T>
{
  private final Action onCancel;
  private final LongConsumer onRequest;
  private final Consumer<? super Subscription> onSubscribe;
  
  public FlowableDoOnLifecycle(Flowable<T> paramFlowable, Consumer<? super Subscription> paramConsumer, LongConsumer paramLongConsumer, Action paramAction)
  {
    super(paramFlowable);
    this.onSubscribe = paramConsumer;
    this.onRequest = paramLongConsumer;
    this.onCancel = paramAction;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class SubscriptionLambdaSubscriber<T>
    implements FlowableSubscriber<T>, Subscription
  {
    final Subscriber<? super T> downstream;
    final Action onCancel;
    final LongConsumer onRequest;
    final Consumer<? super Subscription> onSubscribe;
    Subscription upstream;
    
    SubscriptionLambdaSubscriber(Subscriber<? super T> paramSubscriber, Consumer<? super Subscription> paramConsumer, LongConsumer paramLongConsumer, Action paramAction)
    {
      this.downstream = paramSubscriber;
      this.onSubscribe = paramConsumer;
      this.onCancel = paramAction;
      this.onRequest = paramLongConsumer;
    }
    
    /* Error */
    public void cancel()
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
    
    public void onNext(T paramT)
    {
      this.downstream.onNext(paramT);
    }
    
    /* Error */
    public void onSubscribe(Subscription arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableDoOnLifecycle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */