package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSwitchMap<T, R>
  extends AbstractFlowableWithUpstream<T, R>
{
  final int bufferSize;
  final boolean delayErrors;
  final Function<? super T, ? extends Publisher<? extends R>> mapper;
  
  public FlowableSwitchMap(Flowable<T> paramFlowable, Function<? super T, ? extends Publisher<? extends R>> paramFunction, int paramInt, boolean paramBoolean)
  {
    super(paramFlowable);
    this.mapper = paramFunction;
    this.bufferSize = paramInt;
    this.delayErrors = paramBoolean;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class SwitchMapInnerSubscriber<T, R>
    extends AtomicReference<Subscription>
    implements FlowableSubscriber<R>
  {
    private static final long serialVersionUID = 3837284832786408377L;
    final int bufferSize;
    volatile boolean done;
    int fusionMode;
    final long index;
    final FlowableSwitchMap.SwitchMapSubscriber<T, R> parent;
    volatile SimpleQueue<R> queue;
    
    SwitchMapInnerSubscriber(FlowableSwitchMap.SwitchMapSubscriber<T, R> paramSwitchMapSubscriber, long paramLong, int paramInt)
    {
      this.parent = paramSwitchMapSubscriber;
      this.index = paramLong;
      this.bufferSize = paramInt;
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
    public void onNext(R arg1)
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
  
  static final class SwitchMapSubscriber<T, R>
    extends AtomicInteger
    implements FlowableSubscriber<T>, Subscription
  {
    static final FlowableSwitchMap.SwitchMapInnerSubscriber<Object, Object> CANCELLED;
    private static final long serialVersionUID = -3491074160481096299L;
    final AtomicReference<FlowableSwitchMap.SwitchMapInnerSubscriber<T, R>> active = new AtomicReference();
    final int bufferSize;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final Subscriber<? super R> downstream;
    final AtomicThrowable error;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final AtomicLong requested = new AtomicLong();
    volatile long unique;
    Subscription upstream;
    
    static
    {
      FlowableSwitchMap.SwitchMapInnerSubscriber localSwitchMapInnerSubscriber = new FlowableSwitchMap.SwitchMapInnerSubscriber(null, -1L, 1);
      CANCELLED = localSwitchMapInnerSubscriber;
      localSwitchMapInnerSubscriber.cancel();
    }
    
    SwitchMapSubscriber(Subscriber<? super R> paramSubscriber, Function<? super T, ? extends Publisher<? extends R>> paramFunction, int paramInt, boolean paramBoolean)
    {
      this.downstream = paramSubscriber;
      this.mapper = paramFunction;
      this.bufferSize = paramInt;
      this.delayErrors = paramBoolean;
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
    void disposeInner()
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
      //   2: return
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
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableSwitchMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */