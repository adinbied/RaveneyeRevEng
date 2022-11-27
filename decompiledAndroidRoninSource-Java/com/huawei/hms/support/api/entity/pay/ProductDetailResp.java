package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.a.a;
import java.util.List;

public class ProductDetailResp
  extends AbstractMessageEntity
{
  @a
  public String errMsg;
  @a
  public List<ProductFailObject> failList;
  @a
  public List<ProductDetail> productList;
  @a
  public String requestId;
  @a
  public int returnCode;
  
  public String getErrMsg()
  {
    return this.errMsg;
  }
  
  public List<ProductFailObject> getFailList()
  {
    return this.failList;
  }
  
  public List<ProductDetail> getProductList()
  {
    return this.productList;
  }
  
  public String getRequestId()
  {
    return this.requestId;
  }
  
  public int getReturnCode()
  {
    return this.returnCode;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\pay\ProductDetailResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */