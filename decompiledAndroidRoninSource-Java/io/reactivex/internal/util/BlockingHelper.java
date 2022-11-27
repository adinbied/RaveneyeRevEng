package io.reactivex.internal.util;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.schedulers.NonBlockingThread;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.CountDownLatch;

public final class BlockingHelper
{
  private BlockingHelper()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static void awaitForComplete(CountDownLatch paramCountDownLatch, Disposable paramDisposable)
  {
    if (paramCountDownLatch.getCount() == 0L) {
      return;
    }
    try
    {
      verifyNonBlocking();
      paramCountDownLatch.await();
      return;
    }
    catch (InterruptedException paramCountDownLatch)
    {
      paramDisposable.dispose();
      Thread.currentThread().interrupt();
      throw new IllegalStateException("Interrupted while waiting for subscription to complete.", paramCountDownLatch);
    }
  }
  
  public static void verifyNonBlocking()
  {
    if (RxJavaPlugins.isFailOnNonBlockingScheduler())
    {
      if ((!(Thread.currentThread() instanceof NonBlockingThread)) && (!RxJavaPlugins.onBeforeBlocking())) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Attempt to block on a Scheduler ");
      localStringBuilder.append(Thread.currentThread().getName());
      localStringBuilder.append(" that doesn't support blocking operators as they may lead to deadlock");
      throw new IllegalStateException(localStringBuilder.toString());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\interna\\util\BlockingHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */