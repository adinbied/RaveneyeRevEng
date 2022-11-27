package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableDoFinally
  extends Completable
{
  final Action onFinally;
  final CompletableSource source;
  
  public CompletableDoFinally(CompletableSource paramCompletableSource, Action paramAction)
  {
    this.source = paramCompletableSource;
    this.onFinally = paramAction;
  }
  
  /* Error */
  protected void subscribeActual(CompletableObserver arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class DoFinallyObserver
    extends AtomicInteger
    implements CompletableObserver, Disposable
  {
    private static final long serialVersionUID = 4109457741734051389L;
    final CompletableObserver downstream;
    final Action onFinally;
    Disposable upstream;
    
    DoFinallyObserver(CompletableObserver paramCompletableObserver, Action paramAction)
    {
      this.downstream = paramCompletableObserver;
      this.onFinally = paramAction;
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
    public void onSubscribe(Disposable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void runFinally()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableDoFinally.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */