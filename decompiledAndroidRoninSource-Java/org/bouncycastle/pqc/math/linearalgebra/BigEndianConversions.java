package org.bouncycastle.pqc.math.linearalgebra;

public final class BigEndianConversions
{
  public static void I2OSP(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int i = paramInt2 + 1;
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >>> 24));
    paramInt2 = i + 1;
    paramArrayOfByte[i] = ((byte)(paramInt1 >>> 16));
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >>> 8));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)paramInt1);
  }
  
  public static void I2OSP(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = paramInt3 - 1;
    paramInt3 = i;
    while (paramInt3 >= 0)
    {
      paramArrayOfByte[(paramInt2 + paramInt3)] = ((byte)(paramInt1 >>> (i - paramInt3) * 8));
      paramInt3 -= 1;
    }
  }
  
  public static void I2OSP(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt + 1;
    paramArrayOfByte[paramInt] = ((byte)(int)(paramLong >>> 56));
    paramInt = i + 1;
    paramArrayOfByte[i] = ((byte)(int)(paramLong >>> 48));
    i = paramInt + 1;
    paramArrayOfByte[paramInt] = ((byte)(int)(paramLong >>> 40));
    paramInt = i + 1;
    paramArrayOfByte[i] = ((byte)(int)(paramLong >>> 32));
    i = paramInt + 1;
    paramArrayOfByte[paramInt] = ((byte)(int)(paramLong >>> 24));
    paramInt = i + 1;
    paramArrayOfByte[i] = ((byte)(int)(paramLong >>> 16));
    paramArrayOfByte[paramInt] = ((byte)(int)(paramLong >>> 8));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)paramLong);
  }
  
  public static byte[] I2OSP(int paramInt)
  {
    return new byte[] { (byte)(paramInt >>> 24), (byte)(paramInt >>> 16), (byte)(paramInt >>> 8), (byte)paramInt };
  }
  
  public static byte[] I2OSP(int paramInt1, int paramInt2)
    throws ArithmeticException
  {
    if (paramInt1 < 0) {
      return null;
    }
    int k = IntegerFunctions.ceilLog256(paramInt1);
    if (k <= paramInt2)
    {
      byte[] arrayOfByte = new byte[paramInt2];
      int j = paramInt2 - 1;
      int i = j;
      while (i >= paramInt2 - k)
      {
        arrayOfByte[i] = ((byte)(paramInt1 >>> (j - i) * 8));
        i -= 1;
      }
      return arrayOfByte;
    }
    throw new ArithmeticException("Cannot encode given integer into specified number of octets.");
  }
  
  public static byte[] I2OSP(long paramLong)
  {
    return new byte[] { (byte)(int)(paramLong >>> 56), (byte)(int)(paramLong >>> 48), (byte)(int)(paramLong >>> 40), (byte)(int)(paramLong >>> 32), (byte)(int)(paramLong >>> 24), (byte)(int)(paramLong >>> 16), (byte)(int)(paramLong >>> 8), (byte)(int)paramLong };
  }
  
  public static int OS2IP(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length <= 4)
    {
      int j = paramArrayOfByte.length;
      int i = 0;
      if (j == 0) {
        return 0;
      }
      j = 0;
      while (i < paramArrayOfByte.length)
      {
        j |= (paramArrayOfByte[i] & 0xFF) << (paramArrayOfByte.length - 1 - i) * 8;
        i += 1;
      }
      return j;
    }
    throw new ArithmeticException("invalid input length");
  }
  
  public static int OS2IP(byte[] paramArrayOfByte, int paramInt)
  {
    int j = paramInt + 1;
    paramInt = paramArrayOfByte[paramInt];
    int i = j + 1;
    j = paramArrayOfByte[j];
    int k = paramArrayOfByte[i];
    return paramArrayOfByte[(i + 1)] & 0xFF | (paramInt & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8;
  }
  
  public static int OS2IP(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = paramArrayOfByte.length;
    int i = 0;
    if (j != 0)
    {
      if (paramArrayOfByte.length < paramInt1 + paramInt2 - 1) {
        return 0;
      }
      j = 0;
      while (i < paramInt2)
      {
        j |= (paramArrayOfByte[(paramInt1 + i)] & 0xFF) << (paramInt2 - i - 1) * 8;
        i += 1;
      }
      return j;
    }
    return 0;
  }
  
  public static long OS2LIP(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt + 1;
    long l1 = paramArrayOfByte[paramInt];
    paramInt = i + 1;
    long l2 = paramArrayOfByte[i];
    i = paramInt + 1;
    long l3 = paramArrayOfByte[paramInt];
    paramInt = i + 1;
    long l4 = paramArrayOfByte[i];
    i = paramInt + 1;
    long l5 = paramArrayOfByte[paramInt];
    paramInt = i + 1;
    long l6 = (paramArrayOfByte[i] & 0xFF) << 16;
    long l7 = (paramArrayOfByte[paramInt] & 0xFF) << 8;
    return paramArrayOfByte[(paramInt + 1)] & 0xFF | (l1 & 0xFF) << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l4 & 0xFF) << 32 | (0xFF & l5) << 24 | l6 | l7;
  }
  
  public static byte[] toByteArray(int[] paramArrayOfInt)
  {
    byte[] arrayOfByte = new byte[paramArrayOfInt.length << 2];
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      I2OSP(paramArrayOfInt[i], arrayOfByte, i << 2);
      i += 1;
    }
    return arrayOfByte;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\math\linearalgebra\BigEndianConversions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */