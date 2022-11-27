package dji.sdksharedlib.hardware.extension;

import dji.common.error.DJIError;

public abstract interface DJISDKCacheCommonMergeCallback
{
  public abstract void onFailure(DJIError paramDJIError);
  
  public abstract void onSuccess(Object paramObject);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\extension\DJISDKCacheCommonMergeCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */