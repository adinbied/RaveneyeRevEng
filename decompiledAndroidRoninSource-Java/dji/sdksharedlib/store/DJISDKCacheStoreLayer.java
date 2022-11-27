package dji.sdksharedlib.store;

import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.sdksharedlib.listener.DJISDKCacheListenerLayer;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DJISDKCacheStoreLayer
{
  private static final String TAG = "DJISDKCacheStoreLayer";
  protected static ConcurrentHashMap<DJISDKCacheKey, DJISDKCacheParamValue> stores = new ConcurrentHashMap(300);
  private DJISDKCacheListenerLayer listener = null;
  private Lock lock = new ReentrantLock();
  
  public void destroy() {}
  
  public DJISDKCacheParamValue getValue(DJISDKCacheKey paramDJISDKCacheKey)
  {
    return null;
  }
  
  public List<DJISDKCacheParamValue> getValues(DJISDKCacheKey[] paramArrayOfDJISDKCacheKey)
  {
    return null;
  }
  
  public void init(DJISDKCacheListenerLayer paramDJISDKCacheListenerLayer)
  {
    this.listener = paramDJISDKCacheListenerLayer;
  }
  
  public boolean removeAllAbstractionValues(String paramString, int paramInt)
  {
    return false;
  }
  
  public boolean removeValue(DJISDKCacheKey paramDJISDKCacheKey)
  {
    return false;
  }
  
  public boolean replaceValue(DJISDKCacheParamValue paramDJISDKCacheParamValue, DJISDKCacheKey paramDJISDKCacheKey)
  {
    return false;
  }
  
  /* Error */
  public void test()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\store\DJISDKCacheStoreLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */