package com.google.android.gms.internal.measurement;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzes
  extends AbstractSet<K>
{
  zzes(zzem paramzzem) {}
  
  public final void clear()
  {
    this.zza.clear();
  }
  
  public final boolean contains(Object paramObject)
  {
    return this.zza.containsKey(paramObject);
  }
  
  public final Iterator<K> iterator()
  {
    return this.zza.zze();
  }
  
  public final boolean remove(@NullableDecl Object paramObject)
  {
    Map localMap = this.zza.zzb();
    if (localMap != null) {
      return localMap.keySet().remove(paramObject);
    }
    return zzem.zza(this.zza, paramObject) != zzem.zzh();
  }
  
  public final int size()
  {
    return this.zza.size();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */