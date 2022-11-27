package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableIgnoreElements<T>
  extends AbstractFlowableWithUpstream<T, T>
{
  public FlowableIgnoreElements(Flowable<T> paramFlowable)
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
  
  static final class IgnoreElementsSubscriber<T>
    implements FlowableSubscriber<T>, QueueSubscription<T>
  {
    final Subscriber<? super T> downstream;
    Subscription upstream;
    
    IgnoreElementsSubscriber(Subscriber<? super T> paramSubscriber)
    {
      this.downstream = paramSubscriber;
    }
    
    public void cancel()
    {
      this.upstream.cancel();
    }
    
    public void clear() {}
    
    public boolean isEmpty()
    {
      return true;
    }
    
    public boolean offer(T paramT)
    {
      throw new UnsupportedOperationException("Should not be called!");
    }
    
    public boolean offer(T paramT1, T paramT2)
    {
      throw new UnsupportedOperationException("Should not be called!");
    }
    
    public void onComplete()
    {
      this.downstream.onComplete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.downstream.onError(paramThrowable);
    }
    
    public void onNext(T paramT) {}
    
    /* Error */
    public void onSubscribe(Subscription arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public T poll()
    {
      return null;
    }
    
    public void request(long paramLong) {}
    
    public int requestFusion(int paramInt)
    {
      return paramInt & 0x2;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableIgnoreElements.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */