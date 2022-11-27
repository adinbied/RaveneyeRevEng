package com.huawei.updatesdk.sdk.a.d.b.a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class c
  implements a
{
  private static c a;
  private static final Object b = new Object();
  
  public static c b()
  {
    synchronized (b)
    {
      if (a == null) {
        a = new c();
      }
      c localc = a;
      return localc;
    }
  }
  
  public static Object c()
  {
    StringBuilder localStringBuilder;
    String str5;
    try
    {
      Object localObject = Class.forName("android.telephony.MSimTelephonyManager");
      localObject = ((Class)localObject).getDeclaredMethod("getDefault", new Class[0]).invoke(localObject, new Object[0]);
      return localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" getDefaultMSimTelephonyManager wrong ");
      String str1 = localClassNotFoundException.toString();
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" getDefaultMSimTelephonyManager wrong ");
      String str2 = localInvocationTargetException.toString();
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" getDefaultMSimTelephonyManager wrong ");
      String str3 = localIllegalArgumentException.toString();
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" getDefaultMSimTelephonyManager wrong ");
      String str4 = localIllegalAccessException.toString();
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" getDefaultMSimTelephonyManager wrong ");
      str5 = localNoSuchMethodException.toString();
    }
    localStringBuilder.append(str5);
    com.huawei.updatesdk.sdk.a.c.a.a.a.d("MutiCardHwImpl", localStringBuilder.toString());
    return null;
  }
  
  public int a()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\sdk\a\d\b\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */