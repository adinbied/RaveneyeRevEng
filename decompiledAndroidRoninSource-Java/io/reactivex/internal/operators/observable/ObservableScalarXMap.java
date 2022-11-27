package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableScalarXMap
{
  private ObservableScalarXMap()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T, U> Observable<U> scalarXMap(T paramT, Function<? super T, ? extends ObservableSource<? extends U>> paramFunction)
  {
    return RxJavaPlugins.onAssembly(new ScalarXMapObservable(paramT, paramFunction));
  }
  
  public static <T, R> boolean tryScalarXMapSubscribe(ObservableSource<T> paramObservableSource, Observer<? super R> paramObserver, Function<? super T, ? extends ObservableSource<? extends R>> paramFunction)
  {
    if ((paramObservableSource instanceof Callable)) {
      try
      {
        paramObservableSource = ((Callable)paramObservableSource).call();
        if (paramObservableSource == null)
        {
          EmptyDisposable.complete(paramObserver);
          return true;
        }
        try
        {
          paramObservableSource = (ObservableSource)ObjectHelper.requireNonNull(paramFunction.apply(paramObservableSource), "The mapper returned a null ObservableSource");
          if ((paramObservableSource instanceof Callable)) {
            try
            {
              paramObservableSource = ((Callable)paramObservableSource).call();
              if (paramObservableSource == null)
              {
                EmptyDisposable.complete(paramObserver);
                return true;
              }
              paramObservableSource = new ScalarDisposable(paramObserver, paramObservableSource);
              paramObserver.onSubscribe(paramObservableSource);
              paramObservableSource.run();
              return true;
            }
            finally {}
          }
          paramObservableSource.subscribe(paramObserver);
          return true;
        }
        finally {}
        return false;
      }
      finally
      {
        Exceptions.throwIfFatal(paramObservableSource);
        EmptyDisposable.error(paramObservableSource, paramObserver);
        return true;
      }
    }
  }
  
  public static final class ScalarDisposable<T>
    extends AtomicInteger
    implements QueueDisposable<T>, Runnable
  {
    static final int FUSED = 1;
    static final int ON_COMPLETE = 3;
    static final int ON_NEXT = 2;
    static final int START = 0;
    private static final long serialVersionUID = 3880992722410194083L;
    final Observer<? super T> observer;
    final T value;
    
    public ScalarDisposable(Observer<? super T> paramObserver, T paramT)
    {
      this.observer = paramObserver;
      this.value = paramT;
    }
    
    public void clear()
    {
      lazySet(3);
    }
    
    public void dispose()
    {
      set(3);
    }
    
    public boolean isDisposed()
    {
      return false;
    }
    
    public boolean isEmpty()
    {
      return false;
    }
    
    public boolean offer(T paramT)
    {
      throw new UnsupportedOperationException("Should not be called!");
    }
    
    public boolean offer(T paramT1, T paramT2)
    {
      throw new UnsupportedOperationException("Should not be called!");
    }
    
    public T poll()
      throws Exception
    {
      return null;
    }
    
    public int requestFusion(int paramInt)
    {
      return 0;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class ScalarXMapObservable<T, R>
    extends Observable<R>
  {
    final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
    final T value;
    
    ScalarXMapObservable(T paramT, Function<? super T, ? extends ObservableSource<? extends R>> paramFunction)
    {
      this.value = paramT;
      this.mapper = paramFunction;
    }
    
    /* Error */
    public void subscribeActual(Observer<? super R> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableScalarXMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */