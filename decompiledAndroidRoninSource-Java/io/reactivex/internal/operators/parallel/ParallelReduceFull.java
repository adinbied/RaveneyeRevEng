package io.reactivex.internal.operators.parallel;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelReduceFull<T>
  extends Flowable<T>
{
  final BiFunction<T, T, T> reducer;
  final ParallelFlowable<? extends T> source;
  
  public ParallelReduceFull(ParallelFlowable<? extends T> paramParallelFlowable, BiFunction<T, T, T> paramBiFunction)
  {
    this.source = paramParallelFlowable;
    this.reducer = paramBiFunction;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ParallelReduceFullInnerSubscriber<T>
    extends AtomicReference<Subscription>
    implements FlowableSubscriber<T>
  {
    private static final long serialVersionUID = -7954444275102466525L;
    boolean done;
    final ParallelReduceFull.ParallelReduceFullMainSubscriber<T> parent;
    final BiFunction<T, T, T> reducer;
    T value;
    
    ParallelReduceFullInnerSubscriber(ParallelReduceFull.ParallelReduceFullMainSubscriber<T> paramParallelReduceFullMainSubscriber, BiFunction<T, T, T> paramBiFunction)
    {
      this.parent = paramParallelReduceFullMainSubscriber;
      this.reducer = paramBiFunction;
    }
    
    void cancel()
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
  }
  
  static final class ParallelReduceFullMainSubscriber<T>
    extends DeferredScalarSubscription<T>
  {
    private static final long serialVersionUID = -5370107872170712765L;
    final AtomicReference<ParallelReduceFull.SlotPair<T>> current = new AtomicReference();
    final AtomicReference<Throwable> error = new AtomicReference();
    final BiFunction<T, T, T> reducer;
    final AtomicInteger remaining = new AtomicInteger();
    final ParallelReduceFull.ParallelReduceFullInnerSubscriber<T>[] subscribers;
    
    ParallelReduceFullMainSubscriber(Subscriber<? super T> paramSubscriber, int paramInt, BiFunction<T, T, T> paramBiFunction)
    {
      super();
      paramSubscriber = new ParallelReduceFull.ParallelReduceFullInnerSubscriber[paramInt];
      int i = 0;
      while (i < paramInt)
      {
        paramSubscriber[i] = new ParallelReduceFull.ParallelReduceFullInnerSubscriber(this, paramBiFunction);
        i += 1;
      }
      this.subscribers = paramSubscriber;
      this.reducer = paramBiFunction;
      this.remaining.lazySet(paramInt);
    }
    
    ParallelReduceFull.SlotPair<T> addValue(T paramT)
    {
      return null;
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
    void innerComplete(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void innerError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class SlotPair<T>
    extends AtomicInteger
  {
    private static final long serialVersionUID = 473971317683868662L;
    T first;
    final AtomicInteger releaseIndex = new AtomicInteger();
    T second;
    
    boolean releaseSlot()
    {
      return false;
    }
    
    int tryAcquireSlot()
    {
      return 0;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\parallel\ParallelReduceFull.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */