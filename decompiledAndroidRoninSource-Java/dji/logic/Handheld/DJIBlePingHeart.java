package dji.logic.Handheld;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

public class DJIBlePingHeart
{
  private static final String TAG = DJIBlePingHeart.class.getSimpleName();
  private ScheduledFuture mBleFuture;
  private ScheduledExecutorService mHeartExecutorService;
  
  public static DJIBlePingHeart getInstance()
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
  public void sendBleHeartPack(dji.midware.data.config.P3.DeviceType arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void stopBleHeartPack()
  {
    shutdownThread();
  }
  
  private static final class SingletonHolder
  {
    private static final DJIBlePingHeart mInstance = new DJIBlePingHeart(null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logic\Handheld\DJIBlePingHeart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */