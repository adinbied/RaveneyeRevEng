package com.google.android.gms.internal.measurement;

final class zzla
{
  private static final zzlb zza;
  
  static
  {
    int i;
    if ((zzkx.zza()) && (zzkx.zzb())) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject;
    if ((i != 0) && (!zzgk.zza())) {
      localObject = new zzlg();
    } else {
      localObject = new zzle();
    }
    zza = (zzlb)localObject;
  }
  
  static int zza(CharSequence paramCharSequence)
  {
    int n = paramCharSequence.length();
    int m = 0;
    int j = 0;
    while ((j < n) && (paramCharSequence.charAt(j) < '')) {
      j += 1;
    }
    int i = n;
    for (;;)
    {
      k = i;
      if (j >= n) {
        break label208;
      }
      k = paramCharSequence.charAt(j);
      if (k >= 2048) {
        break;
      }
      i += (127 - k >>> 31);
      j += 1;
    }
    int i2 = paramCharSequence.length();
    int k = m;
    while (j < i2)
    {
      int i3 = paramCharSequence.charAt(j);
      if (i3 < 2048)
      {
        k += (127 - i3 >>> 31);
        m = j;
      }
      else
      {
        int i1 = k + 2;
        k = i1;
        m = j;
        if (55296 <= i3)
        {
          k = i1;
          m = j;
          if (i3 <= 57343) {
            if (Character.codePointAt(paramCharSequence, j) >= 65536)
            {
              m = j + 1;
              k = i1;
            }
            else
            {
              throw new zzld(j, i2);
            }
          }
        }
      }
      j = m + 1;
    }
    k = i + k;
    label208:
    if (k >= n) {
      return k;
    }
    long l = k;
    paramCharSequence = new StringBuilder(54);
    paramCharSequence.append("UTF-8 length does not fit in int: ");
    paramCharSequence.append(l + 4294967296L);
    throw new IllegalArgumentException(paramCharSequence.toString());
  }
  
  static int zza(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return zza.zza(paramCharSequence, paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static boolean zza(byte[] paramArrayOfByte)
  {
    return zza.zza(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static boolean zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return zza.zza(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private static int zzb(int paramInt)
  {
    int i = paramInt;
    if (paramInt > -12) {
      i = -1;
    }
    return i;
  }
  
  private static int zzb(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= -12) && (paramInt2 <= -65)) {
      return paramInt1 ^ paramInt2 << 8;
    }
    return -1;
  }
  
  private static int zzb(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 <= -12) && (paramInt2 <= -65) && (paramInt3 <= -65)) {
      return paramInt1 ^ paramInt2 << 8 ^ paramInt3 << 16;
    }
    return -1;
  }
  
  static String zzb(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws zzih
  {
    return zza.zzb(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private static int zzd(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfByte[(paramInt1 - 1)];
    paramInt2 -= paramInt1;
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 == 2) {
          return zzb(i, paramArrayOfByte[paramInt1], paramArrayOfByte[(paramInt1 + 1)]);
        }
        throw new AssertionError();
      }
      return zzb(i, paramArrayOfByte[paramInt1]);
    }
    return zzb(i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzla.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */