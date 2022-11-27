package dji.logic.manager;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import dji.midware.data.config.P3.Ccode;
import dji.midware.data.config.P3.ProductType;
import dji.midware.data.manager.P3.DataCameraEvent;
import dji.midware.data.manager.P3.DataEvent;
import dji.midware.data.model.P3.DataWifiSwitchSDR;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.sockets.P3.WifiService;
import dji.midware.usb.P3.UsbAccessoryService;
import dji.midware.util.BackgroundLooper;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class DJIUSBWifiSwitchManager
{
  private static final int CONNECT_CHECK_DELAY = 10000;
  private static final int MSG_NOT_CONNECT_REMOTE = 1;
  private static DJIUSBWifiSwitchManager mInstance;
  private boolean isJustSwitchFromWifi = false;
  private AlertDialog mCannotSwitchDlg;
  private Handler mHandler = new Handler(BackgroundLooper.getLooper(), new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      return false;
    }
  });
  private boolean mNeedShowRCConnectDlg = false;
  private AlertDialog mSwitchPromptDlg;
  private WifiConnectType mWifiConnectType = WifiConnectType.NONE;
  private UsbAccessoryService usbAccessoryService;
  private WifiService wifiService;
  
  private DJIUSBWifiSwitchManager()
  {
    EventBus.getDefault().register(this);
  }
  
  public static DJIUSBWifiSwitchManager getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new DJIUSBWifiSwitchManager();
      }
      DJIUSBWifiSwitchManager localDJIUSBWifiSwitchManager = mInstance;
      return localDJIUSBWifiSwitchManager;
    }
    finally {}
  }
  
  public WifiConnectType getWifiConnectType()
  {
    return this.mWifiConnectType;
  }
  
  public boolean isNeedShowRCConnectDlg()
  {
    return this.mNeedShowRCConnectDlg;
  }
  
  public boolean isProductAoaConnected(ProductType paramProductType)
  {
    return false;
  }
  
  public boolean isProductWifiConnected(ProductType paramProductType)
  {
    return false;
  }
  
  public boolean isRcWifiConnected(ProductType paramProductType)
  {
    return false;
  }
  
  public boolean isUSBAoaConnected()
  {
    return false;
  }
  
  public boolean isWifiConnected()
  {
    return false;
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataCameraEvent paramDataCameraEvent)
  {
    if (paramDataCameraEvent == DataCameraEvent.ConnectOK) {
      resetSwitchFromWifiFlag();
    }
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataEvent paramDataEvent) {}
  
  /* Error */
  public void resetSwitchFromWifiFlag()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setNeedShowRCConnectDlg(boolean paramBoolean)
  {
    this.mNeedShowRCConnectDlg = paramBoolean;
  }
  
  /* Error */
  public void showCannotSwitchDlg(Context arg1, String arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void showNotConnectDlg(Context arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void showRCConnectedDlg(Context arg1, String arg2, String arg3, String arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void showSwitchPromptDlg(Context arg1, String arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Deprecated
  public static enum SwitchUIAction
  {
    static
    {
      SwitchUIAction localSwitchUIAction = new SwitchUIAction("SHOW_NOT_CONNECT_DLG", 1);
      SHOW_NOT_CONNECT_DLG = localSwitchUIAction;
      $VALUES = new SwitchUIAction[] { SHOW_SWITCH_DLG, localSwitchUIAction };
    }
    
    private SwitchUIAction() {}
  }
  
  public static enum USBConnectAction
  {
    static
    {
      USBConnectAction localUSBConnectAction = new USBConnectAction("CONNECT_LOST", 0);
      CONNECT_LOST = localUSBConnectAction;
      $VALUES = new USBConnectAction[] { localUSBConnectAction };
    }
    
    private USBConnectAction() {}
  }
  
  public static enum WifiConnectType
  {
    static
    {
      WifiConnectType localWifiConnectType = new WifiConnectType("NONE", 1);
      NONE = localWifiConnectType;
      $VALUES = new WifiConnectType[] { CONTROL, localWifiConnectType };
    }
    
    private WifiConnectType() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logic\manager\DJIUSBWifiSwitchManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */