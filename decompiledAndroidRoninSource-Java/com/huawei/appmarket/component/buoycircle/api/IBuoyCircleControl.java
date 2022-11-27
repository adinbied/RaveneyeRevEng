package com.huawei.appmarket.component.buoycircle.api;

import android.content.Context;

public abstract interface IBuoyCircleControl
{
  public static final int CREATE_FORCE_SHOW = 2;
  public static final int CREATE_HIDE_MODE = 1;
  public static final int DEFAULT = 0;
  
  public abstract void createBuoyCircle(Context paramContext, AppInfo paramAppInfo);
  
  public abstract void createBuoyCircle(Context paramContext, AppInfo paramAppInfo, int paramInt);
  
  public abstract int getBuoyHideMode(Context paramContext, String paramString1, String paramString2);
  
  public abstract void performDestroy();
  
  public abstract void removeBuoyCircle();
  
  public abstract void setBuoyBIHandler(IBuoyBIHandler paramIBuoyBIHandler);
  
  public abstract void setSwitchGameAccountCallBack(ISwitchGameAccountCallBack paramISwitchGameAccountCallBack);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\api\IBuoyCircleControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */