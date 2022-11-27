package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class ProductDetail
  implements IMessageEntity
{
  @a
  public String country;
  @a
  public String currency;
  @a
  public long microsPrice;
  @a
  public String price;
  @a
  public String productDesc;
  @a
  public String productName;
  @a
  public String productNo;
  
  public String getCountry()
  {
    return this.country;
  }
  
  public String getCurrency()
  {
    return this.currency;
  }
  
  public long getMicrosPrice()
  {
    return this.microsPrice;
  }
  
  public String getPrice()
  {
    return this.price;
  }
  
  public String getProductDesc()
  {
    return this.productDesc;
  }
  
  public String getProductName()
  {
    return this.productName;
  }
  
  public String getProductNo()
  {
    return this.productNo;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\pay\ProductDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */