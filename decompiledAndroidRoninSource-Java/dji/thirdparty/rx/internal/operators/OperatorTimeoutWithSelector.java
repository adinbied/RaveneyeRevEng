package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Scheduler.Worker;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.exceptions.Exceptions;
import dji.thirdparty.rx.functions.Func0;
import dji.thirdparty.rx.functions.Func1;
import dji.thirdparty.rx.schedulers.Schedulers;
import dji.thirdparty.rx.subscriptions.Subscriptions;

public class OperatorTimeoutWithSelector<T, U, V>
  extends OperatorTimeoutBase<T>
{
  public OperatorTimeoutWithSelector(Func0<? extends Observable<U>> paramFunc0, Func1<? super T, ? extends Observable<V>> paramFunc1, Observable<? extends T> paramObservable)
  {
    super(new OperatorTimeoutBase.FirstTimeoutStub()new OperatorTimeoutBase.TimeoutStub
    {
      public Subscription call(OperatorTimeoutBase.TimeoutSubscriber<T> paramAnonymousTimeoutSubscriber, Long paramAnonymousLong, Scheduler.Worker paramAnonymousWorker)
      {
        return null;
      }
    }, new OperatorTimeoutBase.TimeoutStub()
    {
      public Subscription call(final OperatorTimeoutBase.TimeoutSubscriber<T> paramAnonymousTimeoutSubscriber, final Long paramAnonymousLong, T paramAnonymousT, Scheduler.Worker paramAnonymousWorker)
      {
        try
        {
          paramAnonymousT = (Observable)OperatorTimeoutWithSelector.this.call(paramAnonymousT);
          paramAnonymousT.unsafeSubscribe(new Subscriber()
          {
            /* Error */
            public void onCompleted()
            {
              // Byte code:
              //   0: return
              //   1: astore_1
              //   2: goto -2 -> 0
            }
            
            public void onError(Throwable paramAnonymous2Throwable)
            {
              paramAnonymousTimeoutSubscriber.onError(paramAnonymous2Throwable);
            }
            
            /* Error */
            public void onNext(V arg1)
            {
              // Byte code:
              //   0: return
              //   1: astore_1
              //   2: goto -2 -> 0
            }
          });
        }
        finally
        {
          Exceptions.throwOrReport(paramAnonymousLong, paramAnonymousTimeoutSubscriber);
        }
        return Subscriptions.unsubscribed();
      }
    }, paramObservable, Schedulers.immediate());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorTimeoutWithSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */