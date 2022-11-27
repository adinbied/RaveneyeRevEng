package dji.midware.ble2.base;

import dji.midware.ble2.BleCallback;
import dji.midware.ble2.BleManager;
import org.greenrobot.eventbus.EventBus;

public enum BleStateHolder
  implements BleCallback
{
  private static final String TAG = "BleStateHolder";
  private BleState mState = BleState.DISCONNECTED;
  
  static
  {
    BleStateHolder localBleStateHolder = new BleStateHolder("INSTANCE", 0);
    INSTANCE = localBleStateHolder;
    $VALUES = new BleStateHolder[] { localBleStateHolder };
  }
  
  private BleStateHolder() {}
  
  private void changeState(BleState paramBleState)
  {
    if (paramBleState != this.mState)
    {
      this.mState = paramBleState;
      EventBus.getDefault().post(this.mState);
    }
  }
  
  public static BleStateHolder getInstance()
  {
    return INSTANCE;
  }
  
  public BleState getState()
  {
    return this.mState;
  }
  
  public void onConnectFail(BleError paramBleError)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BleStateHolder onConnectFail ");
    localStringBuilder.append(paramBleError.toString());
    BleLog.logD(localStringBuilder.toString());
    changeState(BleState.DISCONNECTED);
  }
  
  public void onConnected(BleDevice paramBleDevice)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BleStateHolder onConnected ");
    localStringBuilder.append(paramBleDevice.toString());
    BleLog.logD(localStringBuilder.toString());
    changeState(BleState.CONNECTED);
  }
  
  public void onDisconnectFail(BleError paramBleError)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BleStateHolder onDisconnectFail ");
    localStringBuilder.append(paramBleError.toString());
    BleLog.logD(localStringBuilder.toString());
    changeState(BleState.DISCONNECTED);
  }
  
  public void onDisconnected(BleDevice paramBleDevice)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BleStateHolder onDisconnected ");
    localStringBuilder.append(paramBleDevice.toString());
    BleLog.logD(localStringBuilder.toString());
    if (BleManager.getInstance().isBluetoothUpgrade()) {
      return;
    }
    changeState(BleState.DISCONNECTED);
  }
  
  public void onScanFinished(boolean paramBoolean)
  {
    BleLog.logD("BleStateHolder onScanFinished");
  }
  
  public void onScanning(BleDevice paramBleDevice)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BleStateHolder onScanning ");
    localStringBuilder.append(paramBleDevice.toString());
    BleLog.logD(localStringBuilder.toString());
  }
  
  public void onStartConnect(BleDevice paramBleDevice)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BleStateHolder onStartConnect ");
    localStringBuilder.append(paramBleDevice.toString());
    BleLog.logD(localStringBuilder.toString());
    changeState(BleState.CONNECTING);
  }
  
  public void onStartDisconnect()
  {
    BleLog.logD("BleStateHolder onStartDisconnect");
    this.mState = BleState.DISCONNECTING;
  }
  
  public void onStartScan()
  {
    BleLog.logD("BleStateHolder onStartScan");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ble2\base\BleStateHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */