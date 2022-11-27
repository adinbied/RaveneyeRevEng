package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.params.DSAParameterGenerationParameters;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAValidationParameters;
import org.bouncycastle.crypto.util.DigestFactory;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.encoders.Hex;

public class DSAParametersGenerator
{
  private static final BigInteger ONE = BigInteger.valueOf(1L);
  private static final BigInteger TWO = BigInteger.valueOf(2L);
  private static final BigInteger ZERO = BigInteger.valueOf(0L);
  private int L;
  private int N;
  private int certainty;
  private Digest digest;
  private int iterations;
  private SecureRandom random;
  private int usageIndex;
  private boolean use186_3;
  
  public DSAParametersGenerator()
  {
    this(DigestFactory.createSHA1());
  }
  
  public DSAParametersGenerator(Digest paramDigest)
  {
    this.digest = paramDigest;
  }
  
  private static BigInteger calculateGenerator_FIPS186_2(BigInteger paramBigInteger1, BigInteger paramBigInteger2, SecureRandom paramSecureRandom)
  {
    paramBigInteger2 = paramBigInteger1.subtract(ONE).divide(paramBigInteger2);
    BigInteger localBigInteger1 = paramBigInteger1.subtract(TWO);
    BigInteger localBigInteger2;
    do
    {
      localBigInteger2 = BigIntegers.createRandomInRange(TWO, localBigInteger1, paramSecureRandom).modPow(paramBigInteger2, paramBigInteger1);
    } while (localBigInteger2.bitLength() <= 1);
    return localBigInteger2;
  }
  
  private static BigInteger calculateGenerator_FIPS186_3_Unverifiable(BigInteger paramBigInteger1, BigInteger paramBigInteger2, SecureRandom paramSecureRandom)
  {
    return calculateGenerator_FIPS186_2(paramBigInteger1, paramBigInteger2, paramSecureRandom);
  }
  
  private static BigInteger calculateGenerator_FIPS186_3_Verifiable(Digest paramDigest, BigInteger paramBigInteger1, BigInteger paramBigInteger2, byte[] paramArrayOfByte, int paramInt)
  {
    paramBigInteger2 = paramBigInteger1.subtract(ONE).divide(paramBigInteger2);
    Object localObject = Hex.decode("6767656E");
    int i = paramArrayOfByte.length + localObject.length + 1 + 2;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    System.arraycopy(localObject, 0, arrayOfByte, paramArrayOfByte.length, localObject.length);
    arrayOfByte[(i - 3)] = ((byte)paramInt);
    paramArrayOfByte = new byte[paramDigest.getDigestSize()];
    paramInt = 1;
    while (paramInt < 65536)
    {
      inc(arrayOfByte);
      hash(paramDigest, arrayOfByte, paramArrayOfByte, 0);
      localObject = new BigInteger(1, paramArrayOfByte).modPow(paramBigInteger2, paramBigInteger1);
      if (((BigInteger)localObject).compareTo(TWO) >= 0) {
        return (BigInteger)localObject;
      }
      paramInt += 1;
    }
    return null;
  }
  
  private DSAParameters generateParameters_FIPS186_2()
  {
    int j = 20;
    byte[] arrayOfByte1 = new byte[20];
    byte[] arrayOfByte2 = new byte[20];
    byte[] arrayOfByte3 = new byte[20];
    byte[] arrayOfByte4 = new byte[20];
    int i = this.L;
    int k = (i - 1) / 160;
    int m = i / 8;
    byte[] arrayOfByte5 = new byte[m];
    if ((this.digest instanceof SHA1Digest)) {
      for (;;)
      {
        this.random.nextBytes(arrayOfByte1);
        hash(this.digest, arrayOfByte1, arrayOfByte2, 0);
        System.arraycopy(arrayOfByte1, 0, arrayOfByte3, 0, j);
        inc(arrayOfByte3);
        hash(this.digest, arrayOfByte3, arrayOfByte3, 0);
        i = 0;
        while (i != j)
        {
          arrayOfByte4[i] = ((byte)(arrayOfByte2[i] ^ arrayOfByte3[i]));
          i += 1;
        }
        arrayOfByte4[0] = ((byte)(arrayOfByte4[0] | 0xFFFFFF80));
        arrayOfByte4[19] = ((byte)(arrayOfByte4[19] | 0x1));
        BigInteger localBigInteger1 = new BigInteger(1, arrayOfByte4);
        if (isProbablePrime(localBigInteger1))
        {
          byte[] arrayOfByte6 = Arrays.clone(arrayOfByte1);
          inc(arrayOfByte6);
          i = 0;
          while (i < 4096)
          {
            j = 1;
            while (j <= k)
            {
              inc(arrayOfByte6);
              hash(this.digest, arrayOfByte6, arrayOfByte5, m - j * 20);
              j += 1;
            }
            j = m - k * 20;
            inc(arrayOfByte6);
            hash(this.digest, arrayOfByte6, arrayOfByte2, 0);
            System.arraycopy(arrayOfByte2, 20 - j, arrayOfByte5, 0, j);
            arrayOfByte5[0] = ((byte)(arrayOfByte5[0] | 0xFFFFFF80));
            BigInteger localBigInteger2 = new BigInteger(1, arrayOfByte5);
            localBigInteger2 = localBigInteger2.subtract(localBigInteger2.mod(localBigInteger1.shiftLeft(1)).subtract(ONE));
            if ((localBigInteger2.bitLength() == this.L) && (isProbablePrime(localBigInteger2))) {
              return new DSAParameters(localBigInteger2, localBigInteger1, calculateGenerator_FIPS186_2(localBigInteger2, localBigInteger1, this.random), new DSAValidationParameters(arrayOfByte1, i));
            }
            i += 1;
            j = 20;
          }
        }
      }
    }
    throw new IllegalStateException("can only use SHA-1 for generating FIPS 186-2 parameters");
  }
  
  private DSAParameters generateParameters_FIPS186_3()
  {
    Object localObject = this.digest;
    int j = ((Digest)localObject).getDigestSize() * 8;
    byte[] arrayOfByte1 = new byte[this.N / 8];
    int i = this.L;
    int k = (i - 1) / j;
    int m = i / 8;
    byte[] arrayOfByte2 = new byte[m];
    int n = ((Digest)localObject).getDigestSize();
    byte[] arrayOfByte3 = new byte[n];
    for (;;)
    {
      this.random.nextBytes(arrayOfByte1);
      hash((Digest)localObject, arrayOfByte1, arrayOfByte3, 0);
      BigInteger localBigInteger1 = new BigInteger(1, arrayOfByte3).mod(ONE.shiftLeft(this.N - 1)).setBit(0).setBit(this.N - 1);
      if (isProbablePrime(localBigInteger1))
      {
        byte[] arrayOfByte4 = Arrays.clone(arrayOfByte1);
        int i1 = this.L;
        i = 0;
        while (i < i1 * 4)
        {
          j = 1;
          while (j <= k)
          {
            inc(arrayOfByte4);
            hash((Digest)localObject, arrayOfByte4, arrayOfByte2, m - j * n);
            j += 1;
          }
          j = m - k * n;
          inc(arrayOfByte4);
          hash((Digest)localObject, arrayOfByte4, arrayOfByte3, 0);
          System.arraycopy(arrayOfByte3, n - j, arrayOfByte2, 0, j);
          arrayOfByte2[0] = ((byte)(arrayOfByte2[0] | 0xFFFFFF80));
          BigInteger localBigInteger2 = new BigInteger(1, arrayOfByte2);
          localBigInteger2 = localBigInteger2.subtract(localBigInteger2.mod(localBigInteger1.shiftLeft(1)).subtract(ONE));
          if ((localBigInteger2.bitLength() == this.L) && (isProbablePrime(localBigInteger2)))
          {
            j = this.usageIndex;
            if (j >= 0)
            {
              localObject = calculateGenerator_FIPS186_3_Verifiable((Digest)localObject, localBigInteger2, localBigInteger1, arrayOfByte1, j);
              if (localObject != null) {
                return new DSAParameters(localBigInteger2, localBigInteger1, (BigInteger)localObject, new DSAValidationParameters(arrayOfByte1, i, this.usageIndex));
              }
            }
            return new DSAParameters(localBigInteger2, localBigInteger1, calculateGenerator_FIPS186_3_Unverifiable(localBigInteger2, localBigInteger1, this.random), new DSAValidationParameters(arrayOfByte1, i));
          }
          i += 1;
        }
      }
    }
  }
  
  private static int getDefaultN(int paramInt)
  {
    if (paramInt > 1024) {
      return 256;
    }
    return 160;
  }
  
  private static int getMinimumIterations(int paramInt)
  {
    if (paramInt <= 1024) {
      return 40;
    }
    return (paramInt - 1) / 1024 * 8 + 48;
  }
  
  private static void hash(Digest paramDigest, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    paramDigest.update(paramArrayOfByte1, 0, paramArrayOfByte1.length);
    paramDigest.doFinal(paramArrayOfByte2, paramInt);
  }
  
  private static void inc(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length - 1;
    while (j >= 0)
    {
      int i = (byte)(paramArrayOfByte[j] + 1 & 0xFF);
      paramArrayOfByte[j] = i;
      if (i != 0) {
        return;
      }
      j -= 1;
    }
  }
  
  private boolean isProbablePrime(BigInteger paramBigInteger)
  {
    return paramBigInteger.isProbablePrime(this.certainty);
  }
  
  public DSAParameters generateParameters()
  {
    if (this.use186_3) {
      return generateParameters_FIPS186_3();
    }
    return generateParameters_FIPS186_2();
  }
  
  public void init(int paramInt1, int paramInt2, SecureRandom paramSecureRandom)
  {
    this.L = paramInt1;
    this.N = getDefaultN(paramInt1);
    this.certainty = paramInt2;
    this.iterations = Math.max(getMinimumIterations(this.L), (paramInt2 + 1) / 2);
    this.random = paramSecureRandom;
    this.use186_3 = false;
    this.usageIndex = -1;
  }
  
  public void init(DSAParameterGenerationParameters paramDSAParameterGenerationParameters)
  {
    int i = paramDSAParameterGenerationParameters.getL();
    int j = paramDSAParameterGenerationParameters.getN();
    if ((i >= 1024) && (i <= 3072) && (i % 1024 == 0))
    {
      if ((i == 1024) && (j != 160)) {
        throw new IllegalArgumentException("N must be 160 for L = 1024");
      }
      if ((i == 2048) && (j != 224) && (j != 256)) {
        throw new IllegalArgumentException("N must be 224 or 256 for L = 2048");
      }
      if ((i == 3072) && (j != 256)) {
        throw new IllegalArgumentException("N must be 256 for L = 3072");
      }
      if (this.digest.getDigestSize() * 8 >= j)
      {
        this.L = i;
        this.N = j;
        this.certainty = paramDSAParameterGenerationParameters.getCertainty();
        this.iterations = Math.max(getMinimumIterations(i), (this.certainty + 1) / 2);
        this.random = paramDSAParameterGenerationParameters.getRandom();
        this.use186_3 = true;
        this.usageIndex = paramDSAParameterGenerationParameters.getUsageIndex();
        return;
      }
      throw new IllegalStateException("Digest output size too small for value of N");
    }
    throw new IllegalArgumentException("L values must be between 1024 and 3072 and a multiple of 1024");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\generators\DSAParametersGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */