package io.reactivex.internal.operators.mixed;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatMapMaybe<T, R>
  extends Flowable<R>
{
  final ErrorMode errorMode;
  final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
  final int prefetch;
  final Flowable<T> source;
  
  public FlowableConcatMapMaybe(Flowable<T> paramFlowable, Function<? super T, ? extends MaybeSource<? extends R>> paramFunction, ErrorMode paramErrorMode, int paramInt)
  {
    this.source = paramFlowable;
    this.mapper = paramFunction;
    this.errorMode = paramErrorMode;
    this.prefetch = paramInt;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ConcatMapMaybeSubscriber<T, R>
    extends AtomicInteger
    implements FlowableSubscriber<T>, Subscription
  {
    static final int STATE_ACTIVE = 1;
    static final int STATE_INACTIVE = 0;
    static final int STATE_RESULT_VALUE = 2;
    private static final long serialVersionUID = -9140123220065488293L;
    volatile boolean cancelled;
    int consumed;
    volatile boolean done;
    final Subscriber<? super R> downstream;
    long emitted;
    final ErrorMode errorMode;
    final AtomicThrowable errors;
    final ConcatMapMaybeObserver<R> inner;
    R item;
    final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    final int prefetch;
    final SimplePlainQueue<T> queue;
    final AtomicLong requested;
    volatile int state;
    Subscription upstream;
    
    ConcatMapMaybeSubscriber(Subscriber<? super R> paramSubscriber, Function<? super T, ? extends MaybeSource<? extends R>> paramFunction, int paramInt, ErrorMode paramErrorMode)
    {
      this.downstream = paramSubscriber;
      this.mapper = paramFunction;
      this.prefetch = paramInt;
      this.errorMode = paramErrorMode;
      this.requested = new AtomicLong();
      this.errors = new AtomicThrowable();
      this.inner = new ConcatMapMaybeObserver(this);
      this.queue = new SpscArrayQueue(paramInt);
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
      //   2: return
    }
    
    void innerComplete()
    {
      this.state = 0;
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
    
    void innerSuccess(R paramR)
    {
      this.item = paramR;
      this.state = 2;
      drain();
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
    
    /* Error */
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    static final class ConcatMapMaybeObserver<R>
      extends AtomicReference<Disposable>
      implements MaybeObserver<R>
    {
      private static final long serialVersionUID = -3051469169682093892L;
      final FlowableConcatMapMaybe.ConcatMapMaybeSubscriber<?, R> parent;
      
      ConcatMapMaybeObserver(FlowableConcatMapMaybe.ConcatMapMaybeSubscriber<?, R> paramConcatMapMaybeSubscriber)
      {
        this.parent = paramConcatMapMaybeSubscriber;
      }
      
      void dispose()
      {
        DisposableHelper.dispose(this);
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
      
      public void onSuccess(R paramR)
      {
        this.parent.innerSuccess(paramR);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\mixed\FlowableConcatMapMaybe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */