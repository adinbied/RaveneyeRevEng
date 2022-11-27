package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class OrderResp
  extends AbstractMessageEntity
{
  @a
  public String orderID;
  @a
  public String orderTime;
  @a
  public String requestId;
  @a
  public int returnCode;
  @a
  public String returnDesc;
  @a
  public String sign;
  @a
  public String status;
  @a
  public String tradeTime;
  
  private static <T> T get(T paramT)
  {
    return paramT;
  }
  
  public String getOrderID()
  {
    return null;
  }
  
  public String getOrderTime()
  {
    return null;
  }
  
  public String getRequestId()
  {
    return null;
  }
  
  public int getReturnCode()
  {
    return 0;
  }
  
  public String getReturnDesc()
  {
    return null;
  }
  
  public String getSign()
  {
    return null;
  }
  
  public String getStatus()
  {
    return null;
  }
  
  public String getTradeTime()
  {
    return null;
  }
  
  public void setOrderID(String paramString)
  {
    this.orderID = paramString;
  }
  
  public void setOrderTime(String paramString)
  {
    this.orderTime = paramString;
  }
  
  public void setRequestId(String paramString)
  {
    this.requestId = paramString;
  }
  
  public void setReturnCode(int paramInt)
  {
    this.returnCode = paramInt;
  }
  
  public void setReturnDesc(String paramString)
  {
    this.returnDesc = paramString;
  }
  
  public void setSign(String paramString)
  {
    this.sign = paramString;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
  
  public void setTradeTime(String paramString)
  {
    this.tradeTime = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\pay\OrderResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */