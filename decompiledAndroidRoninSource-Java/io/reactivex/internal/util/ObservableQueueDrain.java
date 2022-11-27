package io.reactivex.internal.util;

import io.reactivex.Observer;

public abstract interface ObservableQueueDrain<T, U>
{
  public abstract void accept(Observer<? super U> paramObserver, T paramT);
  
  public abstract boolean cancelled();
  
  public abstract boolean done();
  
  public abstract boolean enter();
  
  public abstract Throwable error();
  
  public abstract int leave(int paramInt);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\interna\\util\ObservableQueueDrain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */