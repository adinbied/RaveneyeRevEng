package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import io.reactivex.internal.observers.BasicFuseableObserver;

public final class ObservableMap<T, U>
  extends AbstractObservableWithUpstream<T, U>
{
  final Function<? super T, ? extends U> function;
  
  public ObservableMap(ObservableSource<T> paramObservableSource, Function<? super T, ? extends U> paramFunction)
  {
    super(paramObservableSource);
    this.function = paramFunction;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super U> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class MapObserver<T, U>
    extends BasicFuseableObserver<T, U>
  {
    final Function<? super T, ? extends U> mapper;
    
    MapObserver(Observer<? super U> paramObserver, Function<? super T, ? extends U> paramFunction)
    {
      super();
      this.mapper = paramFunction;
    }
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public U poll()
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */