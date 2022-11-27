package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.internal.observers.BasicFuseableObserver;

public final class ObservableDistinctUntilChanged<T, K>
  extends AbstractObservableWithUpstream<T, T>
{
  final BiPredicate<? super K, ? super K> comparer;
  final Function<? super T, K> keySelector;
  
  public ObservableDistinctUntilChanged(ObservableSource<T> paramObservableSource, Function<? super T, K> paramFunction, BiPredicate<? super K, ? super K> paramBiPredicate)
  {
    super(paramObservableSource);
    this.keySelector = paramFunction;
    this.comparer = paramBiPredicate;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class DistinctUntilChangedObserver<T, K>
    extends BasicFuseableObserver<T, T>
  {
    final BiPredicate<? super K, ? super K> comparer;
    boolean hasValue;
    final Function<? super T, K> keySelector;
    K last;
    
    DistinctUntilChangedObserver(Observer<? super T> paramObserver, Function<? super T, K> paramFunction, BiPredicate<? super K, ? super K> paramBiPredicate)
    {
      super();
      this.keySelector = paramFunction;
      this.comparer = paramBiPredicate;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableDistinctUntilChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */