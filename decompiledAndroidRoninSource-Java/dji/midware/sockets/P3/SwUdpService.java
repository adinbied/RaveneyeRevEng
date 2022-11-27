package dji.midware.sockets.P3;

import com.dji.video.framing.utils.stream.StreamDataObserver;
import dji.midware.data.manager.P3.DJIPackManager;
import dji.midware.natives.UDT;
import dji.midware.sockets.pub.IpPortConfig;
import dji.midware.sockets.pub.IpPortConfig.ConnectType;
import dji.midware.sockets.pub.SocketSwUdpClient;
import java.util.ArrayList;

public class SwUdpService
  extends SocketSwUdpClient
{
  private static final IpPortConfig IP_PORT_CONFIG = new IpPortConfig("192.168.2.1", 9005, IpPortConfig.ConnectType.DRONE);
  private static SwUdpService instance;
  private SwUdpConnectListener connectListener;
  private byte[] extraBufForParsing;
  private boolean isConnected = false;
  private long lastRecvCmd = 0L;
  private StreamDataObserver needPackObserver;
  private StreamDataObserver noNeedPackObserver;
  private DJIPackManager packManager = DJIPackManager.getInstance();
  private StreamDataObserver parseObserver;
  
  private SwUdpService()
  {
    super(getConfig());
    UDT.setSwRecver(this);
  }
  
  public static void Destroy()
  {
    SwUdpService localSwUdpService = instance;
    if (localSwUdpService != null) {
      localSwUdpService.destroy();
    }
  }
  
  private static ArrayList<IpPortConfig> getConfig()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(IP_PORT_CONFIG);
    return localArrayList;
  }
  
  public static SwUdpService getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new SwUdpService();
      }
      SwUdpService localSwUdpService = instance;
      return localSwUdpService;
    }
    finally {}
  }
  
  private void onRecvCmd()
  {
    this.lastRecvCmd = System.currentTimeMillis();
  }
  
  /* Error */
  private void onRecvVideo()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void LOGD(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void LOGE(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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
    return super.isConnected();
  }
  
  public boolean isOK()
  {
    return false;
  }
  
  public boolean isRcConnect()
  {
    return false;
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
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onDisconnect()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void parse(int arg1, byte[] arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void pauseParseThread() {}
  
  public void pauseRecvThread() {}
  
  public void pauseService(boolean paramBoolean) {}
  
  public void removeConnectListener()
  {
    this.connectListener = null;
  }
  
  public void resumeParseThread() {}
  
  public void resumeRecvThread() {}
  
  public void setConnectListener(SwUdpConnectListener paramSwUdpConnectListener)
  {
    this.connectListener = paramSwUdpConnectListener;
  }
  
  public void setDataMode(boolean paramBoolean) {}
  
  public void startStream() {}
  
  public void stopStream() {}
  
  public static abstract interface SwUdpConnectListener
  {
    public abstract void onConnect();
    
    public abstract void onDisconnect();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\sockets\P3\SwUdpService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */