package com.huawei.hms.support.api.pay;

import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.entity.pay.ProductDetail;
import com.huawei.hms.support.api.entity.pay.ProductFailObject;
import java.util.List;

public class ProductDetailResult
  extends Result
{
  private String a;
  private List<ProductDetail> b;
  private List<ProductFailObject> c;
  
  public List<ProductFailObject> getFailList()
  {
    return this.c;
  }
  
  public List<ProductDetail> getProductList()
  {
    return this.b;
  }
  
  public String getRequestId()
  {
    return this.a;
  }
  
  public void setFailList(List<ProductFailObject> paramList)
  {
    this.c = paramList;
  }
  
  public void setProductList(List<ProductDetail> paramList)
  {
    this.b = paramList;
  }
  
  public void setRequestId(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\pay\ProductDetailResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */