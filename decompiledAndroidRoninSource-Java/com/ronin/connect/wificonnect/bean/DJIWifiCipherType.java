package com.ronin.connect.wificonnect.bean;

public enum DJIWifiCipherType
{
  private int mValue;
  
  static
  {
    WIFICIPHER_NOPASS = new DJIWifiCipherType("WIFICIPHER_NOPASS", 2, 0);
    DJIWifiCipherType localDJIWifiCipherType = new DJIWifiCipherType("WIFICIPHER_INVALID", 3, Integer.MAX_VALUE);
    WIFICIPHER_INVALID = localDJIWifiCipherType;
    $VALUES = new DJIWifiCipherType[] { WIFICIPHER_WEP, WIFICIPHER_WPA, WIFICIPHER_NOPASS, localDJIWifiCipherType };
  }
  
  private DJIWifiCipherType(int paramInt)
  {
    this.mValue = paramInt;
  }
  
  public int getValue()
  {
    return this.mValue;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\ronin\connect\wificonnect\bean\DJIWifiCipherType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */