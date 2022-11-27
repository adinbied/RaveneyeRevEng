package com.huawei.hms.support.api.entity.sns.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;
import com.huawei.hms.support.api.entity.sns.UserData;

public class UserDataResp
  implements IMessageEntity
{
  @a
  UserData userData;
  
  public UserData getUserData()
  {
    return this.userData;
  }
  
  public void setUserData(UserData paramUserData)
  {
    this.userData = paramUserData;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\sns\internal\UserDataResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */