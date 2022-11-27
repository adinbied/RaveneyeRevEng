package com.jakewharton.rxbinding2;

import io.reactivex.Observable;
import io.reactivex.Observer;

public abstract class InitialValueObservable<T>
  extends Observable<T>
{
  protected abstract T getInitialValue();
  
  public final Observable<T> skipInitialValue()
  {
    return new Skipped();
  }
  
  /* Error */
  protected final void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected abstract void subscribeListener(Observer<? super T> paramObserver);
  
  private final class Skipped
    extends Observable<T>
  {
    Skipped() {}
    
    protected void subscribeActual(Observer<? super T> paramObserver)
    {
      InitialValueObservable.this.subscribeListener(paramObserver);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\InitialValueObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */