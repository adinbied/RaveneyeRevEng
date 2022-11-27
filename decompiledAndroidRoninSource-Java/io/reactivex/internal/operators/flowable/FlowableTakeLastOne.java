package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTakeLastOne<T>
  extends AbstractFlowableWithUpstream<T, T>
{
  public FlowableTakeLastOne(Flowable<T> paramFlowable)
  {
    super(paramFlowable);
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class TakeLastOneSubscriber<T>
    extends DeferredScalarSubscription<T>
    implements FlowableSubscriber<T>
  {
    private static final long serialVersionUID = -5467847744262967226L;
    Subscription upstream;
    
    TakeLastOneSubscriber(Subscriber<? super T> paramSubscriber)
    {
      super();
    }
    
    /* Error */
    public void cancel()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onNext(T paramT)
    {
      this.value = paramT;
    }
    
    /* Error */
    public void onSubscribe(Subscription arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableTakeLastOne.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */