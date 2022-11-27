package io.reactivex.internal.fuseable;

public abstract interface SimpleQueue<T>
{
  public abstract void clear();
  
  public abstract boolean isEmpty();
  
  public abstract boolean offer(T paramT);
  
  public abstract boolean offer(T paramT1, T paramT2);
  
  public abstract T poll()
    throws Exception;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\fuseable\SimpleQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */