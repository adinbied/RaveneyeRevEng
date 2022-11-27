package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import com.google.firebase.crashlytics.internal.Logger;

public class UnavailableAnalyticsEventLogger
  implements AnalyticsEventLogger
{
  public void logEvent(String paramString, Bundle paramBundle)
  {
    Logger.getLogger().d("Skipping logging Crashlytics event to Firebase, no Firebase Analytics");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\analytics\UnavailableAnalyticsEventLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */