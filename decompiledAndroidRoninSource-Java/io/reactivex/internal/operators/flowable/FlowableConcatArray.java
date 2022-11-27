package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatArray<T>
  extends Flowable<T>
{
  final boolean delayError;
  final Publisher<? extends T>[] sources;
  
  public FlowableConcatArray(Publisher<? extends T>[] paramArrayOfPublisher, boolean paramBoolean)
  {
    this.sources = paramArrayOfPublisher;
    this.delayError = paramBoolean;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ConcatArraySubscriber<T>
    extends SubscriptionArbiter
    implements FlowableSubscriber<T>
  {
    private static final long serialVersionUID = -8158322871608889516L;
    final boolean delayError;
    final Subscriber<? super T> downstream;
    List<Throwable> errors;
    int index;
    long produced;
    final Publisher<? extends T>[] sources;
    final AtomicInteger wip;
    
    ConcatArraySubscriber(Publisher<? extends T>[] paramArrayOfPublisher, boolean paramBoolean, Subscriber<? super T> paramSubscriber)
    {
      super();
      this.downstream = paramSubscriber;
      this.sources = paramArrayOfPublisher;
      this.delayError = paramBoolean;
      this.wip = new AtomicInteger();
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
      setSubscription(paramSubscription);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableConcatArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */