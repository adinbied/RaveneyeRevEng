package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.OnSubscribe;
import java.util.concurrent.Callable;

public final class OnSubscribeFromCallable<T>
  implements Observable.OnSubscribe<T>
{
  private final Callable<? extends T> resultFactory;
  
  public OnSubscribeFromCallable(Callable<? extends T> paramCallable)
  {
    this.resultFactory = paramCallable;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OnSubscribeFromCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */