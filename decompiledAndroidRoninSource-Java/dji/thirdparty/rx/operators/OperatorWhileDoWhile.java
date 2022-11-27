package dji.thirdparty.rx.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Observer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Func0;
import dji.thirdparty.rx.subscriptions.SerialSubscription;

public final class OperatorWhileDoWhile<T>
  implements Observable.OnSubscribe<T>
{
  final Func0<Boolean> postCondition;
  final Func0<Boolean> preCondition;
  final Observable<? extends T> source;
  
  public OperatorWhileDoWhile(Observable<? extends T> paramObservable, Func0<Boolean> paramFunc01, Func0<Boolean> paramFunc02)
  {
    this.source = paramObservable;
    this.preCondition = paramFunc01;
    this.postCondition = paramFunc02;
  }
  
  /* Error */
  public void call(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  final class SourceObserver
    implements Observer<T>
  {
    final Subscriber<? super T> actual;
    final SerialSubscription cancel;
    
    public SourceObserver(SerialSubscription paramSerialSubscription)
    {
      this.actual = paramSerialSubscription;
      SerialSubscription localSerialSubscription;
      this.cancel = localSerialSubscription;
    }
    
    /* Error */
    public void onCompleted()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.actual.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.actual.onNext(paramT);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\operators\OperatorWhileDoWhile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */