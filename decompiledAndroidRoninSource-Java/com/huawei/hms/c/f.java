package com.huawei.hms.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public abstract class f
{
  public static int a(Context paramContext)
  {
    return a(b(paramContext));
  }
  
  private static int a(NetworkInfo paramNetworkInfo)
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
  
  private static NetworkInfo b(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null) {
      return paramContext.getActiveNetworkInfo();
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */