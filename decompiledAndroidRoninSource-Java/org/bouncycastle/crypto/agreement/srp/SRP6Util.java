package org.bouncycastle.crypto.agreement.srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.BigIntegers;

public class SRP6Util
{
  private static BigInteger ONE = BigInteger.valueOf(1L);
  private static BigInteger ZERO = BigInteger.valueOf(0L);
  
  public static BigInteger calculateK(Digest paramDigest, BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    return hashPaddedPair(paramDigest, paramBigInteger1, paramBigInteger1, paramBigInteger2);
  }
  
  public static BigInteger calculateKey(Digest paramDigest, BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    paramBigInteger1 = getPadded(paramBigInteger2, (paramBigInteger1.bitLength() + 7) / 8);
    paramDigest.update(paramBigInteger1, 0, paramBigInteger1.length);
    paramBigInteger1 = new byte[paramDigest.getDigestSize()];
    paramDigest.doFinal(paramBigInteger1, 0);
    return new BigInteger(1, paramBigInteger1);
  }
  
  public static BigInteger calculateM1(Digest paramDigest, BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4)
  {
    return hashPaddedTriplet(paramDigest, paramBigInteger1, paramBigInteger2, paramBigInteger3, paramBigInteger4);
  }
  
  public static BigInteger calculateM2(Digest paramDigest, BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4)
  {
    return hashPaddedTriplet(paramDigest, paramBigInteger1, paramBigInteger2, paramBigInteger3, paramBigInteger4);
  }
  
  public static BigInteger calculateU(Digest paramDigest, BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3)
  {
    return hashPaddedPair(paramDigest, paramBigInteger1, paramBigInteger2, paramBigInteger3);
  }
  
  public static BigInteger calculateX(Digest paramDigest, BigInteger paramBigInteger, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    int i = paramDigest.getDigestSize();
    paramBigInteger = new byte[i];
    paramDigest.update(paramArrayOfByte2, 0, paramArrayOfByte2.length);
    paramDigest.update((byte)58);
    paramDigest.update(paramArrayOfByte3, 0, paramArrayOfByte3.length);
    paramDigest.doFinal(paramBigInteger, 0);
    paramDigest.update(paramArrayOfByte1, 0, paramArrayOfByte1.length);
    paramDigest.update(paramBigInteger, 0, i);
    paramDigest.doFinal(paramBigInteger, 0);
    return new BigInteger(1, paramBigInteger);
  }
  
  public static BigInteger generatePrivateValue(Digest paramDigest, BigInteger paramBigInteger1, BigInteger paramBigInteger2, SecureRandom paramSecureRandom)
  {
    int i = Math.min(256, paramBigInteger1.bitLength() / 2);
    return BigIntegers.createRandomInRange(ONE.shiftLeft(i - 1), paramBigInteger1.subtract(ONE), paramSecureRandom);
  }
  
  private static byte[] getPadded(BigInteger paramBigInteger, int paramInt)
  {
    byte[] arrayOfByte = BigIntegers.asUnsignedByteArray(paramBigInteger);
    paramBigInteger = arrayOfByte;
    if (arrayOfByte.length < paramInt)
    {
      paramBigInteger = new byte[paramInt];
      System.arraycopy(arrayOfByte, 0, paramBigInteger, paramInt - arrayOfByte.length, arrayOfByte.length);
    }
    return paramBigInteger;
  }
  
  private static BigInteger hashPaddedPair(Digest paramDigest, BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3)
  {
    int i = (paramBigInteger1.bitLength() + 7) / 8;
    paramBigInteger1 = getPadded(paramBigInteger2, i);
    paramBigInteger2 = getPadded(paramBigInteger3, i);
    paramDigest.update(paramBigInteger1, 0, paramBigInteger1.length);
    paramDigest.update(paramBigInteger2, 0, paramBigInteger2.length);
    paramBigInteger1 = new byte[paramDigest.getDigestSize()];
    paramDigest.doFinal(paramBigInteger1, 0);
    return new BigInteger(1, paramBigInteger1);
  }
  
  private static BigInteger hashPaddedTriplet(Digest paramDigest, BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4)
  {
    int i = (paramBigInteger1.bitLength() + 7) / 8;
    paramBigInteger1 = getPadded(paramBigInteger2, i);
    paramBigInteger2 = getPadded(paramBigInteger3, i);
    paramBigInteger3 = getPadded(paramBigInteger4, i);
    paramDigest.update(paramBigInteger1, 0, paramBigInteger1.length);
    paramDigest.update(paramBigInteger2, 0, paramBigInteger2.length);
    paramDigest.update(paramBigInteger3, 0, paramBigInteger3.length);
    paramBigInteger1 = new byte[paramDigest.getDigestSize()];
    paramDigest.doFinal(paramBigInteger1, 0);
    return new BigInteger(1, paramBigInteger1);
  }
  
  public static BigInteger validatePublicValue(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
    throws CryptoException
  {
    paramBigInteger1 = paramBigInteger2.mod(paramBigInteger1);
    if (!paramBigInteger1.equals(ZERO)) {
      return paramBigInteger1;
    }
    throw new CryptoException("Invalid public value: 0");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\agreement\srp\SRP6Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */