package com.google.firebase.installations;

public abstract class InstallationTokenResult
{
  public static Builder builder()
  {
    return new AutoValue_InstallationTokenResult.Builder();
  }
  
  public abstract String getToken();
  
  public abstract long getTokenCreationTimestamp();
  
  public abstract long getTokenExpirationTimestamp();
  
  public abstract Builder toBuilder();
  
  public static abstract class Builder
  {
    public abstract InstallationTokenResult build();
    
    public abstract Builder setToken(String paramString);
    
    public abstract Builder setTokenCreationTimestamp(long paramLong);
    
    public abstract Builder setTokenExpirationTimestamp(long paramLong);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\installations\InstallationTokenResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */