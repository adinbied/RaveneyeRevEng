package com.huawei.appmarket.component.buoycircle.impl.manager;

import android.content.Context;
import com.huawei.appmarket.component.buoycircle.api.AppInfo;
import com.huawei.appmarket.component.buoycircle.impl.storage.GamePreferences;
import com.huawei.appmarket.component.buoycircle.impl.utils.PackageManagerHelper;

public class BuoyHideCacheManager
{
  public static final int DEFAULY_HIDE_MODE = 1;
  private static final String FILE_NAME_HIDE_EVENT = "buoyHideEvent";
  public static final int HAND_HIDE_MODE = 2;
  private static final String HIDE_APP_MODE_KEY = "hide_mode_key";
  private static final String HIDE_APP_PID_KEY = "hide_pid_key";
  public static final int NOT_HIDE_MODE = 0;
  private static final String TAG = "BuoyHideCacheManager";
  private static BuoyHideCacheManager instance;
  private GamePreferences gamePreference;
  
  private String getBuoyHideKey(AppInfo paramAppInfo)
  {
    return null;
  }
  
  private GamePreferences getGamePreference(Context paramContext)
  {
    return null;
  }
  
  public static BuoyHideCacheManager getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new BuoyHideCacheManager();
      }
      BuoyHideCacheManager localBuoyHideCacheManager = instance;
      return localBuoyHideCacheManager;
    }
    finally {}
  }
  
  private int getPid(Context paramContext, String paramString)
  {
    return PackageManagerHelper.getPid(paramContext, paramString);
  }
  
  public void clear(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    getGamePreference(paramContext).clear();
  }
  
  public int getBuoyHideMode(Context paramContext, String paramString1, String paramString2)
  {
    return 0;
  }
  
  public boolean isAppHideBuoy(Context paramContext, AppInfo paramAppInfo)
  {
    return false;
  }
  
  public boolean isAppRelaunch(Context paramContext, AppInfo paramAppInfo)
  {
    return false;
  }
  
  /* Error */
  public void removeHideBuoyEvent(Context arg1, AppInfo arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void saveHideBuoyEvent(Context arg1, AppInfo arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\impl\manager\BuoyHideCacheManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */