package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableResumeNext
  extends Completable
{
  final Function<? super Throwable, ? extends CompletableSource> errorMapper;
  final CompletableSource source;
  
  public CompletableResumeNext(CompletableSource paramCompletableSource, Function<? super Throwable, ? extends CompletableSource> paramFunction)
  {
    this.source = paramCompletableSource;
    this.errorMapper = paramFunction;
  }
  
  /* Error */
  protected void subscribeActual(CompletableObserver arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ResumeNextObserver
    extends AtomicReference<Disposable>
    implements CompletableObserver, Disposable
  {
    private static final long serialVersionUID = 5018523762564524046L;
    final CompletableObserver downstream;
    final Function<? super Throwable, ? extends CompletableSource> errorMapper;
    boolean once;
    
    ResumeNextObserver(CompletableObserver paramCompletableObserver, Function<? super Throwable, ? extends CompletableSource> paramFunction)
    {
      this.downstream = paramCompletableObserver;
      this.errorMapper = paramFunction;
    }
    
    public void dispose()
    {
      DisposableHelper.dispose(this);
    }
    
    public boolean isDisposed()
    {
      return false;
    }
    
    public void onComplete()
    {
      this.downstream.onComplete();
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
      DisposableHelper.replace(this, paramDisposable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableResumeNext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */