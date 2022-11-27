package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class CompletableTimeout
  extends Completable
{
  final CompletableSource other;
  final Scheduler scheduler;
  final CompletableSource source;
  final long timeout;
  final TimeUnit unit;
  
  public CompletableTimeout(CompletableSource paramCompletableSource1, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, CompletableSource paramCompletableSource2)
  {
    this.source = paramCompletableSource1;
    this.timeout = paramLong;
    this.unit = paramTimeUnit;
    this.scheduler = paramScheduler;
    this.other = paramCompletableSource2;
  }
  
  /* Error */
  public void subscribeActual(CompletableObserver arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  final class DisposeTask
    implements Runnable
  {
    final CompletableObserver downstream;
    private final AtomicBoolean once;
    final CompositeDisposable set;
    
    DisposeTask(AtomicBoolean paramAtomicBoolean, CompositeDisposable paramCompositeDisposable, CompletableObserver paramCompletableObserver)
    {
      this.once = paramAtomicBoolean;
      this.set = paramCompositeDisposable;
      this.downstream = paramCompletableObserver;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    final class DisposeObserver
      implements CompletableObserver
    {
      DisposeObserver() {}
      
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
        CompletableTimeout.DisposeTask.this.set.add(paramDisposable);
      }
    }
  }
  
  static final class TimeOutObserver
    implements CompletableObserver
  {
    private final CompletableObserver downstream;
    private final AtomicBoolean once;
    private final CompositeDisposable set;
    
    TimeOutObserver(CompositeDisposable paramCompositeDisposable, AtomicBoolean paramAtomicBoolean, CompletableObserver paramCompletableObserver)
    {
      this.set = paramCompositeDisposable;
      this.once = paramAtomicBoolean;
      this.downstream = paramCompletableObserver;
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
      this.set.add(paramDisposable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableTimeout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */