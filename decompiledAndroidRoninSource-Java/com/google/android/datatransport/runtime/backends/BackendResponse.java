package com.google.android.datatransport.runtime.backends;

public abstract class BackendResponse
{
  public static BackendResponse fatalError()
  {
    return new AutoValue_BackendResponse(Status.FATAL_ERROR, -1L);
  }
  
  public static BackendResponse ok(long paramLong)
  {
    return new AutoValue_BackendResponse(Status.OK, paramLong);
  }
  
  public static BackendResponse transientError()
  {
    return new AutoValue_BackendResponse(Status.TRANSIENT_ERROR, -1L);
  }
  
  public abstract long getNextRequestWaitMillis();
  
  public abstract Status getStatus();
  
  public static enum Status
  {
    static
    {
      Status localStatus = new Status("FATAL_ERROR", 2);
      FATAL_ERROR = localStatus;
      $VALUES = new Status[] { OK, TRANSIENT_ERROR, localStatus };
    }
    
    private Status() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\backends\BackendResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */