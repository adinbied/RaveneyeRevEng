package io.reactivex.internal.operators.parallel;

import io.reactivex.functions.Function;
import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Publisher;

public final class ParallelFlatMap<T, R>
  extends ParallelFlowable<R>
{
  final boolean delayError;
  final Function<? super T, ? extends Publisher<? extends R>> mapper;
  final int maxConcurrency;
  final int prefetch;
  final ParallelFlowable<T> source;
  
  public ParallelFlatMap(ParallelFlowable<T> paramParallelFlowable, Function<? super T, ? extends Publisher<? extends R>> paramFunction, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.source = paramParallelFlowable;
    this.mapper = paramFunction;
    this.delayError = paramBoolean;
    this.maxConcurrency = paramInt1;
    this.prefetch = paramInt2;
  }
  
  public int parallelism()
  {
    return this.source.parallelism();
  }
  
  /* Error */
  public void subscribe(org.reactivestreams.Subscriber<? super R>[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\parallel\ParallelFlatMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */