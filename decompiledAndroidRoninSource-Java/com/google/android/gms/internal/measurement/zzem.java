package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzem<K, V>
  extends AbstractMap<K, V>
  implements Serializable
{
  private static final Object zzd = new Object();
  @NullableDecl
  transient int[] zza;
  @NullableDecl
  transient Object[] zzb;
  @NullableDecl
  transient Object[] zzc;
  @NullableDecl
  private transient Object zze;
  private transient int zzf;
  private transient int zzg;
  @NullableDecl
  private transient Set<K> zzh;
  @NullableDecl
  private transient Set<Map.Entry<K, V>> zzi;
  @NullableDecl
  private transient Collection<V> zzj;
  
  zzem()
  {
    zzeb.zza(true, "Expected size must be >= 0");
    this.zzf = zzfz.zza(3, 1, 1073741823);
  }
  
  private final int zza(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject1 = zzex.zza(paramInt2);
    int i = paramInt2 - 1;
    if (paramInt4 != 0) {
      zzex.zza(localObject1, paramInt3 & i, paramInt4 + 1);
    }
    Object localObject2 = this.zze;
    int[] arrayOfInt = this.zza;
    paramInt2 = 0;
    while (paramInt2 <= paramInt1)
    {
      int j;
      for (paramInt3 = zzex.zza(localObject2, paramInt2); paramInt3 != 0; paramInt3 = j & paramInt1)
      {
        paramInt4 = paramInt3 - 1;
        j = arrayOfInt[paramInt4];
        int k = paramInt1 & j | paramInt2;
        int m = k & i;
        int n = zzex.zza(localObject1, m);
        zzex.zza(localObject1, m, paramInt3);
        arrayOfInt[paramInt4] = zzex.zza(k, n, i);
      }
      paramInt2 += 1;
    }
    this.zze = localObject1;
    zzb(i);
    return i;
  }
  
  private final int zza(@NullableDecl Object paramObject)
  {
    if (zza()) {
      return -1;
    }
    int k = zzez.zza(paramObject);
    int m = zzi();
    int i = zzex.zza(this.zze, k & m);
    if (i == 0) {
      return -1;
    }
    int n = m;
    int j;
    do
    {
      i -= 1;
      j = this.zza[i];
      if (((j & n) == (k & n)) && (zzdz.zza(paramObject, this.zzb[i]))) {
        return i;
      }
      j &= m;
      i = j;
    } while (j != 0);
    return -1;
  }
  
  static int zzb(int paramInt1, int paramInt2)
  {
    return paramInt1 - 1;
  }
  
  @NullableDecl
  private final Object zzb(@NullableDecl Object paramObject)
  {
    if (zza()) {
      return zzd;
    }
    int i = zzi();
    int j = zzex.zza(paramObject, null, i, this.zze, this.zza, this.zzb, null);
    if (j == -1) {
      return zzd;
    }
    paramObject = this.zzc[j];
    zza(j, i);
    this.zzg -= 1;
    zzc();
    return paramObject;
  }
  
  private final void zzb(int paramInt)
  {
    paramInt = Integer.numberOfLeadingZeros(paramInt);
    this.zzf = zzex.zza(this.zzf, 32 - paramInt, 31);
  }
  
  private final int zzi()
  {
    return (1 << (this.zzf & 0x1F)) - 1;
  }
  
  public final void clear()
  {
    if (zza()) {
      return;
    }
    zzc();
    Object localObject = zzb();
    if (localObject != null)
    {
      this.zzf = zzfz.zza(size(), 3, 1073741823);
      ((Map)localObject).clear();
      this.zze = null;
      this.zzg = 0;
      return;
    }
    Arrays.fill(this.zzb, 0, this.zzg, null);
    Arrays.fill(this.zzc, 0, this.zzg, null);
    localObject = this.zze;
    if ((localObject instanceof byte[])) {
      Arrays.fill((byte[])localObject, (byte)0);
    } else if ((localObject instanceof short[])) {
      Arrays.fill((short[])localObject, (short)0);
    } else {
      Arrays.fill((int[])localObject, 0);
    }
    Arrays.fill(this.zza, 0, this.zzg, 0);
    this.zzg = 0;
  }
  
  public final boolean containsKey(@NullableDecl Object paramObject)
  {
    Map localMap = zzb();
    if (localMap != null) {
      return localMap.containsKey(paramObject);
    }
    return zza(paramObject) != -1;
  }
  
  public final boolean containsValue(@NullableDecl Object paramObject)
  {
    Map localMap = zzb();
    if (localMap != null) {
      return localMap.containsValue(paramObject);
    }
    int i = 0;
    while (i < this.zzg)
    {
      if (zzdz.zza(paramObject, this.zzc[i])) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public final Set<Map.Entry<K, V>> entrySet()
  {
    Set localSet = this.zzi;
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new zzeq(this);
      this.zzi = ((Set)localObject);
    }
    return (Set<Map.Entry<K, V>>)localObject;
  }
  
  public final V get(@NullableDecl Object paramObject)
  {
    Map localMap = zzb();
    if (localMap != null) {
      return (V)localMap.get(paramObject);
    }
    int i = zza(paramObject);
    if (i == -1) {
      return null;
    }
    return (V)this.zzc[i];
  }
  
  public final boolean isEmpty()
  {
    return size() == 0;
  }
  
  public final Set<K> keySet()
  {
    Set localSet = this.zzh;
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new zzes(this);
      this.zzh = ((Set)localObject);
    }
    return (Set<K>)localObject;
  }
  
  @NullableDecl
  public final V put(@NullableDecl K paramK, @NullableDecl V paramV)
  {
    if (zza())
    {
      zzeb.zzb(zza(), "Arrays already allocated");
      k = this.zzf;
      m = Math.max(k + 1, 2);
      j = Integer.highestOneBit(m);
      i = j;
      if (m > (int)(j * 1.0D))
      {
        j <<= 1;
        i = j;
        if (j <= 0) {
          i = 1073741824;
        }
      }
      i = Math.max(4, i);
      this.zze = zzex.zza(i);
      zzb(i - 1);
      this.zza = new int[k];
      this.zzb = new Object[k];
      this.zzc = new Object[k];
    }
    Object localObject = zzb();
    if (localObject != null) {
      return (V)((Map)localObject).put(paramK, paramV);
    }
    int[] arrayOfInt = this.zza;
    localObject = this.zzb;
    Object[] arrayOfObject = this.zzc;
    int m = this.zzg;
    int n = m + 1;
    int i1 = zzez.zza(paramK);
    int k = zzi();
    int i = i1 & k;
    int j = zzex.zza(this.zze, i);
    int i2;
    if (j == 0)
    {
      if (n > k)
      {
        i = zza(k, zzex.zzb(k), i1, m);
      }
      else
      {
        zzex.zza(this.zze, i, n);
        i = k;
      }
    }
    else
    {
      i2 = k;
      i = 0;
    }
    for (;;)
    {
      int i3 = j - 1;
      int i4 = arrayOfInt[i3];
      if (((i4 & i2) == (i1 & i2)) && (zzdz.zza(paramK, localObject[i3])))
      {
        paramK = arrayOfObject[i3];
        arrayOfObject[i3] = paramV;
        return paramK;
      }
      j = i4 & k;
      i += 1;
      if (j == 0)
      {
        if (i >= 9)
        {
          localObject = new LinkedHashMap(zzi() + 1, 1.0F);
          for (i = zzd(); i >= 0; i = zza(i)) {
            ((Map)localObject).put(this.zzb[i], this.zzc[i]);
          }
          this.zze = localObject;
          this.zza = null;
          this.zzb = null;
          this.zzc = null;
          zzc();
          return (V)((Map)localObject).put(paramK, paramV);
        }
        if (n > k)
        {
          i = zza(k, zzex.zzb(k), i1, m);
        }
        else
        {
          arrayOfInt[i3] = zzex.zza(i4, n, k);
          i = k;
        }
        j = this.zza.length;
        if (n > j)
        {
          k = Math.min(1073741823, 0x1 | Math.max(1, j >>> 1) + j);
          if (k != j)
          {
            this.zza = Arrays.copyOf(this.zza, k);
            this.zzb = Arrays.copyOf(this.zzb, k);
            this.zzc = Arrays.copyOf(this.zzc, k);
          }
        }
        this.zza[m] = zzex.zza(i1, 0, i);
        this.zzb[m] = paramK;
        this.zzc[m] = paramV;
        this.zzg = n;
        zzc();
        return null;
      }
    }
  }
  
  @NullableDecl
  public final V remove(@NullableDecl Object paramObject)
  {
    Object localObject = zzb();
    if (localObject != null) {
      return (V)((Map)localObject).remove(paramObject);
    }
    localObject = zzb(paramObject);
    paramObject = localObject;
    if (localObject == zzd) {
      paramObject = null;
    }
    return (V)paramObject;
  }
  
  public final int size()
  {
    Map localMap = zzb();
    if (localMap != null) {
      return localMap.size();
    }
    return this.zzg;
  }
  
  public final Collection<V> values()
  {
    Collection localCollection = this.zzj;
    Object localObject = localCollection;
    if (localCollection == null)
    {
      localObject = new zzeu(this);
      this.zzj = ((Collection)localObject);
    }
    return (Collection<V>)localObject;
  }
  
  final int zza(int paramInt)
  {
    paramInt += 1;
    if (paramInt < this.zzg) {
      return paramInt;
    }
    return -1;
  }
  
  final void zza(int paramInt1, int paramInt2)
  {
    int i = size() - 1;
    if (paramInt1 < i)
    {
      Object localObject2 = this.zzb;
      Object localObject1 = localObject2[i];
      localObject2[paramInt1] = localObject1;
      Object[] arrayOfObject = this.zzc;
      arrayOfObject[paramInt1] = arrayOfObject[i];
      localObject2[i] = null;
      arrayOfObject[i] = null;
      localObject2 = this.zza;
      localObject2[paramInt1] = localObject2[i];
      localObject2[i] = 0;
      int m = zzez.zza(localObject1) & paramInt2;
      int j = zzex.zza(this.zze, m);
      int k = i + 1;
      i = j;
      if (j == k)
      {
        zzex.zza(this.zze, m, paramInt1 + 1);
        return;
      }
      for (;;)
      {
        j = i - 1;
        localObject1 = this.zza;
        m = localObject1[j];
        i = m & paramInt2;
        if (i == k)
        {
          localObject1[j] = zzex.zza(m, paramInt1 + 1, paramInt2);
          return;
        }
      }
    }
    this.zzb[paramInt1] = null;
    this.zzc[paramInt1] = null;
    this.zza[paramInt1] = 0;
  }
  
  final boolean zza()
  {
    return this.zze == null;
  }
  
  @NullableDecl
  final Map<K, V> zzb()
  {
    Object localObject = this.zze;
    if ((localObject instanceof Map)) {
      return (Map)localObject;
    }
    return null;
  }
  
  final void zzc()
  {
    this.zzf += 32;
  }
  
  final int zzd()
  {
    if (isEmpty()) {
      return -1;
    }
    return 0;
  }
  
  final Iterator<K> zze()
  {
    Map localMap = zzb();
    if (localMap != null) {
      return localMap.keySet().iterator();
    }
    return new zzep(this);
  }
  
  final Iterator<Map.Entry<K, V>> zzf()
  {
    Map localMap = zzb();
    if (localMap != null) {
      return localMap.entrySet().iterator();
    }
    return new zzeo(this);
  }
  
  final Iterator<V> zzg()
  {
    Map localMap = zzb();
    if (localMap != null) {
      return localMap.values().iterator();
    }
    return new zzer(this);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */