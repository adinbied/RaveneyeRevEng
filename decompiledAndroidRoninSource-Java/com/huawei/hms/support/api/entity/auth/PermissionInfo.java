package com.huawei.hms.support.api.entity.auth;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class PermissionInfo
  implements IMessageEntity
{
  @a
  private String appID;
  @a
  private String packageName;
  @a
  private String permission;
  
  public PermissionInfo() {}
  
  public PermissionInfo(String paramString1, String paramString2, String paramString3)
  {
    this.appID = paramString1;
    this.packageName = paramString2;
    this.permission = paramString3;
  }
  
  public String getAppID()
  {
    return this.appID;
  }
  
  public String getPackageName()
  {
    return this.packageName;
  }
  
  public String getPermission()
  {
    return this.permission;
  }
  
  public void setAppID(String paramString)
  {
    this.appID = paramString;
  }
  
  public void setPackageName(String paramString)
  {
    this.packageName = paramString;
  }
  
  public void setPermission(String paramString)
  {
    this.permission = paramString;
  }
  
  public PermissionInfo setPermissionUri(String paramString)
  {
    this.permission = paramString;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\auth\PermissionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */