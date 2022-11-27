package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFlatMap<T, U>
  extends AbstractFlowableWithUpstream<T, U>
{
  final int bufferSize;
  final boolean delayErrors;
  final Function<? super T, ? extends Publisher<? extends U>> mapper;
  final int maxConcurrency;
  
  public FlowableFlatMap(Flowable<T> paramFlowable, Function<? super T, ? extends Publisher<? extends U>> paramFunction, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(paramFlowable);
    this.mapper = paramFunction;
    this.delayErrors = paramBoolean;
    this.maxConcurrency = paramInt1;
    this.bufferSize = paramInt2;
  }
  
  public static <T, U> FlowableSubscriber<T> subscribe(Subscriber<? super U> paramSubscriber, Function<? super T, ? extends Publisher<? extends U>> paramFunction, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    return new MergeSubscriber(paramSubscriber, paramFunction, paramBoolean, paramInt1, paramInt2);
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super U> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class InnerSubscriber<T, U>
    extends AtomicReference<Subscription>
    implements FlowableSubscriber<U>, Disposable
  {
    private static final long serialVersionUID = -4606175640614850599L;
    final int bufferSize;
    volatile boolean done;
    int fusionMode;
    final long id;
    final int limit;
    final FlowableFlatMap.MergeSubscriber<T, U> parent;
    long produced;
    volatile SimpleQueue<U> queue;
    
    InnerSubscriber(FlowableFlatMap.MergeSubscriber<T, U> paramMergeSubscriber, long paramLong)
    {
      this.id = paramLong;
      this.parent = paramMergeSubscriber;
      int i = paramMergeSubscriber.bufferSize;
      this.bufferSize = i;
      this.limit = (i >> 2);
    }
    
    public void dispose()
    {
      SubscriptionHelper.cancel(this);
    }
    
    public boolean isDisposed()
    {
      return false;
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
    public void onNext(U arg1)
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
    void requestMore(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  }
  
  static final class MergeSubscriber<T, U>
    extends AtomicInteger
    implements FlowableSubscriber<T>, Subscription
  {
    static final FlowableFlatMap.InnerSubscriber<?, ?>[] CANCELLED = new FlowableFlatMap.InnerSubscriber[0];
    static final FlowableFlatMap.InnerSubscriber<?, ?>[] EMPTY = new FlowableFlatMap.InnerSubscriber[0];
    private static final long serialVersionUID = -2117620485640801370L;
    final int bufferSize;
    volatile boolean cancelled;
    final boolean delayErrors;
    volatile boolean done;
    final Subscriber<? super U> downstream;
    final AtomicThrowable errs = new AtomicThrowable();
    long lastId;
    int lastIndex;
    final Function<? super T, ? extends Publisher<? extends U>> mapper;
    final int maxConcurrency;
    volatile SimplePlainQueue<U> queue;
    final AtomicLong requested = new AtomicLong();
    int scalarEmitted;
    final int scalarLimit;
    final AtomicReference<FlowableFlatMap.InnerSubscriber<?, ?>[]> subscribers = new AtomicReference();
    long uniqueId;
    Subscription upstream;
    
    MergeSubscriber(Subscriber<? super U> paramSubscriber, Function<? super T, ? extends Publisher<? extends U>> paramFunction, boolean paramBoolean, int paramInt1, int paramInt2)
    {
      this.downstream = paramSubscriber;
      this.mapper = paramFunction;
      this.delayErrors = paramBoolean;
      this.maxConcurrency = paramInt1;
      this.bufferSize = paramInt2;
      this.scalarLimit = Math.max(1, paramInt1 >> 1);
      this.subscribers.lazySet(EMPTY);
    }
    
    boolean addInner(FlowableFlatMap.InnerSubscriber<T, U> paramInnerSubscriber)
    {
      return false;
    }
    
    /* Error */
    public void cancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    boolean checkTerminate()
    {
      return false;
    }
    
    void clearScalarQueue()
    {
      SimplePlainQueue localSimplePlainQueue = this.queue;
      if (localSimplePlainQueue != null) {
        localSimplePlainQueue.clear();
      }
    }
    
    /* Error */
    void disposeAll()
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
      //   2: return
    }
    
    SimpleQueue<U> getInnerQueue(FlowableFlatMap.InnerSubscriber<T, U> paramInnerSubscriber)
    {
      return null;
    }
    
    SimpleQueue<U> getMainQueue()
    {
      return null;
    }
    
    /* Error */
    void innerError(FlowableFlatMap.InnerSubscriber<T, U> arg1, Throwable arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
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
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
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
    void removeInner(FlowableFlatMap.InnerSubscriber<T, U> arg1)
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
    
    /* Error */
    void tryEmit(U arg1, FlowableFlatMap.InnerSubscriber<T, U> arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void tryEmitScalar(U arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableFlatMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */