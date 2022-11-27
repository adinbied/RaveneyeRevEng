package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class DisposeOnCancel
  implements Future<Object>
{
  final Disposable upstream;
  
  DisposeOnCancel(Disposable paramDisposable)
  {
    this.upstream = paramDisposable;
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    this.upstream.dispose();
    return false;
  }
  
  public Object get()
    throws InterruptedException, ExecutionException
  {
    return null;
  }
  
  public Object get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    return null;
  }
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public boolean isDone()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\schedulers\DisposeOnCancel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */