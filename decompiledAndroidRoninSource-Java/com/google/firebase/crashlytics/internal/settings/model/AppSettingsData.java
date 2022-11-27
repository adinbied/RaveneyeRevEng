package com.google.firebase.crashlytics.internal.settings.model;

public class AppSettingsData
{
  public static final String STATUS_ACTIVATED = "activated";
  public static final String STATUS_CONFIGURED = "configured";
  public static final String STATUS_NEW = "new";
  public final String bundleId;
  public final int nativeReportUploadVariant;
  public final String ndkReportsUrl;
  public final String organizationId;
  public final int reportUploadVariant;
  public final String reportsUrl;
  public final String status;
  public final boolean updateRequired;
  public final String url;
  
  public AppSettingsData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.status = paramString1;
    this.url = paramString2;
    this.reportsUrl = paramString3;
    this.ndkReportsUrl = paramString4;
    this.bundleId = paramString5;
    this.organizationId = paramString6;
    this.updateRequired = paramBoolean;
    this.reportUploadVariant = paramInt1;
    this.nativeReportUploadVariant = paramInt2;
  }
  
  public AppSettingsData(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    this(paramString1, paramString2, paramString3, paramString4, null, null, paramBoolean, 0, 0);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\settings\model\AppSettingsData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */