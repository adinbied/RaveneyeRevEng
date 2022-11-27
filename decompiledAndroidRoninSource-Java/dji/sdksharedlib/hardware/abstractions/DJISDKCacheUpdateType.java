package dji.sdksharedlib.hardware.abstractions;

public enum DJISDKCacheUpdateType
{
  private int value;
  
  static
  {
    DJISDKCacheUpdateType localDJISDKCacheUpdateType = new DJISDKCacheUpdateType("Unknown", 2, 255);
    Unknown = localDJISDKCacheUpdateType;
    $VALUES = new DJISDKCacheUpdateType[] { DYNAMIC, USER_DRIVEN, localDJISDKCacheUpdateType };
  }
  
  private DJISDKCacheUpdateType(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static DJISDKCacheUpdateType find(int paramInt)
  {
    DJISDKCacheUpdateType localDJISDKCacheUpdateType = Unknown;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localDJISDKCacheUpdateType;
  }
  
  public boolean _equals(int paramInt)
  {
    return this.value == paramInt;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\DJISDKCacheUpdateType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */