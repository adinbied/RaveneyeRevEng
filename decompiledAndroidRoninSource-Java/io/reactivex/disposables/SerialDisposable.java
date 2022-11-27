package io.reactivex.disposables;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SerialDisposable
  implements Disposable
{
  final AtomicReference<Disposable> resource;
  
  public SerialDisposable()
  {
    this.resource = new AtomicReference();
  }
  
  public SerialDisposable(Disposable paramDisposable)
  {
    this.resource = new AtomicReference(paramDisposable);
  }
  
  public void dispose()
  {
    DisposableHelper.dispose(this.resource);
  }
  
  public Disposable get()
  {
    return null;
  }
  
  public boolean isDisposed()
  {
    return false;
  }
  
  public boolean replace(Disposable paramDisposable)
  {
    return DisposableHelper.replace(this.resource, paramDisposable);
  }
  
  public boolean set(Disposable paramDisposable)
  {
    return DisposableHelper.set(this.resource, paramDisposable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\disposables\SerialDisposable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */