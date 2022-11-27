package io.reactivex.processors;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.CheckReturnValue;
import org.reactivestreams.Processor;

public abstract class FlowableProcessor<T>
  extends Flowable<T>
  implements Processor<T, T>, FlowableSubscriber<T>
{
  public abstract Throwable getThrowable();
  
  public abstract boolean hasComplete();
  
  public abstract boolean hasSubscribers();
  
  public abstract boolean hasThrowable();
  
  @CheckReturnValue
  public final FlowableProcessor<T> toSerialized()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\processors\FlowableProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */