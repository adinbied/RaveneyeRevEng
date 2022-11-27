package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

final class zzhp<T extends zzhr<T>>
{
  private static final zzhp zzd = new zzhp(true);
  final zzke<T, Object> zza;
  private boolean zzb;
  private boolean zzc;
  
  private zzhp()
  {
    this.zza = zzke.zza(16);
  }
  
  private zzhp(zzke<T, Object> paramzzke)
  {
    this.zza = paramzzke;
    zzb();
  }
  
  private zzhp(boolean paramBoolean)
  {
    this(zzke.zza(0));
    zzb();
  }
  
  public static int zza(zzhr<?> paramzzhr, Object paramObject)
  {
    zzli localzzli = paramzzhr.zzb();
    int k = paramzzhr.zza();
    if (paramzzhr.zzd())
    {
      boolean bool = paramzzhr.zze();
      int j = 0;
      int i = 0;
      if (bool)
      {
        paramzzhr = ((List)paramObject).iterator();
        while (paramzzhr.hasNext()) {
          i += zzb(localzzli, paramzzhr.next());
        }
        return zzhg.zze(k) + i + zzhg.zzl(i);
      }
      paramzzhr = ((List)paramObject).iterator();
      i = j;
      while (paramzzhr.hasNext()) {
        i += zza(localzzli, k, paramzzhr.next());
      }
      return i;
    }
    return zza(localzzli, k, paramObject);
  }
  
  static int zza(zzli paramzzli, int paramInt, Object paramObject)
  {
    int i = zzhg.zze(paramInt);
    paramInt = i;
    if (paramzzli == zzli.zzj)
    {
      zzic.zza((zzjh)paramObject);
      paramInt = i << 1;
    }
    return paramInt + zzb(paramzzli, paramObject);
  }
  
  public static <T extends zzhr<T>> zzhp<T> zza()
  {
    return zzd;
  }
  
  private final Object zza(T paramT)
  {
    Object localObject = this.zza.get(paramT);
    paramT = (T)localObject;
    if ((localObject instanceof zzim))
    {
      paramT = (zzim)localObject;
      paramT = zzim.zza();
    }
    return paramT;
  }
  
  private static Object zza(Object paramObject)
  {
    if ((paramObject instanceof zzjq)) {
      return ((zzjq)paramObject).zza();
    }
    if ((paramObject instanceof byte[]))
    {
      paramObject = (byte[])paramObject;
      byte[] arrayOfByte = new byte[paramObject.length];
      System.arraycopy(paramObject, 0, arrayOfByte, 0, paramObject.length);
      return arrayOfByte;
    }
    return paramObject;
  }
  
  static void zza(zzhg paramzzhg, zzli paramzzli, int paramInt, Object paramObject)
    throws IOException
  {
    if (paramzzli == zzli.zzj)
    {
      paramzzli = (zzjh)paramObject;
      zzic.zza(paramzzli);
      paramzzhg.zza(paramInt, 3);
      paramzzli.zza(paramzzhg);
      paramzzhg.zza(paramInt, 4);
      return;
    }
    paramzzhg.zza(paramInt, paramzzli.zzb());
    switch (zzhs.zzb[paramzzli.ordinal()])
    {
    default: 
      return;
    case 18: 
      if ((paramObject instanceof zzib))
      {
        paramzzhg.zza(((zzib)paramObject).zza());
        return;
      }
      paramzzhg.zza(((Integer)paramObject).intValue());
      return;
    case 17: 
      paramzzhg.zzb(((Long)paramObject).longValue());
      return;
    case 16: 
      paramzzhg.zzc(((Integer)paramObject).intValue());
      return;
    case 15: 
      paramzzhg.zzc(((Long)paramObject).longValue());
      return;
    case 14: 
      paramzzhg.zzd(((Integer)paramObject).intValue());
      return;
    case 13: 
      paramzzhg.zzb(((Integer)paramObject).intValue());
      return;
    case 12: 
      if ((paramObject instanceof zzgr))
      {
        paramzzhg.zza((zzgr)paramObject);
        return;
      }
      paramzzli = (byte[])paramObject;
      paramzzhg.zzb(paramzzli, 0, paramzzli.length);
      return;
    case 11: 
      if ((paramObject instanceof zzgr))
      {
        paramzzhg.zza((zzgr)paramObject);
        return;
      }
      paramzzhg.zza((String)paramObject);
      return;
    case 10: 
      paramzzhg.zza((zzjh)paramObject);
      return;
    case 9: 
      ((zzjh)paramObject).zza(paramzzhg);
      return;
    case 8: 
      paramzzhg.zza(((Boolean)paramObject).booleanValue());
      return;
    case 7: 
      paramzzhg.zzd(((Integer)paramObject).intValue());
      return;
    case 6: 
      paramzzhg.zzc(((Long)paramObject).longValue());
      return;
    case 5: 
      paramzzhg.zza(((Integer)paramObject).intValue());
      return;
    case 4: 
      paramzzhg.zza(((Long)paramObject).longValue());
      return;
    case 3: 
      paramzzhg.zza(((Long)paramObject).longValue());
      return;
    case 2: 
      paramzzhg.zza(((Float)paramObject).floatValue());
      return;
    }
    paramzzhg.zza(((Double)paramObject).doubleValue());
  }
  
  private static void zza(zzli paramzzli, Object paramObject)
  {
    zzic.zza(paramObject);
    int i = zzhs.zza[paramzzli.zza().ordinal()];
    boolean bool2 = true;
    boolean bool1;
    switch (i)
    {
    default: 
    case 9: 
    case 8: 
    case 7: 
      do
      {
        do
        {
          do
          {
            bool1 = false;
            break;
            bool1 = bool2;
            if ((paramObject instanceof zzjh)) {
              break;
            }
          } while (!(paramObject instanceof zzim));
          bool1 = bool2;
          break;
          bool1 = bool2;
          if ((paramObject instanceof Integer)) {
            break;
          }
        } while (!(paramObject instanceof zzib));
        bool1 = bool2;
        break;
        bool1 = bool2;
        if ((paramObject instanceof zzgr)) {
          break;
        }
      } while (!(paramObject instanceof byte[]));
      bool1 = bool2;
      break;
    case 6: 
      bool1 = paramObject instanceof String;
      break;
    case 5: 
      bool1 = paramObject instanceof Boolean;
      break;
    case 4: 
      bool1 = paramObject instanceof Double;
      break;
    case 3: 
      bool1 = paramObject instanceof Float;
      break;
    case 2: 
      bool1 = paramObject instanceof Long;
      break;
    case 1: 
      bool1 = paramObject instanceof Integer;
    }
    if (bool1) {
      return;
    }
    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
  }
  
  private static <T extends zzhr<T>> boolean zza(Map.Entry<T, Object> paramEntry)
  {
    zzhr localzzhr = (zzhr)paramEntry.getKey();
    if (localzzhr.zzc() == zzll.zzi)
    {
      if (localzzhr.zzd())
      {
        paramEntry = ((List)paramEntry.getValue()).iterator();
        do
        {
          if (!paramEntry.hasNext()) {
            break;
          }
        } while (((zzjh)paramEntry.next()).i_());
        return false;
      }
      paramEntry = paramEntry.getValue();
      if ((paramEntry instanceof zzjh))
      {
        if (!((zzjh)paramEntry).i_()) {
          return false;
        }
      }
      else
      {
        if ((paramEntry instanceof zzim)) {
          return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
    }
    return true;
  }
  
  private static int zzb(zzli paramzzli, Object paramObject)
  {
    switch (zzhs.zzb[paramzzli.ordinal()])
    {
    default: 
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case 18: 
      if ((paramObject instanceof zzib)) {
        return zzhg.zzk(((zzib)paramObject).zza());
      }
      return zzhg.zzk(((Integer)paramObject).intValue());
    case 17: 
      return zzhg.zzf(((Long)paramObject).longValue());
    case 16: 
      return zzhg.zzh(((Integer)paramObject).intValue());
    case 15: 
      return zzhg.zzh(((Long)paramObject).longValue());
    case 14: 
      return zzhg.zzj(((Integer)paramObject).intValue());
    case 13: 
      return zzhg.zzg(((Integer)paramObject).intValue());
    case 12: 
      if ((paramObject instanceof zzgr)) {
        return zzhg.zzb((zzgr)paramObject);
      }
      return zzhg.zzb((byte[])paramObject);
    case 11: 
      if ((paramObject instanceof zzgr)) {
        return zzhg.zzb((zzgr)paramObject);
      }
      return zzhg.zzb((String)paramObject);
    case 10: 
      if ((paramObject instanceof zzim)) {
        return zzhg.zza((zzim)paramObject);
      }
      return zzhg.zzb((zzjh)paramObject);
    case 9: 
      return zzhg.zzc((zzjh)paramObject);
    case 8: 
      return zzhg.zzb(((Boolean)paramObject).booleanValue());
    case 7: 
      return zzhg.zzi(((Integer)paramObject).intValue());
    case 6: 
      return zzhg.zzg(((Long)paramObject).longValue());
    case 5: 
      return zzhg.zzf(((Integer)paramObject).intValue());
    case 4: 
      return zzhg.zze(((Long)paramObject).longValue());
    case 3: 
      return zzhg.zzd(((Long)paramObject).longValue());
    case 2: 
      return zzhg.zzb(((Float)paramObject).floatValue());
    }
    return zzhg.zzb(((Double)paramObject).doubleValue());
  }
  
  private final void zzb(T paramT, Object paramObject)
  {
    if (paramT.zzd())
    {
      if ((paramObject instanceof List))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll((List)paramObject);
        paramObject = (ArrayList)localArrayList;
        int j = ((ArrayList)paramObject).size();
        int i = 0;
        while (i < j)
        {
          Object localObject = ((ArrayList)paramObject).get(i);
          i += 1;
          zza(paramT.zzb(), localObject);
        }
        paramObject = localArrayList;
      }
      else
      {
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
    }
    else {
      zza(paramT.zzb(), paramObject);
    }
    if ((paramObject instanceof zzim)) {
      this.zzc = true;
    }
    this.zza.zza(paramT, paramObject);
  }
  
  private final void zzb(Map.Entry<T, Object> paramEntry)
  {
    zzhr localzzhr = (zzhr)paramEntry.getKey();
    Object localObject1 = paramEntry.getValue();
    paramEntry = (Map.Entry<T, Object>)localObject1;
    if ((localObject1 instanceof zzim))
    {
      paramEntry = (zzim)localObject1;
      paramEntry = zzim.zza();
    }
    if (localzzhr.zzd())
    {
      Object localObject2 = zza(localzzhr);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ArrayList();
      }
      paramEntry = ((List)paramEntry).iterator();
      while (paramEntry.hasNext())
      {
        localObject2 = paramEntry.next();
        ((List)localObject1).add(zza(localObject2));
      }
      this.zza.zza(localzzhr, localObject1);
      return;
    }
    if (localzzhr.zzc() == zzll.zzi)
    {
      localObject1 = zza(localzzhr);
      if (localObject1 == null)
      {
        this.zza.zza(localzzhr, zza(paramEntry));
        return;
      }
      if ((localObject1 instanceof zzjq)) {
        paramEntry = localzzhr.zza((zzjq)localObject1, (zzjq)paramEntry);
      } else {
        paramEntry = localzzhr.zza(((zzjh)localObject1).zzbs(), (zzjh)paramEntry).zzz();
      }
      this.zza.zza(localzzhr, paramEntry);
      return;
    }
    this.zza.zza(localzzhr, zza(paramEntry));
  }
  
  private static int zzc(Map.Entry<T, Object> paramEntry)
  {
    zzhr localzzhr = (zzhr)paramEntry.getKey();
    Object localObject = paramEntry.getValue();
    if ((localzzhr.zzc() == zzll.zzi) && (!localzzhr.zzd()) && (!localzzhr.zze()))
    {
      if ((localObject instanceof zzim)) {
        return zzhg.zzb(((zzhr)paramEntry.getKey()).zza(), (zzim)localObject);
      }
      return zzhg.zzb(((zzhr)paramEntry.getKey()).zza(), (zzjh)localObject);
    }
    return zza(localzzhr, localObject);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzhp)) {
      return false;
    }
    paramObject = (zzhp)paramObject;
    return this.zza.equals(((zzhp)paramObject).zza);
  }
  
  public final int hashCode()
  {
    return this.zza.hashCode();
  }
  
  public final void zza(zzhp<T> paramzzhp)
  {
    int i = 0;
    while (i < paramzzhp.zza.zzc())
    {
      zzb(paramzzhp.zza.zzb(i));
      i += 1;
    }
    paramzzhp = paramzzhp.zza.zzd().iterator();
    while (paramzzhp.hasNext()) {
      zzb((Map.Entry)paramzzhp.next());
    }
  }
  
  public final void zzb()
  {
    if (this.zzb) {
      return;
    }
    this.zza.zza();
    this.zzb = true;
  }
  
  public final boolean zzc()
  {
    return this.zzb;
  }
  
  public final Iterator<Map.Entry<T, Object>> zzd()
  {
    if (this.zzc) {
      return new zzin(this.zza.entrySet().iterator());
    }
    return this.zza.entrySet().iterator();
  }
  
  final Iterator<Map.Entry<T, Object>> zze()
  {
    if (this.zzc) {
      return new zzin(this.zza.zze().iterator());
    }
    return this.zza.zze().iterator();
  }
  
  public final boolean zzf()
  {
    int i = 0;
    while (i < this.zza.zzc())
    {
      if (!zza(this.zza.zzb(i))) {
        return false;
      }
      i += 1;
    }
    Iterator localIterator = this.zza.zzd().iterator();
    while (localIterator.hasNext()) {
      if (!zza((Map.Entry)localIterator.next())) {
        return false;
      }
    }
    return true;
  }
  
  public final int zzg()
  {
    int j = 0;
    int i = 0;
    while (j < this.zza.zzc())
    {
      i += zzc(this.zza.zzb(j));
      j += 1;
    }
    Iterator localIterator = this.zza.zzd().iterator();
    while (localIterator.hasNext()) {
      i += zzc((Map.Entry)localIterator.next());
    }
    return i;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzhp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */