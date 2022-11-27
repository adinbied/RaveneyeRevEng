package com.huawei.appmarket.component.buoycircle.impl.utils;

import com.huawei.appmarket.component.buoycircle.impl.log.BuoyLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HwBuildEx
{
  private static final String TAG = "HwBuildEx";
  
  public static int getSystemPropertiesInt(String paramString, int paramInt)
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      int i = ((Integer)localClass.getDeclaredMethod("getInt", new Class[] { String.class, Integer.TYPE }).invoke(localClass, new Object[] { paramString, Integer.valueOf(paramInt) })).intValue();
      return i;
    }
    catch (ClassNotFoundException|NoSuchMethodException|IllegalAccessException|IllegalArgumentException|InvocationTargetException|ClassCastException paramString)
    {
      for (;;) {}
    }
    BuoyLog.e("HwBuildEx", "An exception occurred while reading: EMUI_SDK_INT");
    return paramInt;
  }
  
  public static class VERSION
  {
    public static final int EMUI_SDK_INT = HwBuildEx.getSystemPropertiesInt("ro.build.hw_emui_api_level", 0);
  }
  
  public static class VERSION_CODES
  {
    public static final int EMUI_4_0 = 9;
    public static final int EMUI_8_0 = 14;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\utils\HwBuildEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */