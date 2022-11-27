package com.facebook.imagepipeline.memory;

public class NoOpPoolStatsTracker
  implements PoolStatsTracker
{
  private static NoOpPoolStatsTracker sInstance;
  
  public static NoOpPoolStatsTracker getInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new NoOpPoolStatsTracker();
      }
      NoOpPoolStatsTracker localNoOpPoolStatsTracker = sInstance;
      return localNoOpPoolStatsTracker;
    }
    finally {}
  }
  
  public void onAlloc(int paramInt) {}
  
  public void onFree(int paramInt) {}
  
  public void onHardCapReached() {}
  
  public void onSoftCapReached() {}
  
  public void onValueRelease(int paramInt) {}
  
  public void onValueReuse(int paramInt) {}
  
  public void setBasePool(BasePool paramBasePool) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\memory\NoOpPoolStatsTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */