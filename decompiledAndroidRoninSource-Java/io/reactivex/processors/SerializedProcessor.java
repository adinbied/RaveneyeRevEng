package io.reactivex.processors;

import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import org.reactivestreams.Subscriber;

final class SerializedProcessor<T>
  extends FlowableProcessor<T>
{
  final FlowableProcessor<T> actual;
  volatile boolean done;
  boolean emitting;
  AppendOnlyLinkedArrayList<Object> queue;
  
  SerializedProcessor(FlowableProcessor<T> paramFlowableProcessor)
  {
    this.actual = paramFlowableProcessor;
  }
  
  /* Error */
  void emitLoop()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public Throwable getThrowable()
  {
    return this.actual.getThrowable();
  }
  
  public boolean hasComplete()
  {
    return this.actual.hasComplete();
  }
  
  public boolean hasSubscribers()
  {
    return this.actual.hasSubscribers();
  }
  
  public boolean hasThrowable()
  {
    return this.actual.hasThrowable();
  }
  
  /* Error */
  public void onComplete()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void onError(Throwable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
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
  public void onSubscribe(org.reactivestreams.Subscription arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  protected void subscribeActual(Subscriber<? super T> paramSubscriber)
  {
    this.actual.subscribe(paramSubscriber);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\processors\SerializedProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */