package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class BiConsumerSingleObserver<T>
  extends AtomicReference<Disposable>
  implements SingleObserver<T>, Disposable
{
  private static final long serialVersionUID = 4943102778943297569L;
  final BiConsumer<? super T, ? super Throwable> onCallback;
  
  public BiConsumerSingleObserver(BiConsumer<? super T, ? super Throwable> paramBiConsumer)
  {
    this.onCallback = paramBiConsumer;
  }
  
  public void dispose()
  {
    DisposableHelper.dispose(this);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\observers\BiConsumerSingleObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */