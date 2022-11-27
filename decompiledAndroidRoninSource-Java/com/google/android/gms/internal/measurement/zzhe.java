package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

final class zzhe
  implements zzka
{
  private final zzhd zza;
  private int zzb;
  private int zzc;
  private int zzd = 0;
  
  private zzhe(zzhd paramzzhd)
  {
    paramzzhd = (zzhd)zzic.zza(paramzzhd, "input");
    this.zza = paramzzhd;
    paramzzhd.zzc = this;
  }
  
  public static zzhe zza(zzhd paramzzhd)
  {
    if (paramzzhd.zzc != null) {
      return paramzzhd.zzc;
    }
    return new zzhe(paramzzhd);
  }
  
  private final Object zza(zzli paramzzli, Class<?> paramClass, zzhm paramzzhm)
    throws IOException
  {
    switch (zzhh.zza[paramzzli.ordinal()])
    {
    default: 
      throw new RuntimeException("unsupported field type.");
    case 17: 
      return Long.valueOf(zzf());
    case 16: 
      return Integer.valueOf(zzo());
    case 15: 
      return zzm();
    case 14: 
      return Long.valueOf(zzt());
    case 13: 
      return Integer.valueOf(zzs());
    case 12: 
      return Long.valueOf(zzr());
    case 11: 
      return Integer.valueOf(zzq());
    case 10: 
      zza(2);
      return zzc(zzjv.zza().zza(paramClass), paramzzhm);
    case 9: 
      return Long.valueOf(zzg());
    case 8: 
      return Integer.valueOf(zzh());
    case 7: 
      return Float.valueOf(zze());
    case 6: 
      return Long.valueOf(zzi());
    case 5: 
      return Integer.valueOf(zzj());
    case 4: 
      return Integer.valueOf(zzp());
    case 3: 
      return Double.valueOf(zzd());
    case 2: 
      return zzn();
    }
    return Boolean.valueOf(zzk());
  }
  
  private final void zza(int paramInt)
    throws IOException
  {
    if ((this.zzb & 0x7) == paramInt) {
      return;
    }
    throw zzih.zzf();
  }
  
  private final void zza(List<String> paramList, boolean paramBoolean)
    throws IOException
  {
    if ((this.zzb & 0x7) == 2)
    {
      int i;
      if (((paramList instanceof zzis)) && (!paramBoolean))
      {
        paramList = (zzis)paramList;
        do
        {
          paramList.zza(zzn());
          if (this.zza.zzt()) {
            return;
          }
          i = this.zza.zza();
        } while (i == this.zzb);
        this.zzd = i;
        return;
      }
      do
      {
        String str;
        if (paramBoolean) {
          str = zzm();
        } else {
          str = zzl();
        }
        paramList.add(str);
        if (this.zza.zzt()) {
          return;
        }
        i = this.zza.zza();
      } while (i == this.zzb);
      this.zzd = i;
      return;
    }
    throw zzih.zzf();
  }
  
  private static void zzb(int paramInt)
    throws IOException
  {
    if ((paramInt & 0x7) == 0) {
      return;
    }
    throw zzih.zzg();
  }
  
  private final <T> T zzc(zzjz<T> paramzzjz, zzhm paramzzhm)
    throws IOException
  {
    int i = this.zza.zzm();
    if (this.zza.zza < this.zza.zzb)
    {
      i = this.zza.zzc(i);
      Object localObject = paramzzjz.zza();
      zzhd localzzhd = this.zza;
      localzzhd.zza += 1;
      paramzzjz.zza(localObject, this, paramzzhm);
      paramzzjz.zzc(localObject);
      this.zza.zza(0);
      paramzzjz = this.zza;
      paramzzjz.zza -= 1;
      this.zza.zzd(i);
      return (T)localObject;
    }
    throw new zzih("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
  }
  
  private static void zzc(int paramInt)
    throws IOException
  {
    if ((paramInt & 0x3) == 0) {
      return;
    }
    throw zzih.zzg();
  }
  
  private final <T> T zzd(zzjz<T> paramzzjz, zzhm paramzzhm)
    throws IOException
  {
    int i = this.zzc;
    this.zzc = (this.zzb >>> 3 << 3 | 0x4);
    try
    {
      Object localObject = paramzzjz.zza();
      paramzzjz.zza(localObject, this, paramzzhm);
      paramzzjz.zzc(localObject);
      int j = this.zzb;
      int k = this.zzc;
      if (j == k) {
        return (T)localObject;
      }
      throw zzih.zzg();
    }
    finally
    {
      this.zzc = i;
    }
  }
  
  private final void zzd(int paramInt)
    throws IOException
  {
    if (this.zza.zzu() == paramInt) {
      return;
    }
    throw zzih.zza();
  }
  
  public final int zza()
    throws IOException
  {
    int i = this.zzd;
    if (i != 0)
    {
      this.zzb = i;
      this.zzd = 0;
    }
    else
    {
      this.zzb = this.zza.zza();
    }
    i = this.zzb;
    if ((i != 0) && (i != this.zzc)) {
      return i >>> 3;
    }
    return Integer.MAX_VALUE;
  }
  
  public final <T> T zza(zzjz<T> paramzzjz, zzhm paramzzhm)
    throws IOException
  {
    zza(2);
    return (T)zzc(paramzzjz, paramzzhm);
  }
  
  public final void zza(List<Double> paramList)
    throws IOException
  {
    int j;
    if ((paramList instanceof zzhl))
    {
      paramList = (zzhl)paramList;
      i = this.zzb & 0x7;
      if (i != 1)
      {
        if (i == 2)
        {
          i = this.zza.zzm();
          zzb(i);
          j = this.zza.zzu();
          do
          {
            paramList.zza(this.zza.zzb());
          } while (this.zza.zzu() < j + i);
          return;
        }
        throw zzih.zzf();
      }
      do
      {
        paramList.zza(this.zza.zzb());
        if (this.zza.zzt()) {
          return;
        }
        i = this.zza.zza();
      } while (i == this.zzb);
      this.zzd = i;
      return;
    }
    int i = this.zzb & 0x7;
    if (i != 1)
    {
      if (i == 2)
      {
        i = this.zza.zzm();
        zzb(i);
        j = this.zza.zzu();
        do
        {
          paramList.add(Double.valueOf(this.zza.zzb()));
        } while (this.zza.zzu() < j + i);
        return;
      }
      throw zzih.zzf();
    }
    do
    {
      paramList.add(Double.valueOf(this.zza.zzb()));
      if (this.zza.zzt()) {
        return;
      }
      i = this.zza.zza();
    } while (i == this.zzb);
    this.zzd = i;
  }
  
  public final <T> void zza(List<T> paramList, zzjz<T> paramzzjz, zzhm paramzzhm)
    throws IOException
  {
    int i = this.zzb;
    if ((i & 0x7) == 2)
    {
      int j;
      do
      {
        paramList.add(zzc(paramzzjz, paramzzhm));
        if (this.zza.zzt()) {
          break;
        }
        if (this.zzd != 0) {
          return;
        }
        j = this.zza.zza();
      } while (j == i);
      this.zzd = j;
      return;
    }
    throw zzih.zzf();
  }
  
  public final <K, V> void zza(Map<K, V> paramMap, zzjc<K, V> paramzzjc, zzhm paramzzhm)
    throws IOException
  {
    zza(2);
    i = this.zza.zzm();
    i = this.zza.zzc(i);
    Object localObject1 = paramzzjc.zzb;
    Object localObject2 = paramzzjc.zzd;
    do
    {
      for (;;)
      {
        try
        {
          int j = zza();
          if (j != Integer.MAX_VALUE)
          {
            boolean bool = this.zza.zzt();
            if (!bool) {
              if (j != 1) {
                if (j == 2) {}
              }
            }
          }
        }
        finally
        {
          Object localObject3;
          this.zza.zzd(i);
        }
        try
        {
          if (zzc()) {
            continue;
          }
          throw new zzih("Unable to parse map entry.");
        }
        catch (zzik localzzik)
        {
          continue;
        }
        localObject3 = zza(paramzzjc.zzc, paramzzjc.zzd.getClass(), paramzzhm);
        localObject2 = localObject3;
        continue;
        localObject3 = zza(paramzzjc.zza, null, null);
        localObject1 = localObject3;
      }
    } while (zzc());
    throw new zzih("Unable to parse map entry.");
    paramMap.put(localObject1, localObject2);
    this.zza.zzd(i);
  }
  
  public final int zzb()
  {
    return this.zzb;
  }
  
  public final <T> T zzb(zzjz<T> paramzzjz, zzhm paramzzhm)
    throws IOException
  {
    zza(3);
    return (T)zzd(paramzzjz, paramzzhm);
  }
  
  public final void zzb(List<Float> paramList)
    throws IOException
  {
    if ((paramList instanceof zzhv))
    {
      paramList = (zzhv)paramList;
      i = this.zzb & 0x7;
      if (i != 2)
      {
        if (i == 5)
        {
          do
          {
            paramList.zza(this.zza.zzc());
            if (this.zza.zzt()) {
              return;
            }
            i = this.zza.zza();
          } while (i == this.zzb);
          this.zzd = i;
          return;
        }
        throw zzih.zzf();
      }
      i = this.zza.zzm();
      zzc(i);
      j = this.zza.zzu();
      do
      {
        paramList.zza(this.zza.zzc());
      } while (this.zza.zzu() < j + i);
      return;
    }
    int i = this.zzb & 0x7;
    if (i != 2)
    {
      if (i == 5)
      {
        do
        {
          paramList.add(Float.valueOf(this.zza.zzc()));
          if (this.zza.zzt()) {
            return;
          }
          i = this.zza.zza();
        } while (i == this.zzb);
        this.zzd = i;
        return;
      }
      throw zzih.zzf();
    }
    i = this.zza.zzm();
    zzc(i);
    int j = this.zza.zzu();
    do
    {
      paramList.add(Float.valueOf(this.zza.zzc()));
    } while (this.zza.zzu() < j + i);
  }
  
  public final <T> void zzb(List<T> paramList, zzjz<T> paramzzjz, zzhm paramzzhm)
    throws IOException
  {
    int i = this.zzb;
    if ((i & 0x7) == 3)
    {
      int j;
      do
      {
        paramList.add(zzd(paramzzjz, paramzzhm));
        if (this.zza.zzt()) {
          break;
        }
        if (this.zzd != 0) {
          return;
        }
        j = this.zza.zza();
      } while (j == i);
      this.zzd = j;
      return;
    }
    throw zzih.zzf();
  }
  
  public final void zzc(List<Long> paramList)
    throws IOException
  {
    if ((paramList instanceof zziv))
    {
      paramList = (zziv)paramList;
      i = this.zzb & 0x7;
      if (i != 0)
      {
        if (i == 2)
        {
          i = this.zza.zzm();
          i = this.zza.zzu() + i;
          do
          {
            paramList.zza(this.zza.zzd());
          } while (this.zza.zzu() < i);
          zzd(i);
          return;
        }
        throw zzih.zzf();
      }
      do
      {
        paramList.zza(this.zza.zzd());
        if (this.zza.zzt()) {
          return;
        }
        i = this.zza.zza();
      } while (i == this.zzb);
      this.zzd = i;
      return;
    }
    int i = this.zzb & 0x7;
    if (i != 0)
    {
      if (i == 2)
      {
        i = this.zza.zzm();
        i = this.zza.zzu() + i;
        do
        {
          paramList.add(Long.valueOf(this.zza.zzd()));
        } while (this.zza.zzu() < i);
        zzd(i);
        return;
      }
      throw zzih.zzf();
    }
    do
    {
      paramList.add(Long.valueOf(this.zza.zzd()));
      if (this.zza.zzt()) {
        return;
      }
      i = this.zza.zza();
    } while (i == this.zzb);
    this.zzd = i;
  }
  
  public final boolean zzc()
    throws IOException
  {
    if (!this.zza.zzt())
    {
      int i = this.zzb;
      if (i != this.zzc) {
        return this.zza.zzb(i);
      }
    }
    return false;
  }
  
  public final double zzd()
    throws IOException
  {
    zza(1);
    return this.zza.zzb();
  }
  
  public final void zzd(List<Long> paramList)
    throws IOException
  {
    if ((paramList instanceof zziv))
    {
      paramList = (zziv)paramList;
      i = this.zzb & 0x7;
      if (i != 0)
      {
        if (i == 2)
        {
          i = this.zza.zzm();
          i = this.zza.zzu() + i;
          do
          {
            paramList.zza(this.zza.zze());
          } while (this.zza.zzu() < i);
          zzd(i);
          return;
        }
        throw zzih.zzf();
      }
      do
      {
        paramList.zza(this.zza.zze());
        if (this.zza.zzt()) {
          return;
        }
        i = this.zza.zza();
      } while (i == this.zzb);
      this.zzd = i;
      return;
    }
    int i = this.zzb & 0x7;
    if (i != 0)
    {
      if (i == 2)
      {
        i = this.zza.zzm();
        i = this.zza.zzu() + i;
        do
        {
          paramList.add(Long.valueOf(this.zza.zze()));
        } while (this.zza.zzu() < i);
        zzd(i);
        return;
      }
      throw zzih.zzf();
    }
    do
    {
      paramList.add(Long.valueOf(this.zza.zze()));
      if (this.zza.zzt()) {
        return;
      }
      i = this.zza.zza();
    } while (i == this.zzb);
    this.zzd = i;
  }
  
  public final float zze()
    throws IOException
  {
    zza(5);
    return this.zza.zzc();
  }
  
  public final void zze(List<Integer> paramList)
    throws IOException
  {
    if ((paramList instanceof zzia))
    {
      paramList = (zzia)paramList;
      i = this.zzb & 0x7;
      if (i != 0)
      {
        if (i == 2)
        {
          i = this.zza.zzm();
          i = this.zza.zzu() + i;
          do
          {
            paramList.zzd(this.zza.zzf());
          } while (this.zza.zzu() < i);
          zzd(i);
          return;
        }
        throw zzih.zzf();
      }
      do
      {
        paramList.zzd(this.zza.zzf());
        if (this.zza.zzt()) {
          return;
        }
        i = this.zza.zza();
      } while (i == this.zzb);
      this.zzd = i;
      return;
    }
    int i = this.zzb & 0x7;
    if (i != 0)
    {
      if (i == 2)
      {
        i = this.zza.zzm();
        i = this.zza.zzu() + i;
        do
        {
          paramList.add(Integer.valueOf(this.zza.zzf()));
        } while (this.zza.zzu() < i);
        zzd(i);
        return;
      }
      throw zzih.zzf();
    }
    do
    {
      paramList.add(Integer.valueOf(this.zza.zzf()));
      if (this.zza.zzt()) {
        return;
      }
      i = this.zza.zza();
    } while (i == this.zzb);
    this.zzd = i;
  }
  
  public final long zzf()
    throws IOException
  {
    zza(0);
    return this.zza.zzd();
  }
  
  public final void zzf(List<Long> paramList)
    throws IOException
  {
    int j;
    if ((paramList instanceof zziv))
    {
      paramList = (zziv)paramList;
      i = this.zzb & 0x7;
      if (i != 1)
      {
        if (i == 2)
        {
          i = this.zza.zzm();
          zzb(i);
          j = this.zza.zzu();
          do
          {
            paramList.zza(this.zza.zzg());
          } while (this.zza.zzu() < j + i);
          return;
        }
        throw zzih.zzf();
      }
      do
      {
        paramList.zza(this.zza.zzg());
        if (this.zza.zzt()) {
          return;
        }
        i = this.zza.zza();
      } while (i == this.zzb);
      this.zzd = i;
      return;
    }
    int i = this.zzb & 0x7;
    if (i != 1)
    {
      if (i == 2)
      {
        i = this.zza.zzm();
        zzb(i);
        j = this.zza.zzu();
        do
        {
          paramList.add(Long.valueOf(this.zza.zzg()));
        } while (this.zza.zzu() < j + i);
        return;
      }
      throw zzih.zzf();
    }
    do
    {
      paramList.add(Long.valueOf(this.zza.zzg()));
      if (this.zza.zzt()) {
        return;
      }
      i = this.zza.zza();
    } while (i == this.zzb);
    this.zzd = i;
  }
  
  public final long zzg()
    throws IOException
  {
    zza(0);
    return this.zza.zze();
  }
  
  public final void zzg(List<Integer> paramList)
    throws IOException
  {
    if ((paramList instanceof zzia))
    {
      paramList = (zzia)paramList;
      i = this.zzb & 0x7;
      if (i != 2)
      {
        if (i == 5)
        {
          do
          {
            paramList.zzd(this.zza.zzh());
            if (this.zza.zzt()) {
              return;
            }
            i = this.zza.zza();
          } while (i == this.zzb);
          this.zzd = i;
          return;
        }
        throw zzih.zzf();
      }
      i = this.zza.zzm();
      zzc(i);
      j = this.zza.zzu();
      do
      {
        paramList.zzd(this.zza.zzh());
      } while (this.zza.zzu() < j + i);
      return;
    }
    int i = this.zzb & 0x7;
    if (i != 2)
    {
      if (i == 5)
      {
        do
        {
          paramList.add(Integer.valueOf(this.zza.zzh()));
          if (this.zza.zzt()) {
            return;
          }
          i = this.zza.zza();
        } while (i == this.zzb);
        this.zzd = i;
        return;
      }
      throw zzih.zzf();
    }
    i = this.zza.zzm();
    zzc(i);
    int j = this.zza.zzu();
    do
    {
      paramList.add(Integer.valueOf(this.zza.zzh()));
    } while (this.zza.zzu() < j + i);
  }
  
  public final int zzh()
    throws IOException
  {
    zza(0);
    return this.zza.zzf();
  }
  
  public final void zzh(List<Boolean> paramList)
    throws IOException
  {
    if ((paramList instanceof zzgp))
    {
      paramList = (zzgp)paramList;
      i = this.zzb & 0x7;
      if (i != 0)
      {
        if (i == 2)
        {
          i = this.zza.zzm();
          i = this.zza.zzu() + i;
          do
          {
            paramList.zza(this.zza.zzi());
          } while (this.zza.zzu() < i);
          zzd(i);
          return;
        }
        throw zzih.zzf();
      }
      do
      {
        paramList.zza(this.zza.zzi());
        if (this.zza.zzt()) {
          return;
        }
        i = this.zza.zza();
      } while (i == this.zzb);
      this.zzd = i;
      return;
    }
    int i = this.zzb & 0x7;
    if (i != 0)
    {
      if (i == 2)
      {
        i = this.zza.zzm();
        i = this.zza.zzu() + i;
        do
        {
          paramList.add(Boolean.valueOf(this.zza.zzi()));
        } while (this.zza.zzu() < i);
        zzd(i);
        return;
      }
      throw zzih.zzf();
    }
    do
    {
      paramList.add(Boolean.valueOf(this.zza.zzi()));
      if (this.zza.zzt()) {
        return;
      }
      i = this.zza.zza();
    } while (i == this.zzb);
    this.zzd = i;
  }
  
  public final long zzi()
    throws IOException
  {
    zza(1);
    return this.zza.zzg();
  }
  
  public final void zzi(List<String> paramList)
    throws IOException
  {
    zza(paramList, false);
  }
  
  public final int zzj()
    throws IOException
  {
    zza(5);
    return this.zza.zzh();
  }
  
  public final void zzj(List<String> paramList)
    throws IOException
  {
    zza(paramList, true);
  }
  
  public final void zzk(List<zzgr> paramList)
    throws IOException
  {
    if ((this.zzb & 0x7) == 2)
    {
      int i;
      do
      {
        paramList.add(zzn());
        if (this.zza.zzt()) {
          return;
        }
        i = this.zza.zza();
      } while (i == this.zzb);
      this.zzd = i;
      return;
    }
    throw zzih.zzf();
  }
  
  public final boolean zzk()
    throws IOException
  {
    zza(0);
    return this.zza.zzi();
  }
  
  public final String zzl()
    throws IOException
  {
    zza(2);
    return this.zza.zzj();
  }
  
  public final void zzl(List<Integer> paramList)
    throws IOException
  {
    if ((paramList instanceof zzia))
    {
      paramList = (zzia)paramList;
      i = this.zzb & 0x7;
      if (i != 0)
      {
        if (i == 2)
        {
          i = this.zza.zzm();
          i = this.zza.zzu() + i;
          do
          {
            paramList.zzd(this.zza.zzm());
          } while (this.zza.zzu() < i);
          zzd(i);
          return;
        }
        throw zzih.zzf();
      }
      do
      {
        paramList.zzd(this.zza.zzm());
        if (this.zza.zzt()) {
          return;
        }
        i = this.zza.zza();
      } while (i == this.zzb);
      this.zzd = i;
      return;
    }
    int i = this.zzb & 0x7;
    if (i != 0)
    {
      if (i == 2)
      {
        i = this.zza.zzm();
        i = this.zza.zzu() + i;
        do
        {
          paramList.add(Integer.valueOf(this.zza.zzm()));
        } while (this.zza.zzu() < i);
        zzd(i);
        return;
      }
      throw zzih.zzf();
    }
    do
    {
      paramList.add(Integer.valueOf(this.zza.zzm()));
      if (this.zza.zzt()) {
        return;
      }
      i = this.zza.zza();
    } while (i == this.zzb);
    this.zzd = i;
  }
  
  public final String zzm()
    throws IOException
  {
    zza(2);
    return this.zza.zzk();
  }
  
  public final void zzm(List<Integer> paramList)
    throws IOException
  {
    if ((paramList instanceof zzia))
    {
      paramList = (zzia)paramList;
      i = this.zzb & 0x7;
      if (i != 0)
      {
        if (i == 2)
        {
          i = this.zza.zzm();
          i = this.zza.zzu() + i;
          do
          {
            paramList.zzd(this.zza.zzn());
          } while (this.zza.zzu() < i);
          zzd(i);
          return;
        }
        throw zzih.zzf();
      }
      do
      {
        paramList.zzd(this.zza.zzn());
        if (this.zza.zzt()) {
          return;
        }
        i = this.zza.zza();
      } while (i == this.zzb);
      this.zzd = i;
      return;
    }
    int i = this.zzb & 0x7;
    if (i != 0)
    {
      if (i == 2)
      {
        i = this.zza.zzm();
        i = this.zza.zzu() + i;
        do
        {
          paramList.add(Integer.valueOf(this.zza.zzn()));
        } while (this.zza.zzu() < i);
        zzd(i);
        return;
      }
      throw zzih.zzf();
    }
    do
    {
      paramList.add(Integer.valueOf(this.zza.zzn()));
      if (this.zza.zzt()) {
        return;
      }
      i = this.zza.zza();
    } while (i == this.zzb);
    this.zzd = i;
  }
  
  public final zzgr zzn()
    throws IOException
  {
    zza(2);
    return this.zza.zzl();
  }
  
  public final void zzn(List<Integer> paramList)
    throws IOException
  {
    if ((paramList instanceof zzia))
    {
      paramList = (zzia)paramList;
      i = this.zzb & 0x7;
      if (i != 2)
      {
        if (i == 5)
        {
          do
          {
            paramList.zzd(this.zza.zzo());
            if (this.zza.zzt()) {
              return;
            }
            i = this.zza.zza();
          } while (i == this.zzb);
          this.zzd = i;
          return;
        }
        throw zzih.zzf();
      }
      i = this.zza.zzm();
      zzc(i);
      j = this.zza.zzu();
      do
      {
        paramList.zzd(this.zza.zzo());
      } while (this.zza.zzu() < j + i);
      return;
    }
    int i = this.zzb & 0x7;
    if (i != 2)
    {
      if (i == 5)
      {
        do
        {
          paramList.add(Integer.valueOf(this.zza.zzo()));
          if (this.zza.zzt()) {
            return;
          }
          i = this.zza.zza();
        } while (i == this.zzb);
        this.zzd = i;
        return;
      }
      throw zzih.zzf();
    }
    i = this.zza.zzm();
    zzc(i);
    int j = this.zza.zzu();
    do
    {
      paramList.add(Integer.valueOf(this.zza.zzo()));
    } while (this.zza.zzu() < j + i);
  }
  
  public final int zzo()
    throws IOException
  {
    zza(0);
    return this.zza.zzm();
  }
  
  public final void zzo(List<Long> paramList)
    throws IOException
  {
    int j;
    if ((paramList instanceof zziv))
    {
      paramList = (zziv)paramList;
      i = this.zzb & 0x7;
      if (i != 1)
      {
        if (i == 2)
        {
          i = this.zza.zzm();
          zzb(i);
          j = this.zza.zzu();
          do
          {
            paramList.zza(this.zza.zzp());
          } while (this.zza.zzu() < j + i);
          return;
        }
        throw zzih.zzf();
      }
      do
      {
        paramList.zza(this.zza.zzp());
        if (this.zza.zzt()) {
          return;
        }
        i = this.zza.zza();
      } while (i == this.zzb);
      this.zzd = i;
      return;
    }
    int i = this.zzb & 0x7;
    if (i != 1)
    {
      if (i == 2)
      {
        i = this.zza.zzm();
        zzb(i);
        j = this.zza.zzu();
        do
        {
          paramList.add(Long.valueOf(this.zza.zzp()));
        } while (this.zza.zzu() < j + i);
        return;
      }
      throw zzih.zzf();
    }
    do
    {
      paramList.add(Long.valueOf(this.zza.zzp()));
      if (this.zza.zzt()) {
        return;
      }
      i = this.zza.zza();
    } while (i == this.zzb);
    this.zzd = i;
  }
  
  public final int zzp()
    throws IOException
  {
    zza(0);
    return this.zza.zzn();
  }
  
  public final void zzp(List<Integer> paramList)
    throws IOException
  {
    if ((paramList instanceof zzia))
    {
      paramList = (zzia)paramList;
      i = this.zzb & 0x7;
      if (i != 0)
      {
        if (i == 2)
        {
          i = this.zza.zzm();
          i = this.zza.zzu() + i;
          do
          {
            paramList.zzd(this.zza.zzq());
          } while (this.zza.zzu() < i);
          zzd(i);
          return;
        }
        throw zzih.zzf();
      }
      do
      {
        paramList.zzd(this.zza.zzq());
        if (this.zza.zzt()) {
          return;
        }
        i = this.zza.zza();
      } while (i == this.zzb);
      this.zzd = i;
      return;
    }
    int i = this.zzb & 0x7;
    if (i != 0)
    {
      if (i == 2)
      {
        i = this.zza.zzm();
        i = this.zza.zzu() + i;
        do
        {
          paramList.add(Integer.valueOf(this.zza.zzq()));
        } while (this.zza.zzu() < i);
        zzd(i);
        return;
      }
      throw zzih.zzf();
    }
    do
    {
      paramList.add(Integer.valueOf(this.zza.zzq()));
      if (this.zza.zzt()) {
        return;
      }
      i = this.zza.zza();
    } while (i == this.zzb);
    this.zzd = i;
  }
  
  public final int zzq()
    throws IOException
  {
    zza(5);
    return this.zza.zzo();
  }
  
  public final void zzq(List<Long> paramList)
    throws IOException
  {
    if ((paramList instanceof zziv))
    {
      paramList = (zziv)paramList;
      i = this.zzb & 0x7;
      if (i != 0)
      {
        if (i == 2)
        {
          i = this.zza.zzm();
          i = this.zza.zzu() + i;
          do
          {
            paramList.zza(this.zza.zzr());
          } while (this.zza.zzu() < i);
          zzd(i);
          return;
        }
        throw zzih.zzf();
      }
      do
      {
        paramList.zza(this.zza.zzr());
        if (this.zza.zzt()) {
          return;
        }
        i = this.zza.zza();
      } while (i == this.zzb);
      this.zzd = i;
      return;
    }
    int i = this.zzb & 0x7;
    if (i != 0)
    {
      if (i == 2)
      {
        i = this.zza.zzm();
        i = this.zza.zzu() + i;
        do
        {
          paramList.add(Long.valueOf(this.zza.zzr()));
        } while (this.zza.zzu() < i);
        zzd(i);
        return;
      }
      throw zzih.zzf();
    }
    do
    {
      paramList.add(Long.valueOf(this.zza.zzr()));
      if (this.zza.zzt()) {
        return;
      }
      i = this.zza.zza();
    } while (i == this.zzb);
    this.zzd = i;
  }
  
  public final long zzr()
    throws IOException
  {
    zza(1);
    return this.zza.zzp();
  }
  
  public final int zzs()
    throws IOException
  {
    zza(0);
    return this.zza.zzq();
  }
  
  public final long zzt()
    throws IOException
  {
    zza(0);
    return this.zza.zzr();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzhe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */