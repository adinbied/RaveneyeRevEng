package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.FuseToObservable;

public final class ObservableAllSingle<T>
  extends Single<Boolean>
  implements FuseToObservable<Boolean>
{
  final Predicate<? super T> predicate;
  final ObservableSource<T> source;
  
  public ObservableAllSingle(ObservableSource<T> paramObservableSource, Predicate<? super T> paramPredicate)
  {
    this.source = paramObservableSource;
    this.predicate = paramPredicate;
  }
  
  public Observable<Boolean> fuseToObservable()
  {
    return null;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super Boolean> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class AllObserver<T>
    implements Observer<T>, Disposable
  {
    boolean done;
    final SingleObserver<? super Boolean> downstream;
    final Predicate<? super T> predicate;
    Disposable upstream;
    
    AllObserver(SingleObserver<? super Boolean> paramSingleObserver, Predicate<? super T> paramPredicate)
    {
      this.downstream = paramSingleObserver;
      this.predicate = paramPredicate;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableAllSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */