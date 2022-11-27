package io.reactivex.internal.util;

import org.reactivestreams.Subscriber;

public abstract interface QueueDrain<T, U>
{
  public abstract boolean accept(Subscriber<? super U> paramSubscriber, T paramT);
  
  public abstract boolean cancelled();
  
  public abstract boolean done();
  
  public abstract boolean enter();
  
  public abstract Throwable error();
  
  public abstract int leave(int paramInt);
  
  public abstract long produced(long paramLong);
  
  public abstract long requested();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\interna\\util\QueueDrain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */