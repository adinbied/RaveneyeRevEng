package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Notification;
import io.reactivex.functions.Function;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDematerialize<T, R>
  extends AbstractFlowableWithUpstream<T, R>
{
  final Function<? super T, ? extends Notification<R>> selector;
  
  public FlowableDematerialize(Flowable<T> paramFlowable, Function<? super T, ? extends Notification<R>> paramFunction)
  {
    super(paramFlowable);
    this.selector = paramFunction;
  }
  
  /* Error */
  protected void subscribeActual(Subscriber<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class DematerializeSubscriber<T, R>
    implements FlowableSubscriber<T>, Subscription
  {
    boolean done;
    final Subscriber<? super R> downstream;
    final Function<? super T, ? extends Notification<R>> selector;
    Subscription upstream;
    
    DematerializeSubscriber(Subscriber<? super R> paramSubscriber, Function<? super T, ? extends Notification<R>> paramFunction)
    {
      this.downstream = paramSubscriber;
      this.selector = paramFunction;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableDematerialize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */