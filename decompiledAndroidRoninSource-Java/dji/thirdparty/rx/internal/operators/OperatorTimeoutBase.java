package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Scheduler;
import dji.thirdparty.rx.Scheduler.Worker;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.functions.Func3;
import dji.thirdparty.rx.functions.Func4;
import dji.thirdparty.rx.internal.producers.ProducerArbiter;
import dji.thirdparty.rx.observers.SerializedSubscriber;
import dji.thirdparty.rx.subscriptions.SerialSubscription;

class OperatorTimeoutBase<T>
  implements Observable.Operator<T, T>
{
  final FirstTimeoutStub<T> firstTimeoutStub;
  final Observable<? extends T> other;
  final Scheduler scheduler;
  final TimeoutStub<T> timeoutStub;
  
  OperatorTimeoutBase(FirstTimeoutStub<T> paramFirstTimeoutStub, TimeoutStub<T> paramTimeoutStub, Observable<? extends T> paramObservable, Scheduler paramScheduler)
  {
    this.firstTimeoutStub = paramFirstTimeoutStub;
    this.timeoutStub = paramTimeoutStub;
    this.other = paramObservable;
    this.scheduler = paramScheduler;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
  
  static abstract interface FirstTimeoutStub<T>
    extends Func3<OperatorTimeoutBase.TimeoutSubscriber<T>, Long, Scheduler.Worker, Subscription>
  {}
  
  static abstract interface TimeoutStub<T>
    extends Func4<OperatorTimeoutBase.TimeoutSubscriber<T>, Long, T, Scheduler.Worker, Subscription>
  {}
  
  static final class TimeoutSubscriber<T>
    extends Subscriber<T>
  {
    long actual;
    final ProducerArbiter arbiter;
    final Scheduler.Worker inner;
    final Observable<? extends T> other;
    final SerialSubscription serial;
    final SerializedSubscriber<T> serializedSubscriber;
    boolean terminated;
    final OperatorTimeoutBase.TimeoutStub<T> timeoutStub;
    
    TimeoutSubscriber(SerializedSubscriber<T> paramSerializedSubscriber, OperatorTimeoutBase.TimeoutStub<T> paramTimeoutStub, SerialSubscription paramSerialSubscription, Observable<? extends T> paramObservable, Scheduler.Worker paramWorker)
    {
      this.serializedSubscriber = paramSerializedSubscriber;
      this.timeoutStub = paramTimeoutStub;
      this.serial = paramSerialSubscription;
      this.other = paramObservable;
      this.inner = paramWorker;
      this.arbiter = new ProducerArbiter();
    }
    
    /* Error */
    public void onCompleted()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onTimeout(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: return
    }
    
    public void setProducer(Producer paramProducer)
    {
      this.arbiter.setProducer(paramProducer);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorTimeoutBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */