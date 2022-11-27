package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleResumeNext<T>
  extends Single<T>
{
  final Function<? super Throwable, ? extends SingleSource<? extends T>> nextFunction;
  final SingleSource<? extends T> source;
  
  public SingleResumeNext(SingleSource<? extends T> paramSingleSource, Function<? super Throwable, ? extends SingleSource<? extends T>> paramFunction)
  {
    this.source = paramSingleSource;
    this.nextFunction = paramFunction;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ResumeMainSingleObserver<T>
    extends AtomicReference<Disposable>
    implements SingleObserver<T>, Disposable
  {
    private static final long serialVersionUID = -5314538511045349925L;
    final SingleObserver<? super T> downstream;
    final Function<? super Throwable, ? extends SingleSource<? extends T>> nextFunction;
    
    ResumeMainSingleObserver(SingleObserver<? super T> paramSingleObserver, Function<? super Throwable, ? extends SingleSource<? extends T>> paramFunction)
    {
      this.downstream = paramSingleObserver;
      this.nextFunction = paramFunction;
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
      if (DisposableHelper.setOnce(this, paramDisposable)) {
        this.downstream.onSubscribe(this);
      }
    }
    
    public void onSuccess(T paramT)
    {
      this.downstream.onSuccess(paramT);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleResumeNext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */