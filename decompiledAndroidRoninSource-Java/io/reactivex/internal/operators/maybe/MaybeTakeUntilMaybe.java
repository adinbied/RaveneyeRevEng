package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeTakeUntilMaybe<T, U>
  extends AbstractMaybeWithUpstream<T, T>
{
  final MaybeSource<U> other;
  
  public MaybeTakeUntilMaybe(MaybeSource<T> paramMaybeSource, MaybeSource<U> paramMaybeSource1)
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
  
  static final class TakeUntilMainMaybeObserver<T, U>
    extends AtomicReference<Disposable>
    implements MaybeObserver<T>, Disposable
  {
    private static final long serialVersionUID = -2187421758664251153L;
    final MaybeObserver<? super T> downstream;
    final TakeUntilOtherMaybeObserver<U> other;
    
    TakeUntilMainMaybeObserver(MaybeObserver<? super T> paramMaybeObserver)
    {
      this.downstream = paramMaybeObserver;
      this.other = new TakeUntilOtherMaybeObserver(this);
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
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
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
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
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void otherComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void otherError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    static final class TakeUntilOtherMaybeObserver<U>
      extends AtomicReference<Disposable>
      implements MaybeObserver<U>
    {
      private static final long serialVersionUID = -1266041316834525931L;
      final MaybeTakeUntilMaybe.TakeUntilMainMaybeObserver<?, U> parent;
      
      TakeUntilOtherMaybeObserver(MaybeTakeUntilMaybe.TakeUntilMainMaybeObserver<?, U> paramTakeUntilMainMaybeObserver)
      {
        this.parent = paramTakeUntilMainMaybeObserver;
      }
      
      public void onComplete()
      {
        this.parent.otherComplete();
      }
      
      public void onError(Throwable paramThrowable)
      {
        this.parent.otherError(paramThrowable);
      }
      
      public void onSubscribe(Disposable paramDisposable)
      {
        DisposableHelper.setOnce(this, paramDisposable);
      }
      
      public void onSuccess(Object paramObject)
      {
        this.parent.otherComplete();
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeTakeUntilMaybe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */