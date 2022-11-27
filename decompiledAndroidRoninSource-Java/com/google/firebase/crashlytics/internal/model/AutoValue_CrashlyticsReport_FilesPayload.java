package com.google.firebase.crashlytics.internal.model;

final class AutoValue_CrashlyticsReport_FilesPayload
  extends CrashlyticsReport.FilesPayload
{
  private final ImmutableList<CrashlyticsReport.FilesPayload.File> files;
  private final String orgId;
  
  private AutoValue_CrashlyticsReport_FilesPayload(ImmutableList<CrashlyticsReport.FilesPayload.File> paramImmutableList, String paramString)
  {
    this.files = paramImmutableList;
    this.orgId = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.FilesPayload))
    {
      paramObject = (CrashlyticsReport.FilesPayload)paramObject;
      if (this.files.equals(((CrashlyticsReport.FilesPayload)paramObject).getFiles()))
      {
        String str = this.orgId;
        if (str == null)
        {
          if (((CrashlyticsReport.FilesPayload)paramObject).getOrgId() == null) {
            return true;
          }
        }
        else if (str.equals(((CrashlyticsReport.FilesPayload)paramObject).getOrgId())) {
          return true;
        }
      }
      return false;
    }
    return false;
  }
  
  public ImmutableList<CrashlyticsReport.FilesPayload.File> getFiles()
  {
    return this.files;
  }
  
  public String getOrgId()
  {
    return this.orgId;
  }
  
  public int hashCode()
  {
    int j = this.files.hashCode();
    String str = this.orgId;
    int i;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    }
    return (j ^ 0xF4243) * 1000003 ^ i;
  }
  
  CrashlyticsReport.FilesPayload.Builder toBuilder()
  {
    return new Builder(this, null);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FilesPayload{files=");
    localStringBuilder.append(this.files);
    localStringBuilder.append(", orgId=");
    localStringBuilder.append(this.orgId);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.FilesPayload.Builder
  {
    private ImmutableList<CrashlyticsReport.FilesPayload.File> files;
    private String orgId;
    
    Builder() {}
    
    private Builder(CrashlyticsReport.FilesPayload paramFilesPayload)
    {
      this.files = paramFilesPayload.getFiles();
      this.orgId = paramFilesPayload.getOrgId();
    }
    
    public CrashlyticsReport.FilesPayload build()
    {
      Object localObject2 = this.files;
      Object localObject1 = "";
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" files");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (((String)localObject1).isEmpty()) {
        return new AutoValue_CrashlyticsReport_FilesPayload(this.files, this.orgId, null);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Missing required properties:");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    
    public CrashlyticsReport.FilesPayload.Builder setFiles(ImmutableList<CrashlyticsReport.FilesPayload.File> paramImmutableList)
    {
      if (paramImmutableList != null)
      {
        this.files = paramImmutableList;
        return this;
      }
      throw new NullPointerException("Null files");
    }
    
    public CrashlyticsReport.FilesPayload.Builder setOrgId(String paramString)
    {
      this.orgId = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_FilesPayload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */