package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableBuffer<T, U extends Collection<? super T>>
  extends AbstractObservableWithUpstream<T, U>
{
  final Callable<U> bufferSupplier;
  final int count;
  final int skip;
  
  public ObservableBuffer(ObservableSource<T> paramObservableSource, int paramInt1, int paramInt2, Callable<U> paramCallable)
  {
    super(paramObservableSource);
    this.count = paramInt1;
    this.skip = paramInt2;
    this.bufferSupplier = paramCallable;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super U> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class BufferExactObserver<T, U extends Collection<? super T>>
    implements Observer<T>, Disposable
  {
    U buffer;
    final Callable<U> bufferSupplier;
    final int count;
    final Observer<? super U> downstream;
    int size;
    Disposable upstream;
    
    BufferExactObserver(Observer<? super U> paramObserver, int paramInt, Callable<U> paramCallable)
    {
      this.downstream = paramObserver;
      this.count = paramInt;
      this.bufferSupplier = paramCallable;
    }
    
    boolean createBuffer()
    {
      return false;
    }
    
    public void dispose()
    {
      this.upstream.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.upstream.isDisposed();
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
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onSubscribe(Disposable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class BufferSkipObserver<T, U extends Collection<? super T>>
    extends AtomicBoolean
    implements Observer<T>, Disposable
  {
    private static final long serialVersionUID = -8223395059921494546L;
    final Callable<U> bufferSupplier;
    final ArrayDeque<U> buffers;
    final int count;
    final Observer<? super U> downstream;
    long index;
    final int skip;
    Disposable upstream;
    
    BufferSkipObserver(Observer<? super U> paramObserver, int paramInt1, int paramInt2, Callable<U> paramCallable)
    {
      this.downstream = paramObserver;
      this.count = paramInt1;
      this.skip = paramInt2;
      this.bufferSupplier = paramCallable;
      this.buffers = new ArrayDeque();
    }
    
    public void dispose()
    {
      this.upstream.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.upstream.isDisposed();
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
    public void onSubscribe(Disposable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */