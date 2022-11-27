package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCreate<T>
  extends Flowable<T>
{
  final BackpressureStrategy backpressure;
  final FlowableOnSubscribe<T> source;
  
  public FlowableCreate(FlowableOnSubscribe<T> paramFlowableOnSubscribe, BackpressureStrategy paramBackpressureStrategy)
  {
    this.source = paramFlowableOnSubscribe;
    this.backpressure = paramBackpressureStrategy;
  }
  
  /* Error */
  public void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static abstract class BaseEmitter<T>
    extends AtomicLong
    implements FlowableEmitter<T>, Subscription
  {
    private static final long serialVersionUID = 7326289992464377023L;
    final Subscriber<? super T> downstream;
    final SequentialDisposable serial;
    
    BaseEmitter(Subscriber<? super T> paramSubscriber)
    {
      this.downstream = paramSubscriber;
      this.serial = new SequentialDisposable();
    }
    
    /* Error */
    public final void cancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    protected void complete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    protected boolean error(Throwable paramThrowable)
    {
      return false;
    }
    
    public final boolean isCancelled()
    {
      return this.serial.isDisposed();
    }
    
    public void onComplete()
    {
      complete();
    }
    
    /* Error */
    public final void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    void onRequested() {}
    
    void onUnsubscribed() {}
    
    /* Error */
    public final void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    public final long requested()
    {
      return get();
    }
    
    public final FlowableEmitter<T> serialize()
    {
      return new FlowableCreate.SerializedEmitter(this);
    }
    
    /* Error */
    public final void setCancellable(Cancellable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public final void setDisposable(Disposable paramDisposable)
    {
      this.serial.update(paramDisposable);
    }
    
    public String toString()
    {
      return null;
    }
    
    public boolean tryOnError(Throwable paramThrowable)
    {
      return error(paramThrowable);
    }
  }
  
  static final class BufferAsyncEmitter<T>
    extends FlowableCreate.BaseEmitter<T>
  {
    private static final long serialVersionUID = 2427151001689639875L;
    volatile boolean done;
    Throwable error;
    final SpscLinkedArrayQueue<T> queue;
    final AtomicInteger wip;
    
    BufferAsyncEmitter(Subscriber<? super T> paramSubscriber, int paramInt)
    {
      super();
      this.queue = new SpscLinkedArrayQueue(paramInt);
      this.wip = new AtomicInteger();
    }
    
    /* Error */
    void drain()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onComplete()
    {
      this.done = true;
      drain();
    }
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    void onRequested()
    {
      drain();
    }
    
    /* Error */
    void onUnsubscribed()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean tryOnError(Throwable paramThrowable)
    {
      return false;
    }
  }
  
  static final class DropAsyncEmitter<T>
    extends FlowableCreate.NoOverflowBaseAsyncEmitter<T>
  {
    private static final long serialVersionUID = 8360058422307496563L;
    
    DropAsyncEmitter(Subscriber<? super T> paramSubscriber)
    {
      super();
    }
    
    void onOverflow() {}
  }
  
  static final class ErrorAsyncEmitter<T>
    extends FlowableCreate.NoOverflowBaseAsyncEmitter<T>
  {
    private static final long serialVersionUID = 338953216916120960L;
    
    ErrorAsyncEmitter(Subscriber<? super T> paramSubscriber)
    {
      super();
    }
    
    /* Error */
    void onOverflow()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class LatestAsyncEmitter<T>
    extends FlowableCreate.BaseEmitter<T>
  {
    private static final long serialVersionUID = 4023437720691792495L;
    volatile boolean done;
    Throwable error;
    final AtomicReference<T> queue = new AtomicReference();
    final AtomicInteger wip = new AtomicInteger();
    
    LatestAsyncEmitter(Subscriber<? super T> paramSubscriber)
    {
      super();
    }
    
    /* Error */
    void drain()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onComplete()
    {
      this.done = true;
      drain();
    }
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    void onRequested()
    {
      drain();
    }
    
    /* Error */
    void onUnsubscribed()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean tryOnError(Throwable paramThrowable)
    {
      return false;
    }
  }
  
  static final class MissingEmitter<T>
    extends FlowableCreate.BaseEmitter<T>
  {
    private static final long serialVersionUID = 3776720187248809713L;
    
    MissingEmitter(Subscriber<? super T> paramSubscriber)
    {
      super();
    }
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static abstract class NoOverflowBaseAsyncEmitter<T>
    extends FlowableCreate.BaseEmitter<T>
  {
    private static final long serialVersionUID = 4127754106204442833L;
    
    NoOverflowBaseAsyncEmitter(Subscriber<? super T> paramSubscriber)
    {
      super();
    }
    
    /* Error */
    public final void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    abstract void onOverflow();
  }
  
  static final class SerializedEmitter<T>
    extends AtomicInteger
    implements FlowableEmitter<T>
  {
    private static final long serialVersionUID = 4883307006032401862L;
    volatile boolean done;
    final FlowableCreate.BaseEmitter<T> emitter;
    final AtomicThrowable error;
    final SimplePlainQueue<T> queue;
    
    SerializedEmitter(FlowableCreate.BaseEmitter<T> paramBaseEmitter)
    {
      this.emitter = paramBaseEmitter;
      this.error = new AtomicThrowable();
      this.queue = new SpscLinkedArrayQueue(16);
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
    
    public boolean isCancelled()
    {
      return this.emitter.isCancelled();
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
    
    public long requested()
    {
      return this.emitter.requested();
    }
    
    public FlowableEmitter<T> serialize()
    {
      return this;
    }
    
    public void setCancellable(Cancellable paramCancellable)
    {
      this.emitter.setCancellable(paramCancellable);
    }
    
    public void setDisposable(Disposable paramDisposable)
    {
      this.emitter.setDisposable(paramDisposable);
    }
    
    public String toString()
    {
      return this.emitter.toString();
    }
    
    public boolean tryOnError(Throwable paramThrowable)
    {
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableCreate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */