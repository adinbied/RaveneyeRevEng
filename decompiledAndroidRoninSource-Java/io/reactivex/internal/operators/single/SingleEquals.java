package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class SingleEquals<T>
  extends Single<Boolean>
{
  final SingleSource<? extends T> first;
  final SingleSource<? extends T> second;
  
  public SingleEquals(SingleSource<? extends T> paramSingleSource1, SingleSource<? extends T> paramSingleSource2)
  {
    this.first = paramSingleSource1;
    this.second = paramSingleSource2;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super Boolean> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static class InnerObserver<T>
    implements SingleObserver<T>
  {
    final AtomicInteger count;
    final SingleObserver<? super Boolean> downstream;
    final int index;
    final CompositeDisposable set;
    final Object[] values;
    
    InnerObserver(int paramInt, CompositeDisposable paramCompositeDisposable, Object[] paramArrayOfObject, SingleObserver<? super Boolean> paramSingleObserver, AtomicInteger paramAtomicInteger)
    {
      this.index = paramInt;
      this.set = paramCompositeDisposable;
      this.values = paramArrayOfObject;
      this.downstream = paramSingleObserver;
      this.count = paramAtomicInteger;
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      this.set.add(paramDisposable);
    }
    
    /* Error */
    public void onSuccess(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleEquals.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */