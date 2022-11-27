package com.huawei.hms.support.api.push;

import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions.NoOptions;

public class HuaweiPush
{
  public static final HuaweiPushApi HuaweiPushApi = new HuaweiPushApiImp();
  public static final Api<Api.ApiOptions.NoOptions> PUSH_API = new Api("HuaweiPush.API");
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\push\HuaweiPush.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */