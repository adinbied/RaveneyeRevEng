package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.observers.BasicQueueDisposable;
import java.util.Iterator;

public final class ObservableFromIterable<T>
  extends Observable<T>
{
  final Iterable<? extends T> source;
  
  public ObservableFromIterable(Iterable<? extends T> paramIterable)
  {
    this.source = paramIterable;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class FromIterableDisposable<T>
    extends BasicQueueDisposable<T>
  {
    boolean checkNext;
    volatile boolean disposed;
    boolean done;
    final Observer<? super T> downstream;
    boolean fusionMode;
    final Iterator<? extends T> it;
    
    FromIterableDisposable(Observer<? super T> paramObserver, Iterator<? extends T> paramIterator)
    {
      this.downstream = paramObserver;
      this.it = paramIterator;
    }
    
    public void clear()
    {
      this.done = true;
    }
    
    public void dispose()
    {
      this.disposed = true;
    }
    
    public boolean isDisposed()
    {
      return this.disposed;
    }
    
    public boolean isEmpty()
    {
      return this.done;
    }
    
    public T poll()
    {
      return null;
    }
    
    public int requestFusion(int paramInt)
    {
      return 0;
    }
    
    /* Error */
    void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableFromIterable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */