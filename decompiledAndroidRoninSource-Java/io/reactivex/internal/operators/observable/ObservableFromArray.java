package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.observers.BasicQueueDisposable;

public final class ObservableFromArray<T>
  extends Observable<T>
{
  final T[] array;
  
  public ObservableFromArray(T[] paramArrayOfT)
  {
    this.array = paramArrayOfT;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class FromArrayDisposable<T>
    extends BasicQueueDisposable<T>
  {
    final T[] array;
    volatile boolean disposed;
    final Observer<? super T> downstream;
    boolean fusionMode;
    int index;
    
    FromArrayDisposable(Observer<? super T> paramObserver, T[] paramArrayOfT)
    {
      this.downstream = paramObserver;
      this.array = paramArrayOfT;
    }
    
    public void clear()
    {
      this.index = this.array.length;
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
      return false;
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
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableFromArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */