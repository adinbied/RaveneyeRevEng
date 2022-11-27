package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.a.a;
import com.huawei.hms.support.api.entity.pay.internal.BaseReq;

public class ProductPayRequest
  extends BaseReq
{
  @a
  public String expireTime;
  @a
  public String productNo;
  @a
  public int validTime;
  
  public String getExpireTime()
  {
    return this.expireTime;
  }
  
  public String getProductNo()
  {
    return this.productNo;
  }
  
  public int getValidTime()
  {
    return this.validTime;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\pay\ProductPayRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */