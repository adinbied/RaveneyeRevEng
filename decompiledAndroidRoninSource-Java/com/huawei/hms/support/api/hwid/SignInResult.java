package com.huawei.hms.support.api.hwid;

import android.content.Intent;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;

public class SignInResult
  extends Result
{
  private SignInHuaweiId a;
  private Intent b;
  
  public SignInResult() {}
  
  public SignInResult(Status paramStatus)
  {
    setStatus(paramStatus);
  }
  
  public Intent getData()
  {
    return this.b;
  }
  
  public SignInHuaweiId getSignInHuaweiId()
  {
    return this.a;
  }
  
  public boolean isSuccess()
  {
    return false;
  }
  
  public void setData(Intent paramIntent)
  {
    this.b = paramIntent;
  }
  
  public void setSignInHuaweiId(SignInHuaweiId paramSignInHuaweiId)
  {
    this.a = paramSignInHuaweiId;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\hwid\SignInResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */