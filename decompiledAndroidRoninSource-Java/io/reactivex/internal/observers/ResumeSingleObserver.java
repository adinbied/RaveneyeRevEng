package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ResumeSingleObserver<T>
  implements SingleObserver<T>
{
  final SingleObserver<? super T> downstream;
  final AtomicReference<Disposable> parent;
  
  public ResumeSingleObserver(AtomicReference<Disposable> paramAtomicReference, SingleObserver<? super T> paramSingleObserver)
  {
    this.parent = paramAtomicReference;
    this.downstream = paramSingleObserver;
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.downstream.onError(paramThrowable);
  }
  
  public void onSubscribe(Disposable paramDisposable)
  {
    DisposableHelper.replace(this.parent, paramDisposable);
  }
  
  public void onSuccess(T paramT)
  {
    this.downstream.onSuccess(paramT);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\observers\ResumeSingleObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */