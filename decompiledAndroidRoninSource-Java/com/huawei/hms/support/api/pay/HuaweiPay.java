package com.huawei.hms.support.api.pay;

import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions.NoOptions;
import com.huawei.hms.support.api.entity.auth.Scope;

public class HuaweiPay
{
  public static final HuaweiPayApi HuaweiPayApi = new HuaweiPayApiImpl();
  public static final Api<Api.ApiOptions.NoOptions> PAY_API;
  public static final Scope SCOPE_IAP_QUERY_WALLETINFO = new Scope("https://www.huawei.com/auth/pay/walletinfo");
  
  static
  {
    PAY_API = new Api("HuaweiPay.API");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\pay\HuaweiPay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */