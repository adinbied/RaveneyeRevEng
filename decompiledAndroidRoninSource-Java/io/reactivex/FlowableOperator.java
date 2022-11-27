package io.reactivex;

import org.reactivestreams.Subscriber;

public abstract interface FlowableOperator<Downstream, Upstream>
{
  public abstract Subscriber<? super Upstream> apply(Subscriber<? super Downstream> paramSubscriber)
    throws Exception;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\FlowableOperator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */