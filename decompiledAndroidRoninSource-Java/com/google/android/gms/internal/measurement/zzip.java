package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzip
  extends zzgl<String>
  implements zzis, RandomAccess
{
  private static final zzip zza;
  private static final zzis zzb = zza;
  private final List<Object> zzc;
  
  static
  {
    zzip localzzip = new zzip();
    zza = localzzip;
    localzzip.zzb();
  }
  
  public zzip()
  {
    this(10);
  }
  
  public zzip(int paramInt)
  {
    this(new ArrayList(paramInt));
  }
  
  private zzip(ArrayList<Object> paramArrayList)
  {
    this.zzc = paramArrayList;
  }
  
  private static String zza(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    if ((paramObject instanceof zzgr)) {
      return ((zzgr)paramObject).zzb();
    }
    return zzic.zzb((byte[])paramObject);
  }
  
  public final boolean addAll(int paramInt, Collection<? extends String> paramCollection)
  {
    zzc();
    Object localObject = paramCollection;
    if ((paramCollection instanceof zzis)) {
      localObject = ((zzis)paramCollection).zzd();
    }
    boolean bool = this.zzc.addAll(paramInt, (Collection)localObject);
    this.modCount += 1;
    return bool;
  }
  
  public final boolean addAll(Collection<? extends String> paramCollection)
  {
    return addAll(size(), paramCollection);
  }
  
  public final void clear()
  {
    zzc();
    this.zzc.clear();
    this.modCount += 1;
  }
  
  public final int size()
  {
    return this.zzc.size();
  }
  
  public final void zza(zzgr paramzzgr)
  {
    zzc();
    this.zzc.add(paramzzgr);
    this.modCount += 1;
  }
  
  public final Object zzb(int paramInt)
  {
    return this.zzc.get(paramInt);
  }
  
  public final List<?> zzd()
  {
    return Collections.unmodifiableList(this.zzc);
  }
  
  public final zzis zze()
  {
    if (zza()) {
      return new zzkw(this);
    }
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */