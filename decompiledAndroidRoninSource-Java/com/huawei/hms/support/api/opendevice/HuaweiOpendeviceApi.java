package com.huawei.hms.support.api.opendevice;

import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.support.api.client.PendingResult;

public abstract interface HuaweiOpendeviceApi
{
  public abstract PendingResult<OaidResult> getOaid(HuaweiApiClient paramHuaweiApiClient);
  
  public abstract PendingResult<OdidResult> getOdid(HuaweiApiClient paramHuaweiApiClient);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\opendevice\HuaweiOpendeviceApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */