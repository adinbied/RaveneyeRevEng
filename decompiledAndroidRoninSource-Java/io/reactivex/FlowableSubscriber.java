package io.reactivex;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract interface FlowableSubscriber<T>
  extends Subscriber<T>
{
  public abstract void onSubscribe(Subscription paramSubscription);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\FlowableSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */