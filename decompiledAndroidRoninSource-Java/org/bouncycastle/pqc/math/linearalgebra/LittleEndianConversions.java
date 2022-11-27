package org.bouncycastle.pqc.math.linearalgebra;

public final class LittleEndianConversions
{
  public static void I2OSP(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int i = paramInt2 + 1;
    paramArrayOfByte[paramInt2] = ((byte)paramInt1);
    paramInt2 = i + 1;
    paramArrayOfByte[i] = ((byte)(paramInt1 >>> 8));
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >>> 16));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >>> 24));
  }
  
  public static void I2OSP(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    paramInt3 -= 1;
    while (paramInt3 >= 0)
    {
      paramArrayOfByte[(paramInt2 + paramInt3)] = ((byte)(paramInt1 >>> paramInt3 * 8));
      paramInt3 -= 1;
    }
  }
  
  public static void I2OSP(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt + 1;
    paramArrayOfByte[paramInt] = ((byte)(int)paramLong);
    paramInt = i + 1;
    paramArrayOfByte[i] = ((byte)(int)(paramLong >>> 8));
    i = paramInt + 1;
    paramArrayOfByte[paramInt] = ((byte)(int)(paramLong >>> 16));
    paramInt = i + 1;
    paramArrayOfByte[i] = ((byte)(int)(paramLong >>> 24));
    i = paramInt + 1;
    paramArrayOfByte[paramInt] = ((byte)(int)(paramLong >>> 32));
    paramInt = i + 1;
    paramArrayOfByte[i] = ((byte)(int)(paramLong >>> 40));
    paramArrayOfByte[paramInt] = ((byte)(int)(paramLong >>> 48));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >>> 56));
  }
  
  public static byte[] I2OSP(int paramInt)
  {
    return new byte[] { (byte)paramInt, (byte)(paramInt >>> 8), (byte)(paramInt >>> 16), (byte)(paramInt >>> 24) };
  }
  
  public static byte[] I2OSP(long paramLong)
  {
    return new byte[] { (byte)(int)paramLong, (byte)(int)(paramLong >>> 8), (byte)(int)(paramLong >>> 16), (byte)(int)(paramLong >>> 24), (byte)(int)(paramLong >>> 32), (byte)(int)(paramLong >>> 40), (byte)(int)(paramLong >>> 48), (byte)(int)(paramLong >>> 56) };
  }
  
  public static int OS2IP(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte[0];
    int j = paramArrayOfByte[1];
    int k = paramArrayOfByte[2];
    return (paramArrayOfByte[3] & 0xFF) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
  }
  
  public static int OS2IP(byte[] paramArrayOfByte, int paramInt)
  {
    int j = paramInt + 1;
    paramInt = paramArrayOfByte[paramInt];
    int i = j + 1;
    j = paramArrayOfByte[j];
    int k = paramArrayOfByte[i];
    return (paramArrayOfByte[(i + 1)] & 0xFF) << 24 | paramInt & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
  }
  
  public static int OS2IP(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt2 -= 1;
    int i = 0;
    while (paramInt2 >= 0)
    {
      i |= (paramArrayOfByte[(paramInt1 + paramInt2)] & 0xFF) << paramInt2 * 8;
      paramInt2 -= 1;
    }
    return i;
  }
  
  public static long OS2LIP(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt + 1;
    long l1 = paramArrayOfByte[paramInt] & 0xFF;
    paramInt = i + 1;
    long l2 = (paramArrayOfByte[i] & 0xFF) << 8;
    i = paramInt + 1;
    long l3 = (paramArrayOfByte[paramInt] & 0xFF) << 16;
    paramInt = i + 1;
    long l4 = paramArrayOfByte[i];
    i = paramInt + 1;
    long l5 = paramArrayOfByte[paramInt];
    paramInt = i + 1;
    long l6 = paramArrayOfByte[i];
    long l7 = paramArrayOfByte[paramInt];
    return (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 56 | l1 | l2 | l3 | (l4 & 0xFF) << 24 | (l5 & 0xFF) << 32 | (l6 & 0xFF) << 40 | (l7 & 0xFF) << 48;
  }
  
  public static byte[] toByteArray(int[] paramArrayOfInt, int paramInt)
  {
    int k = paramArrayOfInt.length;
    byte[] arrayOfByte = new byte[paramInt];
    int j = 0;
    int i = 0;
    while (j <= k - 2)
    {
      I2OSP(paramArrayOfInt[j], arrayOfByte, i);
      j += 1;
      i += 4;
    }
    I2OSP(paramArrayOfInt[(k - 1)], arrayOfByte, i, paramInt - i);
    return arrayOfByte;
  }
  
  public static int[] toIntArray(byte[] paramArrayOfByte)
  {
    int m = (paramArrayOfByte.length + 3) / 4;
    int k = paramArrayOfByte.length & 0x3;
    int[] arrayOfInt = new int[m];
    int j = 0;
    int i = 0;
    while (j <= m - 2)
    {
      arrayOfInt[j] = OS2IP(paramArrayOfByte, i);
      j += 1;
      i += 4;
    }
    j = m - 1;
    if (k != 0)
    {
      arrayOfInt[j] = OS2IP(paramArrayOfByte, i, k);
      return arrayOfInt;
    }
    arrayOfInt[j] = OS2IP(paramArrayOfByte, i);
    return arrayOfInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\math\linearalgebra\LittleEndianConversions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */