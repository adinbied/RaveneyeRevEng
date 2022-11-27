package com.huawei.hms.support.api.pay;

import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.pay.PurchaseInfo;
import com.huawei.hms.support.api.entity.pay.PurchaseInfoResp;
import com.huawei.hms.support.log.a;
import java.util.List;

public class PurchaseInfoResult
  extends Result
{
  private static String a = "PurchaseInfoResult";
  private String b;
  private long c;
  private List<PurchaseInfo> d;
  private String e;
  
  public PurchaseInfoResult() {}
  
  public PurchaseInfoResult(PurchaseInfoResp paramPurchaseInfoResp)
  {
    int i = -1;
    if (paramPurchaseInfoResp == null)
    {
      setStatus(new Status(-1, "purchaseinfo resp is null"));
      return;
    }
    this.b = paramPurchaseInfoResp.getRtnCode();
    this.c = paramPurchaseInfoResp.getPageCount();
    this.d = paramPurchaseInfoResp.getPurchaseInfoList();
    this.e = paramPurchaseInfoResp.getSign();
    Object localObject = paramPurchaseInfoResp.getCommonStatus();
    if (localObject != null)
    {
      setStatus((Status)localObject);
      return;
    }
    localObject = null;
    if (this.b != null) {
      try
      {
        int j = Integer.parseInt(paramPurchaseInfoResp.getRtnCode());
        i = j;
        paramPurchaseInfoResp = (PurchaseInfoResp)localObject;
      }
      catch (NumberFormatException paramPurchaseInfoResp)
      {
        localObject = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getPurchaseInfo parseInt exception :");
        localStringBuilder.append(paramPurchaseInfoResp.getMessage());
        a.d((String)localObject, localStringBuilder.toString());
        paramPurchaseInfoResp = new StringBuilder();
        paramPurchaseInfoResp.append("parse purchaseinfo code exception, source code:");
        paramPurchaseInfoResp.append(this.b);
        paramPurchaseInfoResp = paramPurchaseInfoResp.toString();
      }
    } else {
      paramPurchaseInfoResp = "purchaseinfo rtnCode is null";
    }
    setStatus(new Status(i, paramPurchaseInfoResp));
  }
  
  public long getPageCount()
  {
    return this.c;
  }
  
  public List<PurchaseInfo> getPurchaseInfoList()
  {
    return this.d;
  }
  
  public String getRtnCode()
  {
    return this.b;
  }
  
  public String getSign()
  {
    return this.e;
  }
  
  public void setPageCount(long paramLong)
  {
    this.c = paramLong;
  }
  
  public void setPurchaseInfoList(List<PurchaseInfo> paramList)
  {
    this.d = paramList;
  }
  
  public void setRtnCode(String paramString)
  {
    this.b = paramString;
  }
  
  public void setSign(String paramString)
  {
    this.e = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\pay\PurchaseInfoResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */