package com.huawei.appmarket.component.buoycircle.impl.cutout;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;
import com.huawei.appmarket.component.buoycircle.impl.storage.BuoyStorage;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BuoyCutoutHelper
{
  private static final int APP_FOLLOW_SYSTEM = 0;
  private static final int APP_HIDE_NOTCH = 2;
  private static final int APP_SHOW_NOTCH = 1;
  private static final int DEFAULT = 0;
  private static final String DISPLAY_NOTCH_STATUS = "display_notch_status";
  private static final int HEIGHT_INDEX = 1;
  private static final int NOTCHCLOSE = 1;
  private static final int NOTCHOPEN = 0;
  private static final int NOTCH_INDEX = 0;
  private static final int NO_CUTOUT = 0;
  private static final String TAG = "BuoyCutoutHelper";
  private static final int WIDTH_INDEX = 0;
  private static BuoyCutoutHelper instance;
  private Map<Integer, CutoutInfo> cutoutInfoMap = new HashMap();
  
  /* Error */
  private void doFinish(Activity arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private int getCutoutHeightGoogleApi(Context paramContext, WindowInsets paramWindowInsets)
  {
    return 0;
  }
  
  private int getCutoutHeightHwApi(Context paramContext)
  {
    return getCutoutSizeHwApi(paramContext)[1];
  }
  
  private static Map<Integer, CutoutInfo> getCutoutInfoFromSP(Context paramContext)
  {
    return BuoyStorage.getInstance().getCutoutParams(paramContext);
  }
  
  private Rect getCutoutRectGoogleApi(WindowInsets paramWindowInsets)
  {
    return null;
  }
  
  private Rect getCutoutRectHwApi(Context paramContext)
  {
    return null;
  }
  
  private static int[] getCutoutSizeHwApi(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
      paramContext = (int[])paramContext.getMethod("getNotchSize", new Class[0]).invoke(paramContext, new Object[0]);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    Log.e("test", "getCutoutSizeHwApi meet exception");
    return new int[] { 0, 0 };
  }
  
  public static BuoyCutoutHelper getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new BuoyCutoutHelper();
      }
      BuoyCutoutHelper localBuoyCutoutHelper = instance;
      return localBuoyCutoutHelper;
    }
    finally {}
  }
  
  private int getSafeInsetBottom(WindowInsets paramWindowInsets)
  {
    return getSafeInsetDistance(paramWindowInsets, "getSafeInsetBottom");
  }
  
  private int getSafeInsetDistance(WindowInsets paramWindowInsets, String paramString)
  {
    paramWindowInsets = invokeMethod(paramWindowInsets, paramString);
    if ((paramWindowInsets instanceof Integer)) {
      return ((Integer)paramWindowInsets).intValue();
    }
    return 0;
  }
  
  private int getSafeInsetLeft(WindowInsets paramWindowInsets)
  {
    return getSafeInsetDistance(paramWindowInsets, "getSafeInsetLeft");
  }
  
  private int getSafeInsetRight(WindowInsets paramWindowInsets)
  {
    return getSafeInsetDistance(paramWindowInsets, "getSafeInsetRight");
  }
  
  private int getSafeInsetTop(WindowInsets paramWindowInsets)
  {
    return getSafeInsetDistance(paramWindowInsets, "getSafeInsetTop");
  }
  
  /* Error */
  private void handleGetCutoutSize(View arg1, WindowInsets arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void handleGetCutoutSizeGoogleApi(WindowInsets arg1, Context arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void handleGetCutoutSizeHwApi(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private Object invokeMethod(WindowInsets paramWindowInsets, String paramString)
  {
    return null;
  }
  
  /* Error */
  private void startGetCutoutSize(Activity arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getAppUseNotchMode(String paramString)
  {
    return 0;
  }
  
  public int getCutoutHeight(Context paramContext)
  {
    paramContext = getCutoutInfo(paramContext);
    if (paramContext != null) {
      return paramContext.getHeight();
    }
    return 0;
  }
  
  public CutoutInfo getCutoutInfo(Context paramContext)
  {
    return null;
  }
  
  /* Error */
  public void getCutoutSize(Activity arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean hasNotchInScreen(Context paramContext)
  {
    return false;
  }
  
  public boolean hasSetOpenNotch(Context paramContext)
  {
    return false;
  }
  
  public boolean isActivityUseNotchArea(Activity paramActivity)
  {
    return false;
  }
  
  public boolean isAdaptNotchArea(Context paramContext, String paramString)
  {
    return false;
  }
  
  public boolean isAppUseNotchArea(Context paramContext, String paramString)
  {
    return false;
  }
  
  public boolean isCutoutPortScreen(Context paramContext)
  {
    return false;
  }
  
  /* Error */
  public void setLayoutInDisplayCutoutMode(Activity arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setLayoutInDisplayCutoutMode(android.view.WindowManager.LayoutParams arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\impl\cutout\BuoyCutoutHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */