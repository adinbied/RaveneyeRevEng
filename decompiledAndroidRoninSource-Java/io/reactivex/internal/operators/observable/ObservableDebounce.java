package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableDebounce<T, U>
  extends AbstractObservableWithUpstream<T, T>
{
  final Function<? super T, ? extends ObservableSource<U>> debounceSelector;
  
  public ObservableDebounce(ObservableSource<T> paramObservableSource, Function<? super T, ? extends ObservableSource<U>> paramFunction)
  {
    super(paramObservableSource);
    this.debounceSelector = paramFunction;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class DebounceObserver<T, U>
    implements Observer<T>, Disposable
  {
    final Function<? super T, ? extends ObservableSource<U>> debounceSelector;
    final AtomicReference<Disposable> debouncer = new AtomicReference();
    boolean done;
    final Observer<? super T> downstream;
    volatile long index;
    Disposable upstream;
    
    DebounceObserver(Observer<? super T> paramObserver, Function<? super T, ? extends ObservableSource<U>> paramFunction)
    {
      this.downstream = paramObserver;
      this.debounceSelector = paramFunction;
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
    void emit(long arg1, T arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
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
    
    static final class DebounceInnerObserver<T, U>
      extends DisposableObserver<U>
    {
      boolean done;
      final long index;
      final AtomicBoolean once = new AtomicBoolean();
      final ObservableDebounce.DebounceObserver<T, U> parent;
      final T value;
      
      DebounceInnerObserver(ObservableDebounce.DebounceObserver<T, U> paramDebounceObserver, long paramLong, T paramT)
      {
        this.parent = paramDebounceObserver;
        this.index = paramLong;
        this.value = paramT;
      }
      
      /* Error */
      void emit()
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
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
      
      public void onNext(U paramU)
      {
        if (this.done) {
          return;
        }
        this.done = true;
        dispose();
        emit();
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableDebounce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */