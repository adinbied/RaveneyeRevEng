package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import java.util.ArrayDeque;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSkipLast<T>
  extends AbstractFlowableWithUpstream<T, T>
{
  final int skip;
  
  public FlowableSkipLast(Flowable<T> paramFlowable, int paramInt)
  {
    super(paramFlowable);
    this.skip = paramInt;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class SkipLastSubscriber<T>
    extends ArrayDeque<T>
    implements FlowableSubscriber<T>, Subscription
  {
    private static final long serialVersionUID = -3807491841935125653L;
    final Subscriber<? super T> downstream;
    final int skip;
    Subscription upstream;
    
    SkipLastSubscriber(Subscriber<? super T> paramSubscriber, int paramInt)
    {
      super();
      this.downstream = paramSubscriber;
      this.skip = paramInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableSkipLast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */