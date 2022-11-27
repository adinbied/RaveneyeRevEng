package dji.sdksharedlib.hardware.abstractions;

public class DJISDKCacheKeyCharacteristics
{
  public static final int DEFAULT_EXPIRATION_DURATION = 100;
  private static final int DEFAULT_INTERVAL = 1000;
  public static final int DEFAULT_SETTER_VAL_PROTECTION_DURATION = 500;
  private int accessTypeMask;
  public int autoGetInterval = 1000;
  private int expirationDuration;
  public String key;
  public Class[] paramTypes;
  private int protectDuration;
  public DJISDKCacheUpdateType updateType;
  public Class valueType;
  
  public DJISDKCacheKeyCharacteristics() {}
  
  public DJISDKCacheKeyCharacteristics(String paramString, int paramInt1, DJISDKCacheUpdateType paramDJISDKCacheUpdateType, int paramInt2, int paramInt3, Class... paramVarArgs)
  {
    init(paramString, paramInt1, paramDJISDKCacheUpdateType, paramInt2, paramInt3, paramVarArgs);
  }
  
  public DJISDKCacheKeyCharacteristics(String paramString, int paramInt, DJISDKCacheUpdateType paramDJISDKCacheUpdateType, Class... paramVarArgs)
  {
    init(paramString, paramInt, paramDJISDKCacheUpdateType, -1, -1, paramVarArgs);
  }
  
  private boolean checkParamTypes(Object... paramVarArgs)
  {
    return false;
  }
  
  private boolean checkValueType(Object paramObject)
  {
    return false;
  }
  
  private void init(String paramString, int paramInt1, DJISDKCacheUpdateType paramDJISDKCacheUpdateType, int paramInt2, int paramInt3, Class... paramVarArgs)
  {
    this.key = paramString;
    this.accessTypeMask = paramInt1;
    this.updateType = paramDJISDKCacheUpdateType;
    this.protectDuration = paramInt2;
    this.expirationDuration = paramInt3;
    if ((paramVarArgs != null) && (paramVarArgs.length > 1))
    {
      this.paramTypes = paramVarArgs;
      return;
    }
    if ((paramInt1 & 0x4) == 4) {
      this.autoGetInterval = 0;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      this.valueType = paramVarArgs[0];
      return;
    }
    this.valueType = null;
  }
  
  public int getAutoGetInterval()
  {
    return this.autoGetInterval;
  }
  
  public int getExpirationDuation()
  {
    return 0;
  }
  
  public int getProtectDuration()
  {
    return this.protectDuration;
  }
  
  public boolean isGettable()
  {
    return false;
  }
  
  public boolean isParamTypeCorrect(Object... paramVarArgs)
  {
    return false;
  }
  
  public boolean isPushAccessType()
  {
    return false;
  }
  
  public boolean isSettable()
  {
    return false;
  }
  
  public boolean isUserDrivenUpdateType()
  {
    return false;
  }
  
  public void setAutoGetInterval(int paramInt)
  {
    this.autoGetInterval = paramInt;
  }
  
  public static class AccessType
  {
    public static final int ACTION = 8;
    public static final int GET = 1;
    public static final int PUSH = 4;
    public static final int SET = 2;
    public static final int SUBSCRIBE = 16;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\DJISDKCacheKeyCharacteristics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */