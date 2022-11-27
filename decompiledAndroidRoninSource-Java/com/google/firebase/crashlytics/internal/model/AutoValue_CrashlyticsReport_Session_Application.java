package com.google.firebase.crashlytics.internal.model;

final class AutoValue_CrashlyticsReport_Session_Application
  extends CrashlyticsReport.Session.Application
{
  private final String displayVersion;
  private final String identifier;
  private final String installationUuid;
  private final CrashlyticsReport.Session.Application.Organization organization;
  private final String version;
  
  private AutoValue_CrashlyticsReport_Session_Application(String paramString1, String paramString2, String paramString3, CrashlyticsReport.Session.Application.Organization paramOrganization, String paramString4)
  {
    this.identifier = paramString1;
    this.version = paramString2;
    this.displayVersion = paramString3;
    this.organization = paramOrganization;
    this.installationUuid = paramString4;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.Session.Application))
    {
      paramObject = (CrashlyticsReport.Session.Application)paramObject;
      if ((this.identifier.equals(((CrashlyticsReport.Session.Application)paramObject).getIdentifier())) && (this.version.equals(((CrashlyticsReport.Session.Application)paramObject).getVersion())))
      {
        Object localObject = this.displayVersion;
        if (localObject == null ? ((CrashlyticsReport.Session.Application)paramObject).getDisplayVersion() == null : ((String)localObject).equals(((CrashlyticsReport.Session.Application)paramObject).getDisplayVersion()))
        {
          localObject = this.organization;
          if (localObject == null ? ((CrashlyticsReport.Session.Application)paramObject).getOrganization() == null : localObject.equals(((CrashlyticsReport.Session.Application)paramObject).getOrganization()))
          {
            localObject = this.installationUuid;
            if (localObject == null)
            {
              if (((CrashlyticsReport.Session.Application)paramObject).getInstallationUuid() == null) {
                return true;
              }
            }
            else if (((String)localObject).equals(((CrashlyticsReport.Session.Application)paramObject).getInstallationUuid())) {
              return true;
            }
          }
        }
      }
      return false;
    }
    return false;
  }
  
  public String getDisplayVersion()
  {
    return this.displayVersion;
  }
  
  public String getIdentifier()
  {
    return this.identifier;
  }
  
  public String getInstallationUuid()
  {
    return this.installationUuid;
  }
  
  public CrashlyticsReport.Session.Application.Organization getOrganization()
  {
    return this.organization;
  }
  
  public String getVersion()
  {
    return this.version;
  }
  
  public int hashCode()
  {
    int m = this.identifier.hashCode();
    int n = this.version.hashCode();
    Object localObject = this.displayVersion;
    int k = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((String)localObject).hashCode();
    }
    localObject = this.organization;
    int j;
    if (localObject == null) {
      j = 0;
    } else {
      j = localObject.hashCode();
    }
    localObject = this.installationUuid;
    if (localObject != null) {
      k = ((String)localObject).hashCode();
    }
    return ((((m ^ 0xF4243) * 1000003 ^ n) * 1000003 ^ i) * 1000003 ^ j) * 1000003 ^ k;
  }
  
  protected CrashlyticsReport.Session.Application.Builder toBuilder()
  {
    return new Builder(this, null);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Application{identifier=");
    localStringBuilder.append(this.identifier);
    localStringBuilder.append(", version=");
    localStringBuilder.append(this.version);
    localStringBuilder.append(", displayVersion=");
    localStringBuilder.append(this.displayVersion);
    localStringBuilder.append(", organization=");
    localStringBuilder.append(this.organization);
    localStringBuilder.append(", installationUuid=");
    localStringBuilder.append(this.installationUuid);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.Session.Application.Builder
  {
    private String displayVersion;
    private String identifier;
    private String installationUuid;
    private CrashlyticsReport.Session.Application.Organization organization;
    private String version;
    
    Builder() {}
    
    private Builder(CrashlyticsReport.Session.Application paramApplication)
    {
      this.identifier = paramApplication.getIdentifier();
      this.version = paramApplication.getVersion();
      this.displayVersion = paramApplication.getDisplayVersion();
      this.organization = paramApplication.getOrganization();
      this.installationUuid = paramApplication.getInstallationUuid();
    }
    
    public CrashlyticsReport.Session.Application build()
    {
      Object localObject2 = this.identifier;
      Object localObject1 = "";
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" identifier");
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
      if (((String)localObject2).isEmpty()) {
        return new AutoValue_CrashlyticsReport_Session_Application(this.identifier, this.version, this.displayVersion, this.organization, this.installationUuid, null);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Missing required properties:");
      ((StringBuilder)localObject1).append((String)localObject2);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    
    public CrashlyticsReport.Session.Application.Builder setDisplayVersion(String paramString)
    {
      this.displayVersion = paramString;
      return this;
    }
    
    public CrashlyticsReport.Session.Application.Builder setIdentifier(String paramString)
    {
      if (paramString != null)
      {
        this.identifier = paramString;
        return this;
      }
      throw new NullPointerException("Null identifier");
    }
    
    public CrashlyticsReport.Session.Application.Builder setInstallationUuid(String paramString)
    {
      this.installationUuid = paramString;
      return this;
    }
    
    public CrashlyticsReport.Session.Application.Builder setOrganization(CrashlyticsReport.Session.Application.Organization paramOrganization)
    {
      this.organization = paramOrganization;
      return this;
    }
    
    public CrashlyticsReport.Session.Application.Builder setVersion(String paramString)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_Session_Application.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */