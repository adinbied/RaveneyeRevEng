package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public final class SingleDoOnSubscribe<T>
  extends Single<T>
{
  final Consumer<? super Disposable> onSubscribe;
  final SingleSource<T> source;
  
  public SingleDoOnSubscribe(SingleSource<T> paramSingleSource, Consumer<? super Disposable> paramConsumer)
  {
    this.source = paramSingleSource;
    this.onSubscribe = paramConsumer;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class DoOnSubscribeSingleObserver<T>
    implements SingleObserver<T>
  {
    boolean done;
    final SingleObserver<? super T> downstream;
    final Consumer<? super Disposable> onSubscribe;
    
    DoOnSubscribeSingleObserver(SingleObserver<? super T> paramSingleObserver, Consumer<? super Disposable> paramConsumer)
    {
      this.downstream = paramSingleObserver;
      this.onSubscribe = paramConsumer;
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onSubscribe(Disposable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleDoOnSubscribe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */