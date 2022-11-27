package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;

public final class SingleDoOnEvent<T>
  extends Single<T>
{
  final BiConsumer<? super T, ? super Throwable> onEvent;
  final SingleSource<T> source;
  
  public SingleDoOnEvent(SingleSource<T> paramSingleSource, BiConsumer<? super T, ? super Throwable> paramBiConsumer)
  {
    this.source = paramSingleSource;
    this.onEvent = paramBiConsumer;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  final class DoOnEvent
    implements SingleObserver<T>
  {
    private final SingleObserver<? super T> downstream;
    
    DoOnEvent()
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleDoOnEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */