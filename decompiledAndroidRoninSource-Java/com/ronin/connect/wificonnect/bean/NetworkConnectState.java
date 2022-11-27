package com.ronin.connect.wificonnect.bean;

public enum NetworkConnectState
{
  static
  {
    CANCEL = new NetworkConnectState("CANCEL", 3);
    NetworkConnectState localNetworkConnectState = new NetworkConnectState("ABNORMAL", 4);
    ABNORMAL = localNetworkConnectState;
    $VALUES = new NetworkConnectState[] { CONNECTED, DISCONNECT, ERROR, CANCEL, localNetworkConnectState };
  }
  
  private NetworkConnectState() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\ronin\connect\wificonnect\bean\NetworkConnectState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */