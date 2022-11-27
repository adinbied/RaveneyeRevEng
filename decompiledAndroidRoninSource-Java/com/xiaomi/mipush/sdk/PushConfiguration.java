package com.xiaomi.mipush.sdk;

import com.xiaomi.push.service.module.PushChannelRegion;

public class PushConfiguration
{
  private boolean mGeoEnable;
  private boolean mOpenCOSPush;
  private boolean mOpenFCMPush;
  private boolean mOpenFTOSPush;
  private boolean mOpenHmsPush;
  private PushChannelRegion mRegion;
  
  public PushConfiguration()
  {
    this.mRegion = PushChannelRegion.China;
    this.mOpenHmsPush = false;
    this.mOpenFCMPush = false;
    this.mOpenCOSPush = false;
    this.mOpenFTOSPush = false;
  }
  
  private PushConfiguration(PushConfigurationBuilder paramPushConfigurationBuilder)
  {
    PushChannelRegion localPushChannelRegion;
    if (paramPushConfigurationBuilder.mRegion == null) {
      localPushChannelRegion = PushChannelRegion.China;
    } else {
      localPushChannelRegion = paramPushConfigurationBuilder.mRegion;
    }
    this.mRegion = localPushChannelRegion;
    this.mOpenHmsPush = paramPushConfigurationBuilder.mOpenHmsPush;
    this.mOpenFCMPush = paramPushConfigurationBuilder.mOpenFCMPush;
    this.mOpenCOSPush = paramPushConfigurationBuilder.mOpenCOSPush;
    this.mOpenFTOSPush = paramPushConfigurationBuilder.mOpenFTOSPush;
  }
  
  public boolean getOpenCOSPush()
  {
    return this.mOpenCOSPush;
  }
  
  public boolean getOpenFCMPush()
  {
    return this.mOpenFCMPush;
  }
  
  public boolean getOpenFTOSPush()
  {
    return this.mOpenFTOSPush;
  }
  
  public boolean getOpenHmsPush()
  {
    return this.mOpenHmsPush;
  }
  
  public PushChannelRegion getRegion()
  {
    return this.mRegion;
  }
  
  public void setOpenCOSPush(boolean paramBoolean)
  {
    this.mOpenCOSPush = paramBoolean;
  }
  
  public void setOpenFCMPush(boolean paramBoolean)
  {
    this.mOpenFCMPush = paramBoolean;
  }
  
  public void setOpenFTOSPush(boolean paramBoolean)
  {
    this.mOpenFTOSPush = paramBoolean;
  }
  
  public void setOpenHmsPush(boolean paramBoolean)
  {
    this.mOpenHmsPush = paramBoolean;
  }
  
  public void setRegion(PushChannelRegion paramPushChannelRegion)
  {
    this.mRegion = paramPushChannelRegion;
  }
  
  public String toString()
  {
    return null;
  }
  
  public static class PushConfigurationBuilder
  {
    private boolean mGeoEnable;
    private boolean mOpenCOSPush;
    private boolean mOpenFCMPush;
    private boolean mOpenFTOSPush;
    private boolean mOpenHmsPush;
    private PushChannelRegion mRegion;
    
    public PushConfiguration build()
    {
      return new PushConfiguration(this, null);
    }
    
    public PushConfigurationBuilder openCOSPush(boolean paramBoolean)
    {
      this.mOpenCOSPush = paramBoolean;
      return this;
    }
    
    public PushConfigurationBuilder openFCMPush(boolean paramBoolean)
    {
      this.mOpenFCMPush = paramBoolean;
      return this;
    }
    
    public PushConfigurationBuilder openFTOSPush(boolean paramBoolean)
    {
      this.mOpenFTOSPush = paramBoolean;
      return this;
    }
    
    public PushConfigurationBuilder openHmsPush(boolean paramBoolean)
    {
      this.mOpenHmsPush = paramBoolean;
      return this;
    }
    
    public PushConfigurationBuilder region(PushChannelRegion paramPushChannelRegion)
    {
      this.mRegion = paramPushChannelRegion;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\PushConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */