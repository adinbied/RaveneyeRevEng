package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

final class zzit
  extends zzir
{
  private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();
  
  private zzit()
  {
    super(null);
  }
  
  private static <L> List<L> zza(Object paramObject, long paramLong, int paramInt)
  {
    List localList = zzc(paramObject, paramLong);
    if (localList.isEmpty())
    {
      if ((localList instanceof zzis)) {
        localObject = new zzip(paramInt);
      } else if (((localList instanceof zzjt)) && ((localList instanceof zzii))) {
        localObject = ((zzii)localList).zza(paramInt);
      } else {
        localObject = new ArrayList(paramInt);
      }
      zzkx.zza(paramObject, paramLong, localObject);
      return (List<L>)localObject;
    }
    if (zza.isAssignableFrom(localList.getClass()))
    {
      localObject = new ArrayList(localList.size() + paramInt);
      ((ArrayList)localObject).addAll(localList);
      zzkx.zza(paramObject, paramLong, localObject);
    }
    for (paramObject = localObject;; paramObject = localObject)
    {
      return (List<L>)paramObject;
      if (!(localList instanceof zzkw)) {
        break;
      }
      localObject = new zzip(localList.size() + paramInt);
      ((zzgl)localObject).addAll((zzkw)localList);
      zzkx.zza(paramObject, paramLong, localObject);
    }
    Object localObject = localList;
    if ((localList instanceof zzjt))
    {
      localObject = localList;
      if ((localList instanceof zzii))
      {
        zzii localzzii = (zzii)localList;
        localObject = localList;
        if (!localzzii.zza())
        {
          localObject = localzzii.zza(localList.size() + paramInt);
          zzkx.zza(paramObject, paramLong, localObject);
        }
      }
    }
    return (List<L>)localObject;
  }
  
  private static <E> List<E> zzc(Object paramObject, long paramLong)
  {
    return (List)zzkx.zzf(paramObject, paramLong);
  }
  
  final <L> List<L> zza(Object paramObject, long paramLong)
  {
    return zza(paramObject, paramLong, 10);
  }
  
  final <E> void zza(Object paramObject1, Object paramObject2, long paramLong)
  {
    paramObject2 = zzc(paramObject2, paramLong);
    List localList = zza(paramObject1, paramLong, ((List)paramObject2).size());
    int i = localList.size();
    int j = ((List)paramObject2).size();
    if ((i > 0) && (j > 0)) {
      localList.addAll((Collection)paramObject2);
    }
    if (i > 0) {
      paramObject2 = localList;
    }
    zzkx.zza(paramObject1, paramLong, paramObject2);
  }
  
  final void zzb(Object paramObject, long paramLong)
  {
    Object localObject = (List)zzkx.zzf(paramObject, paramLong);
    if ((localObject instanceof zzis))
    {
      localObject = ((zzis)localObject).zze();
    }
    else
    {
      if (zza.isAssignableFrom(localObject.getClass())) {
        return;
      }
      if (((localObject instanceof zzjt)) && ((localObject instanceof zzii)))
      {
        paramObject = (zzii)localObject;
        if (((zzii)paramObject).zza()) {
          ((zzii)paramObject).zzb();
        }
        return;
      }
      localObject = Collections.unmodifiableList((List)localObject);
    }
    zzkx.zza(paramObject, paramLong, localObject);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */