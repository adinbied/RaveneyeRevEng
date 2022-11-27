package dji.midware.ble2;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import dji.midware.ble2.base.BleConnector;
import dji.midware.ble2.base.BleDataReceiveListener;
import dji.midware.ble2.base.BleDataTransmitter;
import dji.midware.ble2.base.BleDevice;
import dji.midware.ble2.base.BleLog;
import dji.midware.ble2.base.BleNotifier;
import dji.midware.ble2.base.BleScanFilter;
import dji.midware.ble2.base.BleScanner;
import dji.midware.ble2.base.BleState;
import java.util.List;

public class BleManager
{
  private static final String BLE_STATE_ACTION = "android.bluetooth.adapter.action.STATE_CHANGED";
  private static final String KEY_MANUFACTOR_SAMSUNG = "samsung";
  private static final String TAG = "BleManager";
  private static BleCallback mConnectKnownListener = new BleCallbackAdapter()
  {
    /* Error */
    public void onScanFinished(boolean arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onScanning(BleDevice arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onStartScan()
    {
      BleLog.logD("BleManager ConnectKnown onStartScan --- ");
    }
  };
  private final int MSG_CONNECT = 3;
  private final int MSG_DISCONNECT = 4;
  private final int MSG_RESET = 5;
  private final int MSG_SCAN = 1;
  private final int MSG_SCAN_STOP = 2;
  private final int MSG_SCAN_WAIT_ENABLE = 6;
  private final int MSG_SCAN_WAIT_ENABLE_TIMEOUT = 7;
  private boolean autoConnect = false;
  private BluetoothAdapter mBleAdapter;
  private BluetoothManager mBluetoothManager;
  private Context mContext = null;
  private boolean mIsBluetoothUpgrade = false;
  private boolean mIsInUpgradeMode = false;
  boolean mIsReceiverRegistered;
  private boolean mIsTranslateFwData = false;
  private MainHandler mMainHandler;
  private BleNotifier mNotifier;
  private ActionReceiver mReceiver;
  
  public static BleManager getInstance()
  {
    return SingletonHolder.instance;
  }
  
  /* Error */
  private void initBroadcastReceiver()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean isBleOk()
  {
    return false;
  }
  
  private boolean isSamSung()
  {
    return false;
  }
  
  /* Error */
  private void onBLEClosed()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void onBLEOpened()
  {
    startScan(BleConstants.DEFAULT_SCAN_TIMEOUT);
  }
  
  public void addListener(BleCallback paramBleCallback)
  {
    this.mNotifier.addListener(paramBleCallback);
  }
  
  /* Error */
  public void connect(BleDevice arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void connect(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void connectKnownDevice()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void disconnect()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void enableBluetooth()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public BleDevice getCurrentConnectedDevice()
  {
    return null;
  }
  
  public String getCurrentConnectedDeviceAddress()
  {
    return null;
  }
  
  public String getCurrentConnectedDeviceName()
  {
    return null;
  }
  
  public BleDevice getDeviceWithAddress(String paramString)
  {
    return null;
  }
  
  public int getMaxDataLength()
  {
    return 0;
  }
  
  public BleState getState()
  {
    return null;
  }
  
  /* Error */
  public void init(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isBluetoothEnabled()
  {
    return false;
  }
  
  public boolean isBluetoothUpgrade()
  {
    return this.mIsBluetoothUpgrade;
  }
  
  public boolean isConnectActive()
  {
    return false;
  }
  
  public boolean isDeviceConnected()
  {
    return false;
  }
  
  public boolean isInUpgradeMode()
  {
    return this.mIsInUpgradeMode;
  }
  
  public boolean isLinkTransOk()
  {
    return false;
  }
  
  public boolean isTranslateFwData()
  {
    return this.mIsTranslateFwData;
  }
  
  /* Error */
  public void removeKnownListener()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void removeListener(BleCallback arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void reset()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void sendData(byte[] paramArrayOfByte)
  {
    BleDataTransmitter.getInstance().sendData(paramArrayOfByte);
  }
  
  public void setAutoConnect(boolean paramBoolean)
  {
    this.autoConnect = paramBoolean;
  }
  
  public void setBluetoothUpgrade(boolean paramBoolean)
  {
    this.mIsBluetoothUpgrade = paramBoolean;
  }
  
  public void setDataListener(BleDataReceiveListener paramBleDataReceiveListener)
  {
    BleConnector.getInstance().setDataListener(paramBleDataReceiveListener);
  }
  
  /* Error */
  public void setInUpgradeMode(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void setScanFilter(List<BleScanFilter> paramList)
  {
    BleScanner.getInstance().setScanFilters(paramList);
  }
  
  public void setTranslateFwData(boolean paramBoolean)
  {
    this.mIsTranslateFwData = paramBoolean;
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void startScan()
  {
    startScan(BleConstants.DEFAULT_SCAN_TIMEOUT);
  }
  
  /* Error */
  public void startScan(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void stopScan()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private class ActionReceiver
    extends BroadcastReceiver
  {
    private ActionReceiver() {}
    
    /* Error */
    public void onReceive(Context arg1, android.content.Intent arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  private class MainHandler
    extends Handler
  {
    public MainHandler()
    {
      super();
    }
    
    /* Error */
    public void handleMessage(android.os.Message arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  private static class SingletonHolder
  {
    public static BleManager instance = new BleManager(null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ble2\BleManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */