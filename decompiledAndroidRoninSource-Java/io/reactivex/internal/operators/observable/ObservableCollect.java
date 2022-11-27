package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import java.util.concurrent.Callable;

public final class ObservableCollect<T, U>
  extends AbstractObservableWithUpstream<T, U>
{
  final BiConsumer<? super U, ? super T> collector;
  final Callable<? extends U> initialSupplier;
  
  public ObservableCollect(ObservableSource<T> paramObservableSource, Callable<? extends U> paramCallable, BiConsumer<? super U, ? super T> paramBiConsumer)
  {
    super(paramObservableSource);
    this.initialSupplier = paramCallable;
    this.collector = paramBiConsumer;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super U> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class CollectObserver<T, U>
    implements Observer<T>, Disposable
  {
    final BiConsumer<? super U, ? super T> collector;
    boolean done;
    final Observer<? super U> downstream;
    final U u;
    Disposable upstream;
    
    CollectObserver(Observer<? super U> paramObserver, U paramU, BiConsumer<? super U, ? super T> paramBiConsumer)
    {
      this.downstream = paramObserver;
      this.collector = paramBiConsumer;
      this.u = paramU;
    }
    
    public void dispose()
    {
      this.upstream.dispose();
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
      //   2: goto -2 -> 0
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
    public void onNext(T arg1)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableCollect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */