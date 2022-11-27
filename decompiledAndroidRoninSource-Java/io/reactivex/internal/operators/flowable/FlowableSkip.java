package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSkip<T>
  extends AbstractFlowableWithUpstream<T, T>
{
  final long n;
  
  public FlowableSkip(Flowable<T> paramFlowable, long paramLong)
  {
    super(paramFlowable);
    this.n = paramLong;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class SkipSubscriber<T>
    implements FlowableSubscriber<T>, Subscription
  {
    final Subscriber<? super T> downstream;
    long remaining;
    Subscription upstream;
    
    SkipSubscriber(Subscriber<? super T> paramSubscriber, long paramLong)
    {
      this.downstream = paramSubscriber;
      this.remaining = paramLong;
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
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableSkip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */