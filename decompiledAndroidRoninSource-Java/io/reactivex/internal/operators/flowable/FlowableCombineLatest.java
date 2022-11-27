package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Function;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCombineLatest<T, R>
  extends Flowable<R>
{
  final Publisher<? extends T>[] array;
  final int bufferSize;
  final Function<? super Object[], ? extends R> combiner;
  final boolean delayErrors;
  final Iterable<? extends Publisher<? extends T>> iterable;
  
  public FlowableCombineLatest(Iterable<? extends Publisher<? extends T>> paramIterable, Function<? super Object[], ? extends R> paramFunction, int paramInt, boolean paramBoolean)
  {
    this.array = null;
    this.iterable = paramIterable;
    this.combiner = paramFunction;
    this.bufferSize = paramInt;
    this.delayErrors = paramBoolean;
  }
  
  public FlowableCombineLatest(Publisher<? extends T>[] paramArrayOfPublisher, Function<? super Object[], ? extends R> paramFunction, int paramInt, boolean paramBoolean)
  {
    this.array = paramArrayOfPublisher;
    this.iterable = null;
    this.combiner = paramFunction;
    this.bufferSize = paramInt;
    this.delayErrors = paramBoolean;
  }
  
  /* Error */
  public void subscribeActual(Subscriber<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class CombineLatestCoordinator<T, R>
    extends BasicIntQueueSubscription<R>
  {
    private static final long serialVersionUID = -5082275438355852221L;
    volatile boolean cancelled;
    final Function<? super Object[], ? extends R> combiner;
    int completedSources;
    final boolean delayErrors;
    volatile boolean done;
    final Subscriber<? super R> downstream;
    final AtomicReference<Throwable> error;
    final Object[] latest;
    int nonEmptySources;
    boolean outputFused;
    final SpscLinkedArrayQueue<Object> queue;
    final AtomicLong requested;
    final FlowableCombineLatest.CombineLatestInnerSubscriber<T>[] subscribers;
    
    CombineLatestCoordinator(Subscriber<? super R> paramSubscriber, Function<? super Object[], ? extends R> paramFunction, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.downstream = paramSubscriber;
      this.combiner = paramFunction;
      paramSubscriber = new FlowableCombineLatest.CombineLatestInnerSubscriber[paramInt1];
      int i = 0;
      while (i < paramInt1)
      {
        paramSubscriber[i] = new FlowableCombineLatest.CombineLatestInnerSubscriber(this, i, paramInt2);
        i += 1;
      }
      this.subscribers = paramSubscriber;
      this.latest = new Object[paramInt1];
      this.queue = new SpscLinkedArrayQueue(paramInt2);
      this.requested = new AtomicLong();
      this.error = new AtomicReference();
      this.delayErrors = paramBoolean;
    }
    
    public void cancel()
    {
      this.cancelled = true;
      cancelAll();
    }
    
    /* Error */
    void cancelAll()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, Subscriber<?> paramSubscriber, SpscLinkedArrayQueue<?> paramSpscLinkedArrayQueue)
    {
      return false;
    }
    
    public void clear()
    {
      this.queue.clear();
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
    void drainAsync()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void drainOutput()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void innerComplete(int arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: return
    }
    
    /* Error */
    void innerError(int arg1, Throwable arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void innerValue(int arg1, T arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: return
    }
    
    public boolean isEmpty()
    {
      return this.queue.isEmpty();
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
    
    /* Error */
    void subscribe(Publisher<? extends T>[] arg1, int arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class CombineLatestInnerSubscriber<T>
    extends AtomicReference<Subscription>
    implements FlowableSubscriber<T>
  {
    private static final long serialVersionUID = -8730235182291002949L;
    final int index;
    final int limit;
    final FlowableCombineLatest.CombineLatestCoordinator<T, ?> parent;
    final int prefetch;
    int produced;
    
    CombineLatestInnerSubscriber(FlowableCombineLatest.CombineLatestCoordinator<T, ?> paramCombineLatestCoordinator, int paramInt1, int paramInt2)
    {
      this.parent = paramCombineLatestCoordinator;
      this.index = paramInt1;
      this.prefetch = paramInt2;
      this.limit = (paramInt2 - (paramInt2 >> 2));
    }
    
    public void cancel()
    {
      SubscriptionHelper.cancel(this);
    }
    
    public void onComplete()
    {
      this.parent.innerComplete(this.index);
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.parent.innerError(this.index, paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.parent.innerValue(this.index, paramT);
    }
    
    public void onSubscribe(Subscription paramSubscription)
    {
      SubscriptionHelper.setOnce(this, paramSubscription, this.prefetch);
    }
    
    /* Error */
    public void requestOne()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  final class SingletonArrayFunc
    implements Function<T, R>
  {
    SingletonArrayFunc() {}
    
    public R apply(T paramT)
      throws Exception
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableCombineLatest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */