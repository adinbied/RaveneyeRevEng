package com.google.android.gms.tasks;

final class zzn
  implements Runnable
{
  zzn(zzm paramzzm, Task paramTask) {}
  
  public final void run()
  {
    synchronized (zzm.zza(this.zzq))
    {
      if (zzm.zzb(this.zzq) != null) {
        zzm.zzb(this.zzq).onSuccess(this.zzg.getResult());
      }
      return;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\tasks\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */