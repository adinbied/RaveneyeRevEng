package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTakeUntil<T, U>
  extends AbstractFlowableWithUpstream<T, T>
{
  final Publisher<? extends U> other;
  
  public FlowableTakeUntil(Flowable<T> paramFlowable, Publisher<? extends U> paramPublisher)
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
  
  static final class TakeUntilMainSubscriber<T>
    extends AtomicInteger
    implements FlowableSubscriber<T>, Subscription
  {
    private static final long serialVersionUID = -4945480365982832967L;
    final Subscriber<? super T> downstream;
    final AtomicThrowable error;
    final TakeUntilMainSubscriber<T>.OtherSubscriber other;
    final AtomicLong requested;
    final AtomicReference<Subscription> upstream;
    
    TakeUntilMainSubscriber(Subscriber<? super T> paramSubscriber)
    {
      this.downstream = paramSubscriber;
      this.requested = new AtomicLong();
      this.upstream = new AtomicReference();
      this.other = new OtherSubscriber();
      this.error = new AtomicThrowable();
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
    
    public void onNext(T paramT)
    {
      HalfSerializer.onNext(this.downstream, paramT, this, this.error);
    }
    
    public void onSubscribe(Subscription paramSubscription)
    {
      SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, paramSubscription);
    }
    
    public void request(long paramLong)
    {
      SubscriptionHelper.deferredRequest(this.upstream, this.requested, paramLong);
    }
    
    final class OtherSubscriber
      extends AtomicReference<Subscription>
      implements FlowableSubscriber<Object>
    {
      private static final long serialVersionUID = -3592821756711087922L;
      
      OtherSubscriber() {}
      
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
      
      public void onNext(Object paramObject)
      {
        SubscriptionHelper.cancel(this);
        onComplete();
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
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableTakeUntil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */