package com.google.android.gms.internal.fitness;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class zzj
{
  public static <DP, DT> String zza(DP paramDP, zzg<DP, DT> paramzzg)
  {
    zzh localzzh = paramzzg.zzb();
    if (!localzzh.zzb(paramzzg.zzb(paramDP))) {
      return null;
    }
    Object localObject1 = paramzzg.zza(paramDP);
    int i = 0;
    while (i < localzzh.zzc(localObject1))
    {
      Object localObject2 = localzzh.zzf(localObject1, i);
      if (!paramzzg.zzc(paramDP, i))
      {
        if ((!localzzh.zze(localObject1, i)) && (!zzk.zzep.contains(localObject2))) {
          return String.valueOf(localObject2).concat(" not set");
        }
      }
      else
      {
        double d = localzzh.zzd(localObject1, i);
        if (d == 1.0D)
        {
          d = paramzzg.zzb(paramDP, i);
        }
        else
        {
          if (d != 2.0D) {
            break label268;
          }
          d = paramzzg.zza(paramDP, i);
        }
        Object localObject3 = zzk.zzs().zzk((String)localObject2);
        if ((localObject3 != null) && (!((zzm)localObject3).zza(d))) {
          return "Field out of range";
        }
        localObject3 = localzzh.zzd(localObject1);
        localObject2 = zzk.zzs().zza((String)localObject3, (String)localObject2);
        if (localObject2 != null)
        {
          long l = paramzzg.zza(paramDP, TimeUnit.NANOSECONDS);
          if (l == 0L)
          {
            if (d == 0.0D) {
              return null;
            }
            return "DataPoint out of range";
          }
          if (!((zzm)localObject2).zza(d / l)) {
            return "DataPoint out of range";
          }
        }
      }
      label268:
      i += 1;
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */