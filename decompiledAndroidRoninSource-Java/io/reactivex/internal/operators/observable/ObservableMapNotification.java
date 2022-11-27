package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;

public final class ObservableMapNotification<T, R>
  extends AbstractObservableWithUpstream<T, ObservableSource<? extends R>>
{
  final Callable<? extends ObservableSource<? extends R>> onCompleteSupplier;
  final Function<? super Throwable, ? extends ObservableSource<? extends R>> onErrorMapper;
  final Function<? super T, ? extends ObservableSource<? extends R>> onNextMapper;
  
  public ObservableMapNotification(ObservableSource<T> paramObservableSource, Function<? super T, ? extends ObservableSource<? extends R>> paramFunction, Function<? super Throwable, ? extends ObservableSource<? extends R>> paramFunction1, Callable<? extends ObservableSource<? extends R>> paramCallable)
  {
    super(paramObservableSource);
    this.onNextMapper = paramFunction;
    this.onErrorMapper = paramFunction1;
    this.onCompleteSupplier = paramCallable;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super ObservableSource<? extends R>> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class MapNotificationObserver<T, R>
    implements Observer<T>, Disposable
  {
    final Observer<? super ObservableSource<? extends R>> downstream;
    final Callable<? extends ObservableSource<? extends R>> onCompleteSupplier;
    final Function<? super Throwable, ? extends ObservableSource<? extends R>> onErrorMapper;
    final Function<? super T, ? extends ObservableSource<? extends R>> onNextMapper;
    Disposable upstream;
    
    MapNotificationObserver(Observer<? super ObservableSource<? extends R>> paramObserver, Function<? super T, ? extends ObservableSource<? extends R>> paramFunction, Function<? super Throwable, ? extends ObservableSource<? extends R>> paramFunction1, Callable<? extends ObservableSource<? extends R>> paramCallable)
    {
      this.downstream = paramObserver;
      this.onNextMapper = paramFunction;
      this.onErrorMapper = paramFunction1;
      this.onCompleteSupplier = paramCallable;
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
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableMapNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */