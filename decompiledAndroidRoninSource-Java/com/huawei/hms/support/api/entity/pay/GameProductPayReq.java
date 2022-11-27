package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.a.a;

public class GameProductPayReq
  extends ProductPayRequest
{
  @a
  public String channelId;
  @a
  public String cpId;
  @a
  public String sdkVersionName;
  
  public GameProductPayReq() {}
  
  public GameProductPayReq(ProductPayRequest paramProductPayRequest, String paramString)
  {
    this.sdkVersionName = "2.6.3.301";
    this.cpId = paramString;
    this.expireTime = paramProductPayRequest.expireTime;
    this.validTime = paramProductPayRequest.validTime;
    this.applicationID = paramProductPayRequest.applicationID;
    this.extReserved = paramProductPayRequest.extReserved;
    this.merchantId = paramProductPayRequest.merchantId;
    this.merchantName = paramProductPayRequest.merchantName;
    this.requestId = paramProductPayRequest.requestId;
    this.sdkChannel = paramProductPayRequest.sdkChannel;
    this.serviceCatalog = paramProductPayRequest.serviceCatalog;
    this.sign = paramProductPayRequest.sign;
    this.url = paramProductPayRequest.url;
    this.urlVer = paramProductPayRequest.urlVer;
    this.productNo = paramProductPayRequest.productNo;
  }
  
  public String getChannelId()
  {
    return this.channelId;
  }
  
  public String getCpID()
  {
    return this.cpId;
  }
  
  public String getSdkVersionName()
  {
    return this.sdkVersionName;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\pay\GameProductPayReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */