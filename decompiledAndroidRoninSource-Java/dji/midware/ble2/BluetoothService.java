package dji.midware.ble2;

import android.content.Context;
import android.os.Build.VERSION;
import dji.midware.ble2.base.BleDataReceiveListener;
import dji.midware.data.manager.P3.DJIPackManager;
import dji.midware.data.manager.P3.DJIServiceInterface;
import dji.midware.data.model.P3.DataOsdSetLED;

public class BluetoothService
  implements DJIServiceInterface, BleDataReceiveListener
{
  private static final String TAG = "BluetoothService";
  private static BluetoothService mInstance;
  final DataOsdSetLED ledSetter = new DataOsdSetLED();
  private Runnable mReconnectKnownDeviceRunnable = new Runnable()
  {
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  private boolean needDelayed = false;
  private DJIPackManager packManager = DJIPackManager.getInstance();
  
  public static void Destroy()
  {
    BluetoothService localBluetoothService = mInstance;
    if (localBluetoothService != null) {
      localBluetoothService.destroy();
    }
  }
  
  public static BluetoothService getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new BluetoothService();
      }
      BluetoothService localBluetoothService = mInstance;
      return localBluetoothService;
    }
    finally {}
  }
  
  private boolean needBleHeart()
  {
    return false;
  }
  
  /* Error */
  private void sendBuffer(dji.midware.data.packages.P3.SendPack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static void setContext(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      BleManager.getInstance().init(paramContext);
    }
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isConnected()
  {
    return false;
  }
  
  public boolean isOK()
  {
    return false;
  }
  
  public boolean isRemoteOK()
  {
    return true;
  }
  
  /* Error */
  public void onConnect()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onDataReceived(byte[] paramArrayOfByte)
  {
    this.packManager.parse(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  /* Error */
  public void onDisconnect()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void pauseParseThread() {}
  
  public void pauseRecvThread() {}
  
  public void pauseService(boolean paramBoolean) {}
  
  public void resumeParseThread() {}
  
  public void resumeRecvThread() {}
  
  /* Error */
  public void sendmessage(dji.midware.data.packages.P3.SendPack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void setDataMode(boolean paramBoolean) {}
  
  /* Error */
  public void start(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void startStream() {}
  
  public void stopStream() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ble2\BluetoothService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */