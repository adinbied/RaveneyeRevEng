package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.a.a;
import java.util.List;

public class PurchaseInfoResp
  extends AbstractMessageEntity
{
  @a
  private long pageCount;
  @a
  private List<PurchaseInfo> purchaseInfoList;
  @a
  private String rtnCode;
  @a
  private String sign;
  
  public long getPageCount()
  {
    return this.pageCount;
  }
  
  public List<PurchaseInfo> getPurchaseInfoList()
  {
    return this.purchaseInfoList;
  }
  
  public String getRtnCode()
  {
    return this.rtnCode;
  }
  
  public String getSign()
  {
    return this.sign;
  }
  
  public void setPageCount(long paramLong)
  {
    this.pageCount = paramLong;
  }
  
  public void setPurchaseInfoList(List<PurchaseInfo> paramList)
  {
    this.purchaseInfoList = paramList;
  }
  
  public void setRtnCode(String paramString)
  {
    this.rtnCode = paramString;
  }
  
  public void setSign(String paramString)
  {
    this.sign = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\pay\PurchaseInfoResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */