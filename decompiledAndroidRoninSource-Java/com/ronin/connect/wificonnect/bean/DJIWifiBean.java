package com.ronin.connect.wificonnect.bean;

import android.net.NetworkInfo.State;

public class DJIWifiBean
  implements Comparable<DJIWifiBean>
{
  private String capabilities;
  private String mBssid;
  private String mLevel;
  private NetworkInfo.State mState = NetworkInfo.State.DISCONNECTED;
  private String mWifiName = "<unknown ssid>";
  
  public int compareTo(DJIWifiBean paramDJIWifiBean)
  {
    return 0;
  }
  
  public String getBssid()
  {
    return this.mBssid;
  }
  
  public String getCapabilities()
  {
    return this.capabilities;
  }
  
  public String getLevel()
  {
    return this.mLevel;
  }
  
  public NetworkInfo.State getState()
  {
    return this.mState;
  }
  
  public String getWifiName()
  {
    return this.mWifiName;
  }
  
  public void setBssid(String paramString)
  {
    this.mBssid = paramString;
  }
  
  public void setCapabilities(String paramString)
  {
    this.capabilities = paramString;
  }
  
  public void setLevel(String paramString)
  {
    this.mLevel = paramString;
  }
  
  public void setState(NetworkInfo.State paramState)
  {
    this.mState = paramState;
  }
  
  public void setWifiName(String paramString)
  {
    this.mWifiName = paramString;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\ronin\connect\wificonnect\bean\DJIWifiBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */