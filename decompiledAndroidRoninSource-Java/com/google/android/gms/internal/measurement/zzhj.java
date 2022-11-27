package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzhj
  implements zzlo
{
  private final zzhg zza;
  
  private zzhj(zzhg paramzzhg)
  {
    paramzzhg = (zzhg)zzic.zza(paramzzhg, "output");
    this.zza = paramzzhg;
    paramzzhg.zza = this;
  }
  
  public static zzhj zza(zzhg paramzzhg)
  {
    if (paramzzhg.zza != null) {
      return paramzzhg.zza;
    }
    return new zzhj(paramzzhg);
  }
  
  public final int zza()
  {
    return zzln.zza;
  }
  
  public final void zza(int paramInt)
    throws IOException
  {
    this.zza.zza(paramInt, 3);
  }
  
  public final void zza(int paramInt, double paramDouble)
    throws IOException
  {
    this.zza.zza(paramInt, paramDouble);
  }
  
  public final void zza(int paramInt, float paramFloat)
    throws IOException
  {
    this.zza.zza(paramInt, paramFloat);
  }
  
  public final void zza(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zza.zze(paramInt1, paramInt2);
  }
  
  public final void zza(int paramInt, long paramLong)
    throws IOException
  {
    this.zza.zza(paramInt, paramLong);
  }
  
  public final void zza(int paramInt, zzgr paramzzgr)
    throws IOException
  {
    this.zza.zza(paramInt, paramzzgr);
  }
  
  public final <K, V> void zza(int paramInt, zzjc<K, V> paramzzjc, Map<K, V> paramMap)
    throws IOException
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      this.zza.zza(paramInt, 2);
      this.zza.zzb(zziz.zza(paramzzjc, localEntry.getKey(), localEntry.getValue()));
      zziz.zza(this.zza, paramzzjc, localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public final void zza(int paramInt, Object paramObject)
    throws IOException
  {
    if ((paramObject instanceof zzgr))
    {
      this.zza.zzb(paramInt, (zzgr)paramObject);
      return;
    }
    this.zza.zza(paramInt, (zzjh)paramObject);
  }
  
  public final void zza(int paramInt, Object paramObject, zzjz paramzzjz)
    throws IOException
  {
    this.zza.zza(paramInt, (zzjh)paramObject, paramzzjz);
  }
  
  public final void zza(int paramInt, String paramString)
    throws IOException
  {
    this.zza.zza(paramInt, paramString);
  }
  
  public final void zza(int paramInt, List<String> paramList)
    throws IOException
  {
    boolean bool = paramList instanceof zzis;
    int i = 0;
    int j = 0;
    if (bool)
    {
      zzis localzzis = (zzis)paramList;
      i = j;
      while (i < paramList.size())
      {
        Object localObject = localzzis.zzb(i);
        if ((localObject instanceof String)) {
          this.zza.zza(paramInt, (String)localObject);
        } else {
          this.zza.zza(paramInt, (zzgr)localObject);
        }
        i += 1;
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zza.zza(paramInt, (String)paramList.get(i));
      i += 1;
    }
  }
  
  public final void zza(int paramInt, List<?> paramList, zzjz paramzzjz)
    throws IOException
  {
    int i = 0;
    while (i < paramList.size())
    {
      zza(paramInt, paramList.get(i), paramzzjz);
      i += 1;
    }
  }
  
  public final void zza(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zza.zza(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzhg.zzf(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      this.zza.zzb(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.zza.zza(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zza.zzb(paramInt, ((Integer)paramList.get(i)).intValue());
      i += 1;
    }
  }
  
  public final void zza(int paramInt, boolean paramBoolean)
    throws IOException
  {
    this.zza.zza(paramInt, paramBoolean);
  }
  
  public final void zzb(int paramInt)
    throws IOException
  {
    this.zza.zza(paramInt, 4);
  }
  
  public final void zzb(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zza.zzb(paramInt1, paramInt2);
  }
  
  public final void zzb(int paramInt, long paramLong)
    throws IOException
  {
    this.zza.zzc(paramInt, paramLong);
  }
  
  public final void zzb(int paramInt, Object paramObject, zzjz paramzzjz)
    throws IOException
  {
    zzhg localzzhg = this.zza;
    paramObject = (zzjh)paramObject;
    localzzhg.zza(paramInt, 3);
    paramzzjz.zza(paramObject, localzzhg.zza);
    localzzhg.zza(paramInt, 4);
  }
  
  public final void zzb(int paramInt, List<zzgr> paramList)
    throws IOException
  {
    int i = 0;
    while (i < paramList.size())
    {
      this.zza.zza(paramInt, (zzgr)paramList.get(i));
      i += 1;
    }
  }
  
  public final void zzb(int paramInt, List<?> paramList, zzjz paramzzjz)
    throws IOException
  {
    int i = 0;
    while (i < paramList.size())
    {
      zzb(paramInt, paramList.get(i), paramzzjz);
      i += 1;
    }
  }
  
  public final void zzb(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zza.zza(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzhg.zzi(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      this.zza.zzb(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.zza.zzd(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zza.zze(paramInt, ((Integer)paramList.get(i)).intValue());
      i += 1;
    }
  }
  
  public final void zzc(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zza.zzb(paramInt1, paramInt2);
  }
  
  public final void zzc(int paramInt, long paramLong)
    throws IOException
  {
    this.zza.zza(paramInt, paramLong);
  }
  
  public final void zzc(int paramInt, List<Long> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zza.zza(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzhg.zzd(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
      this.zza.zzb(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.zza.zza(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zza.zza(paramInt, ((Long)paramList.get(i)).longValue());
      i += 1;
    }
  }
  
  public final void zzd(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zza.zze(paramInt1, paramInt2);
  }
  
  public final void zzd(int paramInt, long paramLong)
    throws IOException
  {
    this.zza.zzc(paramInt, paramLong);
  }
  
  public final void zzd(int paramInt, List<Long> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zza.zza(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzhg.zze(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
      this.zza.zzb(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.zza.zza(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zza.zza(paramInt, ((Long)paramList.get(i)).longValue());
      i += 1;
    }
  }
  
  public final void zze(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zza.zzc(paramInt1, paramInt2);
  }
  
  public final void zze(int paramInt, long paramLong)
    throws IOException
  {
    this.zza.zzb(paramInt, paramLong);
  }
  
  public final void zze(int paramInt, List<Long> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zza.zza(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzhg.zzg(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
      this.zza.zzb(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.zza.zzc(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zza.zzc(paramInt, ((Long)paramList.get(i)).longValue());
      i += 1;
    }
  }
  
  public final void zzf(int paramInt1, int paramInt2)
    throws IOException
  {
    this.zza.zzd(paramInt1, paramInt2);
  }
  
  public final void zzf(int paramInt, List<Float> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zza.zza(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzhg.zzb(((Float)paramList.get(paramInt)).floatValue());
        paramInt += 1;
      }
      this.zza.zzb(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.zza.zza(((Float)paramList.get(paramInt)).floatValue());
        paramInt += 1;
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zza.zza(paramInt, ((Float)paramList.get(i)).floatValue());
      i += 1;
    }
  }
  
  public final void zzg(int paramInt, List<Double> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zza.zza(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzhg.zzb(((Double)paramList.get(paramInt)).doubleValue());
        paramInt += 1;
      }
      this.zza.zzb(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.zza.zza(((Double)paramList.get(paramInt)).doubleValue());
        paramInt += 1;
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zza.zza(paramInt, ((Double)paramList.get(i)).doubleValue());
      i += 1;
    }
  }
  
  public final void zzh(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zza.zza(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzhg.zzk(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      this.zza.zzb(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.zza.zza(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zza.zzb(paramInt, ((Integer)paramList.get(i)).intValue());
      i += 1;
    }
  }
  
  public final void zzi(int paramInt, List<Boolean> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zza.zza(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzhg.zzb(((Boolean)paramList.get(paramInt)).booleanValue());
        paramInt += 1;
      }
      this.zza.zzb(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.zza.zza(((Boolean)paramList.get(paramInt)).booleanValue());
        paramInt += 1;
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zza.zza(paramInt, ((Boolean)paramList.get(i)).booleanValue());
      i += 1;
    }
  }
  
  public final void zzj(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zza.zza(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzhg.zzg(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      this.zza.zzb(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.zza.zzb(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zza.zzc(paramInt, ((Integer)paramList.get(i)).intValue());
      i += 1;
    }
  }
  
  public final void zzk(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zza.zza(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzhg.zzj(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      this.zza.zzb(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.zza.zzd(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zza.zze(paramInt, ((Integer)paramList.get(i)).intValue());
      i += 1;
    }
  }
  
  public final void zzl(int paramInt, List<Long> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zza.zza(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzhg.zzh(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
      this.zza.zzb(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.zza.zzc(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zza.zzc(paramInt, ((Long)paramList.get(i)).longValue());
      i += 1;
    }
  }
  
  public final void zzm(int paramInt, List<Integer> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zza.zza(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzhg.zzh(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      this.zza.zzb(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.zza.zzc(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zza.zzd(paramInt, ((Integer)paramList.get(i)).intValue());
      i += 1;
    }
  }
  
  public final void zzn(int paramInt, List<Long> paramList, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.zza.zza(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size())
      {
        i += zzhg.zzf(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
      this.zza.zzb(i);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.zza.zzb(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
      return;
    }
    while (i < paramList.size())
    {
      this.zza.zzb(paramInt, ((Long)paramList.get(i)).longValue());
      i += 1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzhj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */