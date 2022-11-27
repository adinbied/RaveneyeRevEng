package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.functions.Func0;

public final class OnSubscribeDefer<T>
  implements Observable.OnSubscribe<T>
{
  final Func0<? extends Observable<? extends T>> observableFactory;
  
  public OnSubscribeDefer(Func0<? extends Observable<? extends T>> paramFunc0)
  {
    this.observableFactory = paramFunc0;
  }
  
  /* Error */
  public void call(dji.thirdparty.rx.Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OnSubscribeDefer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */