package io.reactivex.internal.operators.single;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import java.util.Iterator;

public final class SingleFlatMapIterableObservable<T, R>
  extends Observable<R>
{
  final Function<? super T, ? extends Iterable<? extends R>> mapper;
  final SingleSource<T> source;
  
  public SingleFlatMapIterableObservable(SingleSource<T> paramSingleSource, Function<? super T, ? extends Iterable<? extends R>> paramFunction)
  {
    this.source = paramSingleSource;
    this.mapper = paramFunction;
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class FlatMapIterableObserver<T, R>
    extends BasicIntQueueDisposable<R>
    implements SingleObserver<T>
  {
    private static final long serialVersionUID = -8938804753851907758L;
    volatile boolean cancelled;
    final Observer<? super R> downstream;
    volatile Iterator<? extends R> it;
    final Function<? super T, ? extends Iterable<? extends R>> mapper;
    boolean outputFused;
    Disposable upstream;
    
    FlatMapIterableObserver(Observer<? super R> paramObserver, Function<? super T, ? extends Iterable<? extends R>> paramFunction)
    {
      this.downstream = paramObserver;
      this.mapper = paramFunction;
    }
    
    public void clear()
    {
      this.it = null;
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean isDisposed()
    {
      return this.cancelled;
    }
    
    public boolean isEmpty()
    {
      return this.it == null;
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
    public void onSubscribe(Disposable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onSuccess(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public R poll()
      throws Exception
    {
      return null;
    }
    
    public int requestFusion(int paramInt)
    {
      return 0;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleFlatMapIterableObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */