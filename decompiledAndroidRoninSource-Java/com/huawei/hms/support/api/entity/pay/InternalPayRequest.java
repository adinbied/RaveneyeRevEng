package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class InternalPayRequest
  implements IMessageEntity
{
  @a
  public String accessToken;
  @a
  public String amount;
  @a
  public String applicationID;
  @a
  public String extReserved;
  @a
  public String notifyUrl;
  @a
  public String productDesc;
  @a
  public String productName;
  @a
  public String requestId;
  @a
  public int sdkChannel;
  @a
  public String serviceCatalog;
  @a
  public String sign;
  @a
  public String signType;
  @a
  public String urlver;
  @a
  public String userID;
  @a
  public String userName;
  @a
  public int validTime;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\pay\InternalPayRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */