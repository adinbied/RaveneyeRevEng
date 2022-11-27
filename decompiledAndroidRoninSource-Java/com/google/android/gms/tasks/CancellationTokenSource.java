package com.google.android.gms.tasks;

public class CancellationTokenSource
{
  private final zza zzc = new zza();
  
  public void cancel()
  {
    this.zzc.cancel();
  }
  
  public CancellationToken getToken()
  {
    return this.zzc;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\tasks\CancellationTokenSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */