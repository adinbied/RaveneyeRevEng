package com.tencent.mmkv;

public enum MMKVRecoverStrategic
{
  static
  {
    MMKVRecoverStrategic localMMKVRecoverStrategic = new MMKVRecoverStrategic("OnErrorRecover", 1);
    OnErrorRecover = localMMKVRecoverStrategic;
    $VALUES = new MMKVRecoverStrategic[] { OnErrorDiscard, localMMKVRecoverStrategic };
  }
  
  private MMKVRecoverStrategic() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\mmkv\MMKVRecoverStrategic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */