package com.google.android.gms.internal.measurement;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzeq
  extends AbstractSet<Map.Entry<K, V>>
{
  zzeq(zzem paramzzem) {}
  
  public final void clear()
  {
    this.zza.clear();
  }
  
  public final boolean contains(@NullableDecl Object paramObject)
  {
    Map localMap = this.zza.zzb();
    if (localMap != null) {
      return localMap.entrySet().contains(paramObject);
    }
    if ((paramObject instanceof Map.Entry))
    {
      paramObject = (Map.Entry)paramObject;
      int i = zzem.zzb(this.zza, ((Map.Entry)paramObject).getKey());
      if ((i != -1) && (zzdz.zza(this.zza.zzc[i], ((Map.Entry)paramObject).getValue()))) {
        return true;
      }
    }
    return false;
  }
  
  public final Iterator<Map.Entry<K, V>> iterator()
  {
    return this.zza.zzf();
  }
  
  public final boolean remove(@NullableDecl Object paramObject)
  {
    Map localMap = this.zza.zzb();
    if (localMap != null) {
      return localMap.entrySet().remove(paramObject);
    }
    if ((paramObject instanceof Map.Entry))
    {
      paramObject = (Map.Entry)paramObject;
      if (this.zza.zza()) {
        return false;
      }
      int i = zzem.zzb(this.zza);
      int j = zzex.zza(((Map.Entry)paramObject).getKey(), ((Map.Entry)paramObject).getValue(), i, zzem.zzc(this.zza), this.zza.zza, this.zza.zzb, this.zza.zzc);
      if (j == -1) {
        return false;
      }
      this.zza.zza(j, i);
      zzem.zzd(this.zza);
      this.zza.zzc();
      return true;
    }
    return false;
  }
  
  public final int size()
  {
    return this.zza.size();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzeq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */