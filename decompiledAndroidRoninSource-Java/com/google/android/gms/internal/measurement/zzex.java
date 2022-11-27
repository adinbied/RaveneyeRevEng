package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzex
{
  static int zza(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt3 | paramInt2 & paramInt3;
  }
  
  static int zza(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof byte[])) {
      return ((byte[])paramObject)[paramInt] & 0xFF;
    }
    if ((paramObject instanceof short[])) {
      return ((short[])paramObject)[paramInt] & 0xFFFF;
    }
    return ((int[])paramObject)[paramInt];
  }
  
  static int zza(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2, int paramInt, Object paramObject3, int[] paramArrayOfInt, Object[] paramArrayOfObject1, @NullableDecl Object[] paramArrayOfObject2)
  {
    int n = zzez.zza(paramObject1);
    int m = n & paramInt;
    int j = zza(paramObject3, m);
    if (j == 0) {
      return -1;
    }
    int i1 = paramInt;
    int i = -1;
    for (;;)
    {
      j -= 1;
      int k = paramArrayOfInt[j];
      if (((k & i1) == (n & i1)) && (zzdz.zza(paramObject1, paramArrayOfObject1[j])) && ((paramArrayOfObject2 == null) || (zzdz.zza(paramObject2, paramArrayOfObject2[j]))))
      {
        k &= paramInt;
        if (i == -1)
        {
          zza(paramObject3, m, k);
          return j;
        }
        paramArrayOfInt[i] = zza(paramArrayOfInt[i], k, paramInt);
        return j;
      }
      k &= paramInt;
      if (k == 0) {
        return -1;
      }
      i = j;
      j = k;
    }
  }
  
  static Object zza(int paramInt)
  {
    if ((paramInt >= 2) && (paramInt <= 1073741824) && (Integer.highestOneBit(paramInt) == paramInt))
    {
      if (paramInt <= 256) {
        return new byte[paramInt];
      }
      if (paramInt <= 65536) {
        return new short[paramInt];
      }
      return new int[paramInt];
    }
    StringBuilder localStringBuilder = new StringBuilder(52);
    localStringBuilder.append("must be power of 2 between 2^1 and 2^30: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  static void zza(Object paramObject, int paramInt1, int paramInt2)
  {
    if ((paramObject instanceof byte[]))
    {
      ((byte[])paramObject)[paramInt1] = ((byte)paramInt2);
      return;
    }
    if ((paramObject instanceof short[]))
    {
      ((short[])paramObject)[paramInt1] = ((short)paramInt2);
      return;
    }
    ((int[])paramObject)[paramInt1] = paramInt2;
  }
  
  static int zzb(int paramInt)
  {
    int i;
    if (paramInt < 32) {
      i = 4;
    } else {
      i = 2;
    }
    return i * (paramInt + 1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */