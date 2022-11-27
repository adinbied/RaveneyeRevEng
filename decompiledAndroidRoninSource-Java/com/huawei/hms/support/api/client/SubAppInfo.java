package com.huawei.hms.support.api.client;

public class SubAppInfo
{
  private String a;
  
  public SubAppInfo(SubAppInfo paramSubAppInfo)
  {
    if (paramSubAppInfo != null) {
      this.a = paramSubAppInfo.getSubAppID();
    }
  }
  
  public SubAppInfo(String paramString)
  {
    this.a = paramString;
  }
  
  public String getSubAppID()
  {
    return this.a;
  }
  
  public void setSubAppID(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\client\SubAppInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */