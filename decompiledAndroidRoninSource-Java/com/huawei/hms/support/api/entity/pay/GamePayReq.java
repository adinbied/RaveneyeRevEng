package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.a.a;

public class GamePayReq
  extends PayReq
{
  @a
  public String channelId;
  @a
  public String cpId;
  @a
  public String sdkVersionName;
  
  public GamePayReq() {}
  
  public GamePayReq(PayReq paramPayReq, String paramString)
  {
    this.sdkVersionName = "2.6.3.301";
    this.cpId = paramString;
    this.amount = paramPayReq.amount;
    this.country = paramPayReq.country;
    this.currency = paramPayReq.currency;
    this.expireTime = paramPayReq.expireTime;
    this.partnerIDs = paramPayReq.partnerIDs;
    this.productDesc = paramPayReq.productDesc;
    this.productName = paramPayReq.productName;
    this.validTime = paramPayReq.validTime;
    this.applicationID = paramPayReq.applicationID;
    this.merchantName = paramPayReq.merchantName;
    this.requestId = paramPayReq.requestId;
    this.extReserved = paramPayReq.extReserved;
    this.merchantId = paramPayReq.merchantId;
    this.sign = paramPayReq.sign;
    this.url = paramPayReq.url;
    this.sdkChannel = paramPayReq.sdkChannel;
    this.serviceCatalog = paramPayReq.serviceCatalog;
    this.urlVer = paramPayReq.urlVer;
    this.reservedInfor = paramPayReq.reservedInfor;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\pay\GamePayReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */