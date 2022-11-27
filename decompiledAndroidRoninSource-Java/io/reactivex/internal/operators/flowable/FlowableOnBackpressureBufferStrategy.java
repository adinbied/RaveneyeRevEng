package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Action;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureBufferStrategy<T>
  extends AbstractFlowableWithUpstream<T, T>
{
  final long bufferSize;
  final Action onOverflow;
  final BackpressureOverflowStrategy strategy;
  
  public FlowableOnBackpressureBufferStrategy(Flowable<T> paramFlowable, long paramLong, Action paramAction, BackpressureOverflowStrategy paramBackpressureOverflowStrategy)
  {
    super(paramFlowable);
    this.bufferSize = paramLong;
    this.onOverflow = paramAction;
    this.strategy = paramBackpressureOverflowStrategy;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class OnBackpressureBufferStrategySubscriber<T>
    extends AtomicInteger
    implements FlowableSubscriber<T>, Subscription
  {
    private static final long serialVersionUID = 3240706908776709697L;
    final long bufferSize;
    volatile boolean cancelled;
    final Deque<T> deque;
    volatile boolean done;
    final Subscriber<? super T> downstream;
    Throwable error;
    final Action onOverflow;
    final AtomicLong requested;
    final BackpressureOverflowStrategy strategy;
    Subscription upstream;
    
    OnBackpressureBufferStrategySubscriber(Subscriber<? super T> paramSubscriber, Action paramAction, BackpressureOverflowStrategy paramBackpressureOverflowStrategy, long paramLong)
    {
      this.downstream = paramSubscriber;
      this.onOverflow = paramAction;
      this.strategy = paramBackpressureOverflowStrategy;
      this.bufferSize = paramLong;
      this.requested = new AtomicLong();
      this.deque = new ArrayDeque();
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
    void clear(Deque<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void drain()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public void onComplete()
    {
      this.done = true;
      drain();
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableOnBackpressureBufferStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */