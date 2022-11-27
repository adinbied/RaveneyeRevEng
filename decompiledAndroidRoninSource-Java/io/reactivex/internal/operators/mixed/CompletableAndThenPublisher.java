package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class CompletableAndThenPublisher<R>
  extends Flowable<R>
{
  final Publisher<? extends R> other;
  final CompletableSource source;
  
  public CompletableAndThenPublisher(CompletableSource paramCompletableSource, Publisher<? extends R> paramPublisher)
  {
    this.source = paramCompletableSource;
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
  
  static final class AndThenPublisherSubscriber<R>
    extends AtomicReference<Subscription>
    implements FlowableSubscriber<R>, CompletableObserver, Subscription
  {
    private static final long serialVersionUID = -8948264376121066672L;
    final Subscriber<? super R> downstream;
    Publisher<? extends R> other;
    final AtomicLong requested;
    Disposable upstream;
    
    AndThenPublisherSubscriber(Subscriber<? super R> paramSubscriber, Publisher<? extends R> paramPublisher)
    {
      this.downstream = paramSubscriber;
      this.other = paramPublisher;
      this.requested = new AtomicLong();
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
    
    public void onError(Throwable paramThrowable)
    {
      this.downstream.onError(paramThrowable);
    }
    
    public void onNext(R paramR)
    {
      this.downstream.onNext(paramR);
    }
    
    /* Error */
    public void onSubscribe(Disposable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onSubscribe(Subscription paramSubscription)
    {
      SubscriptionHelper.deferredSetOnce(this, this.requested, paramSubscription);
    }
    
    public void request(long paramLong)
    {
      SubscriptionHelper.deferredRequest(this, this.requested, paramLong);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\mixed\CompletableAndThenPublisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */