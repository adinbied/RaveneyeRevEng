package com.ronin.connect.wificonnect.presenter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.CountDownTimer;
import com.dji.ronin.uilib.mvp.DJIMvpBasePresenter;
import com.dji.rx.sharedlib.SharedLibPushPublishObservable;
import com.ronin.connect.wificonnect.bean.ConnectWiFiInfo;
import com.ronin.connect.wificonnect.bean.DJIWifiBean;
import com.ronin.connect.wificonnect.bean.DJIWifiCipherType;
import com.ronin.connect.wificonnect.bean.NetworkConnectState;
import com.ronin.connect.wificonnect.contract.DJIIWifiConnectContract.IWifiConnectPresenter;
import com.ronin.connect.wificonnect.contract.DJIIWifiConnectContract.IWifiConnectView;
import com.ronin.connect.wificonnect.manager.DJIWifiConnectManager;
import dji.sdksharedlib.extension.KeyHelper;
import io.reactivex.Completable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;

public class DJIWifiConnectPresenter
  extends DJIMvpBasePresenter<DJIIWifiConnectContract.IWifiConnectView>
  implements DJIIWifiConnectContract.IWifiConnectPresenter
{
  private static final int COUNT_DOWN_INTERVAL = 2000;
  private static final String KEY_MONITOR_NO_MORE_TIP = "monitor_no_more_tip";
  private static final int MAX_SEARCH_COUNT = 4;
  private static final int MILLIS_IN_FUTURE = 8000;
  private static final String TAG = DJIWifiConnectPresenter.class.getSimpleName();
  private CountDownTimer animTimer = new CountDownTimer(8000L, 2000L)
  {
    /* Error */
    public void onFinish()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onTick(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  };
  private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
  private String mConnectedWiFiSSID = "";
  private String mConnectedWifiPwd;
  private SharedLibPushPublishObservable<Boolean> mHasMonitorObservable = new SharedLibPushPublishObservable(KeyHelper.getProductKey("HasMonitor"));
  private boolean mIsConnecting;
  private SharedLibPushPublishObservable<Boolean> mIsMonitorObservable = new SharedLibPushPublishObservable(KeyHelper.getProductKey("IsMonitor"));
  private boolean mPasswordChanged;
  private SharedLibPushPublishObservable<String> mPasswordObservable = new SharedLibPushPublishObservable(KeyHelper.getMonitorKey("Password"));
  private Disposable mScanWifi;
  private DJIWifiBean mWifiConnectedBean = new DJIWifiBean();
  private DJIWifiBean mWifiConnectingBean = new DJIWifiBean();
  private List<DJIWifiBean> mWifiList = new ArrayList();
  private WifiBroadcastReceiver mWifiReceiver = new WifiBroadcastReceiver();
  private SharedLibPushPublishObservable<String> mWifiSSIDObservable = new SharedLibPushPublishObservable(KeyHelper.getMonitorKey("WifiSSID"));
  private DJIWifiBean mWifiStartConnectBean = new DJIWifiBean();
  
  public DJIWifiConnectPresenter(DJIIWifiConnectContract.IWifiConnectView paramIWifiConnectView)
  {
    attachView(paramIWifiConnectView);
  }
  
  /* Error */
  private void dismissDialog()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void dismissSearchingView()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private Network getNetworkObject(ConnectivityManager paramConnectivityManager, int paramInt)
  {
    return null;
  }
  
  /* Error */
  private void onWiFiConnected(Context arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private void onWiFiDisconnected()
  {
    this.mConnectedWiFiSSID = "";
  }
  
  private void startAnimTimer()
  {
    CountDownTimer localCountDownTimer = this.animTimer;
    if (localCountDownTimer != null) {
      localCountDownTimer.start();
    }
  }
  
  /* Error */
  private void stopAnimTimer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateConnectedWifi(String arg1, android.net.NetworkInfo.State arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateConnectingWifi(android.net.NetworkInfo.State arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateDisConnectWifi(android.net.NetworkInfo.State arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateList()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateWifiConnect(String arg1, android.net.NetworkInfo.State arg2)
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
  public void connectWifi(String arg1, String arg2, String arg3, dji.common.util.CommonCallbacks.CompletionCallbackWith<Boolean> arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void getScanLists()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String getWifiPassword()
  {
    return this.mConnectedWifiPwd;
  }
  
  public int getWifiState()
  {
    return 0;
  }
  
  public void initWifiConnectManager(Context paramContext)
  {
    DJIWifiConnectManager.getInstance().init(paramContext);
  }
  
  public boolean isConnecting()
  {
    return this.mIsConnecting;
  }
  
  public boolean isWifiEnabled()
  {
    return false;
  }
  
  public boolean isWifiListEmpty()
  {
    return false;
  }
  
  public boolean needUseNewWifiConnect()
  {
    return false;
  }
  
  /* Error */
  public void notTipAnyMore()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onAttached(DJIIWifiConnectContract.IWifiConnectView arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onDetached()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.MAIN)
  public void onWiFiConnectError(NetworkConnectState arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Completable performPasswordChange(String paramString)
  {
    return null;
  }
  
  /* Error */
  public void registerRecever()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setConnecting(boolean paramBoolean)
  {
    this.mIsConnecting = paramBoolean;
  }
  
  public void setPasswordChanged(boolean paramBoolean)
  {
    this.mPasswordChanged = paramBoolean;
  }
  
  /* Error */
  public void startScheduleWifiScan()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void stopScheduleWifiScan()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void unregisterRecever()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void updateList(List<DJIWifiBean> paramList) {}
  
  public boolean wifiNoNeedPwd(String paramString)
  {
    return false;
  }
  
  public static abstract interface NewWifiApiConnectState
  {
    public abstract void onNewWifiConnectState(NetworkConnectState paramNetworkConnectState);
  }
  
  public class WifiBroadcastReceiver
    extends BroadcastReceiver
  {
    public WifiBroadcastReceiver() {}
    
    /* Error */
    public void onReceive(Context arg1, android.content.Intent arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\ronin\connect\wificonnect\presenter\DJIWifiConnectPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */