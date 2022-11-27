package dji.midware.ble2.base;

import dji.midware.ble2.BleCallback;
import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BleDataTransmitter
  implements BleCallback
{
  private static final String TAG = BleDataTransmitter.class.getSimpleName();
  private int SEND_WAIT_TIME = 15;
  private volatile boolean isConnected;
  volatile boolean isLinkTransOk = false;
  private volatile boolean isStop;
  private final Lock lock = new ReentrantLock();
  private final Object mLocker = new Object();
  private long mPreTime = 0L;
  private int mSendBits = 0;
  private long mSendTime = 0L;
  private volatile LinkedList<BleRequest> procQueue = new LinkedList();
  private int sendResult;
  Thread transmitterThread;
  
  /* Error */
  private void countSendSpeed()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean executeQueue()
  {
    return false;
  }
  
  private boolean generateReq(byte[] paramArrayOfByte)
  {
    return false;
  }
  
  public static BleDataTransmitter getInstance()
  {
    return SingletonHolder.instance;
  }
  
  /* Error */
  private void start()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean addRequestToQueue(BleRequest paramBleRequest)
  {
    return false;
  }
  
  public boolean isDataTransOk()
  {
    return this.isLinkTransOk;
  }
  
  public void onConnectFail(BleError paramBleError) {}
  
  /* Error */
  public void onConnected(BleDevice arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onDisconnectFail(BleError paramBleError) {}
  
  /* Error */
  public void onDisconnected(BleDevice arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onScanFinished(boolean paramBoolean) {}
  
  public void onScanning(BleDevice paramBleDevice) {}
  
  public void onStartConnect(BleDevice paramBleDevice) {}
  
  public void onStartDisconnect() {}
  
  public void onStartScan() {}
  
  public void sendData(byte[] paramArrayOfByte)
  {
    generateReq(paramArrayOfByte);
  }
  
  public int sendNonBlockingWriteRequest(BleRequest paramBleRequest)
  {
    return 0;
  }
  
  /* Error */
  public void setHighSpeedMode(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public class BleRequest
  {
    public byte[] data;
    public long time;
    
    public BleRequest() {}
  }
  
  private static class SingletonHolder
  {
    public static BleDataTransmitter instance = new BleDataTransmitter(null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ble2\base\BleDataTransmitter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */