package dji.midware.sockets.pub;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public abstract class SocketSwUdpClient
  extends DJISwUdpSocket
{
  protected static final int PortOccupiedEventMax = 5;
  private Timer checkTimer;
  private volatile boolean mHasStopTimer;
  protected int portEvent;
  private volatile int tryTime = 0;
  
  public SocketSwUdpClient(ArrayList<IpPortConfig> paramArrayList)
  {
    super(paramArrayList);
    startTimers();
  }
  
  /* Error */
  private void checkConneted()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void closeSocket()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void connect()
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
    return false;
  }
  
  protected abstract void parse(int paramInt1, byte[] paramArrayOfByte, int paramInt2);
  
  /* Error */
  protected void startTimers()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\sockets\pub\SocketSwUdpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */