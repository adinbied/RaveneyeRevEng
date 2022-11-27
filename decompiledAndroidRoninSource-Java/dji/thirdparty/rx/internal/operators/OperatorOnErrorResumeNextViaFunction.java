package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Func1;
import dji.thirdparty.rx.internal.producers.ProducerArbiter;
import dji.thirdparty.rx.subscriptions.SerialSubscription;

public final class OperatorOnErrorResumeNextViaFunction<T>
  implements Observable.Operator<T, T>
{
  final Func1<Throwable, ? extends Observable<? extends T>> resumeFunction;
  
  public OperatorOnErrorResumeNextViaFunction(Func1<Throwable, ? extends Observable<? extends T>> paramFunc1)
  {
    this.resumeFunction = paramFunc1;
  }
  
  public static <T> OperatorOnErrorResumeNextViaFunction<T> withException(Observable<? extends T> paramObservable)
  {
    new OperatorOnErrorResumeNextViaFunction(new Func1()
    {
      public Observable<? extends T> call(Throwable paramAnonymousThrowable)
      {
        return null;
      }
    });
  }
  
  public static <T> OperatorOnErrorResumeNextViaFunction<T> withOther(Observable<? extends T> paramObservable)
  {
    new OperatorOnErrorResumeNextViaFunction(new Func1()
    {
      public Observable<? extends T> call(Throwable paramAnonymousThrowable)
      {
        return this.val$other;
      }
    });
  }
  
  public static <T> OperatorOnErrorResumeNextViaFunction<T> withSingle(Func1<Throwable, ? extends T> paramFunc1)
  {
    new OperatorOnErrorResumeNextViaFunction(new Func1()
    {
      public Observable<? extends T> call(Throwable paramAnonymousThrowable)
      {
        return null;
      }
    });
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorOnErrorResumeNextViaFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */