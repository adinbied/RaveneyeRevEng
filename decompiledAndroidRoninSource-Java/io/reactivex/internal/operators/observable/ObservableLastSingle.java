package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public final class ObservableLastSingle<T>
  extends Single<T>
{
  final T defaultItem;
  final ObservableSource<T> source;
  
  public ObservableLastSingle(ObservableSource<T> paramObservableSource, T paramT)
  {
    this.source = paramObservableSource;
    this.defaultItem = paramT;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class LastObserver<T>
    implements Observer<T>, Disposable
  {
    final T defaultItem;
    final SingleObserver<? super T> downstream;
    T item;
    Disposable upstream;
    
    LastObserver(SingleObserver<? super T> paramSingleObserver, T paramT)
    {
      this.downstream = paramSingleObserver;
      this.defaultItem = paramT;
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
      this.item = paramT;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableLastSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */