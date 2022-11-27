package io.reactivex.internal.operators.maybe;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapCompletable<T>
  extends Completable
{
  final Function<? super T, ? extends CompletableSource> mapper;
  final MaybeSource<T> source;
  
  public MaybeFlatMapCompletable(MaybeSource<T> paramMaybeSource, Function<? super T, ? extends CompletableSource> paramFunction)
  {
    this.source = paramMaybeSource;
    this.mapper = paramFunction;
  }
  
  /* Error */
  protected void subscribeActual(CompletableObserver arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class FlatMapCompletableObserver<T>
    extends AtomicReference<Disposable>
    implements MaybeObserver<T>, CompletableObserver, Disposable
  {
    private static final long serialVersionUID = -2177128922851101253L;
    final CompletableObserver downstream;
    final Function<? super T, ? extends CompletableSource> mapper;
    
    FlatMapCompletableObserver(CompletableObserver paramCompletableObserver, Function<? super T, ? extends CompletableSource> paramFunction)
    {
      this.downstream = paramCompletableObserver;
      this.mapper = paramFunction;
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
    
    public void onError(Throwable paramThrowable)
    {
      this.downstream.onError(paramThrowable);
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      DisposableHelper.replace(this, paramDisposable);
    }
    
    /* Error */
    public void onSuccess(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeFlatMapCompletable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */