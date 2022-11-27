package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.observers.BasicFuseableObserver;

public final class ObservableDoAfterNext<T>
  extends AbstractObservableWithUpstream<T, T>
{
  final Consumer<? super T> onAfterNext;
  
  public ObservableDoAfterNext(ObservableSource<T> paramObservableSource, Consumer<? super T> paramConsumer)
  {
    super(paramObservableSource);
    this.onAfterNext = paramConsumer;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class DoAfterObserver<T>
    extends BasicFuseableObserver<T, T>
  {
    final Consumer<? super T> onAfterNext;
    
    DoAfterObserver(Observer<? super T> paramObserver, Consumer<? super T> paramConsumer)
    {
      super();
      this.onAfterNext = paramConsumer;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableDoAfterNext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */