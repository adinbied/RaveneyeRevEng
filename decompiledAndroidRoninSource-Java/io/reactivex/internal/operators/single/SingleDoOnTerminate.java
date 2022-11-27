package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

public final class SingleDoOnTerminate<T>
  extends Single<T>
{
  final Action onTerminate;
  final SingleSource<T> source;
  
  public SingleDoOnTerminate(SingleSource<T> paramSingleSource, Action paramAction)
  {
    this.source = paramSingleSource;
    this.onTerminate = paramAction;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  final class DoOnTerminate
    implements SingleObserver<T>
  {
    final SingleObserver<? super T> downstream;
    
    DoOnTerminate()
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleDoOnTerminate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */