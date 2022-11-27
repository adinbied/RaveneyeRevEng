package io.reactivex.internal.operators.parallel;

import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Publisher;

public final class ParallelConcatMap<T, R>
  extends ParallelFlowable<R>
{
  final ErrorMode errorMode;
  final Function<? super T, ? extends Publisher<? extends R>> mapper;
  final int prefetch;
  final ParallelFlowable<T> source;
  
  public ParallelConcatMap(ParallelFlowable<T> paramParallelFlowable, Function<? super T, ? extends Publisher<? extends R>> paramFunction, int paramInt, ErrorMode paramErrorMode)
  {
    this.source = paramParallelFlowable;
    this.mapper = ((Function)ObjectHelper.requireNonNull(paramFunction, "mapper"));
    this.prefetch = paramInt;
    this.errorMode = ((ErrorMode)ObjectHelper.requireNonNull(paramErrorMode, "errorMode"));
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\parallel\ParallelConcatMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */