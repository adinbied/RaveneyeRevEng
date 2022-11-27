package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToObservable;

public final class ObservableElementAtSingle<T>
  extends Single<T>
  implements FuseToObservable<T>
{
  final T defaultValue;
  final long index;
  final ObservableSource<T> source;
  
  public ObservableElementAtSingle(ObservableSource<T> paramObservableSource, long paramLong, T paramT)
  {
    this.source = paramObservableSource;
    this.index = paramLong;
    this.defaultValue = paramT;
  }
  
  public Observable<T> fuseToObservable()
  {
    return null;
  }
  
  /* Error */
  public void subscribeActual(SingleObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ElementAtObserver<T>
    implements Observer<T>, Disposable
  {
    long count;
    final T defaultValue;
    boolean done;
    final SingleObserver<? super T> downstream;
    final long index;
    Disposable upstream;
    
    ElementAtObserver(SingleObserver<? super T> paramSingleObserver, long paramLong, T paramT)
    {
      this.downstream = paramSingleObserver;
      this.index = paramLong;
      this.defaultValue = paramT;
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
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableElementAtSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */