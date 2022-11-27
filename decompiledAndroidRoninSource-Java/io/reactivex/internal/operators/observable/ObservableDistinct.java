package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import io.reactivex.internal.observers.BasicFuseableObserver;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class ObservableDistinct<T, K>
  extends AbstractObservableWithUpstream<T, T>
{
  final Callable<? extends Collection<? super K>> collectionSupplier;
  final Function<? super T, K> keySelector;
  
  public ObservableDistinct(ObservableSource<T> paramObservableSource, Function<? super T, K> paramFunction, Callable<? extends Collection<? super K>> paramCallable)
  {
    super(paramObservableSource);
    this.keySelector = paramFunction;
    this.collectionSupplier = paramCallable;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class DistinctObserver<T, K>
    extends BasicFuseableObserver<T, T>
  {
    final Collection<? super K> collection;
    final Function<? super T, K> keySelector;
    
    DistinctObserver(Observer<? super T> paramObserver, Function<? super T, K> paramFunction, Collection<? super K> paramCollection)
    {
      super();
      this.keySelector = paramFunction;
      this.collection = paramCollection;
    }
    
    /* Error */
    public void clear()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
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
    
    public T poll()
      throws Exception
    {
      return null;
    }
    
    public int requestFusion(int paramInt)
    {
      return transitiveBoundaryFusion(paramInt);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableDistinct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */