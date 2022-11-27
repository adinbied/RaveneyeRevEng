package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSwitchIfEmptySingle<T>
  extends Single<T>
  implements HasUpstreamMaybeSource<T>
{
  final SingleSource<? extends T> other;
  final MaybeSource<T> source;
  
  public MaybeSwitchIfEmptySingle(MaybeSource<T> paramMaybeSource, SingleSource<? extends T> paramSingleSource)
  {
    this.source = paramMaybeSource;
    this.other = paramSingleSource;
  }
  
  public MaybeSource<T> source()
  {
    return this.source;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class SwitchIfEmptyMaybeObserver<T>
    extends AtomicReference<Disposable>
    implements MaybeObserver<T>, Disposable
  {
    private static final long serialVersionUID = 4603919676453758899L;
    final SingleObserver<? super T> downstream;
    final SingleSource<? extends T> other;
    
    SwitchIfEmptyMaybeObserver(SingleObserver<? super T> paramSingleObserver, SingleSource<? extends T> paramSingleSource)
    {
      this.downstream = paramSingleObserver;
      this.other = paramSingleSource;
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
    public void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
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
    
    public void onSuccess(T paramT)
    {
      this.downstream.onSuccess(paramT);
    }
    
    static final class OtherSingleObserver<T>
      implements SingleObserver<T>
    {
      final SingleObserver<? super T> downstream;
      final AtomicReference<Disposable> parent;
      
      OtherSingleObserver(SingleObserver<? super T> paramSingleObserver, AtomicReference<Disposable> paramAtomicReference)
      {
        this.downstream = paramSingleObserver;
        this.parent = paramAtomicReference;
      }
      
      public void onError(Throwable paramThrowable)
      {
        this.downstream.onError(paramThrowable);
      }
      
      public void onSubscribe(Disposable paramDisposable)
      {
        DisposableHelper.setOnce(this.parent, paramDisposable);
      }
      
      public void onSuccess(T paramT)
      {
        this.downstream.onSuccess(paramT);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeSwitchIfEmptySingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */