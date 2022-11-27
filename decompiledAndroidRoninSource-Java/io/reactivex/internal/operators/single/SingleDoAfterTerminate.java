package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

public final class SingleDoAfterTerminate<T>
  extends Single<T>
{
  final Action onAfterTerminate;
  final SingleSource<T> source;
  
  public SingleDoAfterTerminate(SingleSource<T> paramSingleSource, Action paramAction)
  {
    this.source = paramSingleSource;
    this.onAfterTerminate = paramAction;
  }
  
  /* Error */
  protected void subscribeActual(SingleObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class DoAfterTerminateObserver<T>
    implements SingleObserver<T>, Disposable
  {
    final SingleObserver<? super T> downstream;
    final Action onAfterTerminate;
    Disposable upstream;
    
    DoAfterTerminateObserver(SingleObserver<? super T> paramSingleObserver, Action paramAction)
    {
      this.downstream = paramSingleObserver;
      this.onAfterTerminate = paramAction;
    }
    
    /* Error */
    private void onAfterTerminate()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
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
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleDoAfterTerminate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */