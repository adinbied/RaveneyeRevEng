package com.google.android.gms.tasks;

final class zzd
  implements Runnable
{
  zzd(zzc paramzzc, Task paramTask) {}
  
  public final void run()
  {
    if (this.zzg.isCanceled())
    {
      zzc.zza(this.zzh).zza();
      return;
    }
    try
    {
      Object localObject = zzc.zzb(this.zzh).then(this.zzg);
      zzc.zza(this.zzh).setResult(localObject);
      return;
    }
    catch (Exception localException)
    {
      zzc.zza(this.zzh).setException(localException);
      return;
    }
    catch (RuntimeExecutionException localRuntimeExecutionException)
    {
      if ((localRuntimeExecutionException.getCause() instanceof Exception))
      {
        zzc.zza(this.zzh).setException((Exception)localRuntimeExecutionException.getCause());
        return;
      }
      zzc.zza(this.zzh).setException(localRuntimeExecutionException);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\tasks\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */