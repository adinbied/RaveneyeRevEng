package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableAndThenCompletable
  extends Completable
{
  final CompletableSource next;
  final CompletableSource source;
  
  public CompletableAndThenCompletable(CompletableSource paramCompletableSource1, CompletableSource paramCompletableSource2)
  {
    this.source = paramCompletableSource1;
    this.next = paramCompletableSource2;
  }
  
  /* Error */
  protected void subscribeActual(CompletableObserver arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class NextObserver
    implements CompletableObserver
  {
    final CompletableObserver downstream;
    final AtomicReference<Disposable> parent;
    
    public NextObserver(AtomicReference<Disposable> paramAtomicReference, CompletableObserver paramCompletableObserver)
    {
      this.parent = paramAtomicReference;
      this.downstream = paramCompletableObserver;
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
      DisposableHelper.replace(this.parent, paramDisposable);
    }
  }
  
  static final class SourceObserver
    extends AtomicReference<Disposable>
    implements CompletableObserver, Disposable
  {
    private static final long serialVersionUID = -4101678820158072998L;
    final CompletableObserver actualObserver;
    final CompletableSource next;
    
    SourceObserver(CompletableObserver paramCompletableObserver, CompletableSource paramCompletableSource)
    {
      this.actualObserver = paramCompletableObserver;
      this.next = paramCompletableSource;
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
      this.actualObserver.onError(paramThrowable);
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      if (DisposableHelper.setOnce(this, paramDisposable)) {
        this.actualObserver.onSubscribe(this);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableAndThenCompletable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */