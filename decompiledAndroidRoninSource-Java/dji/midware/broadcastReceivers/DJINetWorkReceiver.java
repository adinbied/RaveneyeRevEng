package dji.midware.broadcastReceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import dji.log.DJILog;
import dji.midware.data.manager.Dpad.DpadProductManager;
import dji.midware.link.DJILinkDaemonService;
import dji.midware.link.DJILinkType;
import dji.midware.util.NetworkUtils;
import dji.midware.util.ProcessUtils;
import dji.midware.wifi.DJIMultiNetworkMgr;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeoutException;

public class DJINetWorkReceiver
  extends BroadcastReceiver
{
  private static volatile boolean isConnected;
  private static boolean isOnline;
  private static long pingTime;
  
  public DJINetWorkReceiver() {}
  
  public DJINetWorkReceiver(Context paramContext)
  {
    DJIMultiNetworkMgr.getInstance().init(paramContext);
    checkNetworkStatus(paramContext);
  }
  
  /* Error */
  private void checkNetworkStatus(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static boolean getNetWorkStatus(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    boolean bool = false;
    Object localObject;
    if (paramContext != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("networkInfo : ");
      ((StringBuilder)localObject).append(paramContext.toString());
      DJILog.d("getMockNetWorkStatus", ((StringBuilder)localObject).toString(), new Object[0]);
    }
    else
    {
      DJILog.d("getMockNetWorkStatus", "networkInfo null", new Object[0]);
    }
    if ((paramContext != null) && (paramContext.isConnected()))
    {
      if ((DpadProductManager.getInstance().isDpad()) && (paramContext.getType() == 9)) {
        return false;
      }
      if (DJIMultiNetworkMgr.getInstance().isEnabled()) {
        return true;
      }
      localObject = DJILinkDaemonService.getInstance();
      if ((paramContext.getType() == 1) && (localObject != null))
      {
        if (((DJILinkDaemonService)localObject).getLinkType() != DJILinkType.WIFI) {
          bool = true;
        }
        return bool;
      }
      return true;
    }
    return false;
  }
  
  public static boolean getNetWorkStatusNoPing(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (paramContext != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("networkInfo : ");
      localStringBuilder.append(paramContext.toString());
      DJILog.d("getMockNetWorkStatus", localStringBuilder.toString(), new Object[0]);
    }
    else
    {
      DJILog.d("getMockNetWorkStatus", "networkInfo null", new Object[0]);
    }
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  private static NetworkInfo getNetworkInfo_23(Context paramContext, int paramInt)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null)
    {
      Network[] arrayOfNetwork = paramContext.getAllNetworks();
      if ((arrayOfNetwork != null) && (arrayOfNetwork.length > 0))
      {
        int j = arrayOfNetwork.length;
        int i = 0;
        while (i < j)
        {
          NetworkInfo localNetworkInfo = paramContext.getNetworkInfo(arrayOfNetwork[i]);
          if ((localNetworkInfo != null) && (localNetworkInfo.getType() == paramInt)) {
            return localNetworkInfo;
          }
          i += 1;
        }
      }
    }
    return null;
  }
  
  private static NetworkInfo getNetworkInfo_below23(Context paramContext, int paramInt)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null) {
      return paramContext.getNetworkInfo(paramInt);
    }
    return null;
  }
  
  public static boolean isConnected()
  {
    return isConnected;
  }
  
  public static boolean isMobileDataEnable(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    Class localClass = paramContext.getClass();
    try
    {
      boolean bool = ((Boolean)localClass.getMethod("getMobileDataEnabled", null).invoke(paramContext, null)).booleanValue();
      if (bool == true) {
        return true;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean isNetworkConnectedByType(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      paramContext = getNetworkInfo_23(paramContext, paramInt);
    } else {
      paramContext = getNetworkInfo_below23(paramContext, paramInt);
    }
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  public static boolean isNetworkConnectedOrConnectingByType(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      paramContext = getNetworkInfo_23(paramContext, paramInt);
    } else {
      paramContext = getNetworkInfo_below23(paramContext, paramInt);
    }
    return (paramContext != null) && (paramContext.isConnectedOrConnecting());
  }
  
  public static boolean isNetworkOnline()
  {
    for (;;)
    {
      try
      {
        bool = NetworkUtils.shouldAllowNetworkAccess();
        if (!bool) {
          return false;
        }
        long l = System.currentTimeMillis();
        if (l - pingTime < 1000L)
        {
          bool = isOnline;
          return bool;
        }
        try
        {
          if (ProcessUtils.executeCommand("ping -c 1 www.dji.com", 200L) != 0) {
            break label100;
          }
          bool = true;
          isOnline = bool;
        }
        catch (TimeoutException localTimeoutException) {}catch (InterruptedException localInterruptedException) {}catch (IOException localIOException) {}
        localIOException.printStackTrace();
        isOnline = false;
        pingTime = l;
        bool = isOnline;
        return bool;
      }
      finally {}
      label100:
      boolean bool = false;
    }
  }
  
  public static boolean isUsingSimNetwork(Context paramContext)
  {
    return ((getNetWorkStatus(paramContext)) && (!isWifiConnected(paramContext))) || (DJIMultiNetworkMgr.getInstance().isEnabled());
  }
  
  public static boolean isWifiConnected(Context paramContext)
  {
    if (isNetworkConnectedByType(paramContext, 1))
    {
      DJILog.i("isWifiConnected", "connect", new Object[0]);
      return true;
    }
    DJILog.i("isWifiConnected", "unconnect", new Object[0]);
    return false;
  }
  
  /* Error */
  public void onReceive(Context arg1, android.content.Intent arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum DJINetWorkStatusEvent
  {
    static
    {
      CONNECT_LOSE = new DJINetWorkStatusEvent("CONNECT_LOSE", 2);
      WIFI_CHANGED = new DJINetWorkStatusEvent("WIFI_CHANGED", 3);
      DJINetWorkStatusEvent localDJINetWorkStatusEvent = new DJINetWorkStatusEvent("CONNECT_LOSE_WIFI", 4);
      CONNECT_LOSE_WIFI = localDJINetWorkStatusEvent;
      $VALUES = new DJINetWorkStatusEvent[] { CONNECT_OK, CONNECT_OK_WIFI, CONNECT_LOSE, WIFI_CHANGED, localDJINetWorkStatusEvent };
    }
    
    private DJINetWorkStatusEvent() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\broadcastReceivers\DJINetWorkReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */