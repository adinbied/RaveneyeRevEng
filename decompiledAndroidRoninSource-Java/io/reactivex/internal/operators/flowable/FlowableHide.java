package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableHide<T>
  extends AbstractFlowableWithUpstream<T, T>
{
  public FlowableHide(Flowable<T> paramFlowable)
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
  
  static final class HideSubscriber<T>
    implements FlowableSubscriber<T>, Subscription
  {
    final Subscriber<? super T> downstream;
    Subscription upstream;
    
    HideSubscriber(Subscriber<? super T> paramSubscriber)
    {
      this.downstream = paramSubscriber;
    }
    
    public void cancel()
    {
      this.upstream.cancel();
    }
    
    public void onComplete()
    {
      this.downstream.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.downstream.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      this.downstream.onNext(paramT);
    }
    
    /* Error */
    public void onSubscribe(Subscription arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void request(long paramLong)
    {
      this.upstream.request(paramLong);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableHide.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */