package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.fuseable.FuseToObservable;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class ObservableToListSingle<T, U extends Collection<? super T>>
  extends Single<U>
  implements FuseToObservable<U>
{
  final Callable<U> collectionSupplier;
  final ObservableSource<T> source;
  
  public ObservableToListSingle(ObservableSource<T> paramObservableSource, int paramInt)
  {
    this.source = paramObservableSource;
    this.collectionSupplier = Functions.createArrayList(paramInt);
  }
  
  public ObservableToListSingle(ObservableSource<T> paramObservableSource, Callable<U> paramCallable)
  {
    this.source = paramObservableSource;
    this.collectionSupplier = paramCallable;
  }
  
  public Observable<U> fuseToObservable()
  {
    return null;
  }
  
  /* Error */
  public void subscribeActual(SingleObserver<? super U> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class ToListObserver<T, U extends Collection<? super T>>
    implements Observer<T>, Disposable
  {
    U collection;
    final SingleObserver<? super U> downstream;
    Disposable upstream;
    
    ToListObserver(SingleObserver<? super U> paramSingleObserver, U paramU)
    {
      this.downstream = paramSingleObserver;
      this.collection = paramU;
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
    
    public void onNext(T paramT)
    {
      this.collection.add(paramT);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableToListSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */