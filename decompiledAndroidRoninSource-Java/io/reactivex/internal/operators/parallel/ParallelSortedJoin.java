package io.reactivex.internal.operators.parallel;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelSortedJoin<T>
  extends Flowable<T>
{
  final Comparator<? super T> comparator;
  final ParallelFlowable<List<T>> source;
  
  public ParallelSortedJoin(ParallelFlowable<List<T>> paramParallelFlowable, Comparator<? super T> paramComparator)
  {
    this.source = paramParallelFlowable;
    this.comparator = paramComparator;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class SortedJoinInnerSubscriber<T>
    extends AtomicReference<Subscription>
    implements FlowableSubscriber<List<T>>
  {
    private static final long serialVersionUID = 6751017204873808094L;
    final int index;
    final ParallelSortedJoin.SortedJoinSubscription<T> parent;
    
    SortedJoinInnerSubscriber(ParallelSortedJoin.SortedJoinSubscription<T> paramSortedJoinSubscription, int paramInt)
    {
      this.parent = paramSortedJoinSubscription;
      this.index = paramInt;
    }
    
    void cancel()
    {
      SubscriptionHelper.cancel(this);
    }
    
    public void onComplete() {}
    
    public void onError(Throwable paramThrowable)
    {
      this.parent.innerError(paramThrowable);
    }
    
    public void onNext(List<T> paramList)
    {
      this.parent.innerNext(paramList, this.index);
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
  
  static final class SortedJoinSubscription<T>
    extends AtomicInteger
    implements Subscription
  {
    private static final long serialVersionUID = 3481980673745556697L;
    volatile boolean cancelled;
    final Comparator<? super T> comparator;
    final Subscriber<? super T> downstream;
    final AtomicReference<Throwable> error = new AtomicReference();
    final int[] indexes;
    final List<T>[] lists;
    final AtomicInteger remaining = new AtomicInteger();
    final AtomicLong requested = new AtomicLong();
    final ParallelSortedJoin.SortedJoinInnerSubscriber<T>[] subscribers;
    
    SortedJoinSubscription(Subscriber<? super T> paramSubscriber, int paramInt, Comparator<? super T> paramComparator)
    {
      this.downstream = paramSubscriber;
      this.comparator = paramComparator;
      paramSubscriber = new ParallelSortedJoin.SortedJoinInnerSubscriber[paramInt];
      int i = 0;
      while (i < paramInt)
      {
        paramSubscriber[i] = new ParallelSortedJoin.SortedJoinInnerSubscriber(this, i);
        i += 1;
      }
      this.subscribers = paramSubscriber;
      this.lists = new List[paramInt];
      this.indexes = new int[paramInt];
      this.remaining.lazySet(paramInt);
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
    void drain()
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
    
    /* Error */
    void innerNext(List<T> arg1, int arg2)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\parallel\ParallelSortedJoin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */