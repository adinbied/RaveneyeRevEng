package com.huawei.updatesdk.service.otaupdate;

import android.content.Intent;

public class b
{
  private static b a;
  private static final Object c = new Object();
  private CheckUpdateCallBack b;
  
  public static b a()
  {
    synchronized (c)
    {
      if (a == null) {
        a = new b();
      }
      b localb = a;
      return localb;
    }
  }
  
  public void a(int paramInt)
  {
    CheckUpdateCallBack localCheckUpdateCallBack = this.b;
    if (localCheckUpdateCallBack != null) {
      localCheckUpdateCallBack.onMarketStoreError(paramInt);
    }
  }
  
  public void a(Intent paramIntent)
  {
    CheckUpdateCallBack localCheckUpdateCallBack = this.b;
    if (localCheckUpdateCallBack != null) {
      localCheckUpdateCallBack.onMarketInstallInfo(paramIntent);
    }
  }
  
  public void a(CheckUpdateCallBack paramCheckUpdateCallBack)
  {
    this.b = paramCheckUpdateCallBack;
  }
  
  public void b(Intent paramIntent)
  {
    CheckUpdateCallBack localCheckUpdateCallBack = this.b;
    if (localCheckUpdateCallBack != null) {
      localCheckUpdateCallBack.onUpdateInfo(paramIntent);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\service\otaupdate\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */