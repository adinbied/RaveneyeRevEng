package io.reactivex.disposables;

import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

abstract class ReferenceDisposable<T>
  extends AtomicReference<T>
  implements Disposable
{
  private static final long serialVersionUID = 6537757548749041217L;
  
  ReferenceDisposable(T paramT)
  {
    super(ObjectHelper.requireNonNull(paramT, "value is null"));
  }
  
  /* Error */
  public final void dispose()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public final boolean isDisposed()
  {
    return false;
  }
  
  protected abstract void onDisposed(T paramT);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\disposables\ReferenceDisposable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */