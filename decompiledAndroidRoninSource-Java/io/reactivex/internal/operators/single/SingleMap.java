package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public final class SingleMap<T, R>
  extends Single<R>
{
  final Function<? super T, ? extends R> mapper;
  final SingleSource<? extends T> source;
  
  public SingleMap(SingleSource<? extends T> paramSingleSource, Function<? super T, ? extends R> paramFunction)
  {
    this.source = paramSingleSource;
    this.mapper = paramFunction;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class MapSingleObserver<T, R>
    implements SingleObserver<T>
  {
    final Function<? super T, ? extends R> mapper;
    final SingleObserver<? super R> t;
    
    MapSingleObserver(SingleObserver<? super R> paramSingleObserver, Function<? super T, ? extends R> paramFunction)
    {
      this.t = paramSingleObserver;
      this.mapper = paramFunction;
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.t.onError(paramThrowable);
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      this.t.onSubscribe(paramDisposable);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */