package org.bouncycastle.pqc.math.linearalgebra;

import java.math.BigInteger;

public final class BigIntUtils
{
  public static boolean equals(BigInteger[] paramArrayOfBigInteger1, BigInteger[] paramArrayOfBigInteger2)
  {
    int i = paramArrayOfBigInteger1.length;
    int j = paramArrayOfBigInteger2.length;
    boolean bool = false;
    if (i != j) {
      return false;
    }
    i = 0;
    j = 0;
    while (i < paramArrayOfBigInteger1.length)
    {
      j |= paramArrayOfBigInteger1[i].compareTo(paramArrayOfBigInteger2[i]);
      i += 1;
    }
    if (j == 0) {
      bool = true;
    }
    return bool;
  }
  
  public static void fill(BigInteger[] paramArrayOfBigInteger, BigInteger paramBigInteger)
  {
    int i = paramArrayOfBigInteger.length - 1;
    while (i >= 0)
    {
      paramArrayOfBigInteger[i] = paramBigInteger;
      i -= 1;
    }
  }
  
  public static BigInteger[] subArray(BigInteger[] paramArrayOfBigInteger, int paramInt1, int paramInt2)
  {
    paramInt2 -= paramInt1;
    BigInteger[] arrayOfBigInteger = new BigInteger[paramInt2];
    System.arraycopy(paramArrayOfBigInteger, paramInt1, arrayOfBigInteger, 0, paramInt2);
    return arrayOfBigInteger;
  }
  
  public static int[] toIntArray(BigInteger[] paramArrayOfBigInteger)
  {
    int[] arrayOfInt = new int[paramArrayOfBigInteger.length];
    int i = 0;
    while (i < paramArrayOfBigInteger.length)
    {
      arrayOfInt[i] = paramArrayOfBigInteger[i].intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  public static int[] toIntArrayModQ(int paramInt, BigInteger[] paramArrayOfBigInteger)
  {
    BigInteger localBigInteger = BigInteger.valueOf(paramInt);
    int[] arrayOfInt = new int[paramArrayOfBigInteger.length];
    paramInt = 0;
    while (paramInt < paramArrayOfBigInteger.length)
    {
      arrayOfInt[paramInt] = paramArrayOfBigInteger[paramInt].mod(localBigInteger).intValue();
      paramInt += 1;
    }
    return arrayOfInt;
  }
  
  public static byte[] toMinimalByteArray(BigInteger paramBigInteger)
  {
    byte[] arrayOfByte = paramBigInteger.toByteArray();
    if (arrayOfByte.length != 1)
    {
      if ((paramBigInteger.bitLength() & 0x7) != 0) {
        return arrayOfByte;
      }
      int i = paramBigInteger.bitLength() >> 3;
      paramBigInteger = new byte[i];
      System.arraycopy(arrayOfByte, 1, paramBigInteger, 0, i);
      return paramBigInteger;
    }
    return arrayOfByte;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\math\linearalgebra\BigIntUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */