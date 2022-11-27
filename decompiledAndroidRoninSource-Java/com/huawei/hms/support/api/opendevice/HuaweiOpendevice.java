package com.huawei.hms.support.api.opendevice;

import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions.NoOptions;

public class HuaweiOpendevice
{
  public static final HuaweiOpendeviceApi HuaweiOpendeviceApi = new HuaweiOpendeviceApiImpl();
  public static final Api<Api.ApiOptions.NoOptions> OPEN_DEVICE_API = new Api("HuaweiOpenDevice.API");
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\opendevice\HuaweiOpendevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */