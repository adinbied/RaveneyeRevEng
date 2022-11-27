package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DSA;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithID;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;
import org.bouncycastle.util.BigIntegers;

public class SM2Signer
  implements DSA, ECConstants
{
  private int curveLength;
  private ECKeyParameters ecKey;
  private ECDomainParameters ecParams;
  private final DSAKCalculator kCalculator = new RandomDSAKCalculator();
  private ECPoint pubPoint;
  private SecureRandom random;
  private byte[] userID;
  
  private void addFieldElement(Digest paramDigest, ECFieldElement paramECFieldElement)
  {
    paramECFieldElement = BigIntegers.asUnsignedByteArray(this.curveLength, paramECFieldElement.toBigInteger());
    paramDigest.update(paramECFieldElement, 0, paramECFieldElement.length);
  }
  
  private void addUserID(Digest paramDigest, byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length * 8;
    paramDigest.update((byte)(i >> 8 & 0xFF));
    paramDigest.update((byte)(i & 0xFF));
    paramDigest.update(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private byte[] getZ(Digest paramDigest)
  {
    addUserID(paramDigest, this.userID);
    addFieldElement(paramDigest, this.ecParams.getCurve().getA());
    addFieldElement(paramDigest, this.ecParams.getCurve().getB());
    addFieldElement(paramDigest, this.ecParams.getG().getAffineXCoord());
    addFieldElement(paramDigest, this.ecParams.getG().getAffineYCoord());
    addFieldElement(paramDigest, this.pubPoint.getAffineXCoord());
    addFieldElement(paramDigest, this.pubPoint.getAffineYCoord());
    byte[] arrayOfByte = new byte[paramDigest.getDigestSize()];
    paramDigest.doFinal(arrayOfByte, 0);
    return arrayOfByte;
  }
  
  protected BigInteger calculateE(byte[] paramArrayOfByte)
  {
    return new BigInteger(1, paramArrayOfByte);
  }
  
  protected ECMultiplier createBasePointMultiplier()
  {
    return new FixedPointCombMultiplier();
  }
  
  public BigInteger[] generateSignature(byte[] paramArrayOfByte)
  {
    Object localObject1 = new SM3Digest();
    Object localObject2 = getZ((Digest)localObject1);
    ((SM3Digest)localObject1).update((byte[])localObject2, 0, localObject2.length);
    ((SM3Digest)localObject1).update(paramArrayOfByte, 0, paramArrayOfByte.length);
    localObject2 = new byte[((SM3Digest)localObject1).getDigestSize()];
    ((SM3Digest)localObject1).doFinal((byte[])localObject2, 0);
    paramArrayOfByte = this.ecParams.getN();
    localObject1 = calculateE((byte[])localObject2);
    localObject2 = ((ECPrivateKeyParameters)this.ecKey).getD();
    ECMultiplier localECMultiplier = createBasePointMultiplier();
    BigInteger localBigInteger2;
    BigInteger localBigInteger1;
    do
    {
      do
      {
        localBigInteger2 = this.kCalculator.nextK();
        localBigInteger1 = ((BigInteger)localObject1).add(localECMultiplier.multiply(this.ecParams.getG(), localBigInteger2).normalize().getAffineXCoord().toBigInteger()).mod(paramArrayOfByte);
      } while ((localBigInteger1.equals(ZERO)) || (localBigInteger1.add(localBigInteger2).equals(paramArrayOfByte)));
      localBigInteger2 = ((BigInteger)localObject2).add(ONE).modInverse(paramArrayOfByte).multiply(localBigInteger2.subtract(localBigInteger1.multiply((BigInteger)localObject2)).mod(paramArrayOfByte)).mod(paramArrayOfByte);
    } while (localBigInteger2.equals(ZERO));
    return new BigInteger[] { localBigInteger1, localBigInteger2 };
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    Object localObject;
    if ((paramCipherParameters instanceof ParametersWithID))
    {
      localObject = (ParametersWithID)paramCipherParameters;
      paramCipherParameters = ((ParametersWithID)localObject).getParameters();
      this.userID = ((ParametersWithID)localObject).getID();
    }
    else
    {
      this.userID = new byte[0];
    }
    if (paramBoolean)
    {
      if ((paramCipherParameters instanceof ParametersWithRandom))
      {
        paramCipherParameters = (ParametersWithRandom)paramCipherParameters;
        localObject = (ECKeyParameters)paramCipherParameters.getParameters();
        this.ecKey = ((ECKeyParameters)localObject);
        localObject = ((ECKeyParameters)localObject).getParameters();
        this.ecParams = ((ECDomainParameters)localObject);
        this.kCalculator.init(((ECDomainParameters)localObject).getN(), paramCipherParameters.getRandom());
      }
      else
      {
        paramCipherParameters = (ECKeyParameters)paramCipherParameters;
        this.ecKey = paramCipherParameters;
        paramCipherParameters = paramCipherParameters.getParameters();
        this.ecParams = paramCipherParameters;
        this.kCalculator.init(paramCipherParameters.getN(), new SecureRandom());
      }
      paramCipherParameters = this.ecParams.getG().multiply(((ECPrivateKeyParameters)this.ecKey).getD()).normalize();
    }
    else
    {
      paramCipherParameters = (ECKeyParameters)paramCipherParameters;
      this.ecKey = paramCipherParameters;
      this.ecParams = paramCipherParameters.getParameters();
      paramCipherParameters = ((ECPublicKeyParameters)this.ecKey).getQ();
    }
    this.pubPoint = paramCipherParameters;
    this.curveLength = ((this.ecParams.getCurve().getFieldSize() + 7) / 8);
  }
  
  public boolean verifySignature(byte[] paramArrayOfByte, BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    BigInteger localBigInteger = this.ecParams.getN();
    if (paramBigInteger1.compareTo(ONE) >= 0)
    {
      if (paramBigInteger1.compareTo(localBigInteger) > 0) {
        return false;
      }
      if (paramBigInteger2.compareTo(ONE) >= 0)
      {
        if (paramBigInteger2.compareTo(localBigInteger) > 0) {
          return false;
        }
        ECPoint localECPoint = ((ECPublicKeyParameters)this.ecKey).getQ();
        Object localObject = new SM3Digest();
        byte[] arrayOfByte = getZ((Digest)localObject);
        ((SM3Digest)localObject).update(arrayOfByte, 0, arrayOfByte.length);
        ((SM3Digest)localObject).update(paramArrayOfByte, 0, paramArrayOfByte.length);
        paramArrayOfByte = new byte[((SM3Digest)localObject).getDigestSize()];
        ((SM3Digest)localObject).doFinal(paramArrayOfByte, 0);
        paramArrayOfByte = calculateE(paramArrayOfByte);
        localObject = paramBigInteger1.add(paramBigInteger2).mod(localBigInteger);
        if (((BigInteger)localObject).equals(ZERO)) {
          return false;
        }
        return paramBigInteger1.equals(paramArrayOfByte.add(this.ecParams.getG().multiply(paramBigInteger2).add(localECPoint.multiply((BigInteger)localObject)).normalize().getAffineXCoord().toBigInteger()).mod(localBigInteger));
      }
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\signers\SM2Signer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */