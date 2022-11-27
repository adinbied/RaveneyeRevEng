package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatMap<T, U>
  extends AbstractObservableWithUpstream<T, U>
{
  final int bufferSize;
  final ErrorMode delayErrors;
  final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
  
  public ObservableConcatMap(ObservableSource<T> paramObservableSource, Function<? super T, ? extends ObservableSource<? extends U>> paramFunction, int paramInt, ErrorMode paramErrorMode)
  {
    super(paramObservableSource);
    this.mapper = paramFunction;
    this.delayErrors = paramErrorMode;
    this.bufferSize = Math.max(8, paramInt);
  }
  
  /* Error */
  public void subscribeActual(Observer<? super U> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ConcatMapDelayErrorObserver<T, R>
    extends AtomicInteger
    implements Observer<T>, Disposable
  {
    private static final long serialVersionUID = -6951100001833242599L;
    volatile boolean active;
    final int bufferSize;
    volatile boolean cancelled;
    volatile boolean done;
    final Observer<? super R> downstream;
    final AtomicThrowable error;
    final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
    final DelayErrorInnerObserver<R> observer;
    SimpleQueue<T> queue;
    int sourceMode;
    final boolean tillTheEnd;
    Disposable upstream;
    
    ConcatMapDelayErrorObserver(Observer<? super R> paramObserver, Function<? super T, ? extends ObservableSource<? extends R>> paramFunction, int paramInt, boolean paramBoolean)
    {
      this.downstream = paramObserver;
      this.mapper = paramFunction;
      this.bufferSize = paramInt;
      this.tillTheEnd = paramBoolean;
      this.error = new AtomicThrowable();
      this.observer = new DelayErrorInnerObserver(paramObserver, this);
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void drain()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public boolean isDisposed()
    {
      return this.cancelled;
    }
    
    public void onComplete()
    {
      this.done = true;
      drain();
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
    
    static final class DelayErrorInnerObserver<R>
      extends AtomicReference<Disposable>
      implements Observer<R>
    {
      private static final long serialVersionUID = 2620149119579502636L;
      final Observer<? super R> downstream;
      final ObservableConcatMap.ConcatMapDelayErrorObserver<?, R> parent;
      
      DelayErrorInnerObserver(Observer<? super R> paramObserver, ObservableConcatMap.ConcatMapDelayErrorObserver<?, R> paramConcatMapDelayErrorObserver)
      {
        this.downstream = paramObserver;
        this.parent = paramConcatMapDelayErrorObserver;
      }
      
      void dispose()
      {
        DisposableHelper.dispose(this);
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
      
      public void onNext(R paramR)
      {
        this.downstream.onNext(paramR);
      }
      
      public void onSubscribe(Disposable paramDisposable)
      {
        DisposableHelper.replace(this, paramDisposable);
      }
    }
  }
  
  static final class SourceObserver<T, U>
    extends AtomicInteger
    implements Observer<T>, Disposable
  {
    private static final long serialVersionUID = 8828587559905699186L;
    volatile boolean active;
    final int bufferSize;
    volatile boolean disposed;
    volatile boolean done;
    final Observer<? super U> downstream;
    int fusionMode;
    final InnerObserver<U> inner;
    final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
    SimpleQueue<T> queue;
    Disposable upstream;
    
    SourceObserver(Observer<? super U> paramObserver, Function<? super T, ? extends ObservableSource<? extends U>> paramFunction, int paramInt)
    {
      this.downstream = paramObserver;
      this.mapper = paramFunction;
      this.bufferSize = paramInt;
      this.inner = new InnerObserver(paramObserver, this);
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void drain()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    void innerComplete()
    {
      this.active = false;
      drain();
    }
    
    public boolean isDisposed()
    {
      return this.disposed;
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
    
    static final class InnerObserver<U>
      extends AtomicReference<Disposable>
      implements Observer<U>
    {
      private static final long serialVersionUID = -7449079488798789337L;
      final Observer<? super U> downstream;
      final ObservableConcatMap.SourceObserver<?, ?> parent;
      
      InnerObserver(Observer<? super U> paramObserver, ObservableConcatMap.SourceObserver<?, ?> paramSourceObserver)
      {
        this.downstream = paramObserver;
        this.parent = paramSourceObserver;
      }
      
      void dispose()
      {
        DisposableHelper.dispose(this);
      }
      
      public void onComplete()
      {
        this.parent.innerComplete();
      }
      
      /* Error */
      public void onError(Throwable arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
      
      public void onNext(U paramU)
      {
        this.downstream.onNext(paramU);
      }
      
      public void onSubscribe(Disposable paramDisposable)
      {
        DisposableHelper.replace(this, paramDisposable);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableConcatMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */