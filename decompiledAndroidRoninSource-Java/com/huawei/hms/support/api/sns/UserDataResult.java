package com.huawei.hms.support.api.sns;

import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.entity.sns.UserData;

public class UserDataResult
  extends Result
{
  private UserData a;
  
  public UserData getUserData()
  {
    return this.a;
  }
  
  public void setUserData(UserData paramUserData)
  {
    this.a = paramUserData;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\sns\UserDataResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */