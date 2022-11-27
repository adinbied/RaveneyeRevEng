package io.reactivex.internal.operators.flowable;

import io.reactivex.Notification;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import java.util.Iterator;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;

public final class BlockingFlowableLatest<T>
  implements Iterable<T>
{
  final Publisher<? extends T> source;
  
  public BlockingFlowableLatest(Publisher<? extends T> paramPublisher)
  {
    this.source = paramPublisher;
  }
  
  public Iterator<T> iterator()
  {
    return null;
  }
  
  static final class LatestSubscriberIterator<T>
    extends DisposableSubscriber<Notification<T>>
    implements Iterator<T>
  {
    Notification<T> iteratorNotification;
    final Semaphore notify = new Semaphore(0);
    final AtomicReference<Notification<T>> value = new AtomicReference();
    
    public boolean hasNext()
    {
      return false;
    }
    
    public T next()
    {
      return null;
    }
    
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
    
    public void remove()
    {
      throw new UnsupportedOperationException("Read-only iterator.");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\BlockingFlowableLatest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */