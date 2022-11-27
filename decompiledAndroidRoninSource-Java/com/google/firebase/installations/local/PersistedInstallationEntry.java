package com.google.firebase.installations.local;

public abstract class PersistedInstallationEntry
{
  public static PersistedInstallationEntry INSTANCE = builder().build();
  
  public static Builder builder()
  {
    return new AutoValue_PersistedInstallationEntry.Builder().setTokenCreationEpochInSecs(0L).setRegistrationStatus(PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION).setExpiresInSecs(0L);
  }
  
  public abstract String getAuthToken();
  
  public abstract long getExpiresInSecs();
  
  public abstract String getFirebaseInstallationId();
  
  public abstract String getFisError();
  
  public abstract String getRefreshToken();
  
  public abstract PersistedInstallation.RegistrationStatus getRegistrationStatus();
  
  public abstract long getTokenCreationEpochInSecs();
  
  public boolean isErrored()
  {
    return getRegistrationStatus() == PersistedInstallation.RegistrationStatus.REGISTER_ERROR;
  }
  
  public boolean isNotGenerated()
  {
    return (getRegistrationStatus() == PersistedInstallation.RegistrationStatus.NOT_GENERATED) || (getRegistrationStatus() == PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION);
  }
  
  public boolean isRegistered()
  {
    return getRegistrationStatus() == PersistedInstallation.RegistrationStatus.REGISTERED;
  }
  
  public boolean isUnregistered()
  {
    return getRegistrationStatus() == PersistedInstallation.RegistrationStatus.UNREGISTERED;
  }
  
  public boolean shouldAttemptMigration()
  {
    return getRegistrationStatus() == PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION;
  }
  
  public abstract Builder toBuilder();
  
  public PersistedInstallationEntry withAuthToken(String paramString, long paramLong1, long paramLong2)
  {
    return toBuilder().setAuthToken(paramString).setExpiresInSecs(paramLong1).setTokenCreationEpochInSecs(paramLong2).build();
  }
  
  public PersistedInstallationEntry withClearedAuthToken()
  {
    return toBuilder().setAuthToken(null).build();
  }
  
  public PersistedInstallationEntry withFisError(String paramString)
  {
    return toBuilder().setFisError(paramString).setRegistrationStatus(PersistedInstallation.RegistrationStatus.REGISTER_ERROR).build();
  }
  
  public PersistedInstallationEntry withNoGeneratedFid()
  {
    return toBuilder().setRegistrationStatus(PersistedInstallation.RegistrationStatus.NOT_GENERATED).build();
  }
  
  public PersistedInstallationEntry withRegisteredFid(String paramString1, String paramString2, long paramLong1, String paramString3, long paramLong2)
  {
    return toBuilder().setFirebaseInstallationId(paramString1).setRegistrationStatus(PersistedInstallation.RegistrationStatus.REGISTERED).setAuthToken(paramString3).setRefreshToken(paramString2).setExpiresInSecs(paramLong2).setTokenCreationEpochInSecs(paramLong1).build();
  }
  
  public PersistedInstallationEntry withUnregisteredFid(String paramString)
  {
    return toBuilder().setFirebaseInstallationId(paramString).setRegistrationStatus(PersistedInstallation.RegistrationStatus.UNREGISTERED).build();
  }
  
  public static abstract class Builder
  {
    public abstract PersistedInstallationEntry build();
    
    public abstract Builder setAuthToken(String paramString);
    
    public abstract Builder setExpiresInSecs(long paramLong);
    
    public abstract Builder setFirebaseInstallationId(String paramString);
    
    public abstract Builder setFisError(String paramString);
    
    public abstract Builder setRefreshToken(String paramString);
    
    public abstract Builder setRegistrationStatus(PersistedInstallation.RegistrationStatus paramRegistrationStatus);
    
    public abstract Builder setTokenCreationEpochInSecs(long paramLong);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\installations\local\PersistedInstallationEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */