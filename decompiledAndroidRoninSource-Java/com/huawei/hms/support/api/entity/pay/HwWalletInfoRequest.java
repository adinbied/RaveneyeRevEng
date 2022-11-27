package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class HwWalletInfoRequest
  implements IMessageEntity
{
  @a
  public String merchantId;
  @a
  public String queryFlag;
  
  private static <T> T get(T paramT)
  {
    return paramT;
  }
  
  public String getMerchantId()
  {
    return null;
  }
  
  public String getQueryFlag()
  {
    return null;
  }
  
  public void setMerchantId(String paramString)
  {
    this.merchantId = paramString;
  }
  
  public void setQueryFlag(String paramString)
  {
    this.queryFlag = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\pay\HwWalletInfoRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */