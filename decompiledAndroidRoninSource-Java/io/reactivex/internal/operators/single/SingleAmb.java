package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;

public final class SingleAmb<T>
  extends Single<T>
{
  private final SingleSource<? extends T>[] sources;
  private final Iterable<? extends SingleSource<? extends T>> sourcesIterable;
  
  public SingleAmb(SingleSource<? extends T>[] paramArrayOfSingleSource, Iterable<? extends SingleSource<? extends T>> paramIterable)
  {
    this.sources = paramArrayOfSingleSource;
    this.sourcesIterable = paramIterable;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class AmbSingleObserver<T>
    implements SingleObserver<T>
  {
    final SingleObserver<? super T> downstream;
    final CompositeDisposable set;
    Disposable upstream;
    final AtomicBoolean winner;
    
    AmbSingleObserver(SingleObserver<? super T> paramSingleObserver, CompositeDisposable paramCompositeDisposable, AtomicBoolean paramAtomicBoolean)
    {
      this.downstream = paramSingleObserver;
      this.set = paramCompositeDisposable;
      this.winner = paramAtomicBoolean;
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      this.upstream = paramDisposable;
      this.set.add(paramDisposable);
    }
    
    /* Error */
    public void onSuccess(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleAmb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */