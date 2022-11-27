package dji.internal.logics;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThrottlingManager
{
  private Map<String, Double> keyToMinElapsedTimeMap = new ConcurrentHashMap();
  private Map<String, Long> keyToTimestampMap = new ConcurrentHashMap();
  
  public static ThrottlingManager getInstance()
  {
    return LazyHolder.INSTANCE;
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void initWithFeatureFlags(dji.internal.network.DJIFeatureFlags arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean shouldTrackThisEventWithKey(String paramString)
  {
    return false;
  }
  
  private static class LazyHolder
  {
    private static final ThrottlingManager INSTANCE = new ThrottlingManager(null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\logics\ThrottlingManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */