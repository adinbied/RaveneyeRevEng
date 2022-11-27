package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import java.util.concurrent.Executor;

public class ExperimentalThreadHandoffProducerQueueImpl
  implements ThreadHandoffProducerQueue
{
  private final Executor mExecutor;
  
  public ExperimentalThreadHandoffProducerQueueImpl(Executor paramExecutor)
  {
    this.mExecutor = ((Executor)Preconditions.checkNotNull(paramExecutor));
  }
  
  public void addToQueueOrExecute(Runnable paramRunnable)
  {
    this.mExecutor.execute(paramRunnable);
  }
  
  public boolean isQueueing()
  {
    return false;
  }
  
  public void remove(Runnable paramRunnable) {}
  
  public void startQueueing()
  {
    throw new UnsupportedOperationException();
  }
  
  public void stopQueuing()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\ExperimentalThreadHandoffProducerQueueImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */