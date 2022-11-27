package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzic
{
  static final Charset zza = Charset.forName("UTF-8");
  public static final byte[] zzb;
  private static final Charset zzc = Charset.forName("ISO-8859-1");
  private static final ByteBuffer zzd;
  private static final zzhd zze;
  
  static
  {
    byte[] arrayOfByte = new byte[0];
    zzb = arrayOfByte;
    zzd = ByteBuffer.wrap(arrayOfByte);
    arrayOfByte = zzb;
    zze = zzhd.zza(arrayOfByte, 0, arrayOfByte.length, false);
  }
  
  static int zza(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    while (i < paramInt2 + paramInt3)
    {
      paramInt1 = paramInt1 * 31 + paramArrayOfByte[i];
      i += 1;
    }
    return paramInt1;
  }
  
  public static int zza(long paramLong)
  {
    return (int)(paramLong ^ paramLong >>> 32);
  }
  
  public static int zza(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1231;
    }
    return 1237;
  }
  
  static <T> T zza(T paramT)
  {
    if (paramT != null) {
      return paramT;
    }
    throw null;
  }
  
  static Object zza(Object paramObject1, Object paramObject2)
  {
    return ((zzjh)paramObject1).zzbs().zza((zzjh)paramObject2).zzy();
  }
  
  static <T> T zza(T paramT, String paramString)
  {
    if (paramT != null) {
      return paramT;
    }
    throw new NullPointerException(paramString);
  }
  
  static boolean zza(zzjh paramzzjh)
  {
    if ((paramzzjh instanceof zzgj)) {
      paramzzjh = (zzgj)paramzzjh;
    }
    return false;
  }
  
  public static boolean zza(byte[] paramArrayOfByte)
  {
    return zzla.zza(paramArrayOfByte);
  }
  
  public static String zzb(byte[] paramArrayOfByte)
  {
    return new String(paramArrayOfByte, zza);
  }
  
  public static int zzc(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    int j = zza(i, paramArrayOfByte, 0, i);
    i = j;
    if (j == 0) {
      i = 1;
    }
    return i;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */