package com.huawei.appmarket.component.buoycircle.impl.update.download;

import android.content.Context;

class DownloadRecord
{
  private static final String SP_NAME = "com.huawei.hms.update.DOWNLOAD_RECORD";
  private String mHash;
  private int mReceived;
  private int mSize;
  private String mUri;
  
  /* Error */
  private void save(Context arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  int getReceived()
  {
    return this.mReceived;
  }
  
  public int getSize()
  {
    return this.mSize;
  }
  
  public void init(String paramString1, int paramInt, String paramString2)
  {
    this.mUri = paramString1;
    this.mSize = paramInt;
    this.mHash = paramString2;
    this.mReceived = 0;
  }
  
  public boolean isValid(String paramString1, int paramInt, String paramString2)
  {
    return false;
  }
  
  /* Error */
  public void load(Context arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void update(Context paramContext, int paramInt, String paramString)
  {
    this.mReceived = paramInt;
    save(paramContext, paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\update\download\DownloadRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */