package com.huawei.hms.support.api.entity.auth;

import android.text.TextUtils;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;
import java.util.List;

public class AuthorizationInfo
  implements IMessageEntity
{
  @a
  private String accessToken;
  @a
  private String appID;
  @a
  private String clientID;
  @a
  private String clientSecret;
  @a
  private long expiredTime;
  @a
  private String openID;
  @a
  private String refreshToken;
  @a
  private List<String> scopeList;
  
  public String getAccessToken()
  {
    return this.accessToken;
  }
  
  public String getAppID()
  {
    return this.appID;
  }
  
  public String getClientID()
  {
    return this.clientID;
  }
  
  public String getClientSecret()
  {
    return this.clientSecret;
  }
  
  public long getExpiredTime()
  {
    return this.expiredTime;
  }
  
  public String getOpenId()
  {
    return this.openID;
  }
  
  public String getRefreshToken()
  {
    return this.refreshToken;
  }
  
  public List<String> getScopeList()
  {
    return this.scopeList;
  }
  
  public boolean isTokenExpire()
  {
    return false;
  }
  
  public boolean isValid()
  {
    return TextUtils.isEmpty(this.appID);
  }
  
  public void setAccessToken(String paramString)
  {
    this.accessToken = paramString;
  }
  
  public void setAppID(String paramString)
  {
    this.appID = paramString;
  }
  
  public void setClientID(String paramString)
  {
    this.clientID = paramString;
  }
  
  public void setClientSecret(String paramString)
  {
    this.clientSecret = paramString;
  }
  
  public void setExpiredTime(long paramLong)
  {
    this.expiredTime = paramLong;
  }
  
  public void setOpenID(String paramString)
  {
    this.openID = paramString;
  }
  
  public void setRefreshToken(String paramString)
  {
    this.refreshToken = paramString;
  }
  
  public void setScopeList(List<String> paramList)
  {
    this.scopeList = paramList;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\auth\AuthorizationInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */