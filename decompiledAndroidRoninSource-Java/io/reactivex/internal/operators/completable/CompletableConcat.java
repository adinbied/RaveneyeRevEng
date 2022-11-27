package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class CompletableConcat
  extends Completable
{
  final int prefetch;
  final Publisher<? extends CompletableSource> sources;
  
  public CompletableConcat(Publisher<? extends CompletableSource> paramPublisher, int paramInt)
  {
    this.sources = paramPublisher;
    this.prefetch = paramInt;
  }
  
  /* Error */
  public void subscribeActual(CompletableObserver arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class CompletableConcatSubscriber
    extends AtomicInteger
    implements FlowableSubscriber<CompletableSource>, Disposable
  {
    private static final long serialVersionUID = 9032184911934499404L;
    volatile boolean active;
    int consumed;
    volatile boolean done;
    final CompletableObserver downstream;
    final ConcatInnerObserver inner;
    final int limit;
    final AtomicBoolean once;
    final int prefetch;
    SimpleQueue<CompletableSource> queue;
    int sourceFused;
    Subscription upstream;
    
    CompletableConcatSubscriber(CompletableObserver paramCompletableObserver, int paramInt)
    {
      this.downstream = paramCompletableObserver;
      this.prefetch = paramInt;
      this.inner = new ConcatInnerObserver(this);
      this.once = new AtomicBoolean();
      this.limit = (paramInt - (paramInt >> 2));
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
    void drain()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    void innerComplete()
    {
      this.active = false;
      drain();
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
      return false;
    }
    
    public void onComplete()
    {
      this.done = true;
      drain();
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
    
    /* Error */
    void request()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    static final class ConcatInnerObserver
      extends AtomicReference<Disposable>
      implements CompletableObserver
    {
      private static final long serialVersionUID = -5454794857847146511L;
      final CompletableConcat.CompletableConcatSubscriber parent;
      
      ConcatInnerObserver(CompletableConcat.CompletableConcatSubscriber paramCompletableConcatSubscriber)
      {
        this.parent = paramCompletableConcatSubscriber;
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
        DisposableHelper.replace(this, paramDisposable);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableConcat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */