package com.tencent.mmkv;

public abstract interface MMKVHandler
{
  public abstract void mmkvLog(MMKVLogLevel paramMMKVLogLevel, String paramString1, int paramInt, String paramString2, String paramString3);
  
  public abstract MMKVRecoverStrategic onMMKVCRCCheckFail(String paramString);
  
  public abstract MMKVRecoverStrategic onMMKVFileLengthError(String paramString);
  
  public abstract boolean wantLogRedirecting();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\mmkv\MMKVHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */