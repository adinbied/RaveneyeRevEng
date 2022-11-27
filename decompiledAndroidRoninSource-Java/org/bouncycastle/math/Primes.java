package org.bouncycastle.math;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

public abstract class Primes
{
  private static final BigInteger ONE = BigInteger.valueOf(1L);
  public static final int SMALL_FACTOR_LIMIT = 211;
  private static final BigInteger THREE = BigInteger.valueOf(3L);
  private static final BigInteger TWO = BigInteger.valueOf(2L);
  
  private static void checkCandidate(BigInteger paramBigInteger, String paramString)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 1) && (paramBigInteger.bitLength() >= 2)) {
      return;
    }
    paramBigInteger = new StringBuilder();
    paramBigInteger.append("'");
    paramBigInteger.append(paramString);
    paramBigInteger.append("' must be non-null and >= 2");
    throw new IllegalArgumentException(paramBigInteger.toString());
  }
  
  public static MROutput enhancedMRProbablePrimeTest(BigInteger paramBigInteger, SecureRandom paramSecureRandom, int paramInt)
  {
    checkCandidate(paramBigInteger, "candidate");
    if (paramSecureRandom != null)
    {
      if (paramInt >= 1)
      {
        if (paramBigInteger.bitLength() == 2) {
          return MROutput.access$000();
        }
        if (!paramBigInteger.testBit(0)) {
          return MROutput.provablyCompositeWithFactor(TWO);
        }
        BigInteger localBigInteger1 = paramBigInteger.subtract(ONE);
        BigInteger localBigInteger2 = paramBigInteger.subtract(TWO);
        int k = localBigInteger1.getLowestSetBit();
        BigInteger localBigInteger3 = localBigInteger1.shiftRight(k);
        int i = 0;
        while (i < paramInt)
        {
          Object localObject1 = BigIntegers.createRandomInRange(TWO, localBigInteger2, paramSecureRandom);
          Object localObject2 = ((BigInteger)localObject1).gcd(paramBigInteger);
          if (((BigInteger)localObject2).compareTo(ONE) > 0) {
            return MROutput.provablyCompositeWithFactor((BigInteger)localObject2);
          }
          localObject1 = ((BigInteger)localObject1).modPow(localBigInteger3, paramBigInteger);
          if ((!((BigInteger)localObject1).equals(ONE)) && (!((BigInteger)localObject1).equals(localBigInteger1)))
          {
            int j = 1;
            while (j < k)
            {
              localObject2 = ((BigInteger)localObject1).modPow(TWO, paramBigInteger);
              if (((BigInteger)localObject2).equals(localBigInteger1))
              {
                j = 1;
                break label224;
              }
              if (((BigInteger)localObject2).equals(ONE)) {
                break label221;
              }
              j += 1;
              localObject1 = localObject2;
            }
            localObject2 = localObject1;
            label221:
            j = 0;
            label224:
            if (j == 0)
            {
              if (!((BigInteger)localObject2).equals(ONE))
              {
                localObject1 = ((BigInteger)localObject2).modPow(TWO, paramBigInteger);
                if (((BigInteger)localObject1).equals(ONE)) {
                  localObject1 = localObject2;
                }
              }
              paramBigInteger = ((BigInteger)localObject1).subtract(ONE).gcd(paramBigInteger);
              if (paramBigInteger.compareTo(ONE) > 0) {
                return MROutput.provablyCompositeWithFactor(paramBigInteger);
              }
              return MROutput.access$200();
            }
          }
          i += 1;
        }
        return MROutput.access$000();
      }
      throw new IllegalArgumentException("'iterations' must be > 0");
    }
    throw new IllegalArgumentException("'random' cannot be null");
  }
  
  private static int extract32(byte[] paramArrayOfByte)
  {
    int m = Math.min(4, paramArrayOfByte.length);
    int i = 0;
    int j = 0;
    while (i < m)
    {
      int n = paramArrayOfByte.length;
      int k = i + 1;
      j |= (paramArrayOfByte[(n - k)] & 0xFF) << i * 8;
      i = k;
    }
    return j;
  }
  
  public static STOutput generateSTRandomPrime(Digest paramDigest, int paramInt, byte[] paramArrayOfByte)
  {
    if (paramDigest != null)
    {
      if (paramInt >= 2)
      {
        if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
          return implSTRandomPrime(paramDigest, paramInt, Arrays.clone(paramArrayOfByte));
        }
        throw new IllegalArgumentException("'inputSeed' cannot be null or empty");
      }
      throw new IllegalArgumentException("'length' must be >= 2");
    }
    throw new IllegalArgumentException("'hash' cannot be null");
  }
  
  public static boolean hasAnySmallFactors(BigInteger paramBigInteger)
  {
    checkCandidate(paramBigInteger, "candidate");
    return implHasAnySmallFactors(paramBigInteger);
  }
  
  private static void hash(Digest paramDigest, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    paramDigest.update(paramArrayOfByte1, 0, paramArrayOfByte1.length);
    paramDigest.doFinal(paramArrayOfByte2, paramInt);
  }
  
  private static BigInteger hashGen(Digest paramDigest, byte[] paramArrayOfByte, int paramInt)
  {
    int k = paramDigest.getDigestSize();
    int j = paramInt * k;
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < paramInt)
    {
      j -= k;
      hash(paramDigest, paramArrayOfByte, arrayOfByte, j);
      inc(paramArrayOfByte, 1);
      i += 1;
    }
    return new BigInteger(1, arrayOfByte);
  }
  
  private static boolean implHasAnySmallFactors(BigInteger paramBigInteger)
  {
    int i = paramBigInteger.mod(BigInteger.valueOf(223092870)).intValue();
    if ((i % 2 != 0) && (i % 3 != 0) && (i % 5 != 0) && (i % 7 != 0) && (i % 11 != 0) && (i % 13 != 0) && (i % 17 != 0) && (i % 19 != 0))
    {
      if (i % 23 == 0) {
        return true;
      }
      i = paramBigInteger.mod(BigInteger.valueOf(58642669)).intValue();
      if ((i % 29 != 0) && (i % 31 != 0) && (i % 37 != 0) && (i % 41 != 0))
      {
        if (i % 43 == 0) {
          return true;
        }
        i = paramBigInteger.mod(BigInteger.valueOf(600662303)).intValue();
        if ((i % 47 != 0) && (i % 53 != 0) && (i % 59 != 0) && (i % 61 != 0))
        {
          if (i % 67 == 0) {
            return true;
          }
          i = paramBigInteger.mod(BigInteger.valueOf(33984931)).intValue();
          if ((i % 71 != 0) && (i % 73 != 0) && (i % 79 != 0))
          {
            if (i % 83 == 0) {
              return true;
            }
            i = paramBigInteger.mod(BigInteger.valueOf(89809099)).intValue();
            if ((i % 89 != 0) && (i % 97 != 0) && (i % 101 != 0))
            {
              if (i % 103 == 0) {
                return true;
              }
              i = paramBigInteger.mod(BigInteger.valueOf(167375713)).intValue();
              if ((i % 107 != 0) && (i % 109 != 0) && (i % 113 != 0))
              {
                if (i % 127 == 0) {
                  return true;
                }
                i = paramBigInteger.mod(BigInteger.valueOf(371700317)).intValue();
                if ((i % 131 != 0) && (i % 137 != 0) && (i % 139 != 0))
                {
                  if (i % 149 == 0) {
                    return true;
                  }
                  i = paramBigInteger.mod(BigInteger.valueOf(645328247)).intValue();
                  if ((i % 151 != 0) && (i % 157 != 0) && (i % 163 != 0))
                  {
                    if (i % 167 == 0) {
                      return true;
                    }
                    i = paramBigInteger.mod(BigInteger.valueOf(1070560157)).intValue();
                    if ((i % 173 != 0) && (i % 179 != 0) && (i % 181 != 0))
                    {
                      if (i % 191 == 0) {
                        return true;
                      }
                      i = paramBigInteger.mod(BigInteger.valueOf(1596463769)).intValue();
                      if ((i % 193 != 0) && (i % 197 != 0) && (i % 199 != 0)) {
                        return i % 211 == 0;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return true;
  }
  
  private static boolean implMRProbablePrimeToBase(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, int paramInt, BigInteger paramBigInteger4)
  {
    paramBigInteger3 = paramBigInteger4.modPow(paramBigInteger3, paramBigInteger1);
    boolean bool2 = paramBigInteger3.equals(ONE);
    boolean bool1 = true;
    if (!bool2)
    {
      if (paramBigInteger3.equals(paramBigInteger2)) {
        return true;
      }
      int i = 1;
      while (i < paramInt)
      {
        paramBigInteger3 = paramBigInteger3.modPow(TWO, paramBigInteger1);
        if (paramBigInteger3.equals(paramBigInteger2)) {
          return true;
        }
        if (paramBigInteger3.equals(ONE)) {
          return false;
        }
        i += 1;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  private static STOutput implSTRandomPrime(Digest paramDigest, int paramInt, byte[] paramArrayOfByte)
  {
    int i = paramDigest.getDigestSize();
    int i1 = 0;
    Object localObject2;
    if (paramInt < 33)
    {
      localObject1 = new byte[i];
      localObject2 = new byte[i];
      i = 0;
      do
      {
        hash(paramDigest, paramArrayOfByte, (byte[])localObject1, 0);
        inc(paramArrayOfByte, 1);
        hash(paramDigest, paramArrayOfByte, (byte[])localObject2, 0);
        inc(paramArrayOfByte, 1);
        j = extract32((byte[])localObject1);
        k = extract32((byte[])localObject2);
        i += 1;
        long l = ((j ^ k) & -1 >>> 32 - paramInt | 1 << paramInt - 1 | 0x1) & 0xFFFFFFFF;
        if (isPrime32(l)) {
          return new STOutput(BigInteger.valueOf(l), paramArrayOfByte, i, null);
        }
      } while (i <= paramInt * 4);
      throw new IllegalStateException("Too many iterations in Shawe-Taylor Random_Prime Routine");
    }
    paramArrayOfByte = implSTRandomPrime(paramDigest, (paramInt + 3) / 2, paramArrayOfByte);
    BigInteger localBigInteger1 = paramArrayOfByte.getPrime();
    byte[] arrayOfByte = paramArrayOfByte.getPrimeSeed();
    int k = paramArrayOfByte.getPrimeGenCounter();
    int m = paramInt - 1;
    int n = m / (i * 8) + 1;
    paramArrayOfByte = hashGen(paramDigest, arrayOfByte, n).mod(ONE.shiftLeft(m)).setBit(m);
    BigInteger localBigInteger2 = localBigInteger1.shiftLeft(1);
    Object localObject1 = paramArrayOfByte.subtract(ONE).divide(localBigInteger2).add(ONE).shiftLeft(1);
    paramArrayOfByte = ((BigInteger)localObject1).multiply(localBigInteger1).add(ONE);
    int j = k;
    i = 0;
    for (;;)
    {
      localObject2 = paramArrayOfByte;
      if (paramArrayOfByte.bitLength() > paramInt)
      {
        localObject1 = ONE.shiftLeft(m).subtract(ONE).divide(localBigInteger2).add(ONE).shiftLeft(1);
        localObject2 = ((BigInteger)localObject1).multiply(localBigInteger1).add(ONE);
      }
      j += 1;
      if (!implHasAnySmallFactors((BigInteger)localObject2))
      {
        paramArrayOfByte = hashGen(paramDigest, arrayOfByte, n).mod(((BigInteger)localObject2).subtract(THREE)).add(TWO);
        localObject1 = ((BigInteger)localObject1).add(BigInteger.valueOf(i));
        paramArrayOfByte = paramArrayOfByte.modPow((BigInteger)localObject1, (BigInteger)localObject2);
        if ((((BigInteger)localObject2).gcd(paramArrayOfByte.subtract(ONE)).equals(ONE)) && (paramArrayOfByte.modPow(localBigInteger1, (BigInteger)localObject2).equals(ONE))) {
          return new STOutput((BigInteger)localObject2, arrayOfByte, j, null);
        }
        i1 = 0;
        i = 0;
      }
      else
      {
        inc(arrayOfByte, n);
      }
      if (j >= paramInt * 4 + k) {
        break;
      }
      i += 2;
      paramArrayOfByte = ((BigInteger)localObject2).add(localBigInteger2);
    }
    throw new IllegalStateException("Too many iterations in Shawe-Taylor Random_Prime Routine");
  }
  
  private static void inc(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte.length;
    while (paramInt > 0)
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      paramInt += (paramArrayOfByte[i] & 0xFF);
      paramArrayOfByte[i] = ((byte)paramInt);
      paramInt >>>= 8;
    }
  }
  
  public static boolean isMRProbablePrime(BigInteger paramBigInteger, SecureRandom paramSecureRandom, int paramInt)
  {
    checkCandidate(paramBigInteger, "candidate");
    if (paramSecureRandom != null)
    {
      if (paramInt >= 1)
      {
        if (paramBigInteger.bitLength() == 2) {
          return true;
        }
        if (!paramBigInteger.testBit(0)) {
          return false;
        }
        BigInteger localBigInteger1 = paramBigInteger.subtract(ONE);
        BigInteger localBigInteger2 = paramBigInteger.subtract(TWO);
        int j = localBigInteger1.getLowestSetBit();
        BigInteger localBigInteger3 = localBigInteger1.shiftRight(j);
        int i = 0;
        while (i < paramInt)
        {
          if (!implMRProbablePrimeToBase(paramBigInteger, localBigInteger1, localBigInteger3, j, BigIntegers.createRandomInRange(TWO, localBigInteger2, paramSecureRandom))) {
            return false;
          }
          i += 1;
        }
        return true;
      }
      throw new IllegalArgumentException("'iterations' must be > 0");
    }
    throw new IllegalArgumentException("'random' cannot be null");
  }
  
  public static boolean isMRProbablePrimeToBase(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    checkCandidate(paramBigInteger1, "candidate");
    checkCandidate(paramBigInteger2, "base");
    if (paramBigInteger2.compareTo(paramBigInteger1.subtract(ONE)) < 0)
    {
      if (paramBigInteger1.bitLength() == 2) {
        return true;
      }
      BigInteger localBigInteger = paramBigInteger1.subtract(ONE);
      int i = localBigInteger.getLowestSetBit();
      return implMRProbablePrimeToBase(paramBigInteger1, localBigInteger, localBigInteger.shiftRight(i), i, paramBigInteger2);
    }
    throw new IllegalArgumentException("'base' must be < ('candidate' - 1)");
  }
  
  private static boolean isPrime32(long paramLong)
  {
    if (paramLong >>> 32 == 0L)
    {
      boolean bool3 = false;
      boolean bool2 = false;
      boolean bool1 = paramLong < 5L;
      if (!bool1)
      {
        if ((paramLong == 2L) || (paramLong == 3L) || (!bool1)) {
          bool2 = true;
        }
        return bool2;
      }
      if (((1L & paramLong) != 0L) && (paramLong % 3L != 0L))
      {
        if (paramLong % 5L == 0L) {
          return false;
        }
        long l = 0L;
        bool1 = true;
        for (;;)
        {
          int i;
          if (bool1 < true)
          {
            if (paramLong % (new long[] { 1L, 7L, 11L, 13L, 17L, 19L, 23L, 29L }[bool1] + l) == 0L)
            {
              bool2 = bool3;
              if (paramLong < 30L) {
                bool2 = true;
              }
              return bool2;
            }
            bool1 += true;
          }
          else
          {
            l += 30L;
            if (l * l >= paramLong) {
              return true;
            }
            i = 0;
          }
        }
      }
      return false;
    }
    throw new IllegalArgumentException("Size limit exceeded");
  }
  
  public static class MROutput
  {
    private BigInteger factor;
    private boolean provablyComposite;
    
    private MROutput(boolean paramBoolean, BigInteger paramBigInteger)
    {
      this.provablyComposite = paramBoolean;
      this.factor = paramBigInteger;
    }
    
    private static MROutput probablyPrime()
    {
      return new MROutput(false, null);
    }
    
    private static MROutput provablyCompositeNotPrimePower()
    {
      return new MROutput(true, null);
    }
    
    private static MROutput provablyCompositeWithFactor(BigInteger paramBigInteger)
    {
      return new MROutput(true, paramBigInteger);
    }
    
    public BigInteger getFactor()
    {
      return this.factor;
    }
    
    public boolean isNotPrimePower()
    {
      return (this.provablyComposite) && (this.factor == null);
    }
    
    public boolean isProvablyComposite()
    {
      return this.provablyComposite;
    }
  }
  
  public static class STOutput
  {
    private BigInteger prime;
    private int primeGenCounter;
    private byte[] primeSeed;
    
    private STOutput(BigInteger paramBigInteger, byte[] paramArrayOfByte, int paramInt)
    {
      this.prime = paramBigInteger;
      this.primeSeed = paramArrayOfByte;
      this.primeGenCounter = paramInt;
    }
    
    public BigInteger getPrime()
    {
      return this.prime;
    }
    
    public int getPrimeGenCounter()
    {
      return this.primeGenCounter;
    }
    
    public byte[] getPrimeSeed()
    {
      return this.primeSeed;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\Primes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */