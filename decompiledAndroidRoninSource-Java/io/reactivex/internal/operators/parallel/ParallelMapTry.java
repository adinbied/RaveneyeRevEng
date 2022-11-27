package io.reactivex.internal.operators.parallel;

import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.parallel.ParallelFailureHandling;
import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelMapTry<T, R>
  extends ParallelFlowable<R>
{
  final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
  final Function<? super T, ? extends R> mapper;
  final ParallelFlowable<T> source;
  
  public ParallelMapTry(ParallelFlowable<T> paramParallelFlowable, Function<? super T, ? extends R> paramFunction, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> paramBiFunction)
  {
    this.source = paramParallelFlowable;
    this.mapper = paramFunction;
    this.errorHandler = paramBiFunction;
  }
  
  public int parallelism()
  {
    return this.source.parallelism();
  }
  
  /* Error */
  public void subscribe(Subscriber<? super R>[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ParallelMapTryConditionalSubscriber<T, R>
    implements ConditionalSubscriber<T>, Subscription
  {
    boolean done;
    final ConditionalSubscriber<? super R> downstream;
    final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
    final Function<? super T, ? extends R> mapper;
    Subscription upstream;
    
    ParallelMapTryConditionalSubscriber(ConditionalSubscriber<? super R> paramConditionalSubscriber, Function<? super T, ? extends R> paramFunction, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> paramBiFunction)
    {
      this.downstream = paramConditionalSubscriber;
      this.mapper = paramFunction;
      this.errorHandler = paramBiFunction;
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
    
    public void request(long paramLong)
    {
      this.upstream.request(paramLong);
    }
    
    public boolean tryOnNext(T paramT)
    {
      return false;
    }
  }
  
  static final class ParallelMapTrySubscriber<T, R>
    implements ConditionalSubscriber<T>, Subscription
  {
    boolean done;
    final Subscriber<? super R> downstream;
    final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
    final Function<? super T, ? extends R> mapper;
    Subscription upstream;
    
    ParallelMapTrySubscriber(Subscriber<? super R> paramSubscriber, Function<? super T, ? extends R> paramFunction, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> paramBiFunction)
    {
      this.downstream = paramSubscriber;
      this.mapper = paramFunction;
      this.errorHandler = paramBiFunction;
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
    
    public void request(long paramLong)
    {
      this.upstream.request(paramLong);
    }
    
    public boolean tryOnNext(T paramT)
    {
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\parallel\ParallelMapTry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */