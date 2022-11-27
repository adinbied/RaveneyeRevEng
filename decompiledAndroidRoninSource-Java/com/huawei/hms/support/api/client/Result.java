package com.huawei.hms.support.api.client;

public abstract class Result
{
  private Status a = Status.FAILURE;
  
  public Status getStatus()
  {
    return this.a;
  }
  
  public void setStatus(Status paramStatus)
  {
    if (paramStatus == null) {
      return;
    }
    this.a = paramStatus;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\client\Result.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */