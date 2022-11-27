package com.google.firebase.crashlytics.internal.settings.model;

public class AppRequestData
{
  public final String appId;
  public final String buildVersion;
  public final String builtSdkVersion;
  public final String displayVersion;
  public final String googleAppId;
  public final String instanceIdentifier;
  public final String minSdkVersion;
  public final String name;
  public final String organizationId;
  public final int source;
  
  public AppRequestData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt, String paramString8, String paramString9)
  {
    this.organizationId = paramString1;
    this.googleAppId = paramString2;
    this.appId = paramString3;
    this.displayVersion = paramString4;
    this.buildVersion = paramString5;
    this.instanceIdentifier = paramString6;
    this.name = paramString7;
    this.source = paramInt;
    this.minSdkVersion = paramString8;
    this.builtSdkVersion = paramString9;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\settings\model\AppRequestData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */