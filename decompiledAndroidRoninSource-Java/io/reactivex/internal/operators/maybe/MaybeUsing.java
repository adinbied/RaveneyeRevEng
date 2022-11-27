package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeUsing<T, D>
  extends Maybe<T>
{
  final boolean eager;
  final Consumer<? super D> resourceDisposer;
  final Callable<? extends D> resourceSupplier;
  final Function<? super D, ? extends MaybeSource<? extends T>> sourceSupplier;
  
  public MaybeUsing(Callable<? extends D> paramCallable, Function<? super D, ? extends MaybeSource<? extends T>> paramFunction, Consumer<? super D> paramConsumer, boolean paramBoolean)
  {
    this.resourceSupplier = paramCallable;
    this.sourceSupplier = paramFunction;
    this.resourceDisposer = paramConsumer;
    this.eager = paramBoolean;
  }
  
  /* Error */
  protected void subscribeActual(MaybeObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class UsingObserver<T, D>
    extends AtomicReference<Object>
    implements MaybeObserver<T>, Disposable
  {
    private static final long serialVersionUID = -674404550052917487L;
    final Consumer<? super D> disposer;
    final MaybeObserver<? super T> downstream;
    final boolean eager;
    Disposable upstream;
    
    UsingObserver(MaybeObserver<? super T> paramMaybeObserver, D paramD, Consumer<? super D> paramConsumer, boolean paramBoolean)
    {
      super();
      this.downstream = paramMaybeObserver;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeUsing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */