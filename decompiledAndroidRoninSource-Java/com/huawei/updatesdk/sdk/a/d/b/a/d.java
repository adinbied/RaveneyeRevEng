package com.huawei.updatesdk.sdk.a.d.b.a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class d
  implements a
{
  private static d a;
  private static final Object b = new Object();
  
  public static d b()
  {
    synchronized (b)
    {
      if (a == null) {
        a = new d();
      }
      d locald = a;
      return locald;
    }
  }
  
  private static Object c()
  {
    StringBuilder localStringBuilder;
    String str6;
    try
    {
      Object localObject = Class.forName("com.mediatek.telephony.TelephonyManagerEx");
      localObject = ((Class)localObject).getDeclaredMethod("getDefault", new Class[0]).invoke(localObject, new Object[0]);
      return localObject;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" getDefaultTelephonyManagerEx wrong ");
      String str1 = localInvocationTargetException.toString();
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" getDefaultTelephonyManagerEx wrong ");
      String str2 = localIllegalArgumentException.toString();
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" getDefaultTelephonyManagerEx wrong ");
      String str3 = localIllegalAccessException.toString();
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" getDefaultTelephonyManagerEx wrong ");
      String str4 = localNoSuchMethodException.toString();
    }
    catch (SecurityException localSecurityException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" getDefaultTelephonyManagerEx wrong ");
      String str5 = localSecurityException.toString();
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" getDefaultTelephonyManagerEx wrong ");
      str6 = localClassNotFoundException.toString();
    }
    localStringBuilder.append(str6);
    com.huawei.updatesdk.sdk.a.c.a.a.a.d("mutiCardMTKImpl", localStringBuilder.toString());
    return null;
  }
  
  public int a()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\sdk\a\d\b\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */