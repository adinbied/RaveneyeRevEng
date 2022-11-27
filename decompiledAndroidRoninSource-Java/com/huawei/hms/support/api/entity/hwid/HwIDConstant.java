package com.huawei.hms.support.api.entity.hwid;

public final class HwIDConstant
{
  public static class ACTION
  {
    public static final String HWID_SCHEME_URL = "android.intent.action.VIEW";
    public static final String STARTUP_FOR_LOGIN = "com.huawei.hwid.ACTION_START_FOR_GOTO_ACCOUNTCENTER";
    public static final String WEB_AUTH = "com.huawei.hwid.ACTION.WEBAUTH";
  }
  
  public static class LOCAL_PERMISSION
  {
    public static final String ACCESS_TOKEN = "https://www.huawei.com/auth/account/base.profile/accesstoken";
    public static final String SERVICE_AUTH_CODE = "https://www.huawei.com/auth/account/base.profile/serviceauthcode";
  }
  
  public static class PERMISSION
  {
    public static final String BASE_PROFILE = "com.huawei.android.hms.account.getBaseProfile";
    public static final String COUNTRY = "com.huawei.android.hms.account.getCountry";
    public static final String OPENID = "com.huawei.android.hms.account.getOpenID";
    public static final String UID = "com.huawei.android.hms.account.getUID";
    public static final String UNIONID = "com.huawei.android.hms.account.getUnionId";
  }
  
  public static final class RETCODE
  {
    public static final int SIGN_IN_AUTH = 2002;
    public static final int SIGN_IN_CHECK_PASSWORD = 2004;
    public static final int SIGN_IN_NETWORK_ERROR = 2005;
    public static final int SIGN_IN_PARAMS_ERROR = 2003;
    public static final int SIGN_IN_SUCCESS = 0;
    public static final int SIGN_IN_UNLOGIN = 2001;
    public static final int ST_VALID = 0;
  }
  
  public static final class RETKEY
  {
    public static final String ACCESS_TOKEN = "ACCESSTOKEN";
    public static final String COUNTRYCODE = "COUNTRY_CODE";
    public static final String DISPLAYNAME = "DISPLAY_NAME";
    public static final String GENDER = "GENDER";
    public static final String OPENID = "OPEN_ID";
    public static final String PHOTOURL = "PHOTO_URL";
    public static final String RETCODE = "RET_CODE";
    public static final String SCOPE = "SCOPE";
    public static final String SERVICEAUTHCODE = "SERVICE_AUTH_CODE";
    public static final String SERVICECOUNTRYCODE = "SERVICE_COUNTRY_CODE";
    public static final String STATUS = "STATUS";
    public static final String UNIONID = "UNION_ID";
    public static final String USERID = "USER_ID";
  }
  
  public static class Req_access_token_parm
  {
    public static final String CLIENT_ID = "client_id";
    public static final String DISPLAY_LABEL = "display";
    public static final String HMS_REDIRECT_URI = "hms://redirect_url";
    public static final String LANGUAGE_LABEL = "lang";
    public static final String PACKAGE_NAME = "packageName";
    public static final String PERMISSION_INFO_LABEL = "permission_info";
    public static final String REDIRECT_URI = "redirect_uri";
    public static final String RESPONSE_TYPE = "response_type";
    public static final String SCOPE_LABEL = "scope";
    public static final String STATE_LABEL = "state";
  }
  
  public static class SCOPE
  {
    public static final String ACCOUNT_BASEPROFILE = "https://www.huawei.com/auth/account/base.profile";
    public static final String SCOPE_ACCOUNT_COUNTRY = "https://www.huawei.com/auth/account/country";
  }
  
  public static class URI
  {
    public static final String LOGIN_BY_PASSWORD = "hwid://com.huawei.hwid/loginbypassword";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\hwid\HwIDConstant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */