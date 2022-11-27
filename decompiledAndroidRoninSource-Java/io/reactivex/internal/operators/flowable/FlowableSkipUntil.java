package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSkipUntil<T, U>
  extends AbstractFlowableWithUpstream<T, T>
{
  final Publisher<U> other;
  
  public FlowableSkipUntil(Flowable<T> paramFlowable, Publisher<U> paramPublisher)
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
  
  static final class SkipUntilMainSubscriber<T>
    extends AtomicInteger
    implements ConditionalSubscriber<T>, Subscription
  {
    private static final long serialVersionUID = -6270983465606289181L;
    final Subscriber<? super T> downstream;
    final AtomicThrowable error;
    volatile boolean gate;
    final SkipUntilMainSubscriber<T>.OtherSubscriber other;
    final AtomicLong requested;
    final AtomicReference<Subscription> upstream;
    
    SkipUntilMainSubscriber(Subscriber<? super T> paramSubscriber)
    {
      this.downstream = paramSubscriber;
      this.upstream = new AtomicReference();
      this.requested = new AtomicLong();
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
    
    public void request(long paramLong)
    {
      SubscriptionHelper.deferredRequest(this.upstream, this.requested, paramLong);
    }
    
    public boolean tryOnNext(T paramT)
    {
      return false;
    }
    
    final class OtherSubscriber
      extends AtomicReference<Subscription>
      implements FlowableSubscriber<Object>
    {
      private static final long serialVersionUID = -5592042965931999169L;
      
      OtherSubscriber() {}
      
      public void onComplete()
      {
        FlowableSkipUntil.SkipUntilMainSubscriber.this.gate = true;
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
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableSkipUntil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */