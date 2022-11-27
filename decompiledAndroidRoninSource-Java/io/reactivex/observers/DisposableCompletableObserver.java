package io.reactivex.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public abstract class DisposableCompletableObserver
  implements CompletableObserver, Disposable
{
  final AtomicReference<Disposable> upstream = new AtomicReference();
  
  public final void dispose()
  {
    DisposableHelper.dispose(this.upstream);
  }
  
  public final boolean isDisposed()
  {
    return false;
  }
  
  protected void onStart() {}
  
  /* Error */
  public final void onSubscribe(Disposable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\observers\DisposableCompletableObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */