package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class DeleteTokenReq
  implements IMessageEntity
{
  @a
  private String pkgName;
  @a
  private String token;
  
  public String getPkgName()
  {
    return this.pkgName;
  }
  
  public String getToken()
  {
    return this.token;
  }
  
  public void setPkgName(String paramString)
  {
    this.pkgName = paramString;
  }
  
  public void setToken(String paramString)
  {
    this.token = paramString;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\push\DeleteTokenReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */