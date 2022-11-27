package dji.midware.aoabridge;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class AppEventClient
{
  private Socket client;
  private InputStream in;
  private String ip;
  private boolean isConnected;
  private OutputStream out;
  private int port;
  
  public AppEventClient(String paramString, int paramInt)
  {
    this.ip = paramString;
    this.port = paramInt;
    this.isConnected = false;
  }
  
  /* Error */
  private void closeSocket()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void readData()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void init()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isRcConnected()
  {
    return this.isConnected;
  }
  
  public void uninit()
  {
    closeSocket();
  }
  
  public static enum Event
  {
    static
    {
      Event localEvent = new Event("DisConnected", 1);
      DisConnected = localEvent;
      $VALUES = new Event[] { Connected, localEvent };
    }
    
    private Event() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\aoabridge\AppEventClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */