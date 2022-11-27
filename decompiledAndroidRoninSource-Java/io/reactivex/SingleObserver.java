package io.reactivex;

import io.reactivex.disposables.Disposable;

public abstract interface SingleObserver<T>
{
  public abstract void onError(Throwable paramThrowable);
  
  public abstract void onSubscribe(Disposable paramDisposable);
  
  public abstract void onSuccess(T paramT);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\SingleObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */