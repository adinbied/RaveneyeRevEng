package dji.midware.sockets.P3;

import dji.logic.receiver.DJIPilotStartupReceiver;
import dji.midware.data.manager.P3.DJIServiceInterface;
import dji.midware.natives.UDT;

public class WifiService
  implements DJIServiceInterface
{
  private static WifiService instance;
  private static SwUdpService mSwUdpService;
  private int connectCount = 0;
  
  private WifiService()
  {
    if (DJIPilotStartupReceiver.ANOTHER_DJIGO_STARTED) {
      return;
    }
    mSwUdpService = SwUdpService.getInstance();
    startStream();
  }
  
  public static void Destroy()
  {
    WifiService localWifiService = instance;
    if (localWifiService != null) {
      localWifiService.destroy();
    }
  }
  
  public static void DestroyFinal()
  {
    Destroy();
    new Thread(new Runnable()
    {
      public void run()
      {
        UDT.cleanup();
      }
    }).start();
  }
  
  public static WifiService getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new WifiService();
      }
      WifiService localWifiService = instance;
      return localWifiService;
    }
    finally {}
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
    return isConnected();
  }
  
  public boolean isRemoteOK()
  {
    return false;
  }
  
  /* Error */
  public void onConnect()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void onDisconnect()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
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
    //   2: goto -2 -> 0
  }
  
  public void setDataMode(boolean paramBoolean) {}
  
  public void startStream() {}
  
  public void stopStream() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\sockets\P3\WifiService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */