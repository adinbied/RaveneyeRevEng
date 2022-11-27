package dji.utils;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;

public class NetworkUtils
{
  private static NetworkInfo getActiveNetworkInfo(Context paramContext)
  {
    if (paramContext != null) {
      paramContext = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
    } else {
      paramContext = (ConnectivityManager)AppUtils.getApp().getSystemService("connectivity");
    }
    if (paramContext == null) {
      return null;
    }
    return paramContext.getActiveNetworkInfo();
  }
  
  public static String getIPAddress(boolean paramBoolean)
  {
    Object localObject2;
    int i;
    label172:
    do
    {
      do
      {
        do
        {
          try
          {
            localObject1 = NetworkInterface.getNetworkInterfaces();
            localObject2 = new LinkedList();
            while (((Enumeration)localObject1).hasMoreElements())
            {
              Object localObject3 = (NetworkInterface)((Enumeration)localObject1).nextElement();
              if ((((NetworkInterface)localObject3).isUp()) && (!((NetworkInterface)localObject3).isLoopback()))
              {
                localObject3 = ((NetworkInterface)localObject3).getInetAddresses();
                while (((Enumeration)localObject3).hasMoreElements()) {
                  ((LinkedList)localObject2).addFirst(((Enumeration)localObject3).nextElement());
                }
              }
            }
            localObject1 = ((LinkedList)localObject2).iterator();
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localObject2 = (InetAddress)((Iterator)localObject1).next();
            } while (((InetAddress)localObject2).isLoopbackAddress());
            localObject2 = ((InetAddress)localObject2).getHostAddress();
            if (((String)localObject2).indexOf(':') >= 0) {
              break label172;
            }
            i = 1;
          }
          catch (SocketException localSocketException)
          {
            Object localObject1;
            localSocketException.printStackTrace();
          }
        } while (i != 0);
        i = ((String)localObject2).indexOf('%');
        if (i < 0) {
          return ((String)localObject2).toUpperCase();
        }
        localObject1 = ((String)localObject2).substring(0, i).toUpperCase();
        return (String)localObject1;
        return "";
        i = 0;
      } while (!paramBoolean);
    } while (i == 0);
    return (String)localObject2;
  }
  
  public static NetworkType getNetworkType(Context paramContext)
  {
    NetworkType localNetworkType = NetworkType.NETWORK_NO;
    NetworkInfo localNetworkInfo = getActiveNetworkInfo(paramContext);
    paramContext = localNetworkType;
    if (localNetworkInfo != null)
    {
      paramContext = localNetworkType;
      if (localNetworkInfo.isAvailable())
      {
        if (localNetworkInfo.getType() == 9) {
          return NetworkType.NETWORK_ETHERNET;
        }
        if (localNetworkInfo.getType() == 1) {
          return NetworkType.NETWORK_WIFI;
        }
        if (localNetworkInfo.getType() == 0)
        {
          switch (localNetworkInfo.getSubtype())
          {
          default: 
            paramContext = localNetworkInfo.getSubtypeName();
            if ((!paramContext.equalsIgnoreCase("TD-SCDMA")) && (!paramContext.equalsIgnoreCase("WCDMA"))) {
              if (!paramContext.equalsIgnoreCase("CDMA2000")) {}
            }
            break;
          case 13: 
          case 18: 
            paramContext = NetworkType.NETWORK_4G;
            break;
          case 3: 
          case 5: 
          case 6: 
          case 8: 
          case 9: 
          case 10: 
          case 12: 
          case 14: 
          case 15: 
          case 17: 
            paramContext = NetworkType.NETWORK_3G;
            break;
          case 1: 
          case 2: 
          case 4: 
          case 7: 
          case 11: 
          case 16: 
            paramContext = NetworkType.NETWORK_2G;
          }
          for (;;)
          {
            return paramContext;
            paramContext = NetworkType.NETWORK_UNKNOWN;
            continue;
            paramContext = NetworkType.NETWORK_3G;
          }
        }
        paramContext = NetworkType.NETWORK_UNKNOWN;
      }
    }
    return paramContext;
  }
  
  public static String getWifiSSID(Context paramContext)
  {
    if (!isWifiConnected(paramContext)) {
      return "";
    }
    paramContext = ((WifiManager)paramContext.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
    if (paramContext == null) {
      return "";
    }
    return paramContext.getSSID().replaceAll("\"", "");
  }
  
  public static boolean is4GConnected(Context paramContext)
  {
    paramContext = getActiveNetworkInfo(paramContext);
    return (paramContext != null) && (paramContext.isAvailable()) && (paramContext.getSubtype() == 13);
  }
  
  public static boolean is5GHzBandSupported(Context paramContext)
  {
    paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
    if (Build.VERSION.SDK_INT >= 22) {
      return paramContext.is5GHzBandSupported();
    }
    return true;
  }
  
  public static boolean isAvailabeleByPing()
  {
    return isAvailableByPing(null);
  }
  
  public static boolean isAvailableByPing(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "223.5.5.5";
    }
    try
    {
      paramString = Runtime.getRuntime();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ping -c 3 -w 100 ");
      localStringBuilder.append(str);
      int i = paramString.exec(localStringBuilder.toString()).waitFor();
      return i == 0;
    }
    catch (InterruptedException paramString)
    {
      paramString.printStackTrace();
      return false;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public static boolean isNetworkConnected(Context paramContext)
  {
    paramContext = getActiveNetworkInfo(paramContext);
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    boolean bool1 = false;
    if ((i >= 23) && (paramContext != null) && (paramContext.getType() == 1))
    {
      if (paramContext.getState() == NetworkInfo.State.CONNECTED) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (paramContext.isConnected()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean isUsingMobileData(Context paramContext)
  {
    paramContext = getActiveNetworkInfo(paramContext);
    return (paramContext != null) && (paramContext.isAvailable()) && (paramContext.getType() == 0);
  }
  
  public static boolean isWifiAvailable(Context paramContext, String paramString)
  {
    return (isWifiConnected(paramContext)) && (isAvailableByPing(paramString));
  }
  
  public static boolean isWifiConnected(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
    boolean bool = false;
    if (paramContext != null) {
      try
      {
        if (Build.VERSION.SDK_INT < 22)
        {
          paramContext = paramContext.getNetworkInfo(1);
          if ((paramContext != null) && (paramContext.isConnected())) {
            return true;
          }
        }
        else
        {
          Object localObject = paramContext.getAllNetworks();
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            NetworkInfo localNetworkInfo = paramContext.getNetworkInfo(localObject[i]);
            if ((localNetworkInfo != null) && (localNetworkInfo.getType() == 1))
            {
              paramContext = localNetworkInfo.getState();
              localObject = NetworkInfo.State.CONNECTED;
              if (paramContext == localObject) {
                bool = true;
              }
              return bool;
            }
            i += 1;
          }
          return false;
        }
      }
      catch (RuntimeException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return false;
  }
  
  public static enum NetworkType
  {
    static
    {
      NETWORK_4G = new NetworkType("NETWORK_4G", 2);
      NETWORK_3G = new NetworkType("NETWORK_3G", 3);
      NETWORK_2G = new NetworkType("NETWORK_2G", 4);
      NETWORK_UNKNOWN = new NetworkType("NETWORK_UNKNOWN", 5);
      NetworkType localNetworkType = new NetworkType("NETWORK_NO", 6);
      NETWORK_NO = localNetworkType;
      $VALUES = new NetworkType[] { NETWORK_ETHERNET, NETWORK_WIFI, NETWORK_4G, NETWORK_3G, NETWORK_2G, NETWORK_UNKNOWN, localNetworkType };
    }
    
    private NetworkType() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dj\\utils\NetworkUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */