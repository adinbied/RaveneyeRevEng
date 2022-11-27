package com.google.firebase.installations.remote;

public abstract class TokenResult
{
  public static Builder builder()
  {
    return new AutoValue_TokenResult.Builder().setTokenExpirationTimestamp(0L);
  }
  
  public abstract ResponseCode getResponseCode();
  
  public abstract String getToken();
  
  public abstract long getTokenExpirationTimestamp();
  
  public abstract Builder toBuilder();
  
  public static abstract class Builder
  {
    public abstract TokenResult build();
    
    public abstract Builder setResponseCode(TokenResult.ResponseCode paramResponseCode);
    
    public abstract Builder setToken(String paramString);
    
    public abstract Builder setTokenExpirationTimestamp(long paramLong);
  }
  
  public static enum ResponseCode
  {
    static
    {
      BAD_CONFIG = new ResponseCode("BAD_CONFIG", 1);
      ResponseCode localResponseCode = new ResponseCode("AUTH_ERROR", 2);
      AUTH_ERROR = localResponseCode;
      $VALUES = new ResponseCode[] { OK, BAD_CONFIG, localResponseCode };
    }
    
    private ResponseCode() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\installations\remote\TokenResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */