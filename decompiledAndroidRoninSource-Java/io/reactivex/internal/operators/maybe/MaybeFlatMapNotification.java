package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapNotification<T, R>
  extends AbstractMaybeWithUpstream<T, R>
{
  final Callable<? extends MaybeSource<? extends R>> onCompleteSupplier;
  final Function<? super Throwable, ? extends MaybeSource<? extends R>> onErrorMapper;
  final Function<? super T, ? extends MaybeSource<? extends R>> onSuccessMapper;
  
  public MaybeFlatMapNotification(MaybeSource<T> paramMaybeSource, Function<? super T, ? extends MaybeSource<? extends R>> paramFunction, Function<? super Throwable, ? extends MaybeSource<? extends R>> paramFunction1, Callable<? extends MaybeSource<? extends R>> paramCallable)
  {
    super(paramMaybeSource);
    this.onSuccessMapper = paramFunction;
    this.onErrorMapper = paramFunction1;
    this.onCompleteSupplier = paramCallable;
  }
  
  /* Error */
  protected void subscribeActual(MaybeObserver<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class FlatMapMaybeObserver<T, R>
    extends AtomicReference<Disposable>
    implements MaybeObserver<T>, Disposable
  {
    private static final long serialVersionUID = 4375739915521278546L;
    final MaybeObserver<? super R> downstream;
    final Callable<? extends MaybeSource<? extends R>> onCompleteSupplier;
    final Function<? super Throwable, ? extends MaybeSource<? extends R>> onErrorMapper;
    final Function<? super T, ? extends MaybeSource<? extends R>> onSuccessMapper;
    Disposable upstream;
    
    FlatMapMaybeObserver(MaybeObserver<? super R> paramMaybeObserver, Function<? super T, ? extends MaybeSource<? extends R>> paramFunction, Function<? super Throwable, ? extends MaybeSource<? extends R>> paramFunction1, Callable<? extends MaybeSource<? extends R>> paramCallable)
    {
      this.downstream = paramMaybeObserver;
      this.onSuccessMapper = paramFunction;
      this.onErrorMapper = paramFunction1;
      this.onCompleteSupplier = paramCallable;
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
      //   2: return
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onSubscribe(Disposable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onSuccess(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    final class InnerObserver
      implements MaybeObserver<R>
    {
      InnerObserver() {}
      
      public void onComplete()
      {
        MaybeFlatMapNotification.FlatMapMaybeObserver.this.downstream.onComplete();
      }
      
      public void onError(Throwable paramThrowable)
      {
        MaybeFlatMapNotification.FlatMapMaybeObserver.this.downstream.onError(paramThrowable);
      }
      
      public void onSubscribe(Disposable paramDisposable)
      {
        DisposableHelper.setOnce(MaybeFlatMapNotification.FlatMapMaybeObserver.this, paramDisposable);
      }
      
      public void onSuccess(R paramR)
      {
        MaybeFlatMapNotification.FlatMapMaybeObserver.this.downstream.onSuccess(paramR);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeFlatMapNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */