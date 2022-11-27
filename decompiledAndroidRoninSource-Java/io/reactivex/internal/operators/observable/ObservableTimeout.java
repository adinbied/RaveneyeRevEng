package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTimeout<T, U, V>
  extends AbstractObservableWithUpstream<T, T>
{
  final ObservableSource<U> firstTimeoutIndicator;
  final Function<? super T, ? extends ObservableSource<V>> itemTimeoutIndicator;
  final ObservableSource<? extends T> other;
  
  public ObservableTimeout(Observable<T> paramObservable, ObservableSource<U> paramObservableSource, Function<? super T, ? extends ObservableSource<V>> paramFunction, ObservableSource<? extends T> paramObservableSource1)
  {
    super(paramObservable);
    this.firstTimeoutIndicator = paramObservableSource;
    this.itemTimeoutIndicator = paramFunction;
    this.other = paramObservableSource1;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class TimeoutConsumer
    extends AtomicReference<Disposable>
    implements Observer<Object>, Disposable
  {
    private static final long serialVersionUID = 8708641127342403073L;
    final long idx;
    final ObservableTimeout.TimeoutSelectorSupport parent;
    
    TimeoutConsumer(long paramLong, ObservableTimeout.TimeoutSelectorSupport paramTimeoutSelectorSupport)
    {
      this.idx = paramLong;
      this.parent = paramTimeoutSelectorSupport;
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
  
  static final class TimeoutFallbackObserver<T>
    extends AtomicReference<Disposable>
    implements Observer<T>, Disposable, ObservableTimeout.TimeoutSelectorSupport
  {
    private static final long serialVersionUID = -7508389464265974549L;
    final Observer<? super T> downstream;
    ObservableSource<? extends T> fallback;
    final AtomicLong index;
    final Function<? super T, ? extends ObservableSource<?>> itemTimeoutIndicator;
    final SequentialDisposable task;
    final AtomicReference<Disposable> upstream;
    
    TimeoutFallbackObserver(Observer<? super T> paramObserver, Function<? super T, ? extends ObservableSource<?>> paramFunction, ObservableSource<? extends T> paramObservableSource)
    {
      this.downstream = paramObserver;
      this.itemTimeoutIndicator = paramFunction;
      this.task = new SequentialDisposable();
      this.fallback = paramObservableSource;
      this.index = new AtomicLong();
      this.upstream = new AtomicReference();
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
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      DisposableHelper.setOnce(this.upstream, paramDisposable);
    }
    
    /* Error */
    public void onTimeout(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onTimeoutError(long arg1, Throwable arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void startFirstTimeout(ObservableSource<?> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class TimeoutObserver<T>
    extends AtomicLong
    implements Observer<T>, Disposable, ObservableTimeout.TimeoutSelectorSupport
  {
    private static final long serialVersionUID = 3764492702657003550L;
    final Observer<? super T> downstream;
    final Function<? super T, ? extends ObservableSource<?>> itemTimeoutIndicator;
    final SequentialDisposable task;
    final AtomicReference<Disposable> upstream;
    
    TimeoutObserver(Observer<? super T> paramObserver, Function<? super T, ? extends ObservableSource<?>> paramFunction)
    {
      this.downstream = paramObserver;
      this.itemTimeoutIndicator = paramFunction;
      this.task = new SequentialDisposable();
      this.upstream = new AtomicReference();
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
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      DisposableHelper.setOnce(this.upstream, paramDisposable);
    }
    
    /* Error */
    public void onTimeout(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onTimeoutError(long arg1, Throwable arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void startFirstTimeout(ObservableSource<?> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static abstract interface TimeoutSelectorSupport
    extends ObservableTimeoutTimed.TimeoutSupport
  {
    public abstract void onTimeoutError(long paramLong, Throwable paramThrowable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableTimeout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */