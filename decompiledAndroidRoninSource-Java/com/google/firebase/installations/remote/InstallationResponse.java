package com.google.firebase.installations.remote;

public abstract class InstallationResponse
{
  public static Builder builder()
  {
    return new AutoValue_InstallationResponse.Builder();
  }
  
  public abstract TokenResult getAuthToken();
  
  public abstract String getFid();
  
  public abstract String getRefreshToken();
  
  public abstract ResponseCode getResponseCode();
  
  public abstract String getUri();
  
  public abstract Builder toBuilder();
  
  public static abstract class Builder
  {
    public abstract InstallationResponse build();
    
    public abstract Builder setAuthToken(TokenResult paramTokenResult);
    
    public abstract Builder setFid(String paramString);
    
    public abstract Builder setRefreshToken(String paramString);
    
    public abstract Builder setResponseCode(InstallationResponse.ResponseCode paramResponseCode);
    
    public abstract Builder setUri(String paramString);
  }
  
  public static enum ResponseCode
  {
    static
    {
      ResponseCode localResponseCode = new ResponseCode("BAD_CONFIG", 1);
      BAD_CONFIG = localResponseCode;
      $VALUES = new ResponseCode[] { OK, localResponseCode };
    }
    
    private ResponseCode() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\installations\remote\InstallationResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */