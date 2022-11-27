package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;

public abstract interface ResettableConnectable
{
  public abstract void resetIf(Disposable paramDisposable);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\disposables\ResettableConnectable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */