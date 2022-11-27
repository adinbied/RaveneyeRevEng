package com.huawei.hms.support.api.entity.auth;

import com.huawei.hms.core.aidl.a.a;

public class AuthInfoResp
  extends AbstractResp
{
  @a
  private AuthorizationInfo authInfo;
  
  public AuthorizationInfo getAuthInfo()
  {
    return this.authInfo;
  }
  
  public int getRtnCode()
  {
    return super.getRtnCode();
  }
  
  public void setAuthInfo(AuthorizationInfo paramAuthorizationInfo)
  {
    this.authInfo = paramAuthorizationInfo;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\auth\AuthInfoResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */