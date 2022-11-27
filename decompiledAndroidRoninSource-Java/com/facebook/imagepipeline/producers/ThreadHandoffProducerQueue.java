package com.facebook.imagepipeline.producers;

public abstract interface ThreadHandoffProducerQueue
{
  public abstract void addToQueueOrExecute(Runnable paramRunnable);
  
  public abstract boolean isQueueing();
  
  public abstract void remove(Runnable paramRunnable);
  
  public abstract void startQueueing();
  
  public abstract void stopQueuing();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\ThreadHandoffProducerQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */