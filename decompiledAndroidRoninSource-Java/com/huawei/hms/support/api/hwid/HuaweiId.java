package com.huawei.hms.support.api.hwid;

import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.Options;
import com.huawei.hms.support.api.entity.auth.Scope;

public class HuaweiId
{
  public static final Scope HUAEWEIID_BASE_SCOPE = new Scope("https://www.huawei.com/auth/account/base.profile");
  public static final HuaweiIdApi HuaweiIdApi;
  public static final Api<HuaweiIdSignInOptions> SIGN_IN_API;
  private static final Api.Options<HuaweiIdSignInOptions> a = new a();
  
  static
  {
    HuaweiIdApi = new HuaweiIdApiImpl();
    SIGN_IN_API = new Api("HuaweiID.API", a);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\hwid\HuaweiId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */