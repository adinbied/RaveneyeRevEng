package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.SimpleQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowablePublishMulticast<T, R>
  extends AbstractFlowableWithUpstream<T, R>
{
  final boolean delayError;
  final int prefetch;
  final Function<? super Flowable<T>, ? extends Publisher<? extends R>> selector;
  
  public FlowablePublishMulticast(Flowable<T> paramFlowable, Function<? super Flowable<T>, ? extends Publisher<? extends R>> paramFunction, int paramInt, boolean paramBoolean)
  {
    super(paramFlowable);
    this.selector = paramFunction;
    this.prefetch = paramInt;
    this.delayError = paramBoolean;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class MulticastProcessor<T>
    extends Flowable<T>
    implements FlowableSubscriber<T>, Disposable
  {
    static final FlowablePublishMulticast.MulticastSubscription[] EMPTY = new FlowablePublishMulticast.MulticastSubscription[0];
    static final FlowablePublishMulticast.MulticastSubscription[] TERMINATED = new FlowablePublishMulticast.MulticastSubscription[0];
    int consumed;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final int limit;
    final int prefetch;
    volatile SimpleQueue<T> queue;
    int sourceMode;
    final AtomicReference<FlowablePublishMulticast.MulticastSubscription<T>[]> subscribers;
    final AtomicReference<Subscription> upstream;
    final AtomicInteger wip;
    
    MulticastProcessor(int paramInt, boolean paramBoolean)
    {
      this.prefetch = paramInt;
      this.limit = (paramInt - (paramInt >> 2));
      this.delayError = paramBoolean;
      this.wip = new AtomicInteger();
      this.upstream = new AtomicReference();
      this.subscribers = new AtomicReference(EMPTY);
    }
    
    boolean add(FlowablePublishMulticast.MulticastSubscription<T> paramMulticastSubscription)
    {
      return false;
    }
    
    /* Error */
    void completeAll()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void drain()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void errorAll(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean isDisposed()
    {
      return false;
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
    
    /* Error */
    public void onSubscribe(Subscription arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void remove(FlowablePublishMulticast.MulticastSubscription<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    protected void subscribeActual(Subscriber<? super T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class MulticastSubscription<T>
    extends AtomicLong
    implements Subscription
  {
    private static final long serialVersionUID = 8664815189257569791L;
    final Subscriber<? super T> downstream;
    long emitted;
    final FlowablePublishMulticast.MulticastProcessor<T> parent;
    
    MulticastSubscription(Subscriber<? super T> paramSubscriber, FlowablePublishMulticast.MulticastProcessor<T> paramMulticastProcessor)
    {
      this.downstream = paramSubscriber;
      this.parent = paramMulticastProcessor;
    }
    
    /* Error */
    public void cancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean isCancelled()
    {
      return false;
    }
    
    /* Error */
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  }
  
  static final class OutputCanceller<R>
    implements FlowableSubscriber<R>, Subscription
  {
    final Subscriber<? super R> downstream;
    final FlowablePublishMulticast.MulticastProcessor<?> processor;
    Subscription upstream;
    
    OutputCanceller(Subscriber<? super R> paramSubscriber, FlowablePublishMulticast.MulticastProcessor<?> paramMulticastProcessor)
    {
      this.downstream = paramSubscriber;
      this.processor = paramMulticastProcessor;
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
    
    public void onNext(R paramR)
    {
      this.downstream.onNext(paramR);
    }
    
    /* Error */
    public void onSubscribe(Subscription arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void request(long paramLong)
    {
      this.upstream.request(paramLong);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowablePublishMulticast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */