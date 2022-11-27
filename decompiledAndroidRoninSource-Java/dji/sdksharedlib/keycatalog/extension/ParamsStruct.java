package dji.sdksharedlib.keycatalog.extension;

import dji.sdksharedlib.hardware.abstractions.DJISDKCacheUpdateType;

public final class ParamsStruct
{
  int accessType;
  Class type;
  Class[] types;
  DJISDKCacheUpdateType updateType;
  
  public ParamsStruct(Class paramClass, Class[] paramArrayOfClass, int paramInt, DJISDKCacheUpdateType paramDJISDKCacheUpdateType)
  {
    this.type = paramClass;
    this.types = paramArrayOfClass;
    this.accessType = paramInt;
    this.updateType = paramDJISDKCacheUpdateType;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\keycatalog\extension\ParamsStruct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */