package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.internal.observers.DeferredScalarDisposable;

public final class MaybeToObservable<T>
  extends Observable<T>
  implements HasUpstreamMaybeSource<T>
{
  final MaybeSource<T> source;
  
  public MaybeToObservable(MaybeSource<T> paramMaybeSource)
  {
    this.source = paramMaybeSource;
  }
  
  public static <T> MaybeObserver<T> create(Observer<? super T> paramObserver)
  {
    return new MaybeToObservableObserver(paramObserver);
  }
  
  public MaybeSource<T> source()
  {
    return this.source;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class MaybeToObservableObserver<T>
    extends DeferredScalarDisposable<T>
    implements MaybeObserver<T>
  {
    private static final long serialVersionUID = 7603343402964826922L;
    Disposable upstream;
    
    MaybeToObservableObserver(Observer<? super T> paramObserver)
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
    
    public void onComplete()
    {
      complete();
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeToObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */