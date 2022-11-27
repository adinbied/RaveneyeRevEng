package dji.midware.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import dji.log.RoninLog;
import dji.midware.encryption.util.FeatureFlagEngine;
import java.util.concurrent.atomic.AtomicBoolean;

public class NetworkUtils
{
  private static final String BASE_URL = "developer.dji.com";
  private static final String TAG = NetworkUtils.class.getSimpleName();
  private static AtomicBoolean isChecking = new AtomicBoolean(false);
  private static AtomicBoolean isLDMEnabled = new AtomicBoolean(false);
  private static AtomicBoolean isOnline;
  
  private static void checkIsDJIBlocked()
  {
    if (isChecking.compareAndSet(false, true)) {
      new Thread(new Runnable()
      {
        /* Error */
        public void run()
        {
          // Byte code:
          //   0: return
          //   1: astore_1
          //   2: return
        }
      }).start();
    }
  }
  
  public static boolean isLDMEnabled()
  {
    return isLDMEnabled.get();
  }
  
  public static boolean isOnline()
  {
    if (isOnline == null)
    {
      isOnline = new AtomicBoolean(false);
      refreshConnectivity();
    }
    return isOnline.get();
  }
  
  public static void refreshConnectivity()
  {
    Object localObject = ContextUtil.getContext();
    if (!shouldAllowNetworkAccess())
    {
      isOnline.set(false);
      return;
    }
    if (localObject == null)
    {
      isOnline.set(false);
      return;
    }
    boolean bool1 = true;
    try
    {
      localObject = ((ConnectivityManager)((Context)localObject).getSystemService("connectivity")).getActiveNetworkInfo();
      if (localObject != null)
      {
        boolean bool2 = ((NetworkInfo)localObject).isConnectedOrConnecting();
        if (bool2) {}
      }
      else
      {
        bool1 = false;
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;) {}
    }
    RoninLog.i(TAG, "Don't have permission to check connectivity, will assume we are online", new Object[0]);
    if (isOnline == null) {
      isOnline = new AtomicBoolean(false);
    }
    isOnline.set(bool1);
    if (bool1) {
      checkIsDJIBlocked();
    }
  }
  
  public static void setLDMEnabled(boolean paramBoolean)
  {
    isLDMEnabled.set(paramBoolean);
  }
  
  public static boolean shouldAllowNetworkAccess()
  {
    return (!FeatureFlagEngine.getInstance().isSilentModeRequired()) && (!isLDMEnabled.get());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midwar\\util\NetworkUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */