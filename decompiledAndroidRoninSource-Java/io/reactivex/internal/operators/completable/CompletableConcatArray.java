package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableConcatArray
  extends Completable
{
  final CompletableSource[] sources;
  
  public CompletableConcatArray(CompletableSource[] paramArrayOfCompletableSource)
  {
    this.sources = paramArrayOfCompletableSource;
  }
  
  /* Error */
  public void subscribeActual(CompletableObserver arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ConcatInnerObserver
    extends AtomicInteger
    implements CompletableObserver
  {
    private static final long serialVersionUID = -7965400327305809232L;
    final CompletableObserver downstream;
    int index;
    final SequentialDisposable sd;
    final CompletableSource[] sources;
    
    ConcatInnerObserver(CompletableObserver paramCompletableObserver, CompletableSource[] paramArrayOfCompletableSource)
    {
      this.downstream = paramCompletableObserver;
      this.sources = paramArrayOfCompletableSource;
      this.sd = new SequentialDisposable();
    }
    
    /* Error */
    void next()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onComplete()
    {
      next();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.downstream.onError(paramThrowable);
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      this.sd.replace(paramDisposable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableConcatArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */