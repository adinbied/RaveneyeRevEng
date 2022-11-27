package dji.sdksharedlib.util.configuration;

import dji.sdksharedlib.hardware.abstractions.DJISDKCacheUpdateType;

public class DJISDKCacheProductConfigsKey
{
  public int accessMask;
  public String backupKey;
  public int dataSize;
  public Class dataType;
  public Number defaultValue;
  public String keyHashName;
  public String keyName;
  public Number maxValue;
  public int maxVersion;
  public Number minValue;
  public int minVersion;
  public DJISDKCacheUpdateType updateType;
  
  public DJISDKCacheProductConfigsKey(int paramInt1, Number paramNumber1, Number paramNumber2, Number paramNumber3, int paramInt2, DJISDKCacheUpdateType paramDJISDKCacheUpdateType, String paramString1, String paramString2, int paramInt3, int paramInt4, String paramString3, Class paramClass)
  {
    this.dataSize = paramInt1;
    this.minValue = paramNumber1;
    this.maxValue = paramNumber2;
    this.defaultValue = paramNumber3;
    this.accessMask = paramInt2;
    this.updateType = paramDJISDKCacheUpdateType;
    this.keyName = paramString1;
    this.keyHashName = paramString2;
    this.maxVersion = paramInt3;
    this.minVersion = paramInt4;
    this.backupKey = paramString3;
    this.dataType = paramClass;
  }
  
  public static class Builder
  {
    private int accessMask;
    private String backupKey;
    private int dataSize;
    private Class dataType;
    private Number defaultValue;
    private String keyHashName;
    private String keyName;
    private Number maxValue;
    private int maxVersion;
    private Number minValue;
    private int minVersion;
    private DJISDKCacheUpdateType updateType;
    
    public Builder accessMask(int paramInt)
    {
      this.accessMask = paramInt;
      return this;
    }
    
    public Builder backupKey(String paramString)
    {
      this.backupKey = paramString;
      return this;
    }
    
    public DJISDKCacheProductConfigsKey build()
    {
      return null;
    }
    
    public Builder dataSize(int paramInt)
    {
      this.dataSize = paramInt;
      return this;
    }
    
    public Builder dataType(Class paramClass)
    {
      this.dataType = paramClass;
      return this;
    }
    
    public Builder defaultValue(Number paramNumber)
    {
      this.defaultValue = paramNumber;
      return this;
    }
    
    public Builder keyHashName(String paramString)
    {
      this.keyHashName = paramString;
      return this;
    }
    
    public Builder keyName(String paramString)
    {
      this.keyName = paramString;
      return this;
    }
    
    public Builder maxValue(Number paramNumber)
    {
      this.maxValue = paramNumber;
      return this;
    }
    
    public Builder maxVersion(int paramInt)
    {
      this.maxVersion = paramInt;
      return this;
    }
    
    public Builder minValue(Number paramNumber)
    {
      this.minValue = paramNumber;
      return this;
    }
    
    public Builder minVersion(int paramInt)
    {
      this.minVersion = paramInt;
      return this;
    }
    
    public Builder updateType(DJISDKCacheUpdateType paramDJISDKCacheUpdateType)
    {
      this.updateType = paramDJISDKCacheUpdateType;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedli\\util\configuration\DJISDKCacheProductConfigsKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */