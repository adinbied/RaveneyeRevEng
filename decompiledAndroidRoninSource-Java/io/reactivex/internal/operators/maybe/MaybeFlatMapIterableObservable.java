package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.observers.BasicQueueDisposable;
import java.util.Iterator;

public final class MaybeFlatMapIterableObservable<T, R>
  extends Observable<R>
{
  final Function<? super T, ? extends Iterable<? extends R>> mapper;
  final MaybeSource<T> source;
  
  public MaybeFlatMapIterableObservable(MaybeSource<T> paramMaybeSource, Function<? super T, ? extends Iterable<? extends R>> paramFunction)
  {
    this.source = paramMaybeSource;
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
    extends BasicQueueDisposable<R>
    implements MaybeObserver<T>
  {
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
    
    public void onComplete()
    {
      this.downstream.onComplete();
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeFlatMapIterableObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */