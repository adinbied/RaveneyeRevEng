package com.ronin.connect.wificonnect.manager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.NetworkInfo.State;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.ronin.connect.wificonnect.bean.ConnectWiFiInfo;
import com.ronin.connect.wificonnect.bean.DJIWifiBean;
import com.ronin.connect.wificonnect.bean.DJIWifiCipherType;
import com.ronin.connect.wificonnect.helper.WiFiRepeatTipHelper;
import com.ronin.connect.wificonnect.presenter.DJIWifiConnectPresenter.NewWifiApiConnectState;
import java.util.ArrayList;
import java.util.List;

public class DJIWifiConnectManager
{
  public static final String REGEX_QUOTATION = "\"";
  public static final String RONIN_WIFI_PREFIX = "RavenEye";
  private static final String TAG = DJIWifiConnectManager.class.getSimpleName();
  private static final int WIFI_CONNECT_TIMEOUT_MS = 5000;
  private static volatile DJIWifiConnectManager instance;
  private ConnectivityManager mConnManager;
  public Context mContext;
  private long mStartConnectTime;
  private WifiManager mWifiManager;
  private WiFiRepeatTipHelper wiFiRepeatTipHelper;
  
  /* Error */
  private void connectCallback(DJIWifiConnectPresenter.NewWifiApiConnectState arg1, com.ronin.connect.wificonnect.bean.NetworkConnectState arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static String getCapabilitiesString(String paramString)
  {
    if (paramString.contains("WEP")) {
      return "WEP";
    }
    if ((!paramString.contains("WPA")) && (!paramString.contains("WPA2")) && (!paramString.contains("WPS"))) {
      return "OPEN";
    }
    return "WPA/WPA2";
  }
  
  public static DJIWifiConnectManager getInstance()
  {
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new DJIWifiConnectManager();
        }
      }
      finally {}
    }
    return instance;
  }
  
  public static int getLevel(int paramInt)
  {
    if (Math.abs(paramInt) < 50) {
      return 1;
    }
    if (Math.abs(paramInt) < 75) {
      return 2;
    }
    if (Math.abs(paramInt) < 90) {
      return 3;
    }
    return 4;
  }
  
  public static void getReplace(List<DJIWifiBean> paramList)
  {
    WifiInfo localWifiInfo = getInstance().getConnectWifiInfo();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(paramList);
    int i = 0;
    while (i < paramList.size())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("\"");
      localStringBuilder.append(((DJIWifiBean)paramList.get(i)).getWifiName());
      localStringBuilder.append("\"");
      if (localStringBuilder.toString().equals(localWifiInfo.getSSID()))
      {
        localArrayList.add(0, paramList.get(i));
        localArrayList.remove(i + 1);
        ((DJIWifiBean)localArrayList.get(0)).setState(NetworkInfo.State.CONNECTED);
      }
      i += 1;
    }
    paramList.clear();
    paramList.addAll(localArrayList);
  }
  
  private ConnectWiFiInfo newConnectWifi(WifiConfiguration paramWifiConfiguration)
  {
    return null;
  }
  
  /* Error */
  private void updateWifiConfig(String arg1, String arg2, WifiConfiguration arg3, DJIWifiCipherType arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String changeToSystemWifiSSID(String paramString)
  {
    return null;
  }
  
  /* Error */
  public void closeWifi()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public ConnectWiFiInfo connectWifi(String paramString1, String paramString2, DJIWifiCipherType paramDJIWifiCipherType)
  {
    return null;
  }
  
  /* Error */
  public void connectWifi(String arg1, String arg2, String arg3, DJIWifiConnectPresenter.NewWifiApiConnectState arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean connectWifi(WifiConfiguration paramWifiConfiguration)
  {
    return false;
  }
  
  public WifiConfiguration createWifiConfig(String paramString1, String paramString2, DJIWifiCipherType paramDJIWifiCipherType)
  {
    return null;
  }
  
  public List getConfigurations()
  {
    return null;
  }
  
  public ConnectivityManager getConnManager()
  {
    return this.mConnManager;
  }
  
  public WifiInfo getConnectWifiInfo()
  {
    return null;
  }
  
  public String getRoninConnectedWifiName()
  {
    return null;
  }
  
  public DJIWifiCipherType getWifiCipher(String paramString)
  {
    return null;
  }
  
  public WifiConfiguration getWifiConfigurationBySSID(String paramString)
  {
    return null;
  }
  
  public List<ScanResult> getWifiScanResult()
  {
    return null;
  }
  
  public int getWifiState()
  {
    return 0;
  }
  
  /* Error */
  public void init(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isRoninSSID(String paramString)
  {
    return false;
  }
  
  public boolean isSupport5G()
  {
    return false;
  }
  
  public boolean isValidSSID(String paramString)
  {
    return false;
  }
  
  public boolean isWifiEnabled()
  {
    return false;
  }
  
  /* Error */
  public void openWifi()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean startWifiScan()
  {
    return false;
  }
  
  public boolean useNewWiFiConnectApi()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\ronin\connect\wificonnect\manager\DJIWifiConnectManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */