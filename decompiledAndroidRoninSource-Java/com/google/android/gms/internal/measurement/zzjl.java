package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import sun.misc.Unsafe;

final class zzjl<T>
  implements zzjz<T>
{
  private static final int[] zza = new int[0];
  private static final Unsafe zzb = zzkx.zzc();
  private final int[] zzc;
  private final Object[] zzd;
  private final int zze;
  private final int zzf;
  private final zzjh zzg;
  private final boolean zzh;
  private final boolean zzi;
  private final boolean zzj;
  private final boolean zzk;
  private final int[] zzl;
  private final int zzm;
  private final int zzn;
  private final zzjp zzo;
  private final zzir zzp;
  private final zzkr<?, ?> zzq;
  private final zzho<?> zzr;
  private final zzje zzs;
  
  private zzjl(int[] paramArrayOfInt1, Object[] paramArrayOfObject, int paramInt1, int paramInt2, zzjh paramzzjh, boolean paramBoolean1, boolean paramBoolean2, int[] paramArrayOfInt2, int paramInt3, int paramInt4, zzjp paramzzjp, zzir paramzzir, zzkr<?, ?> paramzzkr, zzho<?> paramzzho, zzje paramzzje)
  {
    this.zzc = paramArrayOfInt1;
    this.zzd = paramArrayOfObject;
    this.zze = paramInt1;
    this.zzf = paramInt2;
    this.zzi = (paramzzjh instanceof zzhz);
    this.zzj = paramBoolean1;
    if ((paramzzho != null) && (paramzzho.zza(paramzzjh))) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    this.zzh = paramBoolean1;
    this.zzk = false;
    this.zzl = paramArrayOfInt2;
    this.zzm = paramInt3;
    this.zzn = paramInt4;
    this.zzo = paramzzjp;
    this.zzp = paramzzir;
    this.zzq = paramzzkr;
    this.zzr = paramzzho;
    this.zzg = paramzzjh;
    this.zzs = paramzzje;
  }
  
  private final int zza(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= this.zze) && (paramInt1 <= this.zzf)) {
      return zzb(paramInt1, paramInt2);
    }
    return -1;
  }
  
  private static <UT, UB> int zza(zzkr<UT, UB> paramzzkr, T paramT)
  {
    return paramzzkr.zzf(paramzzkr.zzb(paramT));
  }
  
  private final int zza(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong, int paramInt8, zzgm paramzzgm)
    throws IOException
  {
    Unsafe localUnsafe = zzb;
    long l = this.zzc[(paramInt8 + 2)] & 0xFFFFF;
    switch (paramInt7)
    {
    default: 
      break;
    case 68: 
      if (paramInt5 != 3) {
        return paramInt1;
      }
      paramInt1 = zzgn.zza(zza(paramInt8), paramArrayOfByte, paramInt1, paramInt2, paramInt3 & 0xFFFFFFF8 | 0x4, paramzzgm);
      if (localUnsafe.getInt(paramT, l) == paramInt4) {
        paramArrayOfByte = localUnsafe.getObject(paramT, paramLong);
      } else {
        paramArrayOfByte = null;
      }
      if (paramArrayOfByte == null) {
        localUnsafe.putObject(paramT, paramLong, paramzzgm.zzc);
      } else {
        localUnsafe.putObject(paramT, paramLong, zzic.zza(paramArrayOfByte, paramzzgm.zzc));
      }
      break;
    case 67: 
      if (paramInt5 != 0) {
        return paramInt1;
      }
      paramInt1 = zzgn.zzb(paramArrayOfByte, paramInt1, paramzzgm);
      localUnsafe.putObject(paramT, paramLong, Long.valueOf(zzhd.zza(paramzzgm.zzb)));
      break;
    case 66: 
      if (paramInt5 != 0) {
        return paramInt1;
      }
      paramInt1 = zzgn.zza(paramArrayOfByte, paramInt1, paramzzgm);
      localUnsafe.putObject(paramT, paramLong, Integer.valueOf(zzhd.zze(paramzzgm.zza)));
      break;
    case 63: 
      if (paramInt5 != 0) {
        return paramInt1;
      }
      paramInt1 = zzgn.zza(paramArrayOfByte, paramInt1, paramzzgm);
      paramInt2 = paramzzgm.zza;
      paramArrayOfByte = zzc(paramInt8);
      if ((paramArrayOfByte != null) && (!paramArrayOfByte.zza(paramInt2)))
      {
        zze(paramT).zza(paramInt3, Long.valueOf(paramInt2));
        return paramInt1;
      }
      localUnsafe.putObject(paramT, paramLong, Integer.valueOf(paramInt2));
      break;
    case 61: 
      if (paramInt5 != 2) {
        return paramInt1;
      }
      paramInt1 = zzgn.zze(paramArrayOfByte, paramInt1, paramzzgm);
      localUnsafe.putObject(paramT, paramLong, paramzzgm.zzc);
      break;
    case 60: 
      if (paramInt5 != 2) {
        return paramInt1;
      }
      paramInt1 = zzgn.zza(zza(paramInt8), paramArrayOfByte, paramInt1, paramInt2, paramzzgm);
      if (localUnsafe.getInt(paramT, l) == paramInt4) {
        paramArrayOfByte = localUnsafe.getObject(paramT, paramLong);
      } else {
        paramArrayOfByte = null;
      }
      if (paramArrayOfByte == null) {
        localUnsafe.putObject(paramT, paramLong, paramzzgm.zzc);
      } else {
        localUnsafe.putObject(paramT, paramLong, zzic.zza(paramArrayOfByte, paramzzgm.zzc));
      }
      localUnsafe.putInt(paramT, l, paramInt4);
      return paramInt1;
    case 59: 
      if (paramInt5 != 2) {
        return paramInt1;
      }
      paramInt1 = zzgn.zza(paramArrayOfByte, paramInt1, paramzzgm);
      paramInt2 = paramzzgm.zza;
      if (paramInt2 == 0)
      {
        localUnsafe.putObject(paramT, paramLong, "");
      }
      else
      {
        if (((paramInt6 & 0x20000000) != 0) && (!zzla.zza(paramArrayOfByte, paramInt1, paramInt1 + paramInt2))) {
          throw zzih.zzh();
        }
        localUnsafe.putObject(paramT, paramLong, new String(paramArrayOfByte, paramInt1, paramInt2, zzic.zza));
        paramInt1 += paramInt2;
      }
      localUnsafe.putInt(paramT, l, paramInt4);
      return paramInt1;
    case 58: 
      if (paramInt5 != 0) {
        return paramInt1;
      }
      paramInt1 = zzgn.zzb(paramArrayOfByte, paramInt1, paramzzgm);
      boolean bool;
      if (paramzzgm.zzb != 0L) {
        bool = true;
      } else {
        bool = false;
      }
      localUnsafe.putObject(paramT, paramLong, Boolean.valueOf(bool));
      break;
    case 57: 
    case 64: 
      if (paramInt5 != 5) {
        return paramInt1;
      }
      localUnsafe.putObject(paramT, paramLong, Integer.valueOf(zzgn.zza(paramArrayOfByte, paramInt1)));
      break;
    case 56: 
    case 65: 
      if (paramInt5 != 1) {
        return paramInt1;
      }
      localUnsafe.putObject(paramT, paramLong, Long.valueOf(zzgn.zzb(paramArrayOfByte, paramInt1)));
      break;
    case 55: 
    case 62: 
      if (paramInt5 != 0) {
        return paramInt1;
      }
      paramInt1 = zzgn.zza(paramArrayOfByte, paramInt1, paramzzgm);
      localUnsafe.putObject(paramT, paramLong, Integer.valueOf(paramzzgm.zza));
      break;
    case 53: 
    case 54: 
      if (paramInt5 != 0) {
        return paramInt1;
      }
      paramInt1 = zzgn.zzb(paramArrayOfByte, paramInt1, paramzzgm);
      localUnsafe.putObject(paramT, paramLong, Long.valueOf(paramzzgm.zzb));
      break;
    case 52: 
      if (paramInt5 != 5) {
        return paramInt1;
      }
      localUnsafe.putObject(paramT, paramLong, Float.valueOf(zzgn.zzd(paramArrayOfByte, paramInt1)));
      paramInt1 += 4;
      break;
    }
    if (paramInt5 == 1)
    {
      localUnsafe.putObject(paramT, paramLong, Double.valueOf(zzgn.zzc(paramArrayOfByte, paramInt1)));
      paramInt1 += 8;
      localUnsafe.putInt(paramT, l, paramInt4);
      return paramInt1;
    }
    return paramInt1;
  }
  
  private final int zza(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, int paramInt7, long paramLong2, zzgm paramzzgm)
    throws IOException
  {
    int i = paramInt1;
    zzii localzzii2 = (zzii)zzb.getObject(paramT, paramLong2);
    zzii localzzii1 = localzzii2;
    if (!localzzii2.zza())
    {
      int j = localzzii2.size();
      if (j == 0) {
        j = 10;
      } else {
        j <<= 1;
      }
      localzzii1 = localzzii2.zza(j);
      zzb.putObject(paramT, paramLong2, localzzii1);
    }
    switch (paramInt7)
    {
    default: 
      paramInt7 = i;
      break;
    case 49: 
      paramInt7 = i;
      if (paramInt5 != 3) {
        break label2375;
      }
      paramT = zza(paramInt6);
      paramInt4 = paramInt3 & 0xFFFFFFF8 | 0x4;
      paramInt1 = zzgn.zza(paramT, paramArrayOfByte, paramInt1, paramInt2, paramInt4, paramzzgm);
      localzzii1.add(paramzzgm.zzc);
      for (;;)
      {
        paramInt7 = paramInt1;
        if (paramInt1 >= paramInt2) {
          break;
        }
        paramInt5 = zzgn.zza(paramArrayOfByte, paramInt1, paramzzgm);
        paramInt7 = paramInt1;
        if (paramInt3 != paramzzgm.zza) {
          break;
        }
        paramInt1 = zzgn.zza(paramT, paramArrayOfByte, paramInt5, paramInt2, paramInt4, paramzzgm);
        localzzii1.add(paramzzgm.zzc);
      }
    case 34: 
    case 48: 
      if (paramInt5 == 2)
      {
        paramT = (zziv)localzzii1;
        paramInt1 = zzgn.zza(paramArrayOfByte, i, paramzzgm);
        paramInt2 = paramzzgm.zza + paramInt1;
        while (paramInt1 < paramInt2)
        {
          paramInt1 = zzgn.zzb(paramArrayOfByte, paramInt1, paramzzgm);
          paramT.zza(zzhd.zza(paramzzgm.zzb));
        }
        if (paramInt1 == paramInt2) {
          return paramInt1;
        }
        throw zzih.zza();
      }
      paramInt7 = i;
      if (paramInt5 != 0) {
        break label2375;
      }
      paramT = (zziv)localzzii1;
      paramInt4 = zzgn.zzb(paramArrayOfByte, i, paramzzgm);
      paramT.zza(zzhd.zza(paramzzgm.zzb));
      for (;;)
      {
        paramInt1 = paramInt4;
        if (paramInt4 >= paramInt2) {
          break;
        }
        paramInt5 = zzgn.zza(paramArrayOfByte, paramInt4, paramzzgm);
        paramInt1 = paramInt4;
        if (paramInt3 != paramzzgm.zza) {
          break;
        }
        paramInt4 = zzgn.zzb(paramArrayOfByte, paramInt5, paramzzgm);
        paramT.zza(zzhd.zza(paramzzgm.zzb));
      }
    case 33: 
    case 47: 
      if (paramInt5 == 2)
      {
        paramT = (zzia)localzzii1;
        paramInt1 = zzgn.zza(paramArrayOfByte, i, paramzzgm);
        paramInt2 = paramzzgm.zza + paramInt1;
        while (paramInt1 < paramInt2)
        {
          paramInt1 = zzgn.zza(paramArrayOfByte, paramInt1, paramzzgm);
          paramT.zzd(zzhd.zze(paramzzgm.zza));
        }
        if (paramInt1 == paramInt2) {
          return paramInt1;
        }
        throw zzih.zza();
      }
      paramInt7 = i;
      if (paramInt5 != 0) {
        break label2375;
      }
      paramT = (zzia)localzzii1;
      paramInt4 = zzgn.zza(paramArrayOfByte, i, paramzzgm);
      paramT.zzd(zzhd.zze(paramzzgm.zza));
      for (;;)
      {
        paramInt1 = paramInt4;
        if (paramInt4 >= paramInt2) {
          break;
        }
        paramInt5 = zzgn.zza(paramArrayOfByte, paramInt4, paramzzgm);
        paramInt1 = paramInt4;
        if (paramInt3 != paramzzgm.zza) {
          break;
        }
        paramInt4 = zzgn.zza(paramArrayOfByte, paramInt5, paramzzgm);
        paramT.zzd(zzhd.zze(paramzzgm.zza));
      }
    case 30: 
    case 44: 
      if (paramInt5 == 2)
      {
        paramInt1 = zzgn.zza(paramArrayOfByte, i, localzzii1, paramzzgm);
      }
      else
      {
        paramInt7 = i;
        if (paramInt5 != 0) {
          break label2375;
        }
        paramInt1 = zzgn.zza(paramInt3, paramArrayOfByte, paramInt1, paramInt2, localzzii1, paramzzgm);
      }
      paramzzgm = (zzhz)paramT;
      paramArrayOfByte = paramzzgm.zzb;
      paramT = paramArrayOfByte;
      if (paramArrayOfByte == zzku.zza()) {
        paramT = null;
      }
      paramT = (zzku)zzkb.zza(paramInt4, localzzii1, zzc(paramInt6), paramT, this.zzq);
      paramInt2 = paramInt1;
      if (paramT != null) {
        paramzzgm.zzb = paramT;
      }
    case 28: 
    case 27: 
    case 26: 
    case 25: 
    case 42: 
      boolean bool;
      for (paramInt2 = paramInt1;; paramInt2 = paramInt1)
      {
        return paramInt2;
        paramInt7 = i;
        if (paramInt5 != 2) {
          break label2375;
        }
        paramInt4 = zzgn.zza(paramArrayOfByte, i, paramzzgm);
        paramInt1 = paramzzgm.zza;
        if (paramInt1 >= 0)
        {
          if (paramInt1 <= paramArrayOfByte.length - paramInt4)
          {
            if (paramInt1 == 0) {
              localzzii1.add(zzgr.zza);
            } else {
              localzzii1.add(zzgr.zza(paramArrayOfByte, paramInt4, paramInt1));
            }
            for (;;)
            {
              paramInt4 += paramInt1;
              for (;;)
              {
                paramInt1 = paramInt4;
                if (paramInt4 >= paramInt2) {
                  return paramInt1;
                }
                paramInt5 = zzgn.zza(paramArrayOfByte, paramInt4, paramzzgm);
                paramInt1 = paramInt4;
                if (paramInt3 != paramzzgm.zza) {
                  return paramInt1;
                }
                paramInt4 = zzgn.zza(paramArrayOfByte, paramInt5, paramzzgm);
                paramInt1 = paramzzgm.zza;
                if (paramInt1 < 0) {
                  break label963;
                }
                if (paramInt1 > paramArrayOfByte.length - paramInt4) {
                  break label959;
                }
                if (paramInt1 != 0) {
                  break;
                }
                localzzii1.add(zzgr.zza);
              }
              localzzii1.add(zzgr.zza(paramArrayOfByte, paramInt4, paramInt1));
            }
            throw zzih.zza();
            throw zzih.zzb();
          }
          throw zzih.zza();
        }
        throw zzih.zzb();
        paramInt7 = i;
        if (paramInt5 != 2) {
          break label2375;
        }
        return zzgn.zza(zza(paramInt6), paramInt3, paramArrayOfByte, paramInt1, paramInt2, localzzii1, paramzzgm);
        paramInt7 = i;
        if (paramInt5 != 2) {
          break label2375;
        }
        if ((paramLong1 & 0x20000000) == 0L)
        {
          paramInt1 = zzgn.zza(paramArrayOfByte, i, paramzzgm);
          paramInt4 = paramzzgm.zza;
          if (paramInt4 >= 0)
          {
            if (paramInt4 == 0) {
              localzzii1.add("");
            } else {
              localzzii1.add(new String(paramArrayOfByte, paramInt1, paramInt4, zzic.zza));
            }
            for (;;)
            {
              paramInt1 += paramInt4;
              for (;;)
              {
                paramInt7 = paramInt1;
                if (paramInt1 >= paramInt2) {
                  break label2375;
                }
                paramInt4 = zzgn.zza(paramArrayOfByte, paramInt1, paramzzgm);
                paramInt7 = paramInt1;
                if (paramInt3 != paramzzgm.zza) {
                  break label2375;
                }
                paramInt1 = zzgn.zza(paramArrayOfByte, paramInt4, paramzzgm);
                paramInt4 = paramzzgm.zza;
                if (paramInt4 < 0) {
                  break label1187;
                }
                if (paramInt4 != 0) {
                  break;
                }
                localzzii1.add("");
              }
              localzzii1.add(new String(paramArrayOfByte, paramInt1, paramInt4, zzic.zza));
            }
            throw zzih.zzb();
          }
          throw zzih.zzb();
        }
        paramInt1 = zzgn.zza(paramArrayOfByte, i, paramzzgm);
        paramInt5 = paramzzgm.zza;
        if (paramInt5 >= 0)
        {
          if (paramInt5 == 0)
          {
            localzzii1.add("");
          }
          else
          {
            paramInt4 = paramInt1 + paramInt5;
            if (!zzla.zza(paramArrayOfByte, paramInt1, paramInt4)) {
              break label1397;
            }
            localzzii1.add(new String(paramArrayOfByte, paramInt1, paramInt5, zzic.zza));
            paramInt1 = paramInt4;
          }
          for (;;)
          {
            paramInt7 = paramInt1;
            if (paramInt1 >= paramInt2) {
              break label2375;
            }
            paramInt4 = zzgn.zza(paramArrayOfByte, paramInt1, paramzzgm);
            paramInt7 = paramInt1;
            if (paramInt3 != paramzzgm.zza) {
              break label2375;
            }
            paramInt1 = zzgn.zza(paramArrayOfByte, paramInt4, paramzzgm);
            paramInt5 = paramzzgm.zza;
            if (paramInt5 < 0) {
              break label1393;
            }
            if (paramInt5 == 0)
            {
              localzzii1.add("");
            }
            else
            {
              paramInt4 = paramInt1 + paramInt5;
              if (!zzla.zza(paramArrayOfByte, paramInt1, paramInt4)) {
                break;
              }
              localzzii1.add(new String(paramArrayOfByte, paramInt1, paramInt5, zzic.zza));
              paramInt1 = paramInt4;
            }
          }
          throw zzih.zzh();
          throw zzih.zzb();
          throw zzih.zzh();
        }
        throw zzih.zzb();
        if (paramInt5 != 2) {
          break label1493;
        }
        paramT = (zzgp)localzzii1;
        paramInt1 = zzgn.zza(paramArrayOfByte, i, paramzzgm);
        paramInt2 = paramzzgm.zza + paramInt1;
        while (paramInt1 < paramInt2)
        {
          paramInt1 = zzgn.zzb(paramArrayOfByte, paramInt1, paramzzgm);
          if (paramzzgm.zzb != 0L) {
            bool = true;
          } else {
            bool = false;
          }
          paramT.zza(bool);
        }
        if (paramInt1 != paramInt2) {
          break;
        }
      }
      throw zzih.zza();
      paramInt7 = i;
      if (paramInt5 != 0) {
        break label2375;
      }
      paramT = (zzgp)localzzii1;
      paramInt1 = zzgn.zzb(paramArrayOfByte, i, paramzzgm);
      if (paramzzgm.zzb != 0L) {
        bool = true;
      } else {
        bool = false;
      }
      paramT.zza(bool);
      for (;;)
      {
        paramInt7 = paramInt1;
        if (paramInt1 >= paramInt2) {
          break;
        }
        paramInt4 = zzgn.zza(paramArrayOfByte, paramInt1, paramzzgm);
        paramInt7 = paramInt1;
        if (paramInt3 != paramzzgm.zza) {
          break;
        }
        paramInt1 = zzgn.zzb(paramArrayOfByte, paramInt4, paramzzgm);
        if (paramzzgm.zzb != 0L) {
          bool = true;
        } else {
          bool = false;
        }
        paramT.zza(bool);
      }
    case 24: 
    case 31: 
    case 41: 
    case 45: 
      if (paramInt5 == 2)
      {
        paramT = (zzia)localzzii1;
        paramInt1 = zzgn.zza(paramArrayOfByte, i, paramzzgm);
        paramInt2 = paramzzgm.zza + paramInt1;
        while (paramInt1 < paramInt2)
        {
          paramT.zzd(zzgn.zza(paramArrayOfByte, paramInt1));
          paramInt1 += 4;
        }
        if (paramInt1 == paramInt2) {
          return paramInt1;
        }
        throw zzih.zza();
      }
      paramInt7 = i;
      if (paramInt5 != 5) {
        break label2375;
      }
      paramT = (zzia)localzzii1;
      paramT.zzd(zzgn.zza(paramArrayOfByte, paramInt1));
      for (;;)
      {
        paramInt4 = i + 4;
        paramInt1 = paramInt4;
        if (paramInt4 >= paramInt2) {
          break;
        }
        i = zzgn.zza(paramArrayOfByte, paramInt4, paramzzgm);
        paramInt1 = paramInt4;
        if (paramInt3 != paramzzgm.zza) {
          break;
        }
        paramT.zzd(zzgn.zza(paramArrayOfByte, i));
      }
    case 23: 
    case 32: 
    case 40: 
    case 46: 
      if (paramInt5 == 2)
      {
        paramT = (zziv)localzzii1;
        paramInt1 = zzgn.zza(paramArrayOfByte, i, paramzzgm);
        paramInt2 = paramzzgm.zza + paramInt1;
        while (paramInt1 < paramInt2)
        {
          paramT.zza(zzgn.zzb(paramArrayOfByte, paramInt1));
          paramInt1 += 8;
        }
        if (paramInt1 == paramInt2) {
          return paramInt1;
        }
        throw zzih.zza();
      }
      paramInt7 = i;
      if (paramInt5 != 1) {
        break label2375;
      }
      paramT = (zziv)localzzii1;
      paramT.zza(zzgn.zzb(paramArrayOfByte, paramInt1));
      for (;;)
      {
        paramInt4 = i + 8;
        paramInt1 = paramInt4;
        if (paramInt4 >= paramInt2) {
          break;
        }
        i = zzgn.zza(paramArrayOfByte, paramInt4, paramzzgm);
        paramInt1 = paramInt4;
        if (paramInt3 != paramzzgm.zza) {
          break;
        }
        paramT.zza(zzgn.zzb(paramArrayOfByte, i));
      }
    case 22: 
    case 29: 
    case 39: 
    case 43: 
      if (paramInt5 == 2) {
        return zzgn.zza(paramArrayOfByte, i, localzzii1, paramzzgm);
      }
      paramInt7 = i;
      if (paramInt5 != 0) {
        break label2375;
      }
      return zzgn.zza(paramInt3, paramArrayOfByte, paramInt1, paramInt2, localzzii1, paramzzgm);
    case 20: 
    case 21: 
    case 37: 
    case 38: 
      if (paramInt5 == 2)
      {
        paramT = (zziv)localzzii1;
        paramInt1 = zzgn.zza(paramArrayOfByte, i, paramzzgm);
        paramInt2 = paramzzgm.zza + paramInt1;
        while (paramInt1 < paramInt2)
        {
          paramInt1 = zzgn.zzb(paramArrayOfByte, paramInt1, paramzzgm);
          paramT.zza(paramzzgm.zzb);
        }
        if (paramInt1 == paramInt2) {
          return paramInt1;
        }
        throw zzih.zza();
      }
      paramInt7 = i;
      if (paramInt5 != 0) {
        break label2375;
      }
      paramT = (zziv)localzzii1;
      paramInt4 = zzgn.zzb(paramArrayOfByte, i, paramzzgm);
      paramT.zza(paramzzgm.zzb);
      for (;;)
      {
        paramInt1 = paramInt4;
        if (paramInt4 >= paramInt2) {
          break;
        }
        paramInt5 = zzgn.zza(paramArrayOfByte, paramInt4, paramzzgm);
        paramInt1 = paramInt4;
        if (paramInt3 != paramzzgm.zza) {
          break;
        }
        paramInt4 = zzgn.zzb(paramArrayOfByte, paramInt5, paramzzgm);
        paramT.zza(paramzzgm.zzb);
      }
    case 19: 
    case 36: 
      label959:
      label963:
      label1187:
      label1393:
      label1397:
      label1493:
      if (paramInt5 == 2)
      {
        paramT = (zzhv)localzzii1;
        paramInt1 = zzgn.zza(paramArrayOfByte, i, paramzzgm);
        paramInt2 = paramzzgm.zza + paramInt1;
        while (paramInt1 < paramInt2)
        {
          paramT.zza(zzgn.zzd(paramArrayOfByte, paramInt1));
          paramInt1 += 4;
        }
        if (paramInt1 == paramInt2) {
          return paramInt1;
        }
        throw zzih.zza();
      }
      paramInt7 = i;
      if (paramInt5 != 5) {
        break label2375;
      }
      paramT = (zzhv)localzzii1;
      paramT.zza(zzgn.zzd(paramArrayOfByte, paramInt1));
      for (;;)
      {
        paramInt4 = i + 4;
        paramInt1 = paramInt4;
        if (paramInt4 >= paramInt2) {
          break;
        }
        i = zzgn.zza(paramArrayOfByte, paramInt4, paramzzgm);
        paramInt1 = paramInt4;
        if (paramInt3 != paramzzgm.zza) {
          break;
        }
        paramT.zza(zzgn.zzd(paramArrayOfByte, i));
      }
    }
    if (paramInt5 == 2)
    {
      paramT = (zzhl)localzzii1;
      paramInt1 = zzgn.zza(paramArrayOfByte, i, paramzzgm);
      paramInt2 = paramzzgm.zza + paramInt1;
      while (paramInt1 < paramInt2)
      {
        paramT.zza(zzgn.zzc(paramArrayOfByte, paramInt1));
        paramInt1 += 8;
      }
      if (paramInt1 == paramInt2) {
        return paramInt1;
      }
      throw zzih.zza();
    }
    paramInt7 = i;
    if (paramInt5 == 1)
    {
      paramT = (zzhl)localzzii1;
      paramT.zza(zzgn.zzc(paramArrayOfByte, paramInt1));
      for (;;)
      {
        paramInt4 = i + 8;
        paramInt1 = paramInt4;
        if (paramInt4 >= paramInt2) {
          break;
        }
        i = zzgn.zza(paramArrayOfByte, paramInt4, paramzzgm);
        paramInt1 = paramInt4;
        if (paramInt3 != paramzzgm.zza) {
          break;
        }
        paramT.zza(zzgn.zzc(paramArrayOfByte, i));
      }
    }
    label2375:
    paramInt1 = paramInt7;
    return paramInt1;
  }
  
  private final <K, V> int zza(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong, zzgm paramzzgm)
    throws IOException
  {
    Unsafe localUnsafe = zzb;
    Object localObject3 = zzb(paramInt3);
    Object localObject2 = localUnsafe.getObject(paramT, paramLong);
    Object localObject1 = localObject2;
    if (this.zzs.zzd(localObject2))
    {
      localObject1 = this.zzs.zzf(localObject3);
      this.zzs.zza(localObject1, localObject2);
      localUnsafe.putObject(paramT, paramLong, localObject1);
    }
    localObject2 = this.zzs.zzb(localObject3);
    localObject3 = this.zzs.zza(localObject1);
    paramInt1 = zzgn.zza(paramArrayOfByte, paramInt1, paramzzgm);
    paramInt3 = paramzzgm.zza;
    if ((paramInt3 >= 0) && (paramInt3 <= paramInt2 - paramInt1))
    {
      int k = paramInt3 + paramInt1;
      paramT = ((zzjc)localObject2).zzb;
      localObject1 = ((zzjc)localObject2).zzd;
      while (paramInt1 < k)
      {
        int i = paramInt1 + 1;
        int j = paramArrayOfByte[paramInt1];
        paramInt3 = i;
        paramInt1 = j;
        if (j < 0)
        {
          paramInt3 = zzgn.zza(j, paramArrayOfByte, i, paramzzgm);
          paramInt1 = paramzzgm.zza;
        }
        i = paramInt1 >>> 3;
        j = paramInt1 & 0x7;
        if (i != 1)
        {
          if ((i == 2) && (j == ((zzjc)localObject2).zzc.zzb()))
          {
            paramInt1 = zza(paramArrayOfByte, paramInt3, paramInt2, ((zzjc)localObject2).zzc, ((zzjc)localObject2).zzd.getClass(), paramzzgm);
            localObject1 = paramzzgm.zzc;
          }
        }
        else if (j == ((zzjc)localObject2).zza.zzb())
        {
          paramInt1 = zza(paramArrayOfByte, paramInt3, paramInt2, ((zzjc)localObject2).zza, null, paramzzgm);
          paramT = paramzzgm.zzc;
          continue;
        }
        paramInt1 = zzgn.zza(paramInt1, paramArrayOfByte, paramInt3, paramInt2, paramzzgm);
      }
      if (paramInt1 == k)
      {
        ((Map)localObject3).put(paramT, localObject1);
        return k;
      }
      throw zzih.zzg();
    }
    throw zzih.zza();
  }
  
  private static int zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2, zzli paramzzli, Class<?> paramClass, zzgm paramzzgm)
    throws IOException
  {
    switch (zzjo.zza[paramzzli.ordinal()])
    {
    default: 
      throw new RuntimeException("unsupported field type.");
    case 17: 
      return zzgn.zzd(paramArrayOfByte, paramInt1, paramzzgm);
    case 16: 
      paramInt1 = zzgn.zzb(paramArrayOfByte, paramInt1, paramzzgm);
      paramzzgm.zzc = Long.valueOf(zzhd.zza(paramzzgm.zzb));
      return paramInt1;
    case 15: 
      paramInt1 = zzgn.zza(paramArrayOfByte, paramInt1, paramzzgm);
      paramzzgm.zzc = Integer.valueOf(zzhd.zze(paramzzgm.zza));
      return paramInt1;
    case 14: 
      return zzgn.zza(zzjv.zza().zza(paramClass), paramArrayOfByte, paramInt1, paramInt2, paramzzgm);
    case 12: 
    case 13: 
      paramInt1 = zzgn.zzb(paramArrayOfByte, paramInt1, paramzzgm);
      paramzzgm.zzc = Long.valueOf(paramzzgm.zzb);
      return paramInt1;
    case 9: 
    case 10: 
    case 11: 
      paramInt1 = zzgn.zza(paramArrayOfByte, paramInt1, paramzzgm);
      paramzzgm.zzc = Integer.valueOf(paramzzgm.zza);
      return paramInt1;
    case 8: 
      paramzzgm.zzc = Float.valueOf(zzgn.zzd(paramArrayOfByte, paramInt1));
      break;
    case 6: 
    case 7: 
      paramzzgm.zzc = Long.valueOf(zzgn.zzb(paramArrayOfByte, paramInt1));
      break;
    case 4: 
    case 5: 
      paramzzgm.zzc = Integer.valueOf(zzgn.zza(paramArrayOfByte, paramInt1));
      return paramInt1 + 4;
    case 3: 
      paramzzgm.zzc = Double.valueOf(zzgn.zzc(paramArrayOfByte, paramInt1));
      return paramInt1 + 8;
    case 2: 
      return zzgn.zze(paramArrayOfByte, paramInt1, paramzzgm);
    }
    paramInt1 = zzgn.zzb(paramArrayOfByte, paramInt1, paramzzgm);
    boolean bool;
    if (paramzzgm.zzb != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    paramzzgm.zzc = Boolean.valueOf(bool);
    return paramInt1;
  }
  
  static <T> zzjl<T> zza(Class<T> paramClass, zzjf paramzzjf, zzjp paramzzjp, zzir paramzzir, zzkr<?, ?> paramzzkr, zzho<?> paramzzho, zzje paramzzje)
  {
    if ((paramzzjf instanceof zzjx))
    {
      zzjx localzzjx = (zzjx)paramzzjf;
      i = localzzjx.zza();
      int j = zzjw.zzb;
      int n = 0;
      boolean bool;
      if (i == j) {
        bool = true;
      } else {
        bool = false;
      }
      paramzzjf = localzzjx.zzd();
      int i9 = paramzzjf.length();
      if (paramzzjf.charAt(0) >= 55296) {
        for (j = 1;; j = k)
        {
          k = j + 1;
          i = k;
          if (paramzzjf.charAt(j) < 55296) {
            break;
          }
        }
      }
      i = 1;
      j = i + 1;
      int m = paramzzjf.charAt(i);
      i = j;
      int k = m;
      if (m >= 55296)
      {
        k = m & 0x1FFF;
        i = 13;
        for (m = j;; m = j)
        {
          j = m + 1;
          m = paramzzjf.charAt(m);
          if (m < 55296) {
            break;
          }
          k |= (m & 0x1FFF) << i;
          i += 13;
        }
        k |= m << i;
        i = j;
      }
      int i2;
      if (k == 0)
      {
        paramClass = zza;
        m = 0;
        i3 = 0;
        i2 = 0;
        i1 = 0;
        i4 = 0;
        j = 0;
        k = n;
        n = i3;
      }
      else
      {
        j = i + 1;
        m = paramzzjf.charAt(i);
        i = m;
        k = j;
        if (m >= 55296)
        {
          k = m & 0x1FFF;
          i = 13;
          for (m = j;; m = j)
          {
            j = m + 1;
            m = paramzzjf.charAt(m);
            if (m < 55296) {
              break;
            }
            k |= (m & 0x1FFF) << i;
            i += 13;
          }
          i = k | m << i;
          k = j;
        }
        j = k + 1;
        m = paramzzjf.charAt(k);
        i3 = m;
        k = j;
        if (m >= 55296)
        {
          m &= 0x1FFF;
          k = 13;
          for (n = j;; n = j)
          {
            j = n + 1;
            n = paramzzjf.charAt(n);
            if (n < 55296) {
              break;
            }
            m |= (n & 0x1FFF) << k;
            k += 13;
          }
          i3 = m | n << k;
          k = j;
        }
        j = k + 1;
        n = paramzzjf.charAt(k);
        k = n;
        m = j;
        if (n >= 55296)
        {
          m = n & 0x1FFF;
          k = 13;
          for (n = j;; n = j)
          {
            j = n + 1;
            n = paramzzjf.charAt(n);
            if (n < 55296) {
              break;
            }
            m |= (n & 0x1FFF) << k;
            k += 13;
          }
          k = m | n << k;
          m = j;
        }
        j = m + 1;
        i1 = paramzzjf.charAt(m);
        m = i1;
        n = j;
        if (i1 >= 55296)
        {
          n = i1 & 0x1FFF;
          m = 13;
          for (i1 = j;; i1 = j)
          {
            j = i1 + 1;
            i1 = paramzzjf.charAt(i1);
            if (i1 < 55296) {
              break;
            }
            n |= (i1 & 0x1FFF) << m;
            m += 13;
          }
          m = n | i1 << m;
          n = j;
        }
        j = n + 1;
        i2 = paramzzjf.charAt(n);
        n = i2;
        i1 = j;
        if (i2 >= 55296)
        {
          i1 = i2 & 0x1FFF;
          n = 13;
          for (i2 = j;; i2 = j)
          {
            j = i2 + 1;
            i2 = paramzzjf.charAt(i2);
            if (i2 < 55296) {
              break;
            }
            i1 |= (i2 & 0x1FFF) << n;
            n += 13;
          }
          n = i1 | i2 << n;
          i1 = j;
        }
        j = i1 + 1;
        i4 = paramzzjf.charAt(i1);
        i1 = i4;
        i2 = j;
        if (i4 >= 55296)
        {
          i2 = i4 & 0x1FFF;
          i1 = 13;
          for (i4 = j;; i4 = j)
          {
            j = i4 + 1;
            i4 = paramzzjf.charAt(i4);
            if (i4 < 55296) {
              break;
            }
            i2 |= (i4 & 0x1FFF) << i1;
            i1 += 13;
          }
          i1 = i2 | i4 << i1;
          i2 = j;
        }
        j = i2 + 1;
        i5 = paramzzjf.charAt(i2);
        i4 = i5;
        i2 = j;
        if (i5 >= 55296)
        {
          i4 = i5 & 0x1FFF;
          i2 = 13;
          for (i5 = j;; i5 = j)
          {
            j = i5 + 1;
            i5 = paramzzjf.charAt(i5);
            if (i5 < 55296) {
              break;
            }
            i4 |= (i5 & 0x1FFF) << i2;
            i2 += 13;
          }
          i4 |= i5 << i2;
          i2 = j;
        }
        i5 = i2 + 1;
        i6 = paramzzjf.charAt(i2);
        j = i6;
        i2 = i5;
        if (i6 >= 55296)
        {
          i2 = i6 & 0x1FFF;
          i6 = i5;
          j = 13;
          i5 = i2;
          for (;;)
          {
            i2 = i6 + 1;
            i6 = paramzzjf.charAt(i6);
            if (i6 < 55296) {
              break;
            }
            i5 |= (i6 & 0x1FFF) << j;
            j += 13;
            i6 = i2;
          }
          j = i5 | i6 << j;
        }
        paramClass = new int[j + i1 + i4];
        i5 = (i << 1) + i3;
        i3 = i;
        i = i2;
        i4 = i1;
        i1 = n;
        i2 = m;
        n = k;
        m = i5;
        k = i3;
      }
      Unsafe localUnsafe = zzb;
      Object[] arrayOfObject2 = localzzjx.zze();
      Class localClass = localzzjx.zzc().getClass();
      int[] arrayOfInt = new int[i1 * 3];
      Object[] arrayOfObject1 = new Object[i1 << 1];
      int i12 = j + i4;
      int i1 = m;
      int i3 = j;
      int i4 = i;
      m = i12;
      int i5 = 0;
      int i8 = 0;
      i = i3;
      i3 = i5;
      int i6 = i2;
      i5 = n;
      n = i4;
      int i7 = k;
      k = i9;
      while (n < k)
      {
        i2 = n + 1;
        i9 = paramzzjf.charAt(n);
        if (i9 >= 55296)
        {
          i4 = i9 & 0x1FFF;
          i9 = i2;
          n = 13;
          i2 = i4;
          for (;;)
          {
            i4 = i9 + 1;
            i9 = paramzzjf.charAt(i9);
            if (i9 < 55296) {
              break;
            }
            i2 |= (i9 & 0x1FFF) << n;
            n += 13;
            i9 = i4;
          }
          i9 = i2 | i9 << n;
          i2 = i4;
        }
        n = i2 + 1;
        int i11 = paramzzjf.charAt(i2);
        if (i11 >= 55296)
        {
          i4 = i11 & 0x1FFF;
          i2 = 13;
          for (;;)
          {
            i10 = n + 1;
            i11 = paramzzjf.charAt(n);
            n = j;
            if (i11 < 55296) {
              break;
            }
            i4 |= (i11 & 0x1FFF) << i2;
            i2 += 13;
            j = n;
            n = i10;
          }
          i11 = i4 | i11 << i2;
          i2 = i10;
        }
        else
        {
          i2 = n;
          n = j;
        }
        int i14 = i11 & 0xFF;
        int i10 = i3;
        if ((i11 & 0x400) != 0)
        {
          paramClass[i3] = i8;
          i10 = i3 + 1;
        }
        Object localObject;
        if (i14 >= 51)
        {
          i4 = i2 + 1;
          i2 = paramzzjf.charAt(i2);
          i3 = i2;
          j = i4;
          if (i2 >= 55296)
          {
            i3 = i2 & 0x1FFF;
            j = 13;
            for (;;)
            {
              i2 = i4 + 1;
              i4 = paramzzjf.charAt(i4);
              if (i4 < 55296) {
                break;
              }
              i3 |= (i4 & 0x1FFF) << j;
              j += 13;
              i4 = i2;
            }
            i3 |= i4 << j;
            j = i2;
          }
          i4 = i14 - 51;
          if ((i4 != 9) && (i4 != 17))
          {
            i2 = i1;
            if (i4 == 12)
            {
              i2 = i1;
              if (!bool)
              {
                arrayOfObject1[((i8 / 3 << 1) + 1)] = arrayOfObject2[i1];
                i2 = i1 + 1;
              }
            }
            i1 = i2;
          }
          else
          {
            arrayOfObject1[((i8 / 3 << 1) + 1)] = arrayOfObject2[i1];
            i1 += 1;
          }
          i2 = i3 << 1;
          localObject = arrayOfObject2[i2];
          if ((localObject instanceof Field))
          {
            localObject = (Field)localObject;
          }
          else
          {
            localObject = zza(localClass, (String)localObject);
            arrayOfObject2[i2] = localObject;
          }
          i4 = (int)localUnsafe.objectFieldOffset((Field)localObject);
          i2 += 1;
          localObject = arrayOfObject2[i2];
          if ((localObject instanceof Field))
          {
            localObject = (Field)localObject;
          }
          else
          {
            localObject = zza(localClass, (String)localObject);
            arrayOfObject2[i2] = localObject;
          }
          i3 = (int)localUnsafe.objectFieldOffset((Field)localObject);
          i2 = 0;
        }
        else
        {
          i3 = i1 + 1;
          localObject = zza(localClass, (String)arrayOfObject2[i1]);
          if ((i14 != 9) && (i14 != 17))
          {
            if ((i14 != 27) && (i14 != 49))
            {
              if ((i14 != 12) && (i14 != 30) && (i14 != 44))
              {
                j = i3;
                i1 = i;
                if (i14 != 50) {
                  break label2155;
                }
                j = i + 1;
                paramClass[i] = i8;
                i4 = i8 / 3 << 1;
                i1 = i3 + 1;
                arrayOfObject1[i4] = arrayOfObject2[i3];
                if ((i11 & 0x800) != 0)
                {
                  i = i1 + 1;
                  arrayOfObject1[(i4 + 1)] = arrayOfObject2[i1];
                  i1 = j;
                  j = i;
                  break label2155;
                }
                i = j;
                j = i1;
              }
              else if (!bool)
              {
                i1 = i8 / 3;
                j = i3 + 1;
                arrayOfObject1[((i1 << 1) + 1)] = arrayOfObject2[i3];
              }
              else
              {
                j = i3;
                i1 = i;
                break label2155;
              }
            }
            else
            {
              i1 = i8 / 3;
              j = i3 + 1;
              arrayOfObject1[((i1 << 1) + 1)] = arrayOfObject2[i3];
            }
            break label2159;
          }
          else
          {
            arrayOfObject1[((i8 / 3 << 1) + 1)] = ((Field)localObject).getType();
            i1 = i;
            j = i3;
          }
          label2155:
          i = i1;
          label2159:
          i13 = (int)localUnsafe.objectFieldOffset((Field)localObject);
          if (((i11 & 0x1000) == 4096) && (i14 <= 17))
          {
            i3 = i2 + 1;
            i4 = paramzzjf.charAt(i2);
            i2 = i4;
            i1 = i3;
            if (i4 >= 55296)
            {
              i2 = i4 & 0x1FFF;
              i1 = 13;
              i4 = i3;
              i3 = i2;
              for (;;)
              {
                i2 = i4 + 1;
                i4 = paramzzjf.charAt(i4);
                if (i4 < 55296) {
                  break;
                }
                i3 |= (i4 & 0x1FFF) << i1;
                i1 += 13;
                i4 = i2;
              }
              i3 |= i4 << i1;
              i1 = i2;
              i2 = i3;
            }
            i3 = (i7 << 1) + i2 / 32;
            localObject = arrayOfObject2[i3];
            if ((localObject instanceof Field))
            {
              localObject = (Field)localObject;
            }
            else
            {
              localObject = zza(localClass, (String)localObject);
              arrayOfObject2[i3] = localObject;
            }
            i3 = (int)localUnsafe.objectFieldOffset((Field)localObject);
            i2 %= 32;
            i4 = i1;
          }
          else
          {
            i3 = 1048575;
            i1 = 0;
            i4 = i2;
            i2 = i1;
          }
          i1 = m;
          if (i14 >= 18)
          {
            i1 = m;
            if (i14 <= 49)
            {
              paramClass[m] = i13;
              i1 = m + 1;
            }
          }
          m = i1;
          i1 = j;
          j = i4;
          i4 = i13;
        }
        int i15 = i8 + 1;
        arrayOfInt[i8] = i9;
        int i13 = i15 + 1;
        if ((i11 & 0x200) != 0) {
          i8 = 536870912;
        } else {
          i8 = 0;
        }
        if ((i11 & 0x100) != 0) {
          i9 = 268435456;
        } else {
          i9 = 0;
        }
        arrayOfInt[i15] = (i9 | i8 | i14 << 20 | i4);
        arrayOfInt[i13] = (i2 << 20 | i3);
        i2 = j;
        j = n;
        i8 = i13 + 1;
        n = i2;
        i3 = i10;
      }
      return new zzjl(arrayOfInt, arrayOfObject1, i5, i6, localzzjx.zzc(), bool, false, paramClass, j, i12, paramzzjp, paramzzir, paramzzkr, paramzzho, paramzzje);
    }
    ((zzko)paramzzjf).zza();
    int i = zzjw.zzb;
    throw new NoSuchMethodError();
  }
  
  private final zzjz zza(int paramInt)
  {
    paramInt = paramInt / 3 << 1;
    zzjz localzzjz = (zzjz)this.zzd[paramInt];
    if (localzzjz != null) {
      return localzzjz;
    }
    localzzjz = zzjv.zza().zza((Class)this.zzd[(paramInt + 1)]);
    this.zzd[paramInt] = localzzjz;
    return localzzjz;
  }
  
  private final <K, V, UT, UB> UB zza(int paramInt1, int paramInt2, Map<K, V> paramMap, zzid paramzzid, UB paramUB, zzkr<UT, UB> paramzzkr)
  {
    zzjc localzzjc = this.zzs.zzb(zzb(paramInt1));
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!paramzzid.zza(((Integer)localEntry.getValue()).intValue()))
      {
        paramMap = paramUB;
        if (paramUB == null) {
          paramMap = paramzzkr.zza();
        }
        paramUB = zzgr.zzc(zziz.zza(localzzjc, localEntry.getKey(), localEntry.getValue()));
        zzhg localzzhg = paramUB.zzb();
        try
        {
          zziz.zza(localzzhg, localzzjc, localEntry.getKey(), localEntry.getValue());
          paramzzkr.zza(paramMap, paramInt2, paramUB.zza());
          localIterator.remove();
          paramUB = paramMap;
        }
        catch (IOException paramMap)
        {
          throw new RuntimeException(paramMap);
        }
      }
    }
    return paramUB;
  }
  
  private final <UT, UB> UB zza(Object paramObject, int paramInt, UB paramUB, zzkr<UT, UB> paramzzkr)
  {
    int i = this.zzc[paramInt];
    paramObject = zzkx.zzf(paramObject, zzd(paramInt) & 0xFFFFF);
    if (paramObject == null) {
      return paramUB;
    }
    zzid localzzid = zzc(paramInt);
    if (localzzid == null) {
      return paramUB;
    }
    return (UB)zza(paramInt, i, this.zzs.zza(paramObject), localzzid, paramUB, paramzzkr);
  }
  
  private static Field zza(Class<?> paramClass, String paramString)
  {
    try
    {
      localObject1 = paramClass.getDeclaredField(paramString);
      return (Field)localObject1;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      Object localObject1;
      int j;
      int i;
      Object localObject2;
      for (;;) {}
    }
    localObject1 = paramClass.getDeclaredFields();
    j = localObject1.length;
    i = 0;
    while (i < j)
    {
      localObject2 = localObject1[i];
      if (paramString.equals(((Field)localObject2).getName())) {
        return (Field)localObject2;
      }
      i += 1;
    }
    paramClass = paramClass.getName();
    localObject1 = Arrays.toString((Object[])localObject1);
    localObject2 = new StringBuilder(String.valueOf(paramString).length() + 40 + String.valueOf(paramClass).length() + String.valueOf(localObject1).length());
    ((StringBuilder)localObject2).append("Field ");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(" for ");
    ((StringBuilder)localObject2).append(paramClass);
    ((StringBuilder)localObject2).append(" not found. Known fields are ");
    ((StringBuilder)localObject2).append((String)localObject1);
    throw new RuntimeException(((StringBuilder)localObject2).toString());
  }
  
  private static List<?> zza(Object paramObject, long paramLong)
  {
    return (List)zzkx.zzf(paramObject, paramLong);
  }
  
  private static void zza(int paramInt, Object paramObject, zzlo paramzzlo)
    throws IOException
  {
    if ((paramObject instanceof String))
    {
      paramzzlo.zza(paramInt, (String)paramObject);
      return;
    }
    paramzzlo.zza(paramInt, (zzgr)paramObject);
  }
  
  private static <UT, UB> void zza(zzkr<UT, UB> paramzzkr, T paramT, zzlo paramzzlo)
    throws IOException
  {
    paramzzkr.zza(paramzzkr.zzb(paramT), paramzzlo);
  }
  
  private final <K, V> void zza(zzlo paramzzlo, int paramInt1, Object paramObject, int paramInt2)
    throws IOException
  {
    if (paramObject != null) {
      paramzzlo.zza(paramInt1, this.zzs.zzb(zzb(paramInt2)), this.zzs.zzc(paramObject));
    }
  }
  
  private final void zza(Object paramObject, int paramInt, zzka paramzzka)
    throws IOException
  {
    if (zzf(paramInt))
    {
      zzkx.zza(paramObject, paramInt & 0xFFFFF, paramzzka.zzm());
      return;
    }
    if (this.zzi)
    {
      zzkx.zza(paramObject, paramInt & 0xFFFFF, paramzzka.zzl());
      return;
    }
    zzkx.zza(paramObject, paramInt & 0xFFFFF, paramzzka.zzn());
  }
  
  private final void zza(T paramT1, T paramT2, int paramInt)
  {
    long l = zzd(paramInt) & 0xFFFFF;
    if (!zza(paramT2, paramInt)) {
      return;
    }
    Object localObject = zzkx.zzf(paramT1, l);
    paramT2 = zzkx.zzf(paramT2, l);
    if ((localObject != null) && (paramT2 != null))
    {
      zzkx.zza(paramT1, l, zzic.zza(localObject, paramT2));
      zzb(paramT1, paramInt);
      return;
    }
    if (paramT2 != null)
    {
      zzkx.zza(paramT1, l, paramT2);
      zzb(paramT1, paramInt);
    }
  }
  
  private final boolean zza(T paramT, int paramInt)
  {
    int i = zze(paramInt);
    long l = i & 0xFFFFF;
    if (l == 1048575L)
    {
      paramInt = zzd(paramInt);
      l = paramInt & 0xFFFFF;
      switch ((paramInt & 0xFF00000) >>> 20)
      {
      default: 
        throw new IllegalArgumentException();
      case 17: 
        return zzkx.zzf(paramT, l) != null;
      case 16: 
        return zzkx.zzb(paramT, l) != 0L;
      case 15: 
        return zzkx.zza(paramT, l) != 0;
      case 14: 
        return zzkx.zzb(paramT, l) != 0L;
      case 13: 
        return zzkx.zza(paramT, l) != 0;
      case 12: 
        return zzkx.zza(paramT, l) != 0;
      case 11: 
        return zzkx.zza(paramT, l) != 0;
      case 10: 
        return !zzgr.zza.equals(zzkx.zzf(paramT, l));
      case 9: 
        return zzkx.zzf(paramT, l) != null;
      case 8: 
        paramT = zzkx.zzf(paramT, l);
        if ((paramT instanceof String)) {
          return !((String)paramT).isEmpty();
        }
        if ((paramT instanceof zzgr)) {
          return !zzgr.zza.equals(paramT);
        }
        throw new IllegalArgumentException();
      case 7: 
        return zzkx.zzc(paramT, l);
      case 6: 
        return zzkx.zza(paramT, l) != 0;
      case 5: 
        return zzkx.zzb(paramT, l) != 0L;
      case 4: 
        return zzkx.zza(paramT, l) != 0;
      case 3: 
        return zzkx.zzb(paramT, l) != 0L;
      case 2: 
        return zzkx.zzb(paramT, l) != 0L;
      case 1: 
        return zzkx.zzd(paramT, l) != 0.0F;
      }
      return zzkx.zze(paramT, l) != 0.0D;
    }
    return (zzkx.zza(paramT, l) & 1 << (i >>> 20)) != 0;
  }
  
  private final boolean zza(T paramT, int paramInt1, int paramInt2)
  {
    return zzkx.zza(paramT, zze(paramInt2) & 0xFFFFF) == paramInt1;
  }
  
  private final boolean zza(T paramT, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 == 1048575) {
      return zza(paramT, paramInt1);
    }
    return (paramInt3 & paramInt4) != 0;
  }
  
  private static boolean zza(Object paramObject, int paramInt, zzjz paramzzjz)
  {
    return paramzzjz.zzd(zzkx.zzf(paramObject, paramInt & 0xFFFFF));
  }
  
  private static <T> double zzb(T paramT, long paramLong)
  {
    return ((Double)zzkx.zzf(paramT, paramLong)).doubleValue();
  }
  
  private final int zzb(int paramInt1, int paramInt2)
  {
    int i = this.zzc.length / 3 - 1;
    while (paramInt2 <= i)
    {
      int j = i + paramInt2 >>> 1;
      int k = j * 3;
      int m = this.zzc[k];
      if (paramInt1 == m) {
        return k;
      }
      if (paramInt1 < m) {
        i = j - 1;
      } else {
        paramInt2 = j + 1;
      }
    }
    return -1;
  }
  
  private final Object zzb(int paramInt)
  {
    return this.zzd[(paramInt / 3 << 1)];
  }
  
  private final void zzb(T paramT, int paramInt)
  {
    paramInt = zze(paramInt);
    long l = 0xFFFFF & paramInt;
    if (l == 1048575L) {
      return;
    }
    zzkx.zza(paramT, l, 1 << (paramInt >>> 20) | zzkx.zza(paramT, l));
  }
  
  private final void zzb(T paramT, int paramInt1, int paramInt2)
  {
    zzkx.zza(paramT, zze(paramInt2) & 0xFFFFF, paramInt1);
  }
  
  private final void zzb(T paramT, zzlo paramzzlo)
    throws IOException
  {
    if (this.zzh)
    {
      localObject1 = this.zzr.zza(paramT);
      if (!((zzhp)localObject1).zza.isEmpty())
      {
        localIterator = ((zzhp)localObject1).zzd();
        localObject1 = (Map.Entry)localIterator.next();
        break label56;
      }
    }
    Iterator localIterator = null;
    Object localObject1 = null;
    label56:
    int i1 = this.zzc.length;
    Unsafe localUnsafe = zzb;
    int m = 0;
    int i = 1048575;
    int j = 0;
    Object localObject2;
    for (;;)
    {
      localObject2 = localObject1;
      if (m >= i1) {
        break;
      }
      int i2 = zzd(m);
      localObject2 = this.zzc;
      int i3 = localObject2[m];
      int i4 = (i2 & 0xFF00000) >>> 20;
      int n;
      if (i4 <= 17)
      {
        int i5 = localObject2[(m + 2)];
        n = i5 & 0xFFFFF;
        int k = i;
        if (n != i)
        {
          j = localUnsafe.getInt(paramT, n);
          k = n;
        }
        n = 1 << (i5 >>> 20);
        i = k;
      }
      else
      {
        n = 0;
      }
      while ((localObject1 != null) && (this.zzr.zza((Map.Entry)localObject1) <= i3))
      {
        this.zzr.zza(paramzzlo, (Map.Entry)localObject1);
        if (localIterator.hasNext()) {
          localObject1 = (Map.Entry)localIterator.next();
        } else {
          localObject1 = null;
        }
      }
      long l = i2 & 0xFFFFF;
      switch (i4)
      {
      }
      for (;;)
      {
        break;
        if (zza(paramT, i3, m))
        {
          paramzzlo.zzb(i3, localUnsafe.getObject(paramT, l), zza(m));
          continue;
          if (zza(paramT, i3, m))
          {
            paramzzlo.zze(i3, zze(paramT, l));
            continue;
            if (zza(paramT, i3, m))
            {
              paramzzlo.zzf(i3, zzd(paramT, l));
              continue;
              if (zza(paramT, i3, m))
              {
                paramzzlo.zzb(i3, zze(paramT, l));
                continue;
                if (zza(paramT, i3, m))
                {
                  paramzzlo.zza(i3, zzd(paramT, l));
                  continue;
                  if (zza(paramT, i3, m))
                  {
                    paramzzlo.zzb(i3, zzd(paramT, l));
                    continue;
                    if (zza(paramT, i3, m))
                    {
                      paramzzlo.zze(i3, zzd(paramT, l));
                      continue;
                      if (zza(paramT, i3, m))
                      {
                        paramzzlo.zza(i3, (zzgr)localUnsafe.getObject(paramT, l));
                        continue;
                        if (zza(paramT, i3, m))
                        {
                          paramzzlo.zza(i3, localUnsafe.getObject(paramT, l), zza(m));
                          continue;
                          if (zza(paramT, i3, m))
                          {
                            zza(i3, localUnsafe.getObject(paramT, l), paramzzlo);
                            continue;
                            if (zza(paramT, i3, m))
                            {
                              paramzzlo.zza(i3, zzf(paramT, l));
                              continue;
                              if (zza(paramT, i3, m))
                              {
                                paramzzlo.zzd(i3, zzd(paramT, l));
                                continue;
                                if (zza(paramT, i3, m))
                                {
                                  paramzzlo.zzd(i3, zze(paramT, l));
                                  continue;
                                  if (zza(paramT, i3, m))
                                  {
                                    paramzzlo.zzc(i3, zzd(paramT, l));
                                    continue;
                                    if (zza(paramT, i3, m))
                                    {
                                      paramzzlo.zzc(i3, zze(paramT, l));
                                      continue;
                                      if (zza(paramT, i3, m))
                                      {
                                        paramzzlo.zza(i3, zze(paramT, l));
                                        continue;
                                        if (zza(paramT, i3, m))
                                        {
                                          paramzzlo.zza(i3, zzc(paramT, l));
                                          continue;
                                          if (zza(paramT, i3, m))
                                          {
                                            paramzzlo.zza(i3, zzb(paramT, l));
                                            continue;
                                            zza(paramzzlo, i3, localUnsafe.getObject(paramT, l), m);
                                            continue;
                                            zzkb.zzb(this.zzc[m], (List)localUnsafe.getObject(paramT, l), paramzzlo, zza(m));
                                            continue;
                                            zzkb.zze(this.zzc[m], (List)localUnsafe.getObject(paramT, l), paramzzlo, true);
                                            continue;
                                            zzkb.zzj(this.zzc[m], (List)localUnsafe.getObject(paramT, l), paramzzlo, true);
                                            continue;
                                            zzkb.zzg(this.zzc[m], (List)localUnsafe.getObject(paramT, l), paramzzlo, true);
                                            continue;
                                            zzkb.zzl(this.zzc[m], (List)localUnsafe.getObject(paramT, l), paramzzlo, true);
                                            continue;
                                            zzkb.zzm(this.zzc[m], (List)localUnsafe.getObject(paramT, l), paramzzlo, true);
                                            continue;
                                            zzkb.zzi(this.zzc[m], (List)localUnsafe.getObject(paramT, l), paramzzlo, true);
                                            continue;
                                            zzkb.zzn(this.zzc[m], (List)localUnsafe.getObject(paramT, l), paramzzlo, true);
                                            continue;
                                            zzkb.zzk(this.zzc[m], (List)localUnsafe.getObject(paramT, l), paramzzlo, true);
                                            continue;
                                            zzkb.zzf(this.zzc[m], (List)localUnsafe.getObject(paramT, l), paramzzlo, true);
                                            continue;
                                            zzkb.zzh(this.zzc[m], (List)localUnsafe.getObject(paramT, l), paramzzlo, true);
                                            continue;
                                            zzkb.zzd(this.zzc[m], (List)localUnsafe.getObject(paramT, l), paramzzlo, true);
                                            continue;
                                            zzkb.zzc(this.zzc[m], (List)localUnsafe.getObject(paramT, l), paramzzlo, true);
                                            continue;
                                            zzkb.zzb(this.zzc[m], (List)localUnsafe.getObject(paramT, l), paramzzlo, true);
                                            continue;
                                            zzkb.zza(this.zzc[m], (List)localUnsafe.getObject(paramT, l), paramzzlo, true);
                                            continue;
                                            zzkb.zze(this.zzc[m], (List)localUnsafe.getObject(paramT, l), paramzzlo, false);
                                            continue;
                                            zzkb.zzj(this.zzc[m], (List)localUnsafe.getObject(paramT, l), paramzzlo, false);
                                            continue;
                                            zzkb.zzg(this.zzc[m], (List)localUnsafe.getObject(paramT, l), paramzzlo, false);
                                            continue;
                                            zzkb.zzl(this.zzc[m], (List)localUnsafe.getObject(paramT, l), paramzzlo, false);
                                            continue;
                                            zzkb.zzm(this.zzc[m], (List)localUnsafe.getObject(paramT, l), paramzzlo, false);
                                            continue;
                                            zzkb.zzi(this.zzc[m], (List)localUnsafe.getObject(paramT, l), paramzzlo, false);
                                            continue;
                                            zzkb.zzb(this.zzc[m], (List)localUnsafe.getObject(paramT, l), paramzzlo);
                                            continue;
                                            zzkb.zza(this.zzc[m], (List)localUnsafe.getObject(paramT, l), paramzzlo, zza(m));
                                            continue;
                                            zzkb.zza(this.zzc[m], (List)localUnsafe.getObject(paramT, l), paramzzlo);
                                            continue;
                                            zzkb.zzn(this.zzc[m], (List)localUnsafe.getObject(paramT, l), paramzzlo, false);
                                            continue;
                                            zzkb.zzk(this.zzc[m], (List)localUnsafe.getObject(paramT, l), paramzzlo, false);
                                            continue;
                                            zzkb.zzf(this.zzc[m], (List)localUnsafe.getObject(paramT, l), paramzzlo, false);
                                            continue;
                                            zzkb.zzh(this.zzc[m], (List)localUnsafe.getObject(paramT, l), paramzzlo, false);
                                            continue;
                                            zzkb.zzd(this.zzc[m], (List)localUnsafe.getObject(paramT, l), paramzzlo, false);
                                            continue;
                                            zzkb.zzc(this.zzc[m], (List)localUnsafe.getObject(paramT, l), paramzzlo, false);
                                            continue;
                                            zzkb.zzb(this.zzc[m], (List)localUnsafe.getObject(paramT, l), paramzzlo, false);
                                            continue;
                                            zzkb.zza(this.zzc[m], (List)localUnsafe.getObject(paramT, l), paramzzlo, false);
                                            continue;
                                            if ((n & j) != 0)
                                            {
                                              paramzzlo.zzb(i3, localUnsafe.getObject(paramT, l), zza(m));
                                              break;
                                              if ((n & j) != 0)
                                              {
                                                paramzzlo.zze(i3, localUnsafe.getLong(paramT, l));
                                                break;
                                                if ((n & j) != 0)
                                                {
                                                  paramzzlo.zzf(i3, localUnsafe.getInt(paramT, l));
                                                  break;
                                                  if ((n & j) != 0)
                                                  {
                                                    paramzzlo.zzb(i3, localUnsafe.getLong(paramT, l));
                                                    break;
                                                    if ((n & j) != 0)
                                                    {
                                                      paramzzlo.zza(i3, localUnsafe.getInt(paramT, l));
                                                      break;
                                                      if ((n & j) != 0)
                                                      {
                                                        paramzzlo.zzb(i3, localUnsafe.getInt(paramT, l));
                                                        break;
                                                        if ((n & j) != 0)
                                                        {
                                                          paramzzlo.zze(i3, localUnsafe.getInt(paramT, l));
                                                          break;
                                                          if ((n & j) != 0)
                                                          {
                                                            paramzzlo.zza(i3, (zzgr)localUnsafe.getObject(paramT, l));
                                                            break;
                                                            if ((n & j) != 0)
                                                            {
                                                              paramzzlo.zza(i3, localUnsafe.getObject(paramT, l), zza(m));
                                                              break;
                                                              if ((n & j) != 0)
                                                              {
                                                                zza(i3, localUnsafe.getObject(paramT, l), paramzzlo);
                                                                break;
                                                                if ((n & j) != 0)
                                                                {
                                                                  paramzzlo.zza(i3, zzkx.zzc(paramT, l));
                                                                  break;
                                                                  if ((n & j) != 0)
                                                                  {
                                                                    paramzzlo.zzd(i3, localUnsafe.getInt(paramT, l));
                                                                    break;
                                                                    if ((n & j) != 0)
                                                                    {
                                                                      paramzzlo.zzd(i3, localUnsafe.getLong(paramT, l));
                                                                      break;
                                                                      if ((n & j) != 0)
                                                                      {
                                                                        paramzzlo.zzc(i3, localUnsafe.getInt(paramT, l));
                                                                        break;
                                                                        if ((n & j) != 0)
                                                                        {
                                                                          paramzzlo.zzc(i3, localUnsafe.getLong(paramT, l));
                                                                          break;
                                                                          if ((n & j) != 0)
                                                                          {
                                                                            paramzzlo.zza(i3, localUnsafe.getLong(paramT, l));
                                                                            break;
                                                                            if ((n & j) != 0)
                                                                            {
                                                                              paramzzlo.zza(i3, zzkx.zzd(paramT, l));
                                                                              break;
                                                                              if ((n & j) != 0) {
                                                                                paramzzlo.zza(i3, zzkx.zze(paramT, l));
                                                                              }
                                                                            }
                                                                          }
                                                                        }
                                                                      }
                                                                    }
                                                                  }
                                                                }
                                                              }
                                                            }
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      m += 3;
    }
    while (localObject2 != null)
    {
      this.zzr.zza(paramzzlo, (Map.Entry)localObject2);
      if (localIterator.hasNext()) {
        localObject2 = (Map.Entry)localIterator.next();
      } else {
        localObject2 = null;
      }
    }
    zza(this.zzq, paramT, paramzzlo);
  }
  
  private final void zzb(T paramT1, T paramT2, int paramInt)
  {
    int i = zzd(paramInt);
    int j = this.zzc[paramInt];
    long l = i & 0xFFFFF;
    if (!zza(paramT2, j, paramInt)) {
      return;
    }
    Object localObject = null;
    if (zza(paramT1, j, paramInt)) {
      localObject = zzkx.zzf(paramT1, l);
    }
    paramT2 = zzkx.zzf(paramT2, l);
    if ((localObject != null) && (paramT2 != null))
    {
      zzkx.zza(paramT1, l, zzic.zza(localObject, paramT2));
      zzb(paramT1, j, paramInt);
      return;
    }
    if (paramT2 != null)
    {
      zzkx.zza(paramT1, l, paramT2);
      zzb(paramT1, j, paramInt);
    }
  }
  
  private static <T> float zzc(T paramT, long paramLong)
  {
    return ((Float)zzkx.zzf(paramT, paramLong)).floatValue();
  }
  
  private final zzid zzc(int paramInt)
  {
    return (zzid)this.zzd[((paramInt / 3 << 1) + 1)];
  }
  
  private final boolean zzc(T paramT1, T paramT2, int paramInt)
  {
    return zza(paramT1, paramInt) == zza(paramT2, paramInt);
  }
  
  private final int zzd(int paramInt)
  {
    return this.zzc[(paramInt + 1)];
  }
  
  private static <T> int zzd(T paramT, long paramLong)
  {
    return ((Integer)zzkx.zzf(paramT, paramLong)).intValue();
  }
  
  private final int zze(int paramInt)
  {
    return this.zzc[(paramInt + 2)];
  }
  
  private static <T> long zze(T paramT, long paramLong)
  {
    return ((Long)zzkx.zzf(paramT, paramLong)).longValue();
  }
  
  private static zzku zze(Object paramObject)
  {
    zzhz localzzhz = (zzhz)paramObject;
    zzku localzzku = localzzhz.zzb;
    paramObject = localzzku;
    if (localzzku == zzku.zza())
    {
      paramObject = zzku.zzb();
      localzzhz.zzb = ((zzku)paramObject);
    }
    return (zzku)paramObject;
  }
  
  private static boolean zzf(int paramInt)
  {
    return (paramInt & 0x20000000) != 0;
  }
  
  private static <T> boolean zzf(T paramT, long paramLong)
  {
    return ((Boolean)zzkx.zzf(paramT, paramLong)).booleanValue();
  }
  
  private final int zzg(int paramInt)
  {
    if ((paramInt >= this.zze) && (paramInt <= this.zzf)) {
      return zzb(paramInt, 0);
    }
    return -1;
  }
  
  public final int zza(T paramT)
  {
    int m = this.zzc.length;
    int k = 0;
    for (int j = 0; k < m; j = i)
    {
      int i1 = zzd(k);
      int n = this.zzc[k];
      long l = 0xFFFFF & i1;
      i = 37;
      Object localObject;
      switch ((i1 & 0xFF00000) >>> 20)
      {
      default: 
        i = j;
        break;
      case 68: 
        i = j;
        if (!zza(paramT, n, k)) {
          break label1289;
        }
        localObject = zzkx.zzf(paramT, l);
        i = j * 53;
        j = localObject.hashCode();
        break;
      case 67: 
        i = j;
        if (!zza(paramT, n, k)) {
          break label1289;
        }
        i = j * 53;
        j = zzic.zza(zze(paramT, l));
        break;
      case 66: 
        i = j;
        if (!zza(paramT, n, k)) {
          break label1289;
        }
        i = j * 53;
        j = zzd(paramT, l);
        break;
      case 65: 
        i = j;
        if (!zza(paramT, n, k)) {
          break label1289;
        }
        i = j * 53;
        j = zzic.zza(zze(paramT, l));
        break;
      case 64: 
        i = j;
        if (!zza(paramT, n, k)) {
          break label1289;
        }
        i = j * 53;
        j = zzd(paramT, l);
        break;
      case 63: 
        i = j;
        if (!zza(paramT, n, k)) {
          break label1289;
        }
        i = j * 53;
        j = zzd(paramT, l);
        break;
      case 62: 
        i = j;
        if (!zza(paramT, n, k)) {
          break label1289;
        }
        i = j * 53;
        j = zzd(paramT, l);
        break;
      case 61: 
        i = j;
        if (!zza(paramT, n, k)) {
          break label1289;
        }
        i = j * 53;
        j = zzkx.zzf(paramT, l).hashCode();
        break;
      case 60: 
        i = j;
        if (!zza(paramT, n, k)) {
          break label1289;
        }
        localObject = zzkx.zzf(paramT, l);
        i = j * 53;
        j = localObject.hashCode();
        break;
      case 59: 
        i = j;
        if (!zza(paramT, n, k)) {
          break label1289;
        }
        i = j * 53;
        j = ((String)zzkx.zzf(paramT, l)).hashCode();
        break;
      case 58: 
        i = j;
        if (!zza(paramT, n, k)) {
          break label1289;
        }
        i = j * 53;
        j = zzic.zza(zzf(paramT, l));
        break;
      case 57: 
        i = j;
        if (!zza(paramT, n, k)) {
          break label1289;
        }
        i = j * 53;
        j = zzd(paramT, l);
        break;
      case 56: 
        i = j;
        if (!zza(paramT, n, k)) {
          break label1289;
        }
        i = j * 53;
        j = zzic.zza(zze(paramT, l));
        break;
      case 55: 
        i = j;
        if (!zza(paramT, n, k)) {
          break label1289;
        }
        i = j * 53;
        j = zzd(paramT, l);
        break;
      case 54: 
        i = j;
        if (!zza(paramT, n, k)) {
          break label1289;
        }
        i = j * 53;
        j = zzic.zza(zze(paramT, l));
        break;
      case 53: 
        i = j;
        if (!zza(paramT, n, k)) {
          break label1289;
        }
        i = j * 53;
        j = zzic.zza(zze(paramT, l));
        break;
      case 52: 
        i = j;
        if (!zza(paramT, n, k)) {
          break label1289;
        }
        i = j * 53;
        j = Float.floatToIntBits(zzc(paramT, l));
        break;
      case 51: 
        i = j;
        if (!zza(paramT, n, k)) {
          break label1289;
        }
        i = j * 53;
        j = zzic.zza(Double.doubleToLongBits(zzb(paramT, l)));
        break;
      case 50: 
        i = j * 53;
        j = zzkx.zzf(paramT, l).hashCode();
        break;
      case 18: 
      case 19: 
      case 20: 
      case 21: 
      case 22: 
      case 23: 
      case 24: 
      case 25: 
      case 26: 
      case 27: 
      case 28: 
      case 29: 
      case 30: 
      case 31: 
      case 32: 
      case 33: 
      case 34: 
      case 35: 
      case 36: 
      case 37: 
      case 38: 
      case 39: 
      case 40: 
      case 41: 
      case 42: 
      case 43: 
      case 44: 
      case 45: 
      case 46: 
      case 47: 
      case 48: 
      case 49: 
        i = j * 53;
        j = zzkx.zzf(paramT, l).hashCode();
        break;
      case 17: 
        localObject = zzkx.zzf(paramT, l);
        if (localObject != null) {
          i = localObject.hashCode();
        }
        break;
      case 16: 
        i = j * 53;
        j = zzic.zza(zzkx.zzb(paramT, l));
        break;
      case 15: 
        i = j * 53;
        j = zzkx.zza(paramT, l);
        break;
      case 14: 
        i = j * 53;
        j = zzic.zza(zzkx.zzb(paramT, l));
        break;
      case 13: 
        i = j * 53;
        j = zzkx.zza(paramT, l);
        break;
      case 12: 
        i = j * 53;
        j = zzkx.zza(paramT, l);
        break;
      case 11: 
        i = j * 53;
        j = zzkx.zza(paramT, l);
        break;
      case 10: 
        i = j * 53;
        j = zzkx.zzf(paramT, l).hashCode();
        break;
      case 9: 
        localObject = zzkx.zzf(paramT, l);
        if (localObject != null) {
          i = localObject.hashCode();
        }
        i = j * 53 + i;
        break;
      case 8: 
        i = j * 53;
        j = ((String)zzkx.zzf(paramT, l)).hashCode();
        break;
      case 7: 
        i = j * 53;
        j = zzic.zza(zzkx.zzc(paramT, l));
        break;
      case 6: 
        i = j * 53;
        j = zzkx.zza(paramT, l);
        break;
      case 5: 
        i = j * 53;
        j = zzic.zza(zzkx.zzb(paramT, l));
        break;
      case 4: 
        i = j * 53;
        j = zzkx.zza(paramT, l);
        break;
      case 3: 
        i = j * 53;
        j = zzic.zza(zzkx.zzb(paramT, l));
        break;
      case 2: 
        i = j * 53;
        j = zzic.zza(zzkx.zzb(paramT, l));
        break;
      case 1: 
        i = j * 53;
        j = Float.floatToIntBits(zzkx.zzd(paramT, l));
        break;
      }
      i = j * 53;
      j = zzic.zza(Double.doubleToLongBits(zzkx.zze(paramT, l)));
      i += j;
      label1289:
      k += 3;
    }
    j = j * 53 + this.zzq.zzb(paramT).hashCode();
    int i = j;
    if (this.zzh) {
      i = j * 53 + this.zzr.zza(paramT).hashCode();
    }
    return i;
  }
  
  final int zza(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, zzgm paramzzgm)
    throws IOException
  {
    Object localObject3 = this;
    T ? = paramT;
    int i2 = paramInt2;
    int n = paramInt3;
    Object localObject2 = paramzzgm;
    Object localObject1 = zzb;
    int k = -1;
    int i1 = 0;
    int j = 0;
    int i = 0;
    int m = 1048575;
    for (;;)
    {
      Object localObject4 = paramArrayOfByte;
      if (paramInt1 >= i2) {
        break;
      }
      i2 = paramInt1 + 1;
      paramInt1 = localObject4[paramInt1];
      if (paramInt1 < 0)
      {
        i2 = zzgn.zza(paramInt1, (byte[])localObject4, i2, (zzgm)localObject2);
        paramInt1 = ((zzgm)localObject2).zza;
      }
      j = paramInt1 >>> 3;
      int i4 = paramInt1 & 0x7;
      if (j > k) {
        k = ((zzjl)localObject3).zza(j, i1 / 3);
      } else {
        k = ((zzjl)localObject3).zzg(j);
      }
      int i5;
      int i6;
      if (k == -1)
      {
        k = j;
        i1 = paramInt1;
        j = i;
        paramInt1 = n;
        i3 = 0;
        n = i2;
        i = i1;
        i1 = i3;
      }
      else
      {
        localObject4 = ((zzjl)localObject3).zzc;
        int i8 = localObject4[(k + 1)];
        int i9 = (i8 & 0xFF00000) >>> 20;
        long l = i8 & 0xFFFFF;
        if (i9 <= 17)
        {
          n = localObject4[(k + 2)];
          i5 = 1 << (n >>> 20);
          n &= 0xFFFFF;
          if (n != m)
          {
            if (m != 1048575) {
              ((Unsafe)localObject1).putInt(?, m, i);
            }
            i = ((Unsafe)localObject1).getInt(?, n);
            m = n;
            n = i;
          }
          else
          {
            n = i;
          }
          switch (i9)
          {
          default: 
            break;
          case 17: 
            if (i4 == 3)
            {
              i4 = zzgn.zza(((zzjl)localObject3).zza(k), paramArrayOfByte, i2, paramInt2, j << 3 | 0x4, paramzzgm);
              if ((n & i5) == 0) {
                ((Unsafe)localObject1).putObject(?, l, paramzzgm.zzc);
              } else {
                ((Unsafe)localObject1).putObject(?, l, zzic.zza(((Unsafe)localObject1).getObject(?, l), paramzzgm.zzc));
              }
              i3 = n | i5;
              i2 = paramInt2;
              i = paramInt1;
              i1 = k;
              n = paramInt3;
              localObject2 = paramzzgm;
              paramInt1 = i4;
              k = j;
              j = i;
              i = i3;
              continue;
            }
            break;
          case 16: 
            if (i4 == 0)
            {
              i = zzgn.zzb(paramArrayOfByte, i2, paramzzgm);
              ((Unsafe)localObject1).putLong(paramT, l, zzhd.zza(paramzzgm.zzb));
            }
            break;
          case 15: 
            localObject2 = paramzzgm;
            if (i4 == 0)
            {
              i = zzgn.zza(paramArrayOfByte, i2, (zzgm)localObject2);
              ((Unsafe)localObject1).putInt(?, l, zzhd.zze(((zzgm)localObject2).zza));
            }
            break;
          case 12: 
            i = k;
            i3 = paramInt1;
            localObject2 = paramzzgm;
            if (i4 == 0)
            {
              i1 = zzgn.zza(paramArrayOfByte, i2, (zzgm)localObject2);
              i2 = ((zzgm)localObject2).zza;
              localObject4 = ((zzjl)localObject3).zzc(i);
              if ((localObject4 != null) && (!((zzid)localObject4).zza(i2)))
              {
                zze(paramT).zza(i3, Long.valueOf(i2));
                paramInt1 = i1;
                k = j;
                i1 = i;
                j = i3;
              }
              else
              {
                ((Unsafe)localObject1).putInt(?, l, i2);
                i = i1;
              }
            }
            break;
          case 10: 
            localObject2 = paramzzgm;
            if (i4 == 2)
            {
              i = zzgn.zze(paramArrayOfByte, i2, (zzgm)localObject2);
              ((Unsafe)localObject1).putObject(?, l, ((zzgm)localObject2).zzc);
            }
            break;
          case 9: 
            localObject2 = paramzzgm;
            if (i4 == 2)
            {
              i = zzgn.zza(((zzjl)localObject3).zza(k), paramArrayOfByte, i2, paramInt2, (zzgm)localObject2);
              if ((n & i5) == 0) {
                ((Unsafe)localObject1).putObject(?, l, ((zzgm)localObject2).zzc);
              } else {
                ((Unsafe)localObject1).putObject(?, l, zzic.zza(((Unsafe)localObject1).getObject(?, l), ((zzgm)localObject2).zzc));
              }
            }
            break;
          case 8: 
            localObject2 = paramArrayOfByte;
            localObject4 = paramzzgm;
            if (i4 == 2)
            {
              if ((i8 & 0x20000000) == 0) {
                i = zzgn.zzc((byte[])localObject2, i2, (zzgm)localObject4);
              } else {
                i = zzgn.zzd((byte[])localObject2, i2, (zzgm)localObject4);
              }
              ((Unsafe)localObject1).putObject(?, l, ((zzgm)localObject4).zzc);
            }
            break;
          case 7: 
            localObject2 = paramzzgm;
            if (i4 == 0)
            {
              i = zzgn.zzb(paramArrayOfByte, i2, (zzgm)localObject2);
              boolean bool;
              if (((zzgm)localObject2).zzb != 0L) {
                bool = true;
              } else {
                bool = false;
              }
              zzkx.zza(?, l, bool);
              n |= i5;
            }
            break;
          case 6: 
          case 13: 
            if (i4 == 5)
            {
              ((Unsafe)localObject1).putInt(?, l, zzgn.zza(paramArrayOfByte, i2));
              i = i2 + 4;
              n |= i5;
              i3 = paramInt1;
              localObject2 = paramzzgm;
              i2 = paramInt2;
              i1 = k;
              paramInt1 = i;
              k = j;
              j = i3;
              i = n;
            }
            break;
          case 5: 
          case 14: 
            if (i4 == 1)
            {
              ((Unsafe)localObject1).putLong(paramT, l, zzgn.zzb(paramArrayOfByte, i2));
              i = i2 + 8;
            }
            break;
          case 4: 
          case 11: 
            localObject2 = paramzzgm;
            if (i4 == 0)
            {
              i = zzgn.zza(paramArrayOfByte, i2, (zzgm)localObject2);
              ((Unsafe)localObject1).putInt(?, l, ((zzgm)localObject2).zza);
            }
            break;
          case 2: 
          case 3: 
            localObject2 = paramzzgm;
            if (i4 == 0)
            {
              i = zzgn.zzb(paramArrayOfByte, i2, (zzgm)localObject2);
              ((Unsafe)localObject1).putLong(paramT, l, ((zzgm)localObject2).zzb);
              n |= i5;
            }
            break;
          case 1: 
            if (i4 == 5)
            {
              zzkx.zza(?, l, zzgn.zzd(paramArrayOfByte, i2));
              i = i2 + 4;
            }
            break;
          case 0: 
            if (i4 == 1)
            {
              zzkx.zza(?, l, zzgn.zzc(paramArrayOfByte, i2));
              i = i2 + 8;
              n |= i5;
              i1 = paramInt1;
              paramInt1 = j;
              localObject2 = paramzzgm;
              j = i1;
              i1 = k;
              k = paramInt1;
              paramInt1 = i;
              i2 = paramInt2;
              i = n;
              break label1899;
            }
            i = paramInt1;
            paramInt1 = paramInt3;
            i1 = i2;
            i2 = n;
            i3 = j;
            n = i1;
            i1 = k;
            j = i2;
            k = i3;
            break;
          }
        }
        int i7;
        if (i9 == 27)
        {
          if (i4 == 2)
          {
            zzii localzzii = (zzii)((Unsafe)localObject1).getObject(?, l);
            localObject4 = localzzii;
            if (!localzzii.zza())
            {
              n = localzzii.size();
              if (n == 0) {
                n = 10;
              } else {
                n <<= 1;
              }
              localObject4 = localzzii.zza(n);
              ((Unsafe)localObject1).putObject(?, l, localObject4);
            }
            i4 = zzgn.zza(((zzjl)localObject3).zza(k), paramInt1, paramArrayOfByte, i2, paramInt2, (zzii)localObject4, paramzzgm);
            n = paramInt3;
            i2 = paramInt1;
            i1 = k;
            i3 = paramInt2;
            paramInt1 = i4;
            k = j;
            j = i2;
            i2 = i3;
            continue;
          }
        }
        else
        {
          i3 = k;
          i1 = i;
          n = m;
          if (i9 <= 49)
          {
            i5 = zza(paramT, paramArrayOfByte, i2, paramInt2, paramInt1, j, i4, i3, i8, i9, l, paramzzgm);
            i4 = i5;
            if (i5 == i2)
            {
              n = i5;
              break label1648;
            }
          }
          do
          {
            localObject3 = this;
            ? = paramT;
            i2 = paramInt2;
            i5 = paramInt3;
            localObject2 = paramzzgm;
            i = paramInt1;
            m = i1;
            paramInt1 = i4;
            k = j;
            i1 = i3;
            j = i;
            i = m;
            m = n;
            n = i5;
            break;
            i7 = i2;
            i6 = paramInt1;
            i5 = j;
            if (i9 != 50) {
              break label1609;
            }
            if (i4 != 2) {
              break label1572;
            }
            i2 = zza(paramT, paramArrayOfByte, i7, paramInt2, i3, l, paramzzgm);
            i4 = i2;
          } while (i2 != i7);
          n = i2;
          break label1648;
        }
        label1572:
        label1609:
        label1648:
        for (n = i2;; n = i4)
        {
          i2 = j;
          j = i;
          i = paramInt3;
          i1 = paramInt1;
          paramInt1 = i;
          i = i1;
          i1 = k;
          k = i2;
          break;
          i4 = zza(paramT, paramArrayOfByte, i7, paramInt2, i6, i5, i4, i8, i9, l, i3, paramzzgm);
          if (i4 != i7) {
            break label1862;
          }
        }
      }
      localObject3 = localObject1;
      if ((i == paramInt1) && (paramInt1 != 0))
      {
        paramArrayOfByte = this;
        paramzzgm = paramT;
        paramInt3 = n;
        k = j;
        j = i;
        i = k;
        k = paramInt1;
        paramT = paramArrayOfByte;
        paramArrayOfByte = paramzzgm;
        break label1919;
      }
      if (this.zzh)
      {
        localObject1 = paramzzgm;
        if (((zzgm)localObject1).zzd != zzhm.zza())
        {
          localObject2 = this.zzg;
          if (((zzgm)localObject1).zzd.zza((zzjh)localObject2, k) == null)
          {
            n = zzgn.zza(i, paramArrayOfByte, n, paramInt2, zze(paramT), paramzzgm);
            ? = paramT;
            localObject2 = localObject1;
            break label1822;
          }
          paramT = (zzhz.zzb)paramT;
          paramT.zza();
          paramT = paramT.zzc;
          throw new NoSuchMethodError();
        }
      }
      n = zzgn.zza(i, paramArrayOfByte, n, paramInt2, zze(paramT), paramzzgm);
      localObject2 = paramzzgm;
      ? = paramT;
      label1822:
      localObject4 = this;
      i2 = paramInt2;
      localObject1 = localObject3;
      int i3 = j;
      i4 = paramInt1;
      paramInt1 = n;
      j = i;
      i = i3;
      n = i4;
      localObject3 = localObject4;
      continue;
      label1862:
      localObject3 = this;
      ? = paramT;
      i2 = paramInt2;
      localObject2 = paramzzgm;
      j = i6;
      k = i5;
      i = i1;
      m = n;
      i1 = i3;
      paramInt1 = i4;
      label1899:
      n = paramInt3;
    }
    k = n;
    paramArrayOfByte = ?;
    paramT = (T)localObject3;
    paramInt3 = paramInt1;
    label1919:
    if (m != 1048575) {
      ((Unsafe)localObject1).putInt(paramArrayOfByte, m, i);
    }
    paramzzgm = null;
    paramInt1 = paramT.zzm;
    while (paramInt1 < paramT.zzn)
    {
      paramzzgm = (zzku)paramT.zza(paramArrayOfByte, paramT.zzl[paramInt1], paramzzgm, paramT.zzq);
      paramInt1 += 1;
    }
    if (paramzzgm != null) {
      paramT.zzq.zzb(paramArrayOfByte, paramzzgm);
    }
    if (k == 0)
    {
      if (paramInt3 == paramInt2) {
        return paramInt3;
      }
      throw zzih.zzg();
    }
    if ((paramInt3 <= paramInt2) && (j == k)) {
      return paramInt3;
    }
    throw zzih.zzg();
  }
  
  public final T zza()
  {
    return (T)this.zzo.zza(this.zzg);
  }
  
  public final void zza(T paramT, zzka paramzzka, zzhm paramzzhm)
    throws IOException
  {
    zzkr localzzkr;
    if (paramzzhm != null)
    {
      localzzkr = this.zzq;
      zzho localzzho = this.zzr;
      Object localObject5 = null;
      Object localObject1 = localObject5;
      label4014:
      label4097:
      do
      {
        for (;;)
        {
          Object localObject2 = localObject1;
          try
          {
            i = paramzzka.zza();
            localObject2 = localObject1;
            j = zzg(i);
            if (j < 0)
            {
              if (i == Integer.MAX_VALUE) {
                return;
              }
              localObject2 = localObject1;
              if (!this.zzh)
              {
                localObject4 = null;
              }
              else
              {
                localObject2 = localObject1;
                localObject4 = localzzho.zza(paramzzhm, this.zzg, i);
              }
              if (localObject4 != null)
              {
                localObject3 = localObject5;
                if (localObject5 == null)
                {
                  localObject2 = localObject1;
                  localObject3 = localzzho.zzb(paramT);
                }
                localObject2 = localObject1;
                localObject1 = localzzho.zza(paramzzka, localObject4, paramzzhm, (zzhp)localObject3, localObject1, localzzkr);
                localObject5 = localObject3;
                continue;
              }
              localObject2 = localObject1;
              localzzkr.zza(paramzzka);
              localObject3 = localObject1;
              if (localObject1 == null)
              {
                localObject2 = localObject1;
                localObject3 = localzzkr.zzc(paramT);
              }
              localObject2 = localObject3;
              bool = localzzkr.zza(localObject3, paramzzka);
              localObject1 = localObject3;
              if (bool) {
                continue;
              }
              return;
            }
            localObject2 = localObject1;
            k = zzd(j);
            switch ((0xFF00000 & k) >>> 20)
            {
            default: 
              localObject3 = localObject1;
              if (localObject1 == null)
              {
                localObject2 = localObject1;
                localObject4 = localObject1;
              }
              break;
            }
          }
          finally
          {
            int j;
            Object localObject4;
            Object localObject3;
            boolean bool;
            int k;
            int m;
            long l;
            Object localObject7;
            Object localObject6;
            int i = this.zzm;
            while (i < this.zzn)
            {
              localObject2 = zza(paramT, this.zzl[i], localObject2, localzzkr);
              i += 1;
            }
            if (localObject2 != null) {
              localzzkr.zzb(paramT, localObject2);
            }
          }
          try
          {
            localObject3 = localzzkr.zza();
            break label4014;
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzkx.zza(paramT, k & 0xFFFFF, paramzzka.zzb(zza(j), paramzzhm));
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzb(paramT, i, j);
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzkx.zza(paramT, k & 0xFFFFF, Long.valueOf(paramzzka.zzt()));
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzb(paramT, i, j);
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzkx.zza(paramT, k & 0xFFFFF, Integer.valueOf(paramzzka.zzs()));
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzb(paramT, i, j);
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzkx.zza(paramT, k & 0xFFFFF, Long.valueOf(paramzzka.zzr()));
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzb(paramT, i, j);
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzkx.zza(paramT, k & 0xFFFFF, Integer.valueOf(paramzzka.zzq()));
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzb(paramT, i, j);
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            m = paramzzka.zzp();
            localObject2 = localObject1;
            localObject4 = localObject1;
            localObject3 = zzc(j);
            if (localObject3 != null)
            {
              localObject2 = localObject1;
              localObject4 = localObject1;
              if (!((zzid)localObject3).zza(m))
              {
                localObject2 = localObject1;
                localObject4 = localObject1;
                localObject1 = zzkb.zza(i, m, localObject1, localzzkr);
                continue;
              }
            }
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzkx.zza(paramT, k & 0xFFFFF, Integer.valueOf(m));
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzb(paramT, i, j);
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzkx.zza(paramT, k & 0xFFFFF, Integer.valueOf(paramzzka.zzo()));
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzb(paramT, i, j);
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzkx.zza(paramT, k & 0xFFFFF, paramzzka.zzn());
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzb(paramT, i, j);
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            if (zza(paramT, i, j))
            {
              l = k & 0xFFFFF;
              localObject2 = localObject1;
              localObject4 = localObject1;
              zzkx.zza(paramT, l, zzic.zza(zzkx.zzf(paramT, l), paramzzka.zza(zza(j), paramzzhm)));
            }
            else
            {
              localObject2 = localObject1;
              localObject4 = localObject1;
              zzkx.zza(paramT, k & 0xFFFFF, paramzzka.zza(zza(j), paramzzhm));
              localObject2 = localObject1;
              localObject4 = localObject1;
              zzb(paramT, j);
            }
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzb(paramT, i, j);
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            zza(paramT, k, paramzzka);
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzb(paramT, i, j);
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzkx.zza(paramT, k & 0xFFFFF, Boolean.valueOf(paramzzka.zzk()));
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzb(paramT, i, j);
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzkx.zza(paramT, k & 0xFFFFF, Integer.valueOf(paramzzka.zzj()));
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzb(paramT, i, j);
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzkx.zza(paramT, k & 0xFFFFF, Long.valueOf(paramzzka.zzi()));
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzb(paramT, i, j);
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzkx.zza(paramT, k & 0xFFFFF, Integer.valueOf(paramzzka.zzh()));
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzb(paramT, i, j);
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzkx.zza(paramT, k & 0xFFFFF, Long.valueOf(paramzzka.zzf()));
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzb(paramT, i, j);
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzkx.zza(paramT, k & 0xFFFFF, Long.valueOf(paramzzka.zzg()));
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzb(paramT, i, j);
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzkx.zza(paramT, k & 0xFFFFF, Float.valueOf(paramzzka.zze()));
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzb(paramT, i, j);
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzkx.zza(paramT, k & 0xFFFFF, Double.valueOf(paramzzka.zzd()));
            localObject2 = localObject1;
            localObject4 = localObject1;
            zzb(paramT, i, j);
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            localObject7 = zzb(j);
            localObject2 = localObject1;
            localObject4 = localObject1;
            l = zzd(j) & 0xFFFFF;
            localObject2 = localObject1;
            localObject4 = localObject1;
            localObject6 = zzkx.zzf(paramT, l);
            if (localObject6 == null)
            {
              localObject2 = localObject1;
              localObject4 = localObject1;
              localObject3 = this.zzs.zzf(localObject7);
              localObject2 = localObject1;
              localObject4 = localObject1;
              zzkx.zza(paramT, l, localObject3);
            }
            else
            {
              localObject3 = localObject6;
              localObject2 = localObject1;
              localObject4 = localObject1;
              if (this.zzs.zzd(localObject6))
              {
                localObject2 = localObject1;
                localObject4 = localObject1;
                localObject3 = this.zzs.zzf(localObject7);
                localObject2 = localObject1;
                localObject4 = localObject1;
                this.zzs.zza(localObject3, localObject6);
                localObject2 = localObject1;
                localObject4 = localObject1;
                zzkx.zza(paramT, l, localObject3);
              }
            }
            localObject2 = localObject1;
            localObject4 = localObject1;
            paramzzka.zza(this.zzs.zza(localObject3), this.zzs.zzb(localObject7), paramzzhm);
            continue;
            l = k & 0xFFFFF;
            localObject2 = localObject1;
            localObject4 = localObject1;
            localObject3 = zza(j);
            localObject2 = localObject1;
            localObject4 = localObject1;
            paramzzka.zzb(this.zzp.zza(paramT, l), (zzjz)localObject3, paramzzhm);
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            paramzzka.zzq(this.zzp.zza(paramT, k & 0xFFFFF));
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            paramzzka.zzp(this.zzp.zza(paramT, k & 0xFFFFF));
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            paramzzka.zzo(this.zzp.zza(paramT, k & 0xFFFFF));
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            paramzzka.zzn(this.zzp.zza(paramT, k & 0xFFFFF));
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            localObject3 = this.zzp.zza(paramT, k & 0xFFFFF);
            localObject2 = localObject1;
            localObject4 = localObject1;
            paramzzka.zzm((List)localObject3);
            localObject2 = localObject1;
            localObject4 = localObject1;
            localObject1 = zzkb.zza(i, (List)localObject3, zzc(j), localObject1, localzzkr);
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            paramzzka.zzl(this.zzp.zza(paramT, k & 0xFFFFF));
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            paramzzka.zzh(this.zzp.zza(paramT, k & 0xFFFFF));
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            paramzzka.zzg(this.zzp.zza(paramT, k & 0xFFFFF));
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            paramzzka.zzf(this.zzp.zza(paramT, k & 0xFFFFF));
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            paramzzka.zze(this.zzp.zza(paramT, k & 0xFFFFF));
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            paramzzka.zzc(this.zzp.zza(paramT, k & 0xFFFFF));
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            paramzzka.zzd(this.zzp.zza(paramT, k & 0xFFFFF));
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            paramzzka.zzb(this.zzp.zza(paramT, k & 0xFFFFF));
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            paramzzka.zza(this.zzp.zza(paramT, k & 0xFFFFF));
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            paramzzka.zzq(this.zzp.zza(paramT, k & 0xFFFFF));
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            paramzzka.zzp(this.zzp.zza(paramT, k & 0xFFFFF));
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            paramzzka.zzo(this.zzp.zza(paramT, k & 0xFFFFF));
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            paramzzka.zzn(this.zzp.zza(paramT, k & 0xFFFFF));
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            localObject3 = this.zzp.zza(paramT, k & 0xFFFFF);
            localObject2 = localObject1;
            localObject4 = localObject1;
            paramzzka.zzm((List)localObject3);
            localObject2 = localObject1;
            localObject4 = localObject1;
            localObject1 = zzkb.zza(i, (List)localObject3, zzc(j), localObject1, localzzkr);
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            paramzzka.zzl(this.zzp.zza(paramT, k & 0xFFFFF));
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            paramzzka.zzk(this.zzp.zza(paramT, k & 0xFFFFF));
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            localObject3 = zza(j);
            l = k & 0xFFFFF;
            localObject2 = localObject1;
            localObject4 = localObject1;
            paramzzka.zza(this.zzp.zza(paramT, l), (zzjz)localObject3, paramzzhm);
            continue;
            localObject2 = localObject1;
            localObject4 = localObject1;
            if (zzf(k))
            {
              localObject2 = localObject1;
              localObject4 = localObject1;
              paramzzka.zzj(this.zzp.zza(paramT, k & 0xFFFFF));
            }
            else
            {
              localObject2 = localObject1;
              localObject4 = localObject1;
              paramzzka.zzi(this.zzp.zza(paramT, k & 0xFFFFF));
              continue;
              localObject2 = localObject1;
              localObject4 = localObject1;
              paramzzka.zzh(this.zzp.zza(paramT, k & 0xFFFFF));
              continue;
              localObject2 = localObject1;
              localObject4 = localObject1;
              paramzzka.zzg(this.zzp.zza(paramT, k & 0xFFFFF));
              continue;
              localObject2 = localObject1;
              localObject4 = localObject1;
              paramzzka.zzf(this.zzp.zza(paramT, k & 0xFFFFF));
              continue;
              localObject2 = localObject1;
              localObject4 = localObject1;
              paramzzka.zze(this.zzp.zza(paramT, k & 0xFFFFF));
              continue;
              localObject2 = localObject1;
              localObject4 = localObject1;
              paramzzka.zzc(this.zzp.zza(paramT, k & 0xFFFFF));
              continue;
              localObject2 = localObject1;
              localObject4 = localObject1;
              paramzzka.zzd(this.zzp.zza(paramT, k & 0xFFFFF));
              continue;
              localObject2 = localObject1;
              localObject4 = localObject1;
              paramzzka.zzb(this.zzp.zza(paramT, k & 0xFFFFF));
              continue;
              localObject2 = localObject1;
              localObject4 = localObject1;
              paramzzka.zza(this.zzp.zza(paramT, k & 0xFFFFF));
              continue;
              localObject2 = localObject1;
              localObject4 = localObject1;
              if (zza(paramT, j))
              {
                l = k & 0xFFFFF;
                localObject2 = localObject1;
                localObject4 = localObject1;
                zzkx.zza(paramT, l, zzic.zza(zzkx.zzf(paramT, l), paramzzka.zzb(zza(j), paramzzhm)));
              }
              else
              {
                localObject2 = localObject1;
                localObject4 = localObject1;
                zzkx.zza(paramT, k & 0xFFFFF, paramzzka.zzb(zza(j), paramzzhm));
                localObject2 = localObject1;
                localObject4 = localObject1;
                zzb(paramT, j);
                continue;
                localObject2 = localObject1;
                localObject4 = localObject1;
                zzkx.zza(paramT, k & 0xFFFFF, paramzzka.zzt());
                localObject2 = localObject1;
                localObject4 = localObject1;
                zzb(paramT, j);
                continue;
                localObject2 = localObject1;
                localObject4 = localObject1;
                zzkx.zza(paramT, k & 0xFFFFF, paramzzka.zzs());
                localObject2 = localObject1;
                localObject4 = localObject1;
                zzb(paramT, j);
                continue;
                localObject2 = localObject1;
                localObject4 = localObject1;
                zzkx.zza(paramT, k & 0xFFFFF, paramzzka.zzr());
                localObject2 = localObject1;
                localObject4 = localObject1;
                zzb(paramT, j);
                continue;
                localObject2 = localObject1;
                localObject4 = localObject1;
                zzkx.zza(paramT, k & 0xFFFFF, paramzzka.zzq());
                localObject2 = localObject1;
                localObject4 = localObject1;
                zzb(paramT, j);
                continue;
                localObject2 = localObject1;
                localObject4 = localObject1;
                m = paramzzka.zzp();
                localObject2 = localObject1;
                localObject4 = localObject1;
                localObject3 = zzc(j);
                if (localObject3 != null)
                {
                  localObject2 = localObject1;
                  localObject4 = localObject1;
                  if (!((zzid)localObject3).zza(m))
                  {
                    localObject2 = localObject1;
                    localObject4 = localObject1;
                    localObject1 = zzkb.zza(i, m, localObject1, localzzkr);
                    continue;
                  }
                }
                localObject2 = localObject1;
                localObject4 = localObject1;
                zzkx.zza(paramT, k & 0xFFFFF, m);
                localObject2 = localObject1;
                localObject4 = localObject1;
                zzb(paramT, j);
                continue;
                localObject2 = localObject1;
                localObject4 = localObject1;
                zzkx.zza(paramT, k & 0xFFFFF, paramzzka.zzo());
                localObject2 = localObject1;
                localObject4 = localObject1;
                zzb(paramT, j);
                continue;
                localObject2 = localObject1;
                localObject4 = localObject1;
                zzkx.zza(paramT, k & 0xFFFFF, paramzzka.zzn());
                localObject2 = localObject1;
                localObject4 = localObject1;
                zzb(paramT, j);
                continue;
                localObject2 = localObject1;
                localObject4 = localObject1;
                if (zza(paramT, j))
                {
                  l = k & 0xFFFFF;
                  localObject2 = localObject1;
                  localObject4 = localObject1;
                  zzkx.zza(paramT, l, zzic.zza(zzkx.zzf(paramT, l), paramzzka.zza(zza(j), paramzzhm)));
                }
                else
                {
                  localObject2 = localObject1;
                  localObject4 = localObject1;
                  zzkx.zza(paramT, k & 0xFFFFF, paramzzka.zza(zza(j), paramzzhm));
                  localObject2 = localObject1;
                  localObject4 = localObject1;
                  zzb(paramT, j);
                  continue;
                  localObject2 = localObject1;
                  localObject4 = localObject1;
                  zza(paramT, k, paramzzka);
                  localObject2 = localObject1;
                  localObject4 = localObject1;
                  zzb(paramT, j);
                  continue;
                  localObject2 = localObject1;
                  localObject4 = localObject1;
                  zzkx.zza(paramT, k & 0xFFFFF, paramzzka.zzk());
                  localObject2 = localObject1;
                  localObject4 = localObject1;
                  zzb(paramT, j);
                  continue;
                  localObject2 = localObject1;
                  localObject4 = localObject1;
                  zzkx.zza(paramT, k & 0xFFFFF, paramzzka.zzj());
                  localObject2 = localObject1;
                  localObject4 = localObject1;
                  zzb(paramT, j);
                  continue;
                  localObject2 = localObject1;
                  localObject4 = localObject1;
                  zzkx.zza(paramT, k & 0xFFFFF, paramzzka.zzi());
                  localObject2 = localObject1;
                  localObject4 = localObject1;
                  zzb(paramT, j);
                  continue;
                  localObject2 = localObject1;
                  localObject4 = localObject1;
                  zzkx.zza(paramT, k & 0xFFFFF, paramzzka.zzh());
                  localObject2 = localObject1;
                  localObject4 = localObject1;
                  zzb(paramT, j);
                  continue;
                  localObject2 = localObject1;
                  localObject4 = localObject1;
                  zzkx.zza(paramT, k & 0xFFFFF, paramzzka.zzf());
                  localObject2 = localObject1;
                  localObject4 = localObject1;
                  zzb(paramT, j);
                  continue;
                  localObject2 = localObject1;
                  localObject4 = localObject1;
                  zzkx.zza(paramT, k & 0xFFFFF, paramzzka.zzg());
                  localObject2 = localObject1;
                  localObject4 = localObject1;
                  zzb(paramT, j);
                  continue;
                  localObject2 = localObject1;
                  localObject4 = localObject1;
                  zzkx.zza(paramT, k & 0xFFFFF, paramzzka.zze());
                  localObject2 = localObject1;
                  localObject4 = localObject1;
                  zzb(paramT, j);
                  continue;
                  localObject2 = localObject1;
                  localObject4 = localObject1;
                  zzkx.zza(paramT, k & 0xFFFFF, paramzzka.zzd());
                  localObject2 = localObject1;
                  localObject4 = localObject1;
                  zzb(paramT, j);
                  continue;
                  localObject2 = localObject3;
                  localObject4 = localObject3;
                  bool = localzzkr.zza(localObject3, paramzzka);
                  localObject1 = localObject3;
                  if (!bool)
                  {
                    i = this.zzm;
                    while (i < this.zzn)
                    {
                      localObject3 = zza(paramT, this.zzl[i], localObject3, localzzkr);
                      i += 1;
                    }
                    if (localObject3 != null) {
                      localzzkr.zzb(paramT, localObject3);
                    }
                    return;
                  }
                }
              }
            }
          }
          catch (zzik localzzik)
          {
            break label4097;
          }
        }
        localObject2 = localObject4;
        localzzkr.zza(paramzzka);
        localObject3 = localObject4;
        if (localObject4 == null)
        {
          localObject2 = localObject4;
          localObject3 = localzzkr.zzc(paramT);
        }
        localObject2 = localObject3;
        bool = localzzkr.zza(localObject3, paramzzka);
        localObject1 = localObject3;
      } while (bool);
      i = this.zzm;
      while (i < this.zzn)
      {
        localObject3 = zza(paramT, this.zzl[i], localObject3, localzzkr);
        i += 1;
      }
      if (localObject3 != null) {
        localzzkr.zzb(paramT, localObject3);
      }
      return;
    }
    throw null;
  }
  
  public final void zza(T paramT, zzlo paramzzlo)
    throws IOException
  {
    Object localObject1;
    Iterator localIterator;
    label78:
    int i;
    Object localObject2;
    int j;
    int k;
    if (paramzzlo.zza() == zzln.zzb)
    {
      zza(this.zzq, paramT, paramzzlo);
      if (this.zzh)
      {
        localObject1 = this.zzr.zza(paramT);
        if (!((zzhp)localObject1).zza.isEmpty())
        {
          localIterator = ((zzhp)localObject1).zze();
          localObject1 = (Map.Entry)localIterator.next();
          break label78;
        }
      }
      localIterator = null;
      localObject1 = localIterator;
      i = this.zzc.length - 3;
      for (;;)
      {
        localObject2 = localObject1;
        if (i < 0) {
          break;
        }
        j = zzd(i);
        k = this.zzc[i];
        while ((localObject1 != null) && (this.zzr.zza((Map.Entry)localObject1) > k))
        {
          this.zzr.zza(paramzzlo, (Map.Entry)localObject1);
          if (localIterator.hasNext()) {
            localObject1 = (Map.Entry)localIterator.next();
          } else {
            localObject1 = null;
          }
        }
        switch ((j & 0xFF00000) >>> 20)
        {
        default: 
          break;
        case 68: 
          if (zza(paramT, k, i)) {
            paramzzlo.zzb(k, zzkx.zzf(paramT, j & 0xFFFFF), zza(i));
          }
          break;
        case 67: 
          if (zza(paramT, k, i)) {
            paramzzlo.zze(k, zze(paramT, j & 0xFFFFF));
          }
          break;
        case 66: 
          if (zza(paramT, k, i)) {
            paramzzlo.zzf(k, zzd(paramT, j & 0xFFFFF));
          }
          break;
        case 65: 
          if (zza(paramT, k, i)) {
            paramzzlo.zzb(k, zze(paramT, j & 0xFFFFF));
          }
          break;
        case 64: 
          if (zza(paramT, k, i)) {
            paramzzlo.zza(k, zzd(paramT, j & 0xFFFFF));
          }
          break;
        case 63: 
          if (zza(paramT, k, i)) {
            paramzzlo.zzb(k, zzd(paramT, j & 0xFFFFF));
          }
          break;
        case 62: 
          if (zza(paramT, k, i)) {
            paramzzlo.zze(k, zzd(paramT, j & 0xFFFFF));
          }
          break;
        case 61: 
          if (zza(paramT, k, i)) {
            paramzzlo.zza(k, (zzgr)zzkx.zzf(paramT, j & 0xFFFFF));
          }
          break;
        case 60: 
          if (zza(paramT, k, i)) {
            paramzzlo.zza(k, zzkx.zzf(paramT, j & 0xFFFFF), zza(i));
          }
          break;
        case 59: 
          if (zza(paramT, k, i)) {
            zza(k, zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo);
          }
          break;
        case 58: 
          if (zza(paramT, k, i)) {
            paramzzlo.zza(k, zzf(paramT, j & 0xFFFFF));
          }
          break;
        case 57: 
          if (zza(paramT, k, i)) {
            paramzzlo.zzd(k, zzd(paramT, j & 0xFFFFF));
          }
          break;
        case 56: 
          if (zza(paramT, k, i)) {
            paramzzlo.zzd(k, zze(paramT, j & 0xFFFFF));
          }
          break;
        case 55: 
          if (zza(paramT, k, i)) {
            paramzzlo.zzc(k, zzd(paramT, j & 0xFFFFF));
          }
          break;
        case 54: 
          if (zza(paramT, k, i)) {
            paramzzlo.zzc(k, zze(paramT, j & 0xFFFFF));
          }
          break;
        case 53: 
          if (zza(paramT, k, i)) {
            paramzzlo.zza(k, zze(paramT, j & 0xFFFFF));
          }
          break;
        case 52: 
          if (zza(paramT, k, i)) {
            paramzzlo.zza(k, zzc(paramT, j & 0xFFFFF));
          }
          break;
        case 51: 
          if (zza(paramT, k, i)) {
            paramzzlo.zza(k, zzb(paramT, j & 0xFFFFF));
          }
          break;
        case 50: 
          zza(paramzzlo, k, zzkx.zzf(paramT, j & 0xFFFFF), i);
          break;
        case 49: 
          zzkb.zzb(this.zzc[i], (List)zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo, zza(i));
          break;
        case 48: 
          zzkb.zze(this.zzc[i], (List)zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo, true);
          break;
        case 47: 
          zzkb.zzj(this.zzc[i], (List)zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo, true);
          break;
        case 46: 
          zzkb.zzg(this.zzc[i], (List)zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo, true);
          break;
        case 45: 
          zzkb.zzl(this.zzc[i], (List)zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo, true);
          break;
        case 44: 
          zzkb.zzm(this.zzc[i], (List)zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo, true);
          break;
        case 43: 
          zzkb.zzi(this.zzc[i], (List)zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo, true);
          break;
        case 42: 
          zzkb.zzn(this.zzc[i], (List)zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo, true);
          break;
        case 41: 
          zzkb.zzk(this.zzc[i], (List)zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo, true);
          break;
        case 40: 
          zzkb.zzf(this.zzc[i], (List)zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo, true);
          break;
        case 39: 
          zzkb.zzh(this.zzc[i], (List)zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo, true);
          break;
        case 38: 
          zzkb.zzd(this.zzc[i], (List)zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo, true);
          break;
        case 37: 
          zzkb.zzc(this.zzc[i], (List)zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo, true);
          break;
        case 36: 
          zzkb.zzb(this.zzc[i], (List)zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo, true);
          break;
        case 35: 
          zzkb.zza(this.zzc[i], (List)zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo, true);
          break;
        case 34: 
          zzkb.zze(this.zzc[i], (List)zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo, false);
          break;
        case 33: 
          zzkb.zzj(this.zzc[i], (List)zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo, false);
          break;
        case 32: 
          zzkb.zzg(this.zzc[i], (List)zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo, false);
          break;
        case 31: 
          zzkb.zzl(this.zzc[i], (List)zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo, false);
          break;
        case 30: 
          zzkb.zzm(this.zzc[i], (List)zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo, false);
          break;
        case 29: 
          zzkb.zzi(this.zzc[i], (List)zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo, false);
          break;
        case 28: 
          zzkb.zzb(this.zzc[i], (List)zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo);
          break;
        case 27: 
          zzkb.zza(this.zzc[i], (List)zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo, zza(i));
          break;
        case 26: 
          zzkb.zza(this.zzc[i], (List)zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo);
          break;
        case 25: 
          zzkb.zzn(this.zzc[i], (List)zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo, false);
          break;
        case 24: 
          zzkb.zzk(this.zzc[i], (List)zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo, false);
          break;
        case 23: 
          zzkb.zzf(this.zzc[i], (List)zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo, false);
          break;
        case 22: 
          zzkb.zzh(this.zzc[i], (List)zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo, false);
          break;
        case 21: 
          zzkb.zzd(this.zzc[i], (List)zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo, false);
          break;
        case 20: 
          zzkb.zzc(this.zzc[i], (List)zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo, false);
          break;
        case 19: 
          zzkb.zzb(this.zzc[i], (List)zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo, false);
          break;
        case 18: 
          zzkb.zza(this.zzc[i], (List)zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo, false);
          break;
        case 17: 
          if (zza(paramT, i)) {
            paramzzlo.zzb(k, zzkx.zzf(paramT, j & 0xFFFFF), zza(i));
          }
          break;
        case 16: 
          if (zza(paramT, i)) {
            paramzzlo.zze(k, zzkx.zzb(paramT, j & 0xFFFFF));
          }
          break;
        case 15: 
          if (zza(paramT, i)) {
            paramzzlo.zzf(k, zzkx.zza(paramT, j & 0xFFFFF));
          }
          break;
        case 14: 
          if (zza(paramT, i)) {
            paramzzlo.zzb(k, zzkx.zzb(paramT, j & 0xFFFFF));
          }
          break;
        case 13: 
          if (zza(paramT, i)) {
            paramzzlo.zza(k, zzkx.zza(paramT, j & 0xFFFFF));
          }
          break;
        case 12: 
          if (zza(paramT, i)) {
            paramzzlo.zzb(k, zzkx.zza(paramT, j & 0xFFFFF));
          }
          break;
        case 11: 
          if (zza(paramT, i)) {
            paramzzlo.zze(k, zzkx.zza(paramT, j & 0xFFFFF));
          }
          break;
        case 10: 
          if (zza(paramT, i)) {
            paramzzlo.zza(k, (zzgr)zzkx.zzf(paramT, j & 0xFFFFF));
          }
          break;
        case 9: 
          if (zza(paramT, i)) {
            paramzzlo.zza(k, zzkx.zzf(paramT, j & 0xFFFFF), zza(i));
          }
          break;
        case 8: 
          if (zza(paramT, i)) {
            zza(k, zzkx.zzf(paramT, j & 0xFFFFF), paramzzlo);
          }
          break;
        case 7: 
          if (zza(paramT, i)) {
            paramzzlo.zza(k, zzkx.zzc(paramT, j & 0xFFFFF));
          }
          break;
        case 6: 
          if (zza(paramT, i)) {
            paramzzlo.zzd(k, zzkx.zza(paramT, j & 0xFFFFF));
          }
          break;
        case 5: 
          if (zza(paramT, i)) {
            paramzzlo.zzd(k, zzkx.zzb(paramT, j & 0xFFFFF));
          }
          break;
        case 4: 
          if (zza(paramT, i)) {
            paramzzlo.zzc(k, zzkx.zza(paramT, j & 0xFFFFF));
          }
          break;
        case 3: 
          if (zza(paramT, i)) {
            paramzzlo.zzc(k, zzkx.zzb(paramT, j & 0xFFFFF));
          }
          break;
        case 2: 
          if (zza(paramT, i)) {
            paramzzlo.zza(k, zzkx.zzb(paramT, j & 0xFFFFF));
          }
          break;
        case 1: 
          if (zza(paramT, i)) {
            paramzzlo.zza(k, zzkx.zzd(paramT, j & 0xFFFFF));
          }
          break;
        case 0: 
          if (zza(paramT, i)) {
            paramzzlo.zza(k, zzkx.zze(paramT, j & 0xFFFFF));
          }
          break;
        }
        i -= 3;
      }
      while (localObject2 != null)
      {
        this.zzr.zza(paramzzlo, (Map.Entry)localObject2);
        if (localIterator.hasNext()) {
          localObject2 = (Map.Entry)localIterator.next();
        } else {
          localObject2 = null;
        }
      }
      return;
    }
    if (this.zzj)
    {
      if (this.zzh)
      {
        localObject1 = this.zzr.zza(paramT);
        if (!((zzhp)localObject1).zza.isEmpty())
        {
          localIterator = ((zzhp)localObject1).zzd();
          localObject1 = (Map.Entry)localIterator.next();
          break label2615;
        }
      }
      localIterator = null;
      localObject1 = localIterator;
      label2615:
      j = this.zzc.length;
      i = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (i >= j) {
          break;
        }
        k = zzd(i);
        int m = this.zzc[i];
        while ((localObject1 != null) && (this.zzr.zza((Map.Entry)localObject1) <= m))
        {
          this.zzr.zza(paramzzlo, (Map.Entry)localObject1);
          if (localIterator.hasNext()) {
            localObject1 = (Map.Entry)localIterator.next();
          } else {
            localObject1 = null;
          }
        }
        switch ((k & 0xFF00000) >>> 20)
        {
        default: 
          break;
        case 68: 
          if (zza(paramT, m, i)) {
            paramzzlo.zzb(m, zzkx.zzf(paramT, k & 0xFFFFF), zza(i));
          }
          break;
        case 67: 
          if (zza(paramT, m, i)) {
            paramzzlo.zze(m, zze(paramT, k & 0xFFFFF));
          }
          break;
        case 66: 
          if (zza(paramT, m, i)) {
            paramzzlo.zzf(m, zzd(paramT, k & 0xFFFFF));
          }
          break;
        case 65: 
          if (zza(paramT, m, i)) {
            paramzzlo.zzb(m, zze(paramT, k & 0xFFFFF));
          }
          break;
        case 64: 
          if (zza(paramT, m, i)) {
            paramzzlo.zza(m, zzd(paramT, k & 0xFFFFF));
          }
          break;
        case 63: 
          if (zza(paramT, m, i)) {
            paramzzlo.zzb(m, zzd(paramT, k & 0xFFFFF));
          }
          break;
        case 62: 
          if (zza(paramT, m, i)) {
            paramzzlo.zze(m, zzd(paramT, k & 0xFFFFF));
          }
          break;
        case 61: 
          if (zza(paramT, m, i)) {
            paramzzlo.zza(m, (zzgr)zzkx.zzf(paramT, k & 0xFFFFF));
          }
          break;
        case 60: 
          if (zza(paramT, m, i)) {
            paramzzlo.zza(m, zzkx.zzf(paramT, k & 0xFFFFF), zza(i));
          }
          break;
        case 59: 
          if (zza(paramT, m, i)) {
            zza(m, zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo);
          }
          break;
        case 58: 
          if (zza(paramT, m, i)) {
            paramzzlo.zza(m, zzf(paramT, k & 0xFFFFF));
          }
          break;
        case 57: 
          if (zza(paramT, m, i)) {
            paramzzlo.zzd(m, zzd(paramT, k & 0xFFFFF));
          }
          break;
        case 56: 
          if (zza(paramT, m, i)) {
            paramzzlo.zzd(m, zze(paramT, k & 0xFFFFF));
          }
          break;
        case 55: 
          if (zza(paramT, m, i)) {
            paramzzlo.zzc(m, zzd(paramT, k & 0xFFFFF));
          }
          break;
        case 54: 
          if (zza(paramT, m, i)) {
            paramzzlo.zzc(m, zze(paramT, k & 0xFFFFF));
          }
          break;
        case 53: 
          if (zza(paramT, m, i)) {
            paramzzlo.zza(m, zze(paramT, k & 0xFFFFF));
          }
          break;
        case 52: 
          if (zza(paramT, m, i)) {
            paramzzlo.zza(m, zzc(paramT, k & 0xFFFFF));
          }
          break;
        case 51: 
          if (zza(paramT, m, i)) {
            paramzzlo.zza(m, zzb(paramT, k & 0xFFFFF));
          }
          break;
        case 50: 
          zza(paramzzlo, m, zzkx.zzf(paramT, k & 0xFFFFF), i);
          break;
        case 49: 
          zzkb.zzb(this.zzc[i], (List)zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo, zza(i));
          break;
        case 48: 
          zzkb.zze(this.zzc[i], (List)zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo, true);
          break;
        case 47: 
          zzkb.zzj(this.zzc[i], (List)zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo, true);
          break;
        case 46: 
          zzkb.zzg(this.zzc[i], (List)zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo, true);
          break;
        case 45: 
          zzkb.zzl(this.zzc[i], (List)zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo, true);
          break;
        case 44: 
          zzkb.zzm(this.zzc[i], (List)zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo, true);
          break;
        case 43: 
          zzkb.zzi(this.zzc[i], (List)zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo, true);
          break;
        case 42: 
          zzkb.zzn(this.zzc[i], (List)zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo, true);
          break;
        case 41: 
          zzkb.zzk(this.zzc[i], (List)zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo, true);
          break;
        case 40: 
          zzkb.zzf(this.zzc[i], (List)zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo, true);
          break;
        case 39: 
          zzkb.zzh(this.zzc[i], (List)zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo, true);
          break;
        case 38: 
          zzkb.zzd(this.zzc[i], (List)zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo, true);
          break;
        case 37: 
          zzkb.zzc(this.zzc[i], (List)zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo, true);
          break;
        case 36: 
          zzkb.zzb(this.zzc[i], (List)zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo, true);
          break;
        case 35: 
          zzkb.zza(this.zzc[i], (List)zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo, true);
          break;
        case 34: 
          zzkb.zze(this.zzc[i], (List)zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo, false);
          break;
        case 33: 
          zzkb.zzj(this.zzc[i], (List)zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo, false);
          break;
        case 32: 
          zzkb.zzg(this.zzc[i], (List)zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo, false);
          break;
        case 31: 
          zzkb.zzl(this.zzc[i], (List)zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo, false);
          break;
        case 30: 
          zzkb.zzm(this.zzc[i], (List)zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo, false);
          break;
        case 29: 
          zzkb.zzi(this.zzc[i], (List)zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo, false);
          break;
        case 28: 
          zzkb.zzb(this.zzc[i], (List)zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo);
          break;
        case 27: 
          zzkb.zza(this.zzc[i], (List)zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo, zza(i));
          break;
        case 26: 
          zzkb.zza(this.zzc[i], (List)zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo);
          break;
        case 25: 
          zzkb.zzn(this.zzc[i], (List)zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo, false);
          break;
        case 24: 
          zzkb.zzk(this.zzc[i], (List)zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo, false);
          break;
        case 23: 
          zzkb.zzf(this.zzc[i], (List)zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo, false);
          break;
        case 22: 
          zzkb.zzh(this.zzc[i], (List)zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo, false);
          break;
        case 21: 
          zzkb.zzd(this.zzc[i], (List)zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo, false);
          break;
        case 20: 
          zzkb.zzc(this.zzc[i], (List)zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo, false);
          break;
        case 19: 
          zzkb.zzb(this.zzc[i], (List)zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo, false);
          break;
        case 18: 
          zzkb.zza(this.zzc[i], (List)zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo, false);
          break;
        case 17: 
          if (zza(paramT, i)) {
            paramzzlo.zzb(m, zzkx.zzf(paramT, k & 0xFFFFF), zza(i));
          }
          break;
        case 16: 
          if (zza(paramT, i)) {
            paramzzlo.zze(m, zzkx.zzb(paramT, k & 0xFFFFF));
          }
          break;
        case 15: 
          if (zza(paramT, i)) {
            paramzzlo.zzf(m, zzkx.zza(paramT, k & 0xFFFFF));
          }
          break;
        case 14: 
          if (zza(paramT, i)) {
            paramzzlo.zzb(m, zzkx.zzb(paramT, k & 0xFFFFF));
          }
          break;
        case 13: 
          if (zza(paramT, i)) {
            paramzzlo.zza(m, zzkx.zza(paramT, k & 0xFFFFF));
          }
          break;
        case 12: 
          if (zza(paramT, i)) {
            paramzzlo.zzb(m, zzkx.zza(paramT, k & 0xFFFFF));
          }
          break;
        case 11: 
          if (zza(paramT, i)) {
            paramzzlo.zze(m, zzkx.zza(paramT, k & 0xFFFFF));
          }
          break;
        case 10: 
          if (zza(paramT, i)) {
            paramzzlo.zza(m, (zzgr)zzkx.zzf(paramT, k & 0xFFFFF));
          }
          break;
        case 9: 
          if (zza(paramT, i)) {
            paramzzlo.zza(m, zzkx.zzf(paramT, k & 0xFFFFF), zza(i));
          }
          break;
        case 8: 
          if (zza(paramT, i)) {
            zza(m, zzkx.zzf(paramT, k & 0xFFFFF), paramzzlo);
          }
          break;
        case 7: 
          if (zza(paramT, i)) {
            paramzzlo.zza(m, zzkx.zzc(paramT, k & 0xFFFFF));
          }
          break;
        case 6: 
          if (zza(paramT, i)) {
            paramzzlo.zzd(m, zzkx.zza(paramT, k & 0xFFFFF));
          }
          break;
        case 5: 
          if (zza(paramT, i)) {
            paramzzlo.zzd(m, zzkx.zzb(paramT, k & 0xFFFFF));
          }
          break;
        case 4: 
          if (zza(paramT, i)) {
            paramzzlo.zzc(m, zzkx.zza(paramT, k & 0xFFFFF));
          }
          break;
        case 3: 
          if (zza(paramT, i)) {
            paramzzlo.zzc(m, zzkx.zzb(paramT, k & 0xFFFFF));
          }
          break;
        case 2: 
          if (zza(paramT, i)) {
            paramzzlo.zza(m, zzkx.zzb(paramT, k & 0xFFFFF));
          }
          break;
        case 1: 
          if (zza(paramT, i)) {
            paramzzlo.zza(m, zzkx.zzd(paramT, k & 0xFFFFF));
          }
          break;
        case 0: 
          if (zza(paramT, i)) {
            paramzzlo.zza(m, zzkx.zze(paramT, k & 0xFFFFF));
          }
          break;
        }
        i += 3;
      }
      while (localObject2 != null)
      {
        this.zzr.zza(paramzzlo, (Map.Entry)localObject2);
        if (localIterator.hasNext()) {
          localObject2 = (Map.Entry)localIterator.next();
        } else {
          localObject2 = null;
        }
      }
      zza(this.zzq, paramT, paramzzlo);
      return;
    }
    zzb(paramT, paramzzlo);
  }
  
  public final void zza(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2, zzgm paramzzgm)
    throws IOException
  {
    zzjl localzzjl = this;
    T ? = paramT;
    byte[] arrayOfByte = paramArrayOfByte;
    int i1 = paramInt2;
    zzgm localzzgm = paramzzgm;
    if (localzzjl.zzj)
    {
      Object localObject1 = zzb;
      int n = paramInt1;
      int m = -1;
      int i = 0;
      paramInt1 = 0;
      int k = 1048575;
      while (n < i1)
      {
        int j = n + 1;
        int i2 = arrayOfByte[n];
        if (i2 < 0)
        {
          j = zzgn.zza(i2, arrayOfByte, j, localzzgm);
          i2 = localzzgm.zza;
        }
        n = i2 >>> 3;
        int i5 = i2 & 0x7;
        if (n > m) {
          i = localzzjl.zza(n, i / 3);
        } else {
          i = localzzjl.zzg(n);
        }
        if (i == -1) {
          i = 0;
        }
        for (;;)
        {
          break;
          Object localObject2 = localzzjl.zzc;
          int i6 = localObject2[(i + 1)];
          int i7 = (i6 & 0xFF00000) >>> 20;
          long l1 = i6 & 0xFFFFF;
          int i4;
          Object localObject3;
          int i3;
          if (i7 <= 17)
          {
            m = localObject2[(i + 2)];
            i4 = 1 << (m >>> 20);
            m &= 0xFFFFF;
            if (m != k)
            {
              if (k != 1048575) {
                ((Unsafe)localObject1).putInt(?, k, paramInt1);
              }
              if (m != 1048575) {
                paramInt1 = ((Unsafe)localObject1).getInt(?, m);
              }
              k = m;
              m = paramInt1;
            }
            else
            {
              m = paramInt1;
            }
            switch (i7)
            {
            default: 
              break;
            case 16: 
              if (i5 == 0)
              {
                paramInt1 = zzgn.zzb(arrayOfByte, j, localzzgm);
                long l2 = zzhd.zza(localzzgm.zzb);
                ((Unsafe)localObject1).putLong(paramT, l1, l2);
                j = m | i4;
                break label1047;
              }
              break;
            case 15: 
              if (i5 == 0)
              {
                paramInt1 = zzgn.zza(arrayOfByte, j, localzzgm);
                ((Unsafe)localObject1).putInt(?, l1, zzhd.zze(localzzgm.zza));
              }
              break;
            case 12: 
              if (i5 == 0)
              {
                paramInt1 = zzgn.zza(arrayOfByte, j, localzzgm);
                ((Unsafe)localObject1).putInt(?, l1, localzzgm.zza);
              }
              break;
            case 10: 
              if (i5 == 2)
              {
                paramInt1 = zzgn.zze(arrayOfByte, j, localzzgm);
                ((Unsafe)localObject1).putObject(?, l1, localzzgm.zzc);
              }
              break;
            case 9: 
              localObject2 = localObject1;
              if (i5 == 2)
              {
                paramInt1 = zzgn.zza(localzzjl.zza(i), arrayOfByte, j, i1, localzzgm);
                localObject3 = ((Unsafe)localObject2).getObject(?, l1);
                if (localObject3 == null) {
                  ((Unsafe)localObject2).putObject(?, l1, localzzgm.zzc);
                } else {
                  ((Unsafe)localObject2).putObject(?, l1, zzic.zza(localObject3, localzzgm.zzc));
                }
              }
              break;
            case 8: 
              if (i5 == 2)
              {
                if ((i6 & 0x20000000) == 0) {
                  paramInt1 = zzgn.zzc(arrayOfByte, j, localzzgm);
                } else {
                  paramInt1 = zzgn.zzd(arrayOfByte, j, localzzgm);
                }
                ((Unsafe)localObject1).putObject(?, l1, localzzgm.zzc);
              }
              break;
            case 7: 
              if (i5 == 0)
              {
                paramInt1 = zzgn.zzb(arrayOfByte, j, localzzgm);
                boolean bool;
                if (localzzgm.zzb != 0L) {
                  bool = true;
                } else {
                  bool = false;
                }
                zzkx.zza(?, l1, bool);
              }
              break;
            case 6: 
            case 13: 
              if (i5 == 5)
              {
                ((Unsafe)localObject1).putInt(?, l1, zzgn.zza(arrayOfByte, j));
                paramInt1 = j + 4;
              }
              break;
            case 5: 
            case 14: 
              if (i5 == 1)
              {
                ((Unsafe)localObject1).putLong(paramT, l1, zzgn.zzb(arrayOfByte, j));
                paramInt1 = j + 8;
                break label900;
              }
              break;
            case 4: 
            case 11: 
              if (i5 != 0) {
                break;
              }
              paramInt1 = zzgn.zza(arrayOfByte, j, localzzgm);
              ((Unsafe)localObject1).putInt(?, l1, localzzgm.zza);
              break;
            case 2: 
            case 3: 
              i3 = k;
              localObject2 = localObject1;
              if (i5 != 0) {
                break;
              }
              paramInt1 = zzgn.zzb(arrayOfByte, j, localzzgm);
              ((Unsafe)localObject2).putLong(paramT, l1, localzzgm.zzb);
              j = m | i4;
              localObject1 = localObject2;
              k = i3;
              break;
            case 1: 
              paramInt1 = j;
              if (i5 != 5) {
                break;
              }
              zzkx.zza(?, l1, zzgn.zzd(arrayOfByte, paramInt1));
              paramInt1 += 4;
              break;
            }
            paramInt1 = j;
            if (i5 == 1)
            {
              zzkx.zza(?, l1, zzgn.zzc(arrayOfByte, paramInt1));
              paramInt1 += 8;
              label900:
              j = m | i4;
            }
            else
            {
              paramInt1 = m;
            }
          }
          else
          {
            i3 = n;
            m = k;
            if (i7 != 27) {
              break label1059;
            }
            if (i5 != 2) {
              break label1056;
            }
            localObject3 = (zzii)((Unsafe)localObject1).getObject(?, l1);
            localObject2 = localObject3;
            if (!((zzii)localObject3).zza())
            {
              k = ((zzii)localObject3).size();
              if (k == 0) {
                k = 10;
              } else {
                k <<= 1;
              }
              localObject2 = ((zzii)localObject3).zza(k);
              ((Unsafe)localObject1).putObject(?, l1, localObject2);
            }
            i2 = zzgn.zza(localzzjl.zza(i), i2, paramArrayOfByte, j, paramInt2, (zzii)localObject2, paramzzgm);
            k = m;
            j = paramInt1;
            paramInt1 = i2;
          }
          label1047:
          m = paramInt1;
          paramInt1 = n;
          break label1265;
          label1056:
          break label1179;
          label1059:
          i1 = i;
          if (i7 <= 49)
          {
            i4 = zza(paramT, paramArrayOfByte, j, paramInt2, i2, i3, i5, i1, i6, i7, l1, paramzzgm);
            m = i4;
            if (i4 == j)
            {
              j = i4;
              break label1221;
            }
          }
          for (;;)
          {
            i = i1;
            j = paramInt1;
            paramInt1 = i3;
            break label1248;
            i4 = j;
            if (i7 == 50) {
              if (i5 == 2)
              {
                j = zza(paramT, paramArrayOfByte, i4, paramInt2, i1, l1, paramzzgm);
                m = j;
                if (j == i4) {
                  break label1221;
                }
              }
            }
          }
          label1179:
          label1221:
          for (;;)
          {
            break label1224;
            j = zza(paramT, paramArrayOfByte, i4, paramInt2, i2, i3, i5, i6, i7, l1, i1, paramzzgm);
            m = j;
            if (j != i4) {
              break;
            }
          }
        }
        label1224:
        m = zzgn.zza(i2, paramArrayOfByte, j, paramInt2, zze(paramT), paramzzgm);
        j = paramInt1;
        paramInt1 = n;
        label1248:
        localzzjl = this;
        ? = paramT;
        i1 = paramInt2;
        arrayOfByte = paramArrayOfByte;
        localzzgm = paramzzgm;
        label1265:
        n = m;
        m = paramInt1;
        paramInt1 = j;
      }
      if (k != 1048575) {
        ((Unsafe)localObject1).putInt(paramT, k, paramInt1);
      }
      if (n == paramInt2) {
        return;
      }
      throw zzih.zzg();
    }
    zza(paramT, paramArrayOfByte, paramInt1, paramInt2, 0, paramzzgm);
  }
  
  /* Error */
  public final boolean zza(T paramT1, T paramT2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 57	com/google/android/gms/internal/measurement/zzjl:zzc	[I
    //   4: arraylength
    //   5: istore 4
    //   7: iconst_0
    //   8: istore_3
    //   9: iconst_1
    //   10: istore 6
    //   12: iload_3
    //   13: iload 4
    //   15: if_icmpge +955 -> 970
    //   18: aload_0
    //   19: iload_3
    //   20: invokespecial 520	com/google/android/gms/internal/measurement/zzjl:zzd	(I)I
    //   23: istore 5
    //   25: iload 5
    //   27: ldc 115
    //   29: iand
    //   30: i2l
    //   31: lstore 7
    //   33: iload 5
    //   35: ldc_w 618
    //   38: iand
    //   39: bipush 20
    //   41: iushr
    //   42: tableswitch	default:+290->332, 0:+879->921, 1:+845->887, 2:+816->858, 3:+787->829, 4:+759->801, 5:+730->772, 6:+702->744, 7:+674->716, 8:+643->685, 9:+612->654, 10:+581->623, 11:+553->595, 12:+525->567, 13:+497->539, 14:+468->510, 15:+440->482, 16:+411->453, 17:+380->422, 18:+360->402, 19:+360->402, 20:+360->402, 21:+360->402, 22:+360->402, 23:+360->402, 24:+360->402, 25:+360->402, 26:+360->402, 27:+360->402, 28:+360->402, 29:+360->402, 30:+360->402, 31:+360->402, 32:+360->402, 33:+360->402, 34:+360->402, 35:+360->402, 36:+360->402, 37:+360->402, 38:+360->402, 39:+360->402, 40:+360->402, 41:+360->402, 42:+360->402, 43:+360->402, 44:+360->402, 45:+360->402, 46:+360->402, 47:+360->402, 48:+360->402, 49:+360->402, 50:+340->382, 51:+293->335, 52:+293->335, 53:+293->335, 54:+293->335, 55:+293->335, 56:+293->335, 57:+293->335, 58:+293->335, 59:+293->335, 60:+293->335, 61:+293->335, 62:+293->335, 63:+293->335, 64:+293->335, 65:+293->335, 66:+293->335, 67:+293->335, 68:+293->335
    //   332: goto +624 -> 956
    //   335: aload_0
    //   336: iload_3
    //   337: invokespecial 615	com/google/android/gms/internal/measurement/zzjl:zze	(I)I
    //   340: ldc 115
    //   342: iand
    //   343: i2l
    //   344: lstore 9
    //   346: aload_1
    //   347: lload 9
    //   349: invokestatic 626	com/google/android/gms/internal/measurement/zzkx:zza	(Ljava/lang/Object;J)I
    //   352: aload_2
    //   353: lload 9
    //   355: invokestatic 626	com/google/android/gms/internal/measurement/zzkx:zza	(Ljava/lang/Object;J)I
    //   358: if_icmpne +595 -> 953
    //   361: aload_1
    //   362: lload 7
    //   364: invokestatic 522	com/google/android/gms/internal/measurement/zzkx:zzf	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   367: aload_2
    //   368: lload 7
    //   370: invokestatic 522	com/google/android/gms/internal/measurement/zzkx:zzf	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   373: invokestatic 999	com/google/android/gms/internal/measurement/zzkb:zza	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   376: ifne +580 -> 956
    //   379: goto +574 -> 953
    //   382: aload_1
    //   383: lload 7
    //   385: invokestatic 522	com/google/android/gms/internal/measurement/zzkx:zzf	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   388: aload_2
    //   389: lload 7
    //   391: invokestatic 522	com/google/android/gms/internal/measurement/zzkx:zzf	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   394: invokestatic 999	com/google/android/gms/internal/measurement/zzkb:zza	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   397: istore 6
    //   399: goto +557 -> 956
    //   402: aload_1
    //   403: lload 7
    //   405: invokestatic 522	com/google/android/gms/internal/measurement/zzkx:zzf	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   408: aload_2
    //   409: lload 7
    //   411: invokestatic 522	com/google/android/gms/internal/measurement/zzkx:zzf	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   414: invokestatic 999	com/google/android/gms/internal/measurement/zzkb:zza	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   417: istore 6
    //   419: goto +537 -> 956
    //   422: aload_0
    //   423: aload_1
    //   424: aload_2
    //   425: iload_3
    //   426: invokespecial 1001	com/google/android/gms/internal/measurement/zzjl:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   429: ifeq +524 -> 953
    //   432: aload_1
    //   433: lload 7
    //   435: invokestatic 522	com/google/android/gms/internal/measurement/zzkx:zzf	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   438: aload_2
    //   439: lload 7
    //   441: invokestatic 522	com/google/android/gms/internal/measurement/zzkx:zzf	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   444: invokestatic 999	com/google/android/gms/internal/measurement/zzkb:zza	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   447: ifne +509 -> 956
    //   450: goto +503 -> 953
    //   453: aload_0
    //   454: aload_1
    //   455: aload_2
    //   456: iload_3
    //   457: invokespecial 1001	com/google/android/gms/internal/measurement/zzjl:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   460: ifeq +493 -> 953
    //   463: aload_1
    //   464: lload 7
    //   466: invokestatic 624	com/google/android/gms/internal/measurement/zzkx:zzb	(Ljava/lang/Object;J)J
    //   469: aload_2
    //   470: lload 7
    //   472: invokestatic 624	com/google/android/gms/internal/measurement/zzkx:zzb	(Ljava/lang/Object;J)J
    //   475: lcmp
    //   476: ifeq +480 -> 956
    //   479: goto +474 -> 953
    //   482: aload_0
    //   483: aload_1
    //   484: aload_2
    //   485: iload_3
    //   486: invokespecial 1001	com/google/android/gms/internal/measurement/zzjl:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   489: ifeq +464 -> 953
    //   492: aload_1
    //   493: lload 7
    //   495: invokestatic 626	com/google/android/gms/internal/measurement/zzkx:zza	(Ljava/lang/Object;J)I
    //   498: aload_2
    //   499: lload 7
    //   501: invokestatic 626	com/google/android/gms/internal/measurement/zzkx:zza	(Ljava/lang/Object;J)I
    //   504: if_icmpeq +452 -> 956
    //   507: goto +446 -> 953
    //   510: aload_0
    //   511: aload_1
    //   512: aload_2
    //   513: iload_3
    //   514: invokespecial 1001	com/google/android/gms/internal/measurement/zzjl:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   517: ifeq +436 -> 953
    //   520: aload_1
    //   521: lload 7
    //   523: invokestatic 624	com/google/android/gms/internal/measurement/zzkx:zzb	(Ljava/lang/Object;J)J
    //   526: aload_2
    //   527: lload 7
    //   529: invokestatic 624	com/google/android/gms/internal/measurement/zzkx:zzb	(Ljava/lang/Object;J)J
    //   532: lcmp
    //   533: ifeq +423 -> 956
    //   536: goto +417 -> 953
    //   539: aload_0
    //   540: aload_1
    //   541: aload_2
    //   542: iload_3
    //   543: invokespecial 1001	com/google/android/gms/internal/measurement/zzjl:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   546: ifeq +407 -> 953
    //   549: aload_1
    //   550: lload 7
    //   552: invokestatic 626	com/google/android/gms/internal/measurement/zzkx:zza	(Ljava/lang/Object;J)I
    //   555: aload_2
    //   556: lload 7
    //   558: invokestatic 626	com/google/android/gms/internal/measurement/zzkx:zza	(Ljava/lang/Object;J)I
    //   561: if_icmpeq +395 -> 956
    //   564: goto +389 -> 953
    //   567: aload_0
    //   568: aload_1
    //   569: aload_2
    //   570: iload_3
    //   571: invokespecial 1001	com/google/android/gms/internal/measurement/zzjl:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   574: ifeq +379 -> 953
    //   577: aload_1
    //   578: lload 7
    //   580: invokestatic 626	com/google/android/gms/internal/measurement/zzkx:zza	(Ljava/lang/Object;J)I
    //   583: aload_2
    //   584: lload 7
    //   586: invokestatic 626	com/google/android/gms/internal/measurement/zzkx:zza	(Ljava/lang/Object;J)I
    //   589: if_icmpeq +367 -> 956
    //   592: goto +361 -> 953
    //   595: aload_0
    //   596: aload_1
    //   597: aload_2
    //   598: iload_3
    //   599: invokespecial 1001	com/google/android/gms/internal/measurement/zzjl:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   602: ifeq +351 -> 953
    //   605: aload_1
    //   606: lload 7
    //   608: invokestatic 626	com/google/android/gms/internal/measurement/zzkx:zza	(Ljava/lang/Object;J)I
    //   611: aload_2
    //   612: lload 7
    //   614: invokestatic 626	com/google/android/gms/internal/measurement/zzkx:zza	(Ljava/lang/Object;J)I
    //   617: if_icmpeq +339 -> 956
    //   620: goto +333 -> 953
    //   623: aload_0
    //   624: aload_1
    //   625: aload_2
    //   626: iload_3
    //   627: invokespecial 1001	com/google/android/gms/internal/measurement/zzjl:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   630: ifeq +323 -> 953
    //   633: aload_1
    //   634: lload 7
    //   636: invokestatic 522	com/google/android/gms/internal/measurement/zzkx:zzf	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   639: aload_2
    //   640: lload 7
    //   642: invokestatic 522	com/google/android/gms/internal/measurement/zzkx:zzf	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   645: invokestatic 999	com/google/android/gms/internal/measurement/zzkb:zza	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   648: ifne +308 -> 956
    //   651: goto +302 -> 953
    //   654: aload_0
    //   655: aload_1
    //   656: aload_2
    //   657: iload_3
    //   658: invokespecial 1001	com/google/android/gms/internal/measurement/zzjl:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   661: ifeq +292 -> 953
    //   664: aload_1
    //   665: lload 7
    //   667: invokestatic 522	com/google/android/gms/internal/measurement/zzkx:zzf	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   670: aload_2
    //   671: lload 7
    //   673: invokestatic 522	com/google/android/gms/internal/measurement/zzkx:zzf	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   676: invokestatic 999	com/google/android/gms/internal/measurement/zzkb:zza	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   679: ifne +277 -> 956
    //   682: goto +271 -> 953
    //   685: aload_0
    //   686: aload_1
    //   687: aload_2
    //   688: iload_3
    //   689: invokespecial 1001	com/google/android/gms/internal/measurement/zzjl:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   692: ifeq +261 -> 953
    //   695: aload_1
    //   696: lload 7
    //   698: invokestatic 522	com/google/android/gms/internal/measurement/zzkx:zzf	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   701: aload_2
    //   702: lload 7
    //   704: invokestatic 522	com/google/android/gms/internal/measurement/zzkx:zzf	(Ljava/lang/Object;J)Ljava/lang/Object;
    //   707: invokestatic 999	com/google/android/gms/internal/measurement/zzkb:zza	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   710: ifne +246 -> 956
    //   713: goto +240 -> 953
    //   716: aload_0
    //   717: aload_1
    //   718: aload_2
    //   719: iload_3
    //   720: invokespecial 1001	com/google/android/gms/internal/measurement/zzjl:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   723: ifeq +230 -> 953
    //   726: aload_1
    //   727: lload 7
    //   729: invokestatic 633	com/google/android/gms/internal/measurement/zzkx:zzc	(Ljava/lang/Object;J)Z
    //   732: aload_2
    //   733: lload 7
    //   735: invokestatic 633	com/google/android/gms/internal/measurement/zzkx:zzc	(Ljava/lang/Object;J)Z
    //   738: if_icmpeq +218 -> 956
    //   741: goto +212 -> 953
    //   744: aload_0
    //   745: aload_1
    //   746: aload_2
    //   747: iload_3
    //   748: invokespecial 1001	com/google/android/gms/internal/measurement/zzjl:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   751: ifeq +202 -> 953
    //   754: aload_1
    //   755: lload 7
    //   757: invokestatic 626	com/google/android/gms/internal/measurement/zzkx:zza	(Ljava/lang/Object;J)I
    //   760: aload_2
    //   761: lload 7
    //   763: invokestatic 626	com/google/android/gms/internal/measurement/zzkx:zza	(Ljava/lang/Object;J)I
    //   766: if_icmpeq +190 -> 956
    //   769: goto +184 -> 953
    //   772: aload_0
    //   773: aload_1
    //   774: aload_2
    //   775: iload_3
    //   776: invokespecial 1001	com/google/android/gms/internal/measurement/zzjl:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   779: ifeq +174 -> 953
    //   782: aload_1
    //   783: lload 7
    //   785: invokestatic 624	com/google/android/gms/internal/measurement/zzkx:zzb	(Ljava/lang/Object;J)J
    //   788: aload_2
    //   789: lload 7
    //   791: invokestatic 624	com/google/android/gms/internal/measurement/zzkx:zzb	(Ljava/lang/Object;J)J
    //   794: lcmp
    //   795: ifeq +161 -> 956
    //   798: goto +155 -> 953
    //   801: aload_0
    //   802: aload_1
    //   803: aload_2
    //   804: iload_3
    //   805: invokespecial 1001	com/google/android/gms/internal/measurement/zzjl:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   808: ifeq +145 -> 953
    //   811: aload_1
    //   812: lload 7
    //   814: invokestatic 626	com/google/android/gms/internal/measurement/zzkx:zza	(Ljava/lang/Object;J)I
    //   817: aload_2
    //   818: lload 7
    //   820: invokestatic 626	com/google/android/gms/internal/measurement/zzkx:zza	(Ljava/lang/Object;J)I
    //   823: if_icmpeq +133 -> 956
    //   826: goto +127 -> 953
    //   829: aload_0
    //   830: aload_1
    //   831: aload_2
    //   832: iload_3
    //   833: invokespecial 1001	com/google/android/gms/internal/measurement/zzjl:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   836: ifeq +117 -> 953
    //   839: aload_1
    //   840: lload 7
    //   842: invokestatic 624	com/google/android/gms/internal/measurement/zzkx:zzb	(Ljava/lang/Object;J)J
    //   845: aload_2
    //   846: lload 7
    //   848: invokestatic 624	com/google/android/gms/internal/measurement/zzkx:zzb	(Ljava/lang/Object;J)J
    //   851: lcmp
    //   852: ifeq +104 -> 956
    //   855: goto +98 -> 953
    //   858: aload_0
    //   859: aload_1
    //   860: aload_2
    //   861: iload_3
    //   862: invokespecial 1001	com/google/android/gms/internal/measurement/zzjl:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   865: ifeq +88 -> 953
    //   868: aload_1
    //   869: lload 7
    //   871: invokestatic 624	com/google/android/gms/internal/measurement/zzkx:zzb	(Ljava/lang/Object;J)J
    //   874: aload_2
    //   875: lload 7
    //   877: invokestatic 624	com/google/android/gms/internal/measurement/zzkx:zzb	(Ljava/lang/Object;J)J
    //   880: lcmp
    //   881: ifeq +75 -> 956
    //   884: goto +69 -> 953
    //   887: aload_0
    //   888: aload_1
    //   889: aload_2
    //   890: iload_3
    //   891: invokespecial 1001	com/google/android/gms/internal/measurement/zzjl:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   894: ifeq +59 -> 953
    //   897: aload_1
    //   898: lload 7
    //   900: invokestatic 636	com/google/android/gms/internal/measurement/zzkx:zzd	(Ljava/lang/Object;J)F
    //   903: invokestatic 809	java/lang/Float:floatToIntBits	(F)I
    //   906: aload_2
    //   907: lload 7
    //   909: invokestatic 636	com/google/android/gms/internal/measurement/zzkx:zzd	(Ljava/lang/Object;J)F
    //   912: invokestatic 809	java/lang/Float:floatToIntBits	(F)I
    //   915: if_icmpeq +41 -> 956
    //   918: goto +35 -> 953
    //   921: aload_0
    //   922: aload_1
    //   923: aload_2
    //   924: iload_3
    //   925: invokespecial 1001	com/google/android/gms/internal/measurement/zzjl:zzc	(Ljava/lang/Object;Ljava/lang/Object;I)Z
    //   928: ifeq +25 -> 953
    //   931: aload_1
    //   932: lload 7
    //   934: invokestatic 639	com/google/android/gms/internal/measurement/zzkx:zze	(Ljava/lang/Object;J)D
    //   937: invokestatic 813	java/lang/Double:doubleToLongBits	(D)J
    //   940: aload_2
    //   941: lload 7
    //   943: invokestatic 639	com/google/android/gms/internal/measurement/zzkx:zze	(Ljava/lang/Object;J)D
    //   946: invokestatic 813	java/lang/Double:doubleToLongBits	(D)J
    //   949: lcmp
    //   950: ifeq +6 -> 956
    //   953: iconst_0
    //   954: istore 6
    //   956: iload 6
    //   958: ifne +5 -> 963
    //   961: iconst_0
    //   962: ireturn
    //   963: iload_3
    //   964: iconst_3
    //   965: iadd
    //   966: istore_3
    //   967: goto -958 -> 9
    //   970: aload_0
    //   971: getfield 90	com/google/android/gms/internal/measurement/zzjl:zzq	Lcom/google/android/gms/internal/measurement/zzkr;
    //   974: aload_1
    //   975: invokevirtual 107	com/google/android/gms/internal/measurement/zzkr:zzb	(Ljava/lang/Object;)Ljava/lang/Object;
    //   978: aload_0
    //   979: getfield 90	com/google/android/gms/internal/measurement/zzjl:zzq	Lcom/google/android/gms/internal/measurement/zzkr;
    //   982: aload_2
    //   983: invokevirtual 107	com/google/android/gms/internal/measurement/zzkr:zzb	(Ljava/lang/Object;)Ljava/lang/Object;
    //   986: invokevirtual 1002	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   989: ifne +5 -> 994
    //   992: iconst_0
    //   993: ireturn
    //   994: aload_0
    //   995: getfield 76	com/google/android/gms/internal/measurement/zzjl:zzh	Z
    //   998: ifeq +23 -> 1021
    //   1001: aload_0
    //   1002: getfield 92	com/google/android/gms/internal/measurement/zzjl:zzr	Lcom/google/android/gms/internal/measurement/zzho;
    //   1005: aload_1
    //   1006: invokevirtual 659	com/google/android/gms/internal/measurement/zzho:zza	(Ljava/lang/Object;)Lcom/google/android/gms/internal/measurement/zzhp;
    //   1009: aload_0
    //   1010: getfield 92	com/google/android/gms/internal/measurement/zzjl:zzr	Lcom/google/android/gms/internal/measurement/zzho;
    //   1013: aload_2
    //   1014: invokevirtual 659	com/google/android/gms/internal/measurement/zzho:zza	(Ljava/lang/Object;)Lcom/google/android/gms/internal/measurement/zzhp;
    //   1017: invokevirtual 1003	com/google/android/gms/internal/measurement/zzhp:equals	(Ljava/lang/Object;)Z
    //   1020: ireturn
    //   1021: iconst_1
    //   1022: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1023	0	this	zzjl
    //   0	1023	1	paramT1	T
    //   0	1023	2	paramT2	T
    //   8	959	3	i	int
    //   5	11	4	j	int
    //   23	16	5	k	int
    //   10	947	6	bool	boolean
    //   31	911	7	l1	long
    //   344	10	9	l2	long
  }
  
  public final int zzb(T paramT)
  {
    int j;
    long l;
    Object localObject2;
    if (this.zzj)
    {
      localObject1 = zzb;
      m = 0;
      for (n = 0; m < this.zzc.length; n = i)
      {
        j = zzd(m);
        i = (j & 0xFF00000) >>> 20;
        k = this.zzc[m];
        l = j & 0xFFFFF;
        if ((i >= zzhu.zza.zza()) && (i <= zzhu.zzb.zza())) {
          j = this.zzc[(m + 2)];
        }
        switch (i)
        {
        default: 
          i = n;
          break;
        case 68: 
          i = n;
          if (!zza(paramT, k, m)) {
            break label2307;
          }
          i = zzhg.zzc(k, (zzjh)zzkx.zzf(paramT, l), zza(m));
          break;
        case 67: 
          i = n;
          if (!zza(paramT, k, m)) {
            break label2307;
          }
          i = zzhg.zzf(k, zze(paramT, l));
          break;
        case 66: 
          i = n;
          if (!zza(paramT, k, m)) {
            break label2307;
          }
          i = zzhg.zzh(k, zzd(paramT, l));
          break;
        case 65: 
          i = n;
          if (!zza(paramT, k, m)) {
            break label2307;
          }
          i = zzhg.zzh(k, 0L);
          break;
        case 64: 
          i = n;
          if (!zza(paramT, k, m)) {
            break label2307;
          }
          i = zzhg.zzj(k, 0);
          break;
        case 63: 
          i = n;
          if (!zza(paramT, k, m)) {
            break label2307;
          }
          i = zzhg.zzk(k, zzd(paramT, l));
          break;
        case 62: 
          i = n;
          if (!zza(paramT, k, m)) {
            break label2307;
          }
          i = zzhg.zzg(k, zzd(paramT, l));
          break;
        case 61: 
          i = n;
          if (!zza(paramT, k, m)) {
            break label2307;
          }
          i = zzhg.zzc(k, (zzgr)zzkx.zzf(paramT, l));
          break;
        case 60: 
          i = n;
          if (!zza(paramT, k, m)) {
            break label2307;
          }
          i = zzkb.zza(k, zzkx.zzf(paramT, l), zza(m));
          break;
        case 59: 
          i = n;
          if (!zza(paramT, k, m)) {
            break label2307;
          }
          localObject2 = zzkx.zzf(paramT, l);
          if ((localObject2 instanceof zzgr)) {
            i = zzhg.zzc(k, (zzgr)localObject2);
          } else {
            i = zzhg.zzb(k, (String)localObject2);
          }
          break;
        case 58: 
          i = n;
          if (!zza(paramT, k, m)) {
            break label2307;
          }
          i = zzhg.zzb(k, true);
          break;
        case 57: 
          i = n;
          if (!zza(paramT, k, m)) {
            break label2307;
          }
          i = zzhg.zzi(k, 0);
          break;
        case 56: 
          i = n;
          if (!zza(paramT, k, m)) {
            break label2307;
          }
          i = zzhg.zzg(k, 0L);
          break;
        case 55: 
          i = n;
          if (!zza(paramT, k, m)) {
            break label2307;
          }
          i = zzhg.zzf(k, zzd(paramT, l));
          break;
        case 54: 
          i = n;
          if (!zza(paramT, k, m)) {
            break label2307;
          }
          i = zzhg.zze(k, zze(paramT, l));
          break;
        case 53: 
          i = n;
          if (!zza(paramT, k, m)) {
            break label2307;
          }
          i = zzhg.zzd(k, zze(paramT, l));
          break;
        case 52: 
          i = n;
          if (!zza(paramT, k, m)) {
            break label2307;
          }
          i = zzhg.zzb(k, 0.0F);
          break;
        case 51: 
          i = n;
          if (!zza(paramT, k, m)) {
            break label2307;
          }
          i = zzhg.zzb(k, 0.0D);
          break;
        case 50: 
          i = this.zzs.zza(k, zzkx.zzf(paramT, l), zzb(m));
          break;
        case 49: 
          i = zzkb.zzb(k, zza(paramT, l), zza(m));
          break;
        case 48: 
          j = zzkb.zzc((List)((Unsafe)localObject1).getObject(paramT, l));
          i = n;
          if (j <= 0) {
            break label2307;
          }
          i = zzhg.zze(k);
          k = zzhg.zzg(j);
          break;
        case 47: 
          j = zzkb.zzg((List)((Unsafe)localObject1).getObject(paramT, l));
          i = n;
          if (j <= 0) {
            break label2307;
          }
          i = zzhg.zze(k);
          k = zzhg.zzg(j);
          break;
        case 46: 
          j = zzkb.zzi((List)((Unsafe)localObject1).getObject(paramT, l));
          i = n;
          if (j <= 0) {
            break label2307;
          }
          i = zzhg.zze(k);
          k = zzhg.zzg(j);
          break;
        case 45: 
          j = zzkb.zzh((List)((Unsafe)localObject1).getObject(paramT, l));
          i = n;
          if (j <= 0) {
            break label2307;
          }
          i = zzhg.zze(k);
          k = zzhg.zzg(j);
          break;
        case 44: 
          j = zzkb.zzd((List)((Unsafe)localObject1).getObject(paramT, l));
          i = n;
          if (j <= 0) {
            break label2307;
          }
          i = zzhg.zze(k);
          k = zzhg.zzg(j);
          break;
        case 43: 
          j = zzkb.zzf((List)((Unsafe)localObject1).getObject(paramT, l));
          i = n;
          if (j <= 0) {
            break label2307;
          }
          i = zzhg.zze(k);
          k = zzhg.zzg(j);
          break;
        case 42: 
          j = zzkb.zzj((List)((Unsafe)localObject1).getObject(paramT, l));
          i = n;
          if (j <= 0) {
            break label2307;
          }
          i = zzhg.zze(k);
          k = zzhg.zzg(j);
          break;
        case 41: 
          j = zzkb.zzh((List)((Unsafe)localObject1).getObject(paramT, l));
          i = n;
          if (j <= 0) {
            break label2307;
          }
          i = zzhg.zze(k);
          k = zzhg.zzg(j);
          break;
        case 40: 
          j = zzkb.zzi((List)((Unsafe)localObject1).getObject(paramT, l));
          i = n;
          if (j <= 0) {
            break label2307;
          }
          i = zzhg.zze(k);
          k = zzhg.zzg(j);
          break;
        case 39: 
          j = zzkb.zze((List)((Unsafe)localObject1).getObject(paramT, l));
          i = n;
          if (j <= 0) {
            break label2307;
          }
          i = zzhg.zze(k);
          k = zzhg.zzg(j);
          break;
        case 38: 
          j = zzkb.zzb((List)((Unsafe)localObject1).getObject(paramT, l));
          i = n;
          if (j <= 0) {
            break label2307;
          }
          i = zzhg.zze(k);
          k = zzhg.zzg(j);
          break;
        case 37: 
          j = zzkb.zza((List)((Unsafe)localObject1).getObject(paramT, l));
          i = n;
          if (j <= 0) {
            break label2307;
          }
          i = zzhg.zze(k);
          k = zzhg.zzg(j);
          break;
        case 36: 
          j = zzkb.zzh((List)((Unsafe)localObject1).getObject(paramT, l));
          i = n;
          if (j <= 0) {
            break label2307;
          }
          i = zzhg.zze(k);
          k = zzhg.zzg(j);
          break;
        case 35: 
          j = zzkb.zzi((List)((Unsafe)localObject1).getObject(paramT, l));
          i = n;
          if (j <= 0) {
            break label2307;
          }
          i = zzhg.zze(k);
          k = zzhg.zzg(j);
          i = i + k + j;
          break;
        case 34: 
          i = zzkb.zzc(k, zza(paramT, l), false);
          break;
        case 33: 
          i = zzkb.zzg(k, zza(paramT, l), false);
          break;
        case 32: 
          i = zzkb.zzi(k, zza(paramT, l), false);
          break;
        case 31: 
          i = zzkb.zzh(k, zza(paramT, l), false);
          break;
        case 30: 
          i = zzkb.zzd(k, zza(paramT, l), false);
          break;
        case 29: 
          i = zzkb.zzf(k, zza(paramT, l), false);
          break;
        case 28: 
          i = zzkb.zzb(k, zza(paramT, l));
          break;
        case 27: 
          i = zzkb.zza(k, zza(paramT, l), zza(m));
          break;
        case 26: 
          i = zzkb.zza(k, zza(paramT, l));
          break;
        case 25: 
          i = zzkb.zzj(k, zza(paramT, l), false);
          break;
        case 24: 
          i = zzkb.zzh(k, zza(paramT, l), false);
          break;
        case 23: 
          i = zzkb.zzi(k, zza(paramT, l), false);
          break;
        case 22: 
          i = zzkb.zze(k, zza(paramT, l), false);
          break;
        case 21: 
          i = zzkb.zzb(k, zza(paramT, l), false);
          break;
        case 20: 
          i = zzkb.zza(k, zza(paramT, l), false);
          break;
        case 19: 
          i = zzkb.zzh(k, zza(paramT, l), false);
          break;
        case 18: 
          i = zzkb.zzi(k, zza(paramT, l), false);
        }
        for (;;)
        {
          i = n + i;
          break;
          i = n;
          if (!zza(paramT, m)) {
            break;
          }
          i = zzhg.zzc(k, (zzjh)zzkx.zzf(paramT, l), zza(m));
          continue;
          i = n;
          if (!zza(paramT, m)) {
            break;
          }
          i = zzhg.zzf(k, zzkx.zzb(paramT, l));
          continue;
          i = n;
          if (!zza(paramT, m)) {
            break;
          }
          i = zzhg.zzh(k, zzkx.zza(paramT, l));
          continue;
          i = n;
          if (!zza(paramT, m)) {
            break;
          }
          i = zzhg.zzh(k, 0L);
          continue;
          i = n;
          if (!zza(paramT, m)) {
            break;
          }
          i = zzhg.zzj(k, 0);
          continue;
          i = n;
          if (!zza(paramT, m)) {
            break;
          }
          i = zzhg.zzk(k, zzkx.zza(paramT, l));
          continue;
          i = n;
          if (!zza(paramT, m)) {
            break;
          }
          i = zzhg.zzg(k, zzkx.zza(paramT, l));
          continue;
          i = n;
          if (!zza(paramT, m)) {
            break;
          }
          i = zzhg.zzc(k, (zzgr)zzkx.zzf(paramT, l));
          continue;
          i = n;
          if (!zza(paramT, m)) {
            break;
          }
          i = zzkb.zza(k, zzkx.zzf(paramT, l), zza(m));
          continue;
          i = n;
          if (!zza(paramT, m)) {
            break;
          }
          localObject2 = zzkx.zzf(paramT, l);
          if ((localObject2 instanceof zzgr))
          {
            i = zzhg.zzc(k, (zzgr)localObject2);
          }
          else
          {
            i = zzhg.zzb(k, (String)localObject2);
            continue;
            i = n;
            if (!zza(paramT, m)) {
              break;
            }
            i = zzhg.zzb(k, true);
            continue;
            i = n;
            if (!zza(paramT, m)) {
              break;
            }
            i = zzhg.zzi(k, 0);
            continue;
            i = n;
            if (!zza(paramT, m)) {
              break;
            }
            i = zzhg.zzg(k, 0L);
            continue;
            i = n;
            if (!zza(paramT, m)) {
              break;
            }
            i = zzhg.zzf(k, zzkx.zza(paramT, l));
            continue;
            i = n;
            if (!zza(paramT, m)) {
              break;
            }
            i = zzhg.zze(k, zzkx.zzb(paramT, l));
            continue;
            i = n;
            if (!zza(paramT, m)) {
              break;
            }
            i = zzhg.zzd(k, zzkx.zzb(paramT, l));
            continue;
            i = n;
            if (!zza(paramT, m)) {
              break;
            }
            i = zzhg.zzb(k, 0.0F);
            continue;
            i = n;
            if (!zza(paramT, m)) {
              break;
            }
            i = zzhg.zzb(k, 0.0D);
          }
        }
        label2307:
        m += 3;
      }
      return n + zza(this.zzq, paramT);
    }
    Object localObject1 = zzb;
    int n = 0;
    int m = 0;
    int i = 1048575;
    int i2 = 0;
    while (n < this.zzc.length)
    {
      int i5 = zzd(n);
      localObject2 = this.zzc;
      int i4 = localObject2[n];
      int i6 = (i5 & 0xFF00000) >>> 20;
      int i3;
      int i1;
      if (i6 <= 17)
      {
        j = localObject2[(n + 2)];
        k = j & 0xFFFFF;
        i3 = 1 << (j >>> 20);
        i1 = i;
        j = i3;
        if (k != i)
        {
          i2 = ((Unsafe)localObject1).getInt(paramT, k);
          i1 = k;
          j = i3;
        }
      }
      else
      {
        j = 0;
        i1 = i;
      }
      l = i5 & 0xFFFFF;
      switch (i6)
      {
      default: 
        i = m;
        break;
      case 68: 
        i = m;
        if (zza(paramT, i4, n)) {
          i = zzhg.zzc(i4, (zzjh)((Unsafe)localObject1).getObject(paramT, l), zza(n));
        }
        break;
      case 67: 
        i = m;
        if (zza(paramT, i4, n)) {
          i = zzhg.zzf(i4, zze(paramT, l));
        }
        break;
      case 66: 
        i = m;
        if (zza(paramT, i4, n)) {
          i = zzhg.zzh(i4, zzd(paramT, l));
        }
        break;
      case 65: 
        i = m;
        if (zza(paramT, i4, n)) {
          i = zzhg.zzh(i4, 0L);
        }
        break;
      case 64: 
        i = m;
        if (zza(paramT, i4, n)) {
          i = zzhg.zzj(i4, 0);
        }
        break;
      case 63: 
        i = m;
        if (zza(paramT, i4, n)) {
          i = zzhg.zzk(i4, zzd(paramT, l));
        }
        break;
      case 62: 
        i = m;
        if (zza(paramT, i4, n)) {
          i = zzhg.zzg(i4, zzd(paramT, l));
        }
        break;
      case 61: 
        i = m;
        if (zza(paramT, i4, n)) {
          i = zzhg.zzc(i4, (zzgr)((Unsafe)localObject1).getObject(paramT, l));
        }
        break;
      case 60: 
        i = m;
        if (zza(paramT, i4, n)) {
          i = zzkb.zza(i4, ((Unsafe)localObject1).getObject(paramT, l), zza(n));
        }
        break;
      case 59: 
        i = m;
        if (zza(paramT, i4, n))
        {
          localObject2 = ((Unsafe)localObject1).getObject(paramT, l);
          if ((localObject2 instanceof zzgr)) {
            i = zzhg.zzc(i4, (zzgr)localObject2);
          } else {
            i = zzhg.zzb(i4, (String)localObject2);
          }
        }
        break;
      case 58: 
        i = m;
        if (zza(paramT, i4, n)) {
          i = zzhg.zzb(i4, true);
        }
        break;
      case 57: 
        i = m;
        if (zza(paramT, i4, n)) {
          i = zzhg.zzi(i4, 0);
        }
        break;
      case 56: 
        i = m;
        if (zza(paramT, i4, n)) {
          i = zzhg.zzg(i4, 0L);
        }
        break;
      case 55: 
        i = m;
        if (zza(paramT, i4, n)) {
          i = zzhg.zzf(i4, zzd(paramT, l));
        }
        break;
      case 54: 
        i = m;
        if (zza(paramT, i4, n)) {
          i = zzhg.zze(i4, zze(paramT, l));
        }
        break;
      case 53: 
        i = m;
        if (zza(paramT, i4, n)) {
          i = zzhg.zzd(i4, zze(paramT, l));
        }
        break;
      case 52: 
        i = m;
        if (zza(paramT, i4, n)) {
          i = zzhg.zzb(i4, 0.0F);
        }
        break;
      case 51: 
        i = m;
        if (zza(paramT, i4, n)) {
          i = zzhg.zzb(i4, 0.0D);
        }
        break;
      case 50: 
        i = this.zzs.zza(i4, ((Unsafe)localObject1).getObject(paramT, l), zzb(n));
        break;
      case 49: 
        i = zzkb.zzb(i4, (List)((Unsafe)localObject1).getObject(paramT, l), zza(n));
        break;
      case 48: 
        j = zzkb.zzc((List)((Unsafe)localObject1).getObject(paramT, l));
        i = m;
        if (j > 0)
        {
          i3 = zzhg.zze(i4);
          k = zzhg.zzg(j);
          i = j;
          j = i3;
        }
        break;
      case 47: 
        j = zzkb.zzg((List)((Unsafe)localObject1).getObject(paramT, l));
        i = m;
        if (j > 0)
        {
          i3 = zzhg.zze(i4);
          k = zzhg.zzg(j);
          i = j;
          j = i3;
        }
        break;
      case 46: 
        j = zzkb.zzi((List)((Unsafe)localObject1).getObject(paramT, l));
        i = m;
        if (j > 0)
        {
          i3 = zzhg.zze(i4);
          k = zzhg.zzg(j);
          i = j;
          j = i3;
        }
        break;
      case 45: 
        j = zzkb.zzh((List)((Unsafe)localObject1).getObject(paramT, l));
        i = m;
        if (j > 0)
        {
          i3 = zzhg.zze(i4);
          k = zzhg.zzg(j);
          i = j;
          j = i3;
        }
        break;
      case 44: 
        j = zzkb.zzd((List)((Unsafe)localObject1).getObject(paramT, l));
        i = m;
        if (j > 0)
        {
          i3 = zzhg.zze(i4);
          k = zzhg.zzg(j);
          i = j;
          j = i3;
        }
        break;
      case 43: 
        j = zzkb.zzf((List)((Unsafe)localObject1).getObject(paramT, l));
        i = m;
        if (j > 0)
        {
          i3 = zzhg.zze(i4);
          k = zzhg.zzg(j);
          i = j;
          j = i3;
        }
        break;
      case 42: 
        j = zzkb.zzj((List)((Unsafe)localObject1).getObject(paramT, l));
        i = m;
        if (j > 0)
        {
          i3 = zzhg.zze(i4);
          k = zzhg.zzg(j);
          i = j;
          j = i3;
        }
        break;
      case 41: 
        j = zzkb.zzh((List)((Unsafe)localObject1).getObject(paramT, l));
        i = m;
        if (j > 0)
        {
          i3 = zzhg.zze(i4);
          k = zzhg.zzg(j);
          i = j;
          j = i3;
        }
        break;
      case 40: 
        j = zzkb.zzi((List)((Unsafe)localObject1).getObject(paramT, l));
        i = m;
        if (j > 0)
        {
          i3 = zzhg.zze(i4);
          k = zzhg.zzg(j);
          i = j;
          j = i3;
        }
        break;
      case 39: 
        j = zzkb.zze((List)((Unsafe)localObject1).getObject(paramT, l));
        i = m;
        if (j > 0)
        {
          i3 = zzhg.zze(i4);
          k = zzhg.zzg(j);
          i = j;
          j = i3;
        }
        break;
      case 38: 
        j = zzkb.zzb((List)((Unsafe)localObject1).getObject(paramT, l));
        i = m;
        if (j > 0)
        {
          i3 = zzhg.zze(i4);
          k = zzhg.zzg(j);
          i = j;
          j = i3;
        }
        break;
      case 37: 
        j = zzkb.zza((List)((Unsafe)localObject1).getObject(paramT, l));
        i = m;
        if (j > 0)
        {
          i3 = zzhg.zze(i4);
          k = zzhg.zzg(j);
          i = j;
          j = i3;
        }
        break;
      case 36: 
        j = zzkb.zzh((List)((Unsafe)localObject1).getObject(paramT, l));
        i = m;
        if (j > 0)
        {
          i3 = zzhg.zze(i4);
          k = zzhg.zzg(j);
          i = j;
          j = i3;
        }
        break;
      case 35: 
        i3 = zzkb.zzi((List)((Unsafe)localObject1).getObject(paramT, l));
        i = m;
        if (i3 > 0)
        {
          j = zzhg.zze(i4);
          k = zzhg.zzg(i3);
          i = i3;
          i = j + k + i;
        }
        break;
      case 34: 
        i = zzkb.zzc(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 33: 
        i = zzkb.zzg(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 32: 
        i = zzkb.zzi(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 31: 
        i = zzkb.zzh(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 30: 
        i = zzkb.zzd(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 29: 
        i = zzkb.zzf(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 28: 
        i = zzkb.zzb(i4, (List)((Unsafe)localObject1).getObject(paramT, l));
        break;
      case 27: 
        i = zzkb.zza(i4, (List)((Unsafe)localObject1).getObject(paramT, l), zza(n));
        break;
      case 26: 
        i = zzkb.zza(i4, (List)((Unsafe)localObject1).getObject(paramT, l));
        break;
      case 25: 
        i = zzkb.zzj(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 24: 
        i = zzkb.zzh(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 23: 
        i = zzkb.zzi(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 22: 
        i = zzkb.zze(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 21: 
        i = zzkb.zzb(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 20: 
        i = zzkb.zza(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        break;
      case 19: 
        i = zzkb.zzh(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
        i = m + i;
      case 18: 
      case 17: 
      case 16: 
      case 15: 
      case 14: 
      case 13: 
      case 12: 
      case 11: 
      case 10: 
      case 9: 
      case 8: 
      case 7: 
      case 6: 
        for (;;)
        {
          break label4353;
          i = zzkb.zzi(i4, (List)((Unsafe)localObject1).getObject(paramT, l), false);
          i = m + i;
          for (;;)
          {
            break label4859;
            i = m;
            if ((i2 & j) != 0)
            {
              i = zzhg.zzc(i4, (zzjh)((Unsafe)localObject1).getObject(paramT, l), zza(n));
              break;
              i = m;
              if ((i2 & j) != 0)
              {
                i = zzhg.zzf(i4, ((Unsafe)localObject1).getLong(paramT, l));
                break;
                i = m;
                if ((i2 & j) != 0)
                {
                  i = zzhg.zzh(i4, ((Unsafe)localObject1).getInt(paramT, l));
                  break;
                  i = m;
                  if ((i2 & j) != 0)
                  {
                    i = zzhg.zzh(i4, 0L);
                    break;
                    i = m;
                    if ((i2 & j) != 0)
                    {
                      i = zzhg.zzj(i4, 0);
                      i = m + i;
                      continue;
                      i = m;
                      if ((i2 & j) != 0)
                      {
                        i = zzhg.zzk(i4, ((Unsafe)localObject1).getInt(paramT, l));
                        break;
                        i = m;
                        if ((i2 & j) != 0)
                        {
                          i = zzhg.zzg(i4, ((Unsafe)localObject1).getInt(paramT, l));
                          break;
                          i = m;
                          if ((i2 & j) != 0)
                          {
                            i = zzhg.zzc(i4, (zzgr)((Unsafe)localObject1).getObject(paramT, l));
                            break;
                            i = m;
                            if ((i2 & j) != 0)
                            {
                              i = zzkb.zza(i4, ((Unsafe)localObject1).getObject(paramT, l), zza(n));
                              break;
                              i = m;
                              if ((i2 & j) != 0)
                              {
                                localObject2 = ((Unsafe)localObject1).getObject(paramT, l);
                                if ((localObject2 instanceof zzgr))
                                {
                                  i = zzhg.zzc(i4, (zzgr)localObject2);
                                  break;
                                }
                                i = zzhg.zzb(i4, (String)localObject2);
                                break;
                                i = m;
                                if ((i2 & j) != 0) {
                                  i = m + zzhg.zzb(i4, true);
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          i = m;
          if ((i2 & j) != 0) {
            i = m + zzhg.zzi(i4, 0);
          }
        }
      case 5: 
        i = m;
        if ((i2 & j) != 0) {
          i = zzhg.zzg(i4, 0L);
        }
        break;
      case 4: 
        i = m;
        if ((j & i2) != 0) {
          i = zzhg.zzf(i4, ((Unsafe)localObject1).getInt(paramT, l));
        }
        break;
      case 3: 
        i = m;
        if ((j & i2) != 0) {
          i = zzhg.zze(i4, ((Unsafe)localObject1).getLong(paramT, l));
        }
        break;
      case 2: 
        i = m;
        if ((j & i2) != 0)
        {
          i = zzhg.zzd(i4, ((Unsafe)localObject1).getLong(paramT, l));
          i = m + i;
        }
        break;
      case 1: 
        label4353:
        i = m;
        if ((i2 & j) != 0) {
          i = m + zzhg.zzb(i4, 0.0F);
        }
        break;
      }
      for (;;)
      {
        break;
        i = m;
        if ((i2 & j) != 0) {
          i = m + zzhg.zzb(i4, 0.0D);
        }
      }
      label4859:
      n += 3;
      m = i;
      i = i1;
    }
    n = 0;
    int k = m + zza(this.zzq, paramT);
    i = k;
    if (this.zzh)
    {
      paramT = this.zzr.zza(paramT);
      j = 0;
      i = n;
      while (j < paramT.zza.zzc())
      {
        localObject1 = paramT.zza.zzb(j);
        i += zzhp.zza((zzhr)((Map.Entry)localObject1).getKey(), ((Map.Entry)localObject1).getValue());
        j += 1;
      }
      paramT = paramT.zza.zzd().iterator();
      while (paramT.hasNext())
      {
        localObject1 = (Map.Entry)paramT.next();
        i += zzhp.zza((zzhr)((Map.Entry)localObject1).getKey(), ((Map.Entry)localObject1).getValue());
      }
      i = k + i;
    }
    return i;
  }
  
  public final void zzb(T paramT1, T paramT2)
  {
    if (paramT2 != null)
    {
      int i = 0;
      while (i < this.zzc.length)
      {
        int j = zzd(i);
        long l = 0xFFFFF & j;
        int k = this.zzc[i];
        switch ((j & 0xFF00000) >>> 20)
        {
        default: 
          break;
        case 68: 
          zzb(paramT1, paramT2, i);
          break;
        case 61: 
        case 62: 
        case 63: 
        case 64: 
        case 65: 
        case 66: 
        case 67: 
          if (zza(paramT2, k, i))
          {
            zzkx.zza(paramT1, l, zzkx.zzf(paramT2, l));
            zzb(paramT1, k, i);
          }
          break;
        case 60: 
          zzb(paramT1, paramT2, i);
          break;
        case 51: 
        case 52: 
        case 53: 
        case 54: 
        case 55: 
        case 56: 
        case 57: 
        case 58: 
        case 59: 
          if (zza(paramT2, k, i))
          {
            zzkx.zza(paramT1, l, zzkx.zzf(paramT2, l));
            zzb(paramT1, k, i);
          }
          break;
        case 50: 
          zzkb.zza(this.zzs, paramT1, paramT2, l);
          break;
        case 18: 
        case 19: 
        case 20: 
        case 21: 
        case 22: 
        case 23: 
        case 24: 
        case 25: 
        case 26: 
        case 27: 
        case 28: 
        case 29: 
        case 30: 
        case 31: 
        case 32: 
        case 33: 
        case 34: 
        case 35: 
        case 36: 
        case 37: 
        case 38: 
        case 39: 
        case 40: 
        case 41: 
        case 42: 
        case 43: 
        case 44: 
        case 45: 
        case 46: 
        case 47: 
        case 48: 
        case 49: 
          this.zzp.zza(paramT1, paramT2, l);
          break;
        case 17: 
          zza(paramT1, paramT2, i);
          break;
        case 16: 
          if (zza(paramT2, i))
          {
            zzkx.zza(paramT1, l, zzkx.zzb(paramT2, l));
            zzb(paramT1, i);
          }
          break;
        case 15: 
          if (zza(paramT2, i))
          {
            zzkx.zza(paramT1, l, zzkx.zza(paramT2, l));
            zzb(paramT1, i);
          }
          break;
        case 14: 
          if (zza(paramT2, i))
          {
            zzkx.zza(paramT1, l, zzkx.zzb(paramT2, l));
            zzb(paramT1, i);
          }
          break;
        case 13: 
          if (zza(paramT2, i))
          {
            zzkx.zza(paramT1, l, zzkx.zza(paramT2, l));
            zzb(paramT1, i);
          }
          break;
        case 12: 
          if (zza(paramT2, i))
          {
            zzkx.zza(paramT1, l, zzkx.zza(paramT2, l));
            zzb(paramT1, i);
          }
          break;
        case 11: 
          if (zza(paramT2, i))
          {
            zzkx.zza(paramT1, l, zzkx.zza(paramT2, l));
            zzb(paramT1, i);
          }
          break;
        case 10: 
          if (zza(paramT2, i))
          {
            zzkx.zza(paramT1, l, zzkx.zzf(paramT2, l));
            zzb(paramT1, i);
          }
          break;
        case 9: 
          zza(paramT1, paramT2, i);
          break;
        case 8: 
          if (zza(paramT2, i))
          {
            zzkx.zza(paramT1, l, zzkx.zzf(paramT2, l));
            zzb(paramT1, i);
          }
          break;
        case 7: 
          if (zza(paramT2, i))
          {
            zzkx.zza(paramT1, l, zzkx.zzc(paramT2, l));
            zzb(paramT1, i);
          }
          break;
        case 6: 
          if (zza(paramT2, i))
          {
            zzkx.zza(paramT1, l, zzkx.zza(paramT2, l));
            zzb(paramT1, i);
          }
          break;
        case 5: 
          if (zza(paramT2, i))
          {
            zzkx.zza(paramT1, l, zzkx.zzb(paramT2, l));
            zzb(paramT1, i);
          }
          break;
        case 4: 
          if (zza(paramT2, i))
          {
            zzkx.zza(paramT1, l, zzkx.zza(paramT2, l));
            zzb(paramT1, i);
          }
          break;
        case 3: 
          if (zza(paramT2, i))
          {
            zzkx.zza(paramT1, l, zzkx.zzb(paramT2, l));
            zzb(paramT1, i);
          }
          break;
        case 2: 
          if (zza(paramT2, i))
          {
            zzkx.zza(paramT1, l, zzkx.zzb(paramT2, l));
            zzb(paramT1, i);
          }
          break;
        case 1: 
          if (zza(paramT2, i))
          {
            zzkx.zza(paramT1, l, zzkx.zzd(paramT2, l));
            zzb(paramT1, i);
          }
          break;
        case 0: 
          if (zza(paramT2, i))
          {
            zzkx.zza(paramT1, l, zzkx.zze(paramT2, l));
            zzb(paramT1, i);
          }
          break;
        }
        i += 3;
      }
      zzkb.zza(this.zzq, paramT1, paramT2);
      if (this.zzh) {
        zzkb.zza(this.zzr, paramT1, paramT2);
      }
      return;
    }
    throw null;
  }
  
  public final void zzc(T paramT)
  {
    int i = this.zzm;
    int j;
    for (;;)
    {
      j = this.zzn;
      if (i >= j) {
        break;
      }
      long l = zzd(this.zzl[i]) & 0xFFFFF;
      Object localObject = zzkx.zzf(paramT, l);
      if (localObject != null) {
        zzkx.zza(paramT, l, this.zzs.zze(localObject));
      }
      i += 1;
    }
    int k = this.zzl.length;
    i = j;
    while (i < k)
    {
      this.zzp.zzb(paramT, this.zzl[i]);
      i += 1;
    }
    this.zzq.zzd(paramT);
    if (this.zzh) {
      this.zzr.zzc(paramT);
    }
  }
  
  public final boolean zzd(T paramT)
  {
    int j = 1048575;
    int i = 0;
    int k = 0;
    for (;;)
    {
      int m = this.zzm;
      int i1 = 1;
      int n = 1;
      if (k >= m) {
        break;
      }
      int i2 = this.zzl[k];
      int i3 = this.zzc[i2];
      int i4 = zzd(i2);
      int i5 = this.zzc[(i2 + 2)];
      m = i5 & 0xFFFFF;
      i5 = 1 << (i5 >>> 20);
      if (m != j)
      {
        if (m != 1048575) {
          i = zzb.getInt(paramT, m);
        }
        j = m;
      }
      if ((0x10000000 & i4) != 0) {
        m = 1;
      } else {
        m = 0;
      }
      if ((m != 0) && (!zza(paramT, i2, j, i, i5))) {
        return false;
      }
      m = (0xFF00000 & i4) >>> 20;
      if ((m != 9) && (m != 17))
      {
        Object localObject2;
        if (m != 27) {
          if ((m != 60) && (m != 68))
          {
            if (m != 49)
            {
              if (m != 50) {
                break label527;
              }
              localObject2 = this.zzs.zzc(zzkx.zzf(paramT, i4 & 0xFFFFF));
              m = n;
              if (!((Map)localObject2).isEmpty())
              {
                localObject1 = zzb(i2);
                m = n;
                if (this.zzs.zzb(localObject1).zzc.zza() == zzll.zzi)
                {
                  localObject1 = null;
                  Iterator localIterator = ((Map)localObject2).values().iterator();
                  Object localObject3;
                  do
                  {
                    m = n;
                    if (!localIterator.hasNext()) {
                      break;
                    }
                    localObject3 = localIterator.next();
                    localObject2 = localObject1;
                    if (localObject1 == null) {
                      localObject2 = zzjv.zza().zza(localObject3.getClass());
                    }
                    localObject1 = localObject2;
                  } while (((zzjz)localObject2).zzd(localObject3));
                  m = 0;
                }
              }
              if (m != 0) {
                break label527;
              }
              return false;
            }
          }
          else
          {
            if ((!zza(paramT, i3, i2)) || (zza(paramT, i4, zza(i2)))) {
              break label527;
            }
            return false;
          }
        }
        Object localObject1 = (List)zzkx.zzf(paramT, i4 & 0xFFFFF);
        m = i1;
        if (!((List)localObject1).isEmpty())
        {
          localObject2 = zza(i2);
          n = 0;
          for (;;)
          {
            m = i1;
            if (n >= ((List)localObject1).size()) {
              break;
            }
            if (!((zzjz)localObject2).zzd(((List)localObject1).get(n)))
            {
              m = 0;
              break;
            }
            n += 1;
          }
        }
        if (m == 0) {
          return false;
        }
      }
      else if ((zza(paramT, i2, j, i, i5)) && (!zza(paramT, i4, zza(i2))))
      {
        return false;
      }
      label527:
      k += 1;
    }
    return (!this.zzh) || (this.zzr.zza(paramT).zzf());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzjl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */