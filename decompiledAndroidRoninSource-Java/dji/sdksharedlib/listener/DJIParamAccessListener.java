package dji.sdksharedlib.listener;

import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.sdksharedlib.store.DJISDKCacheParamValue;

public abstract interface DJIParamAccessListener
{
  public abstract void onValueChange(DJISDKCacheKey paramDJISDKCacheKey, DJISDKCacheParamValue paramDJISDKCacheParamValue1, DJISDKCacheParamValue paramDJISDKCacheParamValue2);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\listener\DJIParamAccessListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */