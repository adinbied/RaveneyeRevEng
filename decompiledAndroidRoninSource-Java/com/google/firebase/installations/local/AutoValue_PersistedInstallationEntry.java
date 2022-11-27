package com.google.firebase.installations.local;

final class AutoValue_PersistedInstallationEntry
  extends PersistedInstallationEntry
{
  private final String authToken;
  private final long expiresInSecs;
  private final String firebaseInstallationId;
  private final String fisError;
  private final String refreshToken;
  private final PersistedInstallation.RegistrationStatus registrationStatus;
  private final long tokenCreationEpochInSecs;
  
  private AutoValue_PersistedInstallationEntry(String paramString1, PersistedInstallation.RegistrationStatus paramRegistrationStatus, String paramString2, String paramString3, long paramLong1, long paramLong2, String paramString4)
  {
    this.firebaseInstallationId = paramString1;
    this.registrationStatus = paramRegistrationStatus;
    this.authToken = paramString2;
    this.refreshToken = paramString3;
    this.expiresInSecs = paramLong1;
    this.tokenCreationEpochInSecs = paramLong2;
    this.fisError = paramString4;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof PersistedInstallationEntry))
    {
      paramObject = (PersistedInstallationEntry)paramObject;
      String str = this.firebaseInstallationId;
      if ((str == null ? ((PersistedInstallationEntry)paramObject).getFirebaseInstallationId() == null : str.equals(((PersistedInstallationEntry)paramObject).getFirebaseInstallationId())) && (this.registrationStatus.equals(((PersistedInstallationEntry)paramObject).getRegistrationStatus())))
      {
        str = this.authToken;
        if (str == null ? ((PersistedInstallationEntry)paramObject).getAuthToken() == null : str.equals(((PersistedInstallationEntry)paramObject).getAuthToken()))
        {
          str = this.refreshToken;
          if ((str == null ? ((PersistedInstallationEntry)paramObject).getRefreshToken() == null : str.equals(((PersistedInstallationEntry)paramObject).getRefreshToken())) && (this.expiresInSecs == ((PersistedInstallationEntry)paramObject).getExpiresInSecs()) && (this.tokenCreationEpochInSecs == ((PersistedInstallationEntry)paramObject).getTokenCreationEpochInSecs()))
          {
            str = this.fisError;
            if (str == null)
            {
              if (((PersistedInstallationEntry)paramObject).getFisError() == null) {
                return true;
              }
            }
            else if (str.equals(((PersistedInstallationEntry)paramObject).getFisError())) {
              return true;
            }
          }
        }
      }
      return false;
    }
    return false;
  }
  
  public String getAuthToken()
  {
    return this.authToken;
  }
  
  public long getExpiresInSecs()
  {
    return this.expiresInSecs;
  }
  
  public String getFirebaseInstallationId()
  {
    return this.firebaseInstallationId;
  }
  
  public String getFisError()
  {
    return this.fisError;
  }
  
  public String getRefreshToken()
  {
    return this.refreshToken;
  }
  
  public PersistedInstallation.RegistrationStatus getRegistrationStatus()
  {
    return this.registrationStatus;
  }
  
  public long getTokenCreationEpochInSecs()
  {
    return this.tokenCreationEpochInSecs;
  }
  
  public int hashCode()
  {
    String str = this.firebaseInstallationId;
    int m = 0;
    int i;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    }
    int n = this.registrationStatus.hashCode();
    str = this.authToken;
    int j;
    if (str == null) {
      j = 0;
    } else {
      j = str.hashCode();
    }
    str = this.refreshToken;
    int k;
    if (str == null) {
      k = 0;
    } else {
      k = str.hashCode();
    }
    long l = this.expiresInSecs;
    int i1 = (int)(l ^ l >>> 32);
    l = this.tokenCreationEpochInSecs;
    int i2 = (int)(l ^ l >>> 32);
    str = this.fisError;
    if (str != null) {
      m = str.hashCode();
    }
    return ((((((i ^ 0xF4243) * 1000003 ^ n) * 1000003 ^ j) * 1000003 ^ k) * 1000003 ^ i1) * 1000003 ^ i2) * 1000003 ^ m;
  }
  
  public PersistedInstallationEntry.Builder toBuilder()
  {
    return new Builder(this, null);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PersistedInstallationEntry{firebaseInstallationId=");
    localStringBuilder.append(this.firebaseInstallationId);
    localStringBuilder.append(", registrationStatus=");
    localStringBuilder.append(this.registrationStatus);
    localStringBuilder.append(", authToken=");
    localStringBuilder.append(this.authToken);
    localStringBuilder.append(", refreshToken=");
    localStringBuilder.append(this.refreshToken);
    localStringBuilder.append(", expiresInSecs=");
    localStringBuilder.append(this.expiresInSecs);
    localStringBuilder.append(", tokenCreationEpochInSecs=");
    localStringBuilder.append(this.tokenCreationEpochInSecs);
    localStringBuilder.append(", fisError=");
    localStringBuilder.append(this.fisError);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends PersistedInstallationEntry.Builder
  {
    private String authToken;
    private Long expiresInSecs;
    private String firebaseInstallationId;
    private String fisError;
    private String refreshToken;
    private PersistedInstallation.RegistrationStatus registrationStatus;
    private Long tokenCreationEpochInSecs;
    
    Builder() {}
    
    private Builder(PersistedInstallationEntry paramPersistedInstallationEntry)
    {
      this.firebaseInstallationId = paramPersistedInstallationEntry.getFirebaseInstallationId();
      this.registrationStatus = paramPersistedInstallationEntry.getRegistrationStatus();
      this.authToken = paramPersistedInstallationEntry.getAuthToken();
      this.refreshToken = paramPersistedInstallationEntry.getRefreshToken();
      this.expiresInSecs = Long.valueOf(paramPersistedInstallationEntry.getExpiresInSecs());
      this.tokenCreationEpochInSecs = Long.valueOf(paramPersistedInstallationEntry.getTokenCreationEpochInSecs());
      this.fisError = paramPersistedInstallationEntry.getFisError();
    }
    
    public PersistedInstallationEntry build()
    {
      Object localObject2 = this.registrationStatus;
      Object localObject1 = "";
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" registrationStatus");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.expiresInSecs == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" expiresInSecs");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.tokenCreationEpochInSecs == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" tokenCreationEpochInSecs");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (((String)localObject1).isEmpty()) {
        return new AutoValue_PersistedInstallationEntry(this.firebaseInstallationId, this.registrationStatus, this.authToken, this.refreshToken, this.expiresInSecs.longValue(), this.tokenCreationEpochInSecs.longValue(), this.fisError, null);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Missing required properties:");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    
    public PersistedInstallationEntry.Builder setAuthToken(String paramString)
    {
      this.authToken = paramString;
      return this;
    }
    
    public PersistedInstallationEntry.Builder setExpiresInSecs(long paramLong)
    {
      this.expiresInSecs = Long.valueOf(paramLong);
      return this;
    }
    
    public PersistedInstallationEntry.Builder setFirebaseInstallationId(String paramString)
    {
      this.firebaseInstallationId = paramString;
      return this;
    }
    
    public PersistedInstallationEntry.Builder setFisError(String paramString)
    {
      this.fisError = paramString;
      return this;
    }
    
    public PersistedInstallationEntry.Builder setRefreshToken(String paramString)
    {
      this.refreshToken = paramString;
      return this;
    }
    
    public PersistedInstallationEntry.Builder setRegistrationStatus(PersistedInstallation.RegistrationStatus paramRegistrationStatus)
    {
      if (paramRegistrationStatus != null)
      {
        this.registrationStatus = paramRegistrationStatus;
        return this;
      }
      throw new NullPointerException("Null registrationStatus");
    }
    
    public PersistedInstallationEntry.Builder setTokenCreationEpochInSecs(long paramLong)
    {
      this.tokenCreationEpochInSecs = Long.valueOf(paramLong);
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\installations\local\AutoValue_PersistedInstallationEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */