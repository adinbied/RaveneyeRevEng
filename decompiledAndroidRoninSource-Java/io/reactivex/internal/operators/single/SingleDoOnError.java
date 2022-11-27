package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public final class SingleDoOnError<T>
  extends Single<T>
{
  final Consumer<? super Throwable> onError;
  final SingleSource<T> source;
  
  public SingleDoOnError(SingleSource<T> paramSingleSource, Consumer<? super Throwable> paramConsumer)
  {
    this.source = paramSingleSource;
    this.onError = paramConsumer;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  final class DoOnError
    implements SingleObserver<T>
  {
    private final SingleObserver<? super T> downstream;
    
    DoOnError()
    {
      SingleObserver localSingleObserver;
      this.downstream = localSingleObserver;
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
      this.downstream.onSubscribe(paramDisposable);
    }
    
    public void onSuccess(T paramT)
    {
      this.downstream.onSuccess(paramT);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleDoOnError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */