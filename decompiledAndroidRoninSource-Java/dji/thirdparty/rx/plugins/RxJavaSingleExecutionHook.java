package dji.thirdparty.rx.plugins;

import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Single;
import dji.thirdparty.rx.Single.OnSubscribe;
import dji.thirdparty.rx.Subscription;

public abstract class RxJavaSingleExecutionHook
{
  public <T> Single.OnSubscribe<T> onCreate(Single.OnSubscribe<T> paramOnSubscribe)
  {
    return paramOnSubscribe;
  }
  
  public <T, R> Observable.Operator<? extends R, ? super T> onLift(Observable.Operator<? extends R, ? super T> paramOperator)
  {
    return paramOperator;
  }
  
  public <T> Throwable onSubscribeError(Throwable paramThrowable)
  {
    return paramThrowable;
  }
  
  public <T> Subscription onSubscribeReturn(Subscription paramSubscription)
  {
    return paramSubscription;
  }
  
  public <T> Observable.OnSubscribe<T> onSubscribeStart(Single<? extends T> paramSingle, Observable.OnSubscribe<T> paramOnSubscribe)
  {
    return paramOnSubscribe;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\plugins\RxJavaSingleExecutionHook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */