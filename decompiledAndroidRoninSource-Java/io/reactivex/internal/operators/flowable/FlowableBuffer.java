package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.BooleanSupplier;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBuffer<T, C extends Collection<? super T>>
  extends AbstractFlowableWithUpstream<T, C>
{
  final Callable<C> bufferSupplier;
  final int size;
  final int skip;
  
  public FlowableBuffer(Flowable<T> paramFlowable, int paramInt1, int paramInt2, Callable<C> paramCallable)
  {
    super(paramFlowable);
    this.size = paramInt1;
    this.skip = paramInt2;
    this.bufferSupplier = paramCallable;
  }
  
  /* Error */
  public void subscribeActual(Subscriber<? super C> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class PublisherBufferExactSubscriber<T, C extends Collection<? super T>>
    implements FlowableSubscriber<T>, Subscription
  {
    C buffer;
    final Callable<C> bufferSupplier;
    boolean done;
    final Subscriber<? super C> downstream;
    int index;
    final int size;
    Subscription upstream;
    
    PublisherBufferExactSubscriber(Subscriber<? super C> paramSubscriber, int paramInt, Callable<C> paramCallable)
    {
      this.downstream = paramSubscriber;
      this.size = paramInt;
      this.bufferSupplier = paramCallable;
    }
    
    public void cancel()
    {
      this.upstream.cancel();
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
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  }
  
  static final class PublisherBufferOverlappingSubscriber<T, C extends Collection<? super T>>
    extends AtomicLong
    implements FlowableSubscriber<T>, Subscription, BooleanSupplier
  {
    private static final long serialVersionUID = -7370244972039324525L;
    final Callable<C> bufferSupplier;
    final ArrayDeque<C> buffers;
    volatile boolean cancelled;
    boolean done;
    final Subscriber<? super C> downstream;
    int index;
    final AtomicBoolean once;
    long produced;
    final int size;
    final int skip;
    Subscription upstream;
    
    PublisherBufferOverlappingSubscriber(Subscriber<? super C> paramSubscriber, int paramInt1, int paramInt2, Callable<C> paramCallable)
    {
      this.downstream = paramSubscriber;
      this.size = paramInt1;
      this.skip = paramInt2;
      this.bufferSupplier = paramCallable;
      this.once = new AtomicBoolean();
      this.buffers = new ArrayDeque();
    }
    
    /* Error */
    public void cancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean getAsBoolean()
    {
      return this.cancelled;
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
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  }
  
  static final class PublisherBufferSkipSubscriber<T, C extends Collection<? super T>>
    extends AtomicInteger
    implements FlowableSubscriber<T>, Subscription
  {
    private static final long serialVersionUID = -5616169793639412593L;
    C buffer;
    final Callable<C> bufferSupplier;
    boolean done;
    final Subscriber<? super C> downstream;
    int index;
    final int size;
    final int skip;
    Subscription upstream;
    
    PublisherBufferSkipSubscriber(Subscriber<? super C> paramSubscriber, int paramInt1, int paramInt2, Callable<C> paramCallable)
    {
      this.downstream = paramSubscriber;
      this.size = paramInt1;
      this.skip = paramInt2;
      this.bufferSupplier = paramCallable;
    }
    
    public void cancel()
    {
      this.upstream.cancel();
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
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */