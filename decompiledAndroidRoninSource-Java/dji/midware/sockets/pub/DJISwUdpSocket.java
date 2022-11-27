package dji.midware.sockets.pub;

import dji.midware.data.manager.P3.DJIServiceInterface;
import dji.midware.data.packages.P3.SendPack;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class DJISwUdpSocket
  implements DJIServiceInterface
{
  protected String TAG = getClass().getSimpleName();
  protected ArrayList<IpPortConfig> configList;
  protected IpPortConfig currentConfig;
  private volatile long sendCount = 0L;
  private ExecutorService sendThreadPool;
  
  public DJISwUdpSocket(ArrayList<IpPortConfig> paramArrayList)
  {
    this.configList = paramArrayList;
    this.sendThreadPool = Executors.newSingleThreadExecutor();
  }
  
  public abstract void LOGD(String paramString);
  
  public abstract void LOGE(String paramString);
  
  protected abstract void closeSocket();
  
  protected abstract void connect();
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void sendmessage(SendPack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected abstract void startTimers();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\sockets\pub\DJISwUdpSocket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */