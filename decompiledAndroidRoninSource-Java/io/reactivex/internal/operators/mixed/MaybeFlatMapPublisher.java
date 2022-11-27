package io.reactivex.internal.operators.mixed;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class MaybeFlatMapPublisher<T, R>
  extends Flowable<R>
{
  final Function<? super T, ? extends Publisher<? extends R>> mapper;
  final MaybeSource<T> source;
  
  public MaybeFlatMapPublisher(MaybeSource<T> paramMaybeSource, Function<? super T, ? extends Publisher<? extends R>> paramFunction)
  {
    this.source = paramMaybeSource;
    this.mapper = paramFunction;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class FlatMapPublisherSubscriber<T, R>
    extends AtomicReference<Subscription>
    implements FlowableSubscriber<R>, MaybeObserver<T>, Subscription
  {
    private static final long serialVersionUID = -8948264376121066672L;
    final Subscriber<? super R> downstream;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final AtomicLong requested;
    Disposable upstream;
    
    FlatMapPublisherSubscriber(Subscriber<? super R> paramSubscriber, Function<? super T, ? extends Publisher<? extends R>> paramFunction)
    {
      this.downstream = paramSubscriber;
      this.mapper = paramFunction;
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
    
    public void onComplete()
    {
      this.downstream.onComplete();
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
    
    /* Error */
    public void onSuccess(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public void request(long paramLong)
    {
      SubscriptionHelper.deferredRequest(this, this.requested, paramLong);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\mixed\MaybeFlatMapPublisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */