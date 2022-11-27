package com.huawei.hms.support.api.client;

import android.os.Bundle;

public class BundleResult
{
  private int a;
  private Bundle b;
  
  public BundleResult(int paramInt, Bundle paramBundle)
  {
    this.a = paramInt;
    this.b = paramBundle;
  }
  
  public int getResultCode()
  {
    return this.a;
  }
  
  public Bundle getRspBody()
  {
    return this.b;
  }
  
  public void setResultCode(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setRspBody(Bundle paramBundle)
  {
    this.b = paramBundle;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\client\BundleResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */