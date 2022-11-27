package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.LambdaConsumerIntrospection;
import java.util.concurrent.atomic.AtomicReference;

public final class ConsumerSingleObserver<T>
  extends AtomicReference<Disposable>
  implements SingleObserver<T>, Disposable, LambdaConsumerIntrospection
{
  private static final long serialVersionUID = -7012088219455310787L;
  final Consumer<? super Throwable> onError;
  final Consumer<? super T> onSuccess;
  
  public ConsumerSingleObserver(Consumer<? super T> paramConsumer, Consumer<? super Throwable> paramConsumer1)
  {
    this.onSuccess = paramConsumer;
    this.onError = paramConsumer1;
  }
  
  public void dispose()
  {
    DisposableHelper.dispose(this);
  }
  
  public boolean hasCustomOnError()
  {
    return false;
  }
  
  public boolean isDisposed()
  {
    return false;
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
    DisposableHelper.setOnce(this, paramDisposable);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\observers\ConsumerSingleObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */