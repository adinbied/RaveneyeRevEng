package dji.midware.ble2.base;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Handler;
import dji.midware.ble2.BleCallback;
import dji.midware.ble2.BleConstants;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BleConnector
  extends BluetoothGattCallback
{
  private static final String BLE_CONNECTED_ADDRESS = "ble_last_address";
  private static final int DATA_MAX_LENGTH = 20;
  public static final int DELAY_NOTIFY_DISCONNECT_MILLIS = 38000;
  private static final int DISCONNECT_TIMEOUT = 5000;
  private static final int MSG_RETRY_CONNECT = 2;
  private static final int MSG_RETRY_WRITE = 1;
  private static final int MSG_TIMEOUT = 3;
  private static final int MSG_TIMEOUT_DISCONNECT = 4;
  private static final int MSG_TIMEOUT_RECONNECT = 5;
  private static final int MTU_HEAD_LENGTH = 3;
  public static final int MTU_MAX_LENGTH = 259;
  private static final String TAG = "BleConnector";
  private BluetoothAdapter mBluetoothAdapter;
  private BluetoothGatt mBluetoothGatt;
  private BluetoothManager mBluetoothManager;
  private BleCallback mCallback;
  private Context mContext;
  private BleDataReceiveListener mDataListener;
  private DataWriteListener mDataWriteListener;
  private BleDevice mDevice;
  private volatile boolean mIsConnect;
  private ReentrantReadWriteLock mLock;
  private final Object mLocker;
  private int mMaxDataLength;
  private RetryHandler mRetryHandler;
  private BleState mState;
  private int mTimeout;
  private BluetoothGattCharacteristic mWriteCharacteristic;
  private Lock mWriteLock;
  
  private BleConnector()
  {
    ReentrantReadWriteLock localReentrantReadWriteLock = new ReentrantReadWriteLock();
    this.mLock = localReentrantReadWriteLock;
    this.mWriteLock = localReentrantReadWriteLock.writeLock();
    this.mState = BleState.DISCONNECTED;
    this.mLocker = new Object();
    this.mTimeout = BleConstants.DEFAULT_CONNECT_TIMEOUT;
    this.mMaxDataLength = 20;
    this.mIsConnect = false;
  }
  
  /* Error */
  private void connectFailed(BleError arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void connected()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void disconnectFailed(BleError arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean enableNotification()
  {
    return false;
  }
  
  public static BleConnector getInstance()
  {
    return SingletonHolder.instance;
  }
  
  /* Error */
  private void initWriteCharcteristic(android.bluetooth.BluetoothGattService arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void notifyDisconnected()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean refreshDeviceCache(BluetoothGatt paramBluetoothGatt)
  {
    return false;
  }
  
  /* Error */
  private void sendRetryMsg()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public BluetoothGatt connect(BleDevice paramBleDevice, boolean paramBoolean)
  {
    return null;
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
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
  public void disconnected()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public BleDevice getCurrentConnectedDevice()
  {
    return this.mDevice;
  }
  
  public String getLastConnectedAddress()
  {
    return null;
  }
  
  public int getMaxDataLength()
  {
    return this.mMaxDataLength;
  }
  
  public void init(Context paramContext, BluetoothManager paramBluetoothManager, BluetoothAdapter paramBluetoothAdapter, BleCallback paramBleCallback, int paramInt)
  {
    if (paramBluetoothManager != null)
    {
      if (paramBluetoothAdapter != null)
      {
        if (paramContext != null)
        {
          if (paramBleCallback != null)
          {
            if (paramInt > 0)
            {
              this.mContext = paramContext;
              this.mBluetoothManager = paramBluetoothManager;
              this.mBluetoothAdapter = paramBluetoothAdapter;
              this.mCallback = paramBleCallback;
              this.mTimeout = paramInt;
              return;
            }
            throw new IllegalArgumentException("connect timeout should greater than 0!");
          }
          throw new IllegalArgumentException("BleCallback can not be Null!");
        }
        throw new IllegalArgumentException("Context can not be Null!");
      }
      throw new IllegalArgumentException("BluetoothAdapter can not be Null!");
    }
    throw new IllegalArgumentException("BluetoothManager can not be Null!");
  }
  
  public boolean isConnectAlive()
  {
    return false;
  }
  
  public void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    if ((this.mDataListener != null) && (paramBluetoothGattCharacteristic.getValue() != null) && (paramBluetoothGattCharacteristic.getValue().length != 0)) {
      this.mDataListener.onDataReceived(paramBluetoothGattCharacteristic.getValue());
    }
  }
  
  public void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    super.onCharacteristicRead(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
  }
  
  public void onCharacteristicWrite(BluetoothGatt arg1, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    for (;;)
    {
      synchronized (this.mLocker)
      {
        if (this.mDataWriteListener != null)
        {
          paramBluetoothGattCharacteristic = this.mDataWriteListener;
          if (paramInt == 0)
          {
            bool = true;
            paramBluetoothGattCharacteristic.onCharacteristicWrite(bool);
          }
        }
        else
        {
          return;
        }
      }
      boolean bool = false;
    }
  }
  
  /* Error */
  public void onConnectionStateChange(BluetoothGatt arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void onDescriptorWrite(BluetoothGatt arg1, android.bluetooth.BluetoothGattDescriptor arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void onMtuChanged(BluetoothGatt arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onServicesDiscovered(BluetoothGatt arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void reconnect()
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
    //   2: return
  }
  
  public boolean sendData(byte[] paramArrayOfByte)
  {
    for (;;)
    {
      return false;
    }
  }
  
  public void setDataListener(BleDataReceiveListener paramBleDataReceiveListener)
  {
    this.mDataListener = paramBleDataReceiveListener;
  }
  
  public void setDataWriteListener(DataWriteListener paramDataWriteListener)
  {
    this.mDataWriteListener = paramDataWriteListener;
  }
  
  /* Error */
  public void setHighSpeedMode(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public static abstract interface DataWriteListener
  {
    public abstract void onCharacteristicWrite(boolean paramBoolean);
  }
  
  private class RetryHandler
    extends Handler
  {
    public RetryHandler()
    {
      super();
    }
    
    /* Error */
    public void handleMessage(android.os.Message arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  private static class SingletonHolder
  {
    public static BleConnector instance = new BleConnector(null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ble2\base\BleConnector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */