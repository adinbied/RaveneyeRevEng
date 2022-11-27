package org.bouncycastle.crypto.agreement;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithID;
import org.bouncycastle.crypto.params.SM2KeyExchangePrivateParameters;
import org.bouncycastle.crypto.params.SM2KeyExchangePublicParameters;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

public class SM2KeyExchange
{
  private int curveLength;
  private final Digest digest;
  private ECDomainParameters ecParams;
  private ECPrivateKeyParameters ephemeralKey;
  private ECPoint ephemeralPubPoint;
  private boolean initiator;
  private ECPrivateKeyParameters staticKey;
  private ECPoint staticPubPoint;
  private byte[] userID;
  private int w;
  
  public SM2KeyExchange()
  {
    this(new SM3Digest());
  }
  
  public SM2KeyExchange(Digest paramDigest)
  {
    this.digest = paramDigest;
  }
  
  private byte[] S1(Digest paramDigest, ECPoint paramECPoint, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[paramDigest.getDigestSize()];
    paramDigest.update((byte)2);
    addFieldElement(paramDigest, paramECPoint.getAffineYCoord());
    paramDigest.update(paramArrayOfByte, 0, paramArrayOfByte.length);
    paramDigest.doFinal(arrayOfByte, 0);
    return arrayOfByte;
  }
  
  private byte[] S2(Digest paramDigest, ECPoint paramECPoint, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[paramDigest.getDigestSize()];
    paramDigest.update((byte)3);
    addFieldElement(paramDigest, paramECPoint.getAffineYCoord());
    paramDigest.update(paramArrayOfByte, 0, paramArrayOfByte.length);
    paramDigest.doFinal(arrayOfByte, 0);
    return arrayOfByte;
  }
  
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
  
  private byte[] calculateInnerHash(Digest paramDigest, ECPoint paramECPoint1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, ECPoint paramECPoint2, ECPoint paramECPoint3)
  {
    addFieldElement(paramDigest, paramECPoint1.getAffineXCoord());
    paramDigest.update(paramArrayOfByte1, 0, paramArrayOfByte1.length);
    paramDigest.update(paramArrayOfByte2, 0, paramArrayOfByte2.length);
    addFieldElement(paramDigest, paramECPoint2.getAffineXCoord());
    addFieldElement(paramDigest, paramECPoint2.getAffineYCoord());
    addFieldElement(paramDigest, paramECPoint3.getAffineXCoord());
    addFieldElement(paramDigest, paramECPoint3.getAffineYCoord());
    paramECPoint1 = new byte[paramDigest.getDigestSize()];
    paramDigest.doFinal(paramECPoint1, 0);
    return paramECPoint1;
  }
  
  private ECPoint calculateU(SM2KeyExchangePublicParameters paramSM2KeyExchangePublicParameters)
  {
    BigInteger localBigInteger = reduce(this.ephemeralPubPoint.getAffineXCoord().toBigInteger());
    localBigInteger = this.staticKey.getD().add(localBigInteger.multiply(this.ephemeralKey.getD())).mod(this.ecParams.getN());
    Object localObject = reduce(paramSM2KeyExchangePublicParameters.getEphemeralPublicKey().getQ().getAffineXCoord().toBigInteger());
    localObject = paramSM2KeyExchangePublicParameters.getEphemeralPublicKey().getQ().multiply((BigInteger)localObject).normalize();
    return paramSM2KeyExchangePublicParameters.getStaticPublicKey().getQ().add((ECPoint)localObject).normalize().multiply(this.ecParams.getH().multiply(localBigInteger)).normalize();
  }
  
  private byte[] getZ(Digest paramDigest, byte[] paramArrayOfByte, ECPoint paramECPoint)
  {
    addUserID(paramDigest, paramArrayOfByte);
    addFieldElement(paramDigest, this.ecParams.getCurve().getA());
    addFieldElement(paramDigest, this.ecParams.getCurve().getB());
    addFieldElement(paramDigest, this.ecParams.getG().getAffineXCoord());
    addFieldElement(paramDigest, this.ecParams.getG().getAffineYCoord());
    addFieldElement(paramDigest, paramECPoint.getAffineXCoord());
    addFieldElement(paramDigest, paramECPoint.getAffineYCoord());
    paramArrayOfByte = new byte[paramDigest.getDigestSize()];
    paramDigest.doFinal(paramArrayOfByte, 0);
    return paramArrayOfByte;
  }
  
  private byte[] kdf(ECPoint paramECPoint, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    int n = this.digest.getDigestSize() * 8;
    int i1 = this.digest.getDigestSize();
    byte[] arrayOfByte1 = new byte[i1];
    int i2 = (paramInt + 7) / 8;
    byte[] arrayOfByte2 = new byte[i2];
    int i = 1;
    int j = 1;
    int m;
    for (int k = 0; i <= (paramInt + n - 1) / n; k = m)
    {
      addFieldElement(this.digest, paramECPoint.getAffineXCoord());
      addFieldElement(this.digest, paramECPoint.getAffineYCoord());
      this.digest.update(paramArrayOfByte1, 0, paramArrayOfByte1.length);
      this.digest.update(paramArrayOfByte2, 0, paramArrayOfByte2.length);
      this.digest.update((byte)(j >> 24));
      this.digest.update((byte)(j >> 16));
      this.digest.update((byte)(j >> 8));
      this.digest.update((byte)j);
      this.digest.doFinal(arrayOfByte1, 0);
      m = k + i1;
      if (m < i2) {
        System.arraycopy(arrayOfByte1, 0, arrayOfByte2, k, i1);
      } else {
        System.arraycopy(arrayOfByte1, 0, arrayOfByte2, k, i2 - k);
      }
      j += 1;
      i += 1;
    }
    return arrayOfByte2;
  }
  
  private BigInteger reduce(BigInteger paramBigInteger)
  {
    return paramBigInteger.and(BigInteger.valueOf(1L).shiftLeft(this.w).subtract(BigInteger.valueOf(1L))).setBit(this.w);
  }
  
  public byte[] calculateKey(int paramInt, CipherParameters paramCipherParameters)
  {
    if ((paramCipherParameters instanceof ParametersWithID))
    {
      localObject = (ParametersWithID)paramCipherParameters;
      paramCipherParameters = (SM2KeyExchangePublicParameters)((ParametersWithID)localObject).getParameters();
      localObject = ((ParametersWithID)localObject).getID();
    }
    else
    {
      paramCipherParameters = (SM2KeyExchangePublicParameters)paramCipherParameters;
      localObject = new byte[0];
    }
    byte[] arrayOfByte = getZ(this.digest, this.userID, this.staticPubPoint);
    Object localObject = getZ(this.digest, (byte[])localObject, paramCipherParameters.getStaticPublicKey().getQ());
    paramCipherParameters = calculateU(paramCipherParameters);
    if (this.initiator) {
      return kdf(paramCipherParameters, arrayOfByte, (byte[])localObject, paramInt);
    }
    return kdf(paramCipherParameters, (byte[])localObject, arrayOfByte, paramInt);
  }
  
  public byte[][] calculateKeyWithConfirmation(int paramInt, byte[] paramArrayOfByte, CipherParameters paramCipherParameters)
  {
    if ((paramCipherParameters instanceof ParametersWithID))
    {
      localObject = (ParametersWithID)paramCipherParameters;
      paramCipherParameters = (SM2KeyExchangePublicParameters)((ParametersWithID)localObject).getParameters();
      localObject = ((ParametersWithID)localObject).getID();
    }
    else
    {
      paramCipherParameters = (SM2KeyExchangePublicParameters)paramCipherParameters;
      localObject = new byte[0];
    }
    if ((this.initiator) && (paramArrayOfByte == null)) {
      throw new IllegalArgumentException("if initiating, confirmationTag must be set");
    }
    byte[] arrayOfByte1 = getZ(this.digest, this.userID, this.staticPubPoint);
    byte[] arrayOfByte2 = getZ(this.digest, (byte[])localObject, paramCipherParameters.getStaticPublicKey().getQ());
    Object localObject = calculateU(paramCipherParameters);
    if (this.initiator)
    {
      byte[] arrayOfByte3 = kdf((ECPoint)localObject, arrayOfByte1, arrayOfByte2, paramInt);
      paramCipherParameters = calculateInnerHash(this.digest, (ECPoint)localObject, arrayOfByte1, arrayOfByte2, this.ephemeralPubPoint, paramCipherParameters.getEphemeralPublicKey().getQ());
      if (Arrays.constantTimeAreEqual(S1(this.digest, (ECPoint)localObject, paramCipherParameters), paramArrayOfByte)) {
        return new byte[][] { arrayOfByte3, S2(this.digest, (ECPoint)localObject, paramCipherParameters) };
      }
      throw new IllegalStateException("confirmation tag mismatch");
    }
    paramArrayOfByte = kdf((ECPoint)localObject, arrayOfByte2, arrayOfByte1, paramInt);
    paramCipherParameters = calculateInnerHash(this.digest, (ECPoint)localObject, arrayOfByte2, arrayOfByte1, paramCipherParameters.getEphemeralPublicKey().getQ(), this.ephemeralPubPoint);
    return new byte[][] { paramArrayOfByte, S1(this.digest, (ECPoint)localObject, paramCipherParameters), S2(this.digest, (ECPoint)localObject, paramCipherParameters) };
  }
  
  public int getFieldSize()
  {
    return (this.staticKey.getParameters().getCurve().getFieldSize() + 7) / 8;
  }
  
  public void init(CipherParameters paramCipherParameters)
  {
    if ((paramCipherParameters instanceof ParametersWithID))
    {
      ParametersWithID localParametersWithID = (ParametersWithID)paramCipherParameters;
      paramCipherParameters = (SM2KeyExchangePrivateParameters)localParametersWithID.getParameters();
      this.userID = localParametersWithID.getID();
    }
    else
    {
      paramCipherParameters = (SM2KeyExchangePrivateParameters)paramCipherParameters;
      this.userID = new byte[0];
    }
    this.initiator = paramCipherParameters.isInitiator();
    this.staticKey = paramCipherParameters.getStaticPrivateKey();
    this.ephemeralKey = paramCipherParameters.getEphemeralPrivateKey();
    this.ecParams = this.staticKey.getParameters();
    this.staticPubPoint = paramCipherParameters.getStaticPublicPoint();
    this.ephemeralPubPoint = paramCipherParameters.getEphemeralPublicPoint();
    this.curveLength = ((this.ecParams.getCurve().getFieldSize() + 7) / 8);
    this.w = (this.ecParams.getCurve().getFieldSize() / 2 - 1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\agreement\SM2KeyExchange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */