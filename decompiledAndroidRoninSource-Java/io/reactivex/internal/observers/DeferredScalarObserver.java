package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class DeferredScalarObserver<T, R>
  extends DeferredScalarDisposable<R>
  implements Observer<T>
{
  private static final long serialVersionUID = -266195175408988651L;
  protected Disposable upstream;
  
  public DeferredScalarObserver(Observer<? super R> paramObserver)
  {
    super(paramObserver);
  }
  
  /* Error */
  public void dispose()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onComplete()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.value = null;
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\observers\DeferredScalarObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */