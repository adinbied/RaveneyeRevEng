package com.huawei.hianalytics.process;

import com.huawei.hianalytics.e.c;

public class HiAnalyticsConfig
{
  c cfgData;
  
  private HiAnalyticsConfig(Builder paramBuilder)
  {
    this.cfgData = new c();
    setDeviceConfig(paramBuilder);
    setChannel(paramBuilder.channel);
    setCollectURL(paramBuilder.collectURL);
    setMccMncEnabled(paramBuilder.isMccMncEnabled);
    setSionEnable(paramBuilder.isSessionEnabled);
    setLimitSize(paramBuilder.portLimitSize);
    setCacheExpiryTime(paramBuilder.expiryTime);
    setUUIDEnabled(paramBuilder.isUUIDEnabled);
  }
  
  HiAnalyticsConfig(HiAnalyticsConfig paramHiAnalyticsConfig)
  {
    this.cfgData = new c(paramHiAnalyticsConfig.cfgData);
  }
  
  private void setCacheExpiryTime(int paramInt)
  {
    this.cfgData.a(paramInt);
  }
  
  private void setChannel(String paramString)
  {
    this.cfgData.a(paramString);
  }
  
  private void setCollectURL(String paramString)
  {
    this.cfgData.b(paramString);
  }
  
  /* Error */
  private void setDeviceConfig(Builder arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void setLimitSize(int paramInt)
  {
    this.cfgData.b(paramInt);
  }
  
  private void setMccMncEnabled(boolean paramBoolean)
  {
    this.cfgData.b(paramBoolean);
  }
  
  private void setSionEnable(boolean paramBoolean)
  {
    this.cfgData.a(paramBoolean);
  }
  
  public void setUUIDEnabled(boolean paramBoolean)
  {
    this.cfgData.c(paramBoolean);
  }
  
  public static final class Builder
  {
    private String androidIdCustom;
    private String channel;
    private String collectURL;
    private int expiryTime = 7;
    private String imeiCustom;
    private boolean isAndroidIdEnabled;
    private boolean isImeiEnabled;
    private boolean isMccMncEnabled;
    private boolean isSNEnabled;
    private boolean isSessionEnabled;
    private boolean isUDIDEnabled;
    private boolean isUUIDEnabled = true;
    private int portLimitSize = 10;
    private String snCustom;
    private String udidCustom;
    
    public HiAnalyticsConfig build()
    {
      return null;
    }
    
    public Builder setAndroidId(String paramString)
    {
      return null;
    }
    
    public Builder setAutoReportThreshold(int paramInt)
    {
      return null;
    }
    
    public Builder setCacheExpireTime(int paramInt)
    {
      return null;
    }
    
    public Builder setChannel(String paramString)
    {
      return null;
    }
    
    public Builder setCollectURL(String paramString)
    {
      return null;
    }
    
    @Deprecated
    public Builder setEnableAndroidID(boolean paramBoolean)
    {
      return null;
    }
    
    @Deprecated
    public Builder setEnableImei(boolean paramBoolean)
    {
      return null;
    }
    
    public Builder setEnableMccMnc(boolean paramBoolean)
    {
      return null;
    }
    
    @Deprecated
    public Builder setEnableSN(boolean paramBoolean)
    {
      return null;
    }
    
    public Builder setEnableSession(boolean paramBoolean)
    {
      return null;
    }
    
    @Deprecated
    public Builder setEnableUDID(boolean paramBoolean)
    {
      return null;
    }
    
    public Builder setEnableUUID(boolean paramBoolean)
    {
      return null;
    }
    
    public Builder setImei(String paramString)
    {
      return null;
    }
    
    public Builder setSN(String paramString)
    {
      return null;
    }
    
    public Builder setUdid(String paramString)
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\process\HiAnalyticsConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */