package org.bouncycastle.util;

import java.math.BigInteger;
import java.security.SecureRandom;

public final class BigIntegers
{
  private static final int MAX_ITERATIONS = 1000;
  private static final BigInteger ZERO = BigInteger.valueOf(0L);
  
  public static byte[] asUnsignedByteArray(int paramInt, BigInteger paramBigInteger)
  {
    paramBigInteger = paramBigInteger.toByteArray();
    if (paramBigInteger.length == paramInt) {
      return paramBigInteger;
    }
    int i = 0;
    if (paramBigInteger[0] == 0) {
      i = 1;
    }
    int j = paramBigInteger.length - i;
    if (j <= paramInt)
    {
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(paramBigInteger, i, arrayOfByte, paramInt - j, j);
      return arrayOfByte;
    }
    throw new IllegalArgumentException("standard length exceeded for value");
  }
  
  public static byte[] asUnsignedByteArray(BigInteger paramBigInteger)
  {
    paramBigInteger = paramBigInteger.toByteArray();
    if (paramBigInteger[0] == 0)
    {
      int i = paramBigInteger.length - 1;
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(paramBigInteger, 1, arrayOfByte, 0, i);
      return arrayOfByte;
    }
    return paramBigInteger;
  }
  
  public static BigInteger createRandomInRange(BigInteger paramBigInteger1, BigInteger paramBigInteger2, SecureRandom paramSecureRandom)
  {
    int i = paramBigInteger1.compareTo(paramBigInteger2);
    if (i >= 0)
    {
      if (i <= 0) {
        return paramBigInteger1;
      }
      throw new IllegalArgumentException("'min' may not be greater than 'max'");
    }
    if (paramBigInteger1.bitLength() > paramBigInteger2.bitLength() / 2) {
      return createRandomInRange(ZERO, paramBigInteger2.subtract(paramBigInteger1), paramSecureRandom).add(paramBigInteger1);
    }
    i = 0;
    while (i < 1000)
    {
      BigInteger localBigInteger = new BigInteger(paramBigInteger2.bitLength(), paramSecureRandom);
      if ((localBigInteger.compareTo(paramBigInteger1) >= 0) && (localBigInteger.compareTo(paramBigInteger2) <= 0)) {
        return localBigInteger;
      }
      i += 1;
    }
    return new BigInteger(paramBigInteger2.subtract(paramBigInteger1).bitLength() - 1, paramSecureRandom).add(paramBigInteger1);
  }
  
  public static BigInteger fromUnsignedByteArray(byte[] paramArrayOfByte)
  {
    return new BigInteger(1, paramArrayOfByte);
  }
  
  public static BigInteger fromUnsignedByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte;
    if (paramInt1 == 0)
    {
      arrayOfByte = paramArrayOfByte;
      if (paramInt2 == paramArrayOfByte.length) {}
    }
    else
    {
      arrayOfByte = new byte[paramInt2];
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    }
    return new BigInteger(1, arrayOfByte);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\BigIntegers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */