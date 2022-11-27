package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public final class ObservableDematerialize<T, R>
  extends AbstractObservableWithUpstream<T, R>
{
  final Function<? super T, ? extends Notification<R>> selector;
  
  public ObservableDematerialize(ObservableSource<T> paramObservableSource, Function<? super T, ? extends Notification<R>> paramFunction)
  {
    super(paramObservableSource);
    this.selector = paramFunction;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class DematerializeObserver<T, R>
    implements Observer<T>, Disposable
  {
    boolean done;
    final Observer<? super R> downstream;
    final Function<? super T, ? extends Notification<R>> selector;
    Disposable upstream;
    
    DematerializeObserver(Observer<? super R> paramObserver, Function<? super T, ? extends Notification<R>> paramFunction)
    {
      this.downstream = paramObserver;
      this.selector = paramFunction;
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
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableDematerialize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */