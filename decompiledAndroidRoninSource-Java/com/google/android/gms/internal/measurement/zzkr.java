package com.google.android.gms.internal.measurement;

import java.io.IOException;

abstract class zzkr<T, B>
{
  abstract B zza();
  
  abstract T zza(B paramB);
  
  abstract void zza(B paramB, int paramInt1, int paramInt2);
  
  abstract void zza(B paramB, int paramInt, long paramLong);
  
  abstract void zza(B paramB, int paramInt, zzgr paramzzgr);
  
  abstract void zza(B paramB, int paramInt, T paramT);
  
  abstract void zza(T paramT, zzlo paramzzlo)
    throws IOException;
  
  abstract void zza(Object paramObject, T paramT);
  
  abstract boolean zza(zzka paramzzka);
  
  final boolean zza(B paramB, zzka paramzzka)
    throws IOException
  {
    int j = paramzzka.zzb();
    int i = j >>> 3;
    j &= 0x7;
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j != 4)
            {
              if (j == 5)
              {
                zza(paramB, i, paramzzka.zzj());
                return true;
              }
              throw zzih.zzf();
            }
            return false;
          }
          Object localObject = zza();
          while ((paramzzka.zza() != Integer.MAX_VALUE) && (zza(localObject, paramzzka))) {}
          if ((0x4 | i << 3) == paramzzka.zzb())
          {
            zza(paramB, i, zza(localObject));
            return true;
          }
          throw zzih.zze();
        }
        zza(paramB, i, paramzzka.zzn());
        return true;
      }
      zzb(paramB, i, paramzzka.zzi());
      return true;
    }
    zza(paramB, i, paramzzka.zzg());
    return true;
  }
  
  abstract T zzb(Object paramObject);
  
  abstract void zzb(B paramB, int paramInt, long paramLong);
  
  abstract void zzb(T paramT, zzlo paramzzlo)
    throws IOException;
  
  abstract void zzb(Object paramObject, B paramB);
  
  abstract B zzc(Object paramObject);
  
  abstract T zzc(T paramT1, T paramT2);
  
  abstract void zzd(Object paramObject);
  
  abstract int zze(T paramT);
  
  abstract int zzf(T paramT);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzkr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */