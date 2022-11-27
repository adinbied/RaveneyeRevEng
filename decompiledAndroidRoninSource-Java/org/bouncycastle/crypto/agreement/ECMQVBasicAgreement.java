package org.bouncycastle.crypto.agreement;

import java.math.BigInteger;
import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.MQVPrivateParameters;
import org.bouncycastle.crypto.params.MQVPublicParameters;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.Properties;

public class ECMQVBasicAgreement
  implements BasicAgreement
{
  MQVPrivateParameters privParams;
  
  private ECPoint calculateMqvAgreement(ECDomainParameters paramECDomainParameters, ECPrivateKeyParameters paramECPrivateKeyParameters1, ECPrivateKeyParameters paramECPrivateKeyParameters2, ECPublicKeyParameters paramECPublicKeyParameters1, ECPublicKeyParameters paramECPublicKeyParameters2, ECPublicKeyParameters paramECPublicKeyParameters3)
  {
    BigInteger localBigInteger1 = paramECDomainParameters.getN();
    int i = (localBigInteger1.bitLength() + 1) / 2;
    BigInteger localBigInteger2 = ECConstants.ONE.shiftLeft(i);
    ECCurve localECCurve = paramECDomainParameters.getCurve();
    ECPoint[] arrayOfECPoint = new ECPoint[3];
    arrayOfECPoint[0] = ECAlgorithms.importPoint(localECCurve, paramECPublicKeyParameters1.getQ());
    arrayOfECPoint[1] = ECAlgorithms.importPoint(localECCurve, paramECPublicKeyParameters2.getQ());
    arrayOfECPoint[2] = ECAlgorithms.importPoint(localECCurve, paramECPublicKeyParameters3.getQ());
    localECCurve.normalizeAll(arrayOfECPoint);
    paramECPublicKeyParameters3 = arrayOfECPoint[0];
    paramECPublicKeyParameters1 = arrayOfECPoint[1];
    paramECPublicKeyParameters2 = arrayOfECPoint[2];
    paramECPublicKeyParameters3 = paramECPublicKeyParameters3.getAffineXCoord().toBigInteger().mod(localBigInteger2).setBit(i);
    paramECPrivateKeyParameters1 = paramECPrivateKeyParameters1.getD().multiply(paramECPublicKeyParameters3).add(paramECPrivateKeyParameters2.getD()).mod(localBigInteger1);
    paramECPrivateKeyParameters2 = paramECPublicKeyParameters2.getAffineXCoord().toBigInteger().mod(localBigInteger2).setBit(i);
    paramECDomainParameters = paramECDomainParameters.getH().multiply(paramECPrivateKeyParameters1).mod(localBigInteger1);
    return ECAlgorithms.sumOfTwoMultiplies(paramECPublicKeyParameters1, paramECPrivateKeyParameters2.multiply(paramECDomainParameters).mod(localBigInteger1), paramECPublicKeyParameters2, paramECDomainParameters);
  }
  
  public BigInteger calculateAgreement(CipherParameters paramCipherParameters)
  {
    if (!Properties.isOverrideSet("org.bouncycastle.ec.disable_mqv"))
    {
      paramCipherParameters = (MQVPublicParameters)paramCipherParameters;
      ECPrivateKeyParameters localECPrivateKeyParameters = this.privParams.getStaticPrivateKey();
      ECDomainParameters localECDomainParameters = localECPrivateKeyParameters.getParameters();
      if (localECDomainParameters.equals(paramCipherParameters.getStaticPublicKey().getParameters()))
      {
        paramCipherParameters = calculateMqvAgreement(localECDomainParameters, localECPrivateKeyParameters, this.privParams.getEphemeralPrivateKey(), this.privParams.getEphemeralPublicKey(), paramCipherParameters.getStaticPublicKey(), paramCipherParameters.getEphemeralPublicKey()).normalize();
        if (!paramCipherParameters.isInfinity()) {
          return paramCipherParameters.getAffineXCoord().toBigInteger();
        }
        throw new IllegalStateException("Infinity is not a valid agreement value for MQV");
      }
      throw new IllegalStateException("ECMQV public key components have wrong domain parameters");
    }
    throw new IllegalStateException("ECMQV explicitly disabled");
  }
  
  public int getFieldSize()
  {
    return (this.privParams.getStaticPrivateKey().getParameters().getCurve().getFieldSize() + 7) / 8;
  }
  
  public void init(CipherParameters paramCipherParameters)
  {
    this.privParams = ((MQVPrivateParameters)paramCipherParameters);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\agreement\ECMQVBasicAgreement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */