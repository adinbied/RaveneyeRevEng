package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class BlockingAnalyticsEventLogger
  implements AnalyticsEventReceiver, AnalyticsEventLogger
{
  static final String APP_EXCEPTION_EVENT_NAME = "_ae";
  private final CrashlyticsOriginAnalyticsEventLogger baseAnalyticsEventLogger;
  private boolean callbackReceived = false;
  private CountDownLatch eventLatch;
  private final Object latchLock = new Object();
  private final TimeUnit timeUnit;
  private final int timeout;
  
  public BlockingAnalyticsEventLogger(CrashlyticsOriginAnalyticsEventLogger paramCrashlyticsOriginAnalyticsEventLogger, int paramInt, TimeUnit paramTimeUnit)
  {
    this.baseAnalyticsEventLogger = paramCrashlyticsOriginAnalyticsEventLogger;
    this.timeout = paramInt;
    this.timeUnit = paramTimeUnit;
  }
  
  boolean isCallbackReceived()
  {
    return this.callbackReceived;
  }
  
  public void logEvent(String paramString, Bundle paramBundle)
  {
    synchronized (this.latchLock)
    {
      Logger.getLogger().d("Logging Crashlytics event to Firebase");
      this.eventLatch = new CountDownLatch(1);
      this.callbackReceived = false;
      this.baseAnalyticsEventLogger.logEvent(paramString, paramBundle);
      Logger.getLogger().d("Awaiting app exception callback from FA...");
      try
      {
        if (this.eventLatch.await(this.timeout, this.timeUnit))
        {
          this.callbackReceived = true;
          Logger.getLogger().d("App exception callback received from FA listener.");
        }
        else
        {
          Logger.getLogger().d("Timeout exceeded while awaiting app exception callback from FA listener.");
        }
      }
      catch (InterruptedException paramString)
      {
        for (;;) {}
      }
      Logger.getLogger().d("Interrupted while awaiting app exception callback from FA listener.");
      this.eventLatch = null;
      return;
    }
  }
  
  public void onEvent(String paramString, Bundle paramBundle)
  {
    paramBundle = this.eventLatch;
    if (paramBundle == null) {
      return;
    }
    if ("_ae".equals(paramString)) {
      paramBundle.countDown();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\analytics\BlockingAnalyticsEventLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */