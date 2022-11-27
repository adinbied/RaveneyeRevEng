package com.google.android.gms.internal.measurement;

import java.io.IOException;

final class zzgn
{
  static int zza(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, zzgm paramzzgm)
    throws zzih
  {
    if (paramInt1 >>> 3 != 0)
    {
      int i = paramInt1 & 0x7;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i == 5) {
                return paramInt2 + 4;
              }
              throw zzih.zzd();
            }
            int k = paramInt1 & 0xFFFFFFF8 | 0x4;
            paramInt1 = 0;
            int j;
            for (;;)
            {
              i = paramInt1;
              j = paramInt2;
              if (paramInt2 >= paramInt3) {
                break;
              }
              paramInt2 = zza(paramArrayOfByte, paramInt2, paramzzgm);
              paramInt1 = paramzzgm.zza;
              i = paramInt1;
              j = paramInt2;
              if (paramInt1 == k) {
                break;
              }
              paramInt2 = zza(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramzzgm);
            }
            if ((j <= paramInt3) && (i == k)) {
              return j;
            }
            throw zzih.zzg();
          }
          return zza(paramArrayOfByte, paramInt2, paramzzgm) + paramzzgm.zza;
        }
        return paramInt2 + 8;
      }
      return zzb(paramArrayOfByte, paramInt2, paramzzgm);
    }
    throw zzih.zzd();
  }
  
  static int zza(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, zzii<?> paramzzii, zzgm paramzzgm)
  {
    paramzzii = (zzia)paramzzii;
    paramInt2 = zza(paramArrayOfByte, paramInt2, paramzzgm);
    paramzzii.zzd(paramzzgm.zza);
    while (paramInt2 < paramInt3)
    {
      int i = zza(paramArrayOfByte, paramInt2, paramzzgm);
      if (paramInt1 != paramzzgm.zza) {
        break;
      }
      paramInt2 = zza(paramArrayOfByte, i, paramzzgm);
      paramzzii.zzd(paramzzgm.zza);
    }
    return paramInt2;
  }
  
  static int zza(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, zzku paramzzku, zzgm paramzzgm)
    throws zzih
  {
    if (paramInt1 >>> 3 != 0)
    {
      int i = paramInt1 & 0x7;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i == 5)
              {
                paramzzku.zza(paramInt1, Integer.valueOf(zza(paramArrayOfByte, paramInt2)));
                return paramInt2 + 4;
              }
              throw zzih.zzd();
            }
            zzku localzzku = zzku.zzb();
            int k = paramInt1 & 0xFFFFFFF8 | 0x4;
            i = 0;
            for (;;)
            {
              j = i;
              i = paramInt2;
              if (paramInt2 >= paramInt3) {
                break label140;
              }
              j = zza(paramArrayOfByte, paramInt2, paramzzgm);
              i = paramzzgm.zza;
              paramInt2 = i;
              if (i == k) {
                break;
              }
              paramInt2 = zza(paramInt2, paramArrayOfByte, j, paramInt3, localzzku, paramzzgm);
            }
            i = j;
            int j = paramInt2;
            label140:
            if ((i <= paramInt3) && (j == k))
            {
              paramzzku.zza(paramInt1, localzzku);
              return i;
            }
            throw zzih.zzg();
          }
          paramInt2 = zza(paramArrayOfByte, paramInt2, paramzzgm);
          paramInt3 = paramzzgm.zza;
          if (paramInt3 >= 0)
          {
            if (paramInt3 <= paramArrayOfByte.length - paramInt2)
            {
              if (paramInt3 == 0) {
                paramzzku.zza(paramInt1, zzgr.zza);
              } else {
                paramzzku.zza(paramInt1, zzgr.zza(paramArrayOfByte, paramInt2, paramInt3));
              }
              return paramInt2 + paramInt3;
            }
            throw zzih.zza();
          }
          throw zzih.zzb();
        }
        paramzzku.zza(paramInt1, Long.valueOf(zzb(paramArrayOfByte, paramInt2)));
        return paramInt2 + 8;
      }
      paramInt2 = zzb(paramArrayOfByte, paramInt2, paramzzgm);
      paramzzku.zza(paramInt1, Long.valueOf(paramzzgm.zzb));
      return paramInt2;
    }
    throw zzih.zzd();
  }
  
  static int zza(int paramInt1, byte[] paramArrayOfByte, int paramInt2, zzgm paramzzgm)
  {
    int i = paramInt1 & 0x7F;
    paramInt1 = paramInt2 + 1;
    paramInt2 = paramArrayOfByte[paramInt2];
    if (paramInt2 >= 0)
    {
      paramzzgm.zza = (i | paramInt2 << 7);
      return paramInt1;
    }
    i |= (paramInt2 & 0x7F) << 7;
    paramInt2 = paramInt1 + 1;
    paramInt1 = paramArrayOfByte[paramInt1];
    if (paramInt1 >= 0)
    {
      paramzzgm.zza = (i | paramInt1 << 14);
      return paramInt2;
    }
    paramInt1 = i | (paramInt1 & 0x7F) << 14;
    int j = paramInt2 + 1;
    paramInt2 = paramArrayOfByte[paramInt2];
    if (paramInt2 >= 0)
    {
      paramzzgm.zza = (paramInt1 | paramInt2 << 21);
      return j;
    }
    i = paramInt1 | (paramInt2 & 0x7F) << 21;
    paramInt1 = j + 1;
    j = paramArrayOfByte[j];
    if (j >= 0)
    {
      paramzzgm.zza = (i | j << 28);
      return paramInt1;
    }
    for (;;)
    {
      paramInt2 = paramInt1 + 1;
      if (paramArrayOfByte[paramInt1] >= 0)
      {
        paramzzgm.zza = (i | (j & 0x7F) << 28);
        return paramInt2;
      }
      paramInt1 = paramInt2;
    }
  }
  
  static int zza(zzjz<?> paramzzjz, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, zzii<?> paramzzii, zzgm paramzzgm)
    throws IOException
  {
    paramInt2 = zza(paramzzjz, paramArrayOfByte, paramInt2, paramInt3, paramzzgm);
    paramzzii.add(paramzzgm.zzc);
    while (paramInt2 < paramInt3)
    {
      int i = zza(paramArrayOfByte, paramInt2, paramzzgm);
      if (paramInt1 != paramzzgm.zza) {
        break;
      }
      paramInt2 = zza(paramzzjz, paramArrayOfByte, i, paramInt3, paramzzgm);
      paramzzii.add(paramzzgm.zzc);
    }
    return paramInt2;
  }
  
  static int zza(zzjz paramzzjz, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, zzgm paramzzgm)
    throws IOException
  {
    paramzzjz = (zzjl)paramzzjz;
    Object localObject = paramzzjz.zza();
    paramInt1 = paramzzjz.zza(localObject, paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramzzgm);
    paramzzjz.zzc(localObject);
    paramzzgm.zzc = localObject;
    return paramInt1;
  }
  
  static int zza(zzjz paramzzjz, byte[] paramArrayOfByte, int paramInt1, int paramInt2, zzgm paramzzgm)
    throws IOException
  {
    int j = paramInt1 + 1;
    int k = paramArrayOfByte[paramInt1];
    paramInt1 = j;
    int i = k;
    if (k < 0)
    {
      paramInt1 = zza(k, paramArrayOfByte, j, paramzzgm);
      i = paramzzgm.zza;
    }
    if ((i >= 0) && (i <= paramInt2 - paramInt1))
    {
      Object localObject = paramzzjz.zza();
      paramInt2 = i + paramInt1;
      paramzzjz.zza(localObject, paramArrayOfByte, paramInt1, paramInt2, paramzzgm);
      paramzzjz.zzc(localObject);
      paramzzgm.zzc = localObject;
      return paramInt2;
    }
    throw zzih.zza();
  }
  
  static int zza(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    int j = paramArrayOfByte[(paramInt + 1)];
    int k = paramArrayOfByte[(paramInt + 2)];
    return (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
  }
  
  static int zza(byte[] paramArrayOfByte, int paramInt, zzgm paramzzgm)
  {
    int i = paramInt + 1;
    paramInt = paramArrayOfByte[paramInt];
    if (paramInt >= 0)
    {
      paramzzgm.zza = paramInt;
      return i;
    }
    return zza(paramInt, paramArrayOfByte, i, paramzzgm);
  }
  
  static int zza(byte[] paramArrayOfByte, int paramInt, zzii<?> paramzzii, zzgm paramzzgm)
    throws IOException
  {
    paramzzii = (zzia)paramzzii;
    paramInt = zza(paramArrayOfByte, paramInt, paramzzgm);
    int i = paramzzgm.zza + paramInt;
    while (paramInt < i)
    {
      paramInt = zza(paramArrayOfByte, paramInt, paramzzgm);
      paramzzii.zzd(paramzzgm.zza);
    }
    if (paramInt == i) {
      return paramInt;
    }
    throw zzih.zza();
  }
  
  static int zzb(byte[] paramArrayOfByte, int paramInt, zzgm paramzzgm)
  {
    int i = paramInt + 1;
    long l = paramArrayOfByte[paramInt];
    if (l >= 0L)
    {
      paramzzgm.zzb = l;
      return i;
    }
    paramInt = i + 1;
    int j = paramArrayOfByte[i];
    l = l & 0x7F | (j & 0x7F) << 7;
    i = 7;
    while (j < 0)
    {
      j = paramArrayOfByte[paramInt];
      i += 7;
      l |= (j & 0x7F) << i;
      paramInt += 1;
    }
    paramzzgm.zzb = l;
    return paramInt;
  }
  
  static long zzb(byte[] paramArrayOfByte, int paramInt)
  {
    long l1 = paramArrayOfByte[paramInt];
    long l2 = paramArrayOfByte[(paramInt + 1)];
    long l3 = paramArrayOfByte[(paramInt + 2)];
    long l4 = paramArrayOfByte[(paramInt + 3)];
    long l5 = paramArrayOfByte[(paramInt + 4)];
    long l6 = paramArrayOfByte[(paramInt + 5)];
    long l7 = paramArrayOfByte[(paramInt + 6)];
    return (paramArrayOfByte[(paramInt + 7)] & 0xFF) << 56 | l1 & 0xFF | (l2 & 0xFF) << 8 | (l3 & 0xFF) << 16 | (l4 & 0xFF) << 24 | (l5 & 0xFF) << 32 | (l6 & 0xFF) << 40 | (l7 & 0xFF) << 48;
  }
  
  static double zzc(byte[] paramArrayOfByte, int paramInt)
  {
    return Double.longBitsToDouble(zzb(paramArrayOfByte, paramInt));
  }
  
  static int zzc(byte[] paramArrayOfByte, int paramInt, zzgm paramzzgm)
    throws zzih
  {
    paramInt = zza(paramArrayOfByte, paramInt, paramzzgm);
    int i = paramzzgm.zza;
    if (i >= 0)
    {
      if (i == 0)
      {
        paramzzgm.zzc = "";
        return paramInt;
      }
      paramzzgm.zzc = new String(paramArrayOfByte, paramInt, i, zzic.zza);
      return paramInt + i;
    }
    throw zzih.zzb();
  }
  
  static float zzd(byte[] paramArrayOfByte, int paramInt)
  {
    return Float.intBitsToFloat(zza(paramArrayOfByte, paramInt));
  }
  
  static int zzd(byte[] paramArrayOfByte, int paramInt, zzgm paramzzgm)
    throws zzih
  {
    paramInt = zza(paramArrayOfByte, paramInt, paramzzgm);
    int i = paramzzgm.zza;
    if (i >= 0)
    {
      if (i == 0)
      {
        paramzzgm.zzc = "";
        return paramInt;
      }
      paramzzgm.zzc = zzla.zzb(paramArrayOfByte, paramInt, i);
      return paramInt + i;
    }
    throw zzih.zzb();
  }
  
  static int zze(byte[] paramArrayOfByte, int paramInt, zzgm paramzzgm)
    throws zzih
  {
    paramInt = zza(paramArrayOfByte, paramInt, paramzzgm);
    int i = paramzzgm.zza;
    if (i >= 0)
    {
      if (i <= paramArrayOfByte.length - paramInt)
      {
        if (i == 0)
        {
          paramzzgm.zzc = zzgr.zza;
          return paramInt;
        }
        paramzzgm.zzc = zzgr.zza(paramArrayOfByte, paramInt, i);
        return paramInt + i;
      }
      throw zzih.zza();
    }
    throw zzih.zzb();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzgn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */