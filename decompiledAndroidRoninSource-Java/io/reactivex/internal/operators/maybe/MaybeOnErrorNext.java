package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeOnErrorNext<T>
  extends AbstractMaybeWithUpstream<T, T>
{
  final boolean allowFatal;
  final Function<? super Throwable, ? extends MaybeSource<? extends T>> resumeFunction;
  
  public MaybeOnErrorNext(MaybeSource<T> paramMaybeSource, Function<? super Throwable, ? extends MaybeSource<? extends T>> paramFunction, boolean paramBoolean)
  {
    super(paramMaybeSource);
    this.resumeFunction = paramFunction;
    this.allowFatal = paramBoolean;
  }
  
  /* Error */
  protected void subscribeActual(MaybeObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class OnErrorNextMaybeObserver<T>
    extends AtomicReference<Disposable>
    implements MaybeObserver<T>, Disposable
  {
    private static final long serialVersionUID = 2026620218879969836L;
    final boolean allowFatal;
    final MaybeObserver<? super T> downstream;
    final Function<? super Throwable, ? extends MaybeSource<? extends T>> resumeFunction;
    
    OnErrorNextMaybeObserver(MaybeObserver<? super T> paramMaybeObserver, Function<? super Throwable, ? extends MaybeSource<? extends T>> paramFunction, boolean paramBoolean)
    {
      this.downstream = paramMaybeObserver;
      this.resumeFunction = paramFunction;
      this.allowFatal = paramBoolean;
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
      if (DisposableHelper.setOnce(this, paramDisposable)) {
        this.downstream.onSubscribe(this);
      }
    }
    
    public void onSuccess(T paramT)
    {
      this.downstream.onSuccess(paramT);
    }
    
    static final class NextMaybeObserver<T>
      implements MaybeObserver<T>
    {
      final MaybeObserver<? super T> downstream;
      final AtomicReference<Disposable> upstream;
      
      NextMaybeObserver(MaybeObserver<? super T> paramMaybeObserver, AtomicReference<Disposable> paramAtomicReference)
      {
        this.downstream = paramMaybeObserver;
        this.upstream = paramAtomicReference;
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
        DisposableHelper.setOnce(this.upstream, paramDisposable);
      }
      
      public void onSuccess(T paramT)
      {
        this.downstream.onSuccess(paramT);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeOnErrorNext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */