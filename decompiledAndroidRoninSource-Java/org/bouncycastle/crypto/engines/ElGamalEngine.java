package org.bouncycastle.crypto.engines;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.params.ElGamalKeyParameters;
import org.bouncycastle.crypto.params.ElGamalParameters;
import org.bouncycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.bouncycastle.crypto.params.ElGamalPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.BigIntegers;

public class ElGamalEngine
  implements AsymmetricBlockCipher
{
  private static final BigInteger ONE = BigInteger.valueOf(1L);
  private static final BigInteger TWO = BigInteger.valueOf(2L);
  private static final BigInteger ZERO = BigInteger.valueOf(0L);
  private int bitSize;
  private boolean forEncryption;
  private ElGamalKeyParameters key;
  private SecureRandom random;
  
  public int getInputBlockSize()
  {
    if (this.forEncryption) {
      return (this.bitSize - 1) / 8;
    }
    return (this.bitSize + 7) / 8 * 2;
  }
  
  public int getOutputBlockSize()
  {
    if (this.forEncryption) {
      return (this.bitSize + 7) / 8 * 2;
    }
    return (this.bitSize - 1) / 8;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    if ((paramCipherParameters instanceof ParametersWithRandom))
    {
      paramCipherParameters = (ParametersWithRandom)paramCipherParameters;
      this.key = ((ElGamalKeyParameters)paramCipherParameters.getParameters());
      paramCipherParameters = paramCipherParameters.getRandom();
    }
    else
    {
      this.key = ((ElGamalKeyParameters)paramCipherParameters);
      paramCipherParameters = new SecureRandom();
    }
    this.random = paramCipherParameters;
    this.forEncryption = paramBoolean;
    this.bitSize = this.key.getParameters().getP().bitLength();
    if (paramBoolean)
    {
      if ((this.key instanceof ElGamalPublicKeyParameters)) {
        return;
      }
      throw new IllegalArgumentException("ElGamalPublicKeyParameters are required for encryption.");
    }
    if ((this.key instanceof ElGamalPrivateKeyParameters)) {
      return;
    }
    throw new IllegalArgumentException("ElGamalPrivateKeyParameters are required for decryption.");
  }
  
  public byte[] processBlock(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.key != null)
    {
      int i;
      if (this.forEncryption) {
        i = (this.bitSize - 1 + 7) / 8;
      } else {
        i = getInputBlockSize();
      }
      if (paramInt2 <= i)
      {
        Object localObject2 = this.key.getParameters().getP();
        Object localObject3;
        if ((this.key instanceof ElGamalPrivateKeyParameters))
        {
          paramInt2 /= 2;
          localObject3 = new byte[paramInt2];
          localObject1 = new byte[paramInt2];
          System.arraycopy(paramArrayOfByte, paramInt1, localObject3, 0, paramInt2);
          System.arraycopy(paramArrayOfByte, paramInt1 + paramInt2, localObject1, 0, paramInt2);
          paramArrayOfByte = new BigInteger(1, (byte[])localObject3);
          localObject1 = new BigInteger(1, (byte[])localObject1);
          localObject3 = (ElGamalPrivateKeyParameters)this.key;
          return BigIntegers.asUnsignedByteArray(paramArrayOfByte.modPow(((BigInteger)localObject2).subtract(ONE).subtract(((ElGamalPrivateKeyParameters)localObject3).getX()), (BigInteger)localObject2).multiply((BigInteger)localObject1).mod((BigInteger)localObject2));
        }
        if (paramInt1 == 0)
        {
          localObject1 = paramArrayOfByte;
          if (paramInt2 == paramArrayOfByte.length) {}
        }
        else
        {
          localObject1 = new byte[paramInt2];
          System.arraycopy(paramArrayOfByte, paramInt1, localObject1, 0, paramInt2);
        }
        Object localObject1 = new BigInteger(1, (byte[])localObject1);
        if (((BigInteger)localObject1).compareTo((BigInteger)localObject2) < 0)
        {
          localObject3 = (ElGamalPublicKeyParameters)this.key;
          paramInt1 = ((BigInteger)localObject2).bitLength();
          for (paramArrayOfByte = new BigInteger(paramInt1, this.random);; paramArrayOfByte = new BigInteger(paramInt1, this.random)) {
            if ((!paramArrayOfByte.equals(ZERO)) && (paramArrayOfByte.compareTo(((BigInteger)localObject2).subtract(TWO)) <= 0))
            {
              BigInteger localBigInteger = this.key.getParameters().getG().modPow(paramArrayOfByte, (BigInteger)localObject2);
              localObject1 = ((BigInteger)localObject1).multiply(((ElGamalPublicKeyParameters)localObject3).getY().modPow(paramArrayOfByte, (BigInteger)localObject2)).mod((BigInteger)localObject2);
              paramArrayOfByte = localBigInteger.toByteArray();
              localObject1 = ((BigInteger)localObject1).toByteArray();
              paramInt1 = getOutputBlockSize();
              localObject2 = new byte[paramInt1];
              paramInt2 = paramArrayOfByte.length;
              i = paramInt1 / 2;
              if (paramInt2 > i) {
                System.arraycopy(paramArrayOfByte, 1, localObject2, i - (paramArrayOfByte.length - 1), paramArrayOfByte.length - 1);
              } else {
                System.arraycopy(paramArrayOfByte, 0, localObject2, i - paramArrayOfByte.length, paramArrayOfByte.length);
              }
              if (localObject1.length > i)
              {
                System.arraycopy(localObject1, 1, localObject2, paramInt1 - (localObject1.length - 1), localObject1.length - 1);
                return (byte[])localObject2;
              }
              System.arraycopy(localObject1, 0, localObject2, paramInt1 - localObject1.length, localObject1.length);
              return (byte[])localObject2;
            }
          }
        }
        throw new DataLengthException("input too large for ElGamal cipher.\n");
      }
      throw new DataLengthException("input too large for ElGamal cipher.\n");
    }
    throw new IllegalStateException("ElGamal engine not initialised");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\ElGamalEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */