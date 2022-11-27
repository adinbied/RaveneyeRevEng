package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public final class ObservableOnErrorReturn<T>
  extends AbstractObservableWithUpstream<T, T>
{
  final Function<? super Throwable, ? extends T> valueSupplier;
  
  public ObservableOnErrorReturn(ObservableSource<T> paramObservableSource, Function<? super Throwable, ? extends T> paramFunction)
  {
    super(paramObservableSource);
    this.valueSupplier = paramFunction;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class OnErrorReturnObserver<T>
    implements Observer<T>, Disposable
  {
    final Observer<? super T> downstream;
    Disposable upstream;
    final Function<? super Throwable, ? extends T> valueSupplier;
    
    OnErrorReturnObserver(Observer<? super T> paramObserver, Function<? super Throwable, ? extends T> paramFunction)
    {
      this.downstream = paramObserver;
      this.valueSupplier = paramFunction;
    }
    
    public void dispose()
    {
      this.upstream.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.upstream.isDisposed();
    }
    
    public void onComplete()
    {
      this.downstream.onComplete();
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public void onNext(T paramT)
    {
      this.downstream.onNext(paramT);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableOnErrorReturn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */