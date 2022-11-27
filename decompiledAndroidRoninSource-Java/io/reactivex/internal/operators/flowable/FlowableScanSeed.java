package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableScanSeed<T, R>
  extends AbstractFlowableWithUpstream<T, R>
{
  final BiFunction<R, ? super T, R> accumulator;
  final Callable<R> seedSupplier;
  
  public FlowableScanSeed(Flowable<T> paramFlowable, Callable<R> paramCallable, BiFunction<R, ? super T, R> paramBiFunction)
  {
    super(paramFlowable);
    this.accumulator = paramBiFunction;
    this.seedSupplier = paramCallable;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class ScanSeedSubscriber<T, R>
    extends AtomicInteger
    implements FlowableSubscriber<T>, Subscription
  {
    private static final long serialVersionUID = -1776795561228106469L;
    final BiFunction<R, ? super T, R> accumulator;
    volatile boolean cancelled;
    int consumed;
    volatile boolean done;
    final Subscriber<? super R> downstream;
    Throwable error;
    final int limit;
    final int prefetch;
    final SimplePlainQueue<R> queue;
    final AtomicLong requested;
    Subscription upstream;
    R value;
    
    ScanSeedSubscriber(Subscriber<? super R> paramSubscriber, BiFunction<R, ? super T, R> paramBiFunction, R paramR, int paramInt)
    {
      this.downstream = paramSubscriber;
      this.accumulator = paramBiFunction;
      this.value = paramR;
      this.prefetch = paramInt;
      this.limit = (paramInt - (paramInt >> 2));
      paramSubscriber = new SpscArrayQueue(paramInt);
      this.queue = paramSubscriber;
      paramSubscriber.offer(paramR);
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
    void drain()
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableScanSeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */