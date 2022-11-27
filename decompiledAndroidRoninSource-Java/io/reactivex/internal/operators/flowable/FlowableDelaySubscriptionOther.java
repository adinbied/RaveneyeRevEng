package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDelaySubscriptionOther<T, U>
  extends Flowable<T>
{
  final Publisher<? extends T> main;
  final Publisher<U> other;
  
  public FlowableDelaySubscriptionOther(Publisher<? extends T> paramPublisher, Publisher<U> paramPublisher1)
  {
    this.main = paramPublisher;
    this.other = paramPublisher1;
  }
  
  /* Error */
  public void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class MainSubscriber<T>
    extends AtomicLong
    implements FlowableSubscriber<T>, Subscription
  {
    private static final long serialVersionUID = 2259811067697317255L;
    final Subscriber<? super T> downstream;
    final Publisher<? extends T> main;
    final MainSubscriber<T>.OtherSubscriber other;
    final AtomicReference<Subscription> upstream;
    
    MainSubscriber(Subscriber<? super T> paramSubscriber, Publisher<? extends T> paramPublisher)
    {
      this.downstream = paramSubscriber;
      this.main = paramPublisher;
      this.other = new OtherSubscriber();
      this.upstream = new AtomicReference();
    }
    
    /* Error */
    public void cancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    void next()
    {
      this.main.subscribe(this);
    }
    
    public void onComplete()
    {
      this.downstream.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.downstream.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.downstream.onNext(paramT);
    }
    
    public void onSubscribe(Subscription paramSubscription)
    {
      SubscriptionHelper.deferredSetOnce(this.upstream, this, paramSubscription);
    }
    
    /* Error */
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    final class OtherSubscriber
      extends AtomicReference<Subscription>
      implements FlowableSubscriber<Object>
    {
      private static final long serialVersionUID = -3892798459447644106L;
      
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableDelaySubscriptionOther.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */