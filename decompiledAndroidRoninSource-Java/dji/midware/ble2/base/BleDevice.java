package dji.midware.ble2.base;

import android.bluetooth.BluetoothDevice;
import dji.midware.ble2.DJIBLEDeviceType;

public class BleDevice
  implements Comparable
{
  private String desc;
  private BluetoothDevice device;
  private int deviceId;
  private int rssi;
  private BleState state = BleState.DISCONNECTED;
  private long timestamp;
  
  public BleDevice(BluetoothDevice paramBluetoothDevice, int paramInt1, int paramInt2, long paramLong)
  {
    this.device = paramBluetoothDevice;
    this.rssi = paramInt1;
    this.timestamp = paramLong;
    this.deviceId = paramInt2;
    paramBluetoothDevice = new StringBuilder();
    paramBluetoothDevice.append(" BleDevice deviceId: ");
    paramBluetoothDevice.append(paramInt2);
    BleLog.logD(paramBluetoothDevice.toString());
  }
  
  public BleDevice(BluetoothDevice paramBluetoothDevice, String paramString)
  {
    this.device = paramBluetoothDevice;
    this.desc = paramString;
  }
  
  public int compareTo(Object paramObject)
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public String getAddress()
  {
    return null;
  }
  
  public String getDesc()
  {
    return this.desc;
  }
  
  public BluetoothDevice getDevice()
  {
    return this.device;
  }
  
  public DJIBLEDeviceType getDeviceType()
  {
    return DJIBLEDeviceType.find(this.deviceId);
  }
  
  public String getKey()
  {
    return null;
  }
  
  public String getMac()
  {
    return null;
  }
  
  public String getName()
  {
    return null;
  }
  
  public int getRssi()
  {
    return this.rssi;
  }
  
  public BleState getState()
  {
    return this.state;
  }
  
  public long getTimestampNanos()
  {
    return this.timestamp;
  }
  
  public void setDesc(String paramString)
  {
    this.desc = paramString;
  }
  
  public void setDevice(BluetoothDevice paramBluetoothDevice)
  {
    this.device = paramBluetoothDevice;
  }
  
  public void setRssi(int paramInt)
  {
    this.rssi = paramInt;
  }
  
  public void setState(BleState paramBleState)
  {
    this.state = paramBleState;
  }
  
  public void setTimestampNanos(long paramLong)
  {
    this.timestamp = paramLong;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ble2\base\BleDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */