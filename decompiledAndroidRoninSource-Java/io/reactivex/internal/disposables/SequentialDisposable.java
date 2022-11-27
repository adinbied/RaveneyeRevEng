package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

public final class SequentialDisposable
  extends AtomicReference<Disposable>
  implements Disposable
{
  private static final long serialVersionUID = -754898800686245608L;
  
  public SequentialDisposable() {}
  
  public SequentialDisposable(Disposable paramDisposable)
  {
    lazySet(paramDisposable);
  }
  
  public void dispose()
  {
    DisposableHelper.dispose(this);
  }
  
  public boolean isDisposed()
  {
    return false;
  }
  
  public boolean replace(Disposable paramDisposable)
  {
    return DisposableHelper.replace(this, paramDisposable);
  }
  
  public boolean update(Disposable paramDisposable)
  {
    return DisposableHelper.set(this, paramDisposable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\disposables\SequentialDisposable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */