package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class EnableNotifyReq
  implements IMessageEntity
{
  @a
  private boolean enable;
  @a
  private String packageName;
  
  public String getPackageName()
  {
    return this.packageName;
  }
  
  public boolean isEnable()
  {
    return this.enable;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
  
  public void setPackageName(String paramString)
  {
    this.packageName = paramString;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\push\EnableNotifyReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */