package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.subscribers.DisposableSubscriber;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBufferBoundarySupplier<T, U extends Collection<? super T>, B>
  extends AbstractFlowableWithUpstream<T, U>
{
  final Callable<? extends Publisher<B>> boundarySupplier;
  final Callable<U> bufferSupplier;
  
  public FlowableBufferBoundarySupplier(Flowable<T> paramFlowable, Callable<? extends Publisher<B>> paramCallable, Callable<U> paramCallable1)
  {
    super(paramFlowable);
    this.boundarySupplier = paramCallable;
    this.bufferSupplier = paramCallable1;
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
    boolean once;
    final FlowableBufferBoundarySupplier.BufferBoundarySupplierSubscriber<T, U, B> parent;
    
    BufferBoundarySubscriber(FlowableBufferBoundarySupplier.BufferBoundarySupplierSubscriber<T, U, B> paramBufferBoundarySupplierSubscriber)
    {
      this.parent = paramBufferBoundarySupplierSubscriber;
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
    
    public void onNext(B paramB)
    {
      if (this.once) {
        return;
      }
      this.once = true;
      cancel();
      this.parent.next();
    }
  }
  
  static final class BufferBoundarySupplierSubscriber<T, U extends Collection<? super T>, B>
    extends QueueDrainSubscriber<T, U, U>
    implements FlowableSubscriber<T>, Subscription, Disposable
  {
    final Callable<? extends Publisher<B>> boundarySupplier;
    U buffer;
    final Callable<U> bufferSupplier;
    final AtomicReference<Disposable> other = new AtomicReference();
    Subscription upstream;
    
    BufferBoundarySupplierSubscriber(Subscriber<? super U> paramSubscriber, Callable<U> paramCallable, Callable<? extends Publisher<B>> paramCallable1)
    {
      super(new MpscLinkedQueue());
      this.bufferSupplier = paramCallable;
      this.boundarySupplier = paramCallable1;
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
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    void disposeOther()
    {
      DisposableHelper.dispose(this.other);
    }
    
    public boolean isDisposed()
    {
      return false;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableBufferBoundarySupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */