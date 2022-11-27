package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;

public final class FlowableNever
  extends Flowable<Object>
{
  public static final Flowable<Object> INSTANCE = new FlowableNever();
  
  public void subscribeActual(Subscriber<? super Object> paramSubscriber)
  {
    paramSubscriber.onSubscribe(EmptySubscription.INSTANCE);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableNever.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */