package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

public final class MaybeDoOnTerminate<T>
  extends Maybe<T>
{
  final Action onTerminate;
  final MaybeSource<T> source;
  
  public MaybeDoOnTerminate(MaybeSource<T> paramMaybeSource, Action paramAction)
  {
    this.source = paramMaybeSource;
    this.onTerminate = paramAction;
  }
  
  /* Error */
  protected void subscribeActual(MaybeObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  final class DoOnTerminate
    implements MaybeObserver<T>
  {
    final MaybeObserver<? super T> downstream;
    
    DoOnTerminate()
    {
      MaybeObserver localMaybeObserver;
      this.downstream = localMaybeObserver;
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      this.downstream.onSubscribe(paramDisposable);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeDoOnTerminate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */