package io.reactivex.internal.fuseable;

import io.reactivex.FlowableSubscriber;

public abstract interface ConditionalSubscriber<T>
  extends FlowableSubscriber<T>
{
  public abstract boolean tryOnNext(T paramT);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\fuseable\ConditionalSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */