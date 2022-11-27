package io.reactivex;

import org.reactivestreams.Publisher;

public abstract interface FlowableTransformer<Upstream, Downstream>
{
  public abstract Publisher<Downstream> apply(Flowable<Upstream> paramFlowable);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\FlowableTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */