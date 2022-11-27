package dji.internal.mock;

import dji.sdksharedlib.DJISDKCache;

public class MockDJISDKCache
  extends DJISDKCache
{
  private static final String TAG = "MockDJISDKCache";
  
  public static MockDJISDKCache getInstance()
  {
    return SingletonHolder.instance;
  }
  
  /* Error */
  public void init()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void notifyFakeComponentChanged()
  {
    ((MockDJISDKCacheHWAbstractionLayer)this.halLayer).notifyFakeComponentChanged();
  }
  
  private static class SingletonHolder
  {
    private static MockDJISDKCache instance = new MockDJISDKCache(null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mock\MockDJISDKCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */