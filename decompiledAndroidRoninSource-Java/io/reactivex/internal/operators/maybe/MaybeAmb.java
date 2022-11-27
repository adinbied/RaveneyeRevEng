package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;

public final class MaybeAmb<T>
  extends Maybe<T>
{
  private final MaybeSource<? extends T>[] sources;
  private final Iterable<? extends MaybeSource<? extends T>> sourcesIterable;
  
  public MaybeAmb(MaybeSource<? extends T>[] paramArrayOfMaybeSource, Iterable<? extends MaybeSource<? extends T>> paramIterable)
  {
    this.sources = paramArrayOfMaybeSource;
    this.sourcesIterable = paramIterable;
  }
  
  /* Error */
  protected void subscribeActual(MaybeObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class AmbMaybeObserver<T>
    implements MaybeObserver<T>
  {
    final MaybeObserver<? super T> downstream;
    final CompositeDisposable set;
    Disposable upstream;
    final AtomicBoolean winner;
    
    AmbMaybeObserver(MaybeObserver<? super T> paramMaybeObserver, CompositeDisposable paramCompositeDisposable, AtomicBoolean paramAtomicBoolean)
    {
      this.downstream = paramMaybeObserver;
      this.set = paramCompositeDisposable;
      this.winner = paramAtomicBoolean;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeAmb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */