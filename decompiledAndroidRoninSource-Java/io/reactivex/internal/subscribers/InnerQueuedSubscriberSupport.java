package io.reactivex.internal.subscribers;

public abstract interface InnerQueuedSubscriberSupport<T>
{
  public abstract void drain();
  
  public abstract void innerComplete(InnerQueuedSubscriber<T> paramInnerQueuedSubscriber);
  
  public abstract void innerError(InnerQueuedSubscriber<T> paramInnerQueuedSubscriber, Throwable paramThrowable);
  
  public abstract void innerNext(InnerQueuedSubscriber<T> paramInnerQueuedSubscriber, T paramT);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\subscribers\InnerQueuedSubscriberSupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */