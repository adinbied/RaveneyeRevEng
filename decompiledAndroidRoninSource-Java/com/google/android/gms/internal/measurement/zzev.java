package com.google.android.gms.internal.measurement;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzev
  extends zzei<K, V>
{
  @NullableDecl
  private final K zza = paramzzem.zzb[paramInt];
  private int zzb;
  
  zzev(zzem paramzzem, int paramInt)
  {
    this.zzb = paramInt;
  }
  
  private final void zza()
  {
    int i = this.zzb;
    if ((i == -1) || (i >= this.zzc.size()) || (!zzdz.zza(this.zza, this.zzc.zzb[this.zzb]))) {
      this.zzb = zzem.zzb(this.zzc, this.zza);
    }
  }
  
  @NullableDecl
  public final K getKey()
  {
    return (K)this.zza;
  }
  
  @NullableDecl
  public final V getValue()
  {
    Map localMap = this.zzc.zzb();
    if (localMap != null) {
      return (V)localMap.get(this.zza);
    }
    zza();
    if (this.zzb == -1) {
      return null;
    }
    return (V)this.zzc.zzc[this.zzb];
  }
  
  public final V setValue(V paramV)
  {
    Object localObject = this.zzc.zzb();
    if (localObject != null) {
      return (V)((Map)localObject).put(this.zza, paramV);
    }
    zza();
    if (this.zzb == -1)
    {
      this.zzc.put(this.zza, paramV);
      return null;
    }
    localObject = this.zzc.zzc[this.zzb];
    this.zzc.zzc[this.zzb] = paramV;
    return (V)localObject;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */