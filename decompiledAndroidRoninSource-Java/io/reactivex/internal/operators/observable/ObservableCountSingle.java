package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToObservable;

public final class ObservableCountSingle<T>
  extends Single<Long>
  implements FuseToObservable<Long>
{
  final ObservableSource<T> source;
  
  public ObservableCountSingle(ObservableSource<T> paramObservableSource)
  {
    this.source = paramObservableSource;
  }
  
  public Observable<Long> fuseToObservable()
  {
    return null;
  }
  
  /* Error */
  public void subscribeActual(SingleObserver<? super Long> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class CountObserver
    implements Observer<Object>, Disposable
  {
    long count;
    final SingleObserver<? super Long> downstream;
    Disposable upstream;
    
    CountObserver(SingleObserver<? super Long> paramSingleObserver)
    {
      this.downstream = paramSingleObserver;
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
    
    public void onNext(Object paramObject)
    {
      this.count += 1L;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableCountSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */