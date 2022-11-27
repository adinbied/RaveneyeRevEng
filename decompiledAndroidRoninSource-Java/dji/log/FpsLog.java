package dji.log;

import dji.midware.util.BackgroundLooper;
import java.util.concurrent.locks.ReentrantLock;

public class FpsLog
{
  private StringBuilder builder = new StringBuilder();
  private long lastTime = -1L;
  ReentrantLock lock = new ReentrantLock();
  private Runnable logRunnable = new Runnable()
  {
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  
  private FpsLog()
  {
    BackgroundLooper.postDelayed(this.logRunnable, 1000L);
  }
  
  public static FpsLog getInstance()
  {
    return SingletonHolder.INSTANCE;
  }
  
  /* Error */
  public void d(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static class SingletonHolder
  {
    private static final FpsLog INSTANCE = new FpsLog(null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\log\FpsLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */