package com.ronin.connect.wificonnect.bean;

public class ConnectWiFiInfo
{
  private final boolean addWifiConfigurationSuccess;
  private final boolean enableNetworkSuccess;
  private final boolean reconnectSuccess;
  
  public ConnectWiFiInfo(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.addWifiConfigurationSuccess = paramBoolean1;
    this.enableNetworkSuccess = paramBoolean2;
    this.reconnectSuccess = paramBoolean3;
  }
  
  public boolean connectDeviceSuccess()
  {
    return false;
  }
  
  public boolean wifiConfigurationBelongOtherAPP()
  {
    return this.addWifiConfigurationSuccess ^ true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\ronin\connect\wificonnect\bean\ConnectWiFiInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */