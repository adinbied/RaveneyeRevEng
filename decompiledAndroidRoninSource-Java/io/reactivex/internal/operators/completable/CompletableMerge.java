package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class CompletableMerge
  extends Completable
{
  final boolean delayErrors;
  final int maxConcurrency;
  final Publisher<? extends CompletableSource> source;
  
  public CompletableMerge(Publisher<? extends CompletableSource> paramPublisher, int paramInt, boolean paramBoolean)
  {
    this.source = paramPublisher;
    this.maxConcurrency = paramInt;
    this.delayErrors = paramBoolean;
  }
  
  /* Error */
  public void subscribeActual(CompletableObserver arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class CompletableMergeSubscriber
    extends AtomicInteger
    implements FlowableSubscriber<CompletableSource>, Disposable
  {
    private static final long serialVersionUID = -2108443387387077490L;
    final boolean delayErrors;
    final CompletableObserver downstream;
    final AtomicThrowable error;
    final int maxConcurrency;
    final CompositeDisposable set;
    Subscription upstream;
    
    CompletableMergeSubscriber(CompletableObserver paramCompletableObserver, int paramInt, boolean paramBoolean)
    {
      this.downstream = paramCompletableObserver;
      this.maxConcurrency = paramInt;
      this.delayErrors = paramBoolean;
      this.set = new CompositeDisposable();
      this.error = new AtomicThrowable();
      lazySet(1);
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
    void innerComplete(MergeInnerObserver arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void innerError(MergeInnerObserver arg1, Throwable arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean isDisposed()
    {
      return this.set.isDisposed();
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
    public void onNext(CompletableSource arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onSubscribe(Subscription arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    final class MergeInnerObserver
      extends AtomicReference<Disposable>
      implements CompletableObserver, Disposable
    {
      private static final long serialVersionUID = 251330541679988317L;
      
      MergeInnerObserver() {}
      
      public void dispose()
      {
        DisposableHelper.dispose(this);
      }
      
      public boolean isDisposed()
      {
        return false;
      }
      
      public void onComplete()
      {
        CompletableMerge.CompletableMergeSubscriber.this.innerComplete(this);
      }
      
      public void onError(Throwable paramThrowable)
      {
        CompletableMerge.CompletableMergeSubscriber.this.innerError(this, paramThrowable);
      }
      
      public void onSubscribe(Disposable paramDisposable)
      {
        DisposableHelper.setOnce(this, paramDisposable);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */