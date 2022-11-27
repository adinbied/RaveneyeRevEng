package dji.sdksharedlib.listener;

import dji.common.error.DJIError;

public abstract interface DJIActionCallback
{
  public abstract void onFails(DJIError paramDJIError);
  
  public abstract void onSuccess();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\listener\DJIActionCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */