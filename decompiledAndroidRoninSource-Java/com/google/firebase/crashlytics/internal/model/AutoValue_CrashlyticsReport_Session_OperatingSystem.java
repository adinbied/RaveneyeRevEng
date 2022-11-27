package com.google.firebase.crashlytics.internal.model;

final class AutoValue_CrashlyticsReport_Session_OperatingSystem
  extends CrashlyticsReport.Session.OperatingSystem
{
  private final String buildVersion;
  private final boolean jailbroken;
  private final int platform;
  private final String version;
  
  private AutoValue_CrashlyticsReport_Session_OperatingSystem(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.platform = paramInt;
    this.version = paramString1;
    this.buildVersion = paramString2;
    this.jailbroken = paramBoolean;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.Session.OperatingSystem))
    {
      paramObject = (CrashlyticsReport.Session.OperatingSystem)paramObject;
      return (this.platform == ((CrashlyticsReport.Session.OperatingSystem)paramObject).getPlatform()) && (this.version.equals(((CrashlyticsReport.Session.OperatingSystem)paramObject).getVersion())) && (this.buildVersion.equals(((CrashlyticsReport.Session.OperatingSystem)paramObject).getBuildVersion())) && (this.jailbroken == ((CrashlyticsReport.Session.OperatingSystem)paramObject).isJailbroken());
    }
    return false;
  }
  
  public String getBuildVersion()
  {
    return this.buildVersion;
  }
  
  public int getPlatform()
  {
    return this.platform;
  }
  
  public String getVersion()
  {
    return this.version;
  }
  
  public int hashCode()
  {
    int j = this.platform;
    int k = this.version.hashCode();
    int m = this.buildVersion.hashCode();
    int i;
    if (this.jailbroken) {
      i = 1231;
    } else {
      i = 1237;
    }
    return (((j ^ 0xF4243) * 1000003 ^ k) * 1000003 ^ m) * 1000003 ^ i;
  }
  
  public boolean isJailbroken()
  {
    return this.jailbroken;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OperatingSystem{platform=");
    localStringBuilder.append(this.platform);
    localStringBuilder.append(", version=");
    localStringBuilder.append(this.version);
    localStringBuilder.append(", buildVersion=");
    localStringBuilder.append(this.buildVersion);
    localStringBuilder.append(", jailbroken=");
    localStringBuilder.append(this.jailbroken);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.Session.OperatingSystem.Builder
  {
    private String buildVersion;
    private Boolean jailbroken;
    private Integer platform;
    private String version;
    
    public CrashlyticsReport.Session.OperatingSystem build()
    {
      Object localObject2 = this.platform;
      Object localObject1 = "";
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" platform");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.version == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" version");
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
      if (this.jailbroken == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" jailbroken");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      if (((String)localObject2).isEmpty()) {
        return new AutoValue_CrashlyticsReport_Session_OperatingSystem(this.platform.intValue(), this.version, this.buildVersion, this.jailbroken.booleanValue(), null);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Missing required properties:");
      ((StringBuilder)localObject1).append((String)localObject2);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    
    public CrashlyticsReport.Session.OperatingSystem.Builder setBuildVersion(String paramString)
    {
      if (paramString != null)
      {
        this.buildVersion = paramString;
        return this;
      }
      throw new NullPointerException("Null buildVersion");
    }
    
    public CrashlyticsReport.Session.OperatingSystem.Builder setJailbroken(boolean paramBoolean)
    {
      this.jailbroken = Boolean.valueOf(paramBoolean);
      return this;
    }
    
    public CrashlyticsReport.Session.OperatingSystem.Builder setPlatform(int paramInt)
    {
      this.platform = Integer.valueOf(paramInt);
      return this;
    }
    
    public CrashlyticsReport.Session.OperatingSystem.Builder setVersion(String paramString)
    {
      if (paramString != null)
      {
        this.version = paramString;
        return this;
      }
      throw new NullPointerException("Null version");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_Session_OperatingSystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */