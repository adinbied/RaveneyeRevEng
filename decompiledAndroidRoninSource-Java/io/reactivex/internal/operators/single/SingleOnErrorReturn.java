package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public final class SingleOnErrorReturn<T>
  extends Single<T>
{
  final SingleSource<? extends T> source;
  final T value;
  final Function<? super Throwable, ? extends T> valueSupplier;
  
  public SingleOnErrorReturn(SingleSource<? extends T> paramSingleSource, Function<? super Throwable, ? extends T> paramFunction, T paramT)
  {
    this.source = paramSingleSource;
    this.valueSupplier = paramFunction;
    this.value = paramT;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  final class OnErrorReturn
    implements SingleObserver<T>
  {
    private final SingleObserver<? super T> observer;
    
    OnErrorReturn()
    {
      SingleObserver localSingleObserver;
      this.observer = localSingleObserver;
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      this.observer.onSubscribe(paramDisposable);
    }
    
    public void onSuccess(T paramT)
    {
      this.observer.onSuccess(paramT);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleOnErrorReturn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */