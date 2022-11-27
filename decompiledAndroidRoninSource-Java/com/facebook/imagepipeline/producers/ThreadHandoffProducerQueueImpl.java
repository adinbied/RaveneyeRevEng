package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;

public class ThreadHandoffProducerQueueImpl
  implements ThreadHandoffProducerQueue
{
  private final Executor mExecutor;
  private boolean mQueueing = false;
  private final Deque<Runnable> mRunnableList;
  
  public ThreadHandoffProducerQueueImpl(Executor paramExecutor)
  {
    this.mExecutor = ((Executor)Preconditions.checkNotNull(paramExecutor));
    this.mRunnableList = new ArrayDeque();
  }
  
  private void execInQueue()
  {
    while (!this.mRunnableList.isEmpty()) {
      this.mExecutor.execute((Runnable)this.mRunnableList.pop());
    }
    this.mRunnableList.clear();
  }
  
  public void addToQueueOrExecute(Runnable paramRunnable)
  {
    try
    {
      if (this.mQueueing) {
        this.mRunnableList.add(paramRunnable);
      } else {
        this.mExecutor.execute(paramRunnable);
      }
      return;
    }
    finally {}
  }
  
  public boolean isQueueing()
  {
    try
    {
      boolean bool = this.mQueueing;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void remove(Runnable paramRunnable)
  {
    try
    {
      this.mRunnableList.remove(paramRunnable);
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
  
  public void startQueueing()
  {
    try
    {
      this.mQueueing = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void stopQueuing()
  {
    try
    {
      this.mQueueing = false;
      execInQueue();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\ThreadHandoffProducerQueueImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */