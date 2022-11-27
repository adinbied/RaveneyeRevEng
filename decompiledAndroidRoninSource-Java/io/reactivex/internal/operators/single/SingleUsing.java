package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleUsing<T, U>
  extends Single<T>
{
  final Consumer<? super U> disposer;
  final boolean eager;
  final Callable<U> resourceSupplier;
  final Function<? super U, ? extends SingleSource<? extends T>> singleFunction;
  
  public SingleUsing(Callable<U> paramCallable, Function<? super U, ? extends SingleSource<? extends T>> paramFunction, Consumer<? super U> paramConsumer, boolean paramBoolean)
  {
    this.resourceSupplier = paramCallable;
    this.singleFunction = paramFunction;
    this.disposer = paramConsumer;
    this.eager = paramBoolean;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class UsingSingleObserver<T, U>
    extends AtomicReference<Object>
    implements SingleObserver<T>, Disposable
  {
    private static final long serialVersionUID = -5331524057054083935L;
    final Consumer<? super U> disposer;
    final SingleObserver<? super T> downstream;
    final boolean eager;
    Disposable upstream;
    
    UsingSingleObserver(SingleObserver<? super T> paramSingleObserver, U paramU, boolean paramBoolean, Consumer<? super U> paramConsumer)
    {
      super();
      this.downstream = paramSingleObserver;
      this.eager = paramBoolean;
      this.disposer = paramConsumer;
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
    void disposeAfter()
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleUsing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */