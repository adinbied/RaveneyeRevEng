package com.google.firebase.crashlytics.internal.report.model;

public class CreateReportRequest
{
  public final String googleAppId;
  public final String organizationId;
  public final Report report;
  
  public CreateReportRequest(String paramString1, String paramString2, Report paramReport)
  {
    this.organizationId = paramString1;
    this.googleAppId = paramString2;
    this.report = paramReport;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\report\model\CreateReportRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */