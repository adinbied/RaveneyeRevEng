package io.reactivex;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;

public abstract interface ObservableEmitter<T>
  extends Emitter<T>
{
  public abstract boolean isDisposed();
  
  public abstract ObservableEmitter<T> serialize();
  
  public abstract void setCancellable(Cancellable paramCancellable);
  
  public abstract void setDisposable(Disposable paramDisposable);
  
  public abstract boolean tryOnError(Throwable paramThrowable);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\ObservableEmitter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */