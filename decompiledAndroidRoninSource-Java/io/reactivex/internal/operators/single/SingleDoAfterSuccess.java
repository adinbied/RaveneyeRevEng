package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public final class SingleDoAfterSuccess<T>
  extends Single<T>
{
  final Consumer<? super T> onAfterSuccess;
  final SingleSource<T> source;
  
  public SingleDoAfterSuccess(SingleSource<T> paramSingleSource, Consumer<? super T> paramConsumer)
  {
    this.source = paramSingleSource;
    this.onAfterSuccess = paramConsumer;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class DoAfterObserver<T>
    implements SingleObserver<T>, Disposable
  {
    final SingleObserver<? super T> downstream;
    final Consumer<? super T> onAfterSuccess;
    Disposable upstream;
    
    DoAfterObserver(SingleObserver<? super T> paramSingleObserver, Consumer<? super T> paramConsumer)
    {
      this.downstream = paramSingleObserver;
      this.onAfterSuccess = paramConsumer;
    }
    
    public void dispose()
    {
      this.upstream.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.upstream.isDisposed();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.downstream.onError(paramThrowable);
    }
    
    /* Error */
    public void onSubscribe(Disposable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleDoAfterSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */