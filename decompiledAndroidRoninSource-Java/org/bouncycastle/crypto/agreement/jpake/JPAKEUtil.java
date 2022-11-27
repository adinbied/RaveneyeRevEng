package org.bouncycastle.crypto.agreement.jpake;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Strings;

public class JPAKEUtil
{
  static final BigInteger ONE = BigInteger.valueOf(1L);
  static final BigInteger ZERO = BigInteger.valueOf(0L);
  
  public static BigInteger calculateA(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4)
  {
    return paramBigInteger3.modPow(paramBigInteger4, paramBigInteger1);
  }
  
  public static BigInteger calculateGA(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4)
  {
    return paramBigInteger2.multiply(paramBigInteger3).multiply(paramBigInteger4).mod(paramBigInteger1);
  }
  
  public static BigInteger calculateGx(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3)
  {
    return paramBigInteger2.modPow(paramBigInteger3, paramBigInteger1);
  }
  
  private static BigInteger calculateHashForZeroKnowledgeProof(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, String paramString, Digest paramDigest)
  {
    paramDigest.reset();
    updateDigestIncludingSize(paramDigest, paramBigInteger1);
    updateDigestIncludingSize(paramDigest, paramBigInteger2);
    updateDigestIncludingSize(paramDigest, paramBigInteger3);
    updateDigestIncludingSize(paramDigest, paramString);
    paramBigInteger1 = new byte[paramDigest.getDigestSize()];
    paramDigest.doFinal(paramBigInteger1, 0);
    return new BigInteger(paramBigInteger1);
  }
  
  public static BigInteger calculateKeyingMaterial(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4, BigInteger paramBigInteger5, BigInteger paramBigInteger6)
  {
    return paramBigInteger3.modPow(paramBigInteger4.multiply(paramBigInteger5).negate().mod(paramBigInteger2), paramBigInteger1).multiply(paramBigInteger6).modPow(paramBigInteger4, paramBigInteger1);
  }
  
  private static byte[] calculateMacKey(BigInteger paramBigInteger, Digest paramDigest)
  {
    paramDigest.reset();
    updateDigest(paramDigest, paramBigInteger);
    updateDigest(paramDigest, "JPAKE_KC");
    paramBigInteger = new byte[paramDigest.getDigestSize()];
    paramDigest.doFinal(paramBigInteger, 0);
    return paramBigInteger;
  }
  
  public static BigInteger calculateMacTag(String paramString1, String paramString2, BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4, BigInteger paramBigInteger5, Digest paramDigest)
  {
    paramBigInteger5 = calculateMacKey(paramBigInteger5, paramDigest);
    paramDigest = new HMac(paramDigest);
    byte[] arrayOfByte = new byte[paramDigest.getMacSize()];
    paramDigest.init(new KeyParameter(paramBigInteger5));
    updateMac(paramDigest, "KC_1_U");
    updateMac(paramDigest, paramString1);
    updateMac(paramDigest, paramString2);
    updateMac(paramDigest, paramBigInteger1);
    updateMac(paramDigest, paramBigInteger2);
    updateMac(paramDigest, paramBigInteger3);
    updateMac(paramDigest, paramBigInteger4);
    paramDigest.doFinal(arrayOfByte, 0);
    Arrays.fill(paramBigInteger5, (byte)0);
    return new BigInteger(arrayOfByte);
  }
  
  public static BigInteger calculateS(char[] paramArrayOfChar)
  {
    return new BigInteger(Strings.toUTF8ByteArray(paramArrayOfChar));
  }
  
  public static BigInteger calculateX2s(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3)
  {
    return paramBigInteger2.multiply(paramBigInteger3).mod(paramBigInteger1);
  }
  
  public static BigInteger[] calculateZeroKnowledgeProof(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4, BigInteger paramBigInteger5, String paramString, Digest paramDigest, SecureRandom paramSecureRandom)
  {
    paramSecureRandom = BigIntegers.createRandomInRange(ZERO, paramBigInteger2.subtract(ONE), paramSecureRandom);
    paramBigInteger1 = paramBigInteger3.modPow(paramSecureRandom, paramBigInteger1);
    return new BigInteger[] { paramBigInteger1, paramSecureRandom.subtract(paramBigInteger5.multiply(calculateHashForZeroKnowledgeProof(paramBigInteger3, paramBigInteger1, paramBigInteger4, paramString, paramDigest))).mod(paramBigInteger2) };
  }
  
  public static BigInteger generateX1(BigInteger paramBigInteger, SecureRandom paramSecureRandom)
  {
    return BigIntegers.createRandomInRange(ZERO, paramBigInteger.subtract(ONE), paramSecureRandom);
  }
  
  public static BigInteger generateX2(BigInteger paramBigInteger, SecureRandom paramSecureRandom)
  {
    BigInteger localBigInteger = ONE;
    return BigIntegers.createRandomInRange(localBigInteger, paramBigInteger.subtract(localBigInteger), paramSecureRandom);
  }
  
  private static byte[] intToByteArray(int paramInt)
  {
    return new byte[] { (byte)(paramInt >>> 24), (byte)(paramInt >>> 16), (byte)(paramInt >>> 8), (byte)paramInt };
  }
  
  private static void updateDigest(Digest paramDigest, String paramString)
  {
    paramString = Strings.toUTF8ByteArray(paramString);
    paramDigest.update(paramString, 0, paramString.length);
    Arrays.fill(paramString, (byte)0);
  }
  
  private static void updateDigest(Digest paramDigest, BigInteger paramBigInteger)
  {
    paramBigInteger = BigIntegers.asUnsignedByteArray(paramBigInteger);
    paramDigest.update(paramBigInteger, 0, paramBigInteger.length);
    Arrays.fill(paramBigInteger, (byte)0);
  }
  
  private static void updateDigestIncludingSize(Digest paramDigest, String paramString)
  {
    paramString = Strings.toUTF8ByteArray(paramString);
    paramDigest.update(intToByteArray(paramString.length), 0, 4);
    paramDigest.update(paramString, 0, paramString.length);
    Arrays.fill(paramString, (byte)0);
  }
  
  private static void updateDigestIncludingSize(Digest paramDigest, BigInteger paramBigInteger)
  {
    paramBigInteger = BigIntegers.asUnsignedByteArray(paramBigInteger);
    paramDigest.update(intToByteArray(paramBigInteger.length), 0, 4);
    paramDigest.update(paramBigInteger, 0, paramBigInteger.length);
    Arrays.fill(paramBigInteger, (byte)0);
  }
  
  private static void updateMac(Mac paramMac, String paramString)
  {
    paramString = Strings.toUTF8ByteArray(paramString);
    paramMac.update(paramString, 0, paramString.length);
    Arrays.fill(paramString, (byte)0);
  }
  
  private static void updateMac(Mac paramMac, BigInteger paramBigInteger)
  {
    paramBigInteger = BigIntegers.asUnsignedByteArray(paramBigInteger);
    paramMac.update(paramBigInteger, 0, paramBigInteger.length);
    Arrays.fill(paramBigInteger, (byte)0);
  }
  
  public static void validateGa(BigInteger paramBigInteger)
    throws CryptoException
  {
    if (!paramBigInteger.equals(ONE)) {
      return;
    }
    throw new CryptoException("ga is equal to 1.  It should not be.  The chances of this happening are on the order of 2^160 for a 160-bit q.  Try again.");
  }
  
  public static void validateGx4(BigInteger paramBigInteger)
    throws CryptoException
  {
    if (!paramBigInteger.equals(ONE)) {
      return;
    }
    throw new CryptoException("g^x validation failed.  g^x should not be 1.");
  }
  
  public static void validateMacTag(String paramString1, String paramString2, BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4, BigInteger paramBigInteger5, Digest paramDigest, BigInteger paramBigInteger6)
    throws CryptoException
  {
    if (calculateMacTag(paramString2, paramString1, paramBigInteger3, paramBigInteger4, paramBigInteger1, paramBigInteger2, paramBigInteger5, paramDigest).equals(paramBigInteger6)) {
      return;
    }
    throw new CryptoException("Partner MacTag validation failed. Therefore, the password, MAC, or digest algorithm of each participant does not match.");
  }
  
  public static void validateNotNull(Object paramObject, String paramString)
  {
    if (paramObject != null) {
      return;
    }
    paramObject = new StringBuilder();
    ((StringBuilder)paramObject).append(paramString);
    ((StringBuilder)paramObject).append(" must not be null");
    throw new NullPointerException(((StringBuilder)paramObject).toString());
  }
  
  public static void validateParticipantIdsDiffer(String paramString1, String paramString2)
    throws CryptoException
  {
    if (!paramString1.equals(paramString2)) {
      return;
    }
    paramString2 = new StringBuilder();
    paramString2.append("Both participants are using the same participantId (");
    paramString2.append(paramString1);
    paramString2.append("). This is not allowed. ");
    paramString2.append("Each participant must use a unique participantId.");
    throw new CryptoException(paramString2.toString());
  }
  
  public static void validateParticipantIdsEqual(String paramString1, String paramString2)
    throws CryptoException
  {
    if (paramString1.equals(paramString2)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Received payload from incorrect partner (");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("). Expected to receive payload from ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    throw new CryptoException(localStringBuilder.toString());
  }
  
  public static void validateZeroKnowledgeProof(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4, BigInteger[] paramArrayOfBigInteger, String paramString, Digest paramDigest)
    throws CryptoException
  {
    BigInteger localBigInteger = paramArrayOfBigInteger[0];
    paramArrayOfBigInteger = paramArrayOfBigInteger[1];
    paramString = calculateHashForZeroKnowledgeProof(paramBigInteger3, localBigInteger, paramBigInteger4, paramString, paramDigest);
    if ((paramBigInteger4.compareTo(ZERO) == 1) && (paramBigInteger4.compareTo(paramBigInteger1) == -1) && (paramBigInteger4.modPow(paramBigInteger2, paramBigInteger1).compareTo(ONE) == 0) && (paramBigInteger3.modPow(paramArrayOfBigInteger, paramBigInteger1).multiply(paramBigInteger4.modPow(paramString, paramBigInteger1)).mod(paramBigInteger1).compareTo(localBigInteger) == 0)) {
      return;
    }
    throw new CryptoException("Zero-knowledge proof validation failed");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\agreement\jpake\JPAKEUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */