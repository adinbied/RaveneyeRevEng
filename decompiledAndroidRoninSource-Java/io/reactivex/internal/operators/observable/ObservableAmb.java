package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableAmb<T>
  extends Observable<T>
{
  final ObservableSource<? extends T>[] sources;
  final Iterable<? extends ObservableSource<? extends T>> sourcesIterable;
  
  public ObservableAmb(ObservableSource<? extends T>[] paramArrayOfObservableSource, Iterable<? extends ObservableSource<? extends T>> paramIterable)
  {
    this.sources = paramArrayOfObservableSource;
    this.sourcesIterable = paramIterable;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class AmbCoordinator<T>
    implements Disposable
  {
    final Observer<? super T> downstream;
    final ObservableAmb.AmbInnerObserver<T>[] observers;
    final AtomicInteger winner = new AtomicInteger();
    
    AmbCoordinator(Observer<? super T> paramObserver, int paramInt)
    {
      this.downstream = paramObserver;
      this.observers = new ObservableAmb.AmbInnerObserver[paramInt];
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
    public void subscribe(ObservableSource<? extends T>[] arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean win(int paramInt)
    {
      return false;
    }
  }
  
  static final class AmbInnerObserver<T>
    extends AtomicReference<Disposable>
    implements Observer<T>
  {
    private static final long serialVersionUID = -1185974347409665484L;
    final Observer<? super T> downstream;
    final int index;
    final ObservableAmb.AmbCoordinator<T> parent;
    boolean won;
    
    AmbInnerObserver(ObservableAmb.AmbCoordinator<T> paramAmbCoordinator, int paramInt, Observer<? super T> paramObserver)
    {
      this.parent = paramAmbCoordinator;
      this.index = paramInt;
      this.downstream = paramObserver;
    }
    
    public void dispose()
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
      DisposableHelper.setOnce(this, paramDisposable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableAmb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */