package com.huawei.appmarket.component.buoycircle.impl.manager;

import android.content.Context;
import com.huawei.appmarket.component.buoycircle.api.AppInfo;
import com.huawei.appmarket.component.buoycircle.api.IBuoyBIHandler;
import com.huawei.appmarket.component.buoycircle.api.IBuoyCircleControl;
import com.huawei.appmarket.component.buoycircle.api.ISwitchGameAccountCallBack;
import com.huawei.appmarket.component.buoycircle.impl.bi.BuoyAnalyticHelper;
import com.huawei.hmf.annotation.ApiDefine;
import com.huawei.hmf.annotation.Singleton;

@ApiDefine(uri=IBuoyCircleControl.class)
@Singleton
public class BuoyCircleManager
  implements IBuoyCircleControl
{
  private static BuoyCircleManager instance;
  
  public static BuoyCircleManager getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new BuoyCircleManager();
      }
      BuoyCircleManager localBuoyCircleManager = instance;
      return localBuoyCircleManager;
    }
    finally {}
  }
  
  /* Error */
  public void createBuoyCircle(Context arg1, AppInfo arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void createBuoyCircle(Context paramContext, AppInfo paramAppInfo, int paramInt)
  {
    FloatWindowManager.getInstance().createSmallWindow(paramContext, paramAppInfo, paramInt);
  }
  
  public int getBuoyHideMode(Context paramContext, String paramString1, String paramString2)
  {
    return 0;
  }
  
  public void performDestroy()
  {
    FloatWindowManager.getInstance().performDestroy();
  }
  
  public void removeBuoyCircle()
  {
    FloatWindowManager.getInstance().removeSmallWindow();
  }
  
  public void setBuoyBIHandler(IBuoyBIHandler paramIBuoyBIHandler)
  {
    BuoyAnalyticHelper.getInstance().init(paramIBuoyBIHandler);
  }
  
  public void setSwitchGameAccountCallBack(ISwitchGameAccountCallBack paramISwitchGameAccountCallBack)
  {
    FloatWindowManager.getInstance().setSwitchGameAccountCallBack(paramISwitchGameAccountCallBack);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\impl\manager\BuoyCircleManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */