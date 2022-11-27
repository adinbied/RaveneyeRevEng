package com.google.firebase.installations.remote;

final class AutoValue_TokenResult
  extends TokenResult
{
  private final TokenResult.ResponseCode responseCode;
  private final String token;
  private final long tokenExpirationTimestamp;
  
  private AutoValue_TokenResult(String paramString, long paramLong, TokenResult.ResponseCode paramResponseCode)
  {
    this.token = paramString;
    this.tokenExpirationTimestamp = paramLong;
    this.responseCode = paramResponseCode;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof TokenResult))
    {
      paramObject = (TokenResult)paramObject;
      Object localObject = this.token;
      if ((localObject == null ? ((TokenResult)paramObject).getToken() == null : ((String)localObject).equals(((TokenResult)paramObject).getToken())) && (this.tokenExpirationTimestamp == ((TokenResult)paramObject).getTokenExpirationTimestamp()))
      {
        localObject = this.responseCode;
        if (localObject == null)
        {
          if (((TokenResult)paramObject).getResponseCode() == null) {
            return true;
          }
        }
        else if (((TokenResult.ResponseCode)localObject).equals(((TokenResult)paramObject).getResponseCode())) {
          return true;
        }
      }
      return false;
    }
    return false;
  }
  
  public TokenResult.ResponseCode getResponseCode()
  {
    return this.responseCode;
  }
  
  public String getToken()
  {
    return this.token;
  }
  
  public long getTokenExpirationTimestamp()
  {
    return this.tokenExpirationTimestamp;
  }
  
  public int hashCode()
  {
    Object localObject = this.token;
    int j = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((String)localObject).hashCode();
    }
    long l = this.tokenExpirationTimestamp;
    int k = (int)(l ^ l >>> 32);
    localObject = this.responseCode;
    if (localObject != null) {
      j = ((TokenResult.ResponseCode)localObject).hashCode();
    }
    return ((i ^ 0xF4243) * 1000003 ^ k) * 1000003 ^ j;
  }
  
  public TokenResult.Builder toBuilder()
  {
    return new Builder(this, null);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TokenResult{token=");
    localStringBuilder.append(this.token);
    localStringBuilder.append(", tokenExpirationTimestamp=");
    localStringBuilder.append(this.tokenExpirationTimestamp);
    localStringBuilder.append(", responseCode=");
    localStringBuilder.append(this.responseCode);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends TokenResult.Builder
  {
    private TokenResult.ResponseCode responseCode;
    private String token;
    private Long tokenExpirationTimestamp;
    
    Builder() {}
    
    private Builder(TokenResult paramTokenResult)
    {
      this.token = paramTokenResult.getToken();
      this.tokenExpirationTimestamp = Long.valueOf(paramTokenResult.getTokenExpirationTimestamp());
      this.responseCode = paramTokenResult.getResponseCode();
    }
    
    public TokenResult build()
    {
      Object localObject2 = this.tokenExpirationTimestamp;
      Object localObject1 = "";
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" tokenExpirationTimestamp");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (((String)localObject1).isEmpty()) {
        return new AutoValue_TokenResult(this.token, this.tokenExpirationTimestamp.longValue(), this.responseCode, null);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Missing required properties:");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    
    public TokenResult.Builder setResponseCode(TokenResult.ResponseCode paramResponseCode)
    {
      this.responseCode = paramResponseCode;
      return this;
    }
    
    public TokenResult.Builder setToken(String paramString)
    {
      this.token = paramString;
      return this;
    }
    
    public TokenResult.Builder setTokenExpirationTimestamp(long paramLong)
    {
      this.tokenExpirationTimestamp = Long.valueOf(paramLong);
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\installations\remote\AutoValue_TokenResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */