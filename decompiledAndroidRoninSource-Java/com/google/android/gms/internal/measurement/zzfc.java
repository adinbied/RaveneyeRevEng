package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class zzfc<K, V>
  implements Serializable, Map<K, V>
{
  private static final Map.Entry<?, ?>[] zza = new Map.Entry[0];
  private transient zzfg<Map.Entry<K, V>> zzb;
  private transient zzfg<K> zzc;
  private transient zzey<V> zzd;
  
  @Deprecated
  public final void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean containsKey(@NullableDecl Object paramObject)
  {
    return get(paramObject) != null;
  }
  
  public boolean containsValue(@NullableDecl Object paramObject)
  {
    return ((zzey)values()).contains(paramObject);
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof Map))
    {
      paramObject = (Map)paramObject;
      return entrySet().equals(((Map)paramObject).entrySet());
    }
    return false;
  }
  
  public abstract V get(@NullableDecl Object paramObject);
  
  public final V getOrDefault(@NullableDecl Object paramObject, @NullableDecl V paramV)
  {
    paramObject = get(paramObject);
    if (paramObject != null) {
      return (V)paramObject;
    }
    return paramV;
  }
  
  public int hashCode()
  {
    return zzfv.zza((zzfg)entrySet());
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  @Deprecated
  public final V put(K paramK, V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final void putAll(Map<? extends K, ? extends V> paramMap)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final V remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public String toString()
  {
    int i = size();
    if (i >= 0)
    {
      localStringBuilder = new StringBuilder((int)Math.min(i << 3, 1073741824L));
      localStringBuilder.append('{');
      i = 1;
      Iterator localIterator = entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (i == 0) {
          localStringBuilder.append(", ");
        }
        i = 0;
        localStringBuilder.append(localEntry.getKey());
        localStringBuilder.append('=');
        localStringBuilder.append(localEntry.getValue());
      }
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder("size".length() + 40);
    localStringBuilder.append("size");
    localStringBuilder.append(" cannot be negative but was: ");
    localStringBuilder.append(i);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  abstract zzfg<Map.Entry<K, V>> zza();
  
  abstract zzfg<K> zzb();
  
  abstract zzey<V> zzc();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzfc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */