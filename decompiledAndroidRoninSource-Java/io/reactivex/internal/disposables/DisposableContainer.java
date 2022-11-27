package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;

public abstract interface DisposableContainer
{
  public abstract boolean add(Disposable paramDisposable);
  
  public abstract boolean delete(Disposable paramDisposable);
  
  public abstract boolean remove(Disposable paramDisposable);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\disposables\DisposableContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */