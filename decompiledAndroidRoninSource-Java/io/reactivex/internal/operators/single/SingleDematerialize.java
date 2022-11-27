package io.reactivex.internal.operators.single;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Notification;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public final class SingleDematerialize<T, R>
  extends Maybe<R>
{
  final Function<? super T, Notification<R>> selector;
  final Single<T> source;
  
  public SingleDematerialize(Single<T> paramSingle, Function<? super T, Notification<R>> paramFunction)
  {
    this.source = paramSingle;
    this.selector = paramFunction;
  }
  
  /* Error */
  protected void subscribeActual(MaybeObserver<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class DematerializeObserver<T, R>
    implements SingleObserver<T>, Disposable
  {
    final MaybeObserver<? super R> downstream;
    final Function<? super T, Notification<R>> selector;
    Disposable upstream;
    
    DematerializeObserver(MaybeObserver<? super R> paramMaybeObserver, Function<? super T, Notification<R>> paramFunction)
    {
      this.downstream = paramMaybeObserver;
      this.selector = paramFunction;
    }
    
    public void dispose()
    {
      this.upstream.dispose();
    }
    
    public boolean isDisposed()
    {
      return this.upstream.isDisposed();
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleDematerialize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */