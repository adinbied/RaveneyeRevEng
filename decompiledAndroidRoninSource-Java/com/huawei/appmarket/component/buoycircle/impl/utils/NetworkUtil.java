package com.huawei.appmarket.component.buoycircle.impl.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class NetworkUtil
{
  private static NetworkInfo getActiveNetworkInfo(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null) {
      return paramContext.getActiveNetworkInfo();
    }
    return null;
  }
  
  public static int getNetworkType(Context paramContext)
  {
    return getPsType(getActiveNetworkInfo(paramContext));
  }
  
  private static int getPsType(NetworkInfo paramNetworkInfo)
  {
    if ((paramNetworkInfo != null) && (paramNetworkInfo.isConnected()))
    {
      if (paramNetworkInfo.getType() == 1) {
        return 1;
      }
      if (paramNetworkInfo.getType() == 0)
      {
        switch (paramNetworkInfo.getSubtype())
        {
        default: 
          return 6;
        case 13: 
        case 14: 
          return 4;
        case 3: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 15: 
          return 3;
        }
        return 2;
      }
    }
    return 0;
  }
  
  public static boolean hasActiveNetwork(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
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
  
  public static final class NetType
  {
    public static final int NET = -2;
    public static final int TYPE_2G = 2;
    public static final int TYPE_3G = 3;
    public static final int TYPE_4G = 4;
    public static final int TYPE_5G = 5;
    public static final int TYPE_NEED_INIT = -1;
    public static final int TYPE_OTHER = 6;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_WIFI = 1;
    public static final int WAP = -3;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\utils\NetworkUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */