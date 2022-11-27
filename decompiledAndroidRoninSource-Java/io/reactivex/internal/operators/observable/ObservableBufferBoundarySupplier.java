package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.observers.DisposableObserver;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableBufferBoundarySupplier<T, U extends Collection<? super T>, B>
  extends AbstractObservableWithUpstream<T, U>
{
  final Callable<? extends ObservableSource<B>> boundarySupplier;
  final Callable<U> bufferSupplier;
  
  public ObservableBufferBoundarySupplier(ObservableSource<T> paramObservableSource, Callable<? extends ObservableSource<B>> paramCallable, Callable<U> paramCallable1)
  {
    super(paramObservableSource);
    this.boundarySupplier = paramCallable;
    this.bufferSupplier = paramCallable1;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super U> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class BufferBoundaryObserver<T, U extends Collection<? super T>, B>
    extends DisposableObserver<B>
  {
    boolean once;
    final ObservableBufferBoundarySupplier.BufferBoundarySupplierObserver<T, U, B> parent;
    
    BufferBoundaryObserver(ObservableBufferBoundarySupplier.BufferBoundarySupplierObserver<T, U, B> paramBufferBoundarySupplierObserver)
    {
      this.parent = paramBufferBoundarySupplierObserver;
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
    
    public void onNext(B paramB)
    {
      if (this.once) {
        return;
      }
      this.once = true;
      dispose();
      this.parent.next();
    }
  }
  
  static final class BufferBoundarySupplierObserver<T, U extends Collection<? super T>, B>
    extends QueueDrainObserver<T, U, U>
    implements Observer<T>, Disposable
  {
    final Callable<? extends ObservableSource<B>> boundarySupplier;
    U buffer;
    final Callable<U> bufferSupplier;
    final AtomicReference<Disposable> other = new AtomicReference();
    Disposable upstream;
    
    BufferBoundarySupplierObserver(Observer<? super U> paramObserver, Callable<U> paramCallable, Callable<? extends ObservableSource<B>> paramCallable1)
    {
      super(new MpscLinkedQueue());
      this.bufferSupplier = paramCallable;
      this.boundarySupplier = paramCallable1;
    }
    
    public void accept(Observer<? super U> paramObserver, U paramU)
    {
      this.downstream.onNext(paramU);
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    void disposeOther()
    {
      DisposableHelper.dispose(this.other);
    }
    
    public boolean isDisposed()
    {
      return this.cancelled;
    }
    
    /* Error */
    void next()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
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
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableBufferBoundarySupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */