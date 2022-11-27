package com.google.android.gms.internal.measurement;

import java.util.Map.Entry;

final class zzfo<K, V>
  extends zzfg<Map.Entry<K, V>>
{
  private final transient zzfc<K, V> zza;
  private final transient Object[] zzb;
  private final transient int zzc;
  private final transient int zzd;
  
  zzfo(zzfc<K, V> paramzzfc, Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    this.zza = paramzzfc;
    this.zzb = paramArrayOfObject;
    this.zzc = 0;
    this.zzd = paramInt2;
  }
  
  public final boolean contains(Object paramObject)
  {
    if ((paramObject instanceof Map.Entry))
    {
      Object localObject = (Map.Entry)paramObject;
      paramObject = ((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if ((localObject != null) && (localObject.equals(this.zza.get(paramObject)))) {
        return true;
      }
    }
    return false;
  }
  
  public final int size()
  {
    return this.zzd;
  }
  
  final int zza(Object[] paramArrayOfObject, int paramInt)
  {
    return zze().zza(paramArrayOfObject, paramInt);
  }
  
  public final zzfx<Map.Entry<K, V>> zza()
  {
    return (zzfx)zze().iterator();
  }
  
  final boolean zzf()
  {
    return true;
  }
  
  final zzfb<Map.Entry<K, V>> zzh()
  {
    return new zzfr(this);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */