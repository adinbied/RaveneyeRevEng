package com.google.firebase.crashlytics.internal.model;

final class AutoValue_CrashlyticsReport
  extends CrashlyticsReport
{
  private final String buildVersion;
  private final String displayVersion;
  private final String gmpAppId;
  private final String installationUuid;
  private final CrashlyticsReport.FilesPayload ndkPayload;
  private final int platform;
  private final String sdkVersion;
  private final CrashlyticsReport.Session session;
  
  private AutoValue_CrashlyticsReport(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, CrashlyticsReport.Session paramSession, CrashlyticsReport.FilesPayload paramFilesPayload)
  {
    this.sdkVersion = paramString1;
    this.gmpAppId = paramString2;
    this.platform = paramInt;
    this.installationUuid = paramString3;
    this.buildVersion = paramString4;
    this.displayVersion = paramString5;
    this.session = paramSession;
    this.ndkPayload = paramFilesPayload;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport))
    {
      paramObject = (CrashlyticsReport)paramObject;
      if ((this.sdkVersion.equals(((CrashlyticsReport)paramObject).getSdkVersion())) && (this.gmpAppId.equals(((CrashlyticsReport)paramObject).getGmpAppId())) && (this.platform == ((CrashlyticsReport)paramObject).getPlatform()) && (this.installationUuid.equals(((CrashlyticsReport)paramObject).getInstallationUuid())) && (this.buildVersion.equals(((CrashlyticsReport)paramObject).getBuildVersion())) && (this.displayVersion.equals(((CrashlyticsReport)paramObject).getDisplayVersion())))
      {
        Object localObject = this.session;
        if (localObject == null ? ((CrashlyticsReport)paramObject).getSession() == null : localObject.equals(((CrashlyticsReport)paramObject).getSession()))
        {
          localObject = this.ndkPayload;
          if (localObject == null)
          {
            if (((CrashlyticsReport)paramObject).getNdkPayload() == null) {
              return true;
            }
          }
          else if (localObject.equals(((CrashlyticsReport)paramObject).getNdkPayload())) {
            return true;
          }
        }
      }
      return false;
    }
    return false;
  }
  
  public String getBuildVersion()
  {
    return this.buildVersion;
  }
  
  public String getDisplayVersion()
  {
    return this.displayVersion;
  }
  
  public String getGmpAppId()
  {
    return this.gmpAppId;
  }
  
  public String getInstallationUuid()
  {
    return this.installationUuid;
  }
  
  public CrashlyticsReport.FilesPayload getNdkPayload()
  {
    return this.ndkPayload;
  }
  
  public int getPlatform()
  {
    return this.platform;
  }
  
  public String getSdkVersion()
  {
    return this.sdkVersion;
  }
  
  public CrashlyticsReport.Session getSession()
  {
    return this.session;
  }
  
  public int hashCode()
  {
    int k = this.sdkVersion.hashCode();
    int m = this.gmpAppId.hashCode();
    int n = this.platform;
    int i1 = this.installationUuid.hashCode();
    int i2 = this.buildVersion.hashCode();
    int i3 = this.displayVersion.hashCode();
    Object localObject = this.session;
    int j = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = localObject.hashCode();
    }
    localObject = this.ndkPayload;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return (((((((k ^ 0xF4243) * 1000003 ^ m) * 1000003 ^ n) * 1000003 ^ i1) * 1000003 ^ i2) * 1000003 ^ i3) * 1000003 ^ i) * 1000003 ^ j;
  }
  
  protected CrashlyticsReport.Builder toBuilder()
  {
    return new Builder(this, null);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CrashlyticsReport{sdkVersion=");
    localStringBuilder.append(this.sdkVersion);
    localStringBuilder.append(", gmpAppId=");
    localStringBuilder.append(this.gmpAppId);
    localStringBuilder.append(", platform=");
    localStringBuilder.append(this.platform);
    localStringBuilder.append(", installationUuid=");
    localStringBuilder.append(this.installationUuid);
    localStringBuilder.append(", buildVersion=");
    localStringBuilder.append(this.buildVersion);
    localStringBuilder.append(", displayVersion=");
    localStringBuilder.append(this.displayVersion);
    localStringBuilder.append(", session=");
    localStringBuilder.append(this.session);
    localStringBuilder.append(", ndkPayload=");
    localStringBuilder.append(this.ndkPayload);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.Builder
  {
    private String buildVersion;
    private String displayVersion;
    private String gmpAppId;
    private String installationUuid;
    private CrashlyticsReport.FilesPayload ndkPayload;
    private Integer platform;
    private String sdkVersion;
    private CrashlyticsReport.Session session;
    
    Builder() {}
    
    private Builder(CrashlyticsReport paramCrashlyticsReport)
    {
      this.sdkVersion = paramCrashlyticsReport.getSdkVersion();
      this.gmpAppId = paramCrashlyticsReport.getGmpAppId();
      this.platform = Integer.valueOf(paramCrashlyticsReport.getPlatform());
      this.installationUuid = paramCrashlyticsReport.getInstallationUuid();
      this.buildVersion = paramCrashlyticsReport.getBuildVersion();
      this.displayVersion = paramCrashlyticsReport.getDisplayVersion();
      this.session = paramCrashlyticsReport.getSession();
      this.ndkPayload = paramCrashlyticsReport.getNdkPayload();
    }
    
    public CrashlyticsReport build()
    {
      Object localObject2 = this.sdkVersion;
      Object localObject1 = "";
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" sdkVersion");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.gmpAppId == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" gmpAppId");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.platform == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" platform");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.installationUuid == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" installationUuid");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.buildVersion == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" buildVersion");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.displayVersion == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" displayVersion");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      if (((String)localObject2).isEmpty()) {
        return new AutoValue_CrashlyticsReport(this.sdkVersion, this.gmpAppId, this.platform.intValue(), this.installationUuid, this.buildVersion, this.displayVersion, this.session, this.ndkPayload, null);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Missing required properties:");
      ((StringBuilder)localObject1).append((String)localObject2);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    
    public CrashlyticsReport.Builder setBuildVersion(String paramString)
    {
      if (paramString != null)
      {
        this.buildVersion = paramString;
        return this;
      }
      throw new NullPointerException("Null buildVersion");
    }
    
    public CrashlyticsReport.Builder setDisplayVersion(String paramString)
    {
      if (paramString != null)
      {
        this.displayVersion = paramString;
        return this;
      }
      throw new NullPointerException("Null displayVersion");
    }
    
    public CrashlyticsReport.Builder setGmpAppId(String paramString)
    {
      if (paramString != null)
      {
        this.gmpAppId = paramString;
        return this;
      }
      throw new NullPointerException("Null gmpAppId");
    }
    
    public CrashlyticsReport.Builder setInstallationUuid(String paramString)
    {
      if (paramString != null)
      {
        this.installationUuid = paramString;
        return this;
      }
      throw new NullPointerException("Null installationUuid");
    }
    
    public CrashlyticsReport.Builder setNdkPayload(CrashlyticsReport.FilesPayload paramFilesPayload)
    {
      this.ndkPayload = paramFilesPayload;
      return this;
    }
    
    public CrashlyticsReport.Builder setPlatform(int paramInt)
    {
      this.platform = Integer.valueOf(paramInt);
      return this;
    }
    
    public CrashlyticsReport.Builder setSdkVersion(String paramString)
    {
      if (paramString != null)
      {
        this.sdkVersion = paramString;
        return this;
      }
      throw new NullPointerException("Null sdkVersion");
    }
    
    public CrashlyticsReport.Builder setSession(CrashlyticsReport.Session paramSession)
    {
      this.session = paramSession;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */