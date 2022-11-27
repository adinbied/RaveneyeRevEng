package com.huawei.hms.support.api.entity.hwid;

import android.os.Bundle;

public class SignInResp
  extends IHwIDRespEntity
{
  @Checked(permission="https://www.huawei.com/auth/account/base.profile/accesstoken", value="ACCESSTOKEN")
  private String mAccessToken;
  @Checked(permission="com.huawei.android.hms.account.getCountry", scope="https://www.huawei.com/auth/account/country", value="COUNTRY_CODE")
  private String mCountryCode;
  @Checked(permission="com.huawei.android.hms.account.getBaseProfile", scope="https://www.huawei.com/auth/account/base.profile", value="GENDER")
  private String mGender;
  @Checked(permission="com.huawei.android.hms.account.getBaseProfile", scope="https://www.huawei.com/auth/account/base.profile", value="DISPLAY_NAME")
  private String mLoginUserName;
  @Checked(permission="com.huawei.android.hms.account.getOpenID", value="OPEN_ID")
  private String mOpenId;
  @Checked("SCOPE")
  private String mScopeUri;
  @Checked(permission="https://www.huawei.com/auth/account/base.profile/serviceauthcode", value="SERVICE_AUTH_CODE")
  private String mServiceAuthCode;
  @Checked(permission="com.huawei.android.hms.account.getCountry", scope="https://www.huawei.com/auth/account/country", value="SERVICE_COUNTRY_CODE")
  private String mServiceCountryCode;
  @Checked(permission="com.huawei.android.hms.account.getUID", value="USER_ID")
  private String mUid;
  @Checked(permission="com.huawei.android.hms.account.getUnionId", value="UNION_ID")
  private String mUnionID;
  @Checked(permission="com.huawei.android.hms.account.getBaseProfile", scope="https://www.huawei.com/auth/account/base.profile", value="STATUS")
  private String mUserStatus;
  @Checked(permission="com.huawei.android.hms.account.getBaseProfile", scope="https://www.huawei.com/auth/account/base.profile", value="PHOTO_URL")
  private String photoUrl;
  
  public static SignInResp buildSignInResp(Bundle paramBundle)
  {
    SignInResp localSignInResp = new SignInResp();
    localSignInResp.mUid = paramBundle.getString("USER_ID", "");
    localSignInResp.mLoginUserName = paramBundle.getString("DISPLAY_NAME", "");
    localSignInResp.photoUrl = paramBundle.getString("PHOTO_URL", "");
    localSignInResp.mAccessToken = paramBundle.getString("ACCESSTOKEN", "");
    localSignInResp.mUserStatus = paramBundle.getString("STATUS", "");
    localSignInResp.mGender = paramBundle.getString("GENDER", "");
    localSignInResp.mScopeUri = paramBundle.getString("SCOPE", "");
    localSignInResp.mOpenId = paramBundle.getString("OPEN_ID", "");
    localSignInResp.mServiceCountryCode = paramBundle.getString("SERVICE_COUNTRY_CODE", "");
    localSignInResp.mCountryCode = paramBundle.getString("COUNTRY_CODE", "");
    localSignInResp.mServiceAuthCode = paramBundle.getString("SERVICE_AUTH_CODE", "");
    localSignInResp.mUnionID = paramBundle.getString("UNION_ID", "");
    return localSignInResp;
  }
  
  public String getAccessToken()
  {
    return this.mAccessToken;
  }
  
  public String getCountryCode()
  {
    return this.mCountryCode;
  }
  
  public String getGender()
  {
    return this.mGender;
  }
  
  public String getLoginUserName()
  {
    return this.mLoginUserName;
  }
  
  public String getOpenId()
  {
    return this.mOpenId;
  }
  
  public String getPhotoUrl()
  {
    return this.photoUrl;
  }
  
  public String getScopeUri()
  {
    return this.mScopeUri;
  }
  
  public String getServiceAuthCode()
  {
    return this.mServiceAuthCode;
  }
  
  public String getServiceCountryCode()
  {
    return this.mServiceCountryCode;
  }
  
  public String getUid()
  {
    return this.mUid;
  }
  
  public String getUserStatus()
  {
    return this.mUserStatus;
  }
  
  public String getmUnionID()
  {
    return this.mUnionID;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\hwid\SignInResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */