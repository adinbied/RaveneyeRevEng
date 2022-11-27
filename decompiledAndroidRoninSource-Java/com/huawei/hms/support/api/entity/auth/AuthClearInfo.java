package com.huawei.hms.support.api.entity.auth;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class AuthClearInfo
  implements IMessageEntity
{
  public static final int TYPE_CLEAR_ALL = 1;
  public static final int TYPE_CLEAR_APP = 0;
  @a
  private String appID;
  @a
  private int type = 0;
  
  public String getAppID()
  {
    return this.appID;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public void setAppID(String paramString)
  {
    this.appID = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\auth\AuthClearInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */