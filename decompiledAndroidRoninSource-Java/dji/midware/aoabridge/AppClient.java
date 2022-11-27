package dji.midware.aoabridge;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class AppClient
{
  private Socket client;
  private InputStream in;
  private String ip;
  private boolean isRcConnected = false;
  private OutputStream out;
  private int port;
  
  public AppClient(String paramString, int paramInt)
  {
    this.ip = paramString;
    this.port = paramInt;
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
  private void startReadThread()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public InputStream getInputStream()
  {
    return this.in;
  }
  
  public OutputStream getOuputStream()
  {
    return this.out;
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
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(AoaController.RcEvent arg1)
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
  
  public static enum Status
  {
    static
    {
      Status localStatus = new Status("DisConnected", 1);
      DisConnected = localStatus;
      $VALUES = new Status[] { Connected, localStatus };
    }
    
    private Status() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\aoabridge\AppClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */