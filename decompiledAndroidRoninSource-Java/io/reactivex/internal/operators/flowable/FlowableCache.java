package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCache<T>
  extends AbstractFlowableWithUpstream<T, T>
  implements FlowableSubscriber<T>
{
  static final CacheSubscription[] EMPTY = new CacheSubscription[0];
  static final CacheSubscription[] TERMINATED = new CacheSubscription[0];
  final int capacityHint;
  volatile boolean done;
  Throwable error;
  final Node<T> head;
  final AtomicBoolean once;
  volatile long size;
  final AtomicReference<CacheSubscription<T>[]> subscribers;
  Node<T> tail;
  int tailOffset;
  
  public FlowableCache(Flowable<T> paramFlowable, int paramInt)
  {
    super(paramFlowable);
    this.capacityHint = paramInt;
    this.once = new AtomicBoolean();
    paramFlowable = new Node(paramInt);
    this.head = paramFlowable;
    this.tail = paramFlowable;
    this.subscribers = new AtomicReference(EMPTY);
  }
  
  /* Error */
  void add(CacheSubscription<T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  long cachedEventCount()
  {
    return this.size;
  }
  
  boolean hasSubscribers()
  {
    return false;
  }
  
  boolean isConnected()
  {
    return this.once.get();
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
  void remove(CacheSubscription<T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void replay(CacheSubscription<T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class CacheSubscription<T>
    extends AtomicInteger
    implements Subscription
  {
    private static final long serialVersionUID = 6770240836423125754L;
    final Subscriber<? super T> downstream;
    long index;
    FlowableCache.Node<T> node;
    int offset;
    final FlowableCache<T> parent;
    final AtomicLong requested;
    
    CacheSubscription(Subscriber<? super T> paramSubscriber, FlowableCache<T> paramFlowableCache)
    {
      this.downstream = paramSubscriber;
      this.parent = paramFlowableCache;
      this.node = paramFlowableCache.head;
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
    
    /* Error */
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  }
  
  static final class Node<T>
  {
    volatile Node<T> next;
    final T[] values;
    
    Node(int paramInt)
    {
      this.values = ((Object[])new Object[paramInt]);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */