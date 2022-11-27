package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableCreate
  extends Completable
{
  final CompletableOnSubscribe source;
  
  public CompletableCreate(CompletableOnSubscribe paramCompletableOnSubscribe)
  {
    this.source = paramCompletableOnSubscribe;
  }
  
  /* Error */
  protected void subscribeActual(CompletableObserver arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class Emitter
    extends AtomicReference<Disposable>
    implements CompletableEmitter, Disposable
  {
    private static final long serialVersionUID = -2467358622224974244L;
    final CompletableObserver downstream;
    
    Emitter(CompletableObserver paramCompletableObserver)
    {
      this.downstream = paramCompletableObserver;
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
      //   2: return
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void setCancellable(io.reactivex.functions.Cancellable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void setDisposable(Disposable paramDisposable)
    {
      DisposableHelper.set(this, paramDisposable);
    }
    
    public String toString()
    {
      return null;
    }
    
    public boolean tryOnError(Throwable paramThrowable)
    {
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableCreate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */