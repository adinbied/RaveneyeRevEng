package io.reactivex.internal.observers;

public abstract interface InnerQueuedObserverSupport<T>
{
  public abstract void drain();
  
  public abstract void innerComplete(InnerQueuedObserver<T> paramInnerQueuedObserver);
  
  public abstract void innerError(InnerQueuedObserver<T> paramInnerQueuedObserver, Throwable paramThrowable);
  
  public abstract void innerNext(InnerQueuedObserver<T> paramInnerQueuedObserver, T paramT);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\observers\InnerQueuedObserverSupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */