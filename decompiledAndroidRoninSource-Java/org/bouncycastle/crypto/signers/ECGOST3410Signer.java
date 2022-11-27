package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DSA;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;

public class ECGOST3410Signer
  implements DSA
{
  ECKeyParameters key;
  SecureRandom random;
  
  protected ECMultiplier createBasePointMultiplier()
  {
    return new FixedPointCombMultiplier();
  }
  
  public BigInteger[] generateSignature(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length;
    Object localObject = new byte[j];
    int i = 0;
    while (i != j)
    {
      localObject[i] = paramArrayOfByte[(j - 1 - i)];
      i += 1;
    }
    paramArrayOfByte = new BigInteger(1, (byte[])localObject);
    localObject = this.key.getParameters();
    BigInteger localBigInteger1 = ((ECDomainParameters)localObject).getN();
    BigInteger localBigInteger2 = ((ECPrivateKeyParameters)this.key).getD();
    ECMultiplier localECMultiplier = createBasePointMultiplier();
    BigInteger localBigInteger4;
    BigInteger localBigInteger3;
    do
    {
      do
      {
        do
        {
          localBigInteger4 = new BigInteger(localBigInteger1.bitLength(), this.random);
        } while (localBigInteger4.equals(ECConstants.ZERO));
        localBigInteger3 = localECMultiplier.multiply(((ECDomainParameters)localObject).getG(), localBigInteger4).normalize().getAffineXCoord().toBigInteger().mod(localBigInteger1);
      } while (localBigInteger3.equals(ECConstants.ZERO));
      localBigInteger4 = localBigInteger4.multiply(paramArrayOfByte).add(localBigInteger2.multiply(localBigInteger3)).mod(localBigInteger1);
    } while (localBigInteger4.equals(ECConstants.ZERO));
    return new BigInteger[] { localBigInteger3, localBigInteger4 };
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    if (paramBoolean)
    {
      if ((paramCipherParameters instanceof ParametersWithRandom))
      {
        paramCipherParameters = (ParametersWithRandom)paramCipherParameters;
        this.random = paramCipherParameters.getRandom();
        this.key = ((ECPrivateKeyParameters)paramCipherParameters.getParameters());
        return;
      }
      this.random = new SecureRandom();
      paramCipherParameters = (ECPrivateKeyParameters)paramCipherParameters;
    }
    else
    {
      paramCipherParameters = (ECPublicKeyParameters)paramCipherParameters;
    }
    this.key = paramCipherParameters;
  }
  
  public boolean verifySignature(byte[] paramArrayOfByte, BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    int j = paramArrayOfByte.length;
    Object localObject = new byte[j];
    int i = 0;
    while (i != j)
    {
      localObject[i] = paramArrayOfByte[(j - 1 - i)];
      i += 1;
    }
    localObject = new BigInteger(1, (byte[])localObject);
    paramArrayOfByte = this.key.getParameters().getN();
    if (paramBigInteger1.compareTo(ECConstants.ONE) >= 0)
    {
      if (paramBigInteger1.compareTo(paramArrayOfByte) >= 0) {
        return false;
      }
      if (paramBigInteger2.compareTo(ECConstants.ONE) >= 0)
      {
        if (paramBigInteger2.compareTo(paramArrayOfByte) >= 0) {
          return false;
        }
        localObject = ((BigInteger)localObject).modInverse(paramArrayOfByte);
        paramBigInteger2 = paramBigInteger2.multiply((BigInteger)localObject).mod(paramArrayOfByte);
        localObject = paramArrayOfByte.subtract(paramBigInteger1).multiply((BigInteger)localObject).mod(paramArrayOfByte);
        paramBigInteger2 = ECAlgorithms.sumOfTwoMultiplies(this.key.getParameters().getG(), paramBigInteger2, ((ECPublicKeyParameters)this.key).getQ(), (BigInteger)localObject).normalize();
        if (paramBigInteger2.isInfinity()) {
          return false;
        }
        return paramBigInteger2.getAffineXCoord().toBigInteger().mod(paramArrayOfByte).equals(paramBigInteger1);
      }
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\signers\ECGOST3410Signer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */