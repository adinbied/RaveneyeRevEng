package dji.sdksharedlib.hardware.extension;

import android.os.Handler;
import android.os.Looper;
import java.util.List;
import java.util.Map;

public class DJISDKCacheCenterTimer
{
  private static final int MAX_INTERVAL = 10000;
  private static final int MIN_INTERVAL = 100;
  private static final int MSG_ADD = 2;
  private static final int MSG_CLEAR = 4;
  private static final int MSG_REMOVE = 3;
  private static final int MSG_REPEAT = 1;
  private Map<Integer, List<Runnable>> intervalListMap;
  private int timerCount = 0;
  private TimerHandler timerHandler;
  
  /* Error */
  private void innerAdd(List<Runnable> arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void innerClear()
  {
    this.intervalListMap.clear();
  }
  
  /* Error */
  private void innerRemove(List<Runnable> arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void repeatRun()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void add(Runnable arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void add(List<Runnable> arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void clearList()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getCenterTimerIntervalSize(int paramInt)
  {
    return 0;
  }
  
  public int getCenterTimerMapSize()
  {
    return 0;
  }
  
  /* Error */
  public void init(Looper arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void remove(Runnable arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void remove(List<Runnable> arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void uninit()
  {
    this.intervalListMap = null;
    this.timerHandler = null;
  }
  
  private class TimerHandler
    extends Handler
  {
    public TimerHandler(Looper paramLooper)
    {
      super();
    }
    
    /* Error */
    public void handleMessage(android.os.Message arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\extension\DJISDKCacheCenterTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */