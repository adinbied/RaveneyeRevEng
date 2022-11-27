package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DSA;
import org.bouncycastle.crypto.params.DSAKeyParameters;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;

public class DSASigner
  implements DSA
{
  private final DSAKCalculator kCalculator;
  private DSAKeyParameters key;
  private SecureRandom random;
  
  public DSASigner()
  {
    this.kCalculator = new RandomDSAKCalculator();
  }
  
  public DSASigner(DSAKCalculator paramDSAKCalculator)
  {
    this.kCalculator = paramDSAKCalculator;
  }
  
  private BigInteger calculateE(BigInteger paramBigInteger, byte[] paramArrayOfByte)
  {
    if (paramBigInteger.bitLength() >= paramArrayOfByte.length * 8) {
      return new BigInteger(1, paramArrayOfByte);
    }
    int i = paramBigInteger.bitLength() / 8;
    paramBigInteger = new byte[i];
    System.arraycopy(paramArrayOfByte, 0, paramBigInteger, 0, i);
    return new BigInteger(1, paramBigInteger);
  }
  
  private BigInteger getRandomizer(BigInteger paramBigInteger, SecureRandom paramSecureRandom)
  {
    if (paramSecureRandom == null) {
      paramSecureRandom = new SecureRandom();
    }
    return new BigInteger(7, paramSecureRandom).add(BigInteger.valueOf(128L)).multiply(paramBigInteger);
  }
  
  public BigInteger[] generateSignature(byte[] paramArrayOfByte)
  {
    Object localObject = this.key.getParameters();
    BigInteger localBigInteger1 = ((DSAParameters)localObject).getQ();
    BigInteger localBigInteger2 = calculateE(localBigInteger1, paramArrayOfByte);
    BigInteger localBigInteger3 = ((DSAPrivateKeyParameters)this.key).getX();
    if (this.kCalculator.isDeterministic()) {
      this.kCalculator.init(localBigInteger1, localBigInteger3, paramArrayOfByte);
    } else {
      this.kCalculator.init(localBigInteger1, this.random);
    }
    paramArrayOfByte = this.kCalculator.nextK();
    localObject = ((DSAParameters)localObject).getG().modPow(paramArrayOfByte.add(getRandomizer(localBigInteger1, this.random)), ((DSAParameters)localObject).getP()).mod(localBigInteger1);
    return new BigInteger[] { localObject, paramArrayOfByte.modInverse(localBigInteger1).multiply(localBigInteger2.add(localBigInteger3.multiply((BigInteger)localObject))).mod(localBigInteger1) };
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    if (paramBoolean)
    {
      if ((paramCipherParameters instanceof ParametersWithRandom))
      {
        paramCipherParameters = (ParametersWithRandom)paramCipherParameters;
        this.key = ((DSAPrivateKeyParameters)paramCipherParameters.getParameters());
        paramCipherParameters = paramCipherParameters.getRandom();
        break label55;
      }
      paramCipherParameters = (DSAPrivateKeyParameters)paramCipherParameters;
    }
    else
    {
      paramCipherParameters = (DSAPublicKeyParameters)paramCipherParameters;
    }
    this.key = paramCipherParameters;
    paramCipherParameters = null;
    label55:
    if ((paramBoolean) && (!this.kCalculator.isDeterministic())) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    this.random = initSecureRandom(paramBoolean, paramCipherParameters);
  }
  
  protected SecureRandom initSecureRandom(boolean paramBoolean, SecureRandom paramSecureRandom)
  {
    if (!paramBoolean) {
      return null;
    }
    if (paramSecureRandom != null) {
      return paramSecureRandom;
    }
    return new SecureRandom();
  }
  
  public boolean verifySignature(byte[] paramArrayOfByte, BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    DSAParameters localDSAParameters = this.key.getParameters();
    BigInteger localBigInteger1 = localDSAParameters.getQ();
    paramArrayOfByte = calculateE(localBigInteger1, paramArrayOfByte);
    BigInteger localBigInteger2 = BigInteger.valueOf(0L);
    if (localBigInteger2.compareTo(paramBigInteger1) < 0)
    {
      if (localBigInteger1.compareTo(paramBigInteger1) <= 0) {
        return false;
      }
      if (localBigInteger2.compareTo(paramBigInteger2) < 0)
      {
        if (localBigInteger1.compareTo(paramBigInteger2) <= 0) {
          return false;
        }
        paramBigInteger2 = paramBigInteger2.modInverse(localBigInteger1);
        paramArrayOfByte = paramArrayOfByte.multiply(paramBigInteger2).mod(localBigInteger1);
        paramBigInteger2 = paramBigInteger1.multiply(paramBigInteger2).mod(localBigInteger1);
        localBigInteger2 = localDSAParameters.getP();
        return localDSAParameters.getG().modPow(paramArrayOfByte, localBigInteger2).multiply(((DSAPublicKeyParameters)this.key).getY().modPow(paramBigInteger2, localBigInteger2)).mod(localBigInteger2).mod(localBigInteger1).equals(paramBigInteger1);
      }
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\signers\DSASigner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */