package dji.thirdparty.rx.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.functions.Func0;

public final class OperatorIfThen<R>
  implements Observable.OnSubscribe<R>
{
  final Func0<Boolean> condition;
  final Observable<? extends R> orElse;
  final Observable<? extends R> then;
  
  public OperatorIfThen(Func0<Boolean> paramFunc0, Observable<? extends R> paramObservable1, Observable<? extends R> paramObservable2)
  {
    this.condition = paramFunc0;
    this.then = paramObservable1;
    this.orElse = paramObservable2;
  }
  
  /* Error */
  public void call(dji.thirdparty.rx.Subscriber<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\operators\OperatorIfThen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */