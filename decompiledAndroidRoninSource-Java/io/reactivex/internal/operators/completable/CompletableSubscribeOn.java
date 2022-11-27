package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableSubscribeOn
  extends Completable
{
  final Scheduler scheduler;
  final CompletableSource source;
  
  public CompletableSubscribeOn(CompletableSource paramCompletableSource, Scheduler paramScheduler)
  {
    this.source = paramCompletableSource;
    this.scheduler = paramScheduler;
  }
  
  /* Error */
  protected void subscribeActual(CompletableObserver arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class SubscribeOnObserver
    extends AtomicReference<Disposable>
    implements CompletableObserver, Disposable, Runnable
  {
    private static final long serialVersionUID = 7000911171163930287L;
    final CompletableObserver downstream;
    final CompletableSource source;
    final SequentialDisposable task;
    
    SubscribeOnObserver(CompletableObserver paramCompletableObserver, CompletableSource paramCompletableSource)
    {
      this.downstream = paramCompletableObserver;
      this.source = paramCompletableSource;
      this.task = new SequentialDisposable();
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
      return false;
    }
    
    public void onComplete()
    {
      this.downstream.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.downstream.onError(paramThrowable);
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      DisposableHelper.setOnce(this, paramDisposable);
    }
    
    public void run()
    {
      this.source.subscribe(this);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableSubscribeOn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */