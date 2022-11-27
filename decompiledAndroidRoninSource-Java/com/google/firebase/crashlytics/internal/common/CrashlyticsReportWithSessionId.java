package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

public abstract class CrashlyticsReportWithSessionId
{
  public static CrashlyticsReportWithSessionId create(CrashlyticsReport paramCrashlyticsReport, String paramString)
  {
    return new AutoValue_CrashlyticsReportWithSessionId(paramCrashlyticsReport, paramString);
  }
  
  public abstract CrashlyticsReport getReport();
  
  public abstract String getSessionId();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\common\CrashlyticsReportWithSessionId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */