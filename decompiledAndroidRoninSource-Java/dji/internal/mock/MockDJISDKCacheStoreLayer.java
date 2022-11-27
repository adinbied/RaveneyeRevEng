package dji.internal.mock;

import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.sdksharedlib.store.DJISDKCacheParamValue;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;
import java.util.concurrent.ConcurrentHashMap;

public class MockDJISDKCacheStoreLayer
  extends DJISDKCacheStoreLayer
{
  public ConcurrentHashMap<DJISDKCacheKey, DJISDKCacheParamValue> getStores()
  {
    return stores;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\mock\MockDJISDKCacheStoreLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */