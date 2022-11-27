package io.reactivex.disposables;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

final class FutureDisposable
  extends AtomicReference<Future<?>>
  implements Disposable
{
  private static final long serialVersionUID = 6545242830671168775L;
  private final boolean allowInterrupt;
  
  FutureDisposable(Future<?> paramFuture, boolean paramBoolean)
  {
    super(paramFuture);
    this.allowInterrupt = paramBoolean;
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\disposables\FutureDisposable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */