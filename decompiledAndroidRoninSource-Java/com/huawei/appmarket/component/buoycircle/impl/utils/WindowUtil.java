package com.huawei.appmarket.component.buoycircle.impl.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.huawei.appmarket.component.buoycircle.impl.log.BuoyLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WindowUtil
{
  private static final int INIT_X = 0;
  private static final float POSITION_Y_PERCENT = 0.43333334F;
  private static final int STATUS_NO_INITED = -1;
  private static final String TAG = "WindowUtil";
  private static int screenH = 0;
  private static int statusBarHeight = -1;
  
  public static int dp2Px(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static float dp2px(Context paramContext, int paramInt)
  {
    return paramInt * paramContext.getResources().getDisplayMetrics().density;
  }
  
  public static int getDefaultPositionX(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    return dp2Px(paramContext, 0.0F);
  }
  
  public static int getDefaultPositionY(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    int i = (int)(getScreenH(paramContext) * 0.43333334F);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("the default positionY:");
    localStringBuilder.append(i);
    localStringBuilder.append(", screenH:");
    localStringBuilder.append(getScreenH(paramContext));
    BuoyLog.d("WindowUtil", localStringBuilder.toString());
    return i;
  }
  
  public static DisplayMetrics getFullDisplayMetrics(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    if (paramContext == null) {
      return localDisplayMetrics;
    }
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    try
    {
      Class.forName("android.view.Display").getMethod("getRealMetrics", new Class[] { DisplayMetrics.class }).invoke(paramContext, new Object[] { localDisplayMetrics });
      return localDisplayMetrics;
    }
    catch (ClassNotFoundException paramContext)
    {
      for (;;) {}
    }
    catch (NoSuchMethodException paramContext)
    {
      for (;;) {}
    }
    catch (IllegalAccessException paramContext)
    {
      for (;;) {}
    }
    catch (IllegalArgumentException paramContext)
    {
      for (;;) {}
    }
    catch (InvocationTargetException paramContext)
    {
      for (;;) {}
    }
    BuoyLog.e("WindowUtil", "get full display metrics error, InvocationTargetException");
    return localDisplayMetrics;
    BuoyLog.e("WindowUtil", "get full display metrics error, IllegalArgumentException");
    return localDisplayMetrics;
    BuoyLog.e("WindowUtil", "get full display metrics error, IllegalAccessException");
    return localDisplayMetrics;
    BuoyLog.e("WindowUtil", "get full display metrics error, NoSuchMethodException");
    return localDisplayMetrics;
    BuoyLog.e("WindowUtil", "get full display metrics error, ClassNotFoundException");
    return localDisplayMetrics;
  }
  
  public static int getScreenH(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = localDisplayMetrics.heightPixels;
    screenH = i;
    return i;
  }
  
  public static int getScreenW(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.widthPixels;
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    if (statusBarHeight == -1) {}
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      int i = ((Integer)localClass.getField("status_bar_height").get(localObject)).intValue();
      statusBarHeight = paramContext.getResources().getDimensionPixelSize(i);
    }
    catch (ClassNotFoundException paramContext)
    {
      for (;;) {}
    }
    catch (InstantiationException paramContext)
    {
      for (;;) {}
    }
    catch (IllegalAccessException paramContext)
    {
      for (;;) {}
    }
    catch (NoSuchFieldException paramContext)
    {
      for (;;) {}
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    statusBarHeight = 0;
    BuoyLog.e("WindowUtil", "getStatusBarHeight Exception");
    break label116;
    statusBarHeight = 0;
    BuoyLog.e("WindowUtil", "getStatusBarHeight NoSuchFieldException");
    break label116;
    statusBarHeight = 0;
    BuoyLog.e("WindowUtil", "getStatusBarHeight IllegalAccessException");
    break label116;
    statusBarHeight = 0;
    BuoyLog.e("WindowUtil", "getStatusBarHeight InstantiationException");
    break label116;
    statusBarHeight = 0;
    BuoyLog.e("WindowUtil", "getStatusBarHeight ClassNotFoundException");
    label116:
    return statusBarHeight;
  }
  
  public static int getTotalWidth(Context paramContext)
  {
    return getFullDisplayMetrics(paramContext).widthPixels;
  }
  
  public static boolean isOverStatus(WindowManager.LayoutParams paramLayoutParams)
  {
    return (paramLayoutParams != null) && ((paramLayoutParams.flags & 0x128) == 296);
  }
  
  public static boolean isShowStatusBar(Context paramContext)
  {
    return getStatusBarHeight(paramContext) > 0;
  }
  
  public static void setStatusBarHeight(Context paramContext)
  {
    if ((paramContext instanceof Activity))
    {
      if ((((Activity)paramContext).getWindow().getAttributes().flags & 0x400) == 1024) {
        statusBarHeight = 0;
      }
    }
    else {
      statusBarHeight = -1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\utils\WindowUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */