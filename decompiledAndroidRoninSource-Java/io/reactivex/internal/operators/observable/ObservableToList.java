package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class ObservableToList<T, U extends Collection<? super T>>
  extends AbstractObservableWithUpstream<T, U>
{
  final Callable<U> collectionSupplier;
  
  public ObservableToList(ObservableSource<T> paramObservableSource, int paramInt)
  {
    super(paramObservableSource);
    this.collectionSupplier = Functions.createArrayList(paramInt);
  }
  
  public ObservableToList(ObservableSource<T> paramObservableSource, Callable<U> paramCallable)
  {
    super(paramObservableSource);
    this.collectionSupplier = paramCallable;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super U> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class ToListObserver<T, U extends Collection<? super T>>
    implements Observer<T>, Disposable
  {
    U collection;
    final Observer<? super U> downstream;
    Disposable upstream;
    
    ToListObserver(Observer<? super U> paramObserver, U paramU)
    {
      this.downstream = paramObserver;
      this.collection = paramU;
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
    
    public void onNext(T paramT)
    {
      this.collection.add(paramT);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableToList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */