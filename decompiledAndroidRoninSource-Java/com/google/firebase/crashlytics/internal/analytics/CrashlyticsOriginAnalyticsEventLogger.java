package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;

public class CrashlyticsOriginAnalyticsEventLogger
  implements AnalyticsEventLogger
{
  static final String FIREBASE_ANALYTICS_ORIGIN_CRASHLYTICS = "clx";
  private final AnalyticsConnector analyticsConnector;
  
  public CrashlyticsOriginAnalyticsEventLogger(AnalyticsConnector paramAnalyticsConnector)
  {
    this.analyticsConnector = paramAnalyticsConnector;
  }
  
  public void logEvent(String paramString, Bundle paramBundle)
  {
    this.analyticsConnector.logEvent("clx", paramString, paramBundle);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\analytics\CrashlyticsOriginAnalyticsEventLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */