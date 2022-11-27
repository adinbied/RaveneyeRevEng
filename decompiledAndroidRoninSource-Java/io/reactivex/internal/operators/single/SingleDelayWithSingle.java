package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleDelayWithSingle<T, U>
  extends Single<T>
{
  final SingleSource<U> other;
  final SingleSource<T> source;
  
  public SingleDelayWithSingle(SingleSource<T> paramSingleSource, SingleSource<U> paramSingleSource1)
  {
    this.source = paramSingleSource;
    this.other = paramSingleSource1;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class OtherObserver<T, U>
    extends AtomicReference<Disposable>
    implements SingleObserver<U>, Disposable
  {
    private static final long serialVersionUID = -8565274649390031272L;
    final SingleObserver<? super T> downstream;
    final SingleSource<T> source;
    
    OtherObserver(SingleObserver<? super T> paramSingleObserver, SingleSource<T> paramSingleSource)
    {
      this.downstream = paramSingleObserver;
      this.source = paramSingleSource;
    }
    
    public void dispose()
    {
      DisposableHelper.dispose(this);
    }
    
    public boolean isDisposed()
    {
      return false;
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.downstream.onError(paramThrowable);
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      if (DisposableHelper.setOnce(this, paramDisposable)) {
        this.downstream.onSubscribe(this);
      }
    }
    
    /* Error */
    public void onSuccess(U arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleDelayWithSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */