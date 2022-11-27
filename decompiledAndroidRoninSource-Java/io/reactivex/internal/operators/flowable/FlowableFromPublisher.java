package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableFromPublisher<T>
  extends Flowable<T>
{
  final Publisher<? extends T> publisher;
  
  public FlowableFromPublisher(Publisher<? extends T> paramPublisher)
  {
    this.publisher = paramPublisher;
  }
  
  protected void subscribeActual(Subscriber<? super T> paramSubscriber)
  {
    this.publisher.subscribe(paramSubscriber);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableFromPublisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */