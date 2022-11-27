package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatMap<T, R>
  extends AbstractFlowableWithUpstream<T, R>
{
  final ErrorMode errorMode;
  final Function<? super T, ? extends Publisher<? extends R>> mapper;
  final int prefetch;
  
  public FlowableConcatMap(Flowable<T> paramFlowable, Function<? super T, ? extends Publisher<? extends R>> paramFunction, int paramInt, ErrorMode paramErrorMode)
  {
    super(paramFlowable);
    this.mapper = paramFunction;
    this.prefetch = paramInt;
    this.errorMode = paramErrorMode;
  }
  
  public static <T, R> Subscriber<T> subscribe(Subscriber<? super R> paramSubscriber, Function<? super T, ? extends Publisher<? extends R>> paramFunction, int paramInt, ErrorMode paramErrorMode)
  {
    int i = 1.$SwitchMap$io$reactivex$internal$util$ErrorMode[paramErrorMode.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return new ConcatMapImmediate(paramSubscriber, paramFunction, paramInt);
      }
      return new ConcatMapDelayed(paramSubscriber, paramFunction, paramInt, true);
    }
    return new ConcatMapDelayed(paramSubscriber, paramFunction, paramInt, false);
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static abstract class BaseConcatMapSubscriber<T, R>
    extends AtomicInteger
    implements FlowableSubscriber<T>, FlowableConcatMap.ConcatMapSupport<R>, Subscription
  {
    private static final long serialVersionUID = -3511336836796789179L;
    volatile boolean active;
    volatile boolean cancelled;
    int consumed;
    volatile boolean done;
    final AtomicThrowable errors;
    final FlowableConcatMap.ConcatMapInner<R> inner;
    final int limit;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final int prefetch;
    SimpleQueue<T> queue;
    int sourceMode;
    Subscription upstream;
    
    BaseConcatMapSubscriber(Function<? super T, ? extends Publisher<? extends R>> paramFunction, int paramInt)
    {
      this.mapper = paramFunction;
      this.prefetch = paramInt;
      this.limit = (paramInt - (paramInt >> 2));
      this.inner = new FlowableConcatMap.ConcatMapInner(this);
      this.errors = new AtomicThrowable();
    }
    
    abstract void drain();
    
    public final void innerComplete()
    {
      this.active = false;
      drain();
    }
    
    public final void onComplete()
    {
      this.done = true;
      drain();
    }
    
    /* Error */
    public final void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public final void onSubscribe(Subscription arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    abstract void subscribeActual();
  }
  
  static final class ConcatMapDelayed<T, R>
    extends FlowableConcatMap.BaseConcatMapSubscriber<T, R>
  {
    private static final long serialVersionUID = -2945777694260521066L;
    final Subscriber<? super R> downstream;
    final boolean veryEnd;
    
    ConcatMapDelayed(Subscriber<? super R> paramSubscriber, Function<? super T, ? extends Publisher<? extends R>> paramFunction, int paramInt, boolean paramBoolean)
    {
      super(paramInt);
      this.downstream = paramSubscriber;
      this.veryEnd = paramBoolean;
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
    void drain()
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
    
    public void innerNext(R paramR)
    {
      this.downstream.onNext(paramR);
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void request(long paramLong)
    {
      this.inner.request(paramLong);
    }
    
    void subscribeActual()
    {
      this.downstream.onSubscribe(this);
    }
  }
  
  static final class ConcatMapImmediate<T, R>
    extends FlowableConcatMap.BaseConcatMapSubscriber<T, R>
  {
    private static final long serialVersionUID = 7898995095634264146L;
    final Subscriber<? super R> downstream;
    final AtomicInteger wip;
    
    ConcatMapImmediate(Subscriber<? super R> paramSubscriber, Function<? super T, ? extends Publisher<? extends R>> paramFunction, int paramInt)
    {
      super(paramInt);
      this.downstream = paramSubscriber;
      this.wip = new AtomicInteger();
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
    void drain()
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
    public void innerNext(R arg1)
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
    
    public void request(long paramLong)
    {
      this.inner.request(paramLong);
    }
    
    void subscribeActual()
    {
      this.downstream.onSubscribe(this);
    }
  }
  
  static final class ConcatMapInner<R>
    extends SubscriptionArbiter
    implements FlowableSubscriber<R>
  {
    private static final long serialVersionUID = 897683679971470653L;
    final FlowableConcatMap.ConcatMapSupport<R> parent;
    long produced;
    
    ConcatMapInner(FlowableConcatMap.ConcatMapSupport<R> paramConcatMapSupport)
    {
      super();
      this.parent = paramConcatMapSupport;
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
    public void onNext(R arg1)
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
  
  static abstract interface ConcatMapSupport<T>
  {
    public abstract void innerComplete();
    
    public abstract void innerError(Throwable paramThrowable);
    
    public abstract void innerNext(T paramT);
  }
  
  static final class WeakScalarSubscription<T>
    implements Subscription
  {
    final Subscriber<? super T> downstream;
    boolean once;
    final T value;
    
    WeakScalarSubscription(T paramT, Subscriber<? super T> paramSubscriber)
    {
      this.value = paramT;
      this.downstream = paramSubscriber;
    }
    
    public void cancel() {}
    
    /* Error */
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableConcatMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */