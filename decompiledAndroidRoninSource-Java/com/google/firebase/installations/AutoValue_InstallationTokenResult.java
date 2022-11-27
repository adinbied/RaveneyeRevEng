package com.google.firebase.installations;

final class AutoValue_InstallationTokenResult
  extends InstallationTokenResult
{
  private final String token;
  private final long tokenCreationTimestamp;
  private final long tokenExpirationTimestamp;
  
  private AutoValue_InstallationTokenResult(String paramString, long paramLong1, long paramLong2)
  {
    this.token = paramString;
    this.tokenExpirationTimestamp = paramLong1;
    this.tokenCreationTimestamp = paramLong2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof InstallationTokenResult))
    {
      paramObject = (InstallationTokenResult)paramObject;
      return (this.token.equals(((InstallationTokenResult)paramObject).getToken())) && (this.tokenExpirationTimestamp == ((InstallationTokenResult)paramObject).getTokenExpirationTimestamp()) && (this.tokenCreationTimestamp == ((InstallationTokenResult)paramObject).getTokenCreationTimestamp());
    }
    return false;
  }
  
  public String getToken()
  {
    return this.token;
  }
  
  public long getTokenCreationTimestamp()
  {
    return this.tokenCreationTimestamp;
  }
  
  public long getTokenExpirationTimestamp()
  {
    return this.tokenExpirationTimestamp;
  }
  
  public int hashCode()
  {
    int i = this.token.hashCode();
    long l = this.tokenExpirationTimestamp;
    int j = (int)(l ^ l >>> 32);
    l = this.tokenCreationTimestamp;
    return ((i ^ 0xF4243) * 1000003 ^ j) * 1000003 ^ (int)(l ^ l >>> 32);
  }
  
  public InstallationTokenResult.Builder toBuilder()
  {
    return new Builder(this, null);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InstallationTokenResult{token=");
    localStringBuilder.append(this.token);
    localStringBuilder.append(", tokenExpirationTimestamp=");
    localStringBuilder.append(this.tokenExpirationTimestamp);
    localStringBuilder.append(", tokenCreationTimestamp=");
    localStringBuilder.append(this.tokenCreationTimestamp);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends InstallationTokenResult.Builder
  {
    private String token;
    private Long tokenCreationTimestamp;
    private Long tokenExpirationTimestamp;
    
    Builder() {}
    
    private Builder(InstallationTokenResult paramInstallationTokenResult)
    {
      this.token = paramInstallationTokenResult.getToken();
      this.tokenExpirationTimestamp = Long.valueOf(paramInstallationTokenResult.getTokenExpirationTimestamp());
      this.tokenCreationTimestamp = Long.valueOf(paramInstallationTokenResult.getTokenCreationTimestamp());
    }
    
    public InstallationTokenResult build()
    {
      Object localObject2 = this.token;
      Object localObject1 = "";
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" token");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.tokenExpirationTimestamp == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" tokenExpirationTimestamp");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.tokenCreationTimestamp == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" tokenCreationTimestamp");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (((String)localObject1).isEmpty()) {
        return new AutoValue_InstallationTokenResult(this.token, this.tokenExpirationTimestamp.longValue(), this.tokenCreationTimestamp.longValue(), null);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Missing required properties:");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    
    public InstallationTokenResult.Builder setToken(String paramString)
    {
      if (paramString != null)
      {
        this.token = paramString;
        return this;
      }
      throw new NullPointerException("Null token");
    }
    
    public InstallationTokenResult.Builder setTokenCreationTimestamp(long paramLong)
    {
      this.tokenCreationTimestamp = Long.valueOf(paramLong);
      return this;
    }
    
    public InstallationTokenResult.Builder setTokenExpirationTimestamp(long paramLong)
    {
      this.tokenExpirationTimestamp = Long.valueOf(paramLong);
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\installations\AutoValue_InstallationTokenResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */