package com.google.android.gms.internal.measurement;

import java.util.List;

final class zziw
  extends zzir
{
  private zziw()
  {
    super(null);
  }
  
  private static <E> zzii<E> zzc(Object paramObject, long paramLong)
  {
    return (zzii)zzkx.zzf(paramObject, paramLong);
  }
  
  final <L> List<L> zza(Object paramObject, long paramLong)
  {
    zzii localzzii2 = zzc(paramObject, paramLong);
    zzii localzzii1 = localzzii2;
    if (!localzzii2.zza())
    {
      int i = localzzii2.size();
      if (i == 0) {
        i = 10;
      } else {
        i <<= 1;
      }
      localzzii1 = localzzii2.zza(i);
      zzkx.zza(paramObject, paramLong, localzzii1);
    }
    return localzzii1;
  }
  
  final <E> void zza(Object paramObject1, Object paramObject2, long paramLong)
  {
    Object localObject = zzc(paramObject1, paramLong);
    zzii localzzii = zzc(paramObject2, paramLong);
    int i = ((zzii)localObject).size();
    int j = localzzii.size();
    paramObject2 = localObject;
    if (i > 0)
    {
      paramObject2 = localObject;
      if (j > 0)
      {
        paramObject2 = localObject;
        if (!((zzii)localObject).zza()) {
          paramObject2 = ((zzii)localObject).zza(j + i);
        }
        ((zzii)paramObject2).addAll(localzzii);
      }
    }
    localObject = localzzii;
    if (i > 0) {
      localObject = paramObject2;
    }
    zzkx.zza(paramObject1, paramLong, localObject);
  }
  
  final void zzb(Object paramObject, long paramLong)
  {
    zzc(paramObject, paramLong).zzb();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zziw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */