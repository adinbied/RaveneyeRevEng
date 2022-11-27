package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public final class SingleDoOnSuccess<T>
  extends Single<T>
{
  final Consumer<? super T> onSuccess;
  final SingleSource<T> source;
  
  public SingleDoOnSuccess(SingleSource<T> paramSingleSource, Consumer<? super T> paramConsumer)
  {
    this.source = paramSingleSource;
    this.onSuccess = paramConsumer;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  final class DoOnSuccess
    implements SingleObserver<T>
  {
    final SingleObserver<? super T> downstream;
    
    DoOnSuccess()
    {
      SingleObserver localSingleObserver;
      this.downstream = localSingleObserver;
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.downstream.onError(paramThrowable);
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      this.downstream.onSubscribe(paramDisposable);
    }
    
    /* Error */
    public void onSuccess(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleDoOnSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */