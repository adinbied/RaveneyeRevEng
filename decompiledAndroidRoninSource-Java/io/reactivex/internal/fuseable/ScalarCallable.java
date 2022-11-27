package io.reactivex.internal.fuseable;

import java.util.concurrent.Callable;

public abstract interface ScalarCallable<T>
  extends Callable<T>
{
  public abstract T call();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\fuseable\ScalarCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */