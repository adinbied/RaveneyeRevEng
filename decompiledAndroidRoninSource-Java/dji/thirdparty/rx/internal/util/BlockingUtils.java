package dji.thirdparty.rx.internal.util;

import dji.thirdparty.rx.Subscription;
import java.util.concurrent.CountDownLatch;

public final class BlockingUtils
{
  public static void awaitForComplete(CountDownLatch paramCountDownLatch, Subscription paramSubscription)
  {
    if (paramCountDownLatch.getCount() == 0L) {
      return;
    }
    try
    {
      paramCountDownLatch.await();
      return;
    }
    catch (InterruptedException paramCountDownLatch)
    {
      paramSubscription.unsubscribe();
      Thread.currentThread().interrupt();
      throw new RuntimeException("Interrupted while waiting for subscription to complete.", paramCountDownLatch);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\util\BlockingUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */