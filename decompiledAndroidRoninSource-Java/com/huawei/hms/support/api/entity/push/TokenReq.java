package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class TokenReq
  implements IMessageEntity
{
  @a
  private boolean firstTime;
  @a
  private String packageName;
  
  public String getPackageName()
  {
    return this.packageName;
  }
  
  public boolean isFirstTime()
  {
    return this.firstTime;
  }
  
  public void setFirstTime(boolean paramBoolean)
  {
    this.firstTime = paramBoolean;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\push\TokenReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */