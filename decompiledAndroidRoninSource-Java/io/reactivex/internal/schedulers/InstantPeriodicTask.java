package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

final class InstantPeriodicTask
  implements Callable<Void>, Disposable
{
  static final FutureTask<Void> CANCELLED = new FutureTask(Functions.EMPTY_RUNNABLE, null);
  final ExecutorService executor;
  final AtomicReference<Future<?>> first;
  final AtomicReference<Future<?>> rest;
  Thread runner;
  final Runnable task;
  
  InstantPeriodicTask(Runnable paramRunnable, ExecutorService paramExecutorService)
  {
    this.task = paramRunnable;
    this.first = new AtomicReference();
    this.rest = new AtomicReference();
    this.executor = paramExecutorService;
  }
  
  public Void call()
    throws Exception
  {
    return null;
  }
  
  /* Error */
  public void dispose()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isDisposed()
  {
    return false;
  }
  
  /* Error */
  void setFirst(Future<?> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void setRest(Future<?> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\schedulers\InstantPeriodicTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */