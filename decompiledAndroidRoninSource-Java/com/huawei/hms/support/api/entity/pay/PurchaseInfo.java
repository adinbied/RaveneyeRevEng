package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class PurchaseInfo
  implements IMessageEntity
{
  @a
  private String appId;
  @a
  private String merchantId;
  @a
  private String productId;
  @a
  private String requestId;
  @a
  private String tradeTime;
  
  public String getAppId()
  {
    return this.appId;
  }
  
  public String getMerchantId()
  {
    return this.merchantId;
  }
  
  public String getProductId()
  {
    return this.productId;
  }
  
  public String getRequestId()
  {
    return this.requestId;
  }
  
  public String getTradeTime()
  {
    return this.tradeTime;
  }
  
  public void setAppId(String paramString)
  {
    this.appId = paramString;
  }
  
  public void setMerchantId(String paramString)
  {
    this.merchantId = paramString;
  }
  
  public void setProductId(String paramString)
  {
    this.productId = paramString;
  }
  
  public void setRequestId(String paramString)
  {
    this.requestId = paramString;
  }
  
  public void setTradeTime(String paramString)
  {
    this.tradeTime = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\pay\PurchaseInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */