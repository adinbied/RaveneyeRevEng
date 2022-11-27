package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleOperator;
import io.reactivex.SingleSource;

public final class SingleLift<T, R>
  extends Single<R>
{
  final SingleOperator<? extends R, ? super T> onLift;
  final SingleSource<T> source;
  
  public SingleLift(SingleSource<T> paramSingleSource, SingleOperator<? extends R, ? super T> paramSingleOperator)
  {
    this.source = paramSingleSource;
    this.onLift = paramSingleOperator;
  }
  
  /* Error */
  protected void subscribeActual(io.reactivex.SingleObserver<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleLift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */