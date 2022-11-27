package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.a.a;

public class PurchaseInfoInnerRequest
  extends PurchaseInfoRequest
{
  @a
  private String hmsSdkVersionName;
  
  public PurchaseInfoInnerRequest()
  {
    this.hmsSdkVersionName = "2.6.3.301";
  }
  
  public PurchaseInfoInnerRequest(PurchaseInfoRequest paramPurchaseInfoRequest)
  {
    setSign(paramPurchaseInfoRequest.getSign());
    setTs(paramPurchaseInfoRequest.getTs());
    setPageNo(paramPurchaseInfoRequest.getPageNo());
    setPriceType(paramPurchaseInfoRequest.getPriceType());
    setAppId(paramPurchaseInfoRequest.getAppId());
    setMerchantId(paramPurchaseInfoRequest.getMerchantId());
    setProductId(paramPurchaseInfoRequest.getProductId());
    this.hmsSdkVersionName = "2.6.3.301";
  }
  
  public String getHmsSdkVersionName()
  {
    return this.hmsSdkVersionName;
  }
  
  public void setHmsSdkVersionName(String paramString)
  {
    this.hmsSdkVersionName = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\pay\PurchaseInfoInnerRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */