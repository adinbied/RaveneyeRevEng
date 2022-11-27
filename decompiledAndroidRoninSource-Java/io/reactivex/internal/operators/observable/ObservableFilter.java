package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.observers.BasicFuseableObserver;

public final class ObservableFilter<T>
  extends AbstractObservableWithUpstream<T, T>
{
  final Predicate<? super T> predicate;
  
  public ObservableFilter(ObservableSource<T> paramObservableSource, Predicate<? super T> paramPredicate)
  {
    super(paramObservableSource);
    this.predicate = paramPredicate;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class FilterObserver<T>
    extends BasicFuseableObserver<T, T>
  {
    final Predicate<? super T> filter;
    
    FilterObserver(Observer<? super T> paramObserver, Predicate<? super T> paramPredicate)
    {
      super();
      this.filter = paramPredicate;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */