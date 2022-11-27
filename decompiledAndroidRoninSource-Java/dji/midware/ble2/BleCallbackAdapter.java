package dji.midware.ble2;

import dji.midware.ble2.base.BleDevice;
import dji.midware.ble2.base.BleError;

public class BleCallbackAdapter
  implements BleCallback
{
  public void onConnectFail(BleError paramBleError) {}
  
  public void onConnected(BleDevice paramBleDevice) {}
  
  public void onDisconnectFail(BleError paramBleError) {}
  
  public void onDisconnected(BleDevice paramBleDevice) {}
  
  public void onScanFinished(boolean paramBoolean) {}
  
  public void onScanning(BleDevice paramBleDevice) {}
  
  public void onStartConnect(BleDevice paramBleDevice) {}
  
  public void onStartDisconnect() {}
  
  public void onStartScan() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ble2\BleCallbackAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */