package org.bouncycastle.crypto.engines;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.util.BigIntegers;

public class RSABlindedEngine
  implements AsymmetricBlockCipher
{
  private static final BigInteger ONE = BigInteger.valueOf(1L);
  private RSACoreEngine core = new RSACoreEngine();
  private RSAKeyParameters key;
  private SecureRandom random;
  
  public int getInputBlockSize()
  {
    return this.core.getInputBlockSize();
  }
  
  public int getOutputBlockSize()
  {
    return this.core.getOutputBlockSize();
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    this.core.init(paramBoolean, paramCipherParameters);
    if ((paramCipherParameters instanceof ParametersWithRandom))
    {
      paramCipherParameters = (ParametersWithRandom)paramCipherParameters;
      this.key = ((RSAKeyParameters)paramCipherParameters.getParameters());
      paramCipherParameters = paramCipherParameters.getRandom();
    }
    else
    {
      this.key = ((RSAKeyParameters)paramCipherParameters);
      paramCipherParameters = new SecureRandom();
    }
    this.random = paramCipherParameters;
  }
  
  public byte[] processBlock(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.key != null)
    {
      BigInteger localBigInteger1 = this.core.convertInput(paramArrayOfByte, paramInt1, paramInt2);
      paramArrayOfByte = this.key;
      if ((paramArrayOfByte instanceof RSAPrivateCrtKeyParameters))
      {
        paramArrayOfByte = (RSAPrivateCrtKeyParameters)paramArrayOfByte;
        BigInteger localBigInteger2 = paramArrayOfByte.getPublicExponent();
        if (localBigInteger2 != null)
        {
          BigInteger localBigInteger3 = paramArrayOfByte.getModulus();
          paramArrayOfByte = ONE;
          paramArrayOfByte = BigIntegers.createRandomInRange(paramArrayOfByte, localBigInteger3.subtract(paramArrayOfByte), this.random);
          BigInteger localBigInteger4 = paramArrayOfByte.modPow(localBigInteger2, localBigInteger3).multiply(localBigInteger1).mod(localBigInteger3);
          paramArrayOfByte = this.core.processBlock(localBigInteger4).multiply(paramArrayOfByte.modInverse(localBigInteger3)).mod(localBigInteger3);
          if (localBigInteger1.equals(paramArrayOfByte.modPow(localBigInteger2, localBigInteger3))) {
            break label155;
          }
          throw new IllegalStateException("RSA engine faulty decryption/signing detected");
        }
      }
      paramArrayOfByte = this.core.processBlock(localBigInteger1);
      label155:
      return this.core.convertOutput(paramArrayOfByte);
    }
    throw new IllegalStateException("RSA engine not initialised");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\RSABlindedEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */