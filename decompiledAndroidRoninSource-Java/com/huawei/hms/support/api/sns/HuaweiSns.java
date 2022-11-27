package com.huawei.hms.support.api.sns;

import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions.NoOptions;
import com.huawei.hms.support.api.entity.auth.Scope;

public final class HuaweiSns
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api("HuaweiSns.API");
  public static final HuaweiSnsApi HuaweiSnsApi;
  public static final Scope SCOPE_SNS_FRIENDS_ACCOUNT;
  public static final Scope SCOPE_SNS_READ = new Scope("https://www.huawei.com/auth/sns/read");
  public static final Scope SCOPE_SNS_WRITE = new Scope("https://www.huawei.com/auth/sns/write");
  
  static
  {
    SCOPE_SNS_FRIENDS_ACCOUNT = new Scope("https://www.huawei.com/auth/sns/friends.account");
    HuaweiSnsApi = new HuaweiSnsApiImpl();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\sns\HuaweiSns.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */