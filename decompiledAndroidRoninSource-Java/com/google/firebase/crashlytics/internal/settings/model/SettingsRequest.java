package com.google.firebase.crashlytics.internal.settings.model;

import com.google.firebase.crashlytics.internal.common.InstallIdProvider;

public class SettingsRequest
{
  public final String buildVersion;
  public final String deviceModel;
  public final String displayVersion;
  public final String googleAppId;
  public final InstallIdProvider installIdProvider;
  public final String instanceId;
  public final String osBuildVersion;
  public final String osDisplayVersion;
  public final int source;
  
  public SettingsRequest(String paramString1, String paramString2, String paramString3, String paramString4, InstallIdProvider paramInstallIdProvider, String paramString5, String paramString6, String paramString7, int paramInt)
  {
    this.googleAppId = paramString1;
    this.deviceModel = paramString2;
    this.osBuildVersion = paramString3;
    this.osDisplayVersion = paramString4;
    this.installIdProvider = paramInstallIdProvider;
    this.instanceId = paramString5;
    this.displayVersion = paramString6;
    this.buildVersion = paramString7;
    this.source = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\settings\model\SettingsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */