package io.reactivex.observers;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import java.util.concurrent.atomic.AtomicReference;

public abstract class ResourceMaybeObserver<T>
  implements MaybeObserver<T>, Disposable
{
  private final ListCompositeDisposable resources = new ListCompositeDisposable();
  private final AtomicReference<Disposable> upstream = new AtomicReference();
  
  /* Error */
  public final void add(Disposable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\observers\ResourceMaybeObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */