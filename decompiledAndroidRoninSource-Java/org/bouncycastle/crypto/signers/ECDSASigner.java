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
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;

public class ECDSASigner
  implements ECConstants, DSA
{
  private final DSAKCalculator kCalculator;
  private ECKeyParameters key;
  private SecureRandom random;
  
  public ECDSASigner()
  {
    this.kCalculator = new RandomDSAKCalculator();
  }
  
  public ECDSASigner(DSAKCalculator paramDSAKCalculator)
  {
    this.kCalculator = paramDSAKCalculator;
  }
  
  protected BigInteger calculateE(BigInteger paramBigInteger, byte[] paramArrayOfByte)
  {
    int i = paramBigInteger.bitLength();
    int j = paramArrayOfByte.length * 8;
    paramArrayOfByte = new BigInteger(1, paramArrayOfByte);
    paramBigInteger = paramArrayOfByte;
    if (i < j) {
      paramBigInteger = paramArrayOfByte.shiftRight(j - i);
    }
    return paramBigInteger;
  }
  
  protected ECMultiplier createBasePointMultiplier()
  {
    return new FixedPointCombMultiplier();
  }
  
  public BigInteger[] generateSignature(byte[] paramArrayOfByte)
  {
    ECDomainParameters localECDomainParameters = this.key.getParameters();
    BigInteger localBigInteger1 = localECDomainParameters.getN();
    BigInteger localBigInteger2 = calculateE(localBigInteger1, paramArrayOfByte);
    BigInteger localBigInteger3 = ((ECPrivateKeyParameters)this.key).getD();
    if (this.kCalculator.isDeterministic()) {
      this.kCalculator.init(localBigInteger1, localBigInteger3, paramArrayOfByte);
    } else {
      this.kCalculator.init(localBigInteger1, this.random);
    }
    paramArrayOfByte = createBasePointMultiplier();
    BigInteger localBigInteger5;
    BigInteger localBigInteger4;
    do
    {
      do
      {
        localBigInteger5 = this.kCalculator.nextK();
        localBigInteger4 = paramArrayOfByte.multiply(localECDomainParameters.getG(), localBigInteger5).normalize().getAffineXCoord().toBigInteger().mod(localBigInteger1);
      } while (localBigInteger4.equals(ZERO));
      localBigInteger5 = localBigInteger5.modInverse(localBigInteger1).multiply(localBigInteger2.add(localBigInteger3.multiply(localBigInteger4))).mod(localBigInteger1);
    } while (localBigInteger5.equals(ZERO));
    return new BigInteger[] { localBigInteger4, localBigInteger5 };
  }
  
  protected ECFieldElement getDenominator(int paramInt, ECPoint paramECPoint)
  {
    if (paramInt != 1) {
      if ((paramInt != 2) && (paramInt != 3) && (paramInt != 4))
      {
        if ((paramInt != 6) && (paramInt != 7)) {
          return null;
        }
      }
      else {
        return paramECPoint.getZCoord(0).square();
      }
    }
    return paramECPoint.getZCoord(0);
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    if (paramBoolean)
    {
      if ((paramCipherParameters instanceof ParametersWithRandom))
      {
        paramCipherParameters = (ParametersWithRandom)paramCipherParameters;
        this.key = ((ECPrivateKeyParameters)paramCipherParameters.getParameters());
        paramCipherParameters = paramCipherParameters.getRandom();
        break label55;
      }
      paramCipherParameters = (ECPrivateKeyParameters)paramCipherParameters;
    }
    else
    {
      paramCipherParameters = (ECPublicKeyParameters)paramCipherParameters;
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
    Object localObject = this.key.getParameters();
    BigInteger localBigInteger = ((ECDomainParameters)localObject).getN();
    paramArrayOfByte = calculateE(localBigInteger, paramArrayOfByte);
    if (paramBigInteger1.compareTo(ONE) >= 0)
    {
      if (paramBigInteger1.compareTo(localBigInteger) >= 0) {
        return false;
      }
      if (paramBigInteger2.compareTo(ONE) >= 0)
      {
        if (paramBigInteger2.compareTo(localBigInteger) >= 0) {
          return false;
        }
        paramBigInteger2 = paramBigInteger2.modInverse(localBigInteger);
        paramArrayOfByte = paramArrayOfByte.multiply(paramBigInteger2).mod(localBigInteger);
        paramBigInteger2 = paramBigInteger1.multiply(paramBigInteger2).mod(localBigInteger);
        localObject = ECAlgorithms.sumOfTwoMultiplies(((ECDomainParameters)localObject).getG(), paramArrayOfByte, ((ECPublicKeyParameters)this.key).getQ(), paramBigInteger2);
        if (((ECPoint)localObject).isInfinity()) {
          return false;
        }
        paramArrayOfByte = ((ECPoint)localObject).getCurve();
        if (paramArrayOfByte != null)
        {
          paramBigInteger2 = paramArrayOfByte.getCofactor();
          if ((paramBigInteger2 != null) && (paramBigInteger2.compareTo(EIGHT) <= 0))
          {
            paramBigInteger2 = getDenominator(paramArrayOfByte.getCoordinateSystem(), (ECPoint)localObject);
            if ((paramBigInteger2 != null) && (!paramBigInteger2.isZero()))
            {
              localObject = ((ECPoint)localObject).getXCoord();
              while (paramArrayOfByte.isValidFieldElement(paramBigInteger1))
              {
                if (paramArrayOfByte.fromBigInteger(paramBigInteger1).multiply(paramBigInteger2).equals(localObject)) {
                  return true;
                }
                paramBigInteger1 = paramBigInteger1.add(localBigInteger);
              }
              return false;
            }
          }
        }
        return ((ECPoint)localObject).normalize().getAffineXCoord().toBigInteger().mod(localBigInteger).equals(paramBigInteger1);
      }
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\signers\ECDSASigner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */