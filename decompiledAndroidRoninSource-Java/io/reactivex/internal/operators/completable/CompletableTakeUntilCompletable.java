package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableTakeUntilCompletable
  extends Completable
{
  final CompletableSource other;
  final Completable source;
  
  public CompletableTakeUntilCompletable(Completable paramCompletable, CompletableSource paramCompletableSource)
  {
    this.source = paramCompletable;
    this.other = paramCompletableSource;
  }
  
  /* Error */
  protected void subscribeActual(CompletableObserver arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class TakeUntilMainObserver
    extends AtomicReference<Disposable>
    implements CompletableObserver, Disposable
  {
    private static final long serialVersionUID = 3533011714830024923L;
    final CompletableObserver downstream;
    final AtomicBoolean once;
    final OtherObserver other;
    
    TakeUntilMainObserver(CompletableObserver paramCompletableObserver)
    {
      this.downstream = paramCompletableObserver;
      this.other = new OtherObserver(this);
      this.once = new AtomicBoolean();
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void innerComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void innerError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean isDisposed()
    {
      return this.once.get();
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
      DisposableHelper.setOnce(this, paramDisposable);
    }
    
    static final class OtherObserver
      extends AtomicReference<Disposable>
      implements CompletableObserver
    {
      private static final long serialVersionUID = 5176264485428790318L;
      final CompletableTakeUntilCompletable.TakeUntilMainObserver parent;
      
      OtherObserver(CompletableTakeUntilCompletable.TakeUntilMainObserver paramTakeUntilMainObserver)
      {
        this.parent = paramTakeUntilMainObserver;
      }
      
      public void onComplete()
      {
        this.parent.innerComplete();
      }
      
      public void onError(Throwable paramThrowable)
      {
        this.parent.innerError(paramThrowable);
      }
      
      public void onSubscribe(Disposable paramDisposable)
      {
        DisposableHelper.setOnce(this, paramDisposable);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableTakeUntilCompletable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */