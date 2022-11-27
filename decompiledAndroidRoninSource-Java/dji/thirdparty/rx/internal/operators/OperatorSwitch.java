package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.internal.producers.ProducerArbiter;
import dji.thirdparty.rx.subscriptions.SerialSubscription;
import java.util.List;

public final class OperatorSwitch<T>
  implements Observable.Operator<T, Observable<? extends T>>
{
  final boolean delayError;
  
  OperatorSwitch(boolean paramBoolean)
  {
    this.delayError = paramBoolean;
  }
  
  public static <T> OperatorSwitch<T> instance(boolean paramBoolean)
  {
    if (paramBoolean) {
      return HolderDelayError.INSTANCE;
    }
    return Holder.INSTANCE;
  }
  
  public Subscriber<? super Observable<? extends T>> call(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
  
  private static final class Holder
  {
    static final OperatorSwitch<Object> INSTANCE = new OperatorSwitch(false);
  }
  
  private static final class HolderDelayError
  {
    static final OperatorSwitch<Object> INSTANCE = new OperatorSwitch(true);
  }
  
  private static final class InnerSubscriber<T>
    extends Subscriber<T>
  {
    private final long id;
    private final OperatorSwitch.SwitchSubscriber<T> parent;
    
    InnerSubscriber(long paramLong, OperatorSwitch.SwitchSubscriber<T> paramSwitchSubscriber)
    {
      this.id = paramLong;
      this.parent = paramSwitchSubscriber;
    }
    
    public void onCompleted()
    {
      this.parent.complete(this.id);
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.parent.error(paramThrowable, this.id);
    }
    
    public void onNext(T paramT)
    {
      this.parent.emit(paramT, this.id);
    }
    
    public void setProducer(Producer paramProducer)
    {
      this.parent.arbiter.setProducer(paramProducer);
    }
  }
  
  private static final class SwitchSubscriber<T>
    extends Subscriber<Observable<? extends T>>
  {
    final ProducerArbiter arbiter;
    final Subscriber<? super T> child;
    final boolean delayError;
    boolean emitting;
    Throwable error;
    long index;
    boolean innerActive;
    boolean mainDone;
    boolean missed;
    List<T> queue;
    final SerialSubscription ssub;
    
    SwitchSubscriber(Subscriber<? super T> paramSubscriber, boolean paramBoolean)
    {
      this.child = paramSubscriber;
      this.arbiter = new ProducerArbiter();
      this.ssub = new SerialSubscription();
      this.delayError = paramBoolean;
    }
    
    /* Error */
    void complete(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: return
    }
    
    /* Error */
    void emit(T arg1, long arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void error(Throwable arg1, long arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void init()
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
    public void onNext(Observable<? extends T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void pluginError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    Throwable updateError(Throwable paramThrowable)
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorSwitch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */