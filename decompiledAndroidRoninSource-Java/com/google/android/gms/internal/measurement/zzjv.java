package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzjv
{
  private static final zzjv zza = new zzjv();
  private final zzkc zzb = new zziy();
  private final ConcurrentMap<Class<?>, zzjz<?>> zzc = new ConcurrentHashMap();
  
  public static zzjv zza()
  {
    return zza;
  }
  
  public final <T> zzjz<T> zza(Class<T> paramClass)
  {
    zzic.zza(paramClass, "messageType");
    zzjz localzzjz = (zzjz)this.zzc.get(paramClass);
    Object localObject = localzzjz;
    if (localzzjz == null)
    {
      localObject = this.zzb.zza(paramClass);
      zzic.zza(paramClass, "messageType");
      zzic.zza(localObject, "schema");
      paramClass = (zzjz)this.zzc.putIfAbsent(paramClass, localObject);
      if (paramClass != null) {
        localObject = paramClass;
      }
    }
    return (zzjz<T>)localObject;
  }
  
  public final <T> zzjz<T> zza(T paramT)
  {
    return zza(paramT.getClass());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzjv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */