package com.google.android.gms.internal.measurement;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class zzke<K extends Comparable<K>, V>
  extends AbstractMap<K, V>
{
  private final int zza;
  private List<zzkj> zzb;
  private Map<K, V> zzc;
  private boolean zzd;
  private volatile zzkl zze;
  private Map<K, V> zzf;
  private volatile zzkf zzg;
  
  private zzke(int paramInt)
  {
    this.zza = paramInt;
    this.zzb = Collections.emptyList();
    this.zzc = Collections.emptyMap();
    this.zzf = Collections.emptyMap();
  }
  
  private final int zza(K paramK)
  {
    int j = this.zzb.size() - 1;
    if (j >= 0)
    {
      i = paramK.compareTo((Comparable)((zzkj)this.zzb.get(j)).getKey());
      if (i > 0) {
        return -(j + 2);
      }
      if (i == 0) {
        return j;
      }
    }
    int i = 0;
    while (i <= j)
    {
      int k = (i + j) / 2;
      int m = paramK.compareTo((Comparable)((zzkj)this.zzb.get(k)).getKey());
      if (m < 0) {
        j = k - 1;
      } else if (m > 0) {
        i = k + 1;
      } else {
        return k;
      }
    }
    return -(i + 1);
  }
  
  static <FieldDescriptorType extends zzhr<FieldDescriptorType>> zzke<FieldDescriptorType, Object> zza(int paramInt)
  {
    return new zzkd(paramInt);
  }
  
  private final V zzc(int paramInt)
  {
    zzf();
    Object localObject = ((zzkj)this.zzb.remove(paramInt)).getValue();
    if (!this.zzc.isEmpty())
    {
      Iterator localIterator = zzg().entrySet().iterator();
      this.zzb.add(new zzkj(this, (Map.Entry)localIterator.next()));
      localIterator.remove();
    }
    return (V)localObject;
  }
  
  private final void zzf()
  {
    if (!this.zzd) {
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  private final SortedMap<K, V> zzg()
  {
    zzf();
    if ((this.zzc.isEmpty()) && (!(this.zzc instanceof TreeMap)))
    {
      TreeMap localTreeMap = new TreeMap();
      this.zzc = localTreeMap;
      this.zzf = ((TreeMap)localTreeMap).descendingMap();
    }
    return (SortedMap)this.zzc;
  }
  
  public void clear()
  {
    zzf();
    if (!this.zzb.isEmpty()) {
      this.zzb.clear();
    }
    if (!this.zzc.isEmpty()) {
      this.zzc.clear();
    }
  }
  
  public boolean containsKey(Object paramObject)
  {
    paramObject = (Comparable)paramObject;
    return (zza((Comparable)paramObject) >= 0) || (this.zzc.containsKey(paramObject));
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    if (this.zze == null) {
      this.zze = new zzkl(this, null);
    }
    return this.zze;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzke)) {
      return super.equals(paramObject);
    }
    paramObject = (zzke)paramObject;
    int j = size();
    if (j != ((zzke)paramObject).size()) {
      return false;
    }
    int k = zzc();
    if (k != ((zzke)paramObject).zzc()) {
      return entrySet().equals(((zzke)paramObject).entrySet());
    }
    int i = 0;
    while (i < k)
    {
      if (!zzb(i).equals(((zzke)paramObject).zzb(i))) {
        return false;
      }
      i += 1;
    }
    if (k != j) {
      return this.zzc.equals(((zzke)paramObject).zzc);
    }
    return true;
  }
  
  public V get(Object paramObject)
  {
    paramObject = (Comparable)paramObject;
    int i = zza((Comparable)paramObject);
    if (i >= 0) {
      return (V)((zzkj)this.zzb.get(i)).getValue();
    }
    return (V)this.zzc.get(paramObject);
  }
  
  public int hashCode()
  {
    int k = zzc();
    int j = 0;
    int i = 0;
    while (j < k)
    {
      i += ((zzkj)this.zzb.get(j)).hashCode();
      j += 1;
    }
    j = i;
    if (this.zzc.size() > 0) {
      j = i + this.zzc.hashCode();
    }
    return j;
  }
  
  public V remove(Object paramObject)
  {
    zzf();
    paramObject = (Comparable)paramObject;
    int i = zza((Comparable)paramObject);
    if (i >= 0) {
      return (V)zzc(i);
    }
    if (this.zzc.isEmpty()) {
      return null;
    }
    return (V)this.zzc.remove(paramObject);
  }
  
  public int size()
  {
    return this.zzb.size() + this.zzc.size();
  }
  
  public final V zza(K paramK, V paramV)
  {
    zzf();
    int i = zza(paramK);
    if (i >= 0) {
      return (V)((zzkj)this.zzb.get(i)).setValue(paramV);
    }
    zzf();
    if ((this.zzb.isEmpty()) && (!(this.zzb instanceof ArrayList))) {
      this.zzb = new ArrayList(this.zza);
    }
    i = -(i + 1);
    if (i >= this.zza) {
      return (V)zzg().put(paramK, paramV);
    }
    int j = this.zzb.size();
    int k = this.zza;
    if (j == k)
    {
      zzkj localzzkj = (zzkj)this.zzb.remove(k - 1);
      zzg().put((Comparable)localzzkj.getKey(), localzzkj.getValue());
    }
    this.zzb.add(i, new zzkj(this, paramK, paramV));
    return null;
  }
  
  public void zza()
  {
    if (!this.zzd)
    {
      Map localMap;
      if (this.zzc.isEmpty()) {
        localMap = Collections.emptyMap();
      } else {
        localMap = Collections.unmodifiableMap(this.zzc);
      }
      this.zzc = localMap;
      if (this.zzf.isEmpty()) {
        localMap = Collections.emptyMap();
      } else {
        localMap = Collections.unmodifiableMap(this.zzf);
      }
      this.zzf = localMap;
      this.zzd = true;
    }
  }
  
  public final Map.Entry<K, V> zzb(int paramInt)
  {
    return (Map.Entry)this.zzb.get(paramInt);
  }
  
  public final boolean zzb()
  {
    return this.zzd;
  }
  
  public final int zzc()
  {
    return this.zzb.size();
  }
  
  public final Iterable<Map.Entry<K, V>> zzd()
  {
    if (this.zzc.isEmpty()) {
      return zzki.zza();
    }
    return this.zzc.entrySet();
  }
  
  final Set<Map.Entry<K, V>> zze()
  {
    if (this.zzg == null) {
      this.zzg = new zzkf(this, null);
    }
    return this.zzg;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzke.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */