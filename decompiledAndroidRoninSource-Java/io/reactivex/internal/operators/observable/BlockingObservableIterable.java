package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class BlockingObservableIterable<T>
  implements Iterable<T>
{
  final int bufferSize;
  final ObservableSource<? extends T> source;
  
  public BlockingObservableIterable(ObservableSource<? extends T> paramObservableSource, int paramInt)
  {
    this.source = paramObservableSource;
    this.bufferSize = paramInt;
  }
  
  public Iterator<T> iterator()
  {
    return null;
  }
  
  static final class BlockingObservableIterator<T>
    extends AtomicReference<Disposable>
    implements Observer<T>, Iterator<T>, Disposable
  {
    private static final long serialVersionUID = 6695226475494099826L;
    final Condition condition;
    volatile boolean done;
    Throwable error;
    final Lock lock;
    final SpscLinkedArrayQueue<T> queue;
    
    BlockingObservableIterator(int paramInt)
    {
      this.queue = new SpscLinkedArrayQueue(paramInt);
      ReentrantLock localReentrantLock = new ReentrantLock();
      this.lock = localReentrantLock;
      this.condition = localReentrantLock.newCondition();
    }
    
    public void dispose()
    {
      DisposableHelper.dispose(this);
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
    
    public void onSubscribe(Disposable paramDisposable)
    {
      DisposableHelper.setOnce(this, paramDisposable);
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("remove");
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\BlockingObservableIterable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */