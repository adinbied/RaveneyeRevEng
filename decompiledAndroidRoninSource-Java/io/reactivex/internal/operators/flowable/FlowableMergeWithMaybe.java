package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableMergeWithMaybe<T>
  extends AbstractFlowableWithUpstream<T, T>
{
  final MaybeSource<? extends T> other;
  
  public FlowableMergeWithMaybe(Flowable<T> paramFlowable, MaybeSource<? extends T> paramMaybeSource)
  {
    super(paramFlowable);
    this.other = paramMaybeSource;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class MergeWithObserver<T>
    extends AtomicInteger
    implements FlowableSubscriber<T>, Subscription
  {
    static final int OTHER_STATE_CONSUMED_OR_EMPTY = 2;
    static final int OTHER_STATE_HAS_VALUE = 1;
    private static final long serialVersionUID = -4592979584110982903L;
    volatile boolean cancelled;
    int consumed;
    final Subscriber<? super T> downstream;
    long emitted;
    final AtomicThrowable error;
    final int limit;
    volatile boolean mainDone;
    final AtomicReference<Subscription> mainSubscription;
    final OtherObserver<T> otherObserver;
    volatile int otherState;
    final int prefetch;
    volatile SimplePlainQueue<T> queue;
    final AtomicLong requested;
    T singleItem;
    
    MergeWithObserver(Subscriber<? super T> paramSubscriber)
    {
      this.downstream = paramSubscriber;
      this.mainSubscription = new AtomicReference();
      this.otherObserver = new OtherObserver(this);
      this.error = new AtomicThrowable();
      this.requested = new AtomicLong();
      int i = Flowable.bufferSize();
      this.prefetch = i;
      this.limit = (i - (i >> 2));
    }
    
    /* Error */
    public void cancel()
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
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void drainLoop()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    SimplePlainQueue<T> getOrCreateQueue()
    {
      return null;
    }
    
    public void onComplete()
    {
      this.mainDone = true;
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
    public void onNext(T arg1)
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
    
    void otherComplete()
    {
      this.otherState = 2;
      drain();
    }
    
    /* Error */
    void otherError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void otherSuccess(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    static final class OtherObserver<T>
      extends AtomicReference<Disposable>
      implements MaybeObserver<T>
    {
      private static final long serialVersionUID = -2935427570954647017L;
      final FlowableMergeWithMaybe.MergeWithObserver<T> parent;
      
      OtherObserver(FlowableMergeWithMaybe.MergeWithObserver<T> paramMergeWithObserver)
      {
        this.parent = paramMergeWithObserver;
      }
      
      public void onComplete()
      {
        this.parent.otherComplete();
      }
      
      public void onError(Throwable paramThrowable)
      {
        this.parent.otherError(paramThrowable);
      }
      
      public void onSubscribe(Disposable paramDisposable)
      {
        DisposableHelper.setOnce(this, paramDisposable);
      }
      
      public void onSuccess(T paramT)
      {
        this.parent.otherSuccess(paramT);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableMergeWithMaybe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */