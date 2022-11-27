package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Single;
import dji.thirdparty.rx.Single.OnSubscribe;
import dji.thirdparty.rx.SingleSubscriber;
import dji.thirdparty.rx.functions.Func1;

public class SingleOperatorOnErrorResumeNext<T>
  implements Single.OnSubscribe<T>
{
  private final Single<? extends T> originalSingle;
  private final Func1<Throwable, ? extends Single<? extends T>> resumeFunctionInCaseOfError;
  
  private SingleOperatorOnErrorResumeNext(Single<? extends T> paramSingle, Func1<Throwable, ? extends Single<? extends T>> paramFunc1)
  {
    if (paramSingle != null)
    {
      if (paramFunc1 != null)
      {
        this.originalSingle = paramSingle;
        this.resumeFunctionInCaseOfError = paramFunc1;
        return;
      }
      throw new NullPointerException("resumeFunctionInCaseOfError must not be null");
    }
    throw new NullPointerException("originalSingle must not be null");
  }
  
  public static <T> SingleOperatorOnErrorResumeNext<T> withFunction(Single<? extends T> paramSingle, Func1<Throwable, ? extends Single<? extends T>> paramFunc1)
  {
    return new SingleOperatorOnErrorResumeNext(paramSingle, paramFunc1);
  }
  
  public static <T> SingleOperatorOnErrorResumeNext<T> withOther(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2)
  {
    if (paramSingle2 != null) {
      new SingleOperatorOnErrorResumeNext(paramSingle1, new Func1()
      {
        public Single<? extends T> call(Throwable paramAnonymousThrowable)
        {
          return this.val$resumeSingleInCaseOfError;
        }
      });
    }
    throw new NullPointerException("resumeSingleInCaseOfError must not be null");
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\SingleOperatorOnErrorResumeNext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */