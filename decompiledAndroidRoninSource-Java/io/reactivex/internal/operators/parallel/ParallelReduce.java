package io.reactivex.internal.operators.parallel;

import io.reactivex.functions.BiFunction;
import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.parallel.ParallelFlowable;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

public final class ParallelReduce<T, R>
  extends ParallelFlowable<R>
{
  final Callable<R> initialSupplier;
  final BiFunction<R, ? super T, R> reducer;
  final ParallelFlowable<? extends T> source;
  
  public ParallelReduce(ParallelFlowable<? extends T> paramParallelFlowable, Callable<R> paramCallable, BiFunction<R, ? super T, R> paramBiFunction)
  {
    this.source = paramParallelFlowable;
    this.initialSupplier = paramCallable;
    this.reducer = paramBiFunction;
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
  public void subscribe(Subscriber<? super R>[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class ParallelReduceSubscriber<T, R>
    extends DeferredScalarSubscriber<T, R>
  {
    private static final long serialVersionUID = 8200530050639449080L;
    R accumulator;
    boolean done;
    final BiFunction<R, ? super T, R> reducer;
    
    ParallelReduceSubscriber(Subscriber<? super R> paramSubscriber, R paramR, BiFunction<R, ? super T, R> paramBiFunction)
    {
      super();
      this.accumulator = paramR;
      this.reducer = paramBiFunction;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\parallel\ParallelReduce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */