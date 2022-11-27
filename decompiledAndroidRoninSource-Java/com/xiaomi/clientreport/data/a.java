package com.xiaomi.clientreport.data;

import com.xiaomi.push.bl;
import com.xiaomi.push.l;
import org.json.JSONObject;

public class a
{
  public String clientInterfaceId;
  private String miuiVersion = l.a();
  private String os = bl.a();
  private String pkgName;
  public int production;
  public int reportType;
  private String sdkVersion;
  
  public String getPackageName()
  {
    return this.pkgName;
  }
  
  public void setAppPackageName(String paramString)
  {
    this.pkgName = paramString;
  }
  
  public void setSdkVersion(String paramString)
  {
    this.sdkVersion = paramString;
  }
  
  public JSONObject toJson()
  {
    return null;
  }
  
  public String toJsonString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\clientreport\data\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */