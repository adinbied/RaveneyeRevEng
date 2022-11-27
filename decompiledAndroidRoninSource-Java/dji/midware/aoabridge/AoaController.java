package dji.midware.aoabridge;

import android.content.BroadcastReceiver;
import android.content.Context;
import com.dji.configassistant.DJIInnerProperty;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class AoaController
{
  private static final String AoaBridgeApp = "com.dji.aoabridge";
  private static final String AoaServiceApp = "com.dji.aoaservice";
  private static final String AoaServiceClientAction = "com.dji.aoaservice.client.connected";
  @DJIInnerProperty("aoabridge.server_ip")
  private static String SERVER_IP = "192.168.1.101";
  @DJIInnerProperty("aoabridge.enable")
  private static boolean isEnable;
  @DJIInnerProperty("aoabridge.is_server")
  private static boolean isProxy;
  public static String sdkIp;
  private int SERVER_DATA_PORT = 7003;
  private int SERVER_EVENT_PORT = 7006;
  private AppClient appClient;
  private AppEventClient appEventClient;
  private BroadcastReceiver clientReceiver = new BroadcastReceiver()
  {
    /* Error */
    public void onReceive(Context arg1, android.content.Intent arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  private Context ctx;
  private String lastSelectedAppPackageName;
  private long lastSelectedAppTime;
  private ProxyEventServer proxyEventServer;
  private ProxyServer proxyServer;
  
  public static AoaController get()
  {
    return SingleHolder.instance;
  }
  
  private boolean isAoaBridgeApp()
  {
    return false;
  }
  
  private boolean isAoaServiceApp()
  {
    return false;
  }
  
  private boolean isAoaServiceAppInstalled()
  {
    return false;
  }
  
  /* Error */
  public void broadcastClientConnected(boolean arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public List<String> getAllClientIp()
  {
    return this.proxyServer.getAllClientIp();
  }
  
  public int getClientCount()
  {
    return this.proxyServer.getClientCount();
  }
  
  public String getCurrentSelectedPackageName()
  {
    return this.proxyServer.getCurrentSelectedPackageName();
  }
  
  public InputStream getInputStream()
  {
    return this.appClient.getInputStream();
  }
  
  public OutputStream getOutputStream()
  {
    return this.appClient.getOuputStream();
  }
  
  /* Error */
  public void init(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isApp()
  {
    return false;
  }
  
  public boolean isEnable()
  {
    return isEnable;
  }
  
  public boolean isProxy()
  {
    return false;
  }
  
  public boolean isRcConnected()
  {
    return false;
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(AppClient.Status arg1)
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
    //   2: goto -2 -> 0
  }
  
  public void sendByte(byte[] paramArrayOfByte, int paramInt)
  {
    ProxyServer localProxyServer = this.proxyServer;
    if (localProxyServer != null) {
      localProxyServer.sendByte(paramArrayOfByte, paramInt);
    }
  }
  
  /* Error */
  public void switchClient(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void unit()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum RcEvent
  {
    static
    {
      RcEvent localRcEvent = new RcEvent("DisConnected", 1);
      DisConnected = localRcEvent;
      $VALUES = new RcEvent[] { Connected, localRcEvent };
    }
    
    private RcEvent() {}
  }
  
  private static class SingleHolder
  {
    public static AoaController instance = new AoaController();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\aoabridge\AoaController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */