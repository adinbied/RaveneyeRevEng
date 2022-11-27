package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelMap<T, R>
  extends ParallelFlowable<R>
{
  final Function<? super T, ? extends R> mapper;
  final ParallelFlowable<T> source;
  
  public ParallelMap(ParallelFlowable<T> paramParallelFlowable, Function<? super T, ? extends R> paramFunction)
  {
    this.source = paramParallelFlowable;
    this.mapper = paramFunction;
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
  
  static final class ParallelMapConditionalSubscriber<T, R>
    implements ConditionalSubscriber<T>, Subscription
  {
    boolean done;
    final ConditionalSubscriber<? super R> downstream;
    final Function<? super T, ? extends R> mapper;
    Subscription upstream;
    
    ParallelMapConditionalSubscriber(ConditionalSubscriber<? super R> paramConditionalSubscriber, Function<? super T, ? extends R> paramFunction)
    {
      this.downstream = paramConditionalSubscriber;
      this.mapper = paramFunction;
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
    
    public void request(long paramLong)
    {
      this.upstream.request(paramLong);
    }
    
    public boolean tryOnNext(T paramT)
    {
      return false;
    }
  }
  
  static final class ParallelMapSubscriber<T, R>
    implements FlowableSubscriber<T>, Subscription
  {
    boolean done;
    final Subscriber<? super R> downstream;
    final Function<? super T, ? extends R> mapper;
    Subscription upstream;
    
    ParallelMapSubscriber(Subscriber<? super R> paramSubscriber, Function<? super T, ? extends R> paramFunction)
    {
      this.downstream = paramSubscriber;
      this.mapper = paramFunction;
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
    
    public void request(long paramLong)
    {
      this.upstream.request(paramLong);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\parallel\ParallelMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */