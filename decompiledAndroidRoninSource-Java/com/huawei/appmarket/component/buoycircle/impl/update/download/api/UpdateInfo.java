package com.huawei.appmarket.component.buoycircle.impl.update.download.api;

public class UpdateInfo
{
  public String mHash = "";
  public int mNewVersionCode = 0;
  public String mPackageName = "";
  public int mSize = 0;
  public String mUri = "";
  
  public UpdateInfo() {}
  
  public UpdateInfo(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    this.mPackageName = paramString1;
    this.mNewVersionCode = paramInt1;
    this.mUri = paramString2;
    this.mSize = paramInt2;
    this.mHash = paramString3;
  }
  
  public boolean isValid()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\update\download\api\UpdateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */