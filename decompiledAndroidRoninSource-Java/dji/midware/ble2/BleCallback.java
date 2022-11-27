package dji.midware.ble2;

import dji.midware.ble2.base.BleDevice;
import dji.midware.ble2.base.BleError;

public abstract interface BleCallback
{
  public abstract void onConnectFail(BleError paramBleError);
  
  public abstract void onConnected(BleDevice paramBleDevice);
  
  public abstract void onDisconnectFail(BleError paramBleError);
  
  public abstract void onDisconnected(BleDevice paramBleDevice);
  
  public abstract void onScanFinished(boolean paramBoolean);
  
  public abstract void onScanning(BleDevice paramBleDevice);
  
  public abstract void onStartConnect(BleDevice paramBleDevice);
  
  public abstract void onStartDisconnect();
  
  public abstract void onStartScan();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ble2\BleCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */