package dji.midware.link;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import dji.midware.data.manager.P3.DJIServiceInterface;

public class DJILinkDaemonService
{
  private static final String TAG = "DJILinkDaemonService";
  private static DJILinkDaemonService instance;
  private DJIServiceInterface curServiceInterface;
  private Handler handler;
  private volatile boolean isAlive;
  private boolean isSupportOnlyForBluetoothDevice = false;
  private DJILinkType linkType = DJILinkType.NON;
  
  private DJILinkDaemonService()
  {
    HandlerThread localHandlerThread = new HandlerThread("DJILinkDaemonService");
    localHandlerThread.start();
    this.handler = new Handler(localHandlerThread.getLooper(), new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        DJILinkDaemonService.this.startDaemon();
        return false;
      }
    });
    this.isAlive = true;
    this.handler.sendEmptyMessage(0);
  }
  
  /* Error */
  private void changeTo(DJIServiceInterface arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static DJILinkDaemonService getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DJILinkDaemonService();
      }
      DJILinkDaemonService localDJILinkDaemonService = instance;
      return localDJILinkDaemonService;
    }
    finally {}
  }
  
  /* Error */
  private void stopDaemon()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DJIServiceInterface getInterface()
  {
    return this.curServiceInterface;
  }
  
  public DJILinkType getLinkType()
  {
    return this.linkType;
  }
  
  /* Error */
  public void init()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setLinkType(DJILinkType arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void setSupportOnlyForBluetoothDevice(boolean paramBoolean)
  {
    this.isSupportOnlyForBluetoothDevice = paramBoolean;
  }
  
  /* Error */
  public void startDaemon()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\link\DJILinkDaemonService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */