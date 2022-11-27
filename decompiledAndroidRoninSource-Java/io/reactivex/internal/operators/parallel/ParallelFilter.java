package io.reactivex.internal.operators.parallel;

import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelFilter<T>
  extends ParallelFlowable<T>
{
  final Predicate<? super T> predicate;
  final ParallelFlowable<T> source;
  
  public ParallelFilter(ParallelFlowable<T> paramParallelFlowable, Predicate<? super T> paramPredicate)
  {
    this.source = paramParallelFlowable;
    this.predicate = paramPredicate;
  }
  
  public int parallelism()
  {
    return this.source.parallelism();
  }
  
  /* Error */
  public void subscribe(Subscriber<? super T>[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static abstract class BaseFilterSubscriber<T>
    implements ConditionalSubscriber<T>, Subscription
  {
    boolean done;
    final Predicate<? super T> predicate;
    Subscription upstream;
    
    BaseFilterSubscriber(Predicate<? super T> paramPredicate)
    {
      this.predicate = paramPredicate;
    }
    
    public final void cancel()
    {
      this.upstream.cancel();
    }
    
    /* Error */
    public final void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public final void request(long paramLong)
    {
      this.upstream.request(paramLong);
    }
  }
  
  static final class ParallelFilterConditionalSubscriber<T>
    extends ParallelFilter.BaseFilterSubscriber<T>
  {
    final ConditionalSubscriber<? super T> downstream;
    
    ParallelFilterConditionalSubscriber(ConditionalSubscriber<? super T> paramConditionalSubscriber, Predicate<? super T> paramPredicate)
    {
      super();
      this.downstream = paramConditionalSubscriber;
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
    public void onSubscribe(Subscription arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean tryOnNext(T paramT)
    {
      return false;
    }
  }
  
  static final class ParallelFilterSubscriber<T>
    extends ParallelFilter.BaseFilterSubscriber<T>
  {
    final Subscriber<? super T> downstream;
    
    ParallelFilterSubscriber(Subscriber<? super T> paramSubscriber, Predicate<? super T> paramPredicate)
    {
      super();
      this.downstream = paramSubscriber;
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
    public void onSubscribe(Subscription arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean tryOnNext(T paramT)
    {
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\parallel\ParallelFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */