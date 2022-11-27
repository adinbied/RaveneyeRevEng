package dji.midware.aoabridge;

import dji.midware.data.manager.P3.DataEvent;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ProxyEventServer
{
  private EventClientInfo curClient;
  private DataEvent dataEvent = DataEvent.ConnectLose;
  private Map<String, EventClientInfo> ipMap;
  private int port = -1;
  private ServerSocket server;
  
  public ProxyEventServer(int paramInt)
  {
    this.port = paramInt;
  }
  
  /* Error */
  private void closeServer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void closeServerSocket()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void initSocket()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void sendByte(byte[] arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void sendEvent()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void sendEvent(AoaController.RcEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean containApp(String paramString)
  {
    return getEventClientInfo(paramString) != null;
  }
  
  public EventClientInfo getEventClientInfo(String paramString)
  {
    return null;
  }
  
  /* Error */
  public void init()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataEvent paramDataEvent)
  {
    sendEvent();
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
  public void uninit()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void updateClientInfo(String arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private class EventClientInfo
    extends Thread
  {
    public InputStream in;
    public String ip;
    public OutputStream out;
    public String packageName;
    public Socket socket;
    
    public EventClientInfo(Socket paramSocket, InputStream paramInputStream, OutputStream paramOutputStream)
    {
      this.socket = paramSocket;
      this.in = paramInputStream;
      this.out = paramOutputStream;
      if ((paramSocket.getInetAddress() != null) && (paramSocket.getInetAddress().getAddress() != null) && (paramSocket.getInetAddress().getAddress().length == 4))
      {
        this$1 = paramSocket.getInetAddress().getAddress();
        this.ip = String.format("%d.%d.%d.%d:%d", new Object[] { Integer.valueOf(ProxyEventServer.this[0] & 0xFF), Integer.valueOf(ProxyEventServer.this[1] & 0xFF), Integer.valueOf(ProxyEventServer.this[2] & 0xFF), Integer.valueOf(ProxyEventServer.this[3] & 0xFF), Integer.valueOf(paramSocket.getPort()) });
      }
    }
    
    /* Error */
    private void closeClientSocket()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public boolean sendByte(byte[] paramArrayOfByte, int paramInt)
    {
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\aoabridge\ProxyEventServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */