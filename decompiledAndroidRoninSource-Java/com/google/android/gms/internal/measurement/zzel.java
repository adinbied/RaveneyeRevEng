package com.google.android.gms.internal.measurement;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class zzel<K, V>
  implements zzfk<K, V>
{
  @NullableDecl
  private transient Map<K, Collection<V>> zza;
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof zzfk))
    {
      paramObject = (zzfk)paramObject;
      return zza().equals(((zzfk)paramObject).zza());
    }
    return false;
  }
  
  public int hashCode()
  {
    return zza().hashCode();
  }
  
  public String toString()
  {
    return zza().toString();
  }
  
  public Map<K, Collection<V>> zza()
  {
    Map localMap2 = this.zza;
    Map localMap1 = localMap2;
    if (localMap2 == null)
    {
      localMap1 = zzb();
      this.zza = localMap1;
    }
    return localMap1;
  }
  
  public boolean zza(@NullableDecl Object paramObject)
  {
    Iterator localIterator = zza().values().iterator();
    while (localIterator.hasNext()) {
      if (((Collection)localIterator.next()).contains(paramObject)) {
        return true;
      }
    }
    return false;
  }
  
  abstract Map<K, Collection<V>> zzb();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */