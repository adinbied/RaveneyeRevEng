package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

final class zzhf
  extends zzhd
{
  private final byte[] zzd;
  private final boolean zze;
  private int zzf;
  private int zzg;
  private int zzh;
  private int zzi;
  private int zzj;
  private int zzk = Integer.MAX_VALUE;
  
  private zzhf(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(null);
    this.zzd = paramArrayOfByte;
    this.zzf = (paramInt2 + paramInt1);
    this.zzh = paramInt1;
    this.zzi = paramInt1;
    this.zze = paramBoolean;
  }
  
  private final byte zzaa()
    throws IOException
  {
    int i = this.zzh;
    if (i != this.zzf)
    {
      byte[] arrayOfByte = this.zzd;
      this.zzh = (i + 1);
      return arrayOfByte[i];
    }
    throw zzih.zza();
  }
  
  private final void zzf(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      int i = this.zzf;
      int j = this.zzh;
      if (paramInt <= i - j)
      {
        this.zzh = (j + paramInt);
        return;
      }
    }
    if (paramInt < 0) {
      throw zzih.zzb();
    }
    throw zzih.zza();
  }
  
  private final int zzv()
    throws IOException
  {
    int k = this.zzh;
    int i = this.zzf;
    if (i != k)
    {
      byte[] arrayOfByte = this.zzd;
      int j = k + 1;
      k = arrayOfByte[k];
      if (k >= 0)
      {
        this.zzh = j;
        return k;
      }
      if (i - j >= 9)
      {
        i = j + 1;
        k ^= arrayOfByte[j] << 7;
        if (k < 0)
        {
          j = k ^ 0xFFFFFF80;
        }
        else
        {
          j = i + 1;
          k ^= arrayOfByte[i] << 14;
          if (k >= 0)
          {
            k ^= 0x3F80;
            i = j;
            j = k;
          }
          for (;;)
          {
            break;
            i = j + 1;
            j = k ^ arrayOfByte[j] << 21;
            if (j < 0)
            {
              j ^= 0xFFE03F80;
            }
            else
            {
              int m = i + 1;
              int n = arrayOfByte[i];
              k = j ^ n << 28 ^ 0xFE03F80;
              j = k;
              i = m;
              if (n < 0)
              {
                n = m + 1;
                j = k;
                i = n;
                if (arrayOfByte[m] < 0)
                {
                  m = n + 1;
                  j = k;
                  i = m;
                  if (arrayOfByte[n] < 0)
                  {
                    n = m + 1;
                    j = k;
                    i = n;
                    if (arrayOfByte[m] < 0)
                    {
                      m = n + 1;
                      j = k;
                      i = m;
                      if (arrayOfByte[n] < 0)
                      {
                        i = m + 1;
                        if (arrayOfByte[m] < 0) {
                          break label262;
                        }
                        j = k;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        this.zzh = i;
        return j;
      }
    }
    label262:
    return (int)zzs();
  }
  
  private final long zzw()
    throws IOException
  {
    int k = this.zzh;
    int i = this.zzf;
    if (i != k)
    {
      byte[] arrayOfByte = this.zzd;
      int j = k + 1;
      k = arrayOfByte[k];
      if (k >= 0)
      {
        this.zzh = j;
        return k;
      }
      if (i - j >= 9)
      {
        i = j + 1;
        k ^= arrayOfByte[j] << 7;
        if (k < 0) {
          j = k ^ 0xFFFFFF80;
        }
        for (;;)
        {
          l1 = j;
          break label334;
          j = i + 1;
          k ^= arrayOfByte[i] << 14;
          if (k >= 0)
          {
            l1 = k ^ 0x3F80;
            i = j;
            break label334;
          }
          i = j + 1;
          j = k ^ arrayOfByte[j] << 21;
          if (j >= 0) {
            break;
          }
          j ^= 0xFFE03F80;
        }
        long l1 = j;
        j = i + 1;
        long l2 = l1 ^ arrayOfByte[i] << 28;
        if (l2 >= 0L)
        {
          l1 = 266354560L;
          i = j;
          l1 = l2 ^ l1;
        }
        else
        {
          i = j + 1;
          l1 = l2 ^ arrayOfByte[j] << 35;
          if (l1 < 0L) {}
          for (l2 = -34093383808L;; l2 = -558586000294016L)
          {
            l1 ^= l2;
            break label334;
            j = i + 1;
            l2 = l1 ^ arrayOfByte[i] << 42;
            if (l2 >= 0L)
            {
              l1 = 4363953127296L;
              i = j;
              break;
            }
            i = j + 1;
            l1 = l2 ^ arrayOfByte[j] << 49;
            if (l1 >= 0L) {
              break label287;
            }
          }
          label287:
          j = i + 1;
          l1 = l1 ^ arrayOfByte[i] << 56 ^ 0xFE03F80FE03F80;
          if (l1 < 0L)
          {
            i = j + 1;
            if (arrayOfByte[j] < 0L) {
              break label342;
            }
          }
          else
          {
            i = j;
          }
        }
        label334:
        this.zzh = i;
        return l1;
      }
    }
    label342:
    return zzs();
  }
  
  private final int zzx()
    throws IOException
  {
    int i = this.zzh;
    if (this.zzf - i >= 4)
    {
      byte[] arrayOfByte = this.zzd;
      this.zzh = (i + 4);
      int j = arrayOfByte[i];
      int k = arrayOfByte[(i + 1)];
      int m = arrayOfByte[(i + 2)];
      return (arrayOfByte[(i + 3)] & 0xFF) << 24 | j & 0xFF | (k & 0xFF) << 8 | (m & 0xFF) << 16;
    }
    throw zzih.zza();
  }
  
  private final long zzy()
    throws IOException
  {
    int i = this.zzh;
    if (this.zzf - i >= 8)
    {
      byte[] arrayOfByte = this.zzd;
      this.zzh = (i + 8);
      long l1 = arrayOfByte[i];
      long l2 = arrayOfByte[(i + 1)];
      long l3 = arrayOfByte[(i + 2)];
      long l4 = arrayOfByte[(i + 3)];
      long l5 = arrayOfByte[(i + 4)];
      long l6 = arrayOfByte[(i + 5)];
      long l7 = arrayOfByte[(i + 6)];
      return (arrayOfByte[(i + 7)] & 0xFF) << 56 | l1 & 0xFF | (l2 & 0xFF) << 8 | (l3 & 0xFF) << 16 | (l4 & 0xFF) << 24 | (l5 & 0xFF) << 32 | (l6 & 0xFF) << 40 | (l7 & 0xFF) << 48;
    }
    throw zzih.zza();
  }
  
  private final void zzz()
  {
    int i = this.zzf + this.zzg;
    this.zzf = i;
    int j = i - this.zzi;
    int k = this.zzk;
    if (j > k)
    {
      j -= k;
      this.zzg = j;
      this.zzf = (i - j);
      return;
    }
    this.zzg = 0;
  }
  
  public final int zza()
    throws IOException
  {
    if (zzt())
    {
      this.zzj = 0;
      return 0;
    }
    int i = zzv();
    this.zzj = i;
    if (i >>> 3 != 0) {
      return i;
    }
    throw zzih.zzd();
  }
  
  public final void zza(int paramInt)
    throws zzih
  {
    if (this.zzj == paramInt) {
      return;
    }
    throw zzih.zze();
  }
  
  public final double zzb()
    throws IOException
  {
    return Double.longBitsToDouble(zzy());
  }
  
  public final boolean zzb(int paramInt)
    throws IOException
  {
    int k = paramInt & 0x7;
    int j = 0;
    int i = 0;
    if (k != 0)
    {
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 3)
          {
            if (k != 4)
            {
              if (k == 5)
              {
                zzf(4);
                return true;
              }
              throw zzih.zzf();
            }
            return false;
          }
          do
          {
            i = zza();
          } while ((i != 0) && (zzb(i)));
          zza(paramInt >>> 3 << 3 | 0x4);
          return true;
        }
        zzf(zzv());
        return true;
      }
      zzf(8);
      return true;
    }
    paramInt = j;
    if (this.zzf - this.zzh >= 10)
    {
      paramInt = i;
      while (paramInt < 10)
      {
        byte[] arrayOfByte = this.zzd;
        i = this.zzh;
        this.zzh = (i + 1);
        if (arrayOfByte[i] >= 0) {
          break label186;
        }
        paramInt += 1;
      }
      throw zzih.zzc();
    }
    for (;;)
    {
      if (paramInt >= 10) {
        break label188;
      }
      if (zzaa() >= 0) {
        break;
      }
      paramInt += 1;
    }
    label186:
    return true;
    label188:
    throw zzih.zzc();
  }
  
  public final float zzc()
    throws IOException
  {
    return Float.intBitsToFloat(zzx());
  }
  
  public final int zzc(int paramInt)
    throws zzih
  {
    if (paramInt >= 0)
    {
      paramInt += zzu();
      int i = this.zzk;
      if (paramInt <= i)
      {
        this.zzk = paramInt;
        zzz();
        return i;
      }
      throw zzih.zza();
    }
    throw zzih.zzb();
  }
  
  public final long zzd()
    throws IOException
  {
    return zzw();
  }
  
  public final void zzd(int paramInt)
  {
    this.zzk = paramInt;
    zzz();
  }
  
  public final long zze()
    throws IOException
  {
    return zzw();
  }
  
  public final int zzf()
    throws IOException
  {
    return zzv();
  }
  
  public final long zzg()
    throws IOException
  {
    return zzy();
  }
  
  public final int zzh()
    throws IOException
  {
    return zzx();
  }
  
  public final boolean zzi()
    throws IOException
  {
    return zzw() != 0L;
  }
  
  public final String zzj()
    throws IOException
  {
    int i = zzv();
    if ((i > 0) && (i <= this.zzf - this.zzh))
    {
      String str = new String(this.zzd, this.zzh, i, zzic.zza);
      this.zzh += i;
      return str;
    }
    if (i == 0) {
      return "";
    }
    if (i < 0) {
      throw zzih.zzb();
    }
    throw zzih.zza();
  }
  
  public final String zzk()
    throws IOException
  {
    int i = zzv();
    if (i > 0)
    {
      int j = this.zzf;
      int k = this.zzh;
      if (i <= j - k)
      {
        String str = zzla.zzb(this.zzd, k, i);
        this.zzh += i;
        return str;
      }
    }
    if (i == 0) {
      return "";
    }
    if (i <= 0) {
      throw zzih.zzb();
    }
    throw zzih.zza();
  }
  
  public final zzgr zzl()
    throws IOException
  {
    int i = zzv();
    int j;
    int k;
    Object localObject;
    if (i > 0)
    {
      j = this.zzf;
      k = this.zzh;
      if (i <= j - k)
      {
        localObject = zzgr.zza(this.zzd, k, i);
        this.zzh += i;
        return (zzgr)localObject;
      }
    }
    if (i == 0) {
      return zzgr.zza;
    }
    if (i > 0)
    {
      k = this.zzf;
      j = this.zzh;
      if (i <= k - j)
      {
        i += j;
        this.zzh = i;
        localObject = Arrays.copyOfRange(this.zzd, j, i);
        break label115;
      }
    }
    if (i <= 0)
    {
      if (i == 0)
      {
        localObject = zzic.zzb;
        label115:
        return zzgr.zza((byte[])localObject);
      }
      throw zzih.zzb();
    }
    throw zzih.zza();
  }
  
  public final int zzm()
    throws IOException
  {
    return zzv();
  }
  
  public final int zzn()
    throws IOException
  {
    return zzv();
  }
  
  public final int zzo()
    throws IOException
  {
    return zzx();
  }
  
  public final long zzp()
    throws IOException
  {
    return zzy();
  }
  
  public final int zzq()
    throws IOException
  {
    return zze(zzv());
  }
  
  public final long zzr()
    throws IOException
  {
    return zza(zzw());
  }
  
  final long zzs()
    throws IOException
  {
    long l = 0L;
    int i = 0;
    while (i < 64)
    {
      int j = zzaa();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    throw zzih.zzc();
  }
  
  public final boolean zzt()
    throws IOException
  {
    return this.zzh == this.zzf;
  }
  
  public final int zzu()
  {
    return this.zzh - this.zzi;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzhf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */