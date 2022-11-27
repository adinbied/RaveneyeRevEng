package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzbv.zzc;
import com.google.android.gms.internal.measurement.zzbv.zze;
import com.google.android.gms.internal.measurement.zzcd.zzk;
import com.google.android.gms.internal.measurement.zzmv;

final class zzu
  extends zzv
{
  private zzbv.zze zzg;
  
  zzu(zzo paramzzo, String paramString, int paramInt, zzbv.zze paramzze)
  {
    super(paramString, paramInt);
    this.zzg = paramzze;
  }
  
  final int zza()
  {
    return this.zzg.zzb();
  }
  
  final boolean zza(Long paramLong1, Long paramLong2, zzcd.zzk paramzzk, boolean paramBoolean)
  {
    int i;
    if ((zzmv.zzb()) && (this.zzh.zzs().zzd(this.zza, zzat.zzaz))) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool2 = this.zzg.zze();
    boolean bool3 = this.zzg.zzf();
    boolean bool1 = this.zzg.zzh();
    int j;
    if ((!bool2) && (!bool3) && (!bool1)) {
      j = 0;
    } else {
      j = 1;
    }
    Object localObject2 = null;
    Object localObject1 = null;
    if ((paramBoolean) && (j == 0))
    {
      paramLong2 = this.zzh.zzq().zzw();
      i = this.zzb;
      paramLong1 = (Long)localObject1;
      if (this.zzg.zza()) {
        paramLong1 = Integer.valueOf(this.zzg.zzb());
      }
      paramLong2.zza("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(i), paramLong1);
      return true;
    }
    localObject1 = this.zzg.zzd();
    bool2 = ((zzbv.zzc)localObject1).zzf();
    if (paramzzk.zzf())
    {
      if (!((zzbv.zzc)localObject1).zzc())
      {
        this.zzh.zzq().zzh().zza("No number filter for long property. property", this.zzh.zzn().zzc(paramzzk.zzc()));
        localObject1 = localObject2;
      }
      else
      {
        localObject1 = zza(zza(paramzzk.zzg(), ((zzbv.zzc)localObject1).zzd()), bool2);
      }
    }
    else if (paramzzk.zzh())
    {
      if (!((zzbv.zzc)localObject1).zzc())
      {
        this.zzh.zzq().zzh().zza("No number filter for double property. property", this.zzh.zzn().zzc(paramzzk.zzc()));
        localObject1 = localObject2;
      }
      else
      {
        localObject1 = zza(zza(paramzzk.zzi(), ((zzbv.zzc)localObject1).zzd()), bool2);
      }
    }
    else if (paramzzk.zzd())
    {
      if (!((zzbv.zzc)localObject1).zza())
      {
        if (!((zzbv.zzc)localObject1).zzc())
        {
          this.zzh.zzq().zzh().zza("No string or number filter defined. property", this.zzh.zzn().zzc(paramzzk.zzc()));
          localObject1 = localObject2;
        }
        else if (zzks.zza(paramzzk.zze()))
        {
          localObject1 = zza(zza(paramzzk.zze(), ((zzbv.zzc)localObject1).zzd()), bool2);
        }
        else
        {
          this.zzh.zzq().zzh().zza("Invalid user property value for Numeric number filter. property, value", this.zzh.zzn().zzc(paramzzk.zzc()), paramzzk.zze());
          localObject1 = localObject2;
        }
      }
      else {
        localObject1 = zza(zza(paramzzk.zze(), ((zzbv.zzc)localObject1).zzb(), this.zzh.zzq()), bool2);
      }
    }
    else
    {
      this.zzh.zzq().zzh().zza("User property has no value, property", this.zzh.zzn().zzc(paramzzk.zzc()));
      localObject1 = localObject2;
    }
    zzet localzzet = this.zzh.zzq().zzw();
    if (localObject1 == null) {
      localObject2 = "null";
    } else {
      localObject2 = localObject1;
    }
    localzzet.zza("Property filter result", localObject2);
    if (localObject1 == null) {
      return false;
    }
    this.zzc = Boolean.valueOf(true);
    if ((bool1) && (!((Boolean)localObject1).booleanValue())) {
      return true;
    }
    if ((!paramBoolean) || (this.zzg.zze())) {
      this.zzd = ((Boolean)localObject1);
    }
    if ((((Boolean)localObject1).booleanValue()) && (j != 0) && (paramzzk.zza()))
    {
      long l1 = paramzzk.zzb();
      if (paramLong1 != null) {
        l1 = paramLong1.longValue();
      }
      long l2 = l1;
      if (i != 0)
      {
        l2 = l1;
        if (this.zzg.zze())
        {
          l2 = l1;
          if (!this.zzg.zzf())
          {
            l2 = l1;
            if (paramLong2 != null) {
              l2 = paramLong2.longValue();
            }
          }
        }
      }
      if (this.zzg.zzf())
      {
        this.zzf = Long.valueOf(l2);
        return true;
      }
      this.zze = Long.valueOf(l2);
    }
    return true;
  }
  
  final boolean zzb()
  {
    return true;
  }
  
  final boolean zzc()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */