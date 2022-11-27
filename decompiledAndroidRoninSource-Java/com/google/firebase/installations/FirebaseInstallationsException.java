package com.google.firebase.installations;

import com.google.firebase.FirebaseException;

public class FirebaseInstallationsException
  extends FirebaseException
{
  private final Status status;
  
  public FirebaseInstallationsException(Status paramStatus)
  {
    this.status = paramStatus;
  }
  
  public FirebaseInstallationsException(String paramString, Status paramStatus)
  {
    super(paramString);
    this.status = paramStatus;
  }
  
  public FirebaseInstallationsException(String paramString, Status paramStatus, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    this.status = paramStatus;
  }
  
  public Status getStatus()
  {
    return this.status;
  }
  
  public static enum Status
  {
    static
    {
      Status localStatus = new Status("UNAVAILABLE", 1);
      UNAVAILABLE = localStatus;
      $VALUES = new Status[] { BAD_CONFIG, localStatus };
    }
    
    private Status() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\installations\FirebaseInstallationsException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */