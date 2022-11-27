package com.google.android.datatransport.runtime.backends;

final class AutoValue_BackendResponse
  extends BackendResponse
{
  private final long nextRequestWaitMillis;
  private final BackendResponse.Status status;
  
  AutoValue_BackendResponse(BackendResponse.Status paramStatus, long paramLong)
  {
    if (paramStatus != null)
    {
      this.status = paramStatus;
      this.nextRequestWaitMillis = paramLong;
      return;
    }
    throw new NullPointerException("Null status");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof BackendResponse))
    {
      paramObject = (BackendResponse)paramObject;
      return (this.status.equals(((BackendResponse)paramObject).getStatus())) && (this.nextRequestWaitMillis == ((BackendResponse)paramObject).getNextRequestWaitMillis());
    }
    return false;
  }
  
  public long getNextRequestWaitMillis()
  {
    return this.nextRequestWaitMillis;
  }
  
  public BackendResponse.Status getStatus()
  {
    return this.status;
  }
  
  public int hashCode()
  {
    int i = this.status.hashCode();
    long l = this.nextRequestWaitMillis;
    return (i ^ 0xF4243) * 1000003 ^ (int)(l ^ l >>> 32);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BackendResponse{status=");
    localStringBuilder.append(this.status);
    localStringBuilder.append(", nextRequestWaitMillis=");
    localStringBuilder.append(this.nextRequestWaitMillis);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\backends\AutoValue_BackendResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */