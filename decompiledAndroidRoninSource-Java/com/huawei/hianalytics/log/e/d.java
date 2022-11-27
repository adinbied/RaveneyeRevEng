package com.huawei.hianalytics.log.e;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.huawei.hianalytics.g.b;
import java.io.Closeable;
import java.io.IOException;

public class d
{
  private static String a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      if ((!paramString.equalsIgnoreCase("TD-SCDMA")) && (!paramString.equalsIgnoreCase("WCDMA")))
      {
        str = paramString;
        if (!paramString.equalsIgnoreCase("CDMA2000")) {
          return str;
        }
      }
      break;
    case 13: 
      return "4G";
    case 3: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    case 14: 
    case 15: 
      return "3G";
    }
    String str = "2G";
    return str;
  }
  
  public static String a(Context paramContext)
  {
    Object localObject1 = "";
    if ((paramContext != null) && (paramContext.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", paramContext.getPackageName()) == 0))
    {
      Object localObject2 = (ConnectivityManager)paramContext.getSystemService("connectivity");
      paramContext = (Context)localObject1;
      if (localObject2 != null)
      {
        localObject2 = ((ConnectivityManager)localObject2).getActiveNetworkInfo();
        paramContext = (Context)localObject1;
        if (localObject2 != null)
        {
          paramContext = (Context)localObject1;
          if (((NetworkInfo)localObject2).isConnected())
          {
            if (((NetworkInfo)localObject2).getType() == 1) {
              return "WIFI";
            }
            if (((NetworkInfo)localObject2).getType() == 0)
            {
              paramContext = ((NetworkInfo)localObject2).getSubtypeName();
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Network getSubtypeName : ");
              ((StringBuilder)localObject1).append(paramContext);
              b.b("HiAnalytics/event", ((StringBuilder)localObject1).toString());
              return a(((NetworkInfo)localObject2).getSubtype(), paramContext);
            }
            paramContext = (Context)localObject1;
            if (((NetworkInfo)localObject2).getType() == 16)
            {
              paramContext = "COMPANION_PROXY";
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("type name = ");
              ((StringBuilder)localObject1).append("COMPANION_PROXY");
              b.c("HiAnalytics/event", ((StringBuilder)localObject1).toString());
            }
          }
        }
      }
      return paramContext;
    }
    b.c("HiAnalytics/event", "not have network state phone permission!");
    return "";
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
    b.c("LogStreamUtil", "closeQuietly(): Exception when closing the closeable!");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\log\e\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */