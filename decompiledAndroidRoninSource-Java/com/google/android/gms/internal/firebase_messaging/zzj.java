package com.google.android.gms.internal.firebase_messaging;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Deque;

public final class zzj
{
  private static final OutputStream zza = new zzi();
  
  public static InputStream zza(InputStream paramInputStream, long paramLong)
  {
    return new zzl(paramInputStream, 1048577L);
  }
  
  public static byte[] zza(InputStream paramInputStream)
    throws IOException
  {
    zzg.zza(paramInputStream);
    ArrayDeque localArrayDeque = new ArrayDeque(20);
    int i = 8192;
    int j = 0;
    while (j < 2147483639)
    {
      int m = Math.min(i, 2147483639 - j);
      byte[] arrayOfByte = new byte[m];
      localArrayDeque.add(arrayOfByte);
      int k = 0;
      while (k < m)
      {
        int n = paramInputStream.read(arrayOfByte, k, m - k);
        if (n == -1) {
          return zza(localArrayDeque, j);
        }
        k += n;
        j += n;
      }
      i = zzn.zza(i, 2);
    }
    if (paramInputStream.read() == -1) {
      return zza(localArrayDeque, 2147483639);
    }
    throw new OutOfMemoryError("input is too large to fit in a byte array");
  }
  
  private static byte[] zza(Deque<byte[]> paramDeque, int paramInt)
  {
    byte[] arrayOfByte1 = new byte[paramInt];
    int i = paramInt;
    while (i > 0)
    {
      byte[] arrayOfByte2 = (byte[])paramDeque.removeFirst();
      int j = Math.min(i, arrayOfByte2.length);
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, paramInt - i, j);
      i -= j;
    }
    return arrayOfByte1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\firebase_messaging\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */