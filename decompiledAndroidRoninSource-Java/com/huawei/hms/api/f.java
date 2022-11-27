package com.huawei.hms.api;

import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;

class f
  implements CheckUpdateCallBack
{
  f(HuaweiApiClientImpl paramHuaweiApiClientImpl) {}
  
  /* Error */
  public void onMarketInstallInfo(android.content.Intent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onMarketStoreError(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onUpdateInfo(android.content.Intent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void onUpdateStoreError(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\api\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */