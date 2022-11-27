package com.tencent.mmkv;

public enum MMKVLogLevel
{
  static
  {
    LevelError = new MMKVLogLevel("LevelError", 3);
    MMKVLogLevel localMMKVLogLevel = new MMKVLogLevel("LevelNone", 4);
    LevelNone = localMMKVLogLevel;
    $VALUES = new MMKVLogLevel[] { LevelDebug, LevelInfo, LevelWarning, LevelError, localMMKVLogLevel };
  }
  
  private MMKVLogLevel() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\mmkv\MMKVLogLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */