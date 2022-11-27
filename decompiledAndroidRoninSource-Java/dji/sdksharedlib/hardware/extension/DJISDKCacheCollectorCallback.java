package dji.sdksharedlib.hardware.extension;

import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheKeyCharacteristics;

public class DJISDKCacheCollectorCallback
{
  public DJISDKCacheHWAbstraction.InnerCallback callback;
  public DJISDKCacheKeyCharacteristics keyCharacteristics;
  
  public DJISDKCacheCollectorCallback(DJISDKCacheKeyCharacteristics paramDJISDKCacheKeyCharacteristics, DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    this.keyCharacteristics = paramDJISDKCacheKeyCharacteristics;
    this.callback = paramInnerCallback;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\extension\DJISDKCacheCollectorCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */