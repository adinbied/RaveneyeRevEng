package com.idlefish.flutterboost;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StatusbarColorUtils
{
  private static int SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
  private static Method mSetStatusBarColorIcon;
  private static Method mSetStatusBarDarkIcon;
  private static Field mStatusBarColorFiled;
  
  static
  {
    try
    {
      mSetStatusBarColorIcon = Activity.class.getMethod("setStatusBarDarkIcon", new Class[] { Integer.TYPE });
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      localNoSuchMethodException1.printStackTrace();
    }
    try
    {
      mSetStatusBarDarkIcon = Activity.class.getMethod("setStatusBarDarkIcon", new Class[] { Boolean.TYPE });
    }
    catch (NoSuchMethodException localNoSuchMethodException2)
    {
      localNoSuchMethodException2.printStackTrace();
    }
    try
    {
      mStatusBarColorFiled = WindowManager.LayoutParams.class.getField("statusBarColor");
    }
    catch (NoSuchFieldException localNoSuchFieldException1)
    {
      localNoSuchFieldException1.printStackTrace();
    }
    try
    {
      SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt(null);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException2)
    {
      localNoSuchFieldException2.printStackTrace();
    }
  }
  
  /* Error */
  private static boolean changeMeizuFlag(WindowManager.LayoutParams paramLayoutParams, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 80	java/lang/Object:getClass	()Ljava/lang/Class;
    //   4: aload_1
    //   5: invokevirtual 83	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   8: astore_1
    //   9: aload_1
    //   10: iconst_1
    //   11: invokevirtual 87	java/lang/reflect/Field:setAccessible	(Z)V
    //   14: aload_1
    //   15: aload_0
    //   16: invokevirtual 65	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   19: istore_3
    //   20: aload_0
    //   21: invokevirtual 80	java/lang/Object:getClass	()Ljava/lang/Class;
    //   24: ldc 89
    //   26: invokevirtual 83	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   29: astore_1
    //   30: aload_1
    //   31: iconst_1
    //   32: invokevirtual 87	java/lang/reflect/Field:setAccessible	(Z)V
    //   35: aload_1
    //   36: aload_0
    //   37: invokevirtual 65	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   40: istore 4
    //   42: iload_2
    //   43: ifeq +56 -> 99
    //   46: iload_3
    //   47: iload 4
    //   49: ior
    //   50: istore_3
    //   51: goto +3 -> 54
    //   54: iload 4
    //   56: iload_3
    //   57: if_icmpeq +40 -> 97
    //   60: aload_1
    //   61: aload_0
    //   62: iload_3
    //   63: invokevirtual 93	java/lang/reflect/Field:setInt	(Ljava/lang/Object;I)V
    //   66: iconst_1
    //   67: ireturn
    //   68: astore_0
    //   69: aload_0
    //   70: invokevirtual 96	java/lang/Throwable:printStackTrace	()V
    //   73: goto +24 -> 97
    //   76: astore_0
    //   77: aload_0
    //   78: invokevirtual 97	java/lang/IllegalArgumentException:printStackTrace	()V
    //   81: goto +16 -> 97
    //   84: astore_0
    //   85: aload_0
    //   86: invokevirtual 68	java/lang/IllegalAccessException:printStackTrace	()V
    //   89: goto +8 -> 97
    //   92: astore_0
    //   93: aload_0
    //   94: invokevirtual 56	java/lang/NoSuchFieldException:printStackTrace	()V
    //   97: iconst_0
    //   98: ireturn
    //   99: iload_3
    //   100: iload 4
    //   102: iand
    //   103: istore_3
    //   104: goto -50 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramLayoutParams	WindowManager.LayoutParams
    //   0	107	1	paramString	String
    //   0	107	2	paramBoolean	boolean
    //   19	85	3	i	int
    //   40	63	4	j	int
    // Exception table:
    //   from	to	target	type
    //   0	42	68	finally
    //   60	66	68	finally
    //   0	42	76	java/lang/IllegalArgumentException
    //   60	66	76	java/lang/IllegalArgumentException
    //   0	42	84	java/lang/IllegalAccessException
    //   60	66	84	java/lang/IllegalAccessException
    //   0	42	92	java/lang/NoSuchFieldException
    //   60	66	92	java/lang/NoSuchFieldException
  }
  
  public static boolean isBlackColor(int paramInt1, int paramInt2)
  {
    return toGrey(paramInt1) < paramInt2;
  }
  
  private static void setStatusBarColor(Window paramWindow, int paramInt)
  {
    WindowManager.LayoutParams localLayoutParams = paramWindow.getAttributes();
    Field localField = mStatusBarColorFiled;
    if (localField != null) {
      try
      {
        if (localField.getInt(localLayoutParams) != paramInt)
        {
          mStatusBarColorFiled.set(localLayoutParams, Integer.valueOf(paramInt));
          paramWindow.setAttributes(localLayoutParams);
          return;
        }
      }
      catch (IllegalAccessException paramWindow)
      {
        paramWindow.printStackTrace();
      }
    }
  }
  
  public static void setStatusBarDarkIcon(Activity paramActivity, int paramInt)
  {
    Method localMethod = mSetStatusBarColorIcon;
    if (localMethod != null) {
      try
      {
        localMethod.invoke(paramActivity, new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      catch (InvocationTargetException paramActivity)
      {
        paramActivity.printStackTrace();
        return;
      }
      catch (IllegalAccessException paramActivity)
      {
        paramActivity.printStackTrace();
        return;
      }
    }
    boolean bool = isBlackColor(paramInt, 50);
    if (mStatusBarColorFiled != null)
    {
      setStatusBarDarkIcon(paramActivity, bool, bool);
      setStatusBarDarkIcon(paramActivity.getWindow(), paramInt);
      return;
    }
    setStatusBarDarkIcon(paramActivity, bool);
  }
  
  public static void setStatusBarDarkIcon(Activity paramActivity, boolean paramBoolean)
  {
    setStatusBarDarkIcon(paramActivity, paramBoolean, true);
  }
  
  private static void setStatusBarDarkIcon(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    Method localMethod = mSetStatusBarDarkIcon;
    if (localMethod != null) {
      try
      {
        localMethod.invoke(paramActivity, new Object[] { Boolean.valueOf(paramBoolean1) });
        return;
      }
      catch (InvocationTargetException paramActivity)
      {
        paramActivity.printStackTrace();
        return;
      }
      catch (IllegalAccessException paramActivity)
      {
        paramActivity.printStackTrace();
        return;
      }
    }
    if (paramBoolean2) {
      setStatusBarDarkIcon(paramActivity.getWindow(), paramBoolean1);
    }
  }
  
  private static void setStatusBarDarkIcon(View paramView, boolean paramBoolean)
  {
    int j = paramView.getSystemUiVisibility();
    int i;
    if (paramBoolean) {
      i = SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | j;
    } else {
      i = SYSTEM_UI_FLAG_LIGHT_STATUS_BAR & j;
    }
    if (i != j) {
      paramView.setSystemUiVisibility(i);
    }
  }
  
  public static void setStatusBarDarkIcon(Window paramWindow, int paramInt)
  {
    try
    {
      setStatusBarColor(paramWindow, paramInt);
      if (Build.VERSION.SDK_INT > 22)
      {
        setStatusBarDarkIcon(paramWindow.getDecorView(), true);
        return;
      }
    }
    catch (Exception paramWindow)
    {
      paramWindow.printStackTrace();
    }
  }
  
  public static void setStatusBarDarkIcon(Window paramWindow, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 23)
    {
      changeMeizuFlag(paramWindow.getAttributes(), "MEIZU_FLAG_DARK_STATUS_BAR_ICON", paramBoolean);
      return;
    }
    View localView = paramWindow.getDecorView();
    if (localView != null)
    {
      setStatusBarDarkIcon(localView, paramBoolean);
      setStatusBarColor(paramWindow, 0);
    }
  }
  
  public static int toGrey(int paramInt)
  {
    return ((paramInt & 0xFF0000) >> 16) * 38 + ((0xFF00 & paramInt) >> 8) * 75 + (paramInt & 0xFF) * 15 >> 7;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\idlefish\flutterboost\StatusbarColorUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */