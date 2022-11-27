package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public final class DisposableLambdaObserver<T>
  implements Observer<T>, Disposable
{
  final Observer<? super T> downstream;
  final Action onDispose;
  final Consumer<? super Disposable> onSubscribe;
  Disposable upstream;
  
  public DisposableLambdaObserver(Observer<? super T> paramObserver, Consumer<? super Disposable> paramConsumer, Action paramAction)
  {
    this.downstream = paramObserver;
    this.onSubscribe = paramConsumer;
    this.onDispose = paramAction;
  }
  
  /* Error */
  public void dispose()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public boolean isDisposed()
  {
    return this.upstream.isDisposed();
  }
  
  /* Error */
  public void onComplete()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onError(Throwable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onNext(T paramT)
  {
    this.downstream.onNext(paramT);
  }
  
  /* Error */
  public void onSubscribe(Disposable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\observers\DisposableLambdaObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */