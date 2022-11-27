package com.huawei.hms.a;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class a
{
  public static int a(String paramString, int paramInt)
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
    Log.e("HwBuildEx", "An exception occurred while reading: EMUI_SDK_INT");
    return paramInt;
  }
  
  public static class a
  {
    public static final int a = a.a("ro.build.hw_emui_api_level", 0);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */