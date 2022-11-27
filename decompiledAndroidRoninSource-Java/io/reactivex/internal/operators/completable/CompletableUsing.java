package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableUsing<R>
  extends Completable
{
  final Function<? super R, ? extends CompletableSource> completableFunction;
  final Consumer<? super R> disposer;
  final boolean eager;
  final Callable<R> resourceSupplier;
  
  public CompletableUsing(Callable<R> paramCallable, Function<? super R, ? extends CompletableSource> paramFunction, Consumer<? super R> paramConsumer, boolean paramBoolean)
  {
    this.resourceSupplier = paramCallable;
    this.completableFunction = paramFunction;
    this.disposer = paramConsumer;
    this.eager = paramBoolean;
  }
  
  /* Error */
  protected void subscribeActual(CompletableObserver arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class UsingObserver<R>
    extends AtomicReference<Object>
    implements CompletableObserver, Disposable
  {
    private static final long serialVersionUID = -674404550052917487L;
    final Consumer<? super R> disposer;
    final CompletableObserver downstream;
    final boolean eager;
    Disposable upstream;
    
    UsingObserver(CompletableObserver paramCompletableObserver, R paramR, Consumer<? super R> paramConsumer, boolean paramBoolean)
    {
      super();
      this.downstream = paramCompletableObserver;
      this.disposer = paramConsumer;
      this.eager = paramBoolean;
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void disposeResourceAfter()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public boolean isDisposed()
    {
      return this.upstream.isDisposed();
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
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableUsing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */