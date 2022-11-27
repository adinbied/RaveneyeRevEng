package io.reactivex.internal.operators.observable;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMapMaybe<T, R>
  extends AbstractObservableWithUpstream<T, R>
{
  final boolean delayErrors;
  final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
  
  public ObservableFlatMapMaybe(ObservableSource<T> paramObservableSource, Function<? super T, ? extends MaybeSource<? extends R>> paramFunction, boolean paramBoolean)
  {
    super(paramObservableSource);
    this.mapper = paramFunction;
    this.delayErrors = paramBoolean;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class FlatMapMaybeObserver<T, R>
    extends AtomicInteger
    implements Observer<T>, Disposable
  {
    private static final long serialVersionUID = 8600231336733376951L;
    final AtomicInteger active;
    volatile boolean cancelled;
    final boolean delayErrors;
    final Observer<? super R> downstream;
    final AtomicThrowable errors;
    final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    final AtomicReference<SpscLinkedArrayQueue<R>> queue;
    final CompositeDisposable set;
    Disposable upstream;
    
    FlatMapMaybeObserver(Observer<? super R> paramObserver, Function<? super T, ? extends MaybeSource<? extends R>> paramFunction, boolean paramBoolean)
    {
      this.downstream = paramObserver;
      this.mapper = paramFunction;
      this.delayErrors = paramBoolean;
      this.set = new CompositeDisposable();
      this.errors = new AtomicThrowable();
      this.active = new AtomicInteger(1);
      this.queue = new AtomicReference();
    }
    
    /* Error */
    void clear()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
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
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void drainLoop()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    SpscLinkedArrayQueue<R> getOrCreateQueue()
    {
      return null;
    }
    
    /* Error */
    void innerComplete(FlatMapMaybeObserver<T, R>.InnerObserver arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void innerError(FlatMapMaybeObserver<T, R>.InnerObserver arg1, Throwable arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void innerSuccess(FlatMapMaybeObserver<T, R>.InnerObserver arg1, R arg2)
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
    
    final class InnerObserver
      extends AtomicReference<Disposable>
      implements MaybeObserver<R>, Disposable
    {
      private static final long serialVersionUID = -502562646270949838L;
      
      InnerObserver() {}
      
      public void dispose()
      {
        DisposableHelper.dispose(this);
      }
      
      public boolean isDisposed()
      {
        return false;
      }
      
      public void onComplete()
      {
        ObservableFlatMapMaybe.FlatMapMaybeObserver.this.innerComplete(this);
      }
      
      public void onError(Throwable paramThrowable)
      {
        ObservableFlatMapMaybe.FlatMapMaybeObserver.this.innerError(this, paramThrowable);
      }
      
      public void onSubscribe(Disposable paramDisposable)
      {
        DisposableHelper.setOnce(this, paramDisposable);
      }
      
      public void onSuccess(R paramR)
      {
        ObservableFlatMapMaybe.FlatMapMaybeObserver.this.innerSuccess(this, paramR);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableFlatMapMaybe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */