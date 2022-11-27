package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeOperator;
import io.reactivex.MaybeSource;

public final class MaybeLift<T, R>
  extends AbstractMaybeWithUpstream<T, R>
{
  final MaybeOperator<? extends R, ? super T> operator;
  
  public MaybeLift(MaybeSource<T> paramMaybeSource, MaybeOperator<? extends R, ? super T> paramMaybeOperator)
  {
    super(paramMaybeSource);
    this.operator = paramMaybeOperator;
  }
  
  /* Error */
  protected void subscribeActual(io.reactivex.MaybeObserver<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeLift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */