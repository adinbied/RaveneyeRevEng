package dji.sdksharedlib;

import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.sdksharedlib.listener.DJIGetCallback;
import dji.sdksharedlib.listener.DJIParamAccessListener;
import dji.sdksharedlib.listener.DJISetCallback;
import dji.sdksharedlib.store.DJISDKCacheParamValue;

public abstract interface IDJISDKCache
{
  public abstract DJISDKCacheParamValue getAvailableValue(DJISDKCacheKey paramDJISDKCacheKey);
  
  public abstract void getValue(DJISDKCacheKey paramDJISDKCacheKey, DJIGetCallback paramDJIGetCallback);
  
  public abstract void setValue(DJISDKCacheKey paramDJISDKCacheKey, Object paramObject, DJISetCallback paramDJISetCallback);
  
  public abstract boolean startListeningForUpdates(DJISDKCacheKey paramDJISDKCacheKey, DJIParamAccessListener paramDJIParamAccessListener, boolean paramBoolean);
  
  public abstract void stopListening(DJIParamAccessListener paramDJIParamAccessListener);
  
  public abstract void stopListeningOnKey(DJISDKCacheKey paramDJISDKCacheKey, DJIParamAccessListener paramDJIParamAccessListener);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\IDJISDKCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */