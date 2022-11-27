package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.LambdaConsumerIntrospection;
import java.util.concurrent.atomic.AtomicReference;

public final class CallbackCompletableObserver
  extends AtomicReference<Disposable>
  implements CompletableObserver, Disposable, Consumer<Throwable>, LambdaConsumerIntrospection
{
  private static final long serialVersionUID = -4361286194466301354L;
  final Action onComplete;
  final Consumer<? super Throwable> onError;
  
  public CallbackCompletableObserver(Action paramAction)
  {
    this.onError = this;
    this.onComplete = paramAction;
  }
  
  public CallbackCompletableObserver(Consumer<? super Throwable> paramConsumer, Action paramAction)
  {
    this.onError = paramConsumer;
    this.onComplete = paramAction;
  }
  
  /* Error */
  public void accept(Throwable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void dispose()
  {
    DisposableHelper.dispose(this);
  }
  
  public boolean hasCustomOnError()
  {
    return this.onError != this;
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\observers\CallbackCompletableObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */