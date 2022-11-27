package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiPredicate;

public final class SingleContains<T>
  extends Single<Boolean>
{
  final BiPredicate<Object, Object> comparer;
  final SingleSource<T> source;
  final Object value;
  
  public SingleContains(SingleSource<T> paramSingleSource, Object paramObject, BiPredicate<Object, Object> paramBiPredicate)
  {
    this.source = paramSingleSource;
    this.value = paramObject;
    this.comparer = paramBiPredicate;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super Boolean> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  final class ContainsSingleObserver
    implements SingleObserver<T>
  {
    private final SingleObserver<? super Boolean> downstream;
    
    ContainsSingleObserver()
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleContains.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */