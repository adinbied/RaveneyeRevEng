package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWithLatestFromMany<T, R>
  extends AbstractFlowableWithUpstream<T, R>
{
  final Function<? super Object[], R> combiner;
  final Publisher<?>[] otherArray;
  final Iterable<? extends Publisher<?>> otherIterable;
  
  public FlowableWithLatestFromMany(Flowable<T> paramFlowable, Iterable<? extends Publisher<?>> paramIterable, Function<? super Object[], R> paramFunction)
  {
    super(paramFlowable);
    this.otherArray = null;
    this.otherIterable = paramIterable;
    this.combiner = paramFunction;
  }
  
  public FlowableWithLatestFromMany(Flowable<T> paramFlowable, Publisher<?>[] paramArrayOfPublisher, Function<? super Object[], R> paramFunction)
  {
    super(paramFlowable);
    this.otherArray = paramArrayOfPublisher;
    this.otherIterable = null;
    this.combiner = paramFunction;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  final class SingletonArrayFunc
    implements Function<T, R>
  {
    SingletonArrayFunc() {}
    
    public R apply(T paramT)
      throws Exception
    {
      return null;
    }
  }
  
  static final class WithLatestFromSubscriber<T, R>
    extends AtomicInteger
    implements ConditionalSubscriber<T>, Subscription
  {
    private static final long serialVersionUID = 1577321883966341961L;
    final Function<? super Object[], R> combiner;
    volatile boolean done;
    final Subscriber<? super R> downstream;
    final AtomicThrowable error;
    final AtomicLong requested;
    final FlowableWithLatestFromMany.WithLatestInnerSubscriber[] subscribers;
    final AtomicReference<Subscription> upstream;
    final AtomicReferenceArray<Object> values;
    
    WithLatestFromSubscriber(Subscriber<? super R> paramSubscriber, Function<? super Object[], R> paramFunction, int paramInt)
    {
      this.downstream = paramSubscriber;
      this.combiner = paramFunction;
      paramSubscriber = new FlowableWithLatestFromMany.WithLatestInnerSubscriber[paramInt];
      int i = 0;
      while (i < paramInt)
      {
        paramSubscriber[i] = new FlowableWithLatestFromMany.WithLatestInnerSubscriber(this, i);
        i += 1;
      }
      this.subscribers = paramSubscriber;
      this.values = new AtomicReferenceArray(paramInt);
      this.upstream = new AtomicReference();
      this.requested = new AtomicLong();
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
    void cancelAllBut(int arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    void innerComplete(int paramInt, boolean paramBoolean)
    {
      if (!paramBoolean)
      {
        this.done = true;
        SubscriptionHelper.cancel(this.upstream);
        cancelAllBut(paramInt);
        HalfSerializer.onComplete(this.downstream, this, this.error);
      }
    }
    
    /* Error */
    void innerError(int arg1, Throwable arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    void innerNext(int paramInt, Object paramObject)
    {
      this.values.set(paramInt, paramObject);
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
    
    /* Error */
    void subscribe(Publisher<?>[] arg1, int arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean tryOnNext(T paramT)
    {
      return false;
    }
  }
  
  static final class WithLatestInnerSubscriber
    extends AtomicReference<Subscription>
    implements FlowableSubscriber<Object>
  {
    private static final long serialVersionUID = 3256684027868224024L;
    boolean hasValue;
    final int index;
    final FlowableWithLatestFromMany.WithLatestFromSubscriber<?, ?> parent;
    
    WithLatestInnerSubscriber(FlowableWithLatestFromMany.WithLatestFromSubscriber<?, ?> paramWithLatestFromSubscriber, int paramInt)
    {
      this.parent = paramWithLatestFromSubscriber;
      this.index = paramInt;
    }
    
    void dispose()
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
    
    public void onError(Throwable paramThrowable)
    {
      this.parent.innerError(this.index, paramThrowable);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableWithLatestFromMany.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */