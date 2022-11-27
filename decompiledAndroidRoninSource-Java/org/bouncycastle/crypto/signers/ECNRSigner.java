package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DSA;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.generators.ECKeyPairGenerator;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyGenerationParameters;
import org.bouncycastle.crypto.params.ECKeyParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;

public class ECNRSigner
  implements DSA
{
  private boolean forSigning;
  private ECKeyParameters key;
  private SecureRandom random;
  
  public BigInteger[] generateSignature(byte[] paramArrayOfByte)
  {
    if (this.forSigning)
    {
      BigInteger localBigInteger1 = ((ECPrivateKeyParameters)this.key).getParameters().getN();
      int i = localBigInteger1.bitLength();
      paramArrayOfByte = new BigInteger(1, paramArrayOfByte);
      int j = paramArrayOfByte.bitLength();
      ECPrivateKeyParameters localECPrivateKeyParameters = (ECPrivateKeyParameters)this.key;
      if (j <= i)
      {
        Object localObject;
        BigInteger localBigInteger2;
        do
        {
          localObject = new ECKeyPairGenerator();
          ((ECKeyPairGenerator)localObject).init(new ECKeyGenerationParameters(localECPrivateKeyParameters.getParameters(), this.random));
          localObject = ((ECKeyPairGenerator)localObject).generateKeyPair();
          localBigInteger2 = ((ECPublicKeyParameters)((AsymmetricCipherKeyPair)localObject).getPublic()).getQ().getAffineXCoord().toBigInteger().add(paramArrayOfByte).mod(localBigInteger1);
        } while (localBigInteger2.equals(ECConstants.ZERO));
        paramArrayOfByte = localECPrivateKeyParameters.getD();
        return new BigInteger[] { localBigInteger2, ((ECPrivateKeyParameters)((AsymmetricCipherKeyPair)localObject).getPrivate()).getD().subtract(localBigInteger2.multiply(paramArrayOfByte)).mod(localBigInteger1) };
      }
      throw new DataLengthException("input too large for ECNR key.");
    }
    throw new IllegalStateException("not initialised for signing");
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    this.forSigning = paramBoolean;
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
    if (!this.forSigning)
    {
      ECPublicKeyParameters localECPublicKeyParameters = (ECPublicKeyParameters)this.key;
      BigInteger localBigInteger = localECPublicKeyParameters.getParameters().getN();
      int i = localBigInteger.bitLength();
      paramArrayOfByte = new BigInteger(1, paramArrayOfByte);
      if (paramArrayOfByte.bitLength() <= i)
      {
        if (paramBigInteger1.compareTo(ECConstants.ONE) >= 0)
        {
          if (paramBigInteger1.compareTo(localBigInteger) >= 0) {
            return false;
          }
          if (paramBigInteger2.compareTo(ECConstants.ZERO) >= 0)
          {
            if (paramBigInteger2.compareTo(localBigInteger) >= 0) {
              return false;
            }
            paramBigInteger2 = ECAlgorithms.sumOfTwoMultiplies(localECPublicKeyParameters.getParameters().getG(), paramBigInteger2, localECPublicKeyParameters.getQ(), paramBigInteger1).normalize();
            if (paramBigInteger2.isInfinity()) {
              return false;
            }
            return paramBigInteger1.subtract(paramBigInteger2.getAffineXCoord().toBigInteger()).mod(localBigInteger).equals(paramArrayOfByte);
          }
        }
        return false;
      }
      throw new DataLengthException("input too large for ECNR key.");
    }
    throw new IllegalStateException("not initialised for verifying");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\signers\ECNRSigner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */