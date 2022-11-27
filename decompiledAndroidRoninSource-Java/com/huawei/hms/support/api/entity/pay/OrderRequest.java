package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class OrderRequest
  implements IMessageEntity
{
  @a
  public String keyType;
  @a
  public String merchantId;
  @a
  public String requestId;
  @a
  public String sign;
  @a
  public String time;
  
  private static <T> T get(T paramT)
  {
    return paramT;
  }
  
  public String getKeyType()
  {
    return null;
  }
  
  public String getMerchantId()
  {
    return null;
  }
  
  public String getRequestId()
  {
    return null;
  }
  
  public String getSign()
  {
    return null;
  }
  
  public String getTime()
  {
    return null;
  }
  
  public void setKeyType(String paramString)
  {
    this.keyType = paramString;
  }
  
  public void setMerchantId(String paramString)
  {
    this.merchantId = paramString;
  }
  
  public void setRequestId(String paramString)
  {
    this.requestId = paramString;
  }
  
  public void setSign(String paramString)
  {
    this.sign = paramString;
  }
  
  public void setTime(String paramString)
  {
    this.time = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\pay\OrderRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */