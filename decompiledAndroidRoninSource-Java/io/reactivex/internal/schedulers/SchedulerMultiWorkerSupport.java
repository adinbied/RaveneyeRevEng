package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler.Worker;

public abstract interface SchedulerMultiWorkerSupport
{
  public abstract void createWorkers(int paramInt, WorkerCallback paramWorkerCallback);
  
  public static abstract interface WorkerCallback
  {
    public abstract void onWorker(int paramInt, Scheduler.Worker paramWorker);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\schedulers\SchedulerMultiWorkerSupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */