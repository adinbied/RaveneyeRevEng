package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableBufferBoundary<T, U extends Collection<? super T>, Open, Close>
  extends AbstractObservableWithUpstream<T, U>
{
  final Function<? super Open, ? extends ObservableSource<? extends Close>> bufferClose;
  final ObservableSource<? extends Open> bufferOpen;
  final Callable<U> bufferSupplier;
  
  public ObservableBufferBoundary(ObservableSource<T> paramObservableSource, ObservableSource<? extends Open> paramObservableSource1, Function<? super Open, ? extends ObservableSource<? extends Close>> paramFunction, Callable<U> paramCallable)
  {
    super(paramObservableSource);
    this.bufferOpen = paramObservableSource1;
    this.bufferClose = paramFunction;
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
  
  static final class BufferBoundaryObserver<T, C extends Collection<? super T>, Open, Close>
    extends AtomicInteger
    implements Observer<T>, Disposable
  {
    private static final long serialVersionUID = -8466418554264089604L;
    final Function<? super Open, ? extends ObservableSource<? extends Close>> bufferClose;
    final ObservableSource<? extends Open> bufferOpen;
    final Callable<C> bufferSupplier;
    Map<Long, C> buffers;
    volatile boolean cancelled;
    volatile boolean done;
    final Observer<? super C> downstream;
    final AtomicThrowable errors;
    long index;
    final CompositeDisposable observers;
    final SpscLinkedArrayQueue<C> queue;
    final AtomicReference<Disposable> upstream;
    
    BufferBoundaryObserver(Observer<? super C> paramObserver, ObservableSource<? extends Open> paramObservableSource, Function<? super Open, ? extends ObservableSource<? extends Close>> paramFunction, Callable<C> paramCallable)
    {
      this.downstream = paramObserver;
      this.bufferSupplier = paramCallable;
      this.bufferOpen = paramObservableSource;
      this.bufferClose = paramFunction;
      this.queue = new SpscLinkedArrayQueue(Observable.bufferSize());
      this.observers = new CompositeDisposable();
      this.upstream = new AtomicReference();
      this.buffers = new LinkedHashMap();
      this.errors = new AtomicThrowable();
    }
    
    /* Error */
    void boundaryError(Disposable arg1, Throwable arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void close(ObservableBufferBoundary.BufferCloseObserver<T, C> arg1, long arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void drain()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean isDisposed()
    {
      return false;
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
      //   2: return
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
    
    /* Error */
    void open(Open arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void openComplete(BufferOpenObserver<Open> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    static final class BufferOpenObserver<Open>
      extends AtomicReference<Disposable>
      implements Observer<Open>, Disposable
    {
      private static final long serialVersionUID = -8498650778633225126L;
      final ObservableBufferBoundary.BufferBoundaryObserver<?, ?, Open, ?> parent;
      
      BufferOpenObserver(ObservableBufferBoundary.BufferBoundaryObserver<?, ?, Open, ?> paramBufferBoundaryObserver)
      {
        this.parent = paramBufferBoundaryObserver;
      }
      
      public void dispose()
      {
        DisposableHelper.dispose(this);
      }
      
      public boolean isDisposed()
      {
        return false;
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
      
      public void onNext(Open paramOpen)
      {
        this.parent.open(paramOpen);
      }
      
      public void onSubscribe(Disposable paramDisposable)
      {
        DisposableHelper.setOnce(this, paramDisposable);
      }
    }
  }
  
  static final class BufferCloseObserver<T, C extends Collection<? super T>>
    extends AtomicReference<Disposable>
    implements Observer<Object>, Disposable
  {
    private static final long serialVersionUID = -8498650778633225126L;
    final long index;
    final ObservableBufferBoundary.BufferBoundaryObserver<T, C, ?, ?> parent;
    
    BufferCloseObserver(ObservableBufferBoundary.BufferBoundaryObserver<T, C, ?, ?> paramBufferBoundaryObserver, long paramLong)
    {
      this.parent = paramBufferBoundaryObserver;
      this.index = paramLong;
    }
    
    public void dispose()
    {
      DisposableHelper.dispose(this);
    }
    
    public boolean isDisposed()
    {
      return false;
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
    public void onNext(Object arg1)
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
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableBufferBoundary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */