package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.BiFunction;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableScan<T>
  extends AbstractFlowableWithUpstream<T, T>
{
  final BiFunction<T, T, T> accumulator;
  
  public FlowableScan(Flowable<T> paramFlowable, BiFunction<T, T, T> paramBiFunction)
  {
    super(paramFlowable);
    this.accumulator = paramBiFunction;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ScanSubscriber<T>
    implements FlowableSubscriber<T>, Subscription
  {
    final BiFunction<T, T, T> accumulator;
    boolean done;
    final Subscriber<? super T> downstream;
    Subscription upstream;
    T value;
    
    ScanSubscriber(Subscriber<? super T> paramSubscriber, BiFunction<T, T, T> paramBiFunction)
    {
      this.downstream = paramSubscriber;
      this.accumulator = paramBiFunction;
    }
    
    public void cancel()
    {
      this.upstream.cancel();
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
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableScan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */