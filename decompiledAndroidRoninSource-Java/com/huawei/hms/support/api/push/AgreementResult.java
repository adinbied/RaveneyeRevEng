package com.huawei.hms.support.api.push;

import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.entity.push.AgreementResp;

public class AgreementResult
  extends Result
{
  protected AgreementResp resp;
  
  public AgreementResp getAgreementRes()
  {
    return this.resp;
  }
  
  public boolean isAgree()
  {
    return false;
  }
  
  public void setAgreementRes(AgreementResp paramAgreementResp)
  {
    this.resp = paramAgreementResp;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\push\AgreementResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */