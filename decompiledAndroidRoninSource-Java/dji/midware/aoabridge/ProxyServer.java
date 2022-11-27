package dji.midware.aoabridge;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Map;

public class ProxyServer
{
  private ClientInfo curClient;
  private Map<String, ClientInfo> ipMap;
  private int port = -1;
  private ServerSocket server;
  
  public ProxyServer(int paramInt)
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
  
  public boolean containApp(String paramString)
  {
    return getClientInfo(paramString) != null;
  }
  
  public List<String> getAllClientIp()
  {
    return null;
  }
  
  public int getClientCount()
  {
    return this.ipMap.size();
  }
  
  public ClientInfo getClientInfo(String paramString)
  {
    return null;
  }
  
  public String getCurrentSelectedPackageName()
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
  
  /* Error */
  public void sendByte(byte[] arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void switchClient(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void uninit()
  {
    closeServer();
  }
  
  /* Error */
  public void updateClientInfo(String arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private class ClientInfo
    extends Thread
  {
    public InputStream in;
    public String ip;
    public OutputStream out;
    public String packageName;
    public Socket socket;
    
    public ClientInfo(Socket paramSocket, InputStream paramInputStream, OutputStream paramOutputStream)
    {
      this.socket = paramSocket;
      this.in = paramInputStream;
      this.out = paramOutputStream;
      if ((paramSocket.getInetAddress() != null) && (paramSocket.getInetAddress().getAddress() != null) && (paramSocket.getInetAddress().getAddress().length == 4))
      {
        this$1 = paramSocket.getInetAddress().getAddress();
        this.ip = String.format("%d.%d.%d.%d:%d", new Object[] { Integer.valueOf(ProxyServer.this[0] & 0xFF), Integer.valueOf(ProxyServer.this[1] & 0xFF), Integer.valueOf(ProxyServer.this[2] & 0xFF), Integer.valueOf(ProxyServer.this[3] & 0xFF), Integer.valueOf(paramSocket.getPort()) });
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
    
    /* Error */
    public void sendByte(byte[] arg1, int arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
  
  public static enum Status
  {
    static
    {
      Status localStatus = new Status("DisConnect", 1);
      DisConnect = localStatus;
      $VALUES = new Status[] { Connect, localStatus };
    }
    
    private Status() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\aoabridge\ProxyServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */