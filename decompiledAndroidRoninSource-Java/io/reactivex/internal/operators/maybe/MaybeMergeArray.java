package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Subscriber;

public final class MaybeMergeArray<T>
  extends Flowable<T>
{
  final MaybeSource<? extends T>[] sources;
  
  public MaybeMergeArray(MaybeSource<? extends T>[] paramArrayOfMaybeSource)
  {
    this.sources = paramArrayOfMaybeSource;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ClqSimpleQueue<T>
    extends ConcurrentLinkedQueue<T>
    implements MaybeMergeArray.SimpleQueueWithConsumerIndex<T>
  {
    private static final long serialVersionUID = -4025173261791142821L;
    int consumerIndex;
    final AtomicInteger producerIndex = new AtomicInteger();
    
    public int consumerIndex()
    {
      return this.consumerIndex;
    }
    
    public void drop()
    {
      poll();
    }
    
    public boolean offer(T paramT)
    {
      return false;
    }
    
    public boolean offer(T paramT1, T paramT2)
    {
      throw new UnsupportedOperationException();
    }
    
    public T poll()
    {
      return null;
    }
    
    public int producerIndex()
    {
      return this.producerIndex.get();
    }
  }
  
  static final class MergeMaybeObserver<T>
    extends BasicIntQueueSubscription<T>
    implements MaybeObserver<T>
  {
    private static final long serialVersionUID = -660395290758764731L;
    volatile boolean cancelled;
    long consumed;
    final Subscriber<? super T> downstream;
    final AtomicThrowable error;
    boolean outputFused;
    final MaybeMergeArray.SimpleQueueWithConsumerIndex<Object> queue;
    final AtomicLong requested;
    final CompositeDisposable set;
    final int sourceCount;
    
    MergeMaybeObserver(Subscriber<? super T> paramSubscriber, int paramInt, MaybeMergeArray.SimpleQueueWithConsumerIndex<Object> paramSimpleQueueWithConsumerIndex)
    {
      this.downstream = paramSubscriber;
      this.sourceCount = paramInt;
      this.set = new CompositeDisposable();
      this.requested = new AtomicLong();
      this.error = new AtomicThrowable();
      this.queue = paramSimpleQueueWithConsumerIndex;
    }
    
    /* Error */
    public void cancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void clear()
    {
      this.queue.clear();
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
    void drainFused()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void drainNormal()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    boolean isCancelled()
    {
      return this.cancelled;
    }
    
    public boolean isEmpty()
    {
      return this.queue.isEmpty();
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
    
    public void onSubscribe(Disposable paramDisposable)
    {
      this.set.add(paramDisposable);
    }
    
    /* Error */
    public void onSuccess(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public T poll()
      throws Exception
    {
      return null;
    }
    
    /* Error */
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    public int requestFusion(int paramInt)
    {
      return 0;
    }
  }
  
  static final class MpscFillOnceSimpleQueue<T>
    extends AtomicReferenceArray<T>
    implements MaybeMergeArray.SimpleQueueWithConsumerIndex<T>
  {
    private static final long serialVersionUID = -7969063454040569579L;
    int consumerIndex;
    final AtomicInteger producerIndex = new AtomicInteger();
    
    MpscFillOnceSimpleQueue(int paramInt)
    {
      super();
    }
    
    /* Error */
    public void clear()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public int consumerIndex()
    {
      return this.consumerIndex;
    }
    
    /* Error */
    public void drop()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean isEmpty()
    {
      return false;
    }
    
    public boolean offer(T paramT)
    {
      return false;
    }
    
    public boolean offer(T paramT1, T paramT2)
    {
      throw new UnsupportedOperationException();
    }
    
    public T peek()
    {
      return null;
    }
    
    public T poll()
    {
      return null;
    }
    
    public int producerIndex()
    {
      return this.producerIndex.get();
    }
  }
  
  static abstract interface SimpleQueueWithConsumerIndex<T>
    extends SimpleQueue<T>
  {
    public abstract int consumerIndex();
    
    public abstract void drop();
    
    public abstract T peek();
    
    public abstract T poll();
    
    public abstract int producerIndex();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeMergeArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */