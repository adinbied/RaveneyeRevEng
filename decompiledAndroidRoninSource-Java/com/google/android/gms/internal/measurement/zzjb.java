package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzjb<K, V>
  extends LinkedHashMap<K, V>
{
  private static final zzjb zzb;
  private boolean zza = true;
  
  static
  {
    zzjb localzzjb = new zzjb();
    zzb = localzzjb;
    localzzjb.zza = false;
  }
  
  private zzjb() {}
  
  private zzjb(Map<K, V> paramMap)
  {
    super(paramMap);
  }
  
  private static int zza(Object paramObject)
  {
    if ((paramObject instanceof byte[])) {
      return zzic.zzc((byte[])paramObject);
    }
    if (!(paramObject instanceof zzib)) {
      return paramObject.hashCode();
    }
    throw new UnsupportedOperationException();
  }
  
  public static <K, V> zzjb<K, V> zza()
  {
    return zzb;
  }
  
  private final void zze()
  {
    if (this.zza) {
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  public final void clear()
  {
    zze();
    super.clear();
  }
  
  public final Set<Map.Entry<K, V>> entrySet()
  {
    if (isEmpty()) {
      return Collections.emptySet();
    }
    return super.entrySet();
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Map))
    {
      paramObject = (Map)paramObject;
      if (this != paramObject)
      {
        if (size() != ((Map)paramObject).size()) {}
        for (;;)
        {
          i = 0;
          break label165;
          Iterator localIterator = entrySet().iterator();
          boolean bool;
          do
          {
            if (!localIterator.hasNext()) {
              break label163;
            }
            Object localObject2 = (Map.Entry)localIterator.next();
            if (!((Map)paramObject).containsKey(((Map.Entry)localObject2).getKey())) {
              break;
            }
            Object localObject1 = ((Map.Entry)localObject2).getValue();
            localObject2 = ((Map)paramObject).get(((Map.Entry)localObject2).getKey());
            if (((localObject1 instanceof byte[])) && ((localObject2 instanceof byte[]))) {
              bool = Arrays.equals((byte[])localObject1, (byte[])localObject2);
            } else {
              bool = localObject1.equals(localObject2);
            }
          } while (bool);
        }
      }
      label163:
      int i = 1;
      label165:
      if (i != 0) {
        return true;
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    Iterator localIterator = entrySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      int j = zza(localEntry.getKey());
      i += (zza(localEntry.getValue()) ^ j);
    }
    return i;
  }
  
  public final V put(K paramK, V paramV)
  {
    zze();
    zzic.zza(paramK);
    zzic.zza(paramV);
    return (V)super.put(paramK, paramV);
  }
  
  public final void putAll(Map<? extends K, ? extends V> paramMap)
  {
    zze();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      zzic.zza(localObject);
      zzic.zza(paramMap.get(localObject));
    }
    super.putAll(paramMap);
  }
  
  public final V remove(Object paramObject)
  {
    zze();
    return (V)super.remove(paramObject);
  }
  
  public final void zza(zzjb<K, V> paramzzjb)
  {
    zze();
    if (!paramzzjb.isEmpty()) {
      putAll(paramzzjb);
    }
  }
  
  public final zzjb<K, V> zzb()
  {
    if (isEmpty()) {
      return new zzjb();
    }
    return new zzjb(this);
  }
  
  public final void zzc()
  {
    this.zza = false;
  }
  
  public final boolean zzd()
  {
    return this.zza;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzjb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */