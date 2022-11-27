package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import org.reactivestreams.Publisher;

abstract class AbstractFlowableWithUpstream<T, R>
  extends Flowable<R>
  implements HasUpstreamPublisher<T>
{
  protected final Flowable<T> source;
  
  AbstractFlowableWithUpstream(Flowable<T> paramFlowable)
  {
    this.source = ((Flowable)ObjectHelper.requireNonNull(paramFlowable, "source is null"));
  }
  
  public final Publisher<T> source()
  {
    return this.source;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\AbstractFlowableWithUpstream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */