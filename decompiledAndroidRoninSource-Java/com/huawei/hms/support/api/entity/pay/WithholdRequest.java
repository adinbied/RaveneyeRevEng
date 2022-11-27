package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.a.a;
import com.huawei.hms.support.api.entity.pay.internal.BaseReq;

public class WithholdRequest
  extends BaseReq
{
  @a
  public String amount;
  @a
  public String country;
  @a
  public String currency;
  @a
  public String productDesc;
  @a
  public String productName;
  @a
  public String tradeType;
  
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
  
  public String getProductDesc()
  {
    return this.productDesc;
  }
  
  public String getProductName()
  {
    return this.productName;
  }
  
  public String getTradeType()
  {
    return this.tradeType;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\pay\WithholdRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */