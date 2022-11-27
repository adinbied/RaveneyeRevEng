package com.huawei.updatesdk.sdk.a.d.b.a;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class b
{
  private static a.a a = a.a.a;
  private static a b;
  
  public static a a()
  {
    b();
    Object localObject;
    if (a == a.a.d) {
      localObject = d.b();
    } else {
      localObject = c.b();
    }
    b = (a)localObject;
    return b;
  }
  
  public static boolean b()
  {
    a.a locala1 = a;
    a.a locala2 = a.a.a;
    boolean bool = true;
    if (locala1 != locala2)
    {
      if (a == a.a.c) {
        return bool;
      }
      if (a == a.a.d) {
        return true;
      }
    }
    else
    {
      if (d()) {}
      for (locala1 = a.a.d;; locala1 = a.a.c)
      {
        a = locala1;
        return true;
        if (!c()) {
          break;
        }
      }
      a = a.a.b;
    }
    bool = false;
    return bool;
  }
  
  public static boolean c()
  {
    boolean bool2 = false;
    try
    {
      try
      {
        Object localObject1 = c.c();
        bool1 = bool2;
        if (localObject1 == null) {
          break label140;
        }
        bool1 = ((Boolean)localObject1.getClass().getMethod("isMultiSimEnabled", new Class[0]).invoke(localObject1, new Object[0])).booleanValue();
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("MSimTelephonyManager.getDefault().isMultiSimEnabled()");
        String str1 = localInvocationTargetException.toString();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("MSimTelephonyManager.getDefault().isMultiSimEnabled()");
        str2 = localIllegalAccessException.toString();
      }
      localStringBuilder.append(str2);
      String str2 = localStringBuilder.toString();
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MSimTelephonyManager.getDefault().isMultiSimEnabled()?");
      localStringBuilder.append(localNoSuchMethodException.toString());
      localObject2 = localStringBuilder.toString();
    }
    com.huawei.updatesdk.sdk.a.c.a.a.a.d("mutiCardFactory", (String)localObject2);
    boolean bool1 = bool2;
    label140:
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("isHwGeminiSupport1 ");
    ((StringBuilder)localObject2).append(bool1);
    com.huawei.updatesdk.sdk.a.c.a.a.a.a("mutiCardFactory", ((StringBuilder)localObject2).toString());
    return bool1;
  }
  
  private static boolean d()
  {
    StringBuilder localStringBuilder;
    try
    {
      Field localField = Class.forName("com.mediatek.common.featureoption.FeatureOption").getDeclaredField("MTK_GEMINI_SUPPORT");
      localField.setAccessible(true);
      bool = localField.getBoolean(null);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("FeatureOption.MTK_GEMINI_SUPPORT");
      String str1 = localIllegalAccessException.toString();
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("FeatureOption.MTK_GEMINI_SUPPORT");
      String str2 = localNoSuchFieldException.toString();
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("FeatureOption.MTK_GEMINI_SUPPORT");
      localObject = localClassNotFoundException.toString();
    }
    localStringBuilder.append((String)localObject);
    com.huawei.updatesdk.sdk.a.c.a.a.a.b("mutiCardFactory", localStringBuilder.toString());
    boolean bool = false;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isMtkGeminiSupport ");
    ((StringBuilder)localObject).append(bool);
    com.huawei.updatesdk.sdk.a.c.a.a.a.a("mutiCardFactory", ((StringBuilder)localObject).toString());
    return bool;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\sdk\a\d\b\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */