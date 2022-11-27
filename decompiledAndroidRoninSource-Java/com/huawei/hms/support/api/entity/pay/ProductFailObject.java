package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class ProductFailObject
  implements IMessageEntity
{
  @a
  public int code;
  @a
  public String msg;
  @a
  public String productNo;
  
  public int getCode()
  {
    return this.code;
  }
  
  public String getMsg()
  {
    return this.msg;
  }
  
  public String getProductNo()
  {
    return this.productNo;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\pay\ProductFailObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */