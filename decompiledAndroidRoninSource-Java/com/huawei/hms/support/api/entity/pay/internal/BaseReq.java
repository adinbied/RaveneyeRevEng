package com.huawei.hms.support.api.entity.pay.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class BaseReq
  implements IMessageEntity
{
  @a
  public String applicationID;
  @a
  public String extReserved;
  @a
  public String merchantId;
  @a
  public String merchantName;
  @a
  public String requestId;
  @a
  public String reservedInfor;
  @a
  public int sdkChannel;
  @a
  public String serviceCatalog;
  @a
  public String sign;
  @a
  public String url;
  @a
  public String urlVer;
  
  public String getApplicationID()
  {
    return this.applicationID;
  }
  
  public String getExtReserved()
  {
    return this.extReserved;
  }
  
  public String getMerchantId()
  {
    return this.merchantId;
  }
  
  public String getMerchantName()
  {
    return this.merchantName;
  }
  
  public String getRequestId()
  {
    return this.requestId;
  }
  
  public String getReservedInfor()
  {
    return this.reservedInfor;
  }
  
  public int getSdkChannel()
  {
    return this.sdkChannel;
  }
  
  public String getServiceCatalog()
  {
    return this.serviceCatalog;
  }
  
  public String getSign()
  {
    return this.sign;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public String getUrlVer()
  {
    return this.urlVer;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\pay\internal\BaseReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */