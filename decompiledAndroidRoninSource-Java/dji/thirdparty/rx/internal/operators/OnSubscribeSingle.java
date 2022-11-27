package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Single.OnSubscribe;
import dji.thirdparty.rx.SingleSubscriber;
import dji.thirdparty.rx.Subscriber;

public class OnSubscribeSingle<T>
  implements Single.OnSubscribe<T>
{
  private final Observable<T> observable;
  
  public OnSubscribeSingle(Observable<T> paramObservable)
  {
    this.observable = paramObservable;
  }
  
  public static <T> OnSubscribeSingle<T> create(Observable<T> paramObservable)
  {
    return new OnSubscribeSingle(paramObservable);
  }
  
  /* Error */
  public void call(SingleSubscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OnSubscribeSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */