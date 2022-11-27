package dji.thirdparty.rx.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.functions.Func0;
import java.util.Map;

public final class OperatorSwitchCase<K, R>
  implements Observable.OnSubscribe<R>
{
  final Func0<? extends K> caseSelector;
  final Observable<? extends R> defaultCase;
  final Map<? super K, ? extends Observable<? extends R>> mapOfCases;
  
  public OperatorSwitchCase(Func0<? extends K> paramFunc0, Map<? super K, ? extends Observable<? extends R>> paramMap, Observable<? extends R> paramObservable)
  {
    this.caseSelector = paramFunc0;
    this.mapOfCases = paramMap;
    this.defaultCase = paramObservable;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\operators\OperatorSwitchCase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */