package org.bouncycastle.crypto.generators;

import java.io.PrintStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Vector;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.NaccacheSternKeyGenerationParameters;
import org.bouncycastle.crypto.params.NaccacheSternKeyParameters;
import org.bouncycastle.crypto.params.NaccacheSternPrivateKeyParameters;

public class NaccacheSternKeyPairGenerator
  implements AsymmetricCipherKeyPairGenerator
{
  private static final BigInteger ONE = BigInteger.valueOf(1L);
  private static int[] smallPrimes = { 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557 };
  private NaccacheSternKeyGenerationParameters param;
  
  private static Vector findFirstPrimes(int paramInt)
  {
    Vector localVector = new Vector(paramInt);
    int i = 0;
    while (i != paramInt)
    {
      localVector.addElement(BigInteger.valueOf(smallPrimes[i]));
      i += 1;
    }
    return localVector;
  }
  
  private static BigInteger generatePrime(int paramInt1, int paramInt2, SecureRandom paramSecureRandom)
  {
    for (BigInteger localBigInteger = new BigInteger(paramInt1, paramInt2, paramSecureRandom); localBigInteger.bitLength() != paramInt1; localBigInteger = new BigInteger(paramInt1, paramInt2, paramSecureRandom)) {}
    return localBigInteger;
  }
  
  private static int getInt(SecureRandom paramSecureRandom, int paramInt)
  {
    if ((-paramInt & paramInt) == paramInt) {
      return (int)(paramInt * (paramSecureRandom.nextInt() & 0x7FFFFFFF) >> 31);
    }
    int i;
    int j;
    do
    {
      i = paramSecureRandom.nextInt() & 0x7FFFFFFF;
      j = i % paramInt;
    } while (i - j + (paramInt - 1) < 0);
    return j;
  }
  
  private static Vector permuteList(Vector paramVector, SecureRandom paramSecureRandom)
  {
    Vector localVector1 = new Vector();
    Vector localVector2 = new Vector();
    int i = 0;
    while (i < paramVector.size())
    {
      localVector2.addElement(paramVector.elementAt(i));
      i += 1;
    }
    localVector1.addElement(localVector2.elementAt(0));
    for (;;)
    {
      localVector2.removeElementAt(0);
      if (localVector2.size() == 0) {
        break;
      }
      localVector1.insertElementAt(localVector2.elementAt(0), getInt(paramSecureRandom, localVector1.size() + 1));
    }
    return localVector1;
  }
  
  public AsymmetricCipherKeyPair generateKeyPair()
  {
    int j = this.param.getStrength();
    Object localObject4 = this.param.getRandom();
    int k = this.param.getCertainty();
    boolean bool = this.param.isDebug();
    if (bool)
    {
      localObject1 = System.out;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Fetching first ");
      ((StringBuilder)localObject2).append(this.param.getCntSmallPrimes());
      ((StringBuilder)localObject2).append(" primes.");
      ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
    }
    Vector localVector = permuteList(findFirstPrimes(this.param.getCntSmallPrimes()), (SecureRandom)localObject4);
    Object localObject2 = ONE;
    Object localObject1 = localObject2;
    int i = 0;
    while (i < localVector.size() / 2)
    {
      localObject1 = ((BigInteger)localObject1).multiply((BigInteger)localVector.elementAt(i));
      i += 1;
    }
    i = localVector.size() / 2;
    while (i < localVector.size())
    {
      localObject2 = ((BigInteger)localObject2).multiply((BigInteger)localVector.elementAt(i));
      i += 1;
    }
    BigInteger localBigInteger4 = ((BigInteger)localObject1).multiply((BigInteger)localObject2);
    i = (j - localBigInteger4.bitLength() - 48) / 2 + 1;
    BigInteger localBigInteger5 = generatePrime(i, k, (SecureRandom)localObject4);
    BigInteger localBigInteger1 = generatePrime(i, k, (SecureRandom)localObject4);
    if (bool) {
      System.out.println("generating p and q");
    }
    Object localObject3 = localBigInteger5.multiply((BigInteger)localObject1).shiftLeft(1);
    localObject1 = localBigInteger1.multiply((BigInteger)localObject2).shiftLeft(1);
    long l = 0L;
    l += 1L;
    BigInteger localBigInteger8 = generatePrime(24, k, (SecureRandom)localObject4);
    BigInteger localBigInteger3 = localBigInteger8.multiply((BigInteger)localObject3).add(ONE);
    localObject2 = localObject1;
    if (!localBigInteger3.isProbablePrime(k)) {
      localObject2 = localObject1;
    }
    for (;;)
    {
      BigInteger localBigInteger9 = generatePrime(24, k, (SecureRandom)localObject4);
      if (!localBigInteger8.equals(localBigInteger9))
      {
        BigInteger localBigInteger2 = localBigInteger9.multiply((BigInteger)localObject2);
        localObject1 = localObject2;
        localBigInteger2 = localBigInteger2.add(ONE);
        if (localBigInteger2.isProbablePrime(k))
        {
          Object localObject5;
          if (!localBigInteger4.gcd(localBigInteger8.multiply(localBigInteger9)).equals(ONE))
          {
            localObject2 = localObject1;
          }
          else
          {
            if (localBigInteger3.multiply(localBigInteger2).bitLength() >= j) {
              break label509;
            }
            localObject2 = localObject1;
            if (bool)
            {
              localObject2 = System.out;
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("key size too small. Should be ");
              ((StringBuilder)localObject5).append(j);
              ((StringBuilder)localObject5).append(" but is actually ");
              ((StringBuilder)localObject5).append(localBigInteger3.multiply(localBigInteger2).bitLength());
              ((PrintStream)localObject2).println(((StringBuilder)localObject5).toString());
              localObject2 = localObject1;
            }
          }
          localObject1 = localObject2;
          break;
          label509:
          if (bool)
          {
            localObject1 = System.out;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("needed ");
            ((StringBuilder)localObject2).append(l);
            ((StringBuilder)localObject2).append(" tries to generate p and q.");
            ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
          }
          BigInteger localBigInteger6 = localBigInteger3.multiply(localBigInteger2);
          BigInteger localBigInteger7 = localBigInteger3.subtract(ONE).multiply(localBigInteger2.subtract(ONE));
          if (bool) {
            System.out.println("generating g");
          }
          l = 0L;
          localObject1 = localObject4;
          i = j;
          for (;;)
          {
            localObject2 = new Vector();
            j = 0;
            while (j != localVector.size())
            {
              localObject3 = localBigInteger7.divide((BigInteger)localVector.elementAt(j));
              do
              {
                l += 1L;
                localObject4 = new BigInteger(i, k, (Random)localObject1);
              } while (((BigInteger)localObject4).modPow((BigInteger)localObject3, localBigInteger6).equals(ONE));
              ((Vector)localObject2).addElement(localObject4);
              j += 1;
            }
            localObject5 = ONE;
            j = 0;
            while (j < localVector.size())
            {
              localObject5 = ((BigInteger)localObject5).multiply(((BigInteger)((Vector)localObject2).elementAt(j)).modPow(localBigInteger4.divide((BigInteger)localVector.elementAt(j)), localBigInteger6)).mod(localBigInteger6);
              j += 1;
            }
            j = 0;
            while (j < localVector.size())
            {
              if (((BigInteger)localObject5).modPow(localBigInteger7.divide((BigInteger)localVector.elementAt(j)), localBigInteger6).equals(ONE))
              {
                if (bool)
                {
                  localObject2 = System.out;
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("g has order phi(n)/");
                  ((StringBuilder)localObject3).append(localVector.elementAt(j));
                  ((StringBuilder)localObject3).append("\n g: ");
                  ((StringBuilder)localObject3).append(localObject5);
                  ((PrintStream)localObject2).println(((StringBuilder)localObject3).toString());
                }
                j = 1;
                break label890;
              }
              j += 1;
            }
            j = 0;
            label890:
            if (j == 0)
            {
              while (((BigInteger)localObject5).modPow(localBigInteger7.divide(BigInteger.valueOf(4L)), localBigInteger6).equals(ONE)) {
                if (bool)
                {
                  localObject2 = System.out;
                  localObject3 = new StringBuilder();
                  localObject4 = "g has order phi(n)/4\n g:";
                }
              }
              for (;;)
              {
                ((StringBuilder)localObject3).append((String)localObject4);
                ((StringBuilder)localObject3).append(localObject5);
                ((PrintStream)localObject2).println(((StringBuilder)localObject3).toString());
                break;
                if (((BigInteger)localObject5).modPow(localBigInteger7.divide(localBigInteger8), localBigInteger6).equals(ONE))
                {
                  if (!bool) {
                    break;
                  }
                  localObject2 = System.out;
                  localObject3 = new StringBuilder();
                  localObject4 = "g has order phi(n)/p'\n g: ";
                  continue;
                }
                if (((BigInteger)localObject5).modPow(localBigInteger7.divide(localBigInteger9), localBigInteger6).equals(ONE))
                {
                  if (!bool) {
                    break;
                  }
                  localObject2 = System.out;
                  localObject3 = new StringBuilder();
                  localObject4 = "g has order phi(n)/q'\n g: ";
                  continue;
                }
                if (!((BigInteger)localObject5).modPow(localBigInteger7.divide(localBigInteger5), localBigInteger6).equals(ONE)) {
                  break label1123;
                }
                if (!bool) {
                  break;
                }
                localObject2 = System.out;
                localObject3 = new StringBuilder();
                localObject4 = "g has order phi(n)/a\n g: ";
              }
              label1123:
              localObject2 = localBigInteger1;
              if (!((BigInteger)localObject5).modPow(localBigInteger7.divide((BigInteger)localObject2), localBigInteger6).equals(ONE)) {
                break;
              }
              if (bool)
              {
                localObject2 = System.out;
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("g has order phi(n)/b\n g: ");
                ((StringBuilder)localObject3).append(localObject5);
                ((PrintStream)localObject2).println(((StringBuilder)localObject3).toString());
              }
            }
          }
          if (bool)
          {
            localObject1 = System.out;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("needed ");
            ((StringBuilder)localObject3).append(l);
            ((StringBuilder)localObject3).append(" tries to generate g");
            ((PrintStream)localObject1).println(((StringBuilder)localObject3).toString());
            System.out.println();
            System.out.println("found new NaccacheStern cipher variables:");
            localObject1 = System.out;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("smallPrimes: ");
            ((StringBuilder)localObject3).append(localVector);
            ((PrintStream)localObject1).println(((StringBuilder)localObject3).toString());
            localObject1 = System.out;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("sigma:...... ");
            ((StringBuilder)localObject3).append(localBigInteger4);
            ((StringBuilder)localObject3).append(" (");
            ((StringBuilder)localObject3).append(localBigInteger4.bitLength());
            ((StringBuilder)localObject3).append(" bits)");
            ((PrintStream)localObject1).println(((StringBuilder)localObject3).toString());
            localObject1 = System.out;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("a:.......... ");
            ((StringBuilder)localObject3).append(localBigInteger5);
            ((PrintStream)localObject1).println(((StringBuilder)localObject3).toString());
            localObject1 = System.out;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("b:.......... ");
            ((StringBuilder)localObject3).append(localObject2);
            ((PrintStream)localObject1).println(((StringBuilder)localObject3).toString());
            localObject1 = System.out;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("p':......... ");
            ((StringBuilder)localObject2).append(localBigInteger8);
            ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
            localObject1 = System.out;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("q':......... ");
            ((StringBuilder)localObject2).append(localBigInteger9);
            ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
            localObject1 = System.out;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("p:.......... ");
            ((StringBuilder)localObject2).append(localBigInteger3);
            ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
            localObject1 = System.out;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("q:.......... ");
            ((StringBuilder)localObject2).append(localBigInteger2);
            ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
            localObject1 = System.out;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("n:.......... ");
            ((StringBuilder)localObject2).append(localBigInteger6);
            ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
            localObject1 = System.out;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("phi(n):..... ");
            ((StringBuilder)localObject2).append(localBigInteger7);
            ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
            localObject1 = System.out;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("g:.......... ");
            ((StringBuilder)localObject2).append(localObject5);
            ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
            System.out.println();
          }
          return new AsymmetricCipherKeyPair(new NaccacheSternKeyParameters(false, (BigInteger)localObject5, localBigInteger6, localBigInteger4.bitLength()), new NaccacheSternPrivateKeyParameters((BigInteger)localObject5, localBigInteger6, localBigInteger4.bitLength(), localVector, localBigInteger7));
        }
        localObject2 = localObject1;
      }
    }
  }
  
  public void init(KeyGenerationParameters paramKeyGenerationParameters)
  {
    this.param = ((NaccacheSternKeyGenerationParameters)paramKeyGenerationParameters);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\generators\NaccacheSternKeyPairGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */