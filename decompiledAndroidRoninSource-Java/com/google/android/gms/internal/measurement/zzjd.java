package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzjd
  implements zzje
{
  public final int zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    paramObject1 = (zzjb)paramObject1;
    paramObject2 = (zziz)paramObject2;
    if (((zzjb)paramObject1).isEmpty()) {
      return 0;
    }
    paramObject1 = ((zzjb)paramObject1).entrySet().iterator();
    if (!((Iterator)paramObject1).hasNext()) {
      return 0;
    }
    paramObject1 = (Map.Entry)((Iterator)paramObject1).next();
    ((Map.Entry)paramObject1).getKey();
    ((Map.Entry)paramObject1).getValue();
    throw new NoSuchMethodError();
  }
  
  public final Object zza(Object paramObject1, Object paramObject2)
  {
    zzjb localzzjb = (zzjb)paramObject1;
    paramObject2 = (zzjb)paramObject2;
    paramObject1 = localzzjb;
    if (!((zzjb)paramObject2).isEmpty())
    {
      paramObject1 = localzzjb;
      if (!localzzjb.zzd()) {
        paramObject1 = localzzjb.zzb();
      }
      ((zzjb)paramObject1).zza((zzjb)paramObject2);
    }
    return paramObject1;
  }
  
  public final Map<?, ?> zza(Object paramObject)
  {
    return (zzjb)paramObject;
  }
  
  public final zzjc<?, ?> zzb(Object paramObject)
  {
    paramObject = (zziz)paramObject;
    throw new NoSuchMethodError();
  }
  
  public final Map<?, ?> zzc(Object paramObject)
  {
    return (zzjb)paramObject;
  }
  
  public final boolean zzd(Object paramObject)
  {
    return !((zzjb)paramObject).zzd();
  }
  
  public final Object zze(Object paramObject)
  {
    ((zzjb)paramObject).zzc();
    return paramObject;
  }
  
  public final Object zzf(Object paramObject)
  {
    return zzjb.zza().zzb();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzjd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */