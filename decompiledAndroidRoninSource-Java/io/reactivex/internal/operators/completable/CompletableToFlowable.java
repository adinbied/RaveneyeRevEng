package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableSource;
import io.reactivex.Flowable;

public final class CompletableToFlowable<T>
  extends Flowable<T>
{
  final CompletableSource source;
  
  public CompletableToFlowable(CompletableSource paramCompletableSource)
  {
    this.source = paramCompletableSource;
  }
  
  /* Error */
  protected void subscribeActual(org.reactivestreams.Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableToFlowable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */