package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFlattenIterable<T, R>
  extends AbstractFlowableWithUpstream<T, R>
{
  final Function<? super T, ? extends Iterable<? extends R>> mapper;
  final int prefetch;
  
  public FlowableFlattenIterable(Flowable<T> paramFlowable, Function<? super T, ? extends Iterable<? extends R>> paramFunction, int paramInt)
  {
    super(paramFlowable);
    this.mapper = paramFunction;
    this.prefetch = paramInt;
  }
  
  /* Error */
  public void subscribeActual(Subscriber<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class FlattenIterableSubscriber<T, R>
    extends BasicIntQueueSubscription<R>
    implements FlowableSubscriber<T>
  {
    private static final long serialVersionUID = -3096000382929934955L;
    volatile boolean cancelled;
    int consumed;
    Iterator<? extends R> current;
    volatile boolean done;
    final Subscriber<? super R> downstream;
    final AtomicReference<Throwable> error;
    int fusionMode;
    final int limit;
    final Function<? super T, ? extends Iterable<? extends R>> mapper;
    final int prefetch;
    SimpleQueue<T> queue;
    final AtomicLong requested;
    Subscription upstream;
    
    FlattenIterableSubscriber(Subscriber<? super R> paramSubscriber, Function<? super T, ? extends Iterable<? extends R>> paramFunction, int paramInt)
    {
      this.downstream = paramSubscriber;
      this.mapper = paramFunction;
      this.prefetch = paramInt;
      this.limit = (paramInt - (paramInt >> 2));
      this.error = new AtomicReference();
      this.requested = new AtomicLong();
    }
    
    /* Error */
    public void cancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, Subscriber<?> paramSubscriber, SimpleQueue<?> paramSimpleQueue)
    {
      return false;
    }
    
    /* Error */
    public void clear()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void consumedOne(boolean arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
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
    
    public boolean isEmpty()
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
    
    public R poll()
      throws Exception
    {
      return null;
    }
    
    /* Error */
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    public int requestFusion(int paramInt)
    {
      return 0;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableFlattenIterable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */