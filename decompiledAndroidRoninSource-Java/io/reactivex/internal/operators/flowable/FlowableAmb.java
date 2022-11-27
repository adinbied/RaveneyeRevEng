package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableAmb<T>
  extends Flowable<T>
{
  final Publisher<? extends T>[] sources;
  final Iterable<? extends Publisher<? extends T>> sourcesIterable;
  
  public FlowableAmb(Publisher<? extends T>[] paramArrayOfPublisher, Iterable<? extends Publisher<? extends T>> paramIterable)
  {
    this.sources = paramArrayOfPublisher;
    this.sourcesIterable = paramIterable;
  }
  
  /* Error */
  public void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class AmbCoordinator<T>
    implements Subscription
  {
    final Subscriber<? super T> downstream;
    final FlowableAmb.AmbInnerSubscriber<T>[] subscribers;
    final AtomicInteger winner = new AtomicInteger();
    
    AmbCoordinator(Subscriber<? super T> paramSubscriber, int paramInt)
    {
      this.downstream = paramSubscriber;
      this.subscribers = new FlowableAmb.AmbInnerSubscriber[paramInt];
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
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void subscribe(Publisher<? extends T>[] arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean win(int paramInt)
    {
      return false;
    }
  }
  
  static final class AmbInnerSubscriber<T>
    extends AtomicReference<Subscription>
    implements FlowableSubscriber<T>, Subscription
  {
    private static final long serialVersionUID = -1185974347409665484L;
    final Subscriber<? super T> downstream;
    final int index;
    final AtomicLong missedRequested = new AtomicLong();
    final FlowableAmb.AmbCoordinator<T> parent;
    boolean won;
    
    AmbInnerSubscriber(FlowableAmb.AmbCoordinator<T> paramAmbCoordinator, int paramInt, Subscriber<? super T> paramSubscriber)
    {
      this.parent = paramAmbCoordinator;
      this.index = paramInt;
      this.downstream = paramSubscriber;
    }
    
    public void cancel()
    {
      SubscriptionHelper.cancel(this);
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
      SubscriptionHelper.deferredSetOnce(this, this.missedRequested, paramSubscription);
    }
    
    public void request(long paramLong)
    {
      SubscriptionHelper.deferredRequest(this, this.missedRequested, paramLong);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableAmb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */