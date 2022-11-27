package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.internal.producers.ProducerArbiter;
import dji.thirdparty.rx.subscriptions.SerialSubscription;

public final class OperatorSwitchIfEmpty<T>
  implements Observable.Operator<T, T>
{
  private final Observable<? extends T> alternate;
  
  public OperatorSwitchIfEmpty(Observable<? extends T> paramObservable)
  {
    this.alternate = paramObservable;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
  
  private static final class AlternateSubscriber<T>
    extends Subscriber<T>
  {
    private final ProducerArbiter arbiter;
    private final Subscriber<? super T> child;
    
    AlternateSubscriber(Subscriber<? super T> paramSubscriber, ProducerArbiter paramProducerArbiter)
    {
      this.child = paramSubscriber;
      this.arbiter = paramProducerArbiter;
    }
    
    public void onCompleted()
    {
      this.child.onCompleted();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.child.onError(paramThrowable);
    }
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void setProducer(Producer paramProducer)
    {
      this.arbiter.setProducer(paramProducer);
    }
  }
  
  private static final class ParentSubscriber<T>
    extends Subscriber<T>
  {
    private final Observable<? extends T> alternate;
    private final ProducerArbiter arbiter;
    private final Subscriber<? super T> child;
    private boolean empty = true;
    private final SerialSubscription ssub;
    
    ParentSubscriber(Subscriber<? super T> paramSubscriber, SerialSubscription paramSerialSubscription, ProducerArbiter paramProducerArbiter, Observable<? extends T> paramObservable)
    {
      this.child = paramSubscriber;
      this.ssub = paramSerialSubscription;
      this.arbiter = paramProducerArbiter;
      this.alternate = paramObservable;
    }
    
    /* Error */
    private void subscribeToAlternate()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onCompleted()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.child.onError(paramThrowable);
    }
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void setProducer(Producer paramProducer)
    {
      this.arbiter.setProducer(paramProducer);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorSwitchIfEmpty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */