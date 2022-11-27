package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.observers.DisposableObserver;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class ObservableBufferExactBoundary<T, U extends Collection<? super T>, B>
  extends AbstractObservableWithUpstream<T, U>
{
  final ObservableSource<B> boundary;
  final Callable<U> bufferSupplier;
  
  public ObservableBufferExactBoundary(ObservableSource<T> paramObservableSource, ObservableSource<B> paramObservableSource1, Callable<U> paramCallable)
  {
    super(paramObservableSource);
    this.boundary = paramObservableSource1;
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
  
  static final class BufferBoundaryObserver<T, U extends Collection<? super T>, B>
    extends DisposableObserver<B>
  {
    final ObservableBufferExactBoundary.BufferExactBoundaryObserver<T, U, B> parent;
    
    BufferBoundaryObserver(ObservableBufferExactBoundary.BufferExactBoundaryObserver<T, U, B> paramBufferExactBoundaryObserver)
    {
      this.parent = paramBufferExactBoundaryObserver;
    }
    
    public void onComplete()
    {
      this.parent.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.parent.onError(paramThrowable);
    }
    
    public void onNext(B paramB)
    {
      this.parent.next();
    }
  }
  
  static final class BufferExactBoundaryObserver<T, U extends Collection<? super T>, B>
    extends QueueDrainObserver<T, U, U>
    implements Observer<T>, Disposable
  {
    final ObservableSource<B> boundary;
    U buffer;
    final Callable<U> bufferSupplier;
    Disposable other;
    Disposable upstream;
    
    BufferExactBoundaryObserver(Observer<? super U> paramObserver, Callable<U> paramCallable, ObservableSource<B> paramObservableSource)
    {
      super(new MpscLinkedQueue());
      this.bufferSupplier = paramCallable;
      this.boundary = paramObservableSource;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableBufferExactBoundary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */