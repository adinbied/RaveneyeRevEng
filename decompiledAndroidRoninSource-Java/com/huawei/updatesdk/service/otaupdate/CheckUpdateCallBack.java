package com.huawei.updatesdk.service.otaupdate;

import android.content.Intent;

public abstract interface CheckUpdateCallBack
{
  public abstract void onMarketInstallInfo(Intent paramIntent);
  
  public abstract void onMarketStoreError(int paramInt);
  
  public abstract void onUpdateInfo(Intent paramIntent);
  
  public abstract void onUpdateStoreError(int paramInt);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\service\otaupdate\CheckUpdateCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */