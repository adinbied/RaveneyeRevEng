package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Single;
import dji.thirdparty.rx.Single.OnSubscribe;
import dji.thirdparty.rx.SingleSubscriber;
import dji.thirdparty.rx.functions.FuncN;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class SingleOperatorZip
{
  public static <T, R> Single<R> zip(Single<? extends T>[] paramArrayOfSingle, final FuncN<? extends R> paramFuncN)
  {
    Single.create(new Single.OnSubscribe()
    {
      /* Error */
      public void call(SingleSubscriber<? super R> arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\SingleOperatorZip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */