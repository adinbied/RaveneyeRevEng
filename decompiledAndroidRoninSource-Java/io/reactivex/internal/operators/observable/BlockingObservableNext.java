package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.ObservableSource;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class BlockingObservableNext<T>
  implements Iterable<T>
{
  final ObservableSource<T> source;
  
  public BlockingObservableNext(ObservableSource<T> paramObservableSource)
  {
    this.source = paramObservableSource;
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
    private final ObservableSource<T> items;
    private T next;
    private final BlockingObservableNext.NextObserver<T> observer;
    private boolean started;
    
    NextIterator(ObservableSource<T> paramObservableSource, BlockingObservableNext.NextObserver<T> paramNextObserver)
    {
      this.items = paramObservableSource;
      this.observer = paramNextObserver;
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
  
  static final class NextObserver<T>
    extends DisposableObserver<Notification<T>>
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\BlockingObservableNext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */