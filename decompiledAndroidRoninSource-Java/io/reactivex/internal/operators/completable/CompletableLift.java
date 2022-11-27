package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableOperator;
import io.reactivex.CompletableSource;

public final class CompletableLift
  extends Completable
{
  final CompletableOperator onLift;
  final CompletableSource source;
  
  public CompletableLift(CompletableSource paramCompletableSource, CompletableOperator paramCompletableOperator)
  {
    this.source = paramCompletableSource;
    this.onLift = paramCompletableOperator;
  }
  
  /* Error */
  protected void subscribeActual(io.reactivex.CompletableObserver arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableLift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */