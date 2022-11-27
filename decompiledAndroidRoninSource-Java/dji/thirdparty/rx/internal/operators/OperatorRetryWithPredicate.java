package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Scheduler.Worker;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.functions.Func2;
import dji.thirdparty.rx.internal.producers.ProducerArbiter;
import dji.thirdparty.rx.subscriptions.SerialSubscription;
import java.util.concurrent.atomic.AtomicInteger;

public final class OperatorRetryWithPredicate<T>
  implements Observable.Operator<T, Observable<T>>
{
  final Func2<Integer, Throwable, Boolean> predicate;
  
  public OperatorRetryWithPredicate(Func2<Integer, Throwable, Boolean> paramFunc2)
  {
    this.predicate = paramFunc2;
  }
  
  public Subscriber<? super Observable<T>> call(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
  
  static final class SourceSubscriber<T>
    extends Subscriber<Observable<T>>
  {
    final AtomicInteger attempts = new AtomicInteger();
    final Subscriber<? super T> child;
    final Scheduler.Worker inner;
    final ProducerArbiter pa;
    final Func2<Integer, Throwable, Boolean> predicate;
    final SerialSubscription serialSubscription;
    
    public SourceSubscriber(Subscriber<? super T> paramSubscriber, Func2<Integer, Throwable, Boolean> paramFunc2, Scheduler.Worker paramWorker, SerialSubscription paramSerialSubscription, ProducerArbiter paramProducerArbiter)
    {
      this.child = paramSubscriber;
      this.predicate = paramFunc2;
      this.inner = paramWorker;
      this.serialSubscription = paramSerialSubscription;
      this.pa = paramProducerArbiter;
    }
    
    public void onCompleted() {}
    
    public void onError(Throwable paramThrowable)
    {
      this.child.onError(paramThrowable);
    }
    
    /* Error */
    public void onNext(Observable<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorRetryWithPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */