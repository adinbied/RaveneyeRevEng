package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.a.a;
import com.huawei.hms.support.api.entity.pay.internal.BaseReq;

public class PayReq
  extends BaseReq
{
  @a
  public String amount;
  @a
  public String country;
  @a
  public String currency;
  @a
  public String expireTime;
  @a
  public String partnerIDs;
  @a
  public String productDesc;
  @a
  public String productName;
  @a
  public int validTime;
  
  public String getAmount()
  {
    return this.amount;
  }
  
  public String getCountry()
  {
    return this.country;
  }
  
  public String getCurrency()
  {
    return this.currency;
  }
  
  public String getExpireTime()
  {
    return this.expireTime;
  }
  
  public String getPartnerIDs()
  {
    return this.partnerIDs;
  }
  
  public String getProductDesc()
  {
    return this.productDesc;
  }
  
  public String getProductName()
  {
    return this.productName;
  }
  
  public int getValidTime()
  {
    return this.validTime;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\pay\PayReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */