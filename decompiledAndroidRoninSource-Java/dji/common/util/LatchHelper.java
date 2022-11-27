package dji.common.util;

import java.util.concurrent.CountDownLatch;

public class LatchHelper
{
  private static LatchHelper uniqueInstance;
  private CountDownLatch latch = null;
  
  public static LatchHelper getInstance()
  {
    if (uniqueInstance == null) {
      uniqueInstance = new LatchHelper();
    }
    return uniqueInstance;
  }
  
  public void countDownLatch()
  {
    CountDownLatch localCountDownLatch = this.latch;
    if (localCountDownLatch != null) {
      localCountDownLatch.countDown();
    }
  }
  
  /* Error */
  public void setUpLatch(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  /* Error */
  public void waitForLatch(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\commo\\util\LatchHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */