package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;

public final class MaybeOnErrorComplete<T>
  extends AbstractMaybeWithUpstream<T, T>
{
  final Predicate<? super Throwable> predicate;
  
  public MaybeOnErrorComplete(MaybeSource<T> paramMaybeSource, Predicate<? super Throwable> paramPredicate)
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
  
  static final class OnErrorCompleteMaybeObserver<T>
    implements MaybeObserver<T>, Disposable
  {
    final MaybeObserver<? super T> downstream;
    final Predicate<? super Throwable> predicate;
    Disposable upstream;
    
    OnErrorCompleteMaybeObserver(MaybeObserver<? super T> paramMaybeObserver, Predicate<? super Throwable> paramPredicate)
    {
      this.downstream = paramMaybeObserver;
      this.predicate = paramPredicate;
    }
    
    public void dispose()
    {
      this.upstream.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.upstream.isDisposed();
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
    
    public void onSuccess(T paramT)
    {
      this.downstream.onSuccess(paramT);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeOnErrorComplete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */