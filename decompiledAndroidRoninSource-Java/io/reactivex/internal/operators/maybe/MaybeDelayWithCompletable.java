package io.reactivex.internal.operators.maybe;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeDelayWithCompletable<T>
  extends Maybe<T>
{
  final CompletableSource other;
  final MaybeSource<T> source;
  
  public MaybeDelayWithCompletable(MaybeSource<T> paramMaybeSource, CompletableSource paramCompletableSource)
  {
    this.source = paramMaybeSource;
    this.other = paramCompletableSource;
  }
  
  /* Error */
  protected void subscribeActual(MaybeObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class DelayWithMainObserver<T>
    implements MaybeObserver<T>
  {
    final MaybeObserver<? super T> downstream;
    final AtomicReference<Disposable> parent;
    
    DelayWithMainObserver(AtomicReference<Disposable> paramAtomicReference, MaybeObserver<? super T> paramMaybeObserver)
    {
      this.parent = paramAtomicReference;
      this.downstream = paramMaybeObserver;
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
    
    public void onSuccess(T paramT)
    {
      this.downstream.onSuccess(paramT);
    }
  }
  
  static final class OtherObserver<T>
    extends AtomicReference<Disposable>
    implements CompletableObserver, Disposable
  {
    private static final long serialVersionUID = 703409937383992161L;
    final MaybeObserver<? super T> downstream;
    final MaybeSource<T> source;
    
    OtherObserver(MaybeObserver<? super T> paramMaybeObserver, MaybeSource<T> paramMaybeSource)
    {
      this.downstream = paramMaybeObserver;
      this.source = paramMaybeSource;
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
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeDelayWithCompletable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */