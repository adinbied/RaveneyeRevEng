package dji.midware.ble2.base;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.content.Context;
import android.os.Handler;
import dji.midware.ble2.BleCallback;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

public class BleScanner
{
  private static final int MSG_SCAN_HID = 1;
  public static final String RONIN_DEVICE_NAME = "Ronin";
  private static final String TAG = "BleScanner";
  private BluetoothAdapter mBluetoothAdapter;
  private BleCallback mCallback;
  private Context mContext;
  private volatile boolean mIsScanning;
  private BluetoothAdapter.LeScanCallback mLeScanCallback;
  private ScanCallback mScanCallback;
  private ScanHandler mScanHandler;
  private BluetoothLeScanner mScanner;
  private ScheduledExecutorService mScheduledService;
  private List<BleScanFilter> scanFilters = new ArrayList();
  private List scanResult = new CopyOnWriteArrayList();
  private volatile boolean startSuccess;
  
  private boolean findSystemConnectedDevice()
  {
    return false;
  }
  
  public static BleScanner getInstance()
  {
    return SingletonHolder.instance;
  }
  
  private List getScanFilters()
  {
    return null;
  }
  
  /* Error */
  private void initScanCallback()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean isDeviceValid(BluetoothDevice paramBluetoothDevice)
  {
    return false;
  }
  
  private boolean isMatchDeviceName(String paramString)
  {
    return false;
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void init(Context paramContext, BluetoothAdapter paramBluetoothAdapter, BleCallback paramBleCallback)
  {
    this.mContext = paramContext;
    this.mBluetoothAdapter = paramBluetoothAdapter;
    this.mCallback = paramBleCallback;
    initScanCallback();
  }
  
  public boolean isScanning()
  {
    return this.mIsScanning;
  }
  
  /* Error */
  public void scan(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public BleScanner setScanFilters(List<BleScanFilter> paramList)
  {
    return null;
  }
  
  /* Error */
  public void stopScan(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  private class ScanHandler
    extends Handler
  {
    public ScanHandler()
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
    public static BleScanner instance = new BleScanner(null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ble2\base\BleScanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */