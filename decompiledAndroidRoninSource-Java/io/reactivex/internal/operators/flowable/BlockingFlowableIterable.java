package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.reactivestreams.Subscription;

public final class BlockingFlowableIterable<T>
  implements Iterable<T>
{
  final int bufferSize;
  final Flowable<T> source;
  
  public BlockingFlowableIterable(Flowable<T> paramFlowable, int paramInt)
  {
    this.source = paramFlowable;
    this.bufferSize = paramInt;
  }
  
  public Iterator<T> iterator()
  {
    return null;
  }
  
  static final class BlockingFlowableIterator<T>
    extends AtomicReference<Subscription>
    implements FlowableSubscriber<T>, Iterator<T>, Runnable, Disposable
  {
    private static final long serialVersionUID = 6695226475494099826L;
    final long batchSize;
    final Condition condition;
    volatile boolean done;
    Throwable error;
    final long limit;
    final Lock lock;
    long produced;
    final SpscArrayQueue<T> queue;
    
    BlockingFlowableIterator(int paramInt)
    {
      this.queue = new SpscArrayQueue(paramInt);
      this.batchSize = paramInt;
      this.limit = (paramInt - (paramInt >> 2));
      ReentrantLock localReentrantLock = new ReentrantLock();
      this.lock = localReentrantLock;
      this.condition = localReentrantLock.newCondition();
    }
    
    public void dispose()
    {
      SubscriptionHelper.cancel(this);
    }
    
    public boolean hasNext()
    {
      return false;
    }
    
    public boolean isDisposed()
    {
      return false;
    }
    
    public T next()
    {
      return null;
    }
    
    public void onComplete()
    {
      this.done = true;
      signalConsumer();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.error = paramThrowable;
      this.done = true;
      signalConsumer();
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
      SubscriptionHelper.setOnce(this, paramSubscription, this.batchSize);
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("remove");
    }
    
    public void run()
    {
      SubscriptionHelper.cancel(this);
      signalConsumer();
    }
    
    /* Error */
    void signalConsumer()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\BlockingFlowableIterable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */