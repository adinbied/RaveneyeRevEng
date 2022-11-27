package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

final class zzjn<T>
  implements zzjz<T>
{
  private final zzjh zza;
  private final zzkr<?, ?> zzb;
  private final boolean zzc;
  private final zzho<?> zzd;
  
  private zzjn(zzkr<?, ?> paramzzkr, zzho<?> paramzzho, zzjh paramzzjh)
  {
    this.zzb = paramzzkr;
    this.zzc = paramzzho.zza(paramzzjh);
    this.zzd = paramzzho;
    this.zza = paramzzjh;
  }
  
  static <T> zzjn<T> zza(zzkr<?, ?> paramzzkr, zzho<?> paramzzho, zzjh paramzzjh)
  {
    return new zzjn(paramzzkr, paramzzho, paramzzjh);
  }
  
  public final int zza(T paramT)
  {
    int j = this.zzb.zzb(paramT).hashCode();
    int i = j;
    if (this.zzc) {
      i = j * 53 + this.zzd.zza(paramT).hashCode();
    }
    return i;
  }
  
  public final T zza()
  {
    return this.zza.zzbt().zzy();
  }
  
  public final void zza(T paramT, zzka paramzzka, zzhm paramzzhm)
    throws IOException
  {
    zzkr localzzkr = this.zzb;
    zzho localzzho = this.zzd;
    Object localObject2 = localzzkr.zzc(paramT);
    zzhp localzzhp = localzzho.zzb(paramT);
    for (;;)
    {
      try
      {
        i = paramzzka.zza();
        if (i == Integer.MAX_VALUE) {
          return;
        }
        i = paramzzka.zzb();
        if (i != 11)
        {
          if ((i & 0x7) == 2)
          {
            localObject1 = localzzho.zza(paramzzhm, this.zza, i >>> 3);
            if (localObject1 != null)
            {
              localzzho.zza(paramzzka, localObject1, paramzzhm, localzzhp);
            }
            else
            {
              bool = localzzkr.zza(localObject2, paramzzka);
              continue;
            }
          }
          else
          {
            bool = paramzzka.zzc();
            continue;
            if (paramzzka.zza() != Integer.MAX_VALUE)
            {
              int j = paramzzka.zzb();
              if (j == 16)
              {
                i = paramzzka.zzo();
                localObject1 = localzzho.zza(paramzzhm, this.zza, i);
                continue;
              }
              if (j == 26)
              {
                if (localObject1 != null)
                {
                  localzzho.zza(paramzzka, localObject1, paramzzhm, localzzhp);
                  continue;
                }
                localzzgr = paramzzka.zzn();
                continue;
              }
              if (paramzzka.zzc()) {
                continue;
              }
            }
            if (paramzzka.zzb() != 12) {
              continue;
            }
            if (localzzgr != null) {
              if (localObject1 != null) {
                localzzho.zza(localzzgr, localObject1, paramzzhm, localzzhp);
              } else {
                localzzkr.zza(localObject2, i, localzzgr);
              }
            }
          }
          boolean bool = true;
          if (bool) {
            continue;
          }
          return;
          throw zzih.zze();
        }
      }
      finally
      {
        localzzkr.zzb(paramT, localObject2);
      }
      int i = 0;
      Object localObject1 = null;
      zzgr localzzgr = null;
    }
  }
  
  public final void zza(T paramT, zzlo paramzzlo)
    throws IOException
  {
    Object localObject = this.zzd.zza(paramT).zzd();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      zzhr localzzhr = (zzhr)localEntry.getKey();
      if ((localzzhr.zzc() == zzll.zzi) && (!localzzhr.zzd()) && (!localzzhr.zze()))
      {
        if ((localEntry instanceof zzio)) {
          paramzzlo.zza(localzzhr.zza(), ((zzio)localEntry).zza().zzc());
        } else {
          paramzzlo.zza(localzzhr.zza(), localEntry.getValue());
        }
      }
      else {
        throw new IllegalStateException("Found invalid MessageSet item.");
      }
    }
    localObject = this.zzb;
    ((zzkr)localObject).zzb(((zzkr)localObject).zzb(paramT), paramzzlo);
  }
  
  public final void zza(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, zzgm paramzzgm)
    throws IOException
  {
    zzhz localzzhz = (zzhz)paramT;
    Object localObject2 = localzzhz.zzb;
    Object localObject1 = localObject2;
    if (localObject2 == zzku.zza())
    {
      localObject1 = zzku.zzb();
      localzzhz.zzb = ((zzku)localObject1);
    }
    ((zzhz.zzb)paramT).zza();
    paramT = null;
    while (paramInt1 < paramInt2)
    {
      paramInt1 = zzgn.zza(paramArrayOfByte, paramInt1, paramzzgm);
      int i = paramzzgm.zza;
      if (i != 11)
      {
        if ((i & 0x7) == 2)
        {
          paramT = (zzhz.zzd)this.zzd.zza(paramzzgm.zzd, this.zza, i >>> 3);
          if (paramT == null)
          {
            paramInt1 = zzgn.zza(i, paramArrayOfByte, paramInt1, paramInt2, (zzku)localObject1, paramzzgm);
          }
          else
          {
            zzjv.zza();
            throw new NoSuchMethodError();
          }
        }
        else
        {
          paramInt1 = zzgn.zza(i, paramArrayOfByte, paramInt1, paramInt2, paramzzgm);
        }
      }
      else
      {
        int j = 0;
        localObject2 = null;
        for (;;)
        {
          i = paramInt1;
          if (paramInt1 >= paramInt2) {
            break;
          }
          paramInt1 = zzgn.zza(paramArrayOfByte, paramInt1, paramzzgm);
          int k = paramzzgm.zza;
          i = k >>> 3;
          int m = k & 0x7;
          if (i != 2)
          {
            if (i == 3) {
              if (paramT == null)
              {
                if (m == 2)
                {
                  paramInt1 = zzgn.zze(paramArrayOfByte, paramInt1, paramzzgm);
                  localObject2 = (zzgr)paramzzgm.zzc;
                }
              }
              else
              {
                zzjv.zza();
                throw new NoSuchMethodError();
              }
            }
          }
          else if (m == 0)
          {
            paramInt1 = zzgn.zza(paramArrayOfByte, paramInt1, paramzzgm);
            j = paramzzgm.zza;
            paramT = (zzhz.zzd)this.zzd.zza(paramzzgm.zzd, this.zza, j);
            continue;
          }
          i = paramInt1;
          if (k == 12) {
            break;
          }
          paramInt1 = zzgn.zza(k, paramArrayOfByte, paramInt1, paramInt2, paramzzgm);
        }
        if (localObject2 != null) {
          ((zzku)localObject1).zza(j << 3 | 0x2, localObject2);
        }
        paramInt1 = i;
      }
    }
    if (paramInt1 == paramInt2) {
      return;
    }
    throw zzih.zzg();
  }
  
  public final boolean zza(T paramT1, T paramT2)
  {
    if (!this.zzb.zzb(paramT1).equals(this.zzb.zzb(paramT2))) {
      return false;
    }
    if (this.zzc) {
      return this.zzd.zza(paramT1).equals(this.zzd.zza(paramT2));
    }
    return true;
  }
  
  public final int zzb(T paramT)
  {
    zzkr localzzkr = this.zzb;
    int j = localzzkr.zze(localzzkr.zzb(paramT)) + 0;
    int i = j;
    if (this.zzc) {
      i = j + this.zzd.zza(paramT).zzg();
    }
    return i;
  }
  
  public final void zzb(T paramT1, T paramT2)
  {
    zzkb.zza(this.zzb, paramT1, paramT2);
    if (this.zzc) {
      zzkb.zza(this.zzd, paramT1, paramT2);
    }
  }
  
  public final void zzc(T paramT)
  {
    this.zzb.zzd(paramT);
    this.zzd.zzc(paramT);
  }
  
  public final boolean zzd(T paramT)
  {
    return this.zzd.zza(paramT).zzf();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzjn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */