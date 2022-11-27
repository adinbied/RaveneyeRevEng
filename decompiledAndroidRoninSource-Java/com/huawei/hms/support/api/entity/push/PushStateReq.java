package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class PushStateReq
  implements IMessageEntity
{
  @a
  private String pkgName;
  
  public String getPkgName()
  {
    return this.pkgName;
  }
  
  public void setPkgName(String paramString)
  {
    this.pkgName = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\push\PushStateReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */