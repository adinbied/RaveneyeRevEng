package dji.sdksharedlib.listener;

import dji.common.error.DJIError;
import dji.sdksharedlib.store.DJISDKCacheParamValue;

public abstract interface DJIGetCallback
{
  public abstract void onFails(DJIError paramDJIError);
  
  public abstract void onSuccess(DJISDKCacheParamValue paramDJISDKCacheParamValue);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\listener\DJIGetCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */