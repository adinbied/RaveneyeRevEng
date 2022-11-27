package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.DisposableSubscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWindowBoundarySelector<T, B, V>
  extends AbstractFlowableWithUpstream<T, Flowable<T>>
{
  final int bufferSize;
  final Function<? super B, ? extends Publisher<V>> close;
  final Publisher<B> open;
  
  public FlowableWindowBoundarySelector(Flowable<T> paramFlowable, Publisher<B> paramPublisher, Function<? super B, ? extends Publisher<V>> paramFunction, int paramInt)
  {
    super(paramFlowable);
    this.open = paramPublisher;
    this.close = paramFunction;
    this.bufferSize = paramInt;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super Flowable<T>> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class OperatorWindowBoundaryCloseSubscriber<T, V>
    extends DisposableSubscriber<V>
  {
    boolean done;
    final FlowableWindowBoundarySelector.WindowBoundaryMainSubscriber<T, ?, V> parent;
    final UnicastProcessor<T> w;
    
    OperatorWindowBoundaryCloseSubscriber(FlowableWindowBoundarySelector.WindowBoundaryMainSubscriber<T, ?, V> paramWindowBoundaryMainSubscriber, UnicastProcessor<T> paramUnicastProcessor)
    {
      this.parent = paramWindowBoundaryMainSubscriber;
      this.w = paramUnicastProcessor;
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
    
    public void onNext(V paramV)
    {
      cancel();
      onComplete();
    }
  }
  
  static final class OperatorWindowBoundaryOpenSubscriber<T, B>
    extends DisposableSubscriber<B>
  {
    final FlowableWindowBoundarySelector.WindowBoundaryMainSubscriber<T, B, ?> parent;
    
    OperatorWindowBoundaryOpenSubscriber(FlowableWindowBoundarySelector.WindowBoundaryMainSubscriber<T, B, ?> paramWindowBoundaryMainSubscriber)
    {
      this.parent = paramWindowBoundaryMainSubscriber;
    }
    
    public void onComplete()
    {
      this.parent.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.parent.error(paramThrowable);
    }
    
    public void onNext(B paramB)
    {
      this.parent.open(paramB);
    }
  }
  
  static final class WindowBoundaryMainSubscriber<T, B, V>
    extends QueueDrainSubscriber<T, Object, Flowable<T>>
    implements Subscription
  {
    final AtomicReference<Disposable> boundary = new AtomicReference();
    final int bufferSize;
    final Function<? super B, ? extends Publisher<V>> close;
    final Publisher<B> open;
    final CompositeDisposable resources;
    final AtomicBoolean stopWindows = new AtomicBoolean();
    Subscription upstream;
    final AtomicLong windows = new AtomicLong();
    final List<UnicastProcessor<T>> ws;
    
    WindowBoundaryMainSubscriber(Subscriber<? super Flowable<T>> paramSubscriber, Publisher<B> paramPublisher, Function<? super B, ? extends Publisher<V>> paramFunction, int paramInt)
    {
      super(new MpscLinkedQueue());
      this.open = paramPublisher;
      this.close = paramFunction;
      this.bufferSize = paramInt;
      this.resources = new CompositeDisposable();
      this.ws = new ArrayList();
      this.windows.lazySet(1L);
    }
    
    public boolean accept(Subscriber<? super Flowable<T>> paramSubscriber, Object paramObject)
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
    
    /* Error */
    void close(FlowableWindowBoundarySelector.OperatorWindowBoundaryCloseSubscriber<T, V> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void dispose()
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
    
    /* Error */
    void error(Throwable arg1)
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
    void open(B arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void request(long paramLong)
    {
      requested(paramLong);
    }
  }
  
  static final class WindowOperation<T, B>
  {
    final B open;
    final UnicastProcessor<T> w;
    
    WindowOperation(UnicastProcessor<T> paramUnicastProcessor, B paramB)
    {
      this.w = paramUnicastProcessor;
      this.open = paramB;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableWindowBoundarySelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */