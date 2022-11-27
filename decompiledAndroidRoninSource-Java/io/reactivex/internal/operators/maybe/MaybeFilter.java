package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;

public final class MaybeFilter<T>
  extends AbstractMaybeWithUpstream<T, T>
{
  final Predicate<? super T> predicate;
  
  public MaybeFilter(MaybeSource<T> paramMaybeSource, Predicate<? super T> paramPredicate)
  {
    super(paramMaybeSource);
    this.predicate = paramPredicate;
  }
  
  /* Error */
  protected void subscribeActual(MaybeObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class FilterMaybeObserver<T>
    implements MaybeObserver<T>, Disposable
  {
    final MaybeObserver<? super T> downstream;
    final Predicate<? super T> predicate;
    Disposable upstream;
    
    FilterMaybeObserver(MaybeObserver<? super T> paramMaybeObserver, Predicate<? super T> paramPredicate)
    {
      this.downstream = paramMaybeObserver;
      this.predicate = paramPredicate;
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
      return this.upstream.isDisposed();
    }
    
    public void onComplete()
    {
      this.downstream.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.downstream.onError(paramThrowable);
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
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */