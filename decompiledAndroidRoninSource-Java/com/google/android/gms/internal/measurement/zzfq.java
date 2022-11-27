package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzfq<K>
  extends zzfg<K>
{
  private final transient zzfc<K, ?> zza;
  private final transient zzfb<K> zzb;
  
  zzfq(zzfc<K, ?> paramzzfc, zzfb<K> paramzzfb)
  {
    this.zza = paramzzfc;
    this.zzb = paramzzfb;
  }
  
  public final boolean contains(@NullableDecl Object paramObject)
  {
    return this.zza.get(paramObject) != null;
  }
  
  public final int size()
  {
    return this.zza.size();
  }
  
  final int zza(Object[] paramArrayOfObject, int paramInt)
  {
    return zze().zza(paramArrayOfObject, paramInt);
  }
  
  public final zzfx<K> zza()
  {
    return (zzfx)zze().iterator();
  }
  
  public final zzfb<K> zze()
  {
    return this.zzb;
  }
  
  final boolean zzf()
  {
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzfq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */