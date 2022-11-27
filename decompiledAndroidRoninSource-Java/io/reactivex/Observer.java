package io.reactivex;

import io.reactivex.disposables.Disposable;

public abstract interface Observer<T>
{
  public abstract void onComplete();
  
  public abstract void onError(Throwable paramThrowable);
  
  public abstract void onNext(T paramT);
  
  public abstract void onSubscribe(Disposable paramDisposable);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\Observer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */