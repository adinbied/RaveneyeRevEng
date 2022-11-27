package io.reactivex.internal.operators.parallel;

import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.parallel.ParallelFlowable;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

public final class ParallelCollect<T, C>
  extends ParallelFlowable<C>
{
  final BiConsumer<? super C, ? super T> collector;
  final Callable<? extends C> initialCollection;
  final ParallelFlowable<? extends T> source;
  
  public ParallelCollect(ParallelFlowable<? extends T> paramParallelFlowable, Callable<? extends C> paramCallable, BiConsumer<? super C, ? super T> paramBiConsumer)
  {
    this.source = paramParallelFlowable;
    this.initialCollection = paramCallable;
    this.collector = paramBiConsumer;
  }
  
  public int parallelism()
  {
    return this.source.parallelism();
  }
  
  /* Error */
  void reportError(Subscriber<?>[] arg1, Throwable arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void subscribe(Subscriber<? super C>[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class ParallelCollectSubscriber<T, C>
    extends DeferredScalarSubscriber<T, C>
  {
    private static final long serialVersionUID = -4767392946044436228L;
    C collection;
    final BiConsumer<? super C, ? super T> collector;
    boolean done;
    
    ParallelCollectSubscriber(Subscriber<? super C> paramSubscriber, C paramC, BiConsumer<? super C, ? super T> paramBiConsumer)
    {
      super();
      this.collection = paramC;
      this.collector = paramBiConsumer;
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
    public void onSubscribe(org.reactivestreams.Subscription arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\parallel\ParallelCollect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */