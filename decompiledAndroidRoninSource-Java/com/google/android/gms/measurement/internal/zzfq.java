package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class zzfq
  implements Thread.UncaughtExceptionHandler
{
  private final String zza;
  
  public zzfq(zzfo paramzzfo, String paramString)
  {
    Preconditions.checkNotNull(paramString);
    this.zza = paramString;
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      this.zzb.zzq().zze().zza(this.zza, paramThrowable);
      return;
    }
    finally
    {
      paramThread = finally;
      throw paramThread;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzfq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */