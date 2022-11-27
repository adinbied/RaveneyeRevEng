package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import java.util.Iterator;

public final class ObservableZipIterable<T, U, V>
  extends Observable<V>
{
  final Iterable<U> other;
  final Observable<? extends T> source;
  final BiFunction<? super T, ? super U, ? extends V> zipper;
  
  public ObservableZipIterable(Observable<? extends T> paramObservable, Iterable<U> paramIterable, BiFunction<? super T, ? super U, ? extends V> paramBiFunction)
  {
    this.source = paramObservable;
    this.other = paramIterable;
    this.zipper = paramBiFunction;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super V> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class ZipIterableObserver<T, U, V>
    implements Observer<T>, Disposable
  {
    boolean done;
    final Observer<? super V> downstream;
    final Iterator<U> iterator;
    Disposable upstream;
    final BiFunction<? super T, ? super U, ? extends V> zipper;
    
    ZipIterableObserver(Observer<? super V> paramObserver, Iterator<U> paramIterator, BiFunction<? super T, ? super U, ? extends V> paramBiFunction)
    {
      this.downstream = paramObserver;
      this.iterator = paramIterator;
      this.zipper = paramBiFunction;
    }
    
    public void dispose()
    {
      this.upstream.dispose();
    }
    
    /* Error */
    void error(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableZipIterable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */