package dji.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.FragmentActivity;
import java.lang.reflect.Method;

public final class DJIUIUtils
{
  public static boolean checkDeviceHasNavigationBar(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    if (i < 21) {
      return false;
    }
    paramContext = paramContext.getResources();
    i = paramContext.getIdentifier("config_showNavigationBar", "bool", "android");
    boolean bool1;
    if (i > 0) {
      bool1 = paramContext.getBoolean(i);
    } else {
      bool1 = false;
    }
    try
    {
      paramContext = Class.forName("android.os.SystemProperties");
      paramContext = (String)paramContext.getMethod("get", new Class[] { String.class }).invoke(paramContext, new Object[] { "qemu.hw.mainkeys" });
      if ("1".equals(paramContext))
      {
        bool1 = bool2;
      }
      else
      {
        bool2 = "0".equals(paramContext);
        if (bool2) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramContext) {}
    return bool1;
  }
  
  public static void closeKeybord(Activity paramActivity)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)paramActivity.getSystemService("input_method");
    if (paramActivity.getCurrentFocus() != null) {
      localInputMethodManager.hideSoftInputFromWindow(paramActivity.getCurrentFocus().getWindowToken(), 0);
    }
  }
  
  public static int dip2px(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static void disableKeepScreenOn(Window paramWindow)
  {
    if (paramWindow != null) {
      paramWindow.clearFlags(128);
    }
  }
  
  public static void enableKeepScreenOn(Window paramWindow)
  {
    if (paramWindow != null) {
      paramWindow.addFlags(128);
    }
  }
  
  public static void forceLandScapeOrientation(Activity paramActivity)
  {
    if (paramActivity.getResources().getConfiguration().orientation != 2) {
      paramActivity.setRequestedOrientation(0);
    }
  }
  
  public static void forcePortraitOrientation(Activity paramActivity)
  {
    if (paramActivity.getResources().getConfiguration().orientation != 1) {
      paramActivity.setRequestedOrientation(1);
    }
  }
  
  public static float getDensity(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().density;
  }
  
  public static int getDrawableResId(Context paramContext, String paramString)
  {
    return paramContext.getResources().getIdentifier(paramString, "drawable", paramContext.getPackageName());
  }
  
  public static int[] getLocationInWindow(View paramView)
  {
    int[] arrayOfInt = new int[2];
    if (paramView != null) {
      paramView.getLocationInWindow(arrayOfInt);
    }
    return arrayOfInt;
  }
  
  public static int[] getLocationOnScreen(View paramView)
  {
    int[] arrayOfInt = new int[2];
    if (paramView != null) {
      paramView.getLocationOnScreen(arrayOfInt);
    }
    return arrayOfInt;
  }
  
  public static int getMaxRealScreenSize(Context paramContext)
  {
    int i = getScreenRealWidth(paramContext);
    int j = getScreenRealHeight(paramContext);
    if (i > j) {
      return i;
    }
    return j;
  }
  
  public static int getMaxScreenSize(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    if (paramContext.widthPixels > paramContext.heightPixels) {
      return paramContext.widthPixels;
    }
    return paramContext.heightPixels;
  }
  
  public static int getMinRealScreenSize(Context paramContext)
  {
    int j = getScreenRealWidth(paramContext);
    int k = getScreenRealHeight(paramContext);
    int i = j;
    if (j > k) {
      i = k;
    }
    return i;
  }
  
  public static int getMinScreenSize(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    if (paramContext.widthPixels > paramContext.heightPixels) {
      return paramContext.heightPixels;
    }
    return paramContext.widthPixels;
  }
  
  public static int getOrientation(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().orientation;
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public static int getScreenRealHeight(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    int i = 0;
    DisplayMetrics localDisplayMetrics;
    if (paramContext != null)
    {
      paramContext = paramContext.getDefaultDisplay();
      localDisplayMetrics = new DisplayMetrics();
      if (Build.VERSION.SDK_INT >= 17)
      {
        paramContext.getRealMetrics(localDisplayMetrics);
        return localDisplayMetrics.heightPixels;
      }
    }
    try
    {
      Class.forName("android.view.Display").getMethod("getRealMetrics", new Class[] { DisplayMetrics.class }).invoke(paramContext, new Object[] { localDisplayMetrics });
      i = localDisplayMetrics.heightPixels;
      return i;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    paramContext.getMetrics(localDisplayMetrics);
    i = localDisplayMetrics.heightPixels;
    return i;
  }
  
  public static int getScreenRealWidth(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    int i = 0;
    DisplayMetrics localDisplayMetrics;
    if (paramContext != null)
    {
      paramContext = paramContext.getDefaultDisplay();
      localDisplayMetrics = new DisplayMetrics();
      if (Build.VERSION.SDK_INT >= 17)
      {
        paramContext.getRealMetrics(localDisplayMetrics);
        return localDisplayMetrics.widthPixels;
      }
    }
    try
    {
      Class.forName("android.view.Display").getMethod("getRealMetrics", new Class[] { DisplayMetrics.class }).invoke(paramContext, new Object[] { localDisplayMetrics });
      i = localDisplayMetrics.widthPixels;
      return i;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    paramContext.getMetrics(localDisplayMetrics);
    i = localDisplayMetrics.widthPixels;
    return i;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static int getStringResId(Context paramContext, String paramString)
  {
    return paramContext.getResources().getIdentifier(paramString, "string", paramContext.getPackageName());
  }
  
  public static String getViewIdName(Context paramContext, int paramInt)
  {
    if (paramInt == -1) {
      return "";
    }
    return paramContext.getResources().getResourceName(paramInt);
  }
  
  public static void hideSoftInput(Context paramContext, View paramView)
  {
    if (paramContext != null)
    {
      if (paramView == null) {
        return;
      }
      paramContext = (InputMethodManager)paramContext.getSystemService("input_method");
      if (paramContext != null) {
        paramContext.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      }
    }
  }
  
  public static void hideSystemUI(Window paramWindow)
  {
    if (paramWindow == null) {
      return;
    }
    paramWindow = paramWindow.getDecorView();
    if (paramWindow != null) {
      paramWindow.setSystemUiVisibility(3846);
    }
  }
  
  public static boolean isFitHasNavigationBar(Context paramContext)
  {
    return (isOpenDeviceHasNavigationBar(paramContext)) && (getScreenRealHeight(paramContext) - getScreenRealWidth(paramContext) * 2 < 0);
  }
  
  public static boolean isJustNavigationBar(Context paramContext)
  {
    return (isNavigationBar(paramContext)) && (!isVerticalLongScreen(paramContext));
  }
  
  public static boolean isJustVerticalLongScreen(Context paramContext)
  {
    return (isVerticalLongScreen(paramContext)) && (!isNavigationBar(paramContext));
  }
  
  public static boolean isLandscape(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().orientation == 2;
  }
  
  public static boolean isMainThread()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  public static boolean isNavigationBar(Context paramContext)
  {
    return (checkDeviceHasNavigationBar(paramContext)) && (isOpenDeviceHasNavigationBar(paramContext));
  }
  
  public static boolean isNavigationBarAndVerticalLongScreen(Context paramContext)
  {
    return (isNavigationBar(paramContext)) && (isVerticalLongScreen(paramContext));
  }
  
  public static boolean isNavigationBarOrVerticalLongScreen(Context paramContext)
  {
    return (isVerticalLongScreen(paramContext)) || (isNavigationBar(paramContext));
  }
  
  public static boolean isOpenDeviceHasNavigationBar(Context paramContext)
  {
    return getScreenRealHeight(paramContext) - getScreenHeight(paramContext) > 0;
  }
  
  public static boolean isPortrait(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().orientation == 1;
  }
  
  public static boolean isValidViewId(int paramInt)
  {
    return (paramInt > 0) && (paramInt != -1);
  }
  
  public static boolean isVerticalLongScreen(Context paramContext)
  {
    return getScreenRealHeight(paramContext) >= getScreenRealWidth(paramContext) * 2;
  }
  
  public static int px2dip(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static int px2sp(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
  
  public static void showSoftInput(Context paramContext, View paramView)
  {
    if (paramContext != null)
    {
      if (paramView == null) {
        return;
      }
      paramContext = (InputMethodManager)paramContext.getSystemService("input_method");
      if (paramContext != null) {
        paramContext.showSoftInput(paramView, 1);
      }
    }
  }
  
  public static void showSystemUI(Window paramWindow)
  {
    if (paramWindow == null) {
      return;
    }
    paramWindow = paramWindow.getDecorView();
    if (paramWindow != null) {
      paramWindow.setSystemUiVisibility(1792);
    }
  }
  
  public static int sp2px(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
  
  public static void toggleHideyBar(FragmentActivity paramFragmentActivity)
  {
    if (paramFragmentActivity == null) {
      return;
    }
    int j = paramFragmentActivity.getWindow().getDecorView().getSystemUiVisibility();
    int i = j;
    if (Build.VERSION.SDK_INT >= 14) {
      i = j ^ 0x2;
    }
    j = i;
    if (Build.VERSION.SDK_INT >= 16) {
      j = i ^ 0x4;
    }
    i = j;
    if (Build.VERSION.SDK_INT >= 18) {
      i = j ^ 0x1000;
    }
    paramFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dj\\utils\DJIUIUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */