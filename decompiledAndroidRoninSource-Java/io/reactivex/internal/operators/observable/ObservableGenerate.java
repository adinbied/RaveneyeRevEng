package io.reactivex.internal.operators.observable;

import io.reactivex.Emitter;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import java.util.concurrent.Callable;

public final class ObservableGenerate<T, S>
  extends Observable<T>
{
  final Consumer<? super S> disposeState;
  final BiFunction<S, Emitter<T>, S> generator;
  final Callable<S> stateSupplier;
  
  public ObservableGenerate(Callable<S> paramCallable, BiFunction<S, Emitter<T>, S> paramBiFunction, Consumer<? super S> paramConsumer)
  {
    this.stateSupplier = paramCallable;
    this.generator = paramBiFunction;
    this.disposeState = paramConsumer;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class GeneratorDisposable<T, S>
    implements Emitter<T>, Disposable
  {
    volatile boolean cancelled;
    final Consumer<? super S> disposeState;
    final Observer<? super T> downstream;
    final BiFunction<S, ? super Emitter<T>, S> generator;
    boolean hasNext;
    S state;
    boolean terminate;
    
    GeneratorDisposable(Observer<? super T> paramObserver, BiFunction<S, ? super Emitter<T>, S> paramBiFunction, Consumer<? super S> paramConsumer, S paramS)
    {
      this.downstream = paramObserver;
      this.generator = paramBiFunction;
      this.disposeState = paramConsumer;
      this.state = paramS;
    }
    
    /* Error */
    private void dispose(S arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public void dispose()
    {
      this.cancelled = true;
    }
    
    public boolean isDisposed()
    {
      return this.cancelled;
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
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableGenerate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */