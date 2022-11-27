package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

public final class zzku
{
  private static final zzku zza = new zzku(0, new int[0], new Object[0], false);
  private int zzb;
  private int[] zzc;
  private Object[] zzd;
  private int zze = -1;
  private boolean zzf;
  
  private zzku()
  {
    this(0, new int[8], new Object[8], true);
  }
  
  private zzku(int paramInt, int[] paramArrayOfInt, Object[] paramArrayOfObject, boolean paramBoolean)
  {
    this.zzb = paramInt;
    this.zzc = paramArrayOfInt;
    this.zzd = paramArrayOfObject;
    this.zzf = paramBoolean;
  }
  
  public static zzku zza()
  {
    return zza;
  }
  
  static zzku zza(zzku paramzzku1, zzku paramzzku2)
  {
    int i = paramzzku1.zzb + paramzzku2.zzb;
    int[] arrayOfInt = Arrays.copyOf(paramzzku1.zzc, i);
    System.arraycopy(paramzzku2.zzc, 0, arrayOfInt, paramzzku1.zzb, paramzzku2.zzb);
    Object[] arrayOfObject = Arrays.copyOf(paramzzku1.zzd, i);
    System.arraycopy(paramzzku2.zzd, 0, arrayOfObject, paramzzku1.zzb, paramzzku2.zzb);
    return new zzku(i, arrayOfInt, arrayOfObject, true);
  }
  
  private static void zza(int paramInt, Object paramObject, zzlo paramzzlo)
    throws IOException
  {
    int i = paramInt >>> 3;
    paramInt &= 0x7;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt == 5)
            {
              paramzzlo.zzd(i, ((Integer)paramObject).intValue());
              return;
            }
            throw new RuntimeException(zzih.zzf());
          }
          if (paramzzlo.zza() == zzln.zza)
          {
            paramzzlo.zza(i);
            ((zzku)paramObject).zzb(paramzzlo);
            paramzzlo.zzb(i);
            return;
          }
          paramzzlo.zzb(i);
          ((zzku)paramObject).zzb(paramzzlo);
          paramzzlo.zza(i);
          return;
        }
        paramzzlo.zza(i, (zzgr)paramObject);
        return;
      }
      paramzzlo.zzd(i, ((Long)paramObject).longValue());
      return;
    }
    paramzzlo.zza(i, ((Long)paramObject).longValue());
  }
  
  static zzku zzb()
  {
    return new zzku();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof zzku)) {
      return false;
    }
    paramObject = (zzku)paramObject;
    int j = this.zzb;
    if (j == ((zzku)paramObject).zzb)
    {
      Object localObject = this.zzc;
      int[] arrayOfInt = ((zzku)paramObject).zzc;
      int i = 0;
      while (i < j)
      {
        if (localObject[i] != arrayOfInt[i])
        {
          i = 0;
          break label84;
        }
        i += 1;
      }
      i = 1;
      label84:
      if (i != 0)
      {
        localObject = this.zzd;
        paramObject = ((zzku)paramObject).zzd;
        j = this.zzb;
        i = 0;
        while (i < j)
        {
          if (!localObject[i].equals(paramObject[i]))
          {
            i = 0;
            break label138;
          }
          i += 1;
        }
        i = 1;
        label138:
        return i != 0;
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    int n = this.zzb;
    Object localObject = this.zzc;
    int m = 0;
    int k = 17;
    int j = 0;
    int i = 17;
    while (j < n)
    {
      i = i * 31 + localObject[j];
      j += 1;
    }
    localObject = this.zzd;
    int i1 = this.zzb;
    j = m;
    while (j < i1)
    {
      k = k * 31 + localObject[j].hashCode();
      j += 1;
    }
    return ((n + 527) * 31 + i) * 31 + k;
  }
  
  final void zza(int paramInt, Object paramObject)
  {
    if (this.zzf)
    {
      int i = this.zzb;
      if (i == this.zzc.length)
      {
        if (i < 4) {
          i = 8;
        } else {
          i >>= 1;
        }
        i = this.zzb + i;
        this.zzc = Arrays.copyOf(this.zzc, i);
        this.zzd = Arrays.copyOf(this.zzd, i);
      }
      int[] arrayOfInt = this.zzc;
      i = this.zzb;
      arrayOfInt[i] = paramInt;
      this.zzd[i] = paramObject;
      this.zzb = (i + 1);
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  final void zza(zzlo paramzzlo)
    throws IOException
  {
    if (paramzzlo.zza() == zzln.zzb)
    {
      i = this.zzb - 1;
      while (i >= 0)
      {
        paramzzlo.zza(this.zzc[i] >>> 3, this.zzd[i]);
        i -= 1;
      }
      return;
    }
    int i = 0;
    while (i < this.zzb)
    {
      paramzzlo.zza(this.zzc[i] >>> 3, this.zzd[i]);
      i += 1;
    }
  }
  
  final void zza(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = 0;
    while (i < this.zzb)
    {
      zzjm.zza(paramStringBuilder, paramInt, String.valueOf(this.zzc[i] >>> 3), this.zzd[i]);
      i += 1;
    }
  }
  
  public final void zzb(zzlo paramzzlo)
    throws IOException
  {
    if (this.zzb == 0) {
      return;
    }
    if (paramzzlo.zza() == zzln.zza)
    {
      i = 0;
      while (i < this.zzb)
      {
        zza(this.zzc[i], this.zzd[i], paramzzlo);
        i += 1;
      }
      return;
    }
    int i = this.zzb - 1;
    while (i >= 0)
    {
      zza(this.zzc[i], this.zzd[i], paramzzlo);
      i -= 1;
    }
  }
  
  public final void zzc()
  {
    this.zzf = false;
  }
  
  public final int zzd()
  {
    int i = this.zze;
    if (i != -1) {
      return i;
    }
    i = 0;
    int j = 0;
    while (i < this.zzb)
    {
      j += zzhg.zzd(this.zzc[i] >>> 3, (zzgr)this.zzd[i]);
      i += 1;
    }
    this.zze = j;
    return j;
  }
  
  public final int zze()
  {
    int i = this.zze;
    if (i != -1) {
      return i;
    }
    int j = 0;
    int k = 0;
    while (j < this.zzb)
    {
      int m = this.zzc[j];
      i = m >>> 3;
      m &= 0x7;
      if (m != 0)
      {
        if (m != 1)
        {
          if (m != 2)
          {
            if (m != 3)
            {
              if (m == 5) {
                i = zzhg.zzi(i, ((Integer)this.zzd[j]).intValue());
              } else {
                throw new IllegalStateException(zzih.zzf());
              }
            }
            else {
              i = (zzhg.zze(i) << 1) + ((zzku)this.zzd[j]).zze();
            }
          }
          else {
            i = zzhg.zzc(i, (zzgr)this.zzd[j]);
          }
        }
        else {
          i = zzhg.zzg(i, ((Long)this.zzd[j]).longValue());
        }
      }
      else {
        i = zzhg.zze(i, ((Long)this.zzd[j]).longValue());
      }
      k += i;
      j += 1;
    }
    this.zze = k;
    return k;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzku.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */