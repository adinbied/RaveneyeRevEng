package dji.logic.Handheld;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

public class DJIWifiPingHeart
{
  private static final String TAG = DJIWifiPingHeart.class.getSimpleName();
  private ScheduledExecutorService mHeartExecutorService;
  private ScheduledFuture mWifiFuture;
  
  public static DJIWifiPingHeart getInstance()
  {
    return SingletonHolder.mInstance;
  }
  
  /* Error */
  private void shutdownThread()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void sendWifiHeartPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void stopWifiHeartPack()
  {
    shutdownThread();
  }
  
  private static final class SingletonHolder
  {
    private static final DJIWifiPingHeart mInstance = new DJIWifiPingHeart(null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logic\Handheld\DJIWifiPingHeart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */