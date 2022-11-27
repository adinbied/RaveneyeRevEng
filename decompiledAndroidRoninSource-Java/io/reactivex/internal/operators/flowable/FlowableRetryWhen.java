package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.processors.FlowableProcessor;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRetryWhen<T>
  extends AbstractFlowableWithUpstream<T, T>
{
  final Function<? super Flowable<Throwable>, ? extends Publisher<?>> handler;
  
  public FlowableRetryWhen(Flowable<T> paramFlowable, Function<? super Flowable<Throwable>, ? extends Publisher<?>> paramFunction)
  {
    super(paramFlowable);
    this.handler = paramFunction;
  }
  
  /* Error */
  public void subscribeActual(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  static final class RetryWhenSubscriber<T>
    extends FlowableRepeatWhen.WhenSourceSubscriber<T, Throwable>
  {
    private static final long serialVersionUID = -2680129890138081029L;
    
    RetryWhenSubscriber(Subscriber<? super T> paramSubscriber, FlowableProcessor<Throwable> paramFlowableProcessor, Subscription paramSubscription)
    {
      super(paramFlowableProcessor, paramSubscription);
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onError(Throwable paramThrowable)
    {
      again(paramThrowable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableRetryWhen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */