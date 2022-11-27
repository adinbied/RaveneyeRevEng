package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.LambdaConsumerIntrospection;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeCallbackObserver<T>
  extends AtomicReference<Disposable>
  implements MaybeObserver<T>, Disposable, LambdaConsumerIntrospection
{
  private static final long serialVersionUID = -6076952298809384986L;
  final Action onComplete;
  final Consumer<? super Throwable> onError;
  final Consumer<? super T> onSuccess;
  
  public MaybeCallbackObserver(Consumer<? super T> paramConsumer, Consumer<? super Throwable> paramConsumer1, Action paramAction)
  {
    this.onSuccess = paramConsumer;
    this.onError = paramConsumer1;
    this.onComplete = paramAction;
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
  public void onComplete()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeCallbackObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */