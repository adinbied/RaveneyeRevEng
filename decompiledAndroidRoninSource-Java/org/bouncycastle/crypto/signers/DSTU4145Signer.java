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
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;
import org.bouncycastle.util.Arrays;

public class DSTU4145Signer
  implements DSA
{
  private static final BigInteger ONE = BigInteger.valueOf(1L);
  private ECKeyParameters key;
  private SecureRandom random;
  
  private static BigInteger fieldElement2Integer(BigInteger paramBigInteger, ECFieldElement paramECFieldElement)
  {
    return truncate(paramECFieldElement.toBigInteger(), paramBigInteger.bitLength() - 1);
  }
  
  private static BigInteger generateRandomInteger(BigInteger paramBigInteger, SecureRandom paramSecureRandom)
  {
    return new BigInteger(paramBigInteger.bitLength() - 1, paramSecureRandom);
  }
  
  private static ECFieldElement hash2FieldElement(ECCurve paramECCurve, byte[] paramArrayOfByte)
  {
    return paramECCurve.fromBigInteger(truncate(new BigInteger(1, Arrays.reverse(paramArrayOfByte)), paramECCurve.getFieldSize()));
  }
  
  private static BigInteger truncate(BigInteger paramBigInteger, int paramInt)
  {
    BigInteger localBigInteger = paramBigInteger;
    if (paramBigInteger.bitLength() > paramInt) {
      localBigInteger = paramBigInteger.mod(ONE.shiftLeft(paramInt));
    }
    return localBigInteger;
  }
  
  protected ECMultiplier createBasePointMultiplier()
  {
    return new FixedPointCombMultiplier();
  }
  
  public BigInteger[] generateSignature(byte[] paramArrayOfByte)
  {
    ECDomainParameters localECDomainParameters = this.key.getParameters();
    Object localObject2 = localECDomainParameters.getCurve();
    Object localObject1 = hash2FieldElement((ECCurve)localObject2, paramArrayOfByte);
    paramArrayOfByte = (byte[])localObject1;
    if (((ECFieldElement)localObject1).isZero()) {
      paramArrayOfByte = ((ECCurve)localObject2).fromBigInteger(ONE);
    }
    localObject1 = localECDomainParameters.getN();
    localObject2 = ((ECPrivateKeyParameters)this.key).getD();
    ECMultiplier localECMultiplier = createBasePointMultiplier();
    BigInteger localBigInteger;
    Object localObject3;
    do
    {
      do
      {
        do
        {
          localBigInteger = generateRandomInteger((BigInteger)localObject1, this.random);
          localObject3 = localECMultiplier.multiply(localECDomainParameters.getG(), localBigInteger).normalize().getAffineXCoord();
        } while (((ECFieldElement)localObject3).isZero());
        localObject3 = fieldElement2Integer((BigInteger)localObject1, paramArrayOfByte.multiply((ECFieldElement)localObject3));
      } while (((BigInteger)localObject3).signum() == 0);
      localBigInteger = ((BigInteger)localObject3).multiply((BigInteger)localObject2).add(localBigInteger).mod((BigInteger)localObject1);
    } while (localBigInteger.signum() == 0);
    return new BigInteger[] { localObject3, localBigInteger };
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    if (paramBoolean)
    {
      if ((paramCipherParameters instanceof ParametersWithRandom))
      {
        paramCipherParameters = (ParametersWithRandom)paramCipherParameters;
        this.random = paramCipherParameters.getRandom();
        paramCipherParameters = paramCipherParameters.getParameters();
      }
      else
      {
        this.random = new SecureRandom();
      }
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
    int i = paramBigInteger1.signum();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i > 0)
    {
      if (paramBigInteger2.signum() <= 0) {
        return false;
      }
      ECDomainParameters localECDomainParameters = this.key.getParameters();
      BigInteger localBigInteger = localECDomainParameters.getN();
      bool1 = bool2;
      if (paramBigInteger1.compareTo(localBigInteger) < 0)
      {
        if (paramBigInteger2.compareTo(localBigInteger) >= 0) {
          return false;
        }
        ECCurve localECCurve = localECDomainParameters.getCurve();
        ECFieldElement localECFieldElement = hash2FieldElement(localECCurve, paramArrayOfByte);
        paramArrayOfByte = localECFieldElement;
        if (localECFieldElement.isZero()) {
          paramArrayOfByte = localECCurve.fromBigInteger(ONE);
        }
        paramBigInteger2 = ECAlgorithms.sumOfTwoMultiplies(localECDomainParameters.getG(), paramBigInteger2, ((ECPublicKeyParameters)this.key).getQ(), paramBigInteger1).normalize();
        if (paramBigInteger2.isInfinity()) {
          return false;
        }
        bool1 = bool2;
        if (fieldElement2Integer(localBigInteger, paramArrayOfByte.multiply(paramBigInteger2.getAffineXCoord())).compareTo(paramBigInteger1) == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\signers\DSTU4145Signer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */