package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.parallel.ParallelFlowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelFromPublisher<T>
  extends ParallelFlowable<T>
{
  final int parallelism;
  final int prefetch;
  final Publisher<? extends T> source;
  
  public ParallelFromPublisher(Publisher<? extends T> paramPublisher, int paramInt1, int paramInt2)
  {
    this.source = paramPublisher;
    this.parallelism = paramInt1;
    this.prefetch = paramInt2;
  }
  
  public int parallelism()
  {
    return this.parallelism;
  }
  
  /* Error */
  public void subscribe(Subscriber<? super T>[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ParallelDispatcher<T>
    extends AtomicInteger
    implements FlowableSubscriber<T>
  {
    private static final long serialVersionUID = -4470634016609963609L;
    volatile boolean cancelled;
    volatile boolean done;
    final long[] emissions;
    Throwable error;
    int index;
    final int limit;
    final int prefetch;
    int produced;
    SimpleQueue<T> queue;
    final AtomicLongArray requests;
    int sourceMode;
    final AtomicInteger subscriberCount = new AtomicInteger();
    final Subscriber<? super T>[] subscribers;
    Subscription upstream;
    
    ParallelDispatcher(Subscriber<? super T>[] paramArrayOfSubscriber, int paramInt)
    {
      this.subscribers = paramArrayOfSubscriber;
      this.prefetch = paramInt;
      this.limit = (paramInt - (paramInt >> 2));
      paramInt = paramArrayOfSubscriber.length;
      int i = paramInt + paramInt;
      paramArrayOfSubscriber = new AtomicLongArray(i + 1);
      this.requests = paramArrayOfSubscriber;
      paramArrayOfSubscriber.lazySet(i, paramInt);
      this.emissions = new long[paramInt];
    }
    
    /* Error */
    void cancel(int arg1)
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
    void drainSync()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public void onComplete()
    {
      this.done = true;
      drain();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.error = paramThrowable;
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
    
    /* Error */
    public void onSubscribe(Subscription arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void setupSubscribers()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    final class RailSubscription
      implements Subscription
    {
      final int j;
      final int m;
      
      RailSubscription(int paramInt1, int paramInt2)
      {
        this.j = paramInt1;
        this.m = paramInt2;
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
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\parallel\ParallelFromPublisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */