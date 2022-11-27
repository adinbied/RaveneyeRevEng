package com.huawei.updatesdk.sdk.a.d.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.net.InetSocketAddress;
import java.net.Proxy.Type;

public class b
{
  private static String a = "NetworkUtil";
  private static int b = -1;
  private static int c = -1;
  private static java.net.Proxy d;
  
  public static int a(NetworkInfo paramNetworkInfo)
  {
    int i = 1;
    if ((paramNetworkInfo != null) && (paramNetworkInfo.isConnected()))
    {
      int j = paramNetworkInfo.getType();
      if (1 == j) {
        return i;
      }
      if (13 == j) {
        return 1;
      }
      if (j == 0) {
        switch (paramNetworkInfo.getSubtype())
        {
        default: 
          break;
        case 13: 
          return 4;
        case 3: 
        case 5: 
        case 6: 
        case 8: 
        case 9: 
        case 10: 
        case 12: 
        case 14: 
        case 15: 
          return 3;
        case 1: 
        case 2: 
        case 4: 
        case 7: 
        case 11: 
          return 2;
        }
      }
    }
    i = 0;
    return i;
  }
  
  public static java.net.Proxy a()
  {
    return d;
  }
  
  public static void a(int paramInt)
  {
    c = paramInt;
  }
  
  public static void a(java.net.Proxy paramProxy)
  {
    d = paramProxy;
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if ((paramContext != null) && (paramContext.isConnected())) {
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean a(NetworkInfo paramNetworkInfo, Context paramContext)
  {
    int i = paramNetworkInfo.getType();
    boolean bool = a.b(paramContext);
    if ((i == 0) && (bool))
    {
      String str = android.net.Proxy.getHost(paramContext);
      i = android.net.Proxy.getPort(paramContext);
      paramContext = null;
      paramNetworkInfo = paramContext;
      if (str != null)
      {
        paramNetworkInfo = paramContext;
        if (str.length() > 0)
        {
          paramNetworkInfo = paramContext;
          if (i != -1) {
            paramNetworkInfo = new java.net.Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i));
          }
        }
      }
      a(paramNetworkInfo);
      return true;
    }
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    if (-1 == c) {
      c(paramContext);
    }
    return c == -3;
  }
  
  public static int c(Context paramContext)
  {
    if (-1 == b)
    {
      com.huawei.updatesdk.sdk.a.c.a.a.a.a(a, "getPsType() need init");
      if (paramContext != null) {
        d(paramContext);
      }
    }
    return b;
  }
  
  public static void d(Context paramContext)
  {
    a(0);
    NetworkInfo localNetworkInfo = g(paramContext);
    if (localNetworkInfo == null)
    {
      com.huawei.updatesdk.sdk.a.c.a.a.a.a(a, "setPsType() info = null");
      return;
    }
    int i = a(localNetworkInfo);
    b = i;
    if (1 != i)
    {
      if (a(localNetworkInfo, paramContext)) {
        i = -3;
      } else {
        i = -2;
      }
      a(i);
    }
  }
  
  public static boolean e(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    boolean bool2 = false;
    paramContext = paramContext.getNetworkInfo(0);
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (paramContext.isConnectedOrConnecting()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static java.net.Proxy f(Context paramContext)
  {
    if (b(paramContext)) {
      return a();
    }
    return null;
  }
  
  private static NetworkInfo g(Context paramContext)
  {
    return ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\sdk\a\d\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */