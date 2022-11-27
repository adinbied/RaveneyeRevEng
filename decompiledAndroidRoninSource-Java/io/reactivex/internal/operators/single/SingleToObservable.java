package io.reactivex.internal.operators.single;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.observers.DeferredScalarDisposable;

public final class SingleToObservable<T>
  extends Observable<T>
{
  final SingleSource<? extends T> source;
  
  public SingleToObservable(SingleSource<? extends T> paramSingleSource)
  {
    this.source = paramSingleSource;
  }
  
  public static <T> SingleObserver<T> create(Observer<? super T> paramObserver)
  {
    return new SingleToObservableObserver(paramObserver);
  }
  
  /* Error */
  public void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class SingleToObservableObserver<T>
    extends DeferredScalarDisposable<T>
    implements SingleObserver<T>
  {
    private static final long serialVersionUID = 3786543492451018833L;
    Disposable upstream;
    
    SingleToObservableObserver(Observer<? super T> paramObserver)
    {
      super();
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onError(Throwable paramThrowable)
    {
      error(paramThrowable);
    }
    
    /* Error */
    public void onSubscribe(Disposable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onSuccess(T paramT)
    {
      complete(paramT);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleToObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */