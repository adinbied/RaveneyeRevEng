package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class PurchaseInfoRequest
  implements IMessageEntity
{
  @a
  public String appId;
  @a
  public String merchantId;
  @a
  public long pageNo = 1L;
  @a
  public String priceType;
  @a
  public String productId;
  @a
  public String sign;
  @a
  public long ts;
  
  public String getAppId()
  {
    return this.appId;
  }
  
  public String getMerchantId()
  {
    return this.merchantId;
  }
  
  public long getPageNo()
  {
    return this.pageNo;
  }
  
  public String getPriceType()
  {
    return this.priceType;
  }
  
  public String getProductId()
  {
    return this.productId;
  }
  
  public String getSign()
  {
    return this.sign;
  }
  
  public long getTs()
  {
    return this.ts;
  }
  
  public void setAppId(String paramString)
  {
    this.appId = paramString;
  }
  
  public void setMerchantId(String paramString)
  {
    this.merchantId = paramString;
  }
  
  public void setPageNo(long paramLong)
  {
    this.pageNo = paramLong;
  }
  
  public void setPriceType(String paramString)
  {
    this.priceType = paramString;
  }
  
  public void setProductId(String paramString)
  {
    this.productId = paramString;
  }
  
  public void setSign(String paramString)
  {
    this.sign = paramString;
  }
  
  public void setTs(long paramLong)
  {
    this.ts = paramLong;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\pay\PurchaseInfoRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */