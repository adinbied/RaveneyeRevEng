package com.google.android.gms.measurement.internal;

final class zzeq
  implements Runnable
{
  zzeq(zzer paramzzer, int paramInt, String paramString, Object paramObject1, Object paramObject2, Object paramObject3) {}
  
  public final void run()
  {
    zzfd localzzfd = this.zzf.zzy.zzb();
    if (!localzzfd.zzz())
    {
      this.zzf.zza(6, "Persisted config not initialized. Not logging error/warn");
      return;
    }
    if (zzer.zza(this.zzf) == 0) {
      if (this.zzf.zzs().zze()) {
        zzer.zza(this.zzf, 'C');
      } else {
        zzer.zza(this.zzf, 'c');
      }
    }
    if (zzer.zzb(this.zzf) < 0L) {
      zzer.zza(this.zzf, 32053L);
    }
    char c1 = "01VDIWEA?".charAt(this.zza);
    char c2 = zzer.zza(this.zzf);
    long l = zzer.zzb(this.zzf);
    Object localObject1 = zzer.zza(true, this.zzb, this.zzc, this.zzd, this.zze);
    Object localObject2 = new StringBuilder(String.valueOf(localObject1).length() + 24);
    ((StringBuilder)localObject2).append("2");
    ((StringBuilder)localObject2).append(c1);
    ((StringBuilder)localObject2).append(c2);
    ((StringBuilder)localObject2).append(l);
    ((StringBuilder)localObject2).append(":");
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject1 = localObject2;
    if (((String)localObject2).length() > 1024) {
      localObject1 = this.zzb.substring(0, 1024);
    }
    localzzfd.zzb.zza((String)localObject1, 1L);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzeq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */