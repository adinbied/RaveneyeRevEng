package com.huawei.hianalytics.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.huawei.hianalytics.g.b;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class e
{
  private static Object a(Class paramClass, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    if (paramClass != null) {
      if (paramArrayOfClass == null)
      {
        if (paramArrayOfObject != null) {
          throw new a("paramsType is null, but params is not null");
        }
      }
      else {
        if ((paramArrayOfObject != null) && (paramArrayOfClass.length != paramArrayOfObject.length)) {
          break label78;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramClass = paramClass.getMethod(paramString, paramArrayOfClass);
      }
      catch (NoSuchMethodException paramClass)
      {
        continue;
        paramClass = "invokeStaticFun(): Illegal Argument!";
        continue;
      }
      try
      {
        paramClass = paramClass.invoke(null, paramArrayOfObject);
        return paramClass;
      }
      catch (IllegalAccessException paramClass) {}catch (IllegalArgumentException paramClass) {}catch (InvocationTargetException paramClass) {}
    }
    for (paramClass = "invokeStaticFun(): Invocation Target Exception!";; paramClass = "invokeStaticFun(): method invoke Exception!")
    {
      b.c("globalStreamUtil", paramClass);
      return null;
    }
    b.c("globalStreamUtil", "invokeStaticFun(): cls.getMethod(),No Such Method !");
    return null;
    label78:
    paramClass = new StringBuilder();
    paramClass.append("paramsType len:");
    paramClass.append(paramArrayOfClass.length);
    paramClass.append(" should equal params.len:");
    paramClass.append(paramArrayOfObject.length);
    throw new a(paramClass.toString());
    throw new a("paramsType or params should be same");
    throw new a("class is null in invokeStaticFun");
  }
  
  private static Object a(String paramString1, String paramString2, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      paramString1 = a(Class.forName(paramString1), paramString2, paramArrayOfClass, paramArrayOfObject);
      return paramString1;
    }
    catch (ClassNotFoundException paramString1)
    {
      for (;;) {}
    }
    catch (a paramString1)
    {
      label22:
      for (;;) {}
    }
    paramString1 = "invokeStaticFun(): Static function call Exception ";
    break label22;
    paramString1 = "invokeStaticFun() Not found class!";
    b.c("globalStreamUtil", paramString1);
    return null;
  }
  
  public static String a(InputStream paramInputStream, int paramInt)
  {
    a locala = new a(paramInt);
    byte[] arrayOfByte = new byte[paramInt];
    for (;;)
    {
      paramInt = paramInputStream.read(arrayOfByte);
      if (paramInt == -1L) {
        break;
      }
      locala.a(arrayOfByte, paramInt);
    }
    if (locala.a() == 0) {
      return "";
    }
    return new String(locala.b(), "UTF-8");
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return b(paramString1, paramString2);
  }
  
  private static String a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = a(paramString1, "get", new Class[] { String.class, String.class }, new Object[] { paramString2, paramString3 });
    if (paramString1 != null) {
      paramString3 = (String)paramString1;
    }
    return paramString3;
  }
  
  public static void a(int paramInt, Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      for (;;) {}
    }
    b.c("globalStreamUtil", "closeQuietly(): Exception when closing the closeable!");
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return true;
    }
    if (Build.VERSION.SDK_INT < 23)
    {
      if (paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName()) != 0)
      {
        b.c("HianalyticsSDK", "not have read phone permission!");
        return true;
      }
    }
    else if (paramContext.checkSelfPermission(paramString) != 0)
    {
      b.c("HianalyticsSDK", "not have read phone permission!");
      return true;
    }
    return false;
  }
  
  public static String b(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    String str2 = a("android.os.SystemProperties", paramString1, paramString2);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = a("com.huawei.android.os.SystemPropertiesEx", paramString1, paramString2);
    }
    return str1;
  }
  
  private static class a
    extends Exception
  {
    a(String paramString)
    {
      super();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytic\\util\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */