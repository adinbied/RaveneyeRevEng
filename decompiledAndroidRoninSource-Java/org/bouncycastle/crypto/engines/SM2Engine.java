package org.bouncycastle.crypto.engines;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

public class SM2Engine
{
  private int curveLength;
  private final Digest digest;
  private ECKeyParameters ecKey;
  private ECDomainParameters ecParams;
  private boolean forEncryption;
  private SecureRandom random;
  
  public SM2Engine()
  {
    this(new SM3Digest());
  }
  
  public SM2Engine(Digest paramDigest)
  {
    this.digest = paramDigest;
  }
  
  private void addFieldElement(Digest paramDigest, ECFieldElement paramECFieldElement)
  {
    paramECFieldElement = BigIntegers.asUnsignedByteArray(this.curveLength, paramECFieldElement.toBigInteger());
    paramDigest.update(paramECFieldElement, 0, paramECFieldElement.length);
  }
  
  private void clearBlock(byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i != paramArrayOfByte.length)
    {
      paramArrayOfByte[i] = 0;
      i += 1;
    }
  }
  
  private byte[] decrypt(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidCipherTextException
  {
    int j = this.curveLength * 2 + 1;
    byte[] arrayOfByte1 = new byte[j];
    int i = 0;
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte1, 0, j);
    ECPoint localECPoint = this.ecParams.getCurve().decodePoint(arrayOfByte1);
    if (!localECPoint.multiply(this.ecParams.getH()).isInfinity())
    {
      localECPoint = localECPoint.multiply(((ECPrivateKeyParameters)this.ecKey).getD()).normalize();
      int k = paramInt2 - j - this.digest.getDigestSize();
      byte[] arrayOfByte2 = new byte[k];
      System.arraycopy(paramArrayOfByte, paramInt1 + j, arrayOfByte2, 0, k);
      kdf(this.digest, localECPoint, arrayOfByte2);
      int m = this.digest.getDigestSize();
      byte[] arrayOfByte3 = new byte[m];
      addFieldElement(this.digest, localECPoint.getAffineXCoord());
      this.digest.update(arrayOfByte2, 0, k);
      addFieldElement(this.digest, localECPoint.getAffineYCoord());
      this.digest.doFinal(arrayOfByte3, 0);
      paramInt2 = 0;
      paramInt1 = i;
      while (paramInt1 != m)
      {
        paramInt2 |= arrayOfByte3[paramInt1] ^ paramArrayOfByte[(j + k + paramInt1)];
        paramInt1 += 1;
      }
      clearBlock(arrayOfByte1);
      clearBlock(arrayOfByte3);
      if (paramInt2 == 0) {
        return arrayOfByte2;
      }
      clearBlock(arrayOfByte2);
      throw new InvalidCipherTextException("invalid cipher text");
    }
    throw new InvalidCipherTextException("[h]C1 at infinity");
  }
  
  private byte[] encrypt(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidCipherTextException
  {
    byte[] arrayOfByte1 = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte1, 0, paramInt2);
    Object localObject;
    byte[] arrayOfByte2;
    do
    {
      localObject = nextK();
      arrayOfByte2 = this.ecParams.getG().multiply((BigInteger)localObject).normalize().getEncoded(false);
      localObject = ((ECPublicKeyParameters)this.ecKey).getQ().multiply((BigInteger)localObject).normalize();
      kdf(this.digest, (ECPoint)localObject, arrayOfByte1);
    } while (notEncrypted(arrayOfByte1, paramArrayOfByte, paramInt1));
    byte[] arrayOfByte3 = new byte[this.digest.getDigestSize()];
    addFieldElement(this.digest, ((ECPoint)localObject).getAffineXCoord());
    this.digest.update(paramArrayOfByte, paramInt1, paramInt2);
    addFieldElement(this.digest, ((ECPoint)localObject).getAffineYCoord());
    this.digest.doFinal(arrayOfByte3, 0);
    return Arrays.concatenate(arrayOfByte2, arrayOfByte1, arrayOfByte3);
  }
  
  private void kdf(Digest paramDigest, ECPoint paramECPoint, byte[] paramArrayOfByte)
  {
    int n = paramDigest.getDigestSize();
    int i1 = paramDigest.getDigestSize();
    byte[] arrayOfByte = new byte[i1];
    int i = 1;
    int j = 1;
    int m;
    for (int k = 0; i <= (paramArrayOfByte.length + n - 1) / n; k = m)
    {
      addFieldElement(paramDigest, paramECPoint.getAffineXCoord());
      addFieldElement(paramDigest, paramECPoint.getAffineYCoord());
      paramDigest.update((byte)(j >> 24));
      paramDigest.update((byte)(j >> 16));
      paramDigest.update((byte)(j >> 8));
      paramDigest.update((byte)j);
      paramDigest.doFinal(arrayOfByte, 0);
      m = k + i1;
      if (m < paramArrayOfByte.length) {
        xor(paramArrayOfByte, arrayOfByte, k, i1);
      } else {
        xor(paramArrayOfByte, arrayOfByte, k, paramArrayOfByte.length - k);
      }
      j += 1;
      i += 1;
    }
  }
  
  private BigInteger nextK()
  {
    int i = this.ecParams.getN().bitLength();
    BigInteger localBigInteger;
    do
    {
      localBigInteger = new BigInteger(i, this.random);
    } while ((localBigInteger.equals(ECConstants.ZERO)) || (localBigInteger.compareTo(this.ecParams.getN()) >= 0));
    return localBigInteger;
  }
  
  private boolean notEncrypted(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    int i = 0;
    while (i != paramArrayOfByte1.length)
    {
      if (paramArrayOfByte1[i] != paramArrayOfByte2[paramInt]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private void xor(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i != paramInt2)
    {
      int j = paramInt1 + i;
      paramArrayOfByte1[j] = ((byte)(paramArrayOfByte1[j] ^ paramArrayOfByte2[i]));
      i += 1;
    }
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    this.forEncryption = paramBoolean;
    if (paramBoolean)
    {
      paramCipherParameters = (ParametersWithRandom)paramCipherParameters;
      ECKeyParameters localECKeyParameters = (ECKeyParameters)paramCipherParameters.getParameters();
      this.ecKey = localECKeyParameters;
      this.ecParams = localECKeyParameters.getParameters();
      if (!((ECPublicKeyParameters)this.ecKey).getQ().multiply(this.ecParams.getH()).isInfinity()) {
        this.random = paramCipherParameters.getRandom();
      } else {
        throw new IllegalArgumentException("invalid key: [h]Q at infinity");
      }
    }
    else
    {
      paramCipherParameters = (ECKeyParameters)paramCipherParameters;
      this.ecKey = paramCipherParameters;
      this.ecParams = paramCipherParameters.getParameters();
    }
    this.curveLength = ((this.ecParams.getCurve().getFieldSize() + 7) / 8);
  }
  
  public byte[] processBlock(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidCipherTextException
  {
    if (this.forEncryption) {
      return encrypt(paramArrayOfByte, paramInt1, paramInt2);
    }
    return decrypt(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\SM2Engine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */