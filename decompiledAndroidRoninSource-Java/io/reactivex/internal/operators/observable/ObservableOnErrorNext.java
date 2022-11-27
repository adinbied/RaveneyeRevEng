package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.SequentialDisposable;

public final class ObservableOnErrorNext<T>
  extends AbstractObservableWithUpstream<T, T>
{
  final boolean allowFatal;
  final Function<? super Throwable, ? extends ObservableSource<? extends T>> nextSupplier;
  
  public ObservableOnErrorNext(ObservableSource<T> paramObservableSource, Function<? super Throwable, ? extends ObservableSource<? extends T>> paramFunction, boolean paramBoolean)
  {
    super(paramObservableSource);
    this.nextSupplier = paramFunction;
    this.allowFatal = paramBoolean;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class OnErrorNextObserver<T>
    implements Observer<T>
  {
    final boolean allowFatal;
    final SequentialDisposable arbiter;
    boolean done;
    final Observer<? super T> downstream;
    final Function<? super Throwable, ? extends ObservableSource<? extends T>> nextSupplier;
    boolean once;
    
    OnErrorNextObserver(Observer<? super T> paramObserver, Function<? super Throwable, ? extends ObservableSource<? extends T>> paramFunction, boolean paramBoolean)
    {
      this.downstream = paramObserver;
      this.nextSupplier = paramFunction;
      this.allowFatal = paramBoolean;
      this.arbiter = new SequentialDisposable();
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
      //   2: return
    }
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      this.arbiter.replace(paramDisposable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableOnErrorNext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */