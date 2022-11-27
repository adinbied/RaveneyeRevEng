package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSequenceEqual<T>
  extends Flowable<Boolean>
{
  final BiPredicate<? super T, ? super T> comparer;
  final Publisher<? extends T> first;
  final int prefetch;
  final Publisher<? extends T> second;
  
  public FlowableSequenceEqual(Publisher<? extends T> paramPublisher1, Publisher<? extends T> paramPublisher2, BiPredicate<? super T, ? super T> paramBiPredicate, int paramInt)
  {
    this.first = paramPublisher1;
    this.second = paramPublisher2;
    this.comparer = paramBiPredicate;
    this.prefetch = paramInt;
  }
  
  /* Error */
  public void subscribeActual(Subscriber<? super Boolean> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class EqualCoordinator<T>
    extends DeferredScalarSubscription<Boolean>
    implements FlowableSequenceEqual.EqualCoordinatorHelper
  {
    private static final long serialVersionUID = -6178010334400373240L;
    final BiPredicate<? super T, ? super T> comparer;
    final AtomicThrowable error;
    final FlowableSequenceEqual.EqualSubscriber<T> first;
    final FlowableSequenceEqual.EqualSubscriber<T> second;
    T v1;
    T v2;
    final AtomicInteger wip;
    
    EqualCoordinator(Subscriber<? super Boolean> paramSubscriber, int paramInt, BiPredicate<? super T, ? super T> paramBiPredicate)
    {
      super();
      this.comparer = paramBiPredicate;
      this.wip = new AtomicInteger();
      this.first = new FlowableSequenceEqual.EqualSubscriber(this, paramInt);
      this.second = new FlowableSequenceEqual.EqualSubscriber(this, paramInt);
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
    void cancelAndClear()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void drain()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void innerError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void subscribe(Publisher<? extends T> arg1, Publisher<? extends T> arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static abstract interface EqualCoordinatorHelper
  {
    public abstract void drain();
    
    public abstract void innerError(Throwable paramThrowable);
  }
  
  static final class EqualSubscriber<T>
    extends AtomicReference<Subscription>
    implements FlowableSubscriber<T>
  {
    private static final long serialVersionUID = 4804128302091633067L;
    volatile boolean done;
    final int limit;
    final FlowableSequenceEqual.EqualCoordinatorHelper parent;
    final int prefetch;
    long produced;
    volatile SimpleQueue<T> queue;
    int sourceMode;
    
    EqualSubscriber(FlowableSequenceEqual.EqualCoordinatorHelper paramEqualCoordinatorHelper, int paramInt)
    {
      this.parent = paramEqualCoordinatorHelper;
      this.limit = (paramInt - (paramInt >> 2));
      this.prefetch = paramInt;
    }
    
    public void cancel()
    {
      SubscriptionHelper.cancel(this);
    }
    
    void clear()
    {
      SimpleQueue localSimpleQueue = this.queue;
      if (localSimpleQueue != null) {
        localSimpleQueue.clear();
      }
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
      this.parent.innerError(paramThrowable);
    }
    
    /* Error */
    public void onNext(T arg1)
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
    
    /* Error */
    public void request()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableSequenceEqual.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */