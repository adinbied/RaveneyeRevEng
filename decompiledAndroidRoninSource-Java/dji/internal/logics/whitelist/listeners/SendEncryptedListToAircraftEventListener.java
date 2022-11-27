package dji.internal.logics.whitelist.listeners;

import dji.common.error.DJIError;

public abstract interface SendEncryptedListToAircraftEventListener
{
  public abstract void onFail(DJIError paramDJIError);
  
  public abstract void onProgressChange(int paramInt);
  
  public abstract void onSucceed();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\logics\whitelist\listeners\SendEncryptedListToAircraftEventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */