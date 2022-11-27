package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzkb
{
  private static final Class<?> zza = ;
  private static final zzkr<?, ?> zzb = zza(false);
  private static final zzkr<?, ?> zzc = zza(true);
  private static final zzkr<?, ?> zzd = new zzkt();
  
  static int zza(int paramInt, Object paramObject, zzjz paramzzjz)
  {
    if ((paramObject instanceof zziq)) {
      return zzhg.zza(paramInt, (zziq)paramObject);
    }
    return zzhg.zzb(paramInt, (zzjh)paramObject, paramzzjz);
  }
  
  static int zza(int paramInt, List<?> paramList)
  {
    int m = paramList.size();
    int i = 0;
    int k = 0;
    if (m == 0) {
      return 0;
    }
    int j = zzhg.zze(paramInt) * m;
    paramInt = j;
    Object localObject;
    if ((paramList instanceof zzis))
    {
      paramList = (zzis)paramList;
      paramInt = j;
      i = k;
      for (;;)
      {
        j = paramInt;
        if (i >= m) {
          break;
        }
        localObject = paramList.zzb(i);
        if ((localObject instanceof zzgr)) {
          j = zzhg.zzb((zzgr)localObject);
        } else {
          j = zzhg.zzb((String)localObject);
        }
        paramInt += j;
        i += 1;
      }
    }
    for (;;)
    {
      j = paramInt;
      if (i >= m) {
        break;
      }
      localObject = paramList.get(i);
      if ((localObject instanceof zzgr)) {
        j = zzhg.zzb((zzgr)localObject);
      } else {
        j = zzhg.zzb((String)localObject);
      }
      paramInt += j;
      i += 1;
    }
    return j;
  }
  
  static int zza(int paramInt, List<?> paramList, zzjz paramzzjz)
  {
    int k = paramList.size();
    int j = 0;
    if (k == 0) {
      return 0;
    }
    int i = zzhg.zze(paramInt) * k;
    paramInt = j;
    while (paramInt < k)
    {
      Object localObject = paramList.get(paramInt);
      if ((localObject instanceof zziq)) {
        j = zzhg.zza((zziq)localObject);
      } else {
        j = zzhg.zza((zzjh)localObject, paramzzjz);
      }
      i += j;
      paramInt += 1;
    }
    return i;
  }
  
  static int zza(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    if (paramList.size() == 0) {
      return 0;
    }
    return zza(paramList) + paramList.size() * zzhg.zze(paramInt);
  }
  
  static int zza(List<Long> paramList)
  {
    int m = paramList.size();
    int j = 0;
    int k = 0;
    if (m == 0) {
      return 0;
    }
    if ((paramList instanceof zziv))
    {
      paramList = (zziv)paramList;
      i = 0;
      for (;;)
      {
        j = i;
        if (k >= m) {
          break;
        }
        i += zzhg.zzd(paramList.zzb(k));
        k += 1;
      }
    }
    int i = 0;
    k = j;
    for (;;)
    {
      j = i;
      if (k >= m) {
        break;
      }
      i += zzhg.zzd(((Long)paramList.get(k)).longValue());
      k += 1;
    }
    return j;
  }
  
  public static zzkr<?, ?> zza()
  {
    return zzb;
  }
  
  private static zzkr<?, ?> zza(boolean paramBoolean)
  {
    try
    {
      Object localObject1 = zze();
      if (localObject1 == null) {
        return null;
      }
      localObject1 = (zzkr)((Class)localObject1).getConstructor(new Class[] { Boolean.TYPE }).newInstance(new Object[] { Boolean.valueOf(paramBoolean) });
      return (zzkr<?, ?>)localObject1;
    }
    finally {}
    return null;
  }
  
  static <UT, UB> UB zza(int paramInt1, int paramInt2, UB paramUB, zzkr<UT, UB> paramzzkr)
  {
    Object localObject = paramUB;
    if (paramUB == null) {
      localObject = paramzzkr.zza();
    }
    paramzzkr.zza(localObject, paramInt1, paramInt2);
    return (UB)localObject;
  }
  
  static <UT, UB> UB zza(int paramInt, List<Integer> paramList, zzid paramzzid, UB paramUB, zzkr<UT, UB> paramzzkr)
  {
    if (paramzzid == null) {
      return paramUB;
    }
    int i;
    UB ?;
    if ((paramList instanceof RandomAccess))
    {
      int k = paramList.size();
      i = 0;
      int j = 0;
      while (i < k)
      {
        int m = ((Integer)paramList.get(i)).intValue();
        if (paramzzid.zza(m))
        {
          if (i != j) {
            paramList.set(j, Integer.valueOf(m));
          }
          j += 1;
        }
        else
        {
          paramUB = zza(paramInt, m, paramUB, paramzzkr);
        }
        i += 1;
      }
      ? = paramUB;
      if (j != k)
      {
        paramList.subList(j, k).clear();
        return paramUB;
      }
    }
    else
    {
      paramList = paramList.iterator();
      for (;;)
      {
        ? = paramUB;
        if (!paramList.hasNext()) {
          break;
        }
        i = ((Integer)paramList.next()).intValue();
        if (!paramzzid.zza(i))
        {
          paramUB = zza(paramInt, i, paramUB, paramzzkr);
          paramList.remove();
        }
      }
    }
    return ?;
  }
  
  public static void zza(int paramInt, List<String> paramList, zzlo paramzzlo)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzlo.zza(paramInt, paramList);
    }
  }
  
  public static void zza(int paramInt, List<?> paramList, zzlo paramzzlo, zzjz paramzzjz)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzlo.zza(paramInt, paramList, paramzzjz);
    }
  }
  
  public static void zza(int paramInt, List<Double> paramList, zzlo paramzzlo, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzlo.zzg(paramInt, paramList, paramBoolean);
    }
  }
  
  static <T, FT extends zzhr<FT>> void zza(zzho<FT> paramzzho, T paramT1, T paramT2)
  {
    paramT2 = paramzzho.zza(paramT2);
    if (!paramT2.zza.isEmpty()) {
      paramzzho.zzb(paramT1).zza(paramT2);
    }
  }
  
  static <T> void zza(zzje paramzzje, T paramT1, T paramT2, long paramLong)
  {
    zzkx.zza(paramT1, paramLong, paramzzje.zza(zzkx.zzf(paramT1, paramLong), zzkx.zzf(paramT2, paramLong)));
  }
  
  static <T, UT, UB> void zza(zzkr<UT, UB> paramzzkr, T paramT1, T paramT2)
  {
    paramzzkr.zza(paramT1, paramzzkr.zzc(paramzzkr.zzb(paramT1), paramzzkr.zzb(paramT2)));
  }
  
  public static void zza(Class<?> paramClass)
  {
    if (!zzhz.class.isAssignableFrom(paramClass))
    {
      Class localClass = zza;
      if (localClass != null)
      {
        if (localClass.isAssignableFrom(paramClass)) {
          return;
        }
        throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
      }
    }
  }
  
  static boolean zza(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  static int zzb(int paramInt, List<zzgr> paramList)
  {
    int j = paramList.size();
    int i = 0;
    if (j == 0) {
      return 0;
    }
    j *= zzhg.zze(paramInt);
    paramInt = i;
    i = j;
    while (paramInt < paramList.size())
    {
      i += zzhg.zzb((zzgr)paramList.get(paramInt));
      paramInt += 1;
    }
    return i;
  }
  
  static int zzb(int paramInt, List<zzjh> paramList, zzjz paramzzjz)
  {
    int k = paramList.size();
    int i = 0;
    if (k == 0) {
      return 0;
    }
    int j = 0;
    while (i < k)
    {
      j += zzhg.zzc(paramInt, (zzjh)paramList.get(i), paramzzjz);
      i += 1;
    }
    return j;
  }
  
  static int zzb(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zzb(paramList) + i * zzhg.zze(paramInt);
  }
  
  static int zzb(List<Long> paramList)
  {
    int m = paramList.size();
    int j = 0;
    int k = 0;
    if (m == 0) {
      return 0;
    }
    if ((paramList instanceof zziv))
    {
      paramList = (zziv)paramList;
      i = 0;
      for (;;)
      {
        j = i;
        if (k >= m) {
          break;
        }
        i += zzhg.zze(paramList.zzb(k));
        k += 1;
      }
    }
    int i = 0;
    k = j;
    for (;;)
    {
      j = i;
      if (k >= m) {
        break;
      }
      i += zzhg.zze(((Long)paramList.get(k)).longValue());
      k += 1;
    }
    return j;
  }
  
  public static zzkr<?, ?> zzb()
  {
    return zzc;
  }
  
  public static void zzb(int paramInt, List<zzgr> paramList, zzlo paramzzlo)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzlo.zzb(paramInt, paramList);
    }
  }
  
  public static void zzb(int paramInt, List<?> paramList, zzlo paramzzlo, zzjz paramzzjz)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzlo.zzb(paramInt, paramList, paramzzjz);
    }
  }
  
  public static void zzb(int paramInt, List<Float> paramList, zzlo paramzzlo, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzlo.zzf(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzc(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zzc(paramList) + i * zzhg.zze(paramInt);
  }
  
  static int zzc(List<Long> paramList)
  {
    int m = paramList.size();
    int j = 0;
    int k = 0;
    if (m == 0) {
      return 0;
    }
    if ((paramList instanceof zziv))
    {
      paramList = (zziv)paramList;
      i = 0;
      for (;;)
      {
        j = i;
        if (k >= m) {
          break;
        }
        i += zzhg.zzf(paramList.zzb(k));
        k += 1;
      }
    }
    int i = 0;
    k = j;
    for (;;)
    {
      j = i;
      if (k >= m) {
        break;
      }
      i += zzhg.zzf(((Long)paramList.get(k)).longValue());
      k += 1;
    }
    return j;
  }
  
  public static zzkr<?, ?> zzc()
  {
    return zzd;
  }
  
  public static void zzc(int paramInt, List<Long> paramList, zzlo paramzzlo, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzlo.zzc(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzd(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zzd(paramList) + i * zzhg.zze(paramInt);
  }
  
  static int zzd(List<Integer> paramList)
  {
    int m = paramList.size();
    int j = 0;
    int k = 0;
    if (m == 0) {
      return 0;
    }
    if ((paramList instanceof zzia))
    {
      paramList = (zzia)paramList;
      i = 0;
      for (;;)
      {
        j = i;
        if (k >= m) {
          break;
        }
        i += zzhg.zzk(paramList.zzc(k));
        k += 1;
      }
    }
    int i = 0;
    k = j;
    for (;;)
    {
      j = i;
      if (k >= m) {
        break;
      }
      i += zzhg.zzk(((Integer)paramList.get(k)).intValue());
      k += 1;
    }
    return j;
  }
  
  private static Class<?> zzd()
  {
    try
    {
      Class localClass = Class.forName("com.google.protobuf.GeneratedMessage");
      return localClass;
    }
    finally
    {
      for (;;) {}
    }
    return null;
  }
  
  public static void zzd(int paramInt, List<Long> paramList, zzlo paramzzlo, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzlo.zzd(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zze(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zze(paramList) + i * zzhg.zze(paramInt);
  }
  
  static int zze(List<Integer> paramList)
  {
    int m = paramList.size();
    int j = 0;
    int k = 0;
    if (m == 0) {
      return 0;
    }
    if ((paramList instanceof zzia))
    {
      paramList = (zzia)paramList;
      i = 0;
      for (;;)
      {
        j = i;
        if (k >= m) {
          break;
        }
        i += zzhg.zzf(paramList.zzc(k));
        k += 1;
      }
    }
    int i = 0;
    k = j;
    for (;;)
    {
      j = i;
      if (k >= m) {
        break;
      }
      i += zzhg.zzf(((Integer)paramList.get(k)).intValue());
      k += 1;
    }
    return j;
  }
  
  private static Class<?> zze()
  {
    try
    {
      Class localClass = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
      return localClass;
    }
    finally
    {
      for (;;) {}
    }
    return null;
  }
  
  public static void zze(int paramInt, List<Long> paramList, zzlo paramzzlo, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzlo.zzn(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzf(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zzf(paramList) + i * zzhg.zze(paramInt);
  }
  
  static int zzf(List<Integer> paramList)
  {
    int m = paramList.size();
    int j = 0;
    int k = 0;
    if (m == 0) {
      return 0;
    }
    if ((paramList instanceof zzia))
    {
      paramList = (zzia)paramList;
      i = 0;
      for (;;)
      {
        j = i;
        if (k >= m) {
          break;
        }
        i += zzhg.zzg(paramList.zzc(k));
        k += 1;
      }
    }
    int i = 0;
    k = j;
    for (;;)
    {
      j = i;
      if (k >= m) {
        break;
      }
      i += zzhg.zzg(((Integer)paramList.get(k)).intValue());
      k += 1;
    }
    return j;
  }
  
  public static void zzf(int paramInt, List<Long> paramList, zzlo paramzzlo, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzlo.zze(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzg(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return zzg(paramList) + i * zzhg.zze(paramInt);
  }
  
  static int zzg(List<Integer> paramList)
  {
    int m = paramList.size();
    int j = 0;
    int k = 0;
    if (m == 0) {
      return 0;
    }
    if ((paramList instanceof zzia))
    {
      paramList = (zzia)paramList;
      i = 0;
      for (;;)
      {
        j = i;
        if (k >= m) {
          break;
        }
        i += zzhg.zzh(paramList.zzc(k));
        k += 1;
      }
    }
    int i = 0;
    k = j;
    for (;;)
    {
      j = i;
      if (k >= m) {
        break;
      }
      i += zzhg.zzh(((Integer)paramList.get(k)).intValue());
      k += 1;
    }
    return j;
  }
  
  public static void zzg(int paramInt, List<Long> paramList, zzlo paramzzlo, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzlo.zzl(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzh(int paramInt, List<?> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return i * zzhg.zzi(paramInt, 0);
  }
  
  static int zzh(List<?> paramList)
  {
    return paramList.size() << 2;
  }
  
  public static void zzh(int paramInt, List<Integer> paramList, zzlo paramzzlo, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzlo.zza(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzi(int paramInt, List<?> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return i * zzhg.zzg(paramInt, 0L);
  }
  
  static int zzi(List<?> paramList)
  {
    return paramList.size() << 3;
  }
  
  public static void zzi(int paramInt, List<Integer> paramList, zzlo paramzzlo, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzlo.zzj(paramInt, paramList, paramBoolean);
    }
  }
  
  static int zzj(int paramInt, List<?> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    if (i == 0) {
      return 0;
    }
    return i * zzhg.zzb(paramInt, true);
  }
  
  static int zzj(List<?> paramList)
  {
    return paramList.size();
  }
  
  public static void zzj(int paramInt, List<Integer> paramList, zzlo paramzzlo, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzlo.zzm(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void zzk(int paramInt, List<Integer> paramList, zzlo paramzzlo, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzlo.zzb(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void zzl(int paramInt, List<Integer> paramList, zzlo paramzzlo, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzlo.zzk(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void zzm(int paramInt, List<Integer> paramList, zzlo paramzzlo, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzlo.zzh(paramInt, paramList, paramBoolean);
    }
  }
  
  public static void zzn(int paramInt, List<Boolean> paramList, zzlo paramzzlo, boolean paramBoolean)
    throws IOException
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramzzlo.zzi(paramInt, paramList, paramBoolean);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzkb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */