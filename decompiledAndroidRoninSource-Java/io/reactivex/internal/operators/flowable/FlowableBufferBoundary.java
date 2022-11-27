package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBufferBoundary<T, U extends Collection<? super T>, Open, Close>
  extends AbstractFlowableWithUpstream<T, U>
{
  final Function<? super Open, ? extends Publisher<? extends Close>> bufferClose;
  final Publisher<? extends Open> bufferOpen;
  final Callable<U> bufferSupplier;
  
  public FlowableBufferBoundary(Flowable<T> paramFlowable, Publisher<? extends Open> paramPublisher, Function<? super Open, ? extends Publisher<? extends Close>> paramFunction, Callable<U> paramCallable)
  {
    super(paramFlowable);
    this.bufferOpen = paramPublisher;
    this.bufferClose = paramFunction;
    this.bufferSupplier = paramCallable;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super U> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class BufferBoundarySubscriber<T, C extends Collection<? super T>, Open, Close>
    extends AtomicInteger
    implements FlowableSubscriber<T>, Subscription
  {
    private static final long serialVersionUID = -8466418554264089604L;
    final Function<? super Open, ? extends Publisher<? extends Close>> bufferClose;
    final Publisher<? extends Open> bufferOpen;
    final Callable<C> bufferSupplier;
    Map<Long, C> buffers;
    volatile boolean cancelled;
    volatile boolean done;
    final Subscriber<? super C> downstream;
    long emitted;
    final AtomicThrowable errors;
    long index;
    final SpscLinkedArrayQueue<C> queue;
    final AtomicLong requested;
    final CompositeDisposable subscribers;
    final AtomicReference<Subscription> upstream;
    
    BufferBoundarySubscriber(Subscriber<? super C> paramSubscriber, Publisher<? extends Open> paramPublisher, Function<? super Open, ? extends Publisher<? extends Close>> paramFunction, Callable<C> paramCallable)
    {
      this.downstream = paramSubscriber;
      this.bufferSupplier = paramCallable;
      this.bufferOpen = paramPublisher;
      this.bufferClose = paramFunction;
      this.queue = new SpscLinkedArrayQueue(Flowable.bufferSize());
      this.subscribers = new CompositeDisposable();
      this.requested = new AtomicLong();
      this.upstream = new AtomicReference();
      this.buffers = new LinkedHashMap();
      this.errors = new AtomicThrowable();
    }
    
    /* Error */
    void boundaryError(Disposable arg1, Throwable arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void cancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void close(FlowableBufferBoundary.BufferCloseSubscriber<T, C> arg1, long arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
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
    public void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
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
    void open(Open arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void openComplete(BufferOpenSubscriber<Open> arg1)
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
    
    static final class BufferOpenSubscriber<Open>
      extends AtomicReference<Subscription>
      implements FlowableSubscriber<Open>, Disposable
    {
      private static final long serialVersionUID = -8498650778633225126L;
      final FlowableBufferBoundary.BufferBoundarySubscriber<?, ?, Open, ?> parent;
      
      BufferOpenSubscriber(FlowableBufferBoundary.BufferBoundarySubscriber<?, ?, Open, ?> paramBufferBoundarySubscriber)
      {
        this.parent = paramBufferBoundarySubscriber;
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
      
      public void onNext(Open paramOpen)
      {
        this.parent.open(paramOpen);
      }
      
      /* Error */
      public void onSubscribe(Subscription arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    }
  }
  
  static final class BufferCloseSubscriber<T, C extends Collection<? super T>>
    extends AtomicReference<Subscription>
    implements FlowableSubscriber<Object>, Disposable
  {
    private static final long serialVersionUID = -8498650778633225126L;
    final long index;
    final FlowableBufferBoundary.BufferBoundarySubscriber<T, C, ?, ?> parent;
    
    BufferCloseSubscriber(FlowableBufferBoundary.BufferBoundarySubscriber<T, C, ?, ?> paramBufferBoundarySubscriber, long paramLong)
    {
      this.parent = paramBufferBoundarySubscriber;
      this.index = paramLong;
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
    public void onNext(Object arg1)
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
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableBufferBoundary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */