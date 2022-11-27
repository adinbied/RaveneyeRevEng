package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleDoOnDispose<T>
  extends Single<T>
{
  final Action onDispose;
  final SingleSource<T> source;
  
  public SingleDoOnDispose(SingleSource<T> paramSingleSource, Action paramAction)
  {
    this.source = paramSingleSource;
    this.onDispose = paramAction;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class DoOnDisposeObserver<T>
    extends AtomicReference<Action>
    implements SingleObserver<T>, Disposable
  {
    private static final long serialVersionUID = -8583764624474935784L;
    final SingleObserver<? super T> downstream;
    Disposable upstream;
    
    DoOnDisposeObserver(SingleObserver<? super T> paramSingleObserver, Action paramAction)
    {
      this.downstream = paramSingleObserver;
      lazySet(paramAction);
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
    
    public void onSuccess(T paramT)
    {
      this.downstream.onSuccess(paramT);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleDoOnDispose.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */