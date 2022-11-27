package dji.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import java.lang.reflect.Method;

public class DisplayUtils
{
  private static final String HUAWEI = "huawei";
  private static final String OPPO = "oppo";
  private static final String SMARTISAN = "smartisan";
  private static final String VIVO = "vivo";
  private static final String XIAOMI = "xiaomi";
  
  public static int getMaxScreenSize(Context paramContext)
  {
    if (getScreenHeight(paramContext) < getScreenWidth(paramContext)) {
      return getScreenWidth(paramContext);
    }
    return getScreenHeight(paramContext);
  }
  
  public static int getMinScreenSize(Context paramContext)
  {
    if (getScreenHeight(paramContext) < getScreenWidth(paramContext)) {
      return getScreenHeight(paramContext);
    }
    return getScreenWidth(paramContext);
  }
  
  public static int getNotchHeight(Context paramContext)
  {
    if (hasNotchInOppo(paramContext)) {
      return 80;
    }
    if (hasNotchInVivo(paramContext)) {
      return UnitUtils.dp2px(27.0F);
    }
    if (hasNotchInHuawei(paramContext)) {
      return 80;
    }
    if (hasNotchInXiaomi(paramContext)) {
      return getXiaomiNotchHeight(paramContext);
    }
    if (hasNotchInSmartisan(paramContext)) {
      return 82;
    }
    return 0;
  }
  
  public static float getScreenDensity()
  {
    return Resources.getSystem().getDisplayMetrics().density;
  }
  
  public static int getScreenDentisyDpi()
  {
    return Resources.getSystem().getDisplayMetrics().densityDpi;
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    WindowManager localWindowManager = (WindowManager)paramContext.getApplicationContext().getSystemService("window");
    Point localPoint = new Point();
    if (Build.VERSION.SDK_INT >= 17) {
      localWindowManager.getDefaultDisplay().getRealSize(localPoint);
    } else {
      localWindowManager.getDefaultDisplay().getSize(localPoint);
    }
    if (isPortrait(paramContext)) {
      return localPoint.y;
    }
    return localPoint.x;
  }
  
  public static int getScreenRotation(Activity paramActivity)
  {
    int i = paramActivity.getWindowManager().getDefaultDisplay().getRotation();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return 0;
        }
        return 270;
      }
      return 180;
    }
    return 90;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    WindowManager localWindowManager = (WindowManager)paramContext.getApplicationContext().getSystemService("window");
    Point localPoint = new Point();
    if (Build.VERSION.SDK_INT >= 17) {
      localWindowManager.getDefaultDisplay().getRealSize(localPoint);
    } else {
      localWindowManager.getDefaultDisplay().getSize(localPoint);
    }
    if (isPortrait(paramContext)) {
      return localPoint.x;
    }
    return localPoint.y;
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    int i = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (i > 0) {
      return paramContext.getResources().getDimensionPixelSize(i);
    }
    return 0;
  }
  
  private static int getXiaomiNotchHeight(Context paramContext)
  {
    int i = paramContext.getResources().getIdentifier("notch_height", "dimen", "android");
    if (i > 0) {
      return paramContext.getResources().getDimensionPixelSize(i);
    }
    return getStatusBarHeight(paramContext);
  }
  
  private static boolean hasNotchInHuawei(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
      boolean bool = ((Boolean)paramContext.getMethod("hasNotchInScreen", new Class[0]).invoke(paramContext, new Object[0])).booleanValue();
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private static boolean hasNotchInOppo(Context paramContext)
  {
    return paramContext.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
  }
  
  public static boolean hasNotchInSmartisan(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("smartisanos.api.DisplayUtilsSmt");
      boolean bool = ((Boolean)paramContext.getMethod("isFeatureSupport", new Class[] { Integer.TYPE }).invoke(paramContext, new Object[] { Integer.valueOf(1) })).booleanValue();
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private static boolean hasNotchInVivo(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("android.util.FtFeature");
      boolean bool = ((Boolean)paramContext.getMethod("isFeatureSupport", new Class[] { Integer.TYPE }).invoke(paramContext, new Object[] { Integer.valueOf(32) })).booleanValue();
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private static boolean hasNotchInXiaomi(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("android.os.SystemProperties");
      int i = ((Integer)paramContext.getMethod("getInt", new Class[] { String.class, Integer.TYPE }).invoke(paramContext, new Object[] { "ro.miui.notch", Integer.valueOf(0) })).intValue();
      if (i == 1) {
        return true;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static void hideNavigationBar(Activity paramActivity)
  {
    if ((Build.VERSION.SDK_INT > 11) && (Build.VERSION.SDK_INT < 19))
    {
      paramActivity.getWindow().getDecorView().setSystemUiVisibility(8);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19) {
      paramActivity.getWindow().getDecorView().setSystemUiVisibility(4098);
    }
  }
  
  public static boolean isFullScreen(Activity paramActivity)
  {
    return (paramActivity.getWindow().getAttributes().flags & 0x400) == 1024;
  }
  
  public static boolean isLandscape(Context paramContext)
  {
    return paramContext.getApplicationContext().getResources().getConfiguration().orientation == 2;
  }
  
  public static boolean isNotchScreen(Context paramContext)
  {
    String str = DeviceUtils.getManufacture();
    switch (str.hashCode())
    {
    default: 
      break;
    case 3620012: 
      if (str.equals("vivo")) {
        i = 0;
      }
      break;
    case 3418016: 
      if (str.equals("oppo")) {
        i = 1;
      }
      break;
    case -759499589: 
      if (str.equals("xiaomi")) {
        i = 3;
      }
      break;
    case -1206476313: 
      if (str.equals("huawei")) {
        i = 2;
      }
      break;
    case -1443430368: 
      if (str.equals("smartisan")) {
        i = 4;
      }
      break;
    }
    int i = -1;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              return false;
            }
            return hasNotchInSmartisan(paramContext);
          }
          return hasNotchInXiaomi(paramContext);
        }
        return hasNotchInHuawei(paramContext);
      }
      return hasNotchInOppo(paramContext);
    }
    return hasNotchInVivo(paramContext);
  }
  
  public static boolean isPortrait(Context paramContext)
  {
    return paramContext.getApplicationContext().getResources().getConfiguration().orientation == 1;
  }
  
  public static void setFullScreen(Activity paramActivity)
  {
    paramActivity.getWindow().addFlags(1024);
  }
  
  public static void setLandscape(Activity paramActivity)
  {
    paramActivity.setRequestedOrientation(0);
  }
  
  public static void setNonFullScreen(Activity paramActivity)
  {
    paramActivity.getWindow().clearFlags(1024);
  }
  
  public static void setPortrait(Activity paramActivity)
  {
    paramActivity.setRequestedOrientation(1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dj\\utils\DisplayUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */