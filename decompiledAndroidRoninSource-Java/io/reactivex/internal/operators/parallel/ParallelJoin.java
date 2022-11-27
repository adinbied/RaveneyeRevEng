package io.reactivex.internal.operators.parallel;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.parallel.ParallelFlowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelJoin<T>
  extends Flowable<T>
{
  final boolean delayErrors;
  final int prefetch;
  final ParallelFlowable<? extends T> source;
  
  public ParallelJoin(ParallelFlowable<? extends T> paramParallelFlowable, int paramInt, boolean paramBoolean)
  {
    this.source = paramParallelFlowable;
    this.prefetch = paramInt;
    this.delayErrors = paramBoolean;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class JoinInnerSubscriber<T>
    extends AtomicReference<Subscription>
    implements FlowableSubscriber<T>
  {
    private static final long serialVersionUID = 8410034718427740355L;
    final int limit;
    final ParallelJoin.JoinSubscriptionBase<T> parent;
    final int prefetch;
    long produced;
    volatile SimplePlainQueue<T> queue;
    
    JoinInnerSubscriber(ParallelJoin.JoinSubscriptionBase<T> paramJoinSubscriptionBase, int paramInt)
    {
      this.parent = paramJoinSubscriptionBase;
      this.prefetch = paramInt;
      this.limit = (paramInt - (paramInt >> 2));
    }
    
    public boolean cancel()
    {
      return SubscriptionHelper.cancel(this);
    }
    
    SimplePlainQueue<T> getQueue()
    {
      return null;
    }
    
    public void onComplete()
    {
      this.parent.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.parent.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.parent.onNext(this, paramT);
    }
    
    public void onSubscribe(Subscription paramSubscription)
    {
      SubscriptionHelper.setOnce(this, paramSubscription, this.prefetch);
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
    public void requestOne()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class JoinSubscription<T>
    extends ParallelJoin.JoinSubscriptionBase<T>
  {
    private static final long serialVersionUID = 6312374661811000451L;
    
    JoinSubscription(Subscriber<? super T> paramSubscriber, int paramInt1, int paramInt2)
    {
      super(paramInt1, paramInt2);
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
    void drainLoop()
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
    public void onNext(ParallelJoin.JoinInnerSubscriber<T> arg1, T arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static abstract class JoinSubscriptionBase<T>
    extends AtomicInteger
    implements Subscription
  {
    private static final long serialVersionUID = 3100232009247827843L;
    volatile boolean cancelled;
    final AtomicInteger done = new AtomicInteger();
    final Subscriber<? super T> downstream;
    final AtomicThrowable errors = new AtomicThrowable();
    final AtomicLong requested = new AtomicLong();
    final ParallelJoin.JoinInnerSubscriber<T>[] subscribers;
    
    JoinSubscriptionBase(Subscriber<? super T> paramSubscriber, int paramInt1, int paramInt2)
    {
      this.downstream = paramSubscriber;
      paramSubscriber = new ParallelJoin.JoinInnerSubscriber[paramInt1];
      int i = 0;
      while (i < paramInt1)
      {
        paramSubscriber[i] = new ParallelJoin.JoinInnerSubscriber(this, paramInt2);
        i += 1;
      }
      this.subscribers = paramSubscriber;
      this.done.lazySet(paramInt1);
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
    void cancelAll()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void cleanup()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    abstract void drain();
    
    abstract void onComplete();
    
    abstract void onError(Throwable paramThrowable);
    
    abstract void onNext(ParallelJoin.JoinInnerSubscriber<T> paramJoinInnerSubscriber, T paramT);
    
    /* Error */
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  }
  
  static final class JoinSubscriptionDelayError<T>
    extends ParallelJoin.JoinSubscriptionBase<T>
  {
    private static final long serialVersionUID = -5737965195918321883L;
    
    JoinSubscriptionDelayError(Subscriber<? super T> paramSubscriber, int paramInt1, int paramInt2)
    {
      super(paramInt1, paramInt2);
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
    void drainLoop()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void onNext(ParallelJoin.JoinInnerSubscriber<T> arg1, T arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\parallel\ParallelJoin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */