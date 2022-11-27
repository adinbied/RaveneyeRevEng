package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.subscribers.DisposableSubscriber;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBufferExactBoundary<T, U extends Collection<? super T>, B>
  extends AbstractFlowableWithUpstream<T, U>
{
  final Publisher<B> boundary;
  final Callable<U> bufferSupplier;
  
  public FlowableBufferExactBoundary(Flowable<T> paramFlowable, Publisher<B> paramPublisher, Callable<U> paramCallable)
  {
    super(paramFlowable);
    this.boundary = paramPublisher;
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
  
  static final class BufferBoundarySubscriber<T, U extends Collection<? super T>, B>
    extends DisposableSubscriber<B>
  {
    final FlowableBufferExactBoundary.BufferExactBoundarySubscriber<T, U, B> parent;
    
    BufferBoundarySubscriber(FlowableBufferExactBoundary.BufferExactBoundarySubscriber<T, U, B> paramBufferExactBoundarySubscriber)
    {
      this.parent = paramBufferExactBoundarySubscriber;
    }
    
    public void onComplete()
    {
      this.parent.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.parent.onError(paramThrowable);
    }
    
    public void onNext(B paramB)
    {
      this.parent.next();
    }
  }
  
  static final class BufferExactBoundarySubscriber<T, U extends Collection<? super T>, B>
    extends QueueDrainSubscriber<T, U, U>
    implements FlowableSubscriber<T>, Subscription, Disposable
  {
    final Publisher<B> boundary;
    U buffer;
    final Callable<U> bufferSupplier;
    Disposable other;
    Subscription upstream;
    
    BufferExactBoundarySubscriber(Subscriber<? super U> paramSubscriber, Callable<U> paramCallable, Publisher<B> paramPublisher)
    {
      super(new MpscLinkedQueue());
      this.bufferSupplier = paramCallable;
      this.boundary = paramPublisher;
    }
    
    public boolean accept(Subscriber<? super U> paramSubscriber, U paramU)
    {
      this.downstream.onNext(paramU);
      return true;
    }
    
    /* Error */
    public void cancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void dispose()
    {
      cancel();
    }
    
    public boolean isDisposed()
    {
      return this.cancelled;
    }
    
    /* Error */
    void next()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
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
      //   2: return
    }
    
    public void request(long paramLong)
    {
      requested(paramLong);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableBufferExactBoundary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */