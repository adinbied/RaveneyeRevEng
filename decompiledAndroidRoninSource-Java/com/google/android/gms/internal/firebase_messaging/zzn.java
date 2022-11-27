package com.google.android.gms.internal.firebase_messaging;

public final class zzn
{
  private static final byte[] zza = { 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0 };
  private static final int[] zzb = { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000 };
  private static final int[] zzc = { 3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE };
  private static final int[] zzd = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600 };
  private static int[] zze = { Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33 };
  
  public static int zza(int paramInt1, int paramInt2)
  {
    long l = paramInt1 << 1;
    if (l > 2147483647L) {
      return Integer.MAX_VALUE;
    }
    if (l < -2147483648L) {
      return Integer.MIN_VALUE;
    }
    return (int)l;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\firebase_messaging\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */