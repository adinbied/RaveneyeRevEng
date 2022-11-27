package com.google.android.gms.common.api;

public class ApiException
  extends Exception
{
  protected final Status mStatus;
  
  public ApiException(Status paramStatus)
  {
    super(localStringBuilder.toString());
    this.mStatus = paramStatus;
  }
  
  public int getStatusCode()
  {
    return this.mStatus.getStatusCode();
  }
  
  @Deprecated
  public String getStatusMessage()
  {
    return this.mStatus.getStatusMessage();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\ApiException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */