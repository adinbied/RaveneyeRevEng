package dji.midware.wifi;

import android.content.Context;
import android.database.ContentObserver;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkRequest;
import android.net.NetworkRequest.Builder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import dji.log.DJILogHelper;
import dji.midware.util.BackgroundLooper;
import java.net.Socket;
import javax.net.SocketFactory;

public class DJIMultiNetworkMgr
{
  private static boolean DEBUG = true;
  private static final int DELAY_NORMAL = 2000;
  private static final int DELAY_SHORT = 500;
  public static String LOG_FILE_NAME = "MultiNetworkLog";
  private static final int MSG_GET_MOBILE_NETWORK = 3;
  private static final int MSG_RETRY_DETECT_ENABLE = 1;
  private static final int MSG_RETRY_DETECT_ENABLE_TIMEOUT = 2;
  private static final String TAG = DJIMultiNetworkMgr.class.getSimpleName();
  private NetworkRequest.Builder builder;
  private volatile boolean isCheckingMobileData;
  private Handler mBackHandler = new Handler(BackgroundLooper.getLooper(), new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      return false;
    }
  });
  private boolean mCallbackRegistered;
  private ConnectivityManager mConnectMgr;
  private Context mContext;
  private boolean mEnabled;
  private boolean mIsMobileEnabled;
  private MobileRunnable mMobileDataChecker;
  private Network mMobileNetwork;
  private ConnectivityManager.NetworkCallback mNetworkCallback;
  int mRetryTime = 0;
  private SocketFactory mSf;
  private Network mWifiNetwork;
  private NetworkRequest networkRequest;
  
  private boolean bindNetwork(Network paramNetwork)
  {
    return false;
  }
  
  private boolean canOpen()
  {
    return false;
  }
  
  /* Error */
  private void checkForEnable()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void close()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean detectMobileEnabled()
  {
    return false;
  }
  
  public static final DJIMultiNetworkMgr getInstance()
  {
    return SingletonHolder.INSTANCE;
  }
  
  private Network getNetworkObject(int paramInt)
  {
    return null;
  }
  
  private void initNetworkCallback()
  {
    this.mNetworkCallback = new ConnectivityManager.NetworkCallback()
    {
      /* Error */
      public void onAvailable(Network arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
      
      /* Error */
      public void onLost(Network arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    };
  }
  
  private boolean isMobileDataConnected()
  {
    return false;
  }
  
  private boolean isMobileEnabled()
  {
    return false;
  }
  
  private boolean isSimReady()
  {
    return false;
  }
  
  public static boolean isVersionSupported()
  {
    return (Build.VERSION.SDK_INT >= 23) && (!Build.VERSION.RELEASE.equals("6.0"));
  }
  
  private boolean isWifiConnected()
  {
    return false;
  }
  
  private boolean isWifiConnectedOrConnecting()
  {
    return false;
  }
  
  private static void log(String paramString)
  {
    if (DEBUG)
    {
      DJILogHelper.getInstance().LOGD(TAG, paramString);
      return;
    }
    logE(paramString);
  }
  
  private static void log(String paramString1, String paramString2)
  {
    if (DEBUG)
    {
      logE(paramString1, paramString2);
      return;
    }
    DJILogHelper.getInstance().LOGD(paramString1, paramString2);
  }
  
  private static void logE(String paramString)
  {
    DJILogHelper.getInstance().LOGE(TAG, paramString, LOG_FILE_NAME);
  }
  
  private static void logE(String paramString1, String paramString2)
  {
    DJILogHelper.getInstance().LOGE(paramString1, paramString2, LOG_FILE_NAME);
  }
  
  private boolean reflectMobileEnabled()
  {
    return false;
  }
  
  /* Error */
  private void setNetwork(Network arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void startMobileCheckerThread()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void unregisterNetworkCallback()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void bindSocketWithWIFI(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  /* Error */
  public void bindSocketWithWIFI(Socket arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void checkForDisable()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Socket getSocket()
  {
    return null;
  }
  
  public Network getWifiNetwork()
  {
    return getNetworkObject(1);
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void handleDataEvent(dji.midware.data.manager.P3.DataEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void init(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isEnabled()
  {
    return this.mEnabled;
  }
  
  private class MobileRunnable
    implements Runnable
  {
    public MobileRunnable()
    {
      DJIMultiNetworkMgr.log(DJIMultiNetworkMgr.TAG, "new MobileRunnable");
    }
    
    private boolean pingURL(Network paramNetwork, String paramString, int paramInt)
    {
      return false;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  public class SettingsObserver
    extends ContentObserver
  {
    public SettingsObserver()
    {
      super();
    }
    
    /* Error */
    public void onChange(boolean arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
  }
  
  private static class SingletonHolder
  {
    private static final DJIMultiNetworkMgr INSTANCE = new DJIMultiNetworkMgr(null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\wifi\DJIMultiNetworkMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */