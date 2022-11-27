package com.xiaomi.push.service.module;

@Deprecated
public enum PushChannelRegion
{
  static
  {
    Europe = new PushChannelRegion("Europe", 2);
    Russia = new PushChannelRegion("Russia", 3);
    PushChannelRegion localPushChannelRegion = new PushChannelRegion("India", 4);
    India = localPushChannelRegion;
    $VALUES = new PushChannelRegion[] { China, Global, Europe, Russia, localPushChannelRegion };
  }
  
  private PushChannelRegion() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\module\PushChannelRegion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */