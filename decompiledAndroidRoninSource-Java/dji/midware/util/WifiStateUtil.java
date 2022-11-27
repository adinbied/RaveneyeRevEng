package dji.midware.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import com.dji.frame.interfaces.V_CallBack_ReceiveData;
import java.net.UnknownHostException;

public class WifiStateUtil
{
  private static boolean isWifiConnected;
  
  public static void getLevel(boolean paramBoolean, final V_CallBack_ReceiveData paramV_CallBack_ReceiveData)
  {
    new Thread(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    }).start();
  }
  
  public static void getRcLevel(boolean paramBoolean, final V_CallBack_ReceiveData paramV_CallBack_ReceiveData)
  {
    new Thread(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    }).start();
  }
  
  public static String getWifiSSID(Context paramContext)
  {
    if (!isWifiActive(paramContext)) {
      return "";
    }
    paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
    if (paramContext == null) {
      return "";
    }
    return paramContext.getSSID().replaceAll("\"", "");
  }
  
  public static boolean isWifiActive(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        int i = Build.VERSION.SDK_INT;
        bool = true;
        if (i < 23)
        {
          paramContext = paramContext.getNetworkInfo(1);
          if ((paramContext == null) || (paramContext.getState() != NetworkInfo.State.CONNECTED)) {
            break label157;
          }
          isWifiConnected = bool;
        }
        else
        {
          isWifiConnected = false;
          Network[] arrayOfNetwork = paramContext.getAllNetworks();
          if ((arrayOfNetwork != null) && (arrayOfNetwork.length > 0))
          {
            int j = arrayOfNetwork.length;
            i = 0;
            if (i < j)
            {
              NetworkInfo localNetworkInfo = paramContext.getNetworkInfo(arrayOfNetwork[i]);
              if (localNetworkInfo.getType() == 1)
              {
                if (localNetworkInfo.getState() != NetworkInfo.State.CONNECTED) {
                  break label162;
                }
                bool = true;
                isWifiConnected = bool;
              }
              i += 1;
              continue;
              isWifiConnected = false;
            }
          }
        }
      }
      catch (Exception paramContext)
      {
        isWifiConnected = false;
        paramContext.printStackTrace();
      }
      return isWifiConnected;
      label157:
      boolean bool = false;
      continue;
      label162:
      bool = false;
    }
  }
  
  public static int ping(String paramString, boolean paramBoolean)
  {
    long l1 = 0L;
    int j = 0;
    int i = 0;
    int m;
    int n;
    for (;;)
    {
      m = 3;
      n = 300;
      k = i;
      if (j >= 3) {
        break label98;
      }
      k = -1;
      long l2 = System.currentTimeMillis();
      try
      {
        boolean bool = ProcessUtils.isReachable(paramString, 300);
        if (bool) {
          k = 0;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      catch (UnknownHostException localUnknownHostException)
      {
        localUnknownHostException.printStackTrace();
      }
      if (k != 0) {
        break;
      }
      l1 += System.currentTimeMillis() - l2;
      i += 1;
      j += 1;
    }
    int k = 0;
    label98:
    i = n;
    if (k == 3)
    {
      j = (int)l1 / 3;
      if (j < 100)
      {
        i = 4;
        j = 0;
        break label173;
      }
      if (j < 250)
      {
        i = m;
        break label173;
      }
      if (j < 500)
      {
        i = 2;
        break label173;
      }
      i = j;
      if (j < 1000)
      {
        i = 1;
        break label173;
      }
    }
    k = 0;
    j = i;
    i = k;
    label173:
    if (paramBoolean) {
      return i;
    }
    i = (1000 - j) / 10;
    if (i < 0) {
      return 0;
    }
    return i;
  }
  
  public static boolean ping(String paramString, int paramInt)
  {
    try
    {
      boolean bool = ProcessUtils.isReachable(paramString, paramInt);
      return bool;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    catch (UnknownHostException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midwar\\util\WifiStateUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */