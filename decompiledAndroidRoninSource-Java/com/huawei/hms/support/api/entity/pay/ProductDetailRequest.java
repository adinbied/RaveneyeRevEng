package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class ProductDetailRequest
  implements IMessageEntity
{
  @a
  public String applicationID;
  @a
  public String merchantId;
  @a
  public String productNos;
  @a
  public String requestId;
  
  public String getApplicationID()
  {
    return this.applicationID;
  }
  
  public String getMerchantId()
  {
    return this.merchantId;
  }
  
  public String getProductNos()
  {
    return this.productNos;
  }
  
  public String getRequestId()
  {
    return this.requestId;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\pay\ProductDetailRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */