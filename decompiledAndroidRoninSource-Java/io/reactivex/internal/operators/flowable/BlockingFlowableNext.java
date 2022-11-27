package io.reactivex.internal.operators.flowable;

import io.reactivex.Notification;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;

public final class BlockingFlowableNext<T>
  implements Iterable<T>
{
  final Publisher<? extends T> source;
  
  public BlockingFlowableNext(Publisher<? extends T> paramPublisher)
  {
    this.source = paramPublisher;
  }
  
  public Iterator<T> iterator()
  {
    return null;
  }
  
  static final class NextIterator<T>
    implements Iterator<T>
  {
    private Throwable error;
    private boolean hasNext = true;
    private boolean isNextConsumed = true;
    private final Publisher<? extends T> items;
    private T next;
    private boolean started;
    private final BlockingFlowableNext.NextSubscriber<T> subscriber;
    
    NextIterator(Publisher<? extends T> paramPublisher, BlockingFlowableNext.NextSubscriber<T> paramNextSubscriber)
    {
      this.items = paramPublisher;
      this.subscriber = paramNextSubscriber;
    }
    
    private boolean moveToNext()
    {
      return false;
    }
    
    public boolean hasNext()
    {
      return false;
    }
    
    public T next()
    {
      return null;
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("Read only iterator");
    }
  }
  
  static final class NextSubscriber<T>
    extends DisposableSubscriber<Notification<T>>
  {
    private final BlockingQueue<Notification<T>> buf = new ArrayBlockingQueue(1);
    final AtomicInteger waiting = new AtomicInteger();
    
    public void onComplete() {}
    
    public void onError(Throwable paramThrowable)
    {
      RxJavaPlugins.onError(paramThrowable);
    }
    
    /* Error */
    public void onNext(Notification<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    void setWaiting()
    {
      this.waiting.set(1);
    }
    
    public Notification<T> takeNext()
      throws InterruptedException
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\BlockingFlowableNext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */