package org.bouncycastle.crypto.kems;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.KeyEncapsulation;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.KDFParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

public class ECIESKeyEncapsulation
  implements KeyEncapsulation
{
  private static final BigInteger ONE = BigInteger.valueOf(1L);
  private boolean CofactorMode;
  private boolean OldCofactorMode;
  private boolean SingleHashMode;
  private DerivationFunction kdf;
  private ECKeyParameters key;
  private SecureRandom rnd;
  
  public ECIESKeyEncapsulation(DerivationFunction paramDerivationFunction, SecureRandom paramSecureRandom)
  {
    this.kdf = paramDerivationFunction;
    this.rnd = paramSecureRandom;
    this.CofactorMode = false;
    this.OldCofactorMode = false;
    this.SingleHashMode = false;
  }
  
  public ECIESKeyEncapsulation(DerivationFunction paramDerivationFunction, SecureRandom paramSecureRandom, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.kdf = paramDerivationFunction;
    this.rnd = paramSecureRandom;
    this.CofactorMode = paramBoolean1;
    this.OldCofactorMode = paramBoolean2;
    this.SingleHashMode = paramBoolean3;
  }
  
  protected ECMultiplier createBasePointMultiplier()
  {
    return new FixedPointCombMultiplier();
  }
  
  public CipherParameters decrypt(byte[] paramArrayOfByte, int paramInt)
  {
    return decrypt(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public CipherParameters decrypt(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws IllegalArgumentException
  {
    Object localObject1 = this.key;
    if ((localObject1 instanceof ECPrivateKeyParameters))
    {
      Object localObject2 = (ECPrivateKeyParameters)localObject1;
      Object localObject3 = ((ECPrivateKeyParameters)localObject2).getParameters();
      localObject1 = ((ECDomainParameters)localObject3).getCurve();
      BigInteger localBigInteger1 = ((ECDomainParameters)localObject3).getN();
      BigInteger localBigInteger2 = ((ECDomainParameters)localObject3).getH();
      localObject3 = new byte[paramInt2];
      System.arraycopy(paramArrayOfByte, paramInt1, localObject3, 0, paramInt2);
      localObject1 = ((ECCurve)localObject1).decodePoint((byte[])localObject3);
      if (!this.CofactorMode)
      {
        paramArrayOfByte = (byte[])localObject1;
        if (!this.OldCofactorMode) {}
      }
      else
      {
        paramArrayOfByte = ((ECPoint)localObject1).multiply(localBigInteger2);
      }
      localObject2 = ((ECPrivateKeyParameters)localObject2).getD();
      localObject1 = localObject2;
      if (this.CofactorMode) {
        localObject1 = ((BigInteger)localObject2).multiply(localBigInteger2.modInverse(localBigInteger1)).mod(localBigInteger1);
      }
      return deriveKey(paramInt3, (byte[])localObject3, paramArrayOfByte.multiply((BigInteger)localObject1).normalize().getAffineXCoord().getEncoded());
    }
    throw new IllegalArgumentException("Private key required for encryption");
  }
  
  protected KeyParameter deriveKey(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = paramArrayOfByte2;
    if (!this.SingleHashMode)
    {
      arrayOfByte = Arrays.concatenate(paramArrayOfByte1, paramArrayOfByte2);
      Arrays.fill(paramArrayOfByte2, (byte)0);
    }
    try
    {
      this.kdf.init(new KDFParameters(arrayOfByte, null));
      paramArrayOfByte1 = new byte[paramInt];
      this.kdf.generateBytes(paramArrayOfByte1, 0, paramInt);
      paramArrayOfByte1 = new KeyParameter(paramArrayOfByte1);
      return paramArrayOfByte1;
    }
    finally
    {
      Arrays.fill(arrayOfByte, (byte)0);
    }
  }
  
  public CipherParameters encrypt(byte[] paramArrayOfByte, int paramInt)
  {
    return encrypt(paramArrayOfByte, 0, paramInt);
  }
  
  public CipherParameters encrypt(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IllegalArgumentException
  {
    Object localObject1 = this.key;
    if ((localObject1 instanceof ECPublicKeyParameters))
    {
      ECPublicKeyParameters localECPublicKeyParameters = (ECPublicKeyParameters)localObject1;
      ECDomainParameters localECDomainParameters = localECPublicKeyParameters.getParameters();
      ECCurve localECCurve = localECDomainParameters.getCurve();
      localObject1 = localECDomainParameters.getN();
      Object localObject2 = localECDomainParameters.getH();
      BigInteger localBigInteger = BigIntegers.createRandomInRange(ONE, (BigInteger)localObject1, this.rnd);
      if (this.CofactorMode) {
        localObject1 = localBigInteger.multiply((BigInteger)localObject2).mod((BigInteger)localObject1);
      } else {
        localObject1 = localBigInteger;
      }
      ECMultiplier localECMultiplier = createBasePointMultiplier();
      localObject2 = new ECPoint[2];
      localObject2[0] = localECMultiplier.multiply(localECDomainParameters.getG(), localBigInteger);
      localObject2[1] = localECPublicKeyParameters.getQ().multiply((BigInteger)localObject1);
      localECCurve.normalizeAll((ECPoint[])localObject2);
      localObject1 = localObject2[0];
      localBigInteger = localObject2[1];
      localObject1 = ((ECPoint)localObject1).getEncoded(false);
      System.arraycopy(localObject1, 0, paramArrayOfByte, paramInt1, localObject1.length);
      return deriveKey(paramInt2, (byte[])localObject1, localBigInteger.getAffineXCoord().getEncoded());
    }
    throw new IllegalArgumentException("Public key required for encryption");
  }
  
  public void init(CipherParameters paramCipherParameters)
    throws IllegalArgumentException
  {
    if ((paramCipherParameters instanceof ECKeyParameters))
    {
      this.key = ((ECKeyParameters)paramCipherParameters);
      return;
    }
    throw new IllegalArgumentException("EC key required");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\kems\ECIESKeyEncapsulation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */