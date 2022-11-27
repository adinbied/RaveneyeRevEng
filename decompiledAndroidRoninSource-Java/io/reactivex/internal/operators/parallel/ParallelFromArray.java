package io.reactivex.internal.operators.parallel;

import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Publisher;

public final class ParallelFromArray<T>
  extends ParallelFlowable<T>
{
  final Publisher<T>[] sources;
  
  public ParallelFromArray(Publisher<T>[] paramArrayOfPublisher)
  {
    this.sources = paramArrayOfPublisher;
  }
  
  public int parallelism()
  {
    return this.sources.length;
  }
  
  /* Error */
  public void subscribe(org.reactivestreams.Subscriber<? super T>[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\parallel\ParallelFromArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */