package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReportWithSessionId
  extends CrashlyticsReportWithSessionId
{
  private final CrashlyticsReport report;
  private final String sessionId;
  
  AutoValue_CrashlyticsReportWithSessionId(CrashlyticsReport paramCrashlyticsReport, String paramString)
  {
    if (paramCrashlyticsReport != null)
    {
      this.report = paramCrashlyticsReport;
      if (paramString != null)
      {
        this.sessionId = paramString;
        return;
      }
      throw new NullPointerException("Null sessionId");
    }
    throw new NullPointerException("Null report");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReportWithSessionId))
    {
      paramObject = (CrashlyticsReportWithSessionId)paramObject;
      return (this.report.equals(((CrashlyticsReportWithSessionId)paramObject).getReport())) && (this.sessionId.equals(((CrashlyticsReportWithSessionId)paramObject).getSessionId()));
    }
    return false;
  }
  
  public CrashlyticsReport getReport()
  {
    return this.report;
  }
  
  public String getSessionId()
  {
    return this.sessionId;
  }
  
  public int hashCode()
  {
    return (this.report.hashCode() ^ 0xF4243) * 1000003 ^ this.sessionId.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CrashlyticsReportWithSessionId{report=");
    localStringBuilder.append(this.report);
    localStringBuilder.append(", sessionId=");
    localStringBuilder.append(this.sessionId);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\common\AutoValue_CrashlyticsReportWithSessionId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */