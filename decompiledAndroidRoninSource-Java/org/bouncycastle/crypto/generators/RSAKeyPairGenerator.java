package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.RSAKeyGenerationParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.math.Primes;
import org.bouncycastle.math.ec.WNafUtil;

public class RSAKeyPairGenerator
  implements AsymmetricCipherKeyPairGenerator
{
  private static final BigInteger ONE = BigInteger.valueOf(1L);
  private int iterations;
  private RSAKeyGenerationParameters param;
  
  private static int getNumberOfIterations(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 1536)
    {
      if (paramInt2 <= 100) {
        return 3;
      }
      if (paramInt2 <= 128) {
        return 4;
      }
      return 4 + (paramInt2 - 128 + 1) / 2;
    }
    if (paramInt1 >= 1024)
    {
      if (paramInt2 <= 100) {
        return 4;
      }
      if (paramInt2 <= 112) {
        return 5;
      }
      return (paramInt2 - 112 + 1) / 2 + 5;
    }
    if (paramInt1 >= 512)
    {
      if (paramInt2 <= 80) {
        return 5;
      }
      if (paramInt2 <= 100) {
        return 7;
      }
      return (paramInt2 - 100 + 1) / 2 + 7;
    }
    if (paramInt2 <= 80) {
      return 40;
    }
    return 40 + (paramInt2 - 80 + 1) / 2;
  }
  
  protected BigInteger chooseRandomPrime(int paramInt, BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    int i = 0;
    while (i != paramInt * 5)
    {
      BigInteger localBigInteger = new BigInteger(paramInt, 1, this.param.getRandom());
      if ((localBigInteger.mod(paramBigInteger1).equals(ONE)) || (localBigInteger.multiply(localBigInteger).compareTo(paramBigInteger2) < 0) || (!isProbablePrime(localBigInteger)) || (!paramBigInteger1.gcd(localBigInteger.subtract(ONE)).equals(ONE))) {
        i += 1;
      } else {
        return localBigInteger;
      }
    }
    throw new IllegalStateException("unable to generate prime number for RSA key");
  }
  
  public AsymmetricCipherKeyPair generateKeyPair()
  {
    int m = this.param.getStrength();
    int n = (m + 1) / 2;
    int i1 = m / 2;
    int i = i1 - 100;
    int k = m / 3;
    int j = i;
    if (i < k) {
      j = k;
    }
    BigInteger localBigInteger2 = BigInteger.valueOf(2L).pow(i1);
    BigInteger localBigInteger3 = ONE.shiftLeft(m - 1);
    BigInteger localBigInteger4 = ONE.shiftLeft(j);
    Object localObject2 = null;
    k = 0;
    i = m;
    Object localObject3 = this;
    if (k == 0)
    {
      BigInteger localBigInteger5 = ((RSAKeyPairGenerator)localObject3).param.getPublicExponent();
      label102:
      Object localObject1 = ((RSAKeyPairGenerator)localObject3).chooseRandomPrime(n, localBigInteger5, localBigInteger3);
      for (;;)
      {
        BigInteger localBigInteger1 = ((RSAKeyPairGenerator)localObject3).chooseRandomPrime(m - n, localBigInteger5, localBigInteger3);
        BigInteger localBigInteger6 = localBigInteger1.subtract((BigInteger)localObject1).abs();
        if ((localBigInteger6.bitLength() >= j) && (localBigInteger6.compareTo(localBigInteger4) > 0))
        {
          localBigInteger6 = ((BigInteger)localObject1).multiply(localBigInteger1);
          if (localBigInteger6.bitLength() != i)
          {
            localObject1 = ((BigInteger)localObject1).max(localBigInteger1);
            continue;
          }
          if (WNafUtil.getNafWeight(localBigInteger6) < m >> 2) {
            break label102;
          }
          if (((BigInteger)localObject1).compareTo(localBigInteger1) < 0)
          {
            localObject3 = localBigInteger1;
          }
          else
          {
            localObject3 = localObject1;
            localObject1 = localBigInteger1;
          }
          BigInteger localBigInteger8 = ((BigInteger)localObject3).subtract(ONE);
          BigInteger localBigInteger7 = ((BigInteger)localObject1).subtract(ONE);
          localBigInteger1 = localBigInteger5.modInverse(localBigInteger8.divide(localBigInteger8.gcd(localBigInteger7)).multiply(localBigInteger7));
          if (localBigInteger1.compareTo(localBigInteger2) > 0)
          {
            localObject2 = localBigInteger1.remainder(localBigInteger8);
            localBigInteger7 = localBigInteger1.remainder(localBigInteger7);
            localBigInteger8 = ((BigInteger)localObject1).modInverse((BigInteger)localObject3);
            localObject2 = new AsymmetricCipherKeyPair(new RSAKeyParameters(false, localBigInteger6, localBigInteger5), new RSAPrivateCrtKeyParameters(localBigInteger6, localBigInteger5, localBigInteger1, (BigInteger)localObject3, (BigInteger)localObject1, (BigInteger)localObject2, localBigInteger7, localBigInteger8));
            k = 1;
          }
          break;
        }
        localObject3 = this;
      }
    }
    return (AsymmetricCipherKeyPair)localObject2;
  }
  
  public void init(KeyGenerationParameters paramKeyGenerationParameters)
  {
    paramKeyGenerationParameters = (RSAKeyGenerationParameters)paramKeyGenerationParameters;
    this.param = paramKeyGenerationParameters;
    this.iterations = getNumberOfIterations(paramKeyGenerationParameters.getStrength(), this.param.getCertainty());
  }
  
  protected boolean isProbablePrime(BigInteger paramBigInteger)
  {
    return (!Primes.hasAnySmallFactors(paramBigInteger)) && (Primes.isMRProbablePrime(paramBigInteger, this.param.getRandom(), this.iterations));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\generators\RSAKeyPairGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */