package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;
import java.util.concurrent.atomic.AtomicReference;

public final class CancellableDisposable
  extends AtomicReference<Cancellable>
  implements Disposable
{
  private static final long serialVersionUID = 5718521705281392066L;
  
  public CancellableDisposable(Cancellable paramCancellable)
  {
    super(paramCancellable);
  }
  
  /* Error */
  public void dispose()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public boolean isDisposed()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\disposables\CancellableDisposable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */