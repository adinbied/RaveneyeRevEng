package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSwitchIfEmpty<T>
  extends AbstractMaybeWithUpstream<T, T>
{
  final MaybeSource<? extends T> other;
  
  public MaybeSwitchIfEmpty(MaybeSource<T> paramMaybeSource, MaybeSource<? extends T> paramMaybeSource1)
  {
    super(paramMaybeSource);
    this.other = paramMaybeSource1;
  }
  
  /* Error */
  protected void subscribeActual(MaybeObserver<? super T> arg1)
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
    private static final long serialVersionUID = -2223459372976438024L;
    final MaybeObserver<? super T> downstream;
    final MaybeSource<? extends T> other;
    
    SwitchIfEmptyMaybeObserver(MaybeObserver<? super T> paramMaybeObserver, MaybeSource<? extends T> paramMaybeSource)
    {
      this.downstream = paramMaybeObserver;
      this.other = paramMaybeSource;
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
    
    static final class OtherMaybeObserver<T>
      implements MaybeObserver<T>
    {
      final MaybeObserver<? super T> downstream;
      final AtomicReference<Disposable> parent;
      
      OtherMaybeObserver(MaybeObserver<? super T> paramMaybeObserver, AtomicReference<Disposable> paramAtomicReference)
      {
        this.downstream = paramMaybeObserver;
        this.parent = paramAtomicReference;
      }
      
      public void onComplete()
      {
        this.downstream.onComplete();
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeSwitchIfEmpty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */