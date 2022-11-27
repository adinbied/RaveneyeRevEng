package dji.internal.network;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import dji.midware.util.DjiSharedPreferencesManager;
import java.util.Iterator;
import java.util.List;

public class WifiHelper
{
  private static final boolean IS_SUPPORT_SCAN_WIFI = true;
  public static final String KEY_PHONE_SUPPORT_5G = "key_phone_support_5g";
  
  public static boolean isSupport5G(Context paramContext)
  {
    boolean bool2 = DjiSharedPreferencesManager.getBoolean(paramContext, "key_phone_support_5g", false);
    if (bool2) {
      return true;
    }
    Object localObject = (WifiManager)paramContext.getSystemService("wifi");
    if ((Build.VERSION.SDK_INT >= 21) && (((WifiManager)localObject).is5GHzBandSupported())) {}
    boolean bool1;
    for (;;)
    {
      bool1 = true;
      break;
      bool1 = bool2;
      if (!((WifiManager)localObject).isWifiEnabled()) {
        break;
      }
      localObject = ((WifiManager)localObject).getScanResults().iterator();
      do
      {
        bool1 = bool2;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (((ScanResult)((Iterator)localObject).next()).frequency < 5000);
    }
    DjiSharedPreferencesManager.putBoolean(paramContext, "key_phone_support_5g", bool1);
    return bool1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\network\WifiHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */